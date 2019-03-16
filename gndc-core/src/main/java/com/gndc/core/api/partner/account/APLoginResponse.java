package com.gndc.core.api.partner.account;

import com.gndc.core.model.Admin;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class APLoginResponse implements Serializable {

    private Admin admin;

    private String sessionId;
}
