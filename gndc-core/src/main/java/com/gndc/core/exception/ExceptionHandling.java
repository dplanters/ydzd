package com.gndc.core.exception;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gndc.common.enums.ResultCode;
import com.gndc.common.exception.HjException;
import com.gndc.core.api.common.ResponseMessage;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler
    public ResponseMessage handler(Throwable e) {
        //处理异常
        ResponseMessage<Object> response = new ResponseMessage<>();
        response.setSuccess(false);
        Integer code = ResultCode.SYSTEM_BUSY.getCode();
        String msg = ResultCode.SYSTEM_BUSY.getI18NContent();
        if (e instanceof MethodArgumentNotValidException) {
            List<ObjectError> allErrors = ((MethodArgumentNotValidException) e).getBindingResult().getAllErrors();
            JSONArray jsonArray = new JSONArray();
            for (ObjectError error : allErrors) {
                String field = ((FieldError) error).getField();
                String defaultMessage = error.getDefaultMessage();
                jsonArray.fluentAdd(new JSONObject().fluentPut(field, defaultMessage));
            }
        }
        if (e instanceof HjException) {
            code = ((HjException) e).getCode();
            msg = ((HjException) e).getMsg();
        }
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }
}
