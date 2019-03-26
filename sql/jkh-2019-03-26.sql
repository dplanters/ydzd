#逻辑删和业务状态分离
ALTER TABLE `dc_admin` MODIFY COLUMN `status`  tinyint(4) NOT NULL DEFAULT 1 COMMENT '状态  1：正常；0：删除' AFTER `role_id`;
ALTER TABLE `dc_common_question` MODIFY COLUMN `status`  tinyint(4) NULL DEFAULT 1 COMMENT '状态  1：正常；0：删除' AFTER
`answer`;
ALTER TABLE `dc_dict`
MODIFY COLUMN `status`  tinyint(4) NOT NULL DEFAULT 1 COMMENT '状态  1：正常；0：删除' AFTER `supper_value`;
ALTER TABLE `dc_event_fee`
MODIFY COLUMN `status`  tinyint(2) NOT NULL DEFAULT 1 COMMENT '状态  1：正常；0：删除' AFTER `fee_status`;
ALTER TABLE `dc_message_info`
MODIFY COLUMN `status`  tinyint(4) NOT NULL DEFAULT 1 COMMENT '状态  1：正常；0：删除' AFTER `content`;
ALTER TABLE `dc_message_template`
MODIFY COLUMN `status`  tinyint(4) NOT NULL DEFAULT 1 COMMENT '状态  1：正常；0：删除' AFTER `content`;

ALTER TABLE `dc_operation_advertis`
CHANGE COLUMN `status` `advertis_status`  tinyint(4) NOT NULL DEFAULT 1 COMMENT '广告状态  1未上线;2上线;-1下线' AFTER `advertis_type`,
CHANGE COLUMN `is_del` `status`  tinyint(4) NOT NULL DEFAULT 1 COMMENT '状态  1：正常；0：删除' AFTER `advertis_status`;

ALTER TABLE `dc_operation_banner`
CHANGE COLUMN `is_del` `status`  tinyint(4) NOT NULL DEFAULT 1 COMMENT '状态  1：正常；0：删除' AFTER `title`,
ADD COLUMN `banner_status`  tinyint(4) NOT NULL DEFAULT 1 COMMENT '广告状态  1未上线;2上线;-1下线' AFTER `title`;

ALTER TABLE `dc_partner`
MODIFY COLUMN `status`  tinyint(2) NOT NULL DEFAULT 1 COMMENT '状态  1：正常；0：删除' AFTER `update_time`;

ALTER TABLE `dc_partner_account_log`
MODIFY COLUMN `status`  tinyint(2) NOT NULL DEFAULT 1 COMMENT '状态  1：正常；0：删除' AFTER `update_time`;

ALTER TABLE `dc_partner_api`
MODIFY COLUMN `status`  tinyint(2) NOT NULL DEFAULT 1 COMMENT '状态  1：正常；0：删除' AFTER `update_time`;

ALTER TABLE `dc_partner_contact`
MODIFY COLUMN `status`  tinyint(2) NOT NULL DEFAULT 1 COMMENT '状态  1：正常；0：删除' AFTER `position`;

ALTER TABLE `dc_product`
CHANGE COLUMN `status` `product_status`  tinyint(4) NOT NULL DEFAULT 1 COMMENT '状态  1未上线;2上线;-1下线' AFTER `fixed_sort_type`,
CHANGE COLUMN `is_del` `status`  tinyint(4) NOT NULL DEFAULT 1 COMMENT '状态  1：正常；0：删除' AFTER `product_status`;

ALTER TABLE `dc_product_data`
MODIFY COLUMN `status`  tinyint(4) NOT NULL DEFAULT 1 COMMENT '状态  1：正常；0：删除' AFTER `answer`;

ALTER TABLE `dc_product_hot`
CHANGE COLUMN `status` `hot_status`  tinyint(4) NOT NULL DEFAULT 1 COMMENT '热推状态  1未上线;2上线;-1下线' AFTER `product_name`;

ALTER TABLE `dc_product_interface`
MODIFY COLUMN `status`  tinyint(4) NOT NULL DEFAULT  1 COMMENT '状态  1：正常；0：删除' AFTER `update_time`;

ALTER TABLE `dc_right`
MODIFY COLUMN `right_status` `status`  tinyint(4) NOT NULL DEFAULT 1 COMMENT '状态  1：正常；0：删除' AFTER `id`;

ALTER TABLE `dc_role`
MODIFY COLUMN `status`  tinyint(1) NOT NULL DEFAULT 1 COMMENT '状态  1：正常；0：删除' AFTER `platform`;

ALTER TABLE `dc_sign_template_union`
MODIFY COLUMN `status`  tinyint(2) NOT NULL DEFAULT 1 COMMENT '状态  1：正常；0：删除' AFTER `template_id`;

ALTER TABLE `dc_sms_channel`
MODIFY COLUMN `status`  tinyint(2) NOT NULL DEFAULT 1 COMMENT '状态  1：正常；0：删除' AFTER `name`;

ALTER TABLE `dc_sms_condition`
CHANGE COLUMN `is_del` `status`  tinyint(2) NULL DEFAULT 1 COMMENT '状态  1：正常；0：删除' AFTER `create_admin_id`;

ALTER TABLE `dc_sms_sign`
MODIFY COLUMN `status`  tinyint(2) NOT NULL DEFAULT 1 COMMENT '状态  1：正常；0：删除' AFTER `name`;

ALTER TABLE `dc_sms_template`
MODIFY COLUMN `status`  tinyint(4) NOT NULL DEFAULT 1 COMMENT '状态  1：正常；0：删除' AFTER `content`;

ALTER TABLE `dc_system_schedule_job`
CHANGE COLUMN `is_del` `status`  tinyint(2) NOT NULL DEFAULT 1 COMMENT '状态  1：正常；0：删除' AFTER `job_group`;

ALTER TABLE `dc_user`
CHANGE COLUMN `status` `user_status`  tinyint(4) NOT NULL DEFAULT '-1' COMMENT '状态 -1未绑定手机号；1未填完资料;2已填写资料' AFTER `last_logout_time`;

ALTER TABLE `dc_user_collection`
MODIFY COLUMN `status`  tinyint(4) NOT NULL DEFAULT 1 COMMENT '状态  1：正常；0：删除' AFTER `remark`;

ALTER TABLE `dc_user_feedback`
CHANGE COLUMN `status` `feedback_status`  tinyint(4) NOT NULL DEFAULT -1 COMMENT '状态1 已回复；2已处理; -1未处理' AFTER `reply_content`;

ALTER TABLE `dc_user_message`
CHANGE COLUMN `status` `message_status`  tinyint(4) NOT NULL DEFAULT 1 COMMENT '状态 1已发送；2已查看' AFTER `message`;
















































