package com.gndc.common.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 弃用，权限逻辑放在网关中做
 * @author <a href="jingkaihui@adpanshi.com">jingkaihui</a>
 * @Description 用于对不需要授权的公共资源进行标识
 * @date 2019/4/11
 */
@Slf4j
@Component
@Deprecated
public class OpenSourceInterceptor extends WebContentInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException {
//        //预检请求放行
//        boolean requireAuth = true;
//        boolean noHandler = true;
//        RedisTemplate redisTemplate;
//        try {
//            if (request.getMethod().equals(HttpMethod.OPTIONS.name())) {
//                return true;
//            }
//            try {
//                redisTemplate =
//                        (RedisTemplate) BeanFactoryUtil.getBean(
//                                "redisTemplate");
//            } catch (Exception e) {
//                log.error("获取redisTemplate出现异常", e);
//                ResponseUtil.sendError(response);
//                return false;
//            }
//            Map<Integer, RightInfoDTO> entries = redisTemplate.opsForHash().entries(CacheConstant.KEY_ALL_RIGHT);
//            for (Map.Entry<Integer, RightInfoDTO> entry : entries.entrySet()) {
//                String rightUrl = entry.getValue().getRightUrl();
//                String servletPath = request.getServletPath();
//                if (rightUrl.equals(servletPath)) {
//                    noHandler = false;
//                }
//                //对当前请求路径和权限表进行匹配
//                if (rightUrl.equals(servletPath) && new Byte((byte)0).equals(entry.getValue().getRequireAuth())) {
//                    requireAuth = false;
//                }
//            }
//            //对不需要授权的请求添加requireAuth标志
//            RequestContextHolder.getRequestAttributes().setAttribute("requireAuth", requireAuth,
//                    RequestAttributes.SCOPE_REQUEST);
//            RequestContextHolder.getRequestAttributes().setAttribute("noHandler", noHandler,
//                    RequestAttributes.SCOPE_REQUEST);
//        } catch (Exception e) {
//            log.error("OpenSourceInterceptor出现异常");
//            ResponseUtil.sendError(response);
//            return false;
//        }
        return true;
    }
}
