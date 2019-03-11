package com.gndc.core.api.question;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;

/**
 * @author <a href="limengwu8493@adpanshi.com">limengwu</a>
 * @version V1.0.1
 * @date 2018-06-08 11:10
 */
public class QuestionListRequest extends RequestMessage {

    private static final long serialVersionUID = 1L;

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.QUESTION_LIST);
    }

}
