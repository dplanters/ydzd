package com.gndc.core.aspect;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.gndc.common.enums.ResultCode;
import com.gndc.common.exception.HjException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 用于打印方法执行前参数及执行后的结果
 */
@Aspect
@Component
@Slf4j
public class InvokeRecordAspect {

    /**
     *
     * 申明一个切点 里面是 execution表达式
     */
    @Pointcut("execution(public * com.gndc.core.controller.*.*.*.*(..))")
    private void controllerAspect() {
    }

    @ResponseBody
    @Around("controllerAspect()")
    public Object isAccessMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        Object result;
        try {
            log.info("<------请求内容------");
            // 打印请求内容
            log.info("请求地址:" + request.getRequestURL().toString());
            log.info("请求方式:" + request.getMethod());
            log.info("请求类方法:" + joinPoint.getSignature());
            Object[] args = joinPoint.getArgs();
            log.info("请求类方法参数:" + JSONObject.toJSONString(args, new SimplePropertyPreFilter() {
                @Override
                public boolean apply(JSONSerializer serializer, Object object, String name) {
                    return !StrUtil.containsAnyIgnoreCase(name, "rights");
                }
            }));
            log.info("<------请求内容------");

            result = joinPoint.proceed(args);

            log.info("------返回内容------>");
            try {
                log.info("Response内容:" + JSONObject.toJSONString(result));
            } catch (Exception e) {
                log.error("###LogAspectServiceApi.class methodAfterReturning() ### ERROR:", e);
            }
            log.info("------返回内容------>");
        } catch (Exception e) {
            log.error("参数打印失败", e);
            throw new HjException(ResultCode.SYSTEM_BUSY);
        }
        return result;
    }

}
