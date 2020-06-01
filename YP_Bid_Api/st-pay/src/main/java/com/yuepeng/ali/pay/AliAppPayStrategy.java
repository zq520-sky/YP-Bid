package com.yuepeng.ali.pay;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.CertAlipayRequest;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.domain.AlipayTradeRefundModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.yuepeng.ali.config.AliPayAppConfig;
import com.yuepeng.ali.exception.AliPayException;
import com.yuepeng.ali.model.AliRefundModel;
import com.yuepeng.ali.model.AliUnifiedOrderModel;
import com.yuepeng.ali.vo.AliNotifyResponse;
import com.yuepeng.dispose.common.R;
import com.yuepeng.dispose.common.RCode;
import com.yuepeng.dispose.config.RUtils;
import com.yuepeng.model.BaseModel;
import com.yuepeng.strategy.PayStrategy;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName: AliPayStrategy
 * @Description: 阿里支付
 * @Author: wuzhiqiang
 * @Date: 2020-03-05 10:53

 **/
@Component
@Slf4j
public class AliAppPayStrategy implements PayStrategy {

    @Autowired
    private AliPayAppConfig aliPayAppConfig;

    @Override
    public R pay(BaseModel baseModel) throws AlipayApiException {
        AliUnifiedOrderModel aliUnifiedOrderModel = (AliUnifiedOrderModel) baseModel;
        if(aliPayAppConfig.isWithCert()){
            return payWithCert(aliUnifiedOrderModel);
        }
        return payWithNoCert(aliUnifiedOrderModel);
    }

    @Override
    public R refund(BaseModel baseModel) throws AlipayApiException {
        AliRefundModel aliRefundModel = (AliRefundModel) baseModel;
        AlipayClient alipayClient = newAlipayClient();
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        AlipayTradeRefundModel model = newRefundModel(aliRefundModel);
        request.setBizModel(model);
        AlipayTradeRefundResponse response = alipayClient.execute(request);
        boolean success = response.isSuccess();
        log.info("alipay refund response: {}", JSON.toJSONString(response) );
        if(success){
            return RUtils.ok();
        }
        log.error("refund error, outTradeNo: {}, tradeNo: {}, refundAmount:{}, errorMsg: {}", aliRefundModel.getOut_trade_no(), aliRefundModel.getTrade_no(), aliRefundModel.getRefund_amount(), response.getMsg()+"/"+response.getSubMsg());
        return RUtils.fail(RCode.ALI_PAY_ERROR.getCode(), response.getMsg());
    }

    @Override
    public R payNotify(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取支付宝POST过来反馈信息
        Map<String,String> params = new HashMap<String,String>(16);
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用。
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        log.info("aliAppNotify response: {}", JSON.toJSONString(params));
        //切记alipaypublickey是支付宝的公钥，请去open.alipay.com对应应用下查看。
        boolean flag;
        if(aliPayAppConfig.isWithCert()){
            flag = AlipaySignature.rsaCertCheckV1(params, aliPayAppConfig.getAlipayPublicCertPath(), aliPayAppConfig.getCharset(),aliPayAppConfig.getSignType());
        }else{
            flag = AlipaySignature.rsaCheckV1(params, aliPayAppConfig.getAliPublicKey(), aliPayAppConfig.getCharset(),aliPayAppConfig.getSignType());
        }
        if (!flag) {
            throw new AliPayException("回调签名错误！");
        }
        AliNotifyResponse aliNotifyResponse = JSON.parseObject(JSONObject.toJSONString(params), AliNotifyResponse.class);
        return RUtils.ok(aliNotifyResponse);
    }

