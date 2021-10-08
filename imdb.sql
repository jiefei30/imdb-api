/*
 Navicat Premium Data Transfer

 Source Server         : alicloud
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : 47.96.250.239:3306
 Source Schema         : imdb

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 15/06/2020 21:34:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for genre
-- ----------------------------
DROP TABLE IF EXISTS `genre`;
CREATE TABLE `genre`  (
  `id` tinyint(2) UNSIGNED NOT NULL,
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of genre
-- ----------------------------
INSERT INTO `genre` VALUES (1, 'Action');
INSERT INTO `genre` VALUES (2, 'Adventure');
INSERT INTO `genre` VALUES (3, 'Animation');
INSERT INTO `genre` VALUES (4, 'Biography');
INSERT INTO `genre` VALUES (5, 'Comedy');
INSERT INTO `genre` VALUES (6, 'Drama');
INSERT INTO `genre` VALUES (7, 'Family');
INSERT INTO `genre` VALUES (8, 'Fantasy');
INSERT INTO `genre` VALUES (9, 'Film-Nior');
INSERT INTO `genre` VALUES (10, 'History');
INSERT INTO `genre` VALUES (11, 'Horror');
INSERT INTO `genre` VALUES (12, 'Musical');
INSERT INTO `genre` VALUES (13, 'Mystery');
INSERT INTO `genre` VALUES (14, 'Romance');
INSERT INTO `genre` VALUES (15, 'Sci-Fi');
INSERT INTO `genre` VALUES (16, 'Sport');
INSERT INTO `genre` VALUES (17, 'Thriller');
INSERT INTO `genre` VALUES (18, 'War');
INSERT INTO `genre` VALUES (19, 'Western');
INSERT INTO `genre` VALUES (20, 'Crime');

-- ----------------------------
-- Table structure for mg
-- ----------------------------
DROP TABLE IF EXISTS `mg`;
CREATE TABLE `mg`  (
  `id` smallint(4) UNSIGNED NOT NULL AUTO_INCREMENT,
  `mid` smallint(4) NOT NULL DEFAULT 0,
  `gid` tinyint(2) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '电影和电影类型关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mg
-- ----------------------------
INSERT INTO `mg` VALUES (1, 1, 6);
INSERT INTO `mg` VALUES (2, 2, 6);
INSERT INTO `mg` VALUES (3, 2, 20);
INSERT INTO `mg` VALUES (4, 3, 6);
INSERT INTO `mg` VALUES (5, 3, 20);
INSERT INTO `mg` VALUES (6, 4, 6);
INSERT INTO `mg` VALUES (7, 4, 20);
INSERT INTO `mg` VALUES (8, 4, 1);
INSERT INTO `mg` VALUES (9, 5, 6);
INSERT INTO `mg` VALUES (10, 6, 4);
INSERT INTO `mg` VALUES (11, 6, 6);
INSERT INTO `mg` VALUES (12, 6, 11);
INSERT INTO `mg` VALUES (13, 7, 2);
INSERT INTO `mg` VALUES (14, 7, 6);
INSERT INTO `mg` VALUES (15, 7, 8);

-- ----------------------------
-- Table structure for movies
-- ----------------------------
DROP TABLE IF EXISTS `movies`;
CREATE TABLE `movies`  (
  `id` smallint(3) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'movie_name',
  `date` bigint(20) NOT NULL DEFAULT 1900,
  `rating` decimal(2, 1) NOT NULL DEFAULT 0.0,
  `country` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'china',
  `motto` tinytext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '电影表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of movies
-- ----------------------------
INSERT INTO `movies` VALUES (1, ' The Shawshank Redemption', 782064000, 9.2, 'USA', 'Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.');
INSERT INTO `movies` VALUES (2, 'The Godfather', 70214400, 9.1, 'USA', 'The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.');
INSERT INTO `movies` VALUES (3, 'The Godfather  Part II', 154108800, 9.0, 'USA', 'The early life and career of Vito Corleone in 1920s New York City is portrayed, while his son, Michael, expands and tightens his grip on the family crime syndicate.');
INSERT INTO `movies` VALUES (4, 'The Dark Knight', 1216310400, 9.0, 'USA', 'When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.');
INSERT INTO `movies` VALUES (5, 'Angry Men', 0, 8.9, 'USA', 'A jury holdout attempts to prevent a miscarriage of justice by forcing his colleagues to reconsider the evidence.');
INSERT INTO `movies` VALUES (6, 'Schindler\'s List', 765388800, 8.9, 'USA', 'In German-occupied Poland during World War II, industrialist Oskar Schindler gradually becomes concerned for his Jewish workforce after witnessing their persecution by the Nazis.');
INSERT INTO `movies` VALUES (7, 'The Lord of the Rings-The Return of the King', 1079020800, 8.9, 'China', 'Gandalf and Aragorn lead the World of Men against Sauron\'s army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.');

SET FOREIGN_KEY_CHECKS = 1;
