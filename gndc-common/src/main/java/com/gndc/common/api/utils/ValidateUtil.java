package com.gndc.common.api.utils;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.gndc.common.api.Header;
import com.gndc.common.api.HjException;
import com.gndc.common.api.Page;
import com.gndc.common.api.ResultCode;
import com.gndc.common.model.Admin;
import com.gndc.common.model.User;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.HibernateValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @author <a href="junhui@sunnyhanmy.com">changjunhui</a>
 * @version V1.0.1
 * @Description
 * @date 2017年5月25日 上午11:37:08
 */
public class ValidateUtil {
    public static boolean validate(Header header) throws HjException {
        if (header == null) {
            header = new Header();
            throw new HjException(ResultCode.HEADER_ISNULL);
        }
        // if (StringUtils.isEmpty(header.getUserid())) {
        // throw new HjException(StockErrorCode.USERID_ISNULL, "用户ID不能为空");
        // }
        if (header.getMsgType() == null) {
            throw new HjException(ResultCode.MSGTYPE_ISNULL);
        }
        if (Header.REQUEST != header.getMsgType()) {
            throw new HjException(ResultCode.INVALID_MSGTYPE);
        }
        return true;
    }

    public static boolean validateUser(User userInfo) throws HjException {
        if (userInfo == null) {
            throw new HjException(ResultCode.SESSIONID_ISNULL);
        }
        return true;
    }

    public static boolean validateAdmin(Admin admin) throws HjException {
        if (admin == null) {
            throw new HjException(ResultCode.SESSIONID_ISNULL);
        }
        return true;
    }

    public static boolean validateBean(Object bean) throws HjException {
        Validator validator = Validation.byProvider(HibernateValidator.class).configure().failFast(true).buildValidatorFactory().getValidator();
        Set<ConstraintViolation<Object>> validate = validator.validate(bean);
        JSONObject msgExt = new JSONObject();
        if (validate.size() > 0) {
            for (ConstraintViolation<Object> violation : validate) {
                Path propertyPath = violation.getPropertyPath();
                msgExt.fluentPut(propertyPath.toString(), violation.getMessage());
            }
            throw new HjException(ResultCode.PARAMETER_ERROR, msgExt);
        }
        return true;
    }
}
