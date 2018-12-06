/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50534
Source Host           : localhost:3306
Source Database       : ec

Target Server Type    : MYSQL
Target Server Version : 50534
File Encoding         : 65001

Date: 2018-12-06 14:54:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cart_table
-- ----------------------------
DROP TABLE IF EXISTS `cart_table`;
CREATE TABLE `cart_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `quantity` int(11) DEFAULT NULL COMMENT '数量',
  `checked` int(11) NOT NULL COMMENT '是否选择 1-已勾选 0-未勾选',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `cart_table_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_table` (`id`),
  CONSTRAINT `cart_table_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product_table` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart_table
-- ----------------------------
INSERT INTO `cart_table` VALUES ('4', '1', '4', '2', '0', '2018-07-29 15:58:54', '2018-07-29 16:14:31');
INSERT INTO `cart_table` VALUES ('5', '1', '2', '4', '1', '2018-07-29 16:03:40', '2018-09-10 20:33:09');

-- ----------------------------
-- Table structure for category_table
-- ----------------------------
DROP TABLE IF EXISTS `category_table`;
CREATE TABLE `category_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) NOT NULL,
  `status` tinyint(1) DEFAULT '1',
  `sort_order` int(4) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category_table
-- ----------------------------
INSERT INTO `category_table` VALUES ('1', '0', '1', null, '家用电器', '2018-07-21 22:35:46', '2018-07-21 22:35:46');
INSERT INTO `category_table` VALUES ('2', '0', '1', null, '数码3C', '2018-07-21 22:44:16', '2018-07-21 22:44:16');
INSERT INTO `category_table` VALUES ('3', '0', '1', null, '服装箱包', '2018-07-21 22:44:42', '2018-07-21 22:44:42');
INSERT INTO `category_table` VALUES ('4', '0', '1', null, '食品生鲜', '2018-07-21 22:45:00', '2018-07-21 22:45:00');
INSERT INTO `category_table` VALUES ('5', '0', '1', null, '酒水饮料', '2018-07-21 22:45:15', '2018-07-21 22:45:15');
INSERT INTO `category_table` VALUES ('6', '1', '1', null, '冰箱', '2018-07-21 22:45:33', '2018-07-21 22:45:33');
INSERT INTO `category_table` VALUES ('7', '1', '1', null, '电视', '2018-07-21 22:45:42', '2018-07-21 22:45:42');
INSERT INTO `category_table` VALUES ('8', '1', '1', null, '洗衣机', '2018-07-21 22:45:49', '2018-07-21 22:45:49');
INSERT INTO `category_table` VALUES ('9', '1', '1', null, '空调', '2018-07-21 22:46:03', '2018-07-21 22:46:03');
INSERT INTO `category_table` VALUES ('10', '1', '1', null, '电热水器', '2018-07-21 22:46:30', '2018-07-21 22:46:30');
INSERT INTO `category_table` VALUES ('11', '2', '1', null, '电脑', '2018-07-21 22:46:37', '2018-07-21 22:46:37');
INSERT INTO `category_table` VALUES ('12', '2', '1', null, '手机', '2018-07-21 22:47:16', '2018-07-21 22:47:16');
INSERT INTO `category_table` VALUES ('13', '2', '1', null, '平板电脑', '2018-07-21 22:47:23', '2018-07-21 22:47:23');
INSERT INTO `category_table` VALUES ('14', '2', '1', null, '数码相机', '2018-07-21 22:47:35', '2018-07-21 22:47:35');
INSERT INTO `category_table` VALUES ('15', '2', '1', null, '3C配件', '2018-07-21 22:48:30', '2018-07-21 22:48:30');
INSERT INTO `category_table` VALUES ('16', '3', '1', null, '女装', '2018-07-21 22:48:49', '2018-07-21 22:48:49');
INSERT INTO `category_table` VALUES ('17', '3', '1', null, '帽子', '2018-07-21 22:49:35', '2018-07-21 22:49:35');
INSERT INTO `category_table` VALUES ('18', '3', '1', null, '旅行箱', '2018-07-21 22:49:49', '2018-07-21 22:49:49');
INSERT INTO `category_table` VALUES ('19', '3', '1', null, '手提包', '2018-07-21 22:49:57', '2018-07-21 22:49:57');
INSERT INTO `category_table` VALUES ('20', '3', '1', null, '保暖内衣', '2018-07-21 22:50:16', '2018-07-21 22:50:16');
INSERT INTO `category_table` VALUES ('21', '4', '1', null, '零食', '2018-07-21 22:50:32', '2018-07-21 22:50:32');
INSERT INTO `category_table` VALUES ('22', '4', '1', null, '生鲜', '2018-07-21 22:50:41', '2018-07-21 22:50:41');
INSERT INTO `category_table` VALUES ('23', '4', '1', null, '半成品菜', '2018-07-21 22:50:57', '2018-07-21 22:50:57');
INSERT INTO `category_table` VALUES ('24', '4', '1', null, '速冻食品', '2018-07-21 22:51:08', '2018-07-21 22:51:08');
INSERT INTO `category_table` VALUES ('25', '4', '1', null, '进口食品', '2018-07-21 22:51:27', '2018-07-21 22:51:27');
INSERT INTO `category_table` VALUES ('26', '5', '1', null, '白酒', '2018-07-21 22:51:41', '2018-07-21 22:51:41');
INSERT INTO `category_table` VALUES ('27', '5', '1', null, '红酒', '2018-07-21 22:51:47', '2018-07-21 22:51:47');
INSERT INTO `category_table` VALUES ('28', '5', '1', null, '饮料', '2018-07-21 22:51:55', '2018-07-21 22:51:55');
INSERT INTO `category_table` VALUES ('29', '5', '1', null, '调制鸡尾酒', '2018-07-21 22:52:09', '2018-07-21 22:52:09');
INSERT INTO `category_table` VALUES ('30', '5', '1', null, '进口洋酒', '2018-07-21 22:52:20', '2018-07-21 22:52:20');

