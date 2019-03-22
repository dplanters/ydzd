alter table dc_sms_template modify column type tinyint(2) comment '类型 0-未定义 1-营销类 2-催收类 3-提醒类 4-通知类';
alter table dc_sms_template add create_admin_id int(11) DEFAULT NULL COMMENT '创建者id';