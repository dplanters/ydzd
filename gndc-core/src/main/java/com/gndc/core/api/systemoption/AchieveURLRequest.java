package com.gndc.core.api.systemoption;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;

/**
 * Description: 获取接口请求地址
 * User: chenzuozhou
 * Date: 2019-02-26
 * Time: 下午8:19
 */
public class AchieveURLRequest extends RequestMessage {

    /**
     * @Fields serialVersionUID:
     */
    private static final long serialVersionUID = 1L;

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.U_ACHIEVE_URL);
    }
}
