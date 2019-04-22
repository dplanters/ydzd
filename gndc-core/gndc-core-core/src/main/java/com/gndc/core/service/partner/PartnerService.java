package com.gndc.core.service.partner;

import com.gndc.common.service.BaseService;
import com.gndc.core.api.partner.finance.account.APPartnerInfoRequest;
import com.gndc.core.api.partner.finance.account.APPartnerInfoResponse;
import com.gndc.core.model.Partner;

public interface PartnerService extends BaseService<Partner, Integer> {

    /**
     * 获取商户信息
     *
     * @return
     */
    APPartnerInfoResponse getPartner(APPartnerInfoRequest request);

}
