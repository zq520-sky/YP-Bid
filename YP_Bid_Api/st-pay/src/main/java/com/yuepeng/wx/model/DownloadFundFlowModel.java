package com.yuepeng.wx.model;

import com.yuepeng.model.BaseModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * @ClassName: DownloadFundFlowModel
 * @Description: 下载资金账单model
 * @Author: wuzhiqiang
 * @Date: 2020-03-04 14:07

 **/
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class DownloadFundFlowModel extends BaseModel {
    private String appid;
    private String mch_id;
    private String nonce_str;
    private String sign;
    private String sign_type;
    private String bill_date;
    private String account_type;
    private String tar_type;
}