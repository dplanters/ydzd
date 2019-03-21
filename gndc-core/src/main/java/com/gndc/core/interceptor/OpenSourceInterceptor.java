package com.gndc.core.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.gndc.common.constant.CacheConstant;
import com.gndc.common.utils.BeanFactoryUtil;
import org.springframework.data.redis.core.HashOperations;
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
import java.util.Map;

@Component
public class OpenSourceInterceptor extends WebContentInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException {
        if (request.getMethod().equals(HttpMethod.OPTIONS.name())) {
            return true;
        }
        RedisTemplate<String, Serializable> redisTemplate =
                (RedisTemplate<String, Serializable>) BeanFactoryUtil.getBean(
                        "redisTemplate");
        boolean requireAuth = true;
        boolean noHandler = true;
        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        Map<Object, Object> entries = hashOperations.entries(CacheConstant.KEY_ALL_RIGHT);
        for (Map.Entry<Object, Object> entry : entries.entrySet()) {
            JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(entry.getValue()));
            String rightUrl = jsonObject.getString("rightUrl");
            String servletPath = request.getServletPath();
            if (rightUrl.equals(servletPath)) {
                noHandler = false;
            }
            //对当前请求路径和权限表进行匹配
            if (rightUrl.equals(servletPath) && new Byte((byte)0).equals(jsonObject.getByte("requireAuth"))) {
                requireAuth = false;
            }
        }
        //对不需要授权的请求添加requireAuth标志
        RequestContextHolder.getRequestAttributes().setAttribute("requireAuth", requireAuth,
                RequestAttributes.SCOPE_REQUEST);
        RequestContextHolder.getRequestAttributes().setAttribute("noHandler", noHandler,
                RequestAttributes.SCOPE_REQUEST);
        return true;
    }
}
