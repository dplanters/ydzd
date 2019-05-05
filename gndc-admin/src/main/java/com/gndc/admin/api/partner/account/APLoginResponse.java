package com.gndc.admin.api.partner.account;

import com.gndc.common.dto.APAdminLoginInfoDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class APLoginResponse implements Serializable {

    private APAdminLoginInfoDTO admin;

    private String sessionId;
}
