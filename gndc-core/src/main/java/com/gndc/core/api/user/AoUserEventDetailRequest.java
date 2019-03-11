package com.gndc.core.api.user;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;

/**
 * Description: 用户详情（用户行为）
 * User: chenzuozhou
 * Date: 2019-03-06
 * Time: 下午8:58
 */
public class AoUserEventDetailRequest extends RequestMessage {


    private static final long serialVersionUID = -2438451765137242563L;
    /**
     * 用户ID
     */
    private int userId;

    /**
     * 事件开始时间
     */
    private String eventDateBegin;
    /**
     * 事件结束时间
     */
    private String eventDateEnd;

    public String getEventDateBegin() {
        return eventDateBegin;
    }

    public void setEventDateBegin(String eventDateBegin) {
        this.eventDateBegin = eventDateBegin;
    }

    public String getEventDateEnd() {
        return eventDateEnd;
    }

    public void setEventDateEnd(String eventDateEnd) {
        this.eventDateEnd = eventDateEnd;
    }

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.AO_USER_EVENT_DETAIL);
    }

    /**
     * @return userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId 要设置的 userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

}
