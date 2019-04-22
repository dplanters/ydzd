package com.gndc.core.service.sys;

import com.gndc.common.service.BaseService;
import com.gndc.core.api.partner.common.APPayeeListRequest;
import com.gndc.core.model.SystemOption;

import java.util.List;

public interface SystemOptionService extends BaseService<SystemOption, Integer> {


    /**
     * 商户后台-获取收款人列表
     * @return
     */
    List<String> payeeList(APPayeeListRequest request);
}
