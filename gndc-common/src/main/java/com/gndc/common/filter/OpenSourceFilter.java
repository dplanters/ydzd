package com.gndc.common.filter;

import com.alibaba.fastjson.JSONObject;
import com.gndc.common.constant.CacheConstant;
import com.gndc.common.utils.BeanFactoryUtil;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

public class OpenSourceFilter extends OncePerRequestFilter {

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        //是否是预检请求
        return request.getMethod().equals(HttpMethod.OPTIONS.name());
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        RedisTemplate<String, Serializable> redisTemplate =
                (RedisTemplate<String, Serializable>) BeanFactoryUtil.getBean(
                        "redisTemplate");
        boolean requireAuth = true;
        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        Map<Object, Object> entries = hashOperations.entries(CacheConstant.KEY_ALL_RIGHT);
        for (Map.Entry<Object, Object> entry : entries.entrySet()) {
            JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(entry.getValue()));
            String rightUrl = jsonObject.getString("rightUrl");
            String servletPath = request.getServletPath();
            //对当前请求路径和权限表进行匹配
            if (rightUrl.equals(servletPath) && new Byte((byte)0).equals(jsonObject.getByte("requireAuth"))) {
                requireAuth = false;
            }
        }
        //对不需要授权的请求添加requireAuth标志
        RequestContextHolder.getRequestAttributes().setAttribute("requireAuth", requireAuth,
                RequestAttributes.SCOPE_REQUEST);
        filterChain.doFilter(request, response);
    }
}
