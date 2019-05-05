/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.admin.service.settlement;

import com.gndc.common.api.admin.settlement.SettlementRecordInfoRequest;
import com.gndc.common.dto.SettlementRecordInfoDTO;
import com.gndc.common.model.Settlement;
import com.gndc.common.service.BaseService;

import java.util.List;

/**
 * @author <a href="liujun8852@adpanshi.com">liujun</a>
 * @version V1.0.1
 * @Description
 * @date 2019/5/5  11:26
 */
public interface SettlementService extends BaseService<Settlement,Integer> {

    /**
     * @Description
     * @param time yyyy 格式
     * @author <a href="liujun8852@adpanshi.com">liujun</a>
     */
    List<Settlement> sumFeeByCreateTimeGroupSettlementMode(String time);

    /**
     * @Description
     * @param time yyyy-MM 格式
     * @author <a href="liujun8852@adpanshi.com">liujun</a>
     */
    Integer countByCreateTime(String time);

    /**
     * @Description
     * @param param
     * @author <a href="liujun8852@adpanshi.com">liujun</a>
     */
    List<SettlementRecordInfoDTO> selectRecordInfoPage(SettlementRecordInfoRequest param);


}
