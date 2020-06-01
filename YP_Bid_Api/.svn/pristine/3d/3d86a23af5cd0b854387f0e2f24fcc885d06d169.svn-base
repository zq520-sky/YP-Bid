package com.yuepeng.utils;

import com.alibaba.fastjson.JSON;

import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class SignUtil {

    private static final String hexDigits[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    private final static String randomBaseStr = "abcdefghijklmnopqrstuvwxyz0123456789";
    private static String CHARSET_NAME = "UTF-8";
    private static final String sign = "sign";

    public static String signMap(Map<String, String[]> map, String salt) {
        StringBuilder param = new StringBuilder();
        Iterator<Map.Entry<String, String[]>> entries = map.entrySet().iterator();
        Map<String, String[]> params = new TreeMap<>();
        while (entries.hasNext()) {
            Map.Entry<String, String[]> entry = entries.next();
            String key = entry.getKey();
            String[] values = entry.getValue();
            if (values == null) {
                entries.remove();
            }
            if (sign.equals(key)) {
                continue;
            }
            params.put(key, values);
        }

        Iterator<Map.Entry<String, String[]>> entries2 = params.entrySet().iterator();
        while (entries2.hasNext()) {
            Map.Entry<String, String[]> entry = entries2.next();
            String key = entry.getKey();
            String[] values = entry.getValue();
            if (values.length == 1) {
                param.append("&").append(key).append("=").append(values[0]);
            } else {
                param.append("&").append(key).append("=").append(JSON.toJSONString(values));
            }

        }

        return MD5Encode(param.toString().replaceFirst("&", "") + salt, CHARSET_NAME);
    }


    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0){
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static String MD5Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname)) {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
            }else {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
            }
        } catch (Exception exception) {
        }
        return resultString;
    }
}