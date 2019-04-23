package com.gndc.demo.client;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author <a href="jingkaihui@adpanshi.com">jingkaihui</a>
 * @Description
 * @date 2019/4/23
 */
@FeignClient(name = "gndc-demo")
public interface DemoClient {


}
