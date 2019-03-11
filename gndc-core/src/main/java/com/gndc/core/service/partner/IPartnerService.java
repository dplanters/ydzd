package com.gndc.core.service.partner;

import com.gndc.common.api.ResponseMessage;
import com.gndc.core.etc.partner.PartnerInfo;
import com.gndc.core.model.Partner;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IPartnerService {

    /**
     * 获取商户信息
     *
     * @param requestStr
     * @return
     */
    ResponseMessage<PartnerInfo> getPartner(@RequestParam String requestStr);

    /**
     * 获取所有商户信息
     *
     * @param requestStr
     * @return
     */
    ResponseMessage<List<Partner>> getAllPartner(@RequestParam String requestStr);
}
