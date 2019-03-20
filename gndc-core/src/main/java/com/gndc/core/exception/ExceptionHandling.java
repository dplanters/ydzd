package com.gndc.core.exception;

import com.alibaba.fastjson.JSONObject;
import com.gndc.common.enums.ResultCode;
import com.gndc.common.exception.ProblemMarker;
import com.gndc.core.api.common.ResponseMessage;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Iterator;
import java.util.Set;

@ControllerAdvice
public class ExceptionHandling {

    @ResponseBody
    @ExceptionHandler
    public ResponseMessage handler(Throwable e) {
        //处理异常
        ResponseMessage<Object> response = new ResponseMessage<>();
        response.setSuccess(false);
        Integer code = ResultCode.ERROR.getCode();
        String msg = ResultCode.ERROR.getI18NContent();
        if (e instanceof ConstraintViolationException) {
            Set<ConstraintViolation<?>> constraintViolations = ((ConstraintViolationException) e).getConstraintViolations();
            Iterator<ConstraintViolation<?>> it = constraintViolations.iterator();
            JSONObject jsonObject = new JSONObject();
            while (it.hasNext()) {
                ConstraintViolation<?> next = it.next();
                jsonObject.fluentPut(next.getPropertyPath().toString(), next.getMessage());
            }
            msg = jsonObject.toJSONString();
        }
        if (e instanceof ProblemMarker) {
            code = ((ProblemMarker) e).getCode();
            msg = ((ProblemMarker) e).getMsg();
        }
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }
}
