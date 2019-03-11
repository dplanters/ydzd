/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.core.api.customerservice;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;

/**
 * @author <a href="biankongbin8418@adpanshi.com">biankongbin</a>
 * @version V1.0.1
 * @Description
 * @date 2018年6月7日 下午6:04:02
 */
public class UserCallRecordRequest extends RequestMessage {

    /**
     * @Fields serialVersionUID:
     */
    private static final long serialVersionUID = 5924550455033489782L;

    private int id;

    /**
     * 用户电话
     */
    private String userPhone;

    private String userName;
    /**
     * 是否注册 1：是 -1不是
     */
    private byte userIsRegist;

    private int adminId;

    private String adminName;
    /**
     * 问题是否解决 1：是 -1：不是
     */
    private byte isSolve;

    private String updateStartTime;

    private String updateEndTime;

    /**
     * 问题
     */
    private String question;
    /**
     * 回答
     */
    private String answer;

    /**
     * @return question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * @param question 要设置的 question
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * @return answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * @param answer 要设置的 answer
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.A_MY_CUSTOMER_USER_CALL_RECORD);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public byte getUserIsRegist() {
        return userIsRegist;
    }

    public void setUserIsRegist(byte userIsRegist) {
        this.userIsRegist = userIsRegist;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public byte getIsSolve() {
        return isSolve;
    }

    public void setIsSolve(byte isSolve) {
        this.isSolve = isSolve;
    }

    public String getUpdateStartTime() {
        return updateStartTime;
    }

    public void setUpdateStartTime(String updateStartTime) {
        this.updateStartTime = updateStartTime;
    }

    public String getUpdateEndTime() {
        return updateEndTime;
    }

    public void setUpdateEndTime(String updateEndTime) {
        this.updateEndTime = updateEndTime;
    }

}
