package com.gndc.core.api.user;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;

/**
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description 校验手机号码是否已经注册
 * @date 2018年1月24日 下午2:40:33
 */
public class UserVerifyMobileRequest extends RequestMessage {
    /**
     * @Fields serialVersionUID:
     */
    private static final long serialVersionUID = 2301349644081904483L;
    /**
     * 短信验证码
     */
    String valCode;
    /**
     * 手机号
     */
    private String phone;

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.U_VERIFY_SMS_RESET_PWD);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getValCode() {
        return valCode;
    }

    public void setValCode(String valCode) {
        this.valCode = valCode;
    }

}
