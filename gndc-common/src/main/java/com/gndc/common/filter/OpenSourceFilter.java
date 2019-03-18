package com.gndc.common.filter;

import com.alibaba.fastjson.JSONObject;
import com.gndc.common.constant.CacheConstant;
import com.gndc.common.utils.BeanFactoryUtil;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
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
        boolean optionsMethod = request.getMethod().equals(HttpMethod.OPTIONS.name());
        RedisTemplate<String, Serializable> redisTemplate =
                (RedisTemplate<String, Serializable>) BeanFactoryUtil.getBean(
                        "redisTemplate");
        boolean requireAuth = true;
        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        Map<Object, Object> entries = hashOperations.entries(CacheConstant.KEY_ALL_RIGHT);
        for (Map.Entry<Object, Object> entry : entries.entrySet()) {
            JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(entry.getValue()));
            Integer requireAuthByte = jsonObject.getIntValue("requireAuth");
            if (requireAuthByte.equals(0)) {
                requireAuth = false;
            }
        }
        return optionsMethod || requireAuth;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        filterChain.doFilter(request, response);
    }
}
