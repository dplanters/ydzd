package com.gndc.common.advice;

import cn.hutool.core.util.ObjectUtil;
import com.gndc.common.api.RequestMessage;
import com.gndc.common.constant.CacheConstant;
import com.gndc.common.dto.AOAdminLoginInfoDTO;
import com.gndc.common.dto.APAdminLoginInfoDTO;
import com.gndc.common.dto.PUserLoginInfoDTO;
import com.gndc.common.utils.BeanFactoryUtil;
import lombok.extern.slf4j.Slf4j;
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
 * @author <a href="jingkaihui@adpanshi.com">jingkaihui</a>
 * @Description 用于对登录信息设置到对应Header的对象中
 * @date 2019/4/11
 */
@Slf4j
@RestControllerAdvice(basePackages = {
        "com.gndc.core.controller.admin",
        "com.gndc.core.controller.partner",
        "com.gndc.core.controller.app",
})
public class LoginInfoHolderAdvice extends RequestBodyAdviceAdapter {

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
            AOAdminLoginInfoDTO admin = null;
            APAdminLoginInfoDTO partner = null;
            PUserLoginInfoDTO user = null;
            Object o =
                    redisTemplate.opsForValue().get(CacheConstant.NAMESPACE_ADMIN_LOGIN + sessionId);
            if (ObjectUtil.isNotNull(o)) {
                admin = (AOAdminLoginInfoDTO) o;
            }

            Object o2 =
                    redisTemplate.opsForValue().get(CacheConstant.NAMESPACE_PARTNER_LOGIN + sessionId);
            if (ObjectUtil.isNotNull(o2)) {
                partner = (APAdminLoginInfoDTO) o2;
            }

            Object o3 =
                    redisTemplate.opsForValue().get(CacheConstant.NAMESPACE_USER_LOGIN + sessionId);
            if (ObjectUtil.isNotNull(o3)) {
                user = (PUserLoginInfoDTO) o3;
            }

            if (ObjectUtil.isNotNull(admin)) {
                ((RequestMessage) body).setAoAdmin(admin);
            }
            if (ObjectUtil.isNotNull(partner)) {
                ((RequestMessage) body).setApAdmin(partner);
            }
            if (ObjectUtil.isNotNull(user)) {
                ((RequestMessage) body).setPUser(user);
            }
        }
        return body;
    }
}
