/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.51 : Database - ssm-druid
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ssm-druid` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ssm-druid`;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id，自动增长',
  `phone` varchar(15) NOT NULL COMMENT '手机（登录账号）',
  `password` varchar(112) NOT NULL COMMENT '密码',
  `nickname` varchar(15) DEFAULT NULL COMMENT '昵称',
  `address` varchar(64) DEFAULT NULL COMMENT '联系地址',
  `age` int(11) DEFAULT '0' COMMENT '年龄',
  `sex` int(11) DEFAULT '1' COMMENT '性别（0女，1男）',
  `user_info` text COMMENT '简介',
  `headicon` varchar(500) DEFAULT NULL COMMENT '头像',
  `register_time` varchar(32) DEFAULT NULL COMMENT '注册时间',
  `permission` int(11) NOT NULL DEFAULT '0' COMMENT '权限（0普通用户，1可接单用户，2被禁用用户）',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`user_id`,`phone`,`password`,`nickname`,`address`,`age`,`sex`,`user_info`,`headicon`,`register_time`,`permission`) values (1,'18219111620','123456','吴乃福','1',0,1,'个人简介18219111620','icon001.png','20180101',-1),(2,'18219111621','123456','吴乃福','1',0,1,'个人简介18219111621','icon001.png','20180101',-1),(3,'18219111622','123456','吴乃福','1',0,1,'个人简介18219111622','icon001.png','20180101',-1),(4,'18219111623','123456','吴乃福',NULL,1,0,'个人简介18219111623','icon001.png','20180101',-1),(5,'18219111624','123456','吴乃福',NULL,0,0,'个人简介18219111624','icon001.png','20180101',-1),(6,'18219111625','123456','吴乃福',NULL,1,1,'个人简介18219111625','icon001.png','20180101',-1),(7,'18219111626','123456','吴乃福',NULL,1,1,'个人简介18219111626','icon001.png','20180101',-1),(8,'18219111627','123456','吴乃福',NULL,0,1,'个人简介18219111627','icon001.png','20180101',-1),(9,'18219111628','123456','吴乃福','sdaf',0,1,'个人简介18219111628','icon001.png','20180101',-1),(10,'18219111629','123456','吴乃福',NULL,0,1,'个人简介18219111629','icon001.png','20180101',-1),(11,'18219111630','123456','吴乃福',NULL,0,1,'个人简介18219111630','icon001.png','20180101',-1),(12,'18219111631','123456','吴乃福','dsf',0,1,'个人简介18219111631','icon001.png','20180101',-1),(13,'18219111632','123456','吴乃福','sadf',0,1,'个人简介18219111632','icon001.png','20180101',0),(14,'123','123456','吴乃福',NULL,NULL,NULL,'个人简介123','icon001.png','20180101',-1),(16,'1234','123456','吴乃福',NULL,NULL,NULL,'个人简介1234','icon001.png','20180101',-1),(17,'18219111633','123456','吴乃福',NULL,0,1,'个人简介18219111633','icon001.png','20180101',-1),(18,'18219111634','123456','吴乃福',NULL,0,1,'个人简介18219111634','icon001.png','20180101',-1),(19,'18219111635','123456','吴乃福',NULL,0,1,'个人简介18219111635','icon001.png','20180101',-1),(20,'18219111636','123456','吴乃福',NULL,0,1,'个人简介18219111636','icon001.png','20180101',-1),(25,'123121313','123456','吴乃福',NULL,0,1,'个人简介123121313','icon001.png','20180101',-1),(26,'2313123','123456','吴乃福',NULL,0,1,'个人简介2313123','icon001.png','20180101',-1),(27,'wngg','123456','吴乃福',NULL,0,1,'个人简介wngg','icon001.png','20180101',-1),(32,'wngg11','123456','吴乃福',NULL,0,1,'个人简介wngg11','icon001.png','20180101',-1),(33,'wngg12','123456','吴乃福',NULL,0,1,'个人简介wngg12','icon001.png','20180101',-1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
