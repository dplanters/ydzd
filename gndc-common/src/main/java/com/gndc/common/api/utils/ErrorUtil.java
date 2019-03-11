package com.gndc.common.api.utils;

import com.gndc.common.api.*;

/**
 * @author <a href="junhui@sunnyhanmy.com">changjunhui</a>
 * @version V1.0.1
 * @Description
 * @date 2017年5月25日 上午10:24:08
 */
public class ErrorUtil {

    // @SuppressWarnings("rawtypes")
    // public static ResponseMessage createError(Header reqhHeader, ResultCode
    // error) {
    // // 组装错误应答报文
    // Header header = new Header(reqhHeader);
    // header.setCode(error.getCode());
    // header.setMsg(error.getDesc());
    // ResponseMessage message = new ResponseMessage();
    // message.createHeader(header);
    // return message;
    // }

    /**
     * @param request
     * @param error
     * @return
     * @Description 错误结果封装
     * @author <a href="junhui@sunnyhanmy.com">changjunhui</a>
     */
    @SuppressWarnings("rawtypes")
    public static ResponseMessage createError(RequestMessage request, ResultCode error) {
        if (request.getHeader() == null) {
            request.createHeader();
        }
        ResponseMessage message = new ResponseMessage(request);
        message.createError(error);
        return message;
    }

    /**
     * @param request
     * @param errorCode
     * @param errorMsg
     * @return
     * @Description 错误结果封装
     * @author <a href="junhui@sunnyhanmy.com">changjunhui</a>
     */
    @SuppressWarnings("rawtypes")
    public static ResponseMessage createError(RequestMessage request, HjException ex) {
        if (request.getHeader() == null) {
            request.createHeader();
        }

        ResponseMessage message = new ResponseMessage(request);
        Header header = message.getHeader();
        header.setCode(ex.getErrorCode());
        header.setMsg(ex.getMessage());
        header.setMsgExt(ex.getMsgExt());
        message.createError(header);
        return message;
    }
}
