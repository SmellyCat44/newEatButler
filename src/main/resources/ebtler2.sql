/*
Navicat MySQL Data Transfer

Source Server         : pxy
Source Server Version : 50514
Source Host           : localhost:3306
Source Database       : ebtler2

Target Server Type    : MYSQL
Target Server Version : 50514
File Encoding         : 65001

Date: 2020-12-29 12:36:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for addrinfo
-- ----------------------------
DROP TABLE IF EXISTS `addrinfo`;
CREATE TABLE `addrinfo` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) DEFAULT NULL,
  `province` varchar(30) NOT NULL,
  `city` varchar(30) NOT NULL,
  `region` varchar(30) NOT NULL,
  `address` varchar(50) NOT NULL,
  `linkman` varchar(40) NOT NULL,
  `tel` varchar(40) NOT NULL,
  PRIMARY KEY (`address_id`),
  KEY `FK_write` (`user_id`),
  CONSTRAINT `FK_write` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of addrinfo
-- ----------------------------
INSERT INTO `addrinfo` VALUES ('2', 'test', 'zj', 'hz', 'sc', 'zju', 'ppz', '123');

-- ----------------------------
-- Table structure for comments
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `p_id` int(11) NOT NULL,
  `user_id` varchar(20) NOT NULL,
  `shop_id` varchar(20) NOT NULL,
  `o_id` int(11) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `cmt_date` datetime DEFAULT NULL,
  `cmt_rank` varchar(10) DEFAULT NULL,
  `pic` longblob,
  `feedback` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`p_id`,`user_id`,`shop_id`,`o_id`),
  KEY `FK_comments2` (`user_id`),
  KEY `FK_comments3` (`shop_id`),
  KEY `FK_comments4` (`o_id`),
  CONSTRAINT `FK_comments` FOREIGN KEY (`p_id`) REFERENCES `products` (`p_id`),
  CONSTRAINT `FK_comments2` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FK_comments3` FOREIGN KEY (`shop_id`) REFERENCES `shop` (`shop_id`),
  CONSTRAINT `FK_comments4` FOREIGN KEY (`o_id`) REFERENCES `orders` (`o_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comments
-- ----------------------------

-- ----------------------------
-- Table structure for coupon
-- ----------------------------
DROP TABLE IF EXISTS `coupon`;
CREATE TABLE `coupon` (
  `c_id` int(11) NOT NULL,
  `shop_id` varchar(20) DEFAULT NULL,
  `o_id` int(11) DEFAULT NULL,
  `c_mon` float NOT NULL,
  `c_start_date` datetime NOT NULL,
  `c_end_date` datetime NOT NULL,
  PRIMARY KEY (`c_id`),
  KEY `FK_provide` (`shop_id`),
  KEY `FK_use` (`o_id`),
  CONSTRAINT `FK_provide` FOREIGN KEY (`shop_id`) REFERENCES `shop` (`shop_id`),
  CONSTRAINT `FK_use` FOREIGN KEY (`o_id`) REFERENCES `orders` (`o_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of coupon
-- ----------------------------

-- ----------------------------
-- Table structure for dscplan
-- ----------------------------
DROP TABLE IF EXISTS `dscplan`;
CREATE TABLE `dscplan` (
  `dsc_id` int(11) NOT NULL,
  `shop_id` varchar(20) DEFAULT NULL,
  `dsc_minus` float NOT NULL,
  `dsc_mon` float NOT NULL,
  `dsc_describe` varchar(100) NOT NULL,
  PRIMARY KEY (`dsc_id`),
  KEY `FK_grants` (`shop_id`),
  CONSTRAINT `FK_grants` FOREIGN KEY (`shop_id`) REFERENCES `shop` (`shop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dscplan
-- ----------------------------

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `manager_id` varchar(20) NOT NULL,
  `manager_name` varchar(20) NOT NULL,
  `manager_pwd` varchar(20) NOT NULL,
  PRIMARY KEY (`manager_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('m1', 'm1', 'm1');

-- ----------------------------
-- Table structure for orderdetail
-- ----------------------------
DROP TABLE IF EXISTS `orderdetail`;
CREATE TABLE `orderdetail` (
  `o_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `amt` int(11) NOT NULL,
  `final_price` double NOT NULL,
  `dsc_sig` double DEFAULT NULL,
  PRIMARY KEY (`o_id`,`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderdetail
-- ----------------------------
INSERT INTO `orderdetail` VALUES ('1', '1', '1', '20.2', '0');
INSERT INTO `orderdetail` VALUES ('4', '1', '2', '40.4', '0');
INSERT INTO `orderdetail` VALUES ('5', '1', '1', '20.2', '0');
INSERT INTO `orderdetail` VALUES ('6', '4', '3', '60.599999999999994', '0');
INSERT INTO `orderdetail` VALUES ('7', '3', '2', '40', '0');
INSERT INTO `orderdetail` VALUES ('8', '3', '9', '180', '0');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `o_id` int(11) NOT NULL,
  `dsc_id` int(11) DEFAULT NULL,
  `address_id` int(11) DEFAULT NULL,
  `user_id` varchar(20) DEFAULT NULL,
  `shop_id` varchar(20) DEFAULT NULL,
  `c_id` int(11) DEFAULT NULL,
  `row` double DEFAULT NULL,
  `mon` double DEFAULT NULL,
  `order_status` varchar(20) DEFAULT NULL,
  `rider_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`o_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', null, '2', 'test', 'test', null, '20.2', '20.2', '正在配送', 'test');
INSERT INTO `orders` VALUES ('4', null, '2', 'test', 'test', null, '40.4', '40.4', '已下单', null);
INSERT INTO `orders` VALUES ('5', null, '2', 'test', 'test', null, '20.2', '20.2', '已取消', null);
INSERT INTO `orders` VALUES ('6', null, null, '12', 'test', null, '60.599999999999994', '60.599999999999994', '正在配送', 'test');
INSERT INTO `orders` VALUES ('7', null, null, '12', 'test', null, '40', '40', '确认收货', 'test');
INSERT INTO `orders` VALUES ('8', null, '2', 'test', 'test', null, '180', '180', '确认收货', 'test');

-- ----------------------------
-- Table structure for own
-- ----------------------------
DROP TABLE IF EXISTS `own`;
CREATE TABLE `own` (
  `user_id` varchar(20) NOT NULL,
  `c_id` int(11) NOT NULL,
  `shop_id` varchar(20) NOT NULL,
  `c_mon` float NOT NULL,
  `quantity` int(11) NOT NULL,
  `user_due_date` datetime NOT NULL,
  PRIMARY KEY (`user_id`,`c_id`,`shop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of own
-- ----------------------------

-- ----------------------------
-- Table structure for products
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `p_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_id` int(11) NOT NULL DEFAULT '0',
  `product_name` varchar(20) NOT NULL DEFAULT '',
  `product_price` double(10,2) NOT NULL DEFAULT '0.00',
  `product_image` longblob,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of products
-- ----------------------------
INSERT INTO `products` VALUES ('1', '1', 'beef hamburger', '20.20', null);
INSERT INTO `products` VALUES ('3', '1', 'beef hamburger', '20.00', null);
INSERT INTO `products` VALUES ('4', '1', 'beef hamburger', '20.20', null);
INSERT INTO `products` VALUES ('5', '1', 'beef hamburger', '20.22', null);
INSERT INTO `products` VALUES ('6', '1', 'beef hamburger', '30.00', null);

-- ----------------------------
-- Table structure for producttype
-- ----------------------------
DROP TABLE IF EXISTS `producttype`;
CREATE TABLE `producttype` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `shop_id` varchar(20) DEFAULT NULL,
  `type_name` varchar(40) NOT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of producttype
-- ----------------------------
INSERT INTO `producttype` VALUES ('1', 'test', 'hamburger');
INSERT INTO `producttype` VALUES ('2', 'test', 'zhaji');
INSERT INTO `producttype` VALUES ('3', 'test', 'miantiao');
INSERT INTO `producttype` VALUES ('4', 'test', 'lsz');

-- ----------------------------
-- Table structure for riders
-- ----------------------------
DROP TABLE IF EXISTS `riders`;
CREATE TABLE `riders` (
  `rider_id` varchar(20) NOT NULL DEFAULT '',
  `rider_name` varchar(40) NOT NULL,
  `rider_date` date NOT NULL,
  `rider_rank` varchar(30) NOT NULL DEFAULT '',
  `rider_pwd` varchar(20) NOT NULL DEFAULT '',
  `rider_balance` double(20,2) NOT NULL DEFAULT '0.00',
  `rider_tel` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`rider_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of riders
-- ----------------------------
INSERT INTO `riders` VALUES ('test', 'rider', '2020-12-14', '新人', '45454555', '0.20', '11125658955');

-- ----------------------------
-- Table structure for rider_account
-- ----------------------------
DROP TABLE IF EXISTS `rider_account`;
CREATE TABLE `rider_account` (
  `o_id` int(11) NOT NULL,
  `rider_id` varchar(20) NOT NULL,
  `r_acc_time` datetime DEFAULT NULL,
  `r_cmmt` varchar(30) DEFAULT NULL,
  `r_income` double DEFAULT NULL,
  PRIMARY KEY (`o_id`,`rider_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rider_account
-- ----------------------------
INSERT INTO `rider_account` VALUES ('7', 'test', '2020-12-29 11:02:00', null, '2.5');

-- ----------------------------
-- Table structure for shop
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop` (
  `shop_id` varchar(20) NOT NULL DEFAULT '',
  `shop_name` varchar(50) DEFAULT '',
  `shop_briefintro` varchar(100) DEFAULT '',
  `shop_address` varchar(60) DEFAULT '',
  `shkper_name` varchar(20) DEFAULT '',
  `shop_pwd` varchar(20) NOT NULL DEFAULT '',
  `shkper_tel` varchar(30) NOT NULL DEFAULT '',
  `shop_balance` double(20,2) NOT NULL DEFAULT '0.00',
  `shop_portrait` longblob,
  `shop_image` longblob,
  PRIMARY KEY (`shop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop
-- ----------------------------
INSERT INTO `shop` VALUES ('test', 'kfc', 'dfghjkdfghjkxghkldfghj', 'afjgtrhdfjthghfhjg', 'sqw', 'test', '123456789', '0.00', null, null);

-- ----------------------------
-- Table structure for shop_account
-- ----------------------------
DROP TABLE IF EXISTS `shop_account`;
CREATE TABLE `shop_account` (
  `o_id` int(11) NOT NULL,
  `shop_id` varchar(20) NOT NULL,
  `s_income` double NOT NULL,
  `s_time` datetime DEFAULT NULL,
  PRIMARY KEY (`o_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_account
-- ----------------------------
INSERT INTO `shop_account` VALUES ('7', 'test', '40', '2020-12-29 11:02:00');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `user_id` varchar(20) NOT NULL DEFAULT '',
  `user_pwd` varchar(16) NOT NULL DEFAULT '',
  `user_name` varchar(40) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `user_tel` varchar(20) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `user_city` varchar(20) DEFAULT NULL,
  `is_vip` varchar(10) NOT NULL DEFAULT '',
  `vip_due_date` datetime DEFAULT NULL,
  `user_balance` double(20,2) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('12', '222', 'sa', null, '22222', null, null, '4545', null, '0.00');
INSERT INTO `users` VALUES ('test', 'test1', '111', 'nv', '11111111111', null, null, '是', null, '200.20');

-- ----------------------------
-- Table structure for vip_coupon
-- ----------------------------
DROP TABLE IF EXISTS `vip_coupon`;
CREATE TABLE `vip_coupon` (
  `vc_id` varchar(20) NOT NULL,
  `vc_start` datetime NOT NULL,
  `vc_due` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vip_coupon
-- ----------------------------
