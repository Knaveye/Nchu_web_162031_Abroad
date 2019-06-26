/*
Navicat MySQL Data Transfer

Source Server         : hospital
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : studyabroad

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2019-06-26 11:52:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `abroad_apply`
-- ----------------------------
DROP TABLE IF EXISTS `abroad_apply`;
CREATE TABLE `abroad_apply` (
  `ap_id` int(11) NOT NULL AUTO_INCREMENT,
  `ap_avgscore` varchar(255) DEFAULT NULL,
  `ap_content` varchar(255) DEFAULT NULL,
  `ap_email` varchar(255) DEFAULT NULL,
  `ap_gamt` varchar(255) DEFAULT NULL,
  `ap_gre` varchar(255) DEFAULT NULL,
  `ap_ielts` varchar(255) DEFAULT NULL,
  `ap_phone` varchar(255) DEFAULT NULL,
  `ap_profession1` varchar(255) DEFAULT NULL,
  `ap_profession2` varchar(255) DEFAULT NULL,
  `ap_school1` varchar(255) DEFAULT NULL,
  `ap_toefl` varchar(255) DEFAULT NULL,
  `school_schoolid` bigint(20) DEFAULT NULL,
  `user_userid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ap_id`),
  KEY `FKiwogxloxx3t8kycl4aleji4fo` (`school_schoolid`),
  KEY `FKbneepsxjbnu85edqso3cogee1` (`user_userid`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of abroad_apply
-- ----------------------------
INSERT INTO `abroad_apply` VALUES ('6', '79.5', '.。。。', '123123@qq.com', '99', '99', '99', '1777777777', '软件工程', '软件工程', '南昌航空大学', '99', '1', '1');

-- ----------------------------
-- Table structure for `abroad_exam`
-- ----------------------------
DROP TABLE IF EXISTS `abroad_exam`;
CREATE TABLE `abroad_exam` (
  `apex_id` int(11) NOT NULL AUTO_INCREMENT,
  `apex_status` varchar(255) DEFAULT NULL,
  `abroad_apply_ap_id` int(11) DEFAULT NULL,
  `school_register_schmanageid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`apex_id`),
  KEY `FKmktnwvawn6y9yrhwgq6xp4lf2` (`abroad_apply_ap_id`),
  KEY `FKqj7xflbfu6mpfq2f2l27l179k` (`school_register_schmanageid`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of abroad_exam
-- ----------------------------
INSERT INTO `abroad_exam` VALUES ('1', '同意申请', '1', '1');
INSERT INTO `abroad_exam` VALUES ('2', '拒绝申请', '6', '1');

-- ----------------------------
-- Table structure for `abroad_require`
-- ----------------------------
DROP TABLE IF EXISTS `abroad_require`;
CREATE TABLE `abroad_require` (
  `ar_id` int(11) NOT NULL AUTO_INCREMENT,
  `ar_content` varchar(255) DEFAULT NULL,
  `ar_gamt` varchar(255) DEFAULT NULL,
  `ar_gre` varchar(255) DEFAULT NULL,
  `ar_ielts` varchar(255) DEFAULT NULL,
  `ar_toefl` varchar(255) DEFAULT NULL,
  `school_schoolid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ar_id`),
  KEY `FKcli4tgf5hobnllei7nrqew7f` (`school_schoolid`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of abroad_require
-- ----------------------------
INSERT INTO `abroad_require` VALUES ('1', '东方时代1', '的方式地方3', '发的是啥地方的V', '对方感到孤独风2', '的风格发的', '1');

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
  `postcontext` varchar(255) DEFAULT NULL,
  `postdate` datetime DEFAULT NULL,
  `viewcount` bigint(20) NOT NULL,
  `userid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`postid`),
  KEY `FK2sf14youcwqso9pdch0uiwpem` (`userid`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES ('1', '爱情', '驱蚊器', '2019-06-25 21:10:50', '17', '1');
INSERT INTO `post` VALUES ('4', 'ddd', 'awedqq', '2019-06-25 22:11:17', '5', '1');

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
  `schmasg_id` bigint(20) DEFAULT NULL,
  `userid` bigint(20) DEFAULT NULL,
  `web_msg_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`postreply_id`),
  KEY `FKomwsu0w06dbbc7b29p64j583t` (`postid`),
  KEY `FKb2dynjjkshbo4l66spxlq0920` (`schmasg_id`),
  KEY `FKctronpuys191afaoxi1p4a1h7` (`userid`),
  KEY `FKcj7amxvb5vgbovjpy1qceq8d6` (`web_msg_id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of postreply
-- ----------------------------
INSERT INTO `postreply` VALUES ('1', '啊速度下擦·', '1', '2019-06-25 21:10:55', '1', null, '1', null);
INSERT INTO `postreply` VALUES ('2', '1231', '2', '2019-06-25 21:13:31', '1', null, null, '1');
INSERT INTO `postreply` VALUES ('3', 'qweqw1', '3', '2019-06-25 21:56:19', '1', null, '1', null);
INSERT INTO `postreply` VALUES ('4', 'ewq1', '4', '2019-06-25 21:56:37', '1', '1', null, null);
INSERT INTO `postreply` VALUES ('5', 'sdaadas', '1', '2019-06-25 22:11:31', '4', null, '1', null);
INSERT INTO `postreply` VALUES ('6', 'dfdxfsd', '5', '2019-06-25 22:11:49', '1', '1', null, null);
INSERT INTO `postreply` VALUES ('7', 'xdxxx', '6', '2019-06-25 22:12:07', '1', null, null, '1');
INSERT INTO `postreply` VALUES ('8', 'eqw', '2', '2019-06-25 22:14:56', '4', null, '3', null);

-- ----------------------------
-- Table structure for `school`
-- ----------------------------
DROP TABLE IF EXISTS `school`;
CREATE TABLE `school` (
  `schoolid` bigint(20) NOT NULL AUTO_INCREMENT,
  `schoolname` varchar(255) DEFAULT NULL,
  `schoolnet` varchar(255) DEFAULT NULL,
  `s_address` varchar(255) DEFAULT NULL,
  `s_country` varchar(255) DEFAULT NULL,
  `s_enlish_name` varchar(255) DEFAULT NULL,
  `s_title` varchar(255) DEFAULT NULL,
  `s_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`schoolid`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school
-- ----------------------------
INSERT INTO `school` VALUES ('1', '南昌航空大学', 'http://www.nchu.edu.cn/', '南昌', '中国', 'nchu', '南昌 ', '公立研究型大学');

-- ----------------------------
-- Table structure for `schoolmanage`
-- ----------------------------
DROP TABLE IF EXISTS `schoolmanage`;
CREATE TABLE `schoolmanage` (
  `schmanageid` bigint(20) NOT NULL AUTO_INCREMENT,
  `schmanage_account` varchar(255) DEFAULT NULL,
  `schmanage_password` varchar(255) DEFAULT NULL,
  `school_id` bigint(20) DEFAULT NULL,
  `schmanage_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`schmanageid`),
  KEY `FKjnxvrmyi96wan159ggw3igc0f` (`school_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of schoolmanage
-- ----------------------------
INSERT INTO `schoolmanage` VALUES ('1', '123', '123', '1', 'ysh');

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
  `webmanageid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`sra_id`),
  KEY `FK4wn9e9ruv0k46bx6y5837qvry` (`userid`),
  KEY `FKo9j2soyu0eehy9x8ff2y1shn9` (`webmanageid`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of studylaw
-- ----------------------------
INSERT INTO `studylaw` VALUES ('1', 'normal', '../webStudyAbroad/src/main/resources/static/txt/rule2.txt', 'rule2.txt', '2019-06-23 18:43:01', '国家建设高水平大学公派研究生项目学费资助办法(试行)', '1', null);
INSERT INTO `studylaw` VALUES ('2', 'normal', '../webStudyAbroad/src/main/resources/static/txt/rule3.txt', 'rule3.txt', '2019-06-14 18:43:47', '国家留学基金资助人员派出和管理若干问题的规定(1996年)', '1', null);
INSERT INTO `studylaw` VALUES ('3', 'normal', '../webStudyAbroad/src/main/resources/static/txt/rule4.txt', 'rule4.txt', '2019-06-05 18:45:18', '教育部 财政部关于印发《国家公派出国留学研究生管理规定(试行)》的通知', '1', null);
INSERT INTO `studylaw` VALUES ('4', 'foreign', '../webStudyAbroad/src/main/resources/static/txt/foreign1.txt', 'foreign1.txt', '2019-06-08 15:27:08', '关于为2018年冬季学期、2019年夏季学期赴德国慕尼黑地区国家公派留学人员提供学生公寓的通知', '1', null);
INSERT INTO `studylaw` VALUES ('5', 'foreign', '../webStudyAbroad/src/main/resources/static/txt/foreign2.txt', 'foreign2.txt', '2019-06-13 15:29:05', '关于为新录取的赴德国慕尼黑国家公派留学人员提供学生公寓的通知', '1', null);
INSERT INTO `studylaw` VALUES ('6', 'foreign', '../webStudyAbroad/src/main/resources/static/txt/foreign3.txt', 'foreign3.txt', '2019-06-05 15:30:54', '关于为2016年冬季学期与2017年夏季学期赴德国慕尼黑国家公派留学人员提供学生公寓的通知', '1', null);
INSERT INTO `studylaw` VALUES ('7', 'foreign', '../webStudyAbroad/src/main/resources/static/txt/foreign4.txt', 'foreign4.txt', '2019-07-20 15:33:09', '常见问题解答', '1', null);
INSERT INTO `studylaw` VALUES ('9', 'normal', '../webStudyAbroad/src/main/resources/static/txt/3cd57266-4cf1-4e45-8c82-8696fe7fd8d4.txt', '3cd57266-4cf1-4e45-8c82-8696fe7fd8d4.txt', '2019-06-25 22:06:48', '21321', null, '1');

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
  `schmanageid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`sa_id`),
  KEY `FK85owpidrbket7ng27i1g7i4xi` (`user_id`),
  KEY `FKanq5crrm30caw03uoqy2eadpp` (`schmanageid`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of study_abroad
-- ----------------------------
INSERT INTO `study_abroad` VALUES ('2', '12312412412342212312321312312321312312312', '2019-06-25 21:22:58', '2222', null, '1');
INSERT INTO `study_abroad` VALUES ('3', 'qweqwewqe', '2019-06-25 21:48:36', 'qwe', null, null);
INSERT INTO `study_abroad` VALUES ('4', '1231234dsfsdfsdf', '2019-06-25 22:05:23', '333', null, '1');

-- ----------------------------
-- Table structure for `study_announce`
-- ----------------------------
DROP TABLE IF EXISTS `study_announce`;
CREATE TABLE `study_announce` (
  `ann_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ann_content` varchar(255) DEFAULT NULL,
  `ann_filename` varchar(255) DEFAULT NULL,
  `ann_filepath` varchar(255) DEFAULT NULL,
  `ann_time` datetime DEFAULT NULL,
  `ann_title` varchar(255) DEFAULT NULL,
  `userid` bigint(20) DEFAULT NULL,
  `schmanageid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ann_id`),
  KEY `FKob9dn18av829kr9qq5i9dvivu` (`userid`),
  KEY `FKp405q0ix3m5mue7to1tgcnurl` (`schmanageid`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of study_announce
-- ----------------------------
INSERT INTO `study_announce` VALUES ('1', null, 'announce1.txt', '../webStudyAbroad/src/main/resources/static/txt/announce1.txt', '2019-06-18 09:50:54', '2019年国家公派出国留学行前培训', '1', null);
INSERT INTO `study_announce` VALUES ('2', null, 'announce3.txt', '../webStudyAbroad/src/main/resources/static/txt/announce3.txt', '2019-06-27 17:08:04', '国家留学基金管理委员会2019年招聘启事', '1', null);
INSERT INTO `study_announce` VALUES ('3', null, 'announce2.txt', '../webStudyAbroad/src/main/resources/static/txt/announce2.txt', '2019-07-11 09:52:49', '关于取消国家公派研究生国外管理部分证明事项有关事宜的公告', '1', null);
INSERT INTO `study_announce` VALUES ('4', null, 'announce4.txt', '../webStudyAbroad/src/main/resources/static/txt/announce4.txt', '2019-06-12 09:53:47', '关于国家公派留学奖学金改革发放问题解答', '1', null);
INSERT INTO `study_announce` VALUES ('5', null, '5ba8b9ca-3f2d-4336-a4c9-b6dcb9a4eea7.txt', '../webStudyAbroad/src/main/resources/static/txt/5ba8b9ca-3f2d-4336-a4c9-b6dcb9a4eea7.txt', '2019-06-25 20:21:16', '2222', null, null);
INSERT INTO `study_announce` VALUES ('6', null, '462c1911-13ea-4150-b7c6-a3b71f96c480.txt', '../webStudyAbroad/src/main/resources/static/txt/462c1911-13ea-4150-b7c6-a3b71f96c480.txt', '2019-06-25 21:21:56', '333', null, '1');
INSERT INTO `study_announce` VALUES ('7', null, 'e52754d7-935a-4ce2-aef3-0c202e50c5f0.txt', '../webStudyAbroad/src/main/resources/static/txt/e52754d7-935a-4ce2-aef3-0c202e50c5f0.txt', '2019-06-25 21:23:24', '2222', null, '1');
INSERT INTO `study_announce` VALUES ('8', null, '7edce162-138c-446f-b4d2-143feccf5fc6.txt', '../webStudyAbroad/src/main/resources/static/txt/7edce162-138c-446f-b4d2-143feccf5fc6.txt', '2019-06-25 21:32:05', '123', null, '1');
INSERT INTO `study_announce` VALUES ('9', null, 'fb42b4e6-3250-4596-a31d-8985332050e3.txt', '../webStudyAbroad/src/main/resources/static/txt/fb42b4e6-3250-4596-a31d-8985332050e3.txt', '2019-06-25 22:05:40', '12312', null, '1');

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
  PRIMARY KEY (`userid`),
  UNIQUE KEY `UK_nmm6ogy93lci5nfamcuqqun2j` (`userpassword`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '123', '1999-11-11', '16203122@stu.nchu.edu.cn', '叶瑾', '12', '123');
INSERT INTO `user` VALUES ('2', 'C1001', null, '16203122@stu.nchu.edu.cn', '数据存储', '125', '111');
INSERT INTO `user` VALUES ('4', '1231', null, '16203122@stu.nchu.edu.cn', 'asd zxc', null, '12345');

-- ----------------------------
-- Table structure for `webmanage`
-- ----------------------------
DROP TABLE IF EXISTS `webmanage`;
CREATE TABLE `webmanage` (
  `webmanageid` bigint(20) NOT NULL AUTO_INCREMENT,
  `web_account` varchar(255) DEFAULT NULL,
  `web_password` varchar(255) DEFAULT NULL,
  `webname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`webmanageid`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of webmanage
-- ----------------------------
INSERT INTO `webmanage` VALUES ('1', '1', '1', '啊啊');
