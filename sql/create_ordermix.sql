/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.0.23 : Database - ordermix
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ordermix` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `ordermix`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `admin_id` int NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `real_name` varchar(255) DEFAULT NULL,
  `contact_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`admin_id`,`admin_name`,`password`,`real_name`,`contact_number`) values (1,'hjy','123','大肚腩妹妹','13579246811'),(4,'ljs','123','我爱打码','12345678901'),(5,'ljh','123','无言的靓仔','12345678998'),(6,'slw','123','没良心狗狗',NULL),(7,'sxp','123','百宝袋被狗叼走了',NULL),(8,'xjy','123','草莓味腊肉',NULL);

/*Table structure for table `adshow` */

DROP TABLE IF EXISTS `adshow`;

CREATE TABLE `adshow` (
  `ad_id` int NOT NULL,
  `ad_name` varchar(255) DEFAULT NULL,
  `ad_src` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ad_introduce` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ad_adminId` int DEFAULT NULL,
  PRIMARY KEY (`ad_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `adshow` */

insert  into `adshow`(`ad_id`,`ad_name`,`ad_src`,`ad_introduce`,`ad_adminId`) values (1,'你有生之年见过的最优秀做作品','http://pic1.win4000.com/wallpaper/5/5565394b138e0_270_185.jpg','全体成员呕心沥血历时100天惊天地作品，全学院无人超越。',5),(2,'登上学院展板的海报','https://ai.bdstatic.com/file/81FA641137F740F5849BC6FC1FD19984','学院领导眼睛都瞎了',5),(3,'引领学院新风潮','https://5b0988e595225.cdn.sohucs.com/q_70,c_zoom,w_640/images/20200225/19d17e39309047c48e022091b982e497.jpeg','哦',5),(4,'北苑下雪了','https://ss0.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3687837806,645327575&fm=15&gp=0.jpg','',5);

/*Table structure for table `item` */

DROP TABLE IF EXISTS `item`;

CREATE TABLE `item` (
  `item_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `end_time` date DEFAULT NULL,
  `finished_time` datetime DEFAULT NULL,
  `item_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `requirement` varchar(255) DEFAULT NULL,
  `refuse_message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `contact_name` varchar(255) DEFAULT NULL,
  `contact_number` varchar(255) DEFAULT NULL,
  `admin_id` int DEFAULT NULL,
  `item_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `upload_address` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `download_address` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

/*Data for the table `item` */

insert  into `item`(`item_id`,`user_id`,`create_time`,`end_time`,`finished_time`,`item_type`,`requirement`,`refuse_message`,`contact_name`,`contact_number`,`admin_id`,`item_status`,`upload_address`,`download_address`) values (11,1,'2022-03-09 12:41:19','2050-06-23',NULL,'ppt','我想要精美的ppt',NULL,'小花','13524855484',NULL,'toBeSolved','C:\\Users\\Administrator\\Desktop\\拼客校园拼单平台1.13.docx',NULL),(12,1,'2022-03-09 12:41:20','2050-06-23',NULL,'ppt','我想要精美的ppt我想要精美的ppt我想要精美的ppt我想要精美的ppt我想要精美的ppt我想要精美的ppt我想要精美的ppt我想要精美的ppt我想要精美的ppt我想要精美的ppt我想要精美的ppt我想要精美的ppt',NULL,'小花','13524855484',5,'toBeFinished','C:\\Users\\Administrator\\Desktop\\拼客校园拼单平台1.13.docx',NULL),(13,1,'2022-03-09 12:41:20','2050-06-23',NULL,'ppt','我想要精美的ppt',NULL,'小花','13524855484',5,'toBeFinished','C:\\Users\\Administrator\\Desktop\\拼客校园拼单平台1.13.docx',NULL),(14,1,'2022-03-09 12:41:20','2050-06-23',NULL,'ppt','我想要精美的ppt',NULL,'小花','13524855484',NULL,'toBeSolved','C:\\Users\\Administrator\\Desktop\\拼客校园拼单平台1.13.docx',NULL),(15,1,'2022-03-09 12:41:20','2050-06-23',NULL,'ppt','我想要精美的ppt',NULL,'小花','13524855484',NULL,'toBeSolved','C:\\Users\\Administrator\\Desktop\\拼客校园拼单平台1.13.docx',NULL),(16,1,'2022-03-09 12:41:20','2050-06-23',NULL,'ppt','我想要精美的ppt',NULL,'小花','13524855484',NULL,'toBeSolved','C:\\Users\\Administrator\\Desktop\\拼客校园拼单平台1.13.docx',NULL),(17,1,'2022-03-09 12:41:20','2050-06-23',NULL,'ppt','我想要精美的ppt',NULL,'小花','13524855484',NULL,'toBeSolved','C:\\Users\\Administrator\\Desktop\\拼客校园拼单平台1.13.docx',NULL),(18,1,'2022-03-09 12:41:20','2050-06-23',NULL,'ppt','我想要精美的ppt',NULL,'小花','13524855484',NULL,'toBeSolved','C:\\Users\\Administrator\\Desktop\\拼客校园拼单平台1.13.docx',NULL),(19,1,'2022-03-09 12:41:20','2050-06-23','2022-03-11 16:35:15','ppt','我想要精美的ppt',NULL,'小花','13524855484',5,'finished','C:\\Users\\Administrator\\Desktop\\拼客校园拼单平台1.13.docx','www.baidu.com'),(20,1,'2022-03-09 12:41:21','2050-06-23','2022-03-11 16:35:15','ppt','我想要精美的ppt',NULL,'小花','13524855484',5,'finished','C:\\Users\\Administrator\\Desktop\\拼客校园拼单平台1.13.docx','www.baidu.com'),(21,1,'2022-03-09 12:42:40','2050-06-23',NULL,'ppt','我想要精美的ppt',NULL,'小花','13524855484',NULL,'toBeSolved','C:\\Users\\Administrator\\Desktop\\拼客校园拼单平台1.13.docx',NULL),(22,1,'2022-03-09 12:42:40','2050-06-23','2022-03-11 16:35:04','ppt','我想要精美的ppt',NULL,'小花','13524855484',5,'finished','C:\\Users\\Administrator\\Desktop\\拼客校园拼单平台1.13.docx','www.baidu.com'),(23,1,'2022-03-09 12:42:40','2050-06-23',NULL,'ppt','我想要精美的ppt',NULL,'小花','13524855484',NULL,'toBeSolved','C:\\Users\\Administrator\\Desktop\\拼客校园拼单平台1.13.docx',NULL),(24,1,'2022-03-09 12:42:40','2050-06-23','2022-03-11 16:35:05','ppt','我想要精美的ppt',NULL,'小花','13524855484',5,'finished','C:\\Users\\Administrator\\Desktop\\拼客校园拼单平台1.13.docx','www.baidu.com'),(25,1,'2022-03-09 12:42:40','2050-06-23',NULL,'ppt','我想要精美的ppt',NULL,'小花','13524855484',NULL,'toBeSolved','C:\\Users\\Administrator\\Desktop\\拼客校园拼单平台1.13.docx',NULL),(26,1,'2022-03-09 12:42:41','2050-06-23',NULL,'ppt','我想要精美的ppt',NULL,'小花','13524855484',NULL,'toBeSolved','C:\\Users\\Administrator\\Desktop\\拼客校园拼单平台1.13.docx',NULL),(27,1,'2022-03-09 12:42:41','2050-06-23',NULL,'ppt','我想要精美的ppt',NULL,'小花','13524855484',NULL,'toBeSolved','C:\\Users\\Administrator\\Desktop\\拼客校园拼单平台1.13.docx',NULL),(28,1,'2022-03-09 12:42:41','2050-06-23',NULL,'ppt','我想要精美的ppt',NULL,'小花','13524855484',NULL,'toBeSolved','C:\\Users\\Administrator\\Desktop\\拼客校园拼单平台1.13.docx',NULL),(29,1,'2022-03-09 12:42:41','2050-06-23',NULL,'ppt','我想要精美的ppt',NULL,'小花','13524855484',NULL,'toBeSolved','C:\\Users\\Administrator\\Desktop\\拼客校园拼单平台1.13.docx',NULL),(30,1,'2022-03-09 12:42:41','2050-06-23',NULL,'ppt','我想要精美的ppt',NULL,'小花','13524855484',NULL,'toBeSolved','C:\\Users\\Administrator\\Desktop\\拼客校园拼单平台1.13.docx',NULL),(31,1,'2022-03-11 11:42:40','2050-06-23',NULL,'ppt','我想要精美的ppt',NULL,'小花','13524855484',NULL,'toBeSolved','fileAddress','g'),(32,1,'2022-03-11 11:42:41','2050-06-23',NULL,'ppt','我想要精美的ppt',NULL,'小花','13524855484',NULL,'toBeSolved','fileAddress','g'),(33,1,'2022-03-11 11:42:41','2050-06-23',NULL,'ppt','我想要精美的ppt',NULL,'小花','13524855484',NULL,'toBeSolved','fileAddress','g'),(34,1,'2022-03-11 11:42:41','2050-06-23',NULL,'ppt','我想要精美的ppt',NULL,'小花','13524855484',NULL,'toBeSolved','fileAddress','g'),(35,1,'2022-03-11 11:42:41','2050-06-23',NULL,'ppt','我想要精美的ppt',NULL,'小花','13524855484',NULL,'toBeSolved','fileAddress','g'),(36,1,'2022-03-11 11:42:41','2050-06-23',NULL,'ppt','我想要精美的ppt',NULL,'小花','13524855484',NULL,'toBeSolved','fileAddress','g'),(37,1,'2022-03-11 11:42:42','2050-06-23',NULL,'ppt','我想要精美的ppt',NULL,'小花','13524855484',NULL,'toBeSolved','fileAddress','g'),(38,1,'2022-03-11 11:42:42','2050-06-23',NULL,'ppt','我想要精美的ppt',NULL,'小花','13524855484',NULL,'toBeSolved','fileAddress','g'),(39,1,'2022-03-11 11:42:42','2050-06-23',NULL,'ppt','我想要精美的ppt',NULL,'小花','13524855484',NULL,'toBeSolved','fileAddress','g'),(40,1,'2022-03-11 11:42:42','2050-06-23',NULL,'ppt','我想要精美的ppt',NULL,'小花','13524855484',NULL,'toBeSolved','fileAddress','g');

/*Table structure for table `rollad` */

DROP TABLE IF EXISTS `rollad`;

CREATE TABLE `rollad` (
  `img_id` int NOT NULL AUTO_INCREMENT,
  `img_src` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`img_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `rollad` */

insert  into `rollad`(`img_id`,`img_src`) values (1,'https://gildedwallpapers.com/wp-content/uploads/2020/01/super-smash-bros-ultimate-toon-link-uhd-4k-wallpaper.jpg'),(2,'https://pic1.zhimg.com/80/v2-087e0dcc3f9be1baf3c2559f3257162a_1440w.jpg'),(3,'http://bos.pgzs.com/rbpiczy/Wallpaper/2012/9/3/5c922a43a111431184f87e9032fe10cc-3.jpg');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `stu_num` varchar(255) DEFAULT NULL,
  `real_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`user_id`,`username`,`password`,`stu_num`,`real_name`) values (1,'user1','123','124255','wayne'),(2,'user2','123','1235514','lizard');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