-- ----------------------------
-- Table structure for order_item_table
-- ----------------------------
DROP TABLE IF EXISTS `order_item_table`;
CREATE TABLE `order_item_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `order_no` bigint(20) DEFAULT NULL,
  `product_id` int(11) NOT NULL,
  `product_name` varchar(100) DEFAULT NULL,
  `product_image` varchar(500) DEFAULT NULL,
  `curren_unit_price` decimal(10,2) DEFAULT NULL COMMENT '生成订单时的商品单价',
  `quantity` int(10) DEFAULT NULL,
  `total_price` decimal(10,2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_no` (`order_no`),
  KEY `product_id` (`product_id`),
  KEY `user_id` (`user_id`,`order_no`) USING BTREE,
  CONSTRAINT `order_item_table_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_table` (`id`),
  CONSTRAINT `order_item_table_ibfk_3` FOREIGN KEY (`product_id`) REFERENCES `product_table` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_item_table
-- ----------------------------

-- ----------------------------
-- Table structure for order_table
-- ----------------------------
DROP TABLE IF EXISTS `order_table`;
CREATE TABLE `order_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `shipping_id` int(11) DEFAULT NULL,
  `order_no` bigint(20) DEFAULT NULL,
  `payment` decimal(20,2) DEFAULT NULL,
  `payment_type` int(4) DEFAULT NULL,
  `postage` int(11) DEFAULT NULL,
  `status` int(10) DEFAULT NULL COMMENT '订单状态 0-已取消 1-未付款 2-已付款 4-已发货 5-交易成功 6-交易关闭',
  `payment_time` datetime DEFAULT NULL,
  `send_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `close_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `order_no` (`order_no`) USING BTREE,
  KEY `user_id` (`user_id`),
  KEY `shipping_id` (`shipping_id`),
  CONSTRAINT `order_table_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_table` (`id`),
  CONSTRAINT `order_table_ibfk_2` FOREIGN KEY (`shipping_id`) REFERENCES `shipping_table` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_table
-- ----------------------------

-- ----------------------------
-- Table structure for pay_info_table
-- ----------------------------
DROP TABLE IF EXISTS `pay_info_table`;
CREATE TABLE `pay_info_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `order_no` int(20) NOT NULL COMMENT '订单号',
  `pay_platform` int(10) DEFAULT NULL COMMENT '支付平台：1-支付宝 2-微信',
  `platform_number` varchar(200) DEFAULT NULL,
  `platform_status` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `order_no` (`order_no`),
  CONSTRAINT `pay_info_table_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_table` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pay_info_table
