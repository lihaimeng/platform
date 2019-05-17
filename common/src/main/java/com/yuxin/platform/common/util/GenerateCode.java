package com.yuxin.platform.common.util;

import java.util.Calendar;

public class GenerateCode {
    public static String strFormat(String bj, String hylb, String gxdwbm, String number) {

        Calendar calendar = Calendar.getInstance();
        int now_y = calendar.get(Calendar.YEAR);//得到年份
        int now_m = calendar.get(Calendar.MONTH) + 1;//得到月份
        int now_d = calendar.get(Calendar.DATE);//得到月份中今天的号数
        String year = String.valueOf(now_y).substring(2, 4);
        String month = String.valueOf(now_m);
        if (month.length() == 1) {
            month = "0" + month;
        }
        String day = String.valueOf(now_d);
        if (day.length() == 1) {
            day = "0" + day;
        }
        String fillTime = year + month + day;
        return bj + gxdwbm + hylb.substring(4) + fillTime + number;
    }

}
