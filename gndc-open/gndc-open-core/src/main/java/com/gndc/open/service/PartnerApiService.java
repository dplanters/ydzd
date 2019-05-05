package com.gndc.open.service;

import com.gndc.common.enums.partner.PartnerApiTypeEnum;
import com.gndc.common.model.PartnerApi;
import com.gndc.common.service.BaseService;

public interface PartnerApiService extends BaseService<PartnerApi, Integer> {

    /**
     * 根据商户id和apiType获取PartnerApi
     * @return
     */
    PartnerApi getPartnerApi(Integer partnerId, PartnerApiTypeEnum partnerApiTypeEnum);
}
