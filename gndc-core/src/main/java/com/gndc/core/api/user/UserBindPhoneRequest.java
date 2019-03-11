package com.gndc.core.api.user;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;

public class UserBindPhoneRequest extends RequestMessage {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String phone; // 手机号

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.SMS_USER_MODIFY_PHONE);
    }

}
