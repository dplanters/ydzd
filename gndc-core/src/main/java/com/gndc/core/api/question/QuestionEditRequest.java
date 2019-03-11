package com.gndc.core.api.question;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;

/**
 * @author <a href="limengwu8493@adpanshi.com">limengwu</a>
 * @version V1.0.1
 * @date 2018-06-07 14:18
 */
public class QuestionEditRequest extends RequestMessage {

    private static final long serialVersionUID = 1L;

    private int id;
    // 标题
    private String title;
    // 内容
    private String answer;

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.QUESTION_EDIT);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
