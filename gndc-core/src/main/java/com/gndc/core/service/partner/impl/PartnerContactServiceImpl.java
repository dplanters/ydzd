package com.gndc.core.service.partner.impl;
import com.gndc.common.api.ResponseMessage;
import com.gndc.common.api.ResultCode;
import com.gndc.common.service.BaseService;
import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.common.utils.JsonUtil;
import com.gndc.core.api.partner.PartnerContactAddRequest;
import com.gndc.core.api.partner.RechargeRecordRequest;
import com.gndc.core.mapper.simple.PartnerContactMapper;
import com.gndc.core.model.PartnerContact;
import com.gndc.core.service.partner.IPartnerContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author jingkaihui
 * @date 2019/2/25
 */
@RestController
public class PartnerContactServiceImpl extends BaseServiceImpl<PartnerContact, Integer> implements IPartnerContactService {

    private static final Logger logger = LoggerFactory.getLogger(PartnerContactServiceImpl.class);
    @Resource
    private PartnerContactMapper partnerContactMapper;

    @Override
    @RequestMapping(value = "/addPartnerContact")
    public ResponseMessage<Boolean> addPartnerContact(String requestStr) {
        logger.info(String.format("请求:%s", requestStr));
        PartnerContactAddRequest request = JsonUtil.getObject(requestStr, PartnerContactAddRequest.class);
        PartnerContact partnerContact = new PartnerContact();

        BeanUtils.copyProperties(request, partnerContact);

        try {
            ResponseMessage<Boolean> response = new ResponseMessage<>(request);
            partnerContact.setPartnerId(request.getAdmin().getPartnerId());
            int affected = partnerContactMapper.insertSelective(partnerContact);

            response.setData(affected == 1);
            return response;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);

            ResponseMessage<Boolean> response = new ResponseMessage<>(new RechargeRecordRequest());
            response.createError(ResultCode.RECORD_SAVE_FAIL);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        }
    }
}