-- ----------------------------

-- ----------------------------
-- Table structure for product_table
-- ----------------------------
DROP TABLE IF EXISTS `product_table`;
CREATE TABLE `product_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `subtitle` varchar(255) DEFAULT NULL COMMENT '商品副标题',
  `main_image` varchar(500) DEFAULT NULL COMMENT '产品主图，url相对地址',
  `sub_image` text COMMENT '图片地址，json格式，扩展用',
  `detail` text,
  `price` decimal(20,2) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL COMMENT '库存数量',
  `status` int(6) DEFAULT '1' COMMENT '商品状态 1-在售 2-下架 3-删除',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `product_table_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category_table` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_table
-- ----------------------------
INSERT INTO `product_table` VALUES ('1', '1', '三星洗衣机', '三星大促销', 'test.jpg', 'test.jpg', 'detailtext', '2000.00', '100', '1', '2018-07-26 15:53:16', '2018-07-26 15:53:16');
INSERT INTO `product_table` VALUES ('2', '1', '飞利浦小电饭锅', '飞利浦小电饭锅电饭煲正品多功能家用智能小型单人迷你1-2-3-4人', '0001.jpg', '0001.jpg', '证书编号：2016010718855137证书状态：有效产品名称：电饭煲3C规格型号：HD3060, HD3160, HD3061, HD3161, 330W 2.0L 220V～ 50...产品名称：Philips/飞利浦 HD3160品牌: Philips/飞利浦型号: HD3160颜色分类: 黑色容量: 3L以下控制方式: 微电脑式电饭煲多功能: 预约 酸奶 煮饭内胆材质: 不粘涂层售后服务: 全国联保形状: 圆形加热方式: 底盘加热适用人数: 1人-2人', '319.00', '456', '1', '2018-07-29 14:55:20', '2018-07-29 14:55:25');
INSERT INTO `product_table` VALUES ('3', '2', '曲面22英寸液晶显示器', '全新曲面22英寸液晶显示器24 LED电脑显示屏27高清游戏办公曲屏', '0002.jpg', '0002.jpg', 'CCC证书编号: 2018010903048378屏幕类型: LED面板类型: IPS屏幕尺寸: 22英寸分辨率: 1920*1080（全高清）屏幕比例: 16:9刷新率: 其他曲率: 1800R水平可视角度: 178°垂直可视角度: 170°平均亮度: 300cd/m^2点距: 0.23mm黑白响应时间: 2毫秒灰阶响应时间: 2毫秒接口类型: VGA型号: T220AF品牌: 现代e窗型号: T220AF产地: 中国大陆颜色分类: 闪光银 大白 流光银 白橡色 珍珠白 黑 白 白色 乳白色 银色 黑色套餐类型: 官方标配能效等级: 二级能效备案号: 201607-14-1134954-11381977售后服务: 店铺三包成色: 全新', '459.00', '100', '1', '2018-07-29 14:58:09', '2018-07-29 14:58:12');
INSERT INTO `product_table` VALUES ('4', '2', '华硕 飞行堡垒 ZX50VX', 'Asus/华硕 飞行堡垒 ZX50VX吃鸡i7游戏笔记本电脑轻薄便携 学生i5', '0003.jpg', '0003.jpg', 'CCC证书编号: 2015010902753929产品名称: Asus/华硕 飞行堡垒 ZX50VX厚度: 20.0mm及以上机身重量（含电池）: 2.3kg版本类型: 中国大陆能效备案号: 无能效等级: 无品牌: Asus/华硕系列: 飞行堡垒型号: ZX50VX屏幕尺寸: 15.6英寸CPU: 英特尔 酷睿 i5-6300HQ显卡类型: NVIDIA GeForce GTX960M显存容量: 2G机械硬盘容量: 1TB固态硬盘: 128G SSD内存容量: 4GB光驱类型: DVD刻录适用场景: 移动工作站 家庭影音 女性定位 学生 商务办公 高清游戏 尊贵旗舰 家庭娱乐重量: 2kg(含)-2.5kg(不含)锂电池电芯数量: 6芯锂电池售后服务: 店铺三包颜色分类: A1号机 A2号机 A3号机 A4号机 A5号机 A6号机 A7号机 A8号机 A9号机 A10号机 A11号机 B1电竞游戏本 B2电竞游戏本 B3电竞游戏本 B4电竞游戏本 B5电竞游戏本 B6电竞游戏本 B7电竞游戏本 B8电竞游戏本 B9电竞游戏本 B10电竞游戏本操作系统: windows 10通信技术类型: 无线网卡 蓝牙输入设备: 触摸板套餐类型: 官方标配分辨率: 1920x1080是否触摸屏: 非触摸屏', '2880.00', '2', '1', '2018-07-29 15:02:13', '2018-07-29 15:02:16');
INSERT INTO `product_table` VALUES ('5', '3', '双肩包', '瑞士军刀双肩包瑞士商务中学生书包女休闲男士大容量旅行电脑背包', '0004.jpg', '0004.jpg', '大小: 中容纳电脑尺寸: 15英寸是否有背部缓冲棉: 是适用对象: 中年防水程度: 防泼水性别: 男质地: 涤纶提拎部件类型: 硬把闭合方式: 拉链搭扣内部结构: 拉链暗袋 手机袋 证件袋 夹层拉链袋 电脑插袋 相机插袋箱包外袋种类: 内贴袋流行元素: 机车图案: 纯色颜色分类: 15.6寸(送七+水壶+火机) 17寸(送七+水壶+火机) 15.6寸（裸包不带赠品） 17寸（裸包不带赠品） 15.6寸(促销送水壶+帽子) 17寸(促销送水壶+帽子) 15.6寸(促销送腰包推荐) 17寸(促销送腰包推荐) 15.6寸(送七+水壶+雨罩) 17寸(送七加水壶+雨罩)有无夹层: 有箱包硬度: 软是否可折叠: 否成色: 全新适用场景: 旅行品牌: 瑞士军刀货号: BDD812风格: 学院形状: 竖款方形肩带样式: 双根里料材质: 锦纶箱包尺寸: 48*33*23', '216.00', '20', '1', '2018-07-29 15:04:58', '2018-07-29 15:05:01');

-- ----------------------------
-- Table structure for shipping_table
-- ----------------------------
DROP TABLE IF EXISTS `shipping_table`;
CREATE TABLE `shipping_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `receiver_name` varchar(255) DEFAULT NULL,
  `receiver_phone` varchar(255) DEFAULT NULL,
  `receiver_mobile` varchar(255) DEFAULT NULL,
  `receiver_province` varchar(255) DEFAULT NULL,
  `receiver_city` varchar(255) DEFAULT NULL,
  `receiver_district` varchar(255) DEFAULT NULL,
  `receiver_address` varchar(255) DEFAULT NULL,
  `receiver_zip` varchar(255) DEFAULT NULL COMMENT '邮编',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `shipping_table_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_table` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shipping_table
