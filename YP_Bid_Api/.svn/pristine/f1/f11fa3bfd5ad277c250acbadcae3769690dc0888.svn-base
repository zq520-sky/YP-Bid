package com.yuepeng.utils;

import cn.hutool.core.lang.UUID;

import java.security.MessageDigest;

/**
 * @ClassName: PasswordEncryptor
 * @Description: 密码加密
 * @Author: wuzhiqiang
 * @Date: 2020-03-03 11:24
 * @Copyright
 **/
public class PasswordEncryptor {

    public static final String MD5 = "md5";
    public static final String SHA_256 = "sha-256";

//    private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
//            "6", "!", "#", "@", "a", "b", "c", "d", "*", "f", "g", "F" };
    private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "!", "#", "@", "a", "b", "c", "d", "*", "f", "g", "F" };

    private Object salt;
    private String algorithm;

    public PasswordEncryptor(Object salt, String algorithm) {
        this.salt = salt;
        this.algorithm = algorithm;
    }

    public String encode(String rawPass) {
        String result = null;
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            // 加密后的字符串
            result = byteArrayToHexString(md.digest(mergePasswordAndSalt(
                    rawPass).getBytes("utf-8")));
        } catch (Exception ex) {
        }
        return result;
    }

    public boolean isPasswordValid(String encPass, String rawPass) {
        String pass1 = "" + encPass;
        String pass2 = encode(rawPass);

        return pass1.equals(pass2);
    }

    private String mergePasswordAndSalt(String password) {
        if (password == null) {
            password = "";
        }

        if ((salt == null) || "".equals(salt)) {
            return password;
        } else {
            return password + "{" + salt.toString() + "}";
        }
    }

    /**
     * 转换字节数组为16进制字串
     *
     * @param b
     *            字节数组
     * @return 16进制字串
     */
    private static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / hexDigits.length;
        int d2 = n % hexDigits.length;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static void main(String[] args) {
        String salt = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println(salt);
        PasswordEncryptor encoderMd5 = new PasswordEncryptor("b0686cfdd29144ca9114fbe5feb3f7b1", "sha-256");
        //9#!f4*4c9@3*90923508#1#8559!95#4295#83#1!a835@5*6b9#017b0c8g894b
        //9#!f4*4c9@3*90923508#1#8559!95#4295#83#1!a835@5*6b9#017b0c8g894b
        String encodedPassword = encoderMd5.encode("123456");
        System.out.println("加密后密码：" + encodedPassword + "\n密码长度：" + encodedPassword.length());
        System.out.println("salt:" + salt);
    }
}