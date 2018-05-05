/*
Navicat MySQL Data Transfer

Source Server         : 10.0.20.108
Source Server Version : 50714
Source Host           : 10.0.20.108:3306
Source Database       : DB_MANAGER

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2018-05-05 19:35:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user_demo`
-- ----------------------------
DROP TABLE IF EXISTS `user_demo`;
CREATE TABLE `user_demo` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) NOT NULL COMMENT '姓名',
  `mobile` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `age` int(4) NOT NULL COMMENT '年龄',
  `delete_flag` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标识 0正常 1删除',
  `created_at` timestamp NOT NULL COMMENT '创建时间',
  `created_by` varchar(16) NOT NULL COMMENT '创建人',
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `updated_by` varchar(16) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniqx_mobile` (`mobile`) USING BTREE,
  KEY `idx_name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_demo
-- ----------------------------
INSERT INTO `user_demo` VALUES ('1', '王辉', '15698321256', '32', '0', '2018-05-05 17:19:48', '王敏', null, null);
INSERT INTO `user_demo` VALUES ('2', '李亚鹏', '13689561256', '20', '0', '2018-05-05 17:20:12', '王敏', '2018-05-05 19:14:24', null);
INSERT INTO `user_demo` VALUES ('3', '李晓军', '18965324569', '38', '0', '2018-05-05 17:20:37', '王敏', null, null);
INSERT INTO `user_demo` VALUES ('4', '王伟', '18965324069', '31', '0', '2018-05-05 17:21:38', '王敏', null, null);
INSERT INTO `user_demo` VALUES ('5', '胡明', '15689452389', '22', '0', '2018-05-05 19:17:59', '王敏', '2018-05-05 19:27:51', null);
INSERT INTO `user_demo` VALUES ('6', '黄秋巧', '15689452889', '18', '0', '2018-05-05 19:21:58', '王敏', '2018-05-05 19:30:28', null);
INSERT INTO `user_demo` VALUES ('7', '李白凤', '15869368956', '18', '0', '2018-05-05 19:30:56', '李凤', null, null);
INSERT INTO `user_demo` VALUES ('8', '胡明', '15659452889', '22', '0', '2018-05-05 19:24:03', '王敏', null, null);
INSERT INTO `user_demo` VALUES ('9', '冯宣朗', '14698652369', '56', '0', '2018-05-05 19:31:33', '李凤', null, null);
INSERT INTO `user_demo` VALUES ('10', '张昊天', '17856982356', '29', '0', '2018-05-05 19:32:14', '李凤', null, null);
INSERT INTO `user_demo` VALUES ('11', '张鸿飞', '18956234578', '35', '0', '2018-05-05 19:32:53', '李凤', null, null);
INSERT INTO `user_demo` VALUES ('12', '孔景行', '15689451346', '39', '0', '2018-05-05 19:33:30', '李凤', null, null);
INSERT INTO `user_demo` VALUES ('13', '朱书雁', '15678652389', '18', '0', '2018-05-05 19:34:19', '李凤', null, null);
INSERT INTO `user_demo` VALUES ('14', '马元菱', '18945697823', '43', '0', '2018-05-05 19:35:02', '李凤', null, null);
INSERT INTO `user_demo` VALUES ('15', '马惜玉', '18945691234', '38', '0', '2018-05-05 19:35:30', '李凤', null, null);
