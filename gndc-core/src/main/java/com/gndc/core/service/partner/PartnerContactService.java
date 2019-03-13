package com.gndc.core.service.partner;

import com.gndc.common.service.BaseService;
import com.gndc.core.api.partner.PartnerContactAddRequest;
import com.gndc.core.model.PartnerContact;

/**
 * @author jingkaihui
 * @date 2019/2/25
 */
public interface PartnerContactService extends BaseService<PartnerContact, Integer> {

    /**
     * 添加紧急联系人
     *
     * @return
     */
    Boolean addPartnerContact(PartnerContactAddRequest request);
}
