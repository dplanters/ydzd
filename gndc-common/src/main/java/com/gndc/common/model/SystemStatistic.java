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
@Table(name = "dc_sys_statistic")
public class SystemStatistic extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer historyUser;

    private Integer historyActiveUser;

    private Integer historyLostUser;

    private Integer historyDownloads;

    private Integer historyInstall;

    private Integer todayNewUser;

    private Integer todayActiveUser;

    private Integer todayLostUser;

    private Integer todayNewDownloads;

    private Integer todayNewInstall;

    private Date statisticDate;

}