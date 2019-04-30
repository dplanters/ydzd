package com.gndc.open.manager;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.gndc.common.utils.PwdUtil;
import com.gndc.core.client.PartnerClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author <a href="jingkaihui@adpanshi.com">jingkaihui</a>
 * @Description 用来跟机构对接的请求管理类
 * @date 2019/4/27
 */
@Slf4j
@Component
public class PartnerManager {

    @Autowired
    private PartnerClient partnerClient;

    /**
     * 判断用户是否可以申请产品
     *
     * @return
     */
    public JSONObject userJudge(String url, Map<String, Object> params) {

        params.put("algorithm", "MD5withRSA");
        String sign = PwdUtil.sign(params);
        params.put("sign", sign);
        try {
            String post = HttpUtil.post(url, JSONObject.toJSONString(params));
            JSONObject postResponse = JSONObject.parseObject(post);
            boolean success = postResponse.getBooleanValue("success");
            if (success) {
                JSONObject data = postResponse.getJSONObject("data");
                if (data.getBooleanValue("loanable")) {
                    //可以贷款
                    log.info("可以贷款");
                    //修改订单状态
                } else {
                    //不可以贷款
                    log.warn("不可以贷款:原因{}", data.getString("reason"));
                }
            }
        } catch (Exception e) {
            log.error("网络故障");
        }
        return null;
    }
}
