package com.gndc.gateway.filter;

import com.alibaba.fastjson.JSONObject;
import com.gndc.common.api.ResponseMessage;
import com.gndc.common.constant.CacheConstant;
import com.gndc.common.dto.RightInfoDTO;
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

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author <a href="jingkaihui@adpanshi.com">jingkaihui</a>
 * @Description 根据权限表中的记录对当前请求进行标记，标记是否需要授权才能访问
 * @date 2019/4/17
 */
@Slf4j
@Component
public class OpenSourceMarkFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 20;
    }

    @Override
    public boolean shouldFilter() {
        Object innerNet = RequestContext.getCurrentContext().get("innerNet");
        return !innerNet.equals(true);
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        boolean requireAuth = true;
        boolean noHandler = true;
        RedisTemplate redisTemplate;
        try {
            try {
                redisTemplate =
                        (RedisTemplate) BeanFactoryUtil.getBean(
                                "redisTemplate");
            } catch (Exception e) {
                log.error("获取redisTemplate出现异常", e);
                //不进行路由
                currentContext.setSendZuulResponse(false);
                currentContext.setResponseStatusCode(HttpStatus.BAD_REQUEST.value());
                currentContext.setResponseBody(JSONObject.toJSONString(ResponseMessage.error()));
                currentContext.getResponse().setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
                return null;
            }

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
                    break;
                }
            }
            //对不需要授权的请求添加requireAuth标志
            currentContext.set("requireAuth", requireAuth);

            //对权限表中还没有配置的权限进行标记
            currentContext.set("noHandler", noHandler);
        } catch (Exception e) {
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(HttpStatus.BAD_REQUEST.value());
            currentContext.setResponseBody(JSONObject.toJSONString(ResponseMessage.error()));
            currentContext.getResponse().setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            return null;
        }
        return null;
    }
}
