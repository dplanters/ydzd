alter table dc_sms_template modify column type tinyint(2) comment '类型 0-未定义 1-营销类 2-催收类 3-提醒类 4-通知类';
alter table dc_sms_template modify column sign_id int(11) DEFAULT 0 comment '签名ID';
alter table dc_sms_template add create_admin_id int(11) DEFAULT NULL COMMENT '创建者id';

#add by jkh 2019-03-25
alter table dc_right add column right_path varchar(255) not null default '' comment '请求路径';
alter table dc_right modify column right_url varchar(255) not null default '' comment '前端路径';
alter table dc_right modify column right_pic varchar(255) not null default '' comment '图标';
alter table dc_right add column component varchar(64) not null default '' comment '前端页面';
alter table dc_right add column platform tinyint(4) not null default 1 comment '平台：1：公共；2：运营后台；3：商户后台；4：App；';
alter table dc_right add column require_auth tinyint(1) not null default 1 comment '是否需要授权：1：需要：0：不需要';
alter table dc_right add column right_visible tinyint(1) not null default 1 comment '权限是否可见：1：可见；0：不可见';
alter table dc_right add column remark varchar(255) not null default '' comment '备注';
alter table dc_right change supper_id super_id int(11);
alter table dc_right modify right_level tinyint(4) not null default 1 comment '权限级别(如一级菜单/权限为1，二级菜单/权限为2以此类推)';
alter table dc_role modify column status tinyint(1) not null default 1 comment '状态 1正常 -1删除';
alter table dc_role add column platform tinyint(4) not null default 2 comment '平台：1：公共；2：运营后台；3：商户后台；4：App';
alter table dc_admin change level platform tinyint(4) comment '平台：1：公共；2：运营后台；3：商户后台；4：App；';
