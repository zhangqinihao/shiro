/*
 Navicat Premium Data Transfer

 Source Server         : 本地Mysql
 Source Server Type    : MySQL
 Source Server Version : 50646
 Source Host           : localhost:3306
 Source Schema         : testdb

 Target Server Type    : MySQL
 Target Server Version : 50646
 File Encoding         : 65001

 Date: 26/06/2020 15:31:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `prams` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '111', '111111', 'user:add');
INSERT INTO `user` VALUES (2, '222', '222222', 'user:add');
INSERT INTO `user` VALUES (3, '333', '333333', 'user:add');
INSERT INTO `user` VALUES (4, '444', '444444', 'user:add');
INSERT INTO `user` VALUES (5, '5555', '555555', 'user:add');
INSERT INTO `user` VALUES (6, '6666', '666666', 'user:add');
INSERT INTO `user` VALUES (7, '77', '77', 'user:add');
INSERT INTO `user` VALUES (8, '88', '888', 'user:add');
INSERT INTO `user` VALUES (9, '999', '999', 'user:add');
INSERT INTO `user` VALUES (10, '10', '10', 'user:add');
INSERT INTO `user` VALUES (11, 'root', '123456', 'user:update');

-- ----------------------------
-- Table structure for usr
-- ----------------------------
DROP TABLE IF EXISTS `usr`;
CREATE TABLE `usr`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of usr
-- ----------------------------
INSERT INTO `usr` VALUES (1, '111', '111111');
INSERT INTO `usr` VALUES (2, '222', '222222');
INSERT INTO `usr` VALUES (3, '333', '333333');
INSERT INTO `usr` VALUES (4, '444', '444444');
INSERT INTO `usr` VALUES (5, '5555', '555555');
INSERT INTO `usr` VALUES (6, '6666', '666666');
INSERT INTO `usr` VALUES (7, '77', '77');
INSERT INTO `usr` VALUES (8, '88', '888');
INSERT INTO `usr` VALUES (9, '999', '999');
INSERT INTO `usr` VALUES (10, '10', '10');
INSERT INTO `usr` VALUES (11, 'root', '123456');

SET FOREIGN_KEY_CHECKS = 1;
