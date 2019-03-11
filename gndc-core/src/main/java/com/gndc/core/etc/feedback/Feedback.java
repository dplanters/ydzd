package com.gndc.core.etc.feedback;

import com.alibaba.fastjson.annotation.JSONField;
import com.gndc.common.utils.DateUtil;

import java.util.Date;

public class Feedback {
    /**
     *
     */
    private int id;

    /**
     * 微信号
     */
    private String openId;

    /**
     * 手机号
     */
    private String phone;
    /**
     * 留言内容
     */
    private String content;

    /**
     * 用户ID
     */
    private int userId;

    private int adminId;

    private String adminName;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date replyTime;

    private String replyContent;

    private byte status;

    // 图片URL
    private String feedbackPicture;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return adminId
     */
    public int getAdminId() {
        return adminId;
    }

    /**
     * @param adminId 要设置的 adminId
     */
    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    /**
     * @return adminName
     */
    public String getAdminName() {
        return adminName;
    }

    /**
     * @param adminName 要设置的 adminName
     */
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    /**
     * @return replyTime
     */
    public Date getReplyTime() {
        return replyTime;
    }

    /**
     * @param replyTime 要设置的 replyTime
     */
    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    /**
     * @return replyContent
     */
    public String getReplyContent() {
        return replyContent;
    }

    /**
     * @param replyContent 要设置的 replyContent
     */
    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    /**
     * @return status
     */
    public byte getStatus() {
        return status;
    }

    /**
     * @param status 要设置的 status
     */
    public void setStatus(byte status) {
        this.status = status;
    }

    /**
     * @return feedbackPicture
     */
    public String getFeedbackPicture() {
        return feedbackPicture;
    }

    /**
     * @param feedbackPicture 要设置的 feedbackPicture
     */
    public void setFeedbackPicture(String feedbackPicture) {
        this.feedbackPicture = feedbackPicture;
    }

    /**
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime 要设置的 createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime 要设置的 updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    // 处理日期
    public String getStrCreateTime() {
        return DateUtil.timeToString(this.createTime, DateUtil.FORMAT_2);
    }

    public String getStrReplyTime() {
        return DateUtil.timeToString(this.replyTime, DateUtil.FORMAT_2);
    }

}