package com.gndc.core.service.account;

import com.gndc.core.model.Admin;

public interface AccountService {

    Admin login(String name, String password);

}
