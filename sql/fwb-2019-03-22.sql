#add by fwb at 2019-3-22#
ALTER TABLE `gndc`.`dc_partner`
ADD COLUMN `app_id` varchar(32) NULL COMMENT '机构应用ID',
ADD COLUMN `public_key` varchar(2048) NULL COMMENT '机构公钥';


#add by fwb at 2019-3-22#
CREATE TABLE `dc_partner_api` (
  `id` int(11) NOT NULL,
  `partner_id` int(11) NOT NULL COMMENT '机构id',
  `api_url` varchar(32) NOT NULL COMMENT '接口地址',
  `api_type` int(30) NOT NULL COMMENT '接口类型',
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `status` tinyint(2) NOT NULL COMMENT '状态：1 正常； -1删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


#add by fwb at 2019-3-22#
ALTER TABLE `gndc`.`dc_user`
ADD COLUMN `id_card` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '身份证';