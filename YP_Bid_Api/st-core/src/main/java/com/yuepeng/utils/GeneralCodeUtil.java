package com.yuepeng.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @ClassName: GeneralCodeUtil
 * @Description:
 * @Author: wuzhiqiang
 * @Date: 2020-04-09 11:57
 * @Copyright
 **/
public class GeneralCodeUtil {

    private static final int[] r = new int[]{7, 9, 6, 2, 8, 1, 3, 0, 5, 4};
    /**
     * 用户id和随机数总长度
     */
    private static final int maxLength = 14;

    private static String toCode(Integer custId) {
        String idStr = custId.toString();
        StringBuilder idsbs = new StringBuilder();
        for (int i = idStr.length() - 1; i >= 0; i--) {
            idsbs.append(r[idStr.charAt(i) - '0']);
        }
        return idsbs.append(getRandom(maxLength - idStr.length())).toString();
    }

    /**
     ** 生成固定长度随机码
     ** @param n    长度
     */
    private static long getRandom(long n) {
        long min = 1, max = 9;
        for (int i = 1; i < n; i++) {
            min *= 10;
            max *= 10;
        }
        long rangeLong = (((long) (new Random().nextDouble() * (max - min)))) + min;
        return rangeLong;
    }

    /**
     * 生成时间戳
     *
     * @author: wuzhiqiang
     * @date: 2020/4/9
     * @return: java.lang.String
     */
    private static String getDateTime() {
        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return sdf.format(new Date());
    }

    public static synchronized String getCode(Integer custId) {
        return getDateTime()+toCode(custId);
    }

    public static void main(String[] args) {
        String code = GeneralCodeUtil.getCode(1);
        System.out.println(code);
        System.out.println(code.length());
    }
}