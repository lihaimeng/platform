package com.yuxin.platform.common.util;

public class CodeUtil {
    public static String getCode(String mark, String code, int countNum) {
        String codeNum = mark + code;
        countNum = countNum + 1;
        if (String.valueOf(countNum).length() == 1) {
            codeNum = codeNum + "00000" + countNum;
        } else if (String.valueOf(countNum).length() == 2) {
            codeNum = codeNum + "0000" + countNum;
        } else if (String.valueOf(countNum).length() == 3) {
            codeNum = codeNum + "000" + countNum;
        } else if (String.valueOf(countNum).length() == 4) {
            codeNum = codeNum + "00" + countNum;
        } else if (String.valueOf(countNum).length() == 5) {
            codeNum = codeNum + "0" + countNum;
        } else if (String.valueOf(countNum).length() == 6) {
            codeNum = codeNum + countNum;
        }
        return codeNum;
    }
}