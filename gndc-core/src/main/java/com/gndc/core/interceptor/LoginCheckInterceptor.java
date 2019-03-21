package com.gndc.core.interceptor;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.gndc.common.constant.CacheConstant;
import com.gndc.common.enums.ResultCode;
import com.gndc.common.exception.HjException;
import com.gndc.common.utils.BeanFactoryUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

@Component
public class LoginCheckInterceptor extends WebContentInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException {
        if (request.getMethod().equals(HttpMethod.OPTIONS.name())) {
            return true;
        }
        Object requireAuth = RequestContextHolder.getRequestAttributes().getAttribute("requireAuth", RequestAttributes.SCOPE_REQUEST);
        Object noHandler = RequestContextHolder.getRequestAttributes().getAttribute("noHandler",
                RequestAttributes.SCOPE_REQUEST);
        if (noHandler.equals(true)) {
            String msg = StrUtil.format("{} 不存在", request.getServletPath());
            logger.warn(msg);
            throw new HjException(ResultCode.ERROR, msg);
        }
        if (requireAuth.equals(false)) {
            return true;
        }
        String sessionId = request.getHeader("sessionId");
        RedisTemplate<String, Serializable> redisTemplate =
                (RedisTemplate<String, Serializable>) BeanFactoryUtil.getBean("redisTemplate");

        if (StrUtil.isEmpty(sessionId)) {
            logger.warn("用户未登录");
            throw new HjException(ResultCode.USER_NOT_LOGIN, "用户未登录");
        } else {
            Serializable admin = redisTemplate.opsForValue().get(sessionId);
            if (ObjectUtil.isNull(admin)) {
                logger.warn("session已失效");
                throw new HjException(ResultCode.SESSION_EXPIRE);
            } else {
                Long expire = 0L;
                RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();

                if (sessionId.startsWith(CacheConstant.KEY_ADMIN_LOGIN_PREFIX)) {
                    expire = CacheConstant.EXPIRE_ADMIN_LOGIN;
                    requestAttributes.setAttribute(CacheConstant.KEY_ADMIN_LOGIN_PREFIX,   admin,
                            RequestAttributes.SCOPE_SESSION);
                } else if (sessionId.startsWith(CacheConstant.KEY_PARTNER_LOGIN_PREFIX)) {
                    expire = CacheConstant.EXPIRE_PARTNER_LOGIN;
                    requestAttributes.setAttribute(CacheConstant.KEY_PARTNER_LOGIN_PREFIX, admin,
                            RequestAttributes.SCOPE_REQUEST);
                } else if (sessionId.startsWith(CacheConstant.KEY_USER_LOGIN_PREFIX)) {
                    expire = CacheConstant.EXPIRE_USER_LOGIN;
                    requestAttributes.setAttribute(CacheConstant.KEY_USER_LOGIN_PREFIX, admin,
                            RequestAttributes.SCOPE_REQUEST);
                } else {
                    logger.warn("无效的sessionId");
                }
                //session保活
                redisTemplate.opsForValue().set(sessionId, admin, expire, TimeUnit.SECONDS);
                RequestContextHolder.getRequestAttributes().setAttribute("sessionId", sessionId, RequestAttributes.SCOPE_REQUEST);
            }
        }
        return true;
    }
}
