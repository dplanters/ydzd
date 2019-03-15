package com.gndc.core.controller.app.platform;

import com.gndc.common.enums.system.SystemOptionEnum;
import com.gndc.core.api.app.platform.PPlatformBaseInfoRequest;
import com.gndc.core.api.common.ResponseMessage;
import com.gndc.core.model.SystemOption;
import com.gndc.core.service.sys.SystemOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.weekend.Weekend;

import java.util.List;

/**
 * 平台相关
 */
@RestController
@RequestMapping("/platform")
public class PPlatformController {

    @Autowired
    private SystemOptionService systemOptionService;

    /**
     * 微信公众号、客服电话、微信客服获取
     *
     * @param platformBaseInfoRequest
     * @return
     */
    @RequestMapping("/baseInfo")
    public ResponseMessage<SystemOption> baseInfo(PPlatformBaseInfoRequest platformBaseInfoRequest) {
        ResponseMessage<SystemOption> response = new ResponseMessage<>();
        SystemOption systemOption = new SystemOption();
        String infoType = platformBaseInfoRequest.getInfoType();

        // 查找系统配置
        Weekend<SystemOption> weekend = Weekend.of(SystemOption.class);
        weekend.selectProperties("optionKey", "optionValue");
        weekend.weekendCriteria()
                .andEqualTo(SystemOption::getOptionKey, infoType);
        List<SystemOption> systemOptions = systemOptionService.selectByExample(weekend);
        if(systemOptions != null && systemOptions.size() > 0){
            systemOption = systemOptions.get(0);
        }
        response.setData(systemOption);
        return response;
    }
}
