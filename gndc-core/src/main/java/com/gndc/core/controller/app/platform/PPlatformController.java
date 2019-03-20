package com.gndc.core.controller.app.platform;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gndc.common.enums.common.DelEnum;
import com.gndc.core.api.app.platform.PPlatformBaseInfoRequest;
import com.gndc.core.api.common.CommonRequest;
import com.gndc.core.api.common.ResponseMessage;
import com.gndc.core.model.CommonQuestion;
import com.gndc.core.model.SystemOption;
import com.gndc.core.service.platform.CommonQuestionService;
import com.gndc.core.service.sys.SystemOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.weekend.Weekend;

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

        PageInfo page = request.getHeader().getPage();
        PageHelper.startPage(page.getPageNum(), page.getPageSize());

        CommonQuestion question = new CommonQuestion();

        Weekend<CommonQuestion> weekend = Weekend.of(CommonQuestion.class);
        weekend.selectProperties("title", "answer");
        weekend.weekendCriteria()
                .andEqualTo(CommonQuestion::getStatus, DelEnum.NORMAL.getCode());
        List<CommonQuestion> commonQuestions = commonQuestionService.selectByExample(weekend);

        PageInfo<CommonQuestion> pageInfo = new PageInfo<>(commonQuestions);

        pageInfo.setList(null);
        response.setPage(pageInfo);
        response.setData(commonQuestions);
        return response;
    }
}
