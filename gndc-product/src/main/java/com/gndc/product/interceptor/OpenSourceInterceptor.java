package com.gndc.product.interceptor;

import com.gndc.common.constant.CacheConstant;
import com.gndc.common.dto.RightInfoDTO;
import com.gndc.common.utils.BeanFactoryUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Slf4j
@Component
public class OpenSourceInterceptor extends WebContentInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException {
        //预检请求放行
        if (request.getMethod().equals(HttpMethod.OPTIONS.name())) {
            return true;
        }
        RedisTemplate redisTemplate =
                (RedisTemplate) BeanFactoryUtil.getBean(
                        "redisTemplate");
        boolean requireAuth = true;
        boolean noHandler = true;
        Map<Integer, RightInfoDTO> entries = redisTemplate.opsForHash().entries(CacheConstant.KEY_ALL_RIGHT);
        for (Map.Entry<Integer, RightInfoDTO> entry : entries.entrySet()) {
            String rightUrl = entry.getValue().getRightUrl();
            String servletPath = request.getServletPath();
            if (rightUrl.equals(servletPath)) {
                noHandler = false;
            }
            //对当前请求路径和权限表进行匹配
            if (rightUrl.equals(servletPath) && new Byte((byte)0).equals(entry.getValue().getRequireAuth())) {
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
