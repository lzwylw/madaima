package com.madaima.util;

import java.util.regex.Pattern;

public class RegexUtils {
    /**
     * 6位的纯数字
     */
    public static final String REGEX_FIVE_NUMBER = "\\d{5}";
    /**
     * 6位的纯数字
     */
    public static final String REGEX_NUMBER = "\\d{6}";


    /**
     * 校验是否是5位数纯数字
     * @param number 数字
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isFiveNumber(String number) {
        return Pattern.matches(REGEX_FIVE_NUMBER, number);
    }

    /**
     * 校验是否是6位数纯数字
     * @param number number
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isNumber(String number) {
        return Pattern.matches(REGEX_NUMBER, number);
    }
}
