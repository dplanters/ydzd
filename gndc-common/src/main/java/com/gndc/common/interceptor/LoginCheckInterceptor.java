package com.gndc.common.interceptor;

import cn.hutool.core.util.ObjectUtil;
import com.gndc.common.dto.RightInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Set;

/**
 * 弃用，权限校验部分放在网关中做
 * @author <a href="jingkaihui@adpanshi.com">jingkaihui</a>
 * @Description 用于对需要登录才能访问的资源进行登录校验
 * @date 2019/4/11
 */
@Slf4j
@Component
@Deprecated
public class LoginCheckInterceptor extends WebContentInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException {
//        try {
//            //预检请求放行
//            if (request.getMethod().equals(HttpMethod.OPTIONS.name())) {
//                return true;
//            }
//            Object requireAuth = RequestContextHolder.getRequestAttributes().getAttribute("requireAuth", RequestAttributes.SCOPE_REQUEST);
//            Object noHandler = RequestContextHolder.getRequestAttributes().getAttribute("noHandler",
//                    RequestAttributes.SCOPE_REQUEST);
//            if (noHandler.equals(true)) {
//                String msg = StrUtil.format("{} 未初始化", request.getServletPath());
//                logger.warn(msg);
//                ResponseUtil.sendError(response, HttpStatus.OK.value(),
//                        String.valueOf(ResultCode.RIGHT_NOT_INITIALISE.getCode()));
//                return false;
//            }
//            //不需要授权的请求放行
//            if (requireAuth.equals(false)) {
//                return true;
//            }
//            String sessionId = request.getHeader("sessionId");
//            RedisTemplate redisTemplate =
//                    (RedisTemplate) BeanFactoryUtil.getBean("redisTemplate");
//
//            if (StrUtil.isEmpty(sessionId)) {
//                logger.warn("缺少sessionId");
//                ResponseUtil.sendError(response, HttpStatus.OK.value(), String.valueOf(ResultCode.NO_SESSION.getCode()));
//                return false;
//            } else {
//                AOAdminLoginInfoDTO admin = null;
//                APAdminLoginInfoDTO partner = null;
//                PUserLoginInfoDTO user = null;
//
//                Object o =
//                        redisTemplate.opsForValue().get(CacheConstant.NAMESPACE_ADMIN_LOGIN + sessionId);
//                if (ObjectUtil.isNotNull(o)) {
//                    admin = (AOAdminLoginInfoDTO) o;
//                }
//
//                Object o2 =
//                        redisTemplate.opsForValue().get(CacheConstant.NAMESPACE_PARTNER_LOGIN + sessionId);
//                if (ObjectUtil.isNotNull(o2)) {
//                    partner = (APAdminLoginInfoDTO) o2;
//                }
//
//                Object o3 =
//                        redisTemplate.opsForValue().get(CacheConstant.NAMESPACE_USER_LOGIN + sessionId);
//                if (ObjectUtil.isNotNull(o3)) {
//                    user = (PUserLoginInfoDTO) o3;
//                }
//
//                if (ObjectUtil.isNull(admin) && ObjectUtil.isNull(partner) && ObjectUtil.isNull(user)) {
//                    String msg = StrUtil.format("session : {} 已失效", sessionId);
//                    logger.warn(msg);
//                    ResponseUtil.sendError(response, HttpStatus.OK.value(),
//                            String.valueOf(ResultCode.SESSION_EXPIRED.getCode()));
//                    return false;
//                } else {
//                    Long expire = 0L;
//                    RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
//
//                    if (ObjectUtil.isNotNull(admin)) {
//                        expire = CacheConstant.EXPIRE_ADMIN_LOGIN;
//                        requestAttributes.setAttribute(CacheConstant.NAMESPACE_ADMIN_LOGIN, admin,
//                                RequestAttributes.SCOPE_SESSION);
//                        //session保活
//                        redisTemplate.opsForValue().set(CacheConstant.NAMESPACE_ADMIN_LOGIN + sessionId, admin, expire,
//                                TimeUnit.SECONDS);
//                    } else if (ObjectUtil.isNotNull(partner)) {
//                        expire = CacheConstant.EXPIRE_PARTNER_LOGIN;
//                        requestAttributes.setAttribute(CacheConstant.NAMESPACE_PARTNER_LOGIN, admin,
//                                RequestAttributes.SCOPE_REQUEST);
//                        //session保活
//                        redisTemplate.opsForValue().set(CacheConstant.NAMESPACE_PARTNER_LOGIN + sessionId, partner, expire,
//                                TimeUnit.SECONDS);
//                    } else if (ObjectUtil.isNotNull(user)) {
//                        expire = CacheConstant.EXPIRE_USER_LOGIN;
//                        requestAttributes.setAttribute(CacheConstant.NAMESPACE_USER_LOGIN, admin,
//                                RequestAttributes.SCOPE_REQUEST);
//                        //session保活
//                        redisTemplate.opsForValue().set(CacheConstant.NAMESPACE_USER_LOGIN + sessionId, user, expire,
//                                TimeUnit.SECONDS);
//                    } else {
//                        String msg = StrUtil.format("无效的sessionId:{}", sessionId);
//                        logger.warn(msg);
//                        ResponseUtil.sendError(response, HttpStatus.OK.value(),
//                                String.valueOf(ResultCode.INVALID_SESSION.getCode()));
//                        return false;
//                    }
//                    RequestContextHolder.getRequestAttributes().setAttribute("sessionId", sessionId, RequestAttributes.SCOPE_REQUEST);
//                    if (ObjectUtil.isNotNull(user)) {
//                        //App用户放行,不校验权限
//                        return true;
//                    }
//
//                    Set<Boolean> hasRight = new HashSet<>();
//                    if (ObjectUtil.isNotNull(admin)) {
//                        //权限校验
//                        hasRight(admin.getRights(), request.getServletPath(), hasRight);
//                    }
//                    if (ObjectUtil.isNotNull(partner)) {
//                        //权限校验
//                        hasRight(partner.getRights(), request.getServletPath(), hasRight);
//                    }
//                    if (!hasRight.contains(true)) {
//                        logger.warn("没有权限");
//                        ResponseUtil.sendError(response, HttpStatus.OK.value(),
//                                String.valueOf(ResultCode.NO_PERMISSION.getCode()));
//                        return false;
//                    }
//                }
//            }
//        } catch (Exception e) {
//            log.error("LoginCheckInterceptor出现异常", e);
//            ResponseUtil.sendError(response);
//            return false;
//        }
        return true;
    }

    private void hasRight(List<RightInfoDTO> rights, String servletPath, Set<Boolean> hasRight) {
        if (ObjectUtil.isNotNull(rights)) {
            for (RightInfoDTO right : rights) {
                hasRight(right.getChildren(), servletPath, hasRight);
                //如果自己用户的权限中有和当前请求可以匹配，则拥有权限
                if (right.getRightUrl().equals(servletPath)) {
                    hasRight.add(true);
                    break;
                }
            }
        }
    }

}
