package com.gndc.admin.service.sys;

import com.gndc.admin.api.partner.common.APPayeeListRequest;
import com.gndc.common.model.SystemOption;
import com.gndc.common.service.BaseService;

import java.util.List;

public interface SystemOptionService extends BaseService<SystemOption, Integer> {


    /**
     * 商户后台-获取收款人列表
     * @return
     */
    List<String> payeeList(APPayeeListRequest request);
}
