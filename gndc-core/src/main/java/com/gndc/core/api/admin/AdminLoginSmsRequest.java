package com.gndc.core.api.admin;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;

public class AdminLoginSmsRequest extends RequestMessage {
    private static final long serialVersionUID = 1L;

    /**
     * 手机号
     */
    private String phone;

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.A_LOGIN_SMS);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
