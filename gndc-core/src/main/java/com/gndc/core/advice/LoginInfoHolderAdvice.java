package com.gndc.core.advice;

import cn.hutool.core.util.ObjectUtil;
import com.gndc.common.constant.CacheConstant;
import com.gndc.common.utils.BeanFactoryUtil;
import com.gndc.core.api.admin.account.AOLoginAdminInfo;
import com.gndc.core.api.admin.account.AOLoginResponse;
import com.gndc.core.api.common.RequestMessage;
import com.gndc.core.api.partner.account.APLoginAdminInfo;
import com.gndc.core.api.partner.account.APLoginResponse;
import com.gndc.core.model.Admin;
import com.gndc.core.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import java.io.Serializable;
import java.lang.reflect.Type;

/**
 * 登录信息设置在header中
 */
@RestControllerAdvice
public class LoginInfoHolderAdvice extends RequestBodyAdviceAdapter {

    private static final Logger logger = LoggerFactory.getLogger(LoginInfoHolderAdvice.class);

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        RedisTemplate<String, Serializable> redisTemplate = (RedisTemplate<String, Serializable>) BeanFactoryUtil.getBean("redisTemplate");
        Object originalSessionId = RequestContextHolder.getRequestAttributes().getAttribute("sessionId",
                RequestAttributes.SCOPE_REQUEST);
        if (ObjectUtil.isNotNull(originalSessionId)) {
            String sessionId = (String) originalSessionId;
            AOLoginAdminInfo admin = null;
            APLoginAdminInfo partner = null;
            User user = null;
            Object o =
                    redisTemplate.opsForValue().get(CacheConstant.NAMESPACE_ADMIN_LOGIN + sessionId);
            if (ObjectUtil.isNotNull(o)) {
                admin = (AOLoginAdminInfo) o;
            }

            Object o2 =
                    redisTemplate.opsForValue().get(CacheConstant.NAMESPACE_PARTNER_LOGIN + sessionId);
            if (ObjectUtil.isNotNull(o2)) {
                partner = (APLoginAdminInfo) o2;
            }

            Object o3 =
                    redisTemplate.opsForValue().get(CacheConstant.NAMESPACE_USER_LOGIN + sessionId);
            if (ObjectUtil.isNotNull(o3)) {
                user = (User) o3;
            }

            if (ObjectUtil.isNotNull(admin)) {
                ((RequestMessage) body).setAoAdmin(admin);
            }
            if (ObjectUtil.isNotNull(partner)) {
                ((RequestMessage) body).setApAdmin(partner);
            }
            if (ObjectUtil.isNotNull(user)) {
                ((RequestMessage) body).setUser(user);
            }
        }
        return body;
    }
}
