/**************************************************************************
 * Copyright (c) 2013-2023  浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.common.utils;


import com.gndc.common.enums.ResultCode;
import com.gndc.common.exception.HjException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Hashtable;

/**
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description 身份证校验util
 * @date 2018年1月24日 下午5:16:45
 */
public class IDCard {
    private static String[] ValCodeArr = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
    private static String[] WI = {"7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7", "9", "10", "5", "8", "4",
            "2"};
    private static Hashtable<String, String> AreaCodeTable = new Hashtable<String, String>();

    /**
     * 功能：设置地区编码
     *
     * @return Hashtable 对象
     */
    static {
        AreaCodeTable.clear();
        AreaCodeTable.put("11", "北京");
        AreaCodeTable.put("12", "天津");
        AreaCodeTable.put("13", "河北");
        AreaCodeTable.put("14", "山西");
        AreaCodeTable.put("15", "内蒙古");
        AreaCodeTable.put("21", "辽宁");
        AreaCodeTable.put("22", "吉林");
        AreaCodeTable.put("23", "黑龙江");
        AreaCodeTable.put("31", "上海");
        AreaCodeTable.put("32", "江苏");
        AreaCodeTable.put("33", "浙江");
        AreaCodeTable.put("34", "安徽");
        AreaCodeTable.put("35", "福建");
        AreaCodeTable.put("36", "江西");
        AreaCodeTable.put("37", "山东");
        AreaCodeTable.put("41", "河南");
        AreaCodeTable.put("42", "湖北");
        AreaCodeTable.put("43", "湖南");
        AreaCodeTable.put("44", "广东");
        AreaCodeTable.put("45", "广西");
        AreaCodeTable.put("46", "海南");
        AreaCodeTable.put("50", "重庆");
        AreaCodeTable.put("51", "四川");
        AreaCodeTable.put("52", "贵州");
        AreaCodeTable.put("53", "云南");
        AreaCodeTable.put("54", "西藏");
        AreaCodeTable.put("61", "陕西");
        AreaCodeTable.put("62", "甘肃");
        AreaCodeTable.put("63", "青海");
        AreaCodeTable.put("64", "宁夏");
        AreaCodeTable.put("65", "新疆");
        AreaCodeTable.put("71", "台湾");
        AreaCodeTable.put("81", "香港");
        AreaCodeTable.put("82", "澳门");
        AreaCodeTable.put("91", "国外");
    }

    /***********************************
     * 身份证验证开始
     ****************************************/
    /**
     * 身份证号码验证 1、号码的结构 公民身份号码是特征组合码，由十七位数字本体码和一位校验码组成。排列顺序从左至右依次为：六位数字地址码，
     * 八位数字出生日期码，三位数字顺序码和一位数字校验码。 2、地址码(前六位数）
     * 表示编码对象常住户口所在县(市、旗、区)的行政区划代码，按GB/T2260的规定执行。 3、出生日期码（第七位至十四位）
     * 表示编码对象出生的年、月、日，按GB/T7408的规定执行，年、月、日代码之间不用分隔符。 4、顺序码（第十五位至十七位）
     * 表示在同一地址码所标识的区域范围内，对同年、同月、同日出生的人编定的顺序号， 顺序码的奇数分配给男性，偶数分配给女性。 5、校验码（第十八位数）
     * （1）十七位数字本体码加权求和公式 S = Sum(Ai * Wi), i = 0, ... , 16 ，先对前17位数字的权求和
     * Ai:表示第i位置上的身份证号码数字值 Wi:表示第i位置上的加权因子 Wi: 7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2
     * （2）计算模 Y = mod(S, 11) （3）通过模得到对应的校验码 Y: 0 1 2 3 4 5 6 7 8 9 10 校验码: 1 0 X 9 8
     * 7 6 5 4 3 2
     */

    /**
     * 功能：身份证的有效验证
     *
     * @param idStr 身份证号
     * @return 有效：返回"" 无效：返回String信息
     * @throws @throws Exception
     */
    public static String validate(String idStr) throws HjException {
        String ai = "";
        // ================ 号码的长度 15位或18位 ================
        if (idStr.length() == 18) {
            ai = idStr.substring(0, 17);
        } else if (idStr.length() == 15) {
            ai = idStr.substring(0, 6) + "19" + idStr.substring(6, 15);
        } else {
            throw new HjException(ResultCode.ID_CARD_VALIDATE_FAIL);
        }
        // =======================(end)========================

        // ================ 获取生日 ================
        if (PatternUtil.isNumber(ai) == false) {
            throw new HjException(ResultCode.ID_CARD_VALIDATE_FAIL);
        }
        String birthday = getBirthday(ai);
        if (PatternUtil.isDate(birthday) == false) {
            throw new HjException(ResultCode.ID_CARD_VALIDATE_FAIL);
        }
        // =====================(end)=====================

        // ================ 地区码时候有效 ================
        getArea(ai);
        // ==============================================

        // ================ 判断最后一位的值 ================
        int totalmulAiWi = 0;
        for (int i = 0; i < 17; i++) {
            totalmulAiWi = totalmulAiWi + Integer.parseInt(String.valueOf(ai.charAt(i))) * Integer.parseInt(WI[i]);
        }
        int modValue = totalmulAiWi % 11;
        String strVerifyCode = ValCodeArr[modValue];
        ai = ai + strVerifyCode;

        if (idStr.length() == 18) {
            if (!ai.equals(idStr.toUpperCase())) {
                throw new HjException(ResultCode.ID_CARD_VALIDATE_FAIL);
            }
        }
        // =====================(end)=====================
        return ai;
    }

    /**
     * 根据身份证号码获取生日
     *
     * @param ai
     * @return
     * @throws ParseException
     * @throws NumberFormatException
     */
    public static String getBirthday(String ai) throws HjException {
        try {
            String strYear = ai.substring(6, 10);// 年份
            String strMonth = ai.substring(10, 12);// 月份
            String strDay = ai.substring(12, 14);// 月份

            String birthday = String.format("%s%s%s", strYear, strMonth, strDay);

            GregorianCalendar gc = new GregorianCalendar();
            SimpleDateFormat s = new SimpleDateFormat("yyyyMMdd");
            if ((gc.get(Calendar.YEAR) - Integer.parseInt(strYear)) > 150
                    || (gc.getTime().getTime() - s.parse(birthday).getTime()) < 0) {
                throw new HjException(ResultCode.ID_CARD_VALIDATE_FAIL);
            }

            return birthday;
        } catch (Exception e) {
            throw new HjException(ResultCode.ID_CARD_VALIDATE_FAIL);
        }

    }

    /**
     * 根据身份证号码获取地址
     *
     * @param idStr
     * @return
     */
    public static String getArea(String idStr) {
        String area = AreaCodeTable.get(idStr.substring(0, 2));
        if (area == null) {
            throw new RuntimeException("身份证地区码无效");
        }
        return area;
    }

    public static String getAreaCode(String idStr) {
        return idStr.substring(0, 2);
    }

    public static int getSex(String idStr) {
        return Integer.parseInt(idStr.substring(14, 15));
    }

    /**
     * @param args
     * @throws Exception
     * @throws ParseException
     */
    public static void main(String[] args) throws Exception {
        String idCard = "33072419890306004X";
        String ai = IDCard.validate(idCard);
        System.out.println(ai);
        System.out.println(IDCard.getBirthday(ai));
        System.out.println(IDCard.getArea(ai));
        System.out.println(PatternUtil.isDate("2015-12-31"));
        System.out.println(PatternUtil.isNumber("12345"));
    }
    /***********************************
     * 身份证验证结束
     ****************************************/

}
