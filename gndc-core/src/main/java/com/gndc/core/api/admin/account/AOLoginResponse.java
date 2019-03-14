package com.gndc.core.api.admin.account;

import com.gndc.core.model.Admin;
import com.gndc.core.model.Right;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class AOLoginResponse implements Serializable {

    private Admin admin;

    private String sessionId;
}
