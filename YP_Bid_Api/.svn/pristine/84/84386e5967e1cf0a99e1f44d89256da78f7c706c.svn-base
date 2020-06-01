package com.yuepeng.utils;

import com.yuepeng.annotations.CheckField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.util.*;

/**
 * 〈功能概述〉<br>
 *
 * @className: CheckSignUtils
 * @package: com.yuepeng.utils
 * @author: wzq
 * @date: 2020/5/26 12:04
 */
public class CheckSignUtils {
    private static Logger log = LoggerFactory.getLogger(CheckSignUtils.class);

    private static final String hexDigits[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
    private static String CHARSET_NAME = "UTF-8";
    private static final String SIGN = "sign";

    public static boolean checkSign(Object bean, String salt){
        String signData = "";
        Long timestamp;
        Map<String, Object> requiredFields = new HashMap<>();
        List<Field> fields = new ArrayList(Arrays.asList(bean.getClass().getDeclaredFields()));
        fields.addAll(Arrays.asList(bean.getClass().getSuperclass().getDeclaredFields()));
        //将必要的字段获取值
        for (Field field : fields) {
            try {
                boolean isAccessible = field.isAccessible();
                field.setAccessible(true);
                if (field.isAnnotationPresent(CheckField.class)) {
                    requiredFields.put(field.getName(), field.get(bean));
                }
                if(SIGN.equals(field.getName())){
                    signData = (String) field.get(bean);
                }
                field.setAccessible(isAccessible);
            } catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {
                log.error(e.getMessage(), e);
                return false;
            }
        }

        //将需要进行签名的字段进行自然顺序排序、组装
        StringBuffer paramValuesStr = new StringBuffer();
        requiredFields.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEachOrdered(x -> paramValuesStr.append(x.getKey()).append("=").append ( x.getValue() != null ? x.getValue().toString() : ""  ).append("&") );
        String sign = MD5Encode(paramValuesStr.toString() + salt, CHARSET_NAME);
        return sign.equals(signData);
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
}