-- ----------------------------
INSERT INTO `shipping_table` VALUES ('2', '1', 'b', '1321654654', '1321654654', '广东省', '梅州', '', '23号', '510000', '2018-07-30 13:35:43', '2018-07-30 13:35:43');
INSERT INTO `shipping_table` VALUES ('3', '1', 'a', '1234567890', '1234567890', '广东省', '广州', '', '200号', '510000', null, '2018-07-30 15:03:46');

-- ----------------------------
-- Table structure for user_table
-- ----------------------------
DROP TABLE IF EXISTS `user_table`;
CREATE TABLE `user_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `answer` varchar(255) NOT NULL,
  `question` varchar(255) NOT NULL,
  `role` int(4) NOT NULL DEFAULT '0',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_table
-- ----------------------------
INSERT INTO `user_table` VALUES ('1', '123', '81DC9BDB52D04DC20036DBD8313ED055', '1@qq.com', '1234', '1234', '1234', '0', '2018-07-20 11:58:32', '2018-07-20 15:02:13');
INSERT INTO `user_table` VALUES ('2', '123456', 'E10ADC3949BA59ABBE56E057F20F883E', '1234567890@qq.com', '123456789100', '1230', '1230', '0', '2018-07-20 13:03:38', '2018-07-20 13:03:38');
INSERT INTO `user_table` VALUES ('3', 'a', 'E10ADC3949BA59ABBE56E057F20F883E', '13@qq.com', '1111', '111', '111', '1', '2018-07-21 15:36:14', '2018-07-21 15:36:44');
