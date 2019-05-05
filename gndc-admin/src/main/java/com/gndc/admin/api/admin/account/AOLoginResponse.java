package com.gndc.admin.api.admin.account;

import com.gndc.common.dto.AOAdminLoginInfoDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AOLoginResponse implements Serializable {

    private AOAdminLoginInfoDTO admin;

    private String sessionId;
}
