package com.gndc.common.utils;

import java.text.ParseException;
import java.util.List;

public class TradeDayUtils {
    /**
     * @param n     -1:date前最近交易日，1：date后最近交易日，如果date是交易日则返回date
     * @param date
     * @param count 计数，count>10返回"T+1"字符串
     * @return
     * @throws ParseException
     */
    public static String getOpenday(int n, String date, Integer count, List<String> days) throws ParseException {
        //用于限制递归调用的次数，即查找次数
        if (count > 10) {
            return "T+1";
        }
        String daystr = "";
        for (int i = 0; i < days.size(); i++) {
            if (days.get(i).equals(date)) {
                daystr = days.get(i);
            }
        }
        //如果是""则代表date不是交易日，根据n往前或者往后推一天，继续查找
        if ("".equals(daystr)) {
            daystr = DateUtil.dateAddDays(date, n);
            count++;
            daystr = getOpenday(n, daystr, count, days);

        }
        return daystr;
    }

    public static String getOpenday(String date, int n, List<String> days) {
        int index = days.indexOf(date);
        if (index > 0) {
            return days.get(index + n);
        }
        return date;
    }
}
