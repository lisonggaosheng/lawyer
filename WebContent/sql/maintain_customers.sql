/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : lawyer

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-10-24 17:19:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for maintain_customers
-- ----------------------------
DROP TABLE IF EXISTS `maintain_customers`;
CREATE TABLE `maintain_customers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `casecodeself` varchar(50) DEFAULT NULL,
  `contacts` varchar(50) DEFAULT NULL COMMENT '对方联系人',
  `contact_phone` varchar(11) DEFAULT NULL COMMENT '对方联系电话',
  `contact_time` varchar(50) DEFAULT NULL COMMENT '联系时间',
  `service_user` varchar(50) DEFAULT NULL COMMENT '服务人员',
  `service_phone` varchar(11) DEFAULT NULL COMMENT '服务人员电话',
  `content` text COMMENT '内容',
  `uid` int(11) DEFAULT NULL COMMENT '记录人员id',
  `savetime` varchar(50) DEFAULT NULL COMMENT '记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
