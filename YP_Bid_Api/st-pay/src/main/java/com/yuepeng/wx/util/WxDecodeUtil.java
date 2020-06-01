package com.yuepeng.wx.util;

import cn.hutool.core.codec.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;

/**
 * 微信解密工具类(AES-256-ECB解密 PKCS7Padding)
 * 解密方式官方文档：https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_16&index=10#menu1
 * 解密步骤如下：
 * （1）对加密串A做base64解码，得到加密串B
 * （2）对商户key做md5，得到32位小写key* ( key设置路径：微信商户平台(pay.weixin.qq.com)-->账户设置-->API安全-->密钥设置 )
 * （3）用key*对加密串B做AES-256-ECB解密（PKCS7Padding）
 */
public class WxDecodeUtil {

    private String algorithm = "AES";

    private String algorithmModePadding = "AES/ECB/PKCS7Padding";

    SecretKeySpec secretKey;
	
	private boolean initialized = false;

    /**
     * AES解密
     * @param base64Data
     * @return
     * @throws Exception
     */
    public String decryptData(String base64Data) throws Exception {
		initialize();
 
        // 获取解码器实例，"BC"指定Java使用BouncyCastle库里的加/解密算法。
        Cipher cipher = Cipher.getInstance(algorithmModePadding, "BC");
        // 使用秘钥并指定为解密模式初始化解码器
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        // cipher.doFinal(byte[] b)在单部分操作中加密或解密数据，或完成多部分操作。 根据此秘钥的初始化方式，对数据进行加密或解密。
        return new String(cipher.doFinal(Base64.decode(base64Data)));
    }
    
    /**
     * 安全提供者列表中注册解密算法提供者，这个加载过程还挺慢的，有时候要好几秒，只需要加载一次就能一直使用。
     */
    private void initialize() {
        if (initialized) {
            return;
        }

        Security.addProvider(new BouncyCastleProvider());
        initialized = true;
    }


    /**
     * 构造方法(容器初始化时从配置文件中获取key，在全局中维护一个唯一的SecretKeySpec)
     * @param key
     */
    public WxDecodeUtil(String key) {
        // 转化成JAVA的密钥格式
        secretKey = new SecretKeySpec(Public.MD5(key).toLowerCase().getBytes(), algorithm);
    }

    public static void main(String[] args) throws Exception {
        String A = "UXEYxkKUe4dva8tExLqWRLbOTRBuI8CpBPLX8ewcZY6goTT0VIz/Fc9wyxaD0AS4SRYBS7vyq7qyRvjkuF6spVOL3bIpyaEs91Noz70tA8USOO8kuyfuLFcEaWGTxw7n4O/0OmXnTIX8n+RoRMN3eFAb7BzRBMxCvtU0Fmqwv8J16zRx9oovFR2x1bTzCHtQHyT21YvOdSUPZghMuiJI5+rsO0qtBINsRVVtRd7DKPWCuZTvBDFPVVlHThRgHfcJ+N67KzmTy0SLEz0GRKYv0EawYrFxuI0CiJMVwhDuKkbeTOwY6ZTVteg0BJ1XMMPai/vgq99D9GASRE5fkuhZ12DDY2HBpOEQGL5ihmqd5V2TzoCGS3iu/NIB55X3Ene0sGobmf/IYY8UEGnGAd4WqUZ7tOCUJ+In0TZgAESgJ20fsM/dQe6ppMjt1MnWQDHRZqSwdu/2EdFOMSccdRSLO+46VQ/SdqRKRuzneFP7buNf0hY9LannF1U9K1iqdJbcrjVYfqutLuElDvKQyhw1loPSRTuxmVnQMMKoA/HLMdEO/Jcl46CbWO+zxq7BLY+Zw7Y+HgoZ5rtn8WbKmx03uJMW4kpSmsvqqVlPq1Fy28oKOWdaDFy/uu8Ydy6R/H3R0LyXmtJJrdfM1+fGz7IwNSyWZOIoP4dRBBslrA17LqI/OVSfXhirsl6i8tJo8saFxGd2KKJsqOZMAZyklVvuMVirCAq8AgFWLfu4+Oe4oTW16iT77KjK8prhYJv/1/Sxelf8bDKBefELAN4/dADodu8k9Jb45ldGwPTVurrac/1XCI+CxSXlAGx9kGyGyh7cqBw59B7XTAmUvnHz/wcBV8K5pd+o5V/YGMrCpXViZmG9quKiRJ3DVYpO0QRwA1aP8o1WjsHSvRVdKj3rk8kXMOiKbsheoDbVvEwAEuEt2DVnLPeCswy2xnIW/3iyXtMFZZQJcm7HDTKNjCAOJu27JeknVEWS56IIyLmRR/37kmSRpnhU9Mvqf9NcVjPTOGPTWhkF+rmjlVsjKIHgcbqZGcp9WII/2QnxfVHZ4ncIOoU1p2kU8pEtm7MyTL+MPYC/lAz9ZM9X+w8tvIg7Vl9w7g==";
        WxDecodeUtil wxDecodeUtil = new WxDecodeUtil("g69mpx9xjz2c5607m2054065e47b7f40");
        System.out.println(wxDecodeUtil.decryptData(A));
    }

}