    public static void main(String[] args) {
        String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwY7xZTe9UM6w3hCjkuUFoTiRBPZrdDJNVEORuq3ApcmrjSrA75XIHPwi+XrUZ7/Eooah7K+t3JghmJ4zuusa3mMc7TLBN1VXCZSldJCv98daBqXOfT62jylYWBPxsujQ6lehhjcWZ9K+ONG2/LhpEAfBq+1Qg+4u2qd+4qrV0wLINVexek0RcQ4/bCN6BBXcraNs6bX+97z7OBgTa17GmMJcG3SafA6SRANRTLeRp6uhq4HfjHk81qp3wpQK0lt//PEMv4Xn8jq9pz+qr5r/XUXh5+aygSnfKW3akNa6m0L+3n1DR70dFeS6KqndUVR1IutXh64ZoLi9UXnSMWuNNQIDAQAB";
        String charset = "utf-8";
        String signType = "RSA2";
        String data = "{\"gmt_create\":\"2020-04-18 10:35:31\",\"charset\":\"utf-8\",\"seller_email\":\"3004574820@qq.com\",\"subject\":\"小笨智能-加油包\",\"sign\":\"cCiGmiyrfEQtntmvCs2iQ6YaqlUHXGLs1Nw57yVKT4ItRaEmct9snBs4mAw4ZxTZ+gWvkZwGmruPvvjdshQqlL4bV0vuZeUC5wfXYMLIyIzOWJiLQnFCKPfJ4bYvM1UJm1KgP9tkJ4TlZ4vMVa+kKDSGR6QL4WhQn0+q9j+yE2ELCbT0GzgHKMoVGYsfpxit6xRdoVmtKK6jryc70FJVovX8s9ur8nwB7tUOG2z8ooAeEzeuu8VUzbIsA1p0KSvQTu/uj7Fvdue5dKeZnUGyX9yXlEQtklNKqYdG6VYwo91FkwM3WLepu7ADoXuIyTJHbOjjW8hzmxephTd/VEXSvw==\",\"buyer_id\":\"2088702160308182\",\"invoice_amount\":\"0.01\",\"notify_id\":\"2020041800222103532008181412616830\",\"fund_bill_list\":\"[{\\\"amount\\\":\\\"0.01\\\",\\\"fundChannel\\\":\\\"PCREDIT\\\"}]\",\"notify_type\":\"trade_status_sync\",\"trade_status\":\"TRADE_SUCCESS\",\"receipt_amount\":\"0.01\",\"app_id\":\"2021001155680796\",\"buyer_pay_amount\":\"0.01\",\"sign_type\":\"RSA2\",\"seller_id\":\"2088431556741381\",\"gmt_payment\":\"2020-04-18 10:35:31\",\"notify_time\":\"2020-04-18 10:38:27\",\"version\":\"1.0\",\"out_trade_no\":\"2020041810274674467891694653305\",\"total_amount\":\"0.01\",\"trade_no\":\"2020041822001408181440857421\",\"auth_app_id\":\"2021001155680796\",\"buyer_logon_id\":\"186****5721\",\"point_amount\":\"0.00\"}";
        Map dataMap = JSON.parseObject(data, Map.class);
        try {
            boolean checkV1 = AlipaySignature.rsaCheckV1(dataMap, publicKey, null, signType);
            System.out.println(checkV1);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }


    }

    @Override
    public R refundNotify(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return payNotify(request, response);
    }

    private AlipayTradeRefundModel newRefundModel(AliRefundModel aliRefundModel) throws AlipayApiException {
        AlipayTradeRefundModel model = new AlipayTradeRefundModel();
        if(StringUtils.isBlank(aliRefundModel.getOut_trade_no()) && StringUtils.isBlank(aliRefundModel.getTrade_no())){
            throw new AlipayApiException("out_trade_no and trade_no are null!");
        }
        model.setOutTradeNo(aliRefundModel.getOut_trade_no());
        model.setTradeNo(aliRefundModel.getTrade_no());
        model.setRefundAmount(aliRefundModel.getRefund_amount());
        if(StringUtils.isNotBlank(aliRefundModel.getRefund_currency())){
            model.setRefundCurrency(aliRefundModel.getRefund_currency());
        }
        if(StringUtils.isNotBlank(aliRefundModel.getRefund_reason())){
            model.setRefundReason(aliRefundModel.getRefund_reason());
        }
        if(StringUtils.isNotBlank(aliRefundModel.getOut_request_no())){
            model.setOutRequestNo(aliRefundModel.getOut_request_no());
        }
        if(StringUtils.isNotBlank(aliRefundModel.getOperator_id())){
            model.setOperatorId(aliRefundModel.getOperator_id());
        }
        if(StringUtils.isNotBlank(aliRefundModel.getStore_id())){
            model.setStoreId(aliRefundModel.getStore_id());
        }
        if(StringUtils.isNotBlank(aliRefundModel.getTerminal_id())){
            model.setTerminalId(aliRefundModel.getTerminal_id());
        }
        if(null != aliRefundModel.getGoods_detail()){
            model.setGoodsDetail(aliRefundModel.getGoods_detail());
        }
        if(null != aliRefundModel.getRefund_royalty_parameters()){
            model.setRefundRoyaltyParameters(aliRefundModel.getRefund_royalty_parameters());
        }
        if(StringUtils.isNotBlank(aliRefundModel.getOrg_pid())){
            model.setOrgPid(aliRefundModel.getOrg_pid());
        }
        return model;
    }

