/*
Navicat MySQL Data Transfer

Source Server         : hospital
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : studyabroad

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2019-06-10 08:51:26
*/
create  database studyabroad;
use studyabroad;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `apply`
-- ----------------------------
DROP TABLE IF EXISTS `apply`;
CREATE TABLE `apply` (
  `applyid` bigint(20) NOT NULL AUTO_INCREMENT,
  `apply_context` varchar(255) DEFAULT NULL,
  `apply_describe` varchar(255) DEFAULT NULL,
  `schoolid` bigint(20) DEFAULT NULL,
  `userid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`applyid`),
  KEY `FKambsqbeo1oqxhas15pyi3ofkt` (`schoolid`),
  KEY `FKecbqulpo38t9l3j9p55k2l4u9` (`userid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of apply
-- ----------------------------

-- ----------------------------
-- Table structure for `applypermit`
-- ----------------------------
DROP TABLE IF EXISTS `applypermit`;
CREATE TABLE `applypermit` (
  `permit_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `permit_progress` int(11) DEFAULT NULL,
  `schmanage_id` bigint(20) DEFAULT NULL,
  `stdapp_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`permit_id`),
  KEY `FKidapgqxoot4epgcwok9pjbiom` (`schmanage_id`),
  KEY `FKp5nt4vbuxn649k2aqnx3y0n9n` (`stdapp_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of applypermit
-- ----------------------------

-- ----------------------------
-- Table structure for `post`
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `postid` bigint(20) NOT NULL AUTO_INCREMENT,
  `postname` varchar(255) DEFAULT NULL,
  `postdate` time DEFAULT NULL,
  `viewcount` bigint(20) NOT NULL,
  `userid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`postid`),
  KEY `FK2sf14youcwqso9pdch0uiwpem` (`userid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post
-- ----------------------------

-- ----------------------------
-- Table structure for `postreply`
-- ----------------------------
DROP TABLE IF EXISTS `postreply`;
CREATE TABLE `postreply` (
  `postreply_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `replaycontent` varchar(255) DEFAULT NULL,
  `floornum` bigint(20) DEFAULT NULL,
  `replay_time` datetime DEFAULT NULL,
  `postid` bigint(20) DEFAULT NULL,
  `userid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`postreply_id`),
  KEY `FKomwsu0w06dbbc7b29p64j583t` (`postid`),
  KEY `FKctronpuys191afaoxi1p4a1h7` (`userid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of postreply
-- ----------------------------

-- ----------------------------
-- Table structure for `school`
-- ----------------------------
DROP TABLE IF EXISTS `school`;
CREATE TABLE `school` (
  `schoolid` bigint(20) NOT NULL AUTO_INCREMENT,
  `schoolname` varchar(255) DEFAULT NULL,
  `schoolnet` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`schoolid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school
-- ----------------------------

-- ----------------------------
-- Table structure for `schoolmanage`
-- ----------------------------
DROP TABLE IF EXISTS `schoolmanage`;
CREATE TABLE `schoolmanage` (
  `schmanageid` bigint(20) NOT NULL AUTO_INCREMENT,
  `schmanage_account` varchar(255) DEFAULT NULL,
  `schmanage_password` varchar(255) DEFAULT NULL,
  `school_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`schmanageid`),
  KEY `FKjnxvrmyi96wan159ggw3igc0f` (`school_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of schoolmanage
-- ----------------------------

-- ----------------------------
-- Table structure for `stuay_announce`
-- ----------------------------
DROP TABLE IF EXISTS `stuay_announce`;
CREATE TABLE `stuay_announce` (
  `ann_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ann_content` varchar(255) DEFAULT NULL,
  `ann_filename` varchar(255) DEFAULT NULL,
  `ann_filepath` varchar(255) DEFAULT NULL,
  `ann_time` datetime DEFAULT NULL,
  `ann_title` varchar(255) DEFAULT NULL,
  `userid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ann_id`),
  KEY `FKdx32yievi6i531ik9f374v6vu` (`userid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stuay_announce
-- ----------------------------

-- ----------------------------
-- Table structure for `studylaw`
-- ----------------------------
DROP TABLE IF EXISTS `studylaw`;
CREATE TABLE `studylaw` (
  `sra_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sra_content` varchar(255) DEFAULT NULL,
  `sra_filepath` varchar(255) DEFAULT NULL,
  `sra_filename` varchar(255) DEFAULT NULL,
  `sra_time` datetime DEFAULT NULL,
  `sra_title` varchar(255) DEFAULT NULL,
  `userid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`sra_id`),
  KEY `FK4wn9e9ruv0k46bx6y5837qvry` (`userid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of studylaw
-- ----------------------------

-- ----------------------------
-- Table structure for `study_abroad`
-- ----------------------------
DROP TABLE IF EXISTS `study_abroad`;
CREATE TABLE `study_abroad` (
  `sa_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sa_content` varchar(255) DEFAULT NULL,
  `sa_time` datetime DEFAULT NULL,
  `sa_title` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`sa_id`),
  KEY `FK85owpidrbket7ng27i1g7i4xi` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of study_abroad
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` bigint(20) NOT NULL AUTO_INCREMENT,
  `useraccount` varchar(255) DEFAULT NULL,
  `birth` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `passport` varchar(255) DEFAULT NULL,
  `userpassword` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for `webmanage`
-- ----------------------------
DROP TABLE IF EXISTS `webmanage`;
CREATE TABLE `webmanage` (
  `webmanageid` bigint(20) NOT NULL AUTO_INCREMENT,
  `web_account` varchar(255) DEFAULT NULL,
  `web_password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`webmanageid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of webmanage
-- ----------------------------
