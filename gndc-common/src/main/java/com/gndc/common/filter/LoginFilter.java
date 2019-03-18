package com.gndc.common.filter;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.gndc.common.constant.CacheConstant;
import com.gndc.common.http.BodyCacheHttpServletRequestWrapper;
import com.gndc.common.http.CustomBodyResponseWrapper;
import com.gndc.common.utils.BeanFactoryUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

public class LoginFilter extends OncePerRequestFilter {
    private static final Logger logger = LoggerFactory.getLogger(LoginFilter.class);


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        BodyCacheHttpServletRequestWrapper bodyCacheHttpServletRequestWrapper = new BodyCacheHttpServletRequestWrapper(request);
        CustomBodyResponseWrapper customBodyResponseWrapper = new CustomBodyResponseWrapper(request, response);
        filterChain.doFilter(bodyCacheHttpServletRequestWrapper, customBodyResponseWrapper);

        String bodyString = bodyCacheHttpServletRequestWrapper.getBodyString();
        byte[] contentAsByteArray = customBodyResponseWrapper.getContentAsByteArray();
        String responseContent = new String(contentAsByteArray, Charset.forName("UTF-8"));
        JSONObject jsonBody = JSONObject.parseObject(bodyString);

        if (request.getMethod().equals(HttpMethod.OPTIONS.name())) {
            //预检请求放行
            return;
        } else if (request.getRequestURI().contains("login")) {
            //TODO 公共接口 先放行登录接口

        } else {
            String sessionId = request.getHeader("sessionId");
            if (ObjectUtil.isNull(sessionId)) {
                sessionId = jsonBody.getJSONObject("header").getString("sessionId");
            }
            RedisTemplate<String, Serializable> redisTemplate = (RedisTemplate<String, Serializable>) BeanFactoryUtil.getBean("redisTemplate");

            JSONObject responseJson = new JSONObject().fluentPut("success", false);
            if (StrUtil.isEmpty(sessionId)) {
                logger.warn("用户未登录");
                responseJson.fluentPut("code", "-110").fluentPut("msg", "用户未登录");
                responseContent = responseJson.toJSONString();
            } else {
                Serializable admin = redisTemplate.opsForValue().get(sessionId);
                if (ObjectUtil.isNull(admin)) {
                    logger.warn("session已失效");
                    responseJson.fluentPut("code", "-120").fluentPut("msg", "session已失效");
                    responseContent = responseJson.toJSONString();
                } else {
                    Long expire = 0L;
                    if (sessionId.startsWith(CacheConstant.KEY_ADMIN_LOGIN_PREFIX)) {
                        expire = CacheConstant.EXPIRE_ADMIN_LOGIN;
                    } else if (sessionId.startsWith(CacheConstant.KEY_PARTNER_LOGIN_PREFIX)) {
                        expire = CacheConstant.EXPIRE_PARTNER_LOGIN;
                    } else if (sessionId.startsWith(CacheConstant.KEY_USER_LOGIN_PREFIX)) {
                        expire = CacheConstant.EXPIRE_USER_LOGIN;
                    } else {
                        logger.warn("无效的sessionId");
                        responseJson.fluentPut("code", "-130").fluentPut("msg", "无效的sessionId");
                    }
                    redisTemplate.opsForValue().set(sessionId, admin, expire, TimeUnit.SECONDS);
                }
            }
        }
        if (!customBodyResponseWrapper.isCommitted()) {
            customBodyResponseWrapper.reset();
        }
        customBodyResponseWrapper.getContent().write(responseContent.getBytes(Charset.forName("UTF-8")));

        customBodyResponseWrapper.copyBodyToResponse();

    }

}