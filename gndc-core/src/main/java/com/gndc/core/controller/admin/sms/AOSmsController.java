package com.gndc.core.controller.admin.sms;

import com.gndc.core.api.admin.sms.AOSmsStatisticsRequest;
import com.gndc.core.api.admin.sms.AOSmsStatisticsResponse;
import com.gndc.core.api.common.ResponseMessage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 短信管理
 */
@RestController
@RequestMapping("/admin/smsManage")
public class AOSmsController {

    @RequestMapping("/Statistics")
    public ResponseMessage<List<AOSmsStatisticsResponse>> Statistics(@RequestBody AOSmsStatisticsRequest request) {
        ResponseMessage<List<AOSmsStatisticsResponse>> response = new ResponseMessage<>();


        response.setData(null);
        return response;
    }



}
