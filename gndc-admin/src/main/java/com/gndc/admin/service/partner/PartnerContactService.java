package com.gndc.admin.service.partner;

import com.gndc.common.service.BaseService;
import com.gndc.admin.api.partner.sys.APPartnerContactAddRequest;
import com.gndc.common.model.PartnerContact;

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
    Boolean addPartnerContact(APPartnerContactAddRequest request);
}
