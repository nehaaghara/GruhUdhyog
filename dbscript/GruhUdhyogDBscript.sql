/*
SQLyog Enterprise Trial - MySQL GUI v7.11 
MySQL - 5.6.12-log : Database - gruhudhyog
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`gruhudhyog` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `gruhudhyog`;

/*Table structure for table `sign_up` */

DROP TABLE IF EXISTS `sign_up`;

CREATE TABLE `sign_up` (
  `userid` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `email_address` varchar(40) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `phonenumber` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `sign_up` */

insert  into `sign_up`(`userid`,`first_name`,`last_name`,`email_address`,`password`,`phonenumber`) values (1,'vikas','hingu','vikas34@bnjkvn.com','vikas',1213546789);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
