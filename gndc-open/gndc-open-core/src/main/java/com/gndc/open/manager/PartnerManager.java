package com.gndc.open.manager;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.asymmetric.SignAlgorithm;
import cn.hutool.http.HttpException;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.gndc.common.api.ResponseMessage;
import com.gndc.common.enums.ResultCode;
import com.gndc.common.exception.HjException;
import com.gndc.common.utils.PwdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author <a href="jingkaihui@adpanshi.com">jingkaihui</a>
 * @Description 用来跟机构对接的请求管理类
 * @date 2019/4/27
 */
@Slf4j
@Component
public class PartnerManager {

    /**
     * 根据请求地址及参数请求机构接口
     *
     * @return
     */
    public ResponseMessage post(String url, JSONObject params) {
        ResponseMessage<Object> response;
        //签名
        sign(params);
        try {
            String post = HttpUtil.post(url, JSONObject.toJSONString(params));
            response = JSONObject.parseObject(post, ResponseMessage.class);
        } catch (HttpException e) {
            log.error("网络故障", e);
            throw new HjException(ResultCode.HTTP_EXCEPTION);
        }
        return response;
    }

    /**
     * 对参数进行签名
     * @param params
     */
    private void sign(JSONObject params) {
        params.fluentPut("algorithm", SignAlgorithm.MD5withRSA);
        params.fluentPut("timestamp", DateUtil.date().getTime());
        params.put("randomStr", RandomUtil.randomString(10));
        String sign = PwdUtil.sign(params);
        params.fluentPut("sign", sign);
    }
}
