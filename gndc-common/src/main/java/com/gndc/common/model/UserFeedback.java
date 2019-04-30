package com.gndc.common.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Table(name = "dc_user_feedback")
public class UserFeedback extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;

    private String userPhone;

    private String content;

    private Integer adminId;

    private Date replyTime;

    private String replyContent;

    private Byte feedbackStatus;

    private String pictureUrl;

}