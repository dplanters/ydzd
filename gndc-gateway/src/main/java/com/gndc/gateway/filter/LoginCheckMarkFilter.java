package com.gndc.gateway.filter;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.gndc.common.api.ResponseMessage;
import com.gndc.common.constant.CacheConstant;
import com.gndc.common.dto.AOAdminLoginInfoDTO;
import com.gndc.common.dto.APAdminLoginInfoDTO;
import com.gndc.common.dto.PUserLoginInfoDTO;
import com.gndc.common.dto.RightInfoDTO;
import com.gndc.common.enums.ResultCode;
import com.gndc.common.utils.BeanFactoryUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="jingkaihui@adpanshi.com">jingkaihui</a>
 * @Description 根据sessionId进行登录信息的标记
 * @date 2019/4/17
 */
@Slf4j
@Component
public class LoginCheckMarkFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        Object noHandler = RequestContextHolder.getRequestAttributes().getAttribute("noHandler",
                RequestAttributes.SCOPE_REQUEST);
        if (noHandler.equals(true)) {
            String msg = StrUtil.format("{} 未初始化", request.getServletPath());
            log.warn(msg);
            return false;
        }

        Object requireAuth = RequestContextHolder.getRequestAttributes().getAttribute("requireAuth", RequestAttributes.SCOPE_REQUEST);
        //对需要授权的请求进行过滤，不需要授权的不过滤直接转发
        return requireAuth.equals(true);
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        try {
            String sessionId = request.getHeader("sessionId");
            RedisTemplate redisTemplate =
                    (RedisTemplate) BeanFactoryUtil.getBean("redisTemplate");

            if (StrUtil.isEmpty(sessionId)) {
                log.warn("缺少sessionId");
                currentContext.setSendZuulResponse(false);
                currentContext.setResponseStatusCode(HttpStatus.BAD_REQUEST.value());
                currentContext.setResponseBody(JSONObject.toJSONString(ResponseMessage.error(ResultCode.NO_SESSION)));
                currentContext.getResponse().setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
                return false;
            } else {
                AOAdminLoginInfoDTO admin = null;
                APAdminLoginInfoDTO partner = null;
                PUserLoginInfoDTO user = null;

                Object o =
                        redisTemplate.opsForValue().get(CacheConstant.NAMESPACE_ADMIN_LOGIN + sessionId);
                if (ObjectUtil.isNotNull(o)) {
                    //转发时向header中传递当前用户的类型及sessionId
                    currentContext.addZuulRequestHeader("loginType", "admin");
                    currentContext.addZuulRequestHeader("sessionId", CacheConstant.NAMESPACE_ADMIN_LOGIN + sessionId);
                    admin = (AOAdminLoginInfoDTO) o;
                }

                Object o2 =
                        redisTemplate.opsForValue().get(CacheConstant.NAMESPACE_PARTNER_LOGIN + sessionId);
                if (ObjectUtil.isNotNull(o2)) {
                    //转发时向header中传递当前用户的类型及sessionId
                    currentContext.addZuulRequestHeader("loginType", "partner");
                    currentContext.addZuulRequestHeader("sessionId", CacheConstant.NAMESPACE_PARTNER_LOGIN + sessionId);
                    partner = (APAdminLoginInfoDTO) o2;
                }

                Object o3 =
                        redisTemplate.opsForValue().get(CacheConstant.NAMESPACE_USER_LOGIN + sessionId);
                if (ObjectUtil.isNotNull(o3)) {
                    //转发时向header中传递当前用户的类型及sessionId
                    currentContext.addZuulRequestHeader("loginType", "user");
                    currentContext.addZuulRequestHeader("sessionId", CacheConstant.NAMESPACE_USER_LOGIN + sessionId);
                    user = (PUserLoginInfoDTO) o3;
                }

                if (ObjectUtil.isNull(admin) && ObjectUtil.isNull(partner) && ObjectUtil.isNull(user)) {
                    String msg = StrUtil.format("session : {} 已失效", sessionId);
                    log.warn(msg);
                    currentContext.setSendZuulResponse(false);
                    currentContext.setResponseStatusCode(HttpStatus.BAD_REQUEST.value());
                    currentContext.setResponseBody(JSONObject.toJSONString(ResponseMessage.error(ResultCode.SESSION_EXPIRED)));
                    currentContext.getResponse().setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
                    return null;
                } else {
                    Long expire = 0L;
                    RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();

                    if (ObjectUtil.isNotNull(admin)) {
                        expire = CacheConstant.EXPIRE_ADMIN_LOGIN;
                        requestAttributes.setAttribute(CacheConstant.NAMESPACE_ADMIN_LOGIN, admin,
                                RequestAttributes.SCOPE_SESSION);
                        //session保活
                        redisTemplate.opsForValue().set(CacheConstant.NAMESPACE_ADMIN_LOGIN + sessionId, admin, expire,
                                TimeUnit.SECONDS);
                    } else if (ObjectUtil.isNotNull(partner)) {
                        expire = CacheConstant.EXPIRE_PARTNER_LOGIN;
                        requestAttributes.setAttribute(CacheConstant.NAMESPACE_PARTNER_LOGIN, admin,
                                RequestAttributes.SCOPE_REQUEST);
                        //session保活
                        redisTemplate.opsForValue().set(CacheConstant.NAMESPACE_PARTNER_LOGIN + sessionId, partner, expire,
                                TimeUnit.SECONDS);
                    } else if (ObjectUtil.isNotNull(user)) {
                        expire = CacheConstant.EXPIRE_USER_LOGIN;
                        requestAttributes.setAttribute(CacheConstant.NAMESPACE_USER_LOGIN, admin,
                                RequestAttributes.SCOPE_REQUEST);
                        //session保活
                        redisTemplate.opsForValue().set(CacheConstant.NAMESPACE_USER_LOGIN + sessionId, user, expire,
                                TimeUnit.SECONDS);
                    } else {
                        String msg = StrUtil.format("无效的sessionId:{}", sessionId);
                        log.warn(msg);
                        currentContext.setSendZuulResponse(false);
                        currentContext.setResponseStatusCode(HttpStatus.BAD_REQUEST.value());
                        currentContext.setResponseBody(JSONObject.toJSONString(ResponseMessage.error(ResultCode.INVALID_SESSION)));
                        currentContext.getResponse().setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
                        return null;
                    }
                    RequestContextHolder.getRequestAttributes().setAttribute("sessionId", sessionId, RequestAttributes.SCOPE_REQUEST);
                    if (ObjectUtil.isNotNull(user)) {
                        //App用户放行,不校验权限
                        return null;
                    }

                    Set<Boolean> hasRight = new HashSet<>();
                    if (ObjectUtil.isNotNull(admin)) {
                        //权限校验
                        hasRight(admin.getRights(), request.getServletPath(), hasRight);
                    }
                    if (ObjectUtil.isNotNull(partner)) {
                        //权限校验
                        hasRight(partner.getRights(), request.getServletPath(), hasRight);
                    }

                    if (!hasRight.contains(true)) {
                        log.warn("没有权限");
                        currentContext.setSendZuulResponse(false);
                        currentContext.setResponseStatusCode(HttpStatus.BAD_REQUEST.value());
                        currentContext.setResponseBody(JSONObject.toJSONString(ResponseMessage.error(ResultCode.NO_PERMISSION)));
                        currentContext.getResponse().setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
                        return null;
                    }
                }
            }
        } catch (Exception e) {
            log.error("LoginCheckInterceptor出现异常", e);
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(HttpStatus.BAD_REQUEST.value());
            currentContext.setResponseBody(JSONObject.toJSONString(ResponseMessage.error(ResultCode.SYSTEM_BUSY)));
            currentContext.getResponse().setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            return null;
        }
        return null;
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
