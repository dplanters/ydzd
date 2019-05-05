/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.common.enums.product;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="liujun8852@adpanshi.com">liujun</a>
 * @version V1.0.1
 * @Description
 * @date 2019/4/27  14:17
 */
public enum  SettlementModeEnum {

    //  1：UV量；5：CPA-注册成功(H5对接) 或 一推成功(API对接)；10：CPS-放款成功；
    UV((byte)1,"UV量"),
    CPA((byte)5,"CPA-注册成功(H5对接) 或 一推成功(API对接)"),
    CPS((byte)10,"CPS-放款成功");

    private Byte code;
    private String name;

    SettlementModeEnum(Byte code, String name) {
        this.code = code;
        this.name = name;
    }
    private static Map<Byte,SettlementModeEnum> map;
    static{
        SettlementModeEnum[] values = SettlementModeEnum.values();
        map=new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            map.put(values[i].getCode(),values[i]);
        }
    }
    public static SettlementModeEnum valueOfCode(Byte code){
        return map.get(code);
    }

    public Byte getCode() {
        return code;
    }

    public void setCode(Byte code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
