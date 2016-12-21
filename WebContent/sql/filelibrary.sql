/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : lawyer

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-12-21 17:46:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for filelibrary
-- ----------------------------
DROP TABLE IF EXISTS `filelibrary`;
CREATE TABLE `filelibrary` (
  `fl_id` int(11) NOT NULL AUTO_INCREMENT,
  `fl_name` varchar(64) NOT NULL,
  `fl_category` varchar(64) NOT NULL,
  `beizhu` varchar(255) DEFAULT NULL,
  `type` int(2) DEFAULT NULL COMMENT '类型   1案源  2案件  3其他',
  PRIMARY KEY (`fl_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of filelibrary
-- ----------------------------
INSERT INTO `filelibrary` VALUES ('29', '案源文件库', '案源', '', '1');
INSERT INTO `filelibrary` VALUES ('30', '案件文件库', '案件', '', '2');
INSERT INTO `filelibrary` VALUES ('32', '合同文件库', '合同', '', '3');
INSERT INTO `filelibrary` VALUES ('33', '文档库', '文档', '', '3');

-- ----------------------------
-- Table structure for files
-- ----------------------------
DROP TABLE IF EXISTS `files`;
CREATE TABLE `files` (
  `f_id` int(16) NOT NULL AUTO_INCREMENT,
  `f_title` varchar(64) DEFAULT NULL,
  `f_type` varchar(64) DEFAULT NULL,
  `f_reldate` varchar(64) DEFAULT NULL,
  `f_attach` varchar(128) DEFAULT NULL,
  `f_uid` int(11) DEFAULT NULL,
  `f_flid` int(11) DEFAULT NULL,
  `remark` varchar(500) DEFAULT NULL,
  `casecodeself` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`f_id`),
  KEY `f_uid_user` (`f_uid`),
  KEY `f_flid_flies` (`f_flid`),
  CONSTRAINT `f_flid_flies` FOREIGN KEY (`f_flid`) REFERENCES `filelibrary` (`fl_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of files
-- ----------------------------
INSERT INTO `files` VALUES ('1', '1101072012033000220131004094340-20150909021651华山食品机械设备安装有限公司.doc', '案源', '2015年09月09日', '20150909021651华山食品机械设备安装有限公司.doc', '32', '29', null, null);
INSERT INTO `files` VALUES ('2', '11020220100707004-20161129104948_强制清算申请书.doc', '案件', '2016��11��29��', '20161129104948_强制清算申请书.doc', '48', '30', null, null);
INSERT INTO `files` VALUES ('3', '6590112007060500120131113044805-20161129110421公告2014-04-25.pdf', '合同', '2016��11��29��', '20161129110421公告2014-04-25.pdf', '35', '32', null, null);
INSERT INTO `files` VALUES ('4', '', '案件文件库', '2016年12月21日', '20161221_公告161130.xls', '29', '30', null, null);
