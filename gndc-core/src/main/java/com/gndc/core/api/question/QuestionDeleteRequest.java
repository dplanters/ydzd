package com.gndc.core.api.question;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;

/**
 * @author <a href="limengwu8493@adpanshi.com">limengwu</a>
 * @version V1.0.1
 * @date 2018-06-07 14:18
 */
public class QuestionDeleteRequest extends RequestMessage {

    /**
     * @Fields serialVersionUID:
     */
    private static final long serialVersionUID = 1L;

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.QUESTION_DELETE);
    }
}
