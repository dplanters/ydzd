package com.gndc.core.service.partner;

import com.gndc.common.api.ResponseMessage;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author jingkaihui
 * @date 2019/2/25
 */
public interface IPartnerContactService {

    /**
     * 添加紧急联系人
     *
     * @param requestStr
     * @return
     */
    ResponseMessage<Boolean> addPartnerContact(@RequestParam String requestStr);
}