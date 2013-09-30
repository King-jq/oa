/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50612
Source Host           : localhost:3306
Source Database       : oa

Target Server Type    : MYSQL
Target Server Version : 50612
File Encoding         : 65001

Date: 2013-09-09 14:50:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_author`
-- ----------------------------
DROP TABLE IF EXISTS `tb_author`;
CREATE TABLE `tb_author` (
  `authId` varchar(40) NOT NULL,
  `authName` varchar(40) NOT NULL,
  `methodName` varchar(100) NOT NULL,
  `className` varchar(200) NOT NULL,
  `authSortAll` varchar(100) NOT NULL,
  PRIMARY KEY (`authId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_author
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_depart`
-- ----------------------------
DROP TABLE IF EXISTS `tb_depart`;
CREATE TABLE `tb_depart` (
  `departId` varchar(40) NOT NULL,
  `departName` varchar(200) NOT NULL,
  `departSortAll` varchar(100) NOT NULL,
  `departPid` varchar(40) DEFAULT NULL,
  `departAddr` varchar(200) DEFAULT NULL,
  `departState` int(2) NOT NULL,
  `departType` int(2) NOT NULL,
  `departIsDel` int(2) NOT NULL,
  `createDate` datetime NOT NULL,
  PRIMARY KEY (`departId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_depart
-- ----------------------------
INSERT INTO `tb_depart` VALUES ('078055BCB5FC407AB89F59601091CE4D', '省发展改革委', '001001003', '100BCCB58B6144C58AB0C54B5AF534BA', '河南省郑州市', '2', '0', '0', '2013-09-01 17:22:09');
INSERT INTO `tb_depart` VALUES ('100BCCB58B6144C58AB0C54B5AF534BA', '河南省', '001001', null, '河南省郑州市', '1', '1', '0', '2013-08-29 20:03:33');
INSERT INTO `tb_depart` VALUES ('116E562727214F5598823EA7E7C7DE0D', '新乡市', '001001006', '100BCCB58B6144C58AB0C54B5AF534BA', '河南省新乡市', '1', '0', '0', '2013-09-01 17:20:58');
INSERT INTO `tb_depart` VALUES ('5D26F2AABC4842F39654764C083BF8B0', '信阳市', '001001002', '100BCCB58B6144C58AB0C54B5AF534BA', '河南省信阳市浉河区', '1', '0', '0', '2013-08-31 13:52:00');
INSERT INTO `tb_depart` VALUES ('720AAB15CB5846A9A3864B66C54A0030', '省文化厅', '001001008', '100BCCB58B6144C58AB0C54B5AF534BA', '河南省郑州市', '2', '0', '0', '2013-09-01 17:21:45');
INSERT INTO `tb_depart` VALUES ('975F2BBE919143EAA9BA0B8C73B5040A', '省教育厅', '001001007', '100BCCB58B6144C58AB0C54B5AF534BA', '河南省郑州市', '2', '0', '0', '2013-09-01 13:29:41');
INSERT INTO `tb_depart` VALUES ('C4580E4C8340401B81A4DFC5098EEE7B', '河南省公安厅', '001001004', '100BCCB58B6144C58AB0C54B5AF534BA', '河南省郑州市', '2', '0', '0', '2013-09-01 13:29:16');
INSERT INTO `tb_depart` VALUES ('E0CE51B335D449039F9E09E9CD954BBC', '郑州市', '001001001', '100BCCB58B6144C58AB0C54B5AF534BA', '郑州市中原区中原路', '1', '0', '0', '2013-08-29 22:22:50');
INSERT INTO `tb_depart` VALUES ('FAC3685CE57E49868BC848CD22CE3244', '洛阳市', '001001005', '100BCCB58B6144C58AB0C54B5AF534BA', '洛阳市洛龙区', '1', '0', '0', '2013-09-01 17:19:34');

-- ----------------------------
-- Table structure for `tb_leave`
-- ----------------------------
DROP TABLE IF EXISTS `tb_leave`;
CREATE TABLE `tb_leave` (
  `lid` varchar(40) NOT NULL,
  `createDate` datetime NOT NULL,
  `startDate` datetime NOT NULL,
  `endDate` datetime NOT NULL,
  `userId` varchar(40) NOT NULL,
  `cause` varchar(4000) NOT NULL,
  `isEnd` int(2) NOT NULL,
  `proId` varchar(100) NOT NULL,
  PRIMARY KEY (`lid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_leave
-- ----------------------------
INSERT INTO `tb_leave` VALUES ('0200517DB27F45AC9A3CA674A7884771', '2013-09-09 14:44:30', '2013-09-09 14:44:21', '2013-09-10 14:44:25', '784BCCB58B6144C58AB0C54B5AF534A5', '回家结婚', '0', '201');
INSERT INTO `tb_leave` VALUES ('4A6859075D924D1E9B746FF44ACCC82B', '2013-09-09 14:48:41', '2013-09-09 14:48:34', '2013-09-11 14:48:37', '784BCCB58B6144C58AB0C54B5AF534A5', 'asdasd', '0', '209');

-- ----------------------------
-- Table structure for `tb_role`
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `roleId` varchar(40) NOT NULL,
  `roleName` varchar(200) NOT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_role
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_roleauthor`
-- ----------------------------
DROP TABLE IF EXISTS `tb_roleauthor`;
CREATE TABLE `tb_roleauthor` (
  `raId` varchar(100) NOT NULL,
  `roleId` varchar(40) NOT NULL,
  `authId` varchar(40) NOT NULL,
  PRIMARY KEY (`raId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_roleauthor
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `userId` varchar(40) NOT NULL,
  `userName` varchar(200) NOT NULL,
  `passwd` varchar(200) NOT NULL,
  `trueName` varchar(200) DEFAULT NULL,
  `departId` varchar(40) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `isDel` int(2) NOT NULL,
  `isSys` int(2) NOT NULL,
  `createDate` datetime NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('784BCCB58B6144C58AB0C54B5AF534A5', 'tlm1111', '1798D0105603605BC76671446DB04EA5', '滕丽美', '5D26F2AABC4842F39654764C083BF8B0', '0', '0', '0', '2013-08-29 20:01:57');
INSERT INTO `tb_user` VALUES ('FE49F59F3DA84ACB900C7E7074B652F5', 'tlm2222', '1798D0105603605BC76671446DB04EA5', '滕丽美', '100BCCB58B6144C58AB0C54B5AF534BA', '25', '0', '1', '2013-08-29 20:45:18');

-- ----------------------------
-- Table structure for `tb_userauthor`
-- ----------------------------
DROP TABLE IF EXISTS `tb_userauthor`;
CREATE TABLE `tb_userauthor` (
  `uaId` varchar(100) NOT NULL,
  `userId` varchar(40) NOT NULL,
  `authId` varchar(40) NOT NULL,
  PRIMARY KEY (`uaId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_userauthor
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_userrole`
-- ----------------------------
DROP TABLE IF EXISTS `tb_userrole`;
CREATE TABLE `tb_userrole` (
  `urId` varchar(100) NOT NULL,
  `userId` varchar(40) NOT NULL,
  `roleId` varchar(40) NOT NULL,
  PRIMARY KEY (`urId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_userrole
-- ----------------------------
