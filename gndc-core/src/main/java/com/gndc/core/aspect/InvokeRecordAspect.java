package com.gndc.core.aspect;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 *
 */
@Aspect
@Component
@Slf4j
public class InvokeRecordAspect {

    // 申明一个切点 里面是 execution表达式
    @Pointcut("execution(public * com.gndc.core.controller.*.*.*.*(..))")
    private void controllerAspect() {
    }

    // 请求method前打印内容
    @Before(value = "controllerAspect()")
    public void methodBefore(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        log.info("===============请求内容===============");
        try {
            // 打印请求内容
            log.info("请求地址:" + request.getRequestURL().toString());
            log.info("请求方式:" + request.getMethod());
            log.info("请求类方法:" + joinPoint.getSignature());
            log.info("请求类方法参数:" + JSONObject.toJSONString(joinPoint.getArgs(), new SimplePropertyPreFilter() {
                @Override
                public boolean apply(JSONSerializer serializer, Object object, String name) {
                    return !StrUtil.containsAnyIgnoreCase(name, "rights");
                }
            }));
        } catch (Exception e) {
            log.error("###LogAspectServiceApi.class methodBefore() ### ERROR:", e);
        }
        log.info("===============请求内容===============");
    }

    // 在方法执行完结后打印返回内容
    @AfterReturning(returning = "o", pointcut = "controllerAspect()")
    public void methodAfterReturning(Object o) {
        log.info("--------------返回内容----------------");
        try {
            log.info("Response内容:" + JSONObject.toJSONString(o));
        } catch (Exception e) {
            log.error("###LogAspectServiceApi.class methodAfterReturning() ### ERROR:", e);
        }
        log.info("--------------返回内容----------------");
    }
}
