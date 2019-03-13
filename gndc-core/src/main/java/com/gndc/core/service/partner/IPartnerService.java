package com.gndc.core.service.partner;

import com.gndc.common.api.ResponseMessage;
import com.gndc.common.service.BaseService;
import com.gndc.core.api.partner.common.APAllPartnerRequest;
import com.gndc.core.api.partner.finance.account.APPartnerInfoRequest;
import com.gndc.core.api.partner.finance.account.APPartnerInfoResponse;
import com.gndc.core.model.Partner;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IPartnerService extends BaseService<Partner, Integer> {

    /**
     * 获取商户信息
     *
     * @return
     */
    ResponseMessage<APPartnerInfoResponse> getPartner(APPartnerInfoRequest request);

    /**
     * 获取所有商户信息
     *
     * @return
     */
    ResponseMessage<List<Partner>> getAllPartner(APAllPartnerRequest request);
}
