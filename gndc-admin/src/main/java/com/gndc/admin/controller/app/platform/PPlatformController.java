package com.gndc.admin.controller.app.platform;

import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gndc.common.api.ResponseMessage;
import com.gndc.common.enums.common.StatusEnum;
import com.gndc.admin.api.app.platform.PAppExceptionUploadRequest;
import com.gndc.admin.api.app.platform.PPlatformBaseInfoRequest;
import com.gndc.admin.api.common.CommonRequest;
import com.gndc.admin.api.common.CommonResponse;
import com.gndc.common.model.AppException;
import com.gndc.common.model.CommonQuestion;
import com.gndc.common.model.SystemOption;
import com.gndc.admin.service.platform.AppExceptionService;
import com.gndc.admin.service.platform.CommonQuestionService;
import com.gndc.admin.service.sys.SystemOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.weekend.Weekend;

import java.util.Date;
import java.util.List;

/**
 * 客户端平台相关
 */
@RestController
@RequestMapping("/app/platform")
public class PPlatformController {

    @Autowired
    private SystemOptionService systemOptionService;

    @Autowired
    private CommonQuestionService commonQuestionService;

    @Autowired
    private AppExceptionService appExceptionService;

    /**
     * 微信公众号、客服电话、微信客服获取
     *
     * @param platformBaseInfoRequest
     * @return
     */
    @PostMapping("/baseInfo")
    public ResponseMessage<SystemOption> baseInfo(@Validated @RequestBody PPlatformBaseInfoRequest platformBaseInfoRequest) {
        ResponseMessage<SystemOption> response = new ResponseMessage<>();
        SystemOption systemOption = new SystemOption();
        String infoType = platformBaseInfoRequest.getInfoType();

        // 查找系统配置
        Weekend<SystemOption> weekend = Weekend.of(SystemOption.class);
        weekend.selectProperties("optionKey", "optionValue");
        weekend.weekendCriteria()
                .andEqualTo(SystemOption::getOptionKey, infoType);
        List<SystemOption> systemOptions = systemOptionService.selectByExample(weekend);
        if (systemOptions != null && systemOptions.size() > 0) {
            systemOption = systemOptions.get(0);
        }
        response.setData(systemOption);
        return response;
    }

    /**
     * 常见问题
     *
     * @param request
     * @return
     */
    @PostMapping("/commonQuestion")
    public ResponseMessage<List<CommonQuestion>> commonQuestion(@Validated @RequestBody CommonRequest request) {
        ResponseMessage<List<CommonQuestion>> response = new ResponseMessage<>();

        PageHelper.startPage(request.getPageNum(), request.getPageSize());

        CommonQuestion question = new CommonQuestion();

        Weekend<CommonQuestion> weekend = Weekend.of(CommonQuestion.class);
        weekend.selectProperties("title", "answer");
        weekend.weekendCriteria()
                .andEqualTo(CommonQuestion::getStatus, StatusEnum.NORMAL.getCode());
        List<CommonQuestion> commonQuestions = commonQuestionService.selectByExample(weekend);

        PageInfo<CommonQuestion> pageInfo = new PageInfo<>(commonQuestions);

        pageInfo.setList(null);
        response.setPage(pageInfo);
        response.setData(commonQuestions);
        return response;
    }

    /**
     * APP端异常保存
     *
     * @param request
     * @return
     */
    @PostMapping("/appExceptionSave")
    public ResponseMessage<CommonResponse> appExceptionSave(@Validated @RequestBody PAppExceptionUploadRequest request) {
        ResponseMessage<CommonResponse> response = new ResponseMessage<>();
        AppException appException = new AppException();

        Date now = DateUtil.date().toJdkDate();
        appException.setCreateTime(now);
        appException.setSessionId(request.getHeader().getSessionId());
        appException.setException(request.getException());
        appException.setDeviceAndVersion(request.getDeviceAndVersionInfo());
        appException.setUserId(request.getPUser().getId());
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setResult(appExceptionService.insertSelective(appException));
        return response.setData(commonResponse);
    }
}