    private R payWithCert(AliUnifiedOrderModel aliUnifiedOrderModel) throws AlipayApiException {
        AlipayClient alipayClient = newAlipayClient();

        //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
        //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
        AlipayTradeAppPayModel model = newAlipayTradeAppPayModel(aliUnifiedOrderModel);
        model.setProductCode("QUICK_MSECURITY_PAY");
        request.setBizModel(model);
        request.setNotifyUrl(aliPayAppConfig.getNotifyUrl());
        //这里和普通的接口调用不同，使用的是sdkExecute
        AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
        log.info("aliApp pay with cert response: {}", JSON.toJSONString(response));
        //就是orderString 可以直接给客户端请求，无需再做处理。
        boolean success = response.isSuccess();
        if(success){
            return RUtils.ok(response.getBody());
        }
        log.error("payWithNoCert error, orderNo: {}, errorMsg: {}", aliUnifiedOrderModel.getOut_trade_no(), response.getMsg()+"/"+response.getSubMsg());
        return RUtils.fail(RCode.ALI_PAY_ERROR.getCode(), response.getMsg());
    }

    private AlipayTradeAppPayModel newAlipayTradeAppPayModel(AliUnifiedOrderModel aliUnifiedOrderModel) {
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
        model.setTotalAmount(aliUnifiedOrderModel.getTotal_amount());
        model.setSubject(aliUnifiedOrderModel.getSubject());
        model.setOutTradeNo(aliUnifiedOrderModel.getOut_trade_no());

        if(StringUtils.isNotBlank(aliUnifiedOrderModel.getBody())){
            model.setBody(aliUnifiedOrderModel.getBody());
        }
        if(StringUtils.isNotBlank(aliUnifiedOrderModel.getTimeout_express())){
            model.setTimeoutExpress(aliUnifiedOrderModel.getTimeout_express());
        }
        if(StringUtils.isNotBlank(aliUnifiedOrderModel.getProduct_code())){
            model.setProductCode(aliUnifiedOrderModel.getProduct_code());
        }
        if(StringUtils.isNotBlank(aliUnifiedOrderModel.getTime_expire())){
            model.setTimeExpire(aliUnifiedOrderModel.getTime_expire());
        }
        if(StringUtils.isNotBlank(aliUnifiedOrderModel.getGoods_type())){
            model.setGoodsType(aliUnifiedOrderModel.getGoods_type());
        }
        if(StringUtils.isNotBlank(aliUnifiedOrderModel.getPromo_params())){
            model.setPromoParams(aliUnifiedOrderModel.getPromo_params());
        }
        if(StringUtils.isNotBlank(aliUnifiedOrderModel.getPassback_params())){
            model.setPassbackParams(aliUnifiedOrderModel.getPassback_params());
        }
        if(null != aliUnifiedOrderModel.getExtendParams()){
            model.setExtendParams(aliUnifiedOrderModel.getExtendParams());
        }
        if(StringUtils.isNotBlank(aliUnifiedOrderModel.getMerchant_order_no())){
            model.setMerchantOrderNo(aliUnifiedOrderModel.getMerchant_order_no());
        }
        if(StringUtils.isNotBlank(aliUnifiedOrderModel.getEnable_pay_channels())){
            model.setEnablePayChannels(aliUnifiedOrderModel.getEnable_pay_channels());
        }
        if(StringUtils.isNotBlank(aliUnifiedOrderModel.getStore_id())){
            model.setStoreId(aliUnifiedOrderModel.getStore_id());
        }
        if(StringUtils.isNotBlank(aliUnifiedOrderModel.getSpecified_channel())){
            model.setSpecifiedChannel(aliUnifiedOrderModel.getSpecified_channel());
        }
        if(StringUtils.isNotBlank(aliUnifiedOrderModel.getDisable_pay_channels())){
            model.setDisablePayChannels(aliUnifiedOrderModel.getDisable_pay_channels());
        }
        if(null != aliUnifiedOrderModel.getGoodsDetails()){
            model.setGoodsDetail(aliUnifiedOrderModel.getGoodsDetails());
        }
        if (null != aliUnifiedOrderModel.getExtUserInfo()) {
            model.setExtUserInfo(aliUnifiedOrderModel.getExtUserInfo());
        }
        if(StringUtils.isNotBlank(aliUnifiedOrderModel.getBusiness_params())){
            model.setBusinessParams(aliUnifiedOrderModel.getBusiness_params());
        }
        if (null != aliUnifiedOrderModel.getSignParams()) {
            model.setAgreementSignParams(aliUnifiedOrderModel.getSignParams());
        }

        return model;
    }

    private R payWithNoCert(AliUnifiedOrderModel aliUnifiedOrderModel) throws AlipayApiException {
        //实例化客户端
        AlipayClient alipayClient = newAlipayClient();
        //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
        //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
        AlipayTradeAppPayModel model = newAlipayTradeAppPayModel(aliUnifiedOrderModel);
        model.setProductCode("QUICK_MSECURITY_PAY");
        request.setBizModel(model);
        request.setNotifyUrl(aliPayAppConfig.getNotifyUrl());
        //这里和普通的接口调用不同，使用的是sdkExecute
        AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
        log.info("aliApp pay with no cert response: {}", JSON.toJSONString(response));
        //就是orderString 可以直接给客户端请求，无需再做处理。
        boolean success = response.isSuccess();
        if(success){
            return RUtils.ok(response.getBody());
        }
        log.error("payWithNoCert error, orderNo: {}, errorMsg: {}", aliUnifiedOrderModel.getOut_trade_no(), response.getMsg()+"/"+response.getSubMsg());
        return RUtils.fail(RCode.ALI_PAY_ERROR.getCode(), response.getMsg());
    }

    private AlipayClient newAlipayClient() throws AlipayApiException {
        if(aliPayAppConfig.isWithCert()){
            //构造client
            CertAlipayRequest certAlipayRequest = new CertAlipayRequest();
            //设置网关地址
            certAlipayRequest.setServerUrl(aliPayAppConfig.getServerUrl());
            //设置应用Id
            certAlipayRequest.setAppId(aliPayAppConfig.getAppid());
            //设置应用私钥
            certAlipayRequest.setPrivateKey(aliPayAppConfig.getAppPrivateKey());
            //设置请求格式，固定值json
            certAlipayRequest.setFormat(aliPayAppConfig.getFormat());
            //设置字符集
            certAlipayRequest.setCharset(aliPayAppConfig.getCharset());
            //设置签名类型
            certAlipayRequest.setSignType(aliPayAppConfig.getSignType());
            //设置应用公钥证书路径
            certAlipayRequest.setCertPath(aliPayAppConfig.getCertPath());
            //设置支付宝公钥证书路径
            certAlipayRequest.setAlipayPublicCertPath(aliPayAppConfig.getAlipayPublicCertPath());
            //设置支付宝根证书路径
            certAlipayRequest.setRootCertPath(aliPayAppConfig.getRootCertPath());
            //构造client
            return new DefaultAlipayClient(certAlipayRequest);
        }
        return new DefaultAlipayClient(aliPayAppConfig.getServerUrl(), aliPayAppConfig.getAppid(), aliPayAppConfig.getAppPrivateKey(), aliPayAppConfig.getFormat(), aliPayAppConfig.getCharset(), aliPayAppConfig.getAliPublicKey(), aliPayAppConfig.getSignType());
    }

}