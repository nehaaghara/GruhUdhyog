/*
SQLyog Community v13.0.1 (64 bit)
MySQL - 5.7.19 : Database - gruhudhyog
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`gruhudhyog` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `gruhudhyog`;

/*Table structure for table `tbl_brand` */

DROP TABLE IF EXISTS `tbl_brand`;

CREATE TABLE `tbl_brand` (
  `brandname` varchar(20) DEFAULT NULL,
  `categoryFk` bigint(30) DEFAULT NULL,
  `brandid` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdDate` date DEFAULT NULL,
  `createdBy` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`brandid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_brand` */

insert  into `tbl_brand`(`brandname`,`categoryFk`,`brandid`,`createdDate`,`createdBy`) values 
('Cluster',3,2,'2019-03-07',4),
('nike',3,4,'2019-03-07',4),
('aaaaaa',3,5,'2019-03-08',1),
('aedwrewgdfgfd',3,6,'2019-03-08',1);

/*Table structure for table `tbl_category` */

DROP TABLE IF EXISTS `tbl_category`;

CREATE TABLE `tbl_category` (
  `categoryPK` bigint(20) NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(30) DEFAULT NULL,
  `createdBy` bigint(20) DEFAULT NULL,
  `createdOn` datetime DEFAULT NULL,
  `image` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`categoryPK`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_category` */

insert  into `tbl_category`(`categoryPK`,`categoryName`,`createdBy`,`createdOn`,`image`) values 
(1,'Snacks',2,'2019-03-07 00:00:00',NULL),
(3,'Cloths',1,'2019-03-07 00:00:00',NULL),
(4,'Art Work',2,'2019-03-07 00:00:00',NULL),
(6,'Dairy Farm',2,'2019-03-07 00:00:00',NULL),
(5,'Nursery',2,'2019-03-07 00:00:00',NULL);

/*Table structure for table `tbl_product` */

DROP TABLE IF EXISTS `tbl_product`;

CREATE TABLE `tbl_product` (
  `productPK` bigint(20) NOT NULL AUTO_INCREMENT,
  `categoryFK` bigint(20) DEFAULT NULL,
  `productName` varchar(30) DEFAULT NULL,
  `isActive` int(20) DEFAULT NULL,
  `createdBy` bigint(30) DEFAULT NULL,
  `createdOn` datetime DEFAULT NULL,
  PRIMARY KEY (`productPK`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_product` */

insert  into `tbl_product`(`productPK`,`categoryFK`,`productName`,`isActive`,`createdBy`,`createdOn`) values 
(1,3,'Khakhra',1,2,'2019-03-07 19:29:19'),
(5,1,'Khakhra',1,2,'2019-03-07 19:30:30');

/*Table structure for table `tbl_sellerproductimagemapping` */

DROP TABLE IF EXISTS `tbl_sellerproductimagemapping`;

CREATE TABLE `tbl_sellerproductimagemapping` (
  `sellerProductImagePk` bigint(20) NOT NULL AUTO_INCREMENT,
  `sellerProductFk` bigint(20) DEFAULT NULL,
  `imagePath` varchar(30) DEFAULT NULL,
  `createdDate` date DEFAULT NULL,
  `createdBy` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`sellerProductImagePk`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `tbl_sellerproductimagemapping` */

/*Table structure for table `tbl_user` */

DROP TABLE IF EXISTS `tbl_user`;

CREATE TABLE `tbl_user` (
  `userid` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `email_address` varchar(40) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `phonenumber` bigint(20) DEFAULT NULL,
  `roleFK` bigint(20) DEFAULT NULL,
  `createdDate` date DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_user` */

insert  into `tbl_user`(`userid`,`first_name`,`last_name`,`email_address`,`password`,`phonenumber`,`roleFK`,`createdDate`) values 
(1,'vikas','hingu','vikas34@bnjkvn.com','vikas',1213546789,2,NULL),
(2,'admin','admin','admin123@gmail.com','123',9825434543,1,NULL);

/*Table structure for table `tbl_userrole` */

DROP TABLE IF EXISTS `tbl_userrole`;

CREATE TABLE `tbl_userrole` (
  `rolePK` bigint(20) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(30) DEFAULT NULL,
  `isActive` int(20) DEFAULT NULL,
  PRIMARY KEY (`rolePK`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_userrole` */

insert  into `tbl_userrole`(`rolePK`,`roleName`,`isActive`) values 
(1,'admin',1),
(2,'seller',1),
(3,'user',1);

/*Table structure for table `tblsellerproduct` */

DROP TABLE IF EXISTS `tblsellerproduct`;

CREATE TABLE `tblsellerproduct` (
  `productId` bigint(20) NOT NULL AUTO_INCREMENT,
  `brandFK` bigint(20) DEFAULT NULL,
  `productName` varchar(20) DEFAULT NULL,
  `productPrice` double DEFAULT NULL,
  `productImage` varchar(100) DEFAULT NULL,
  `discount` varchar(20) DEFAULT NULL,
  `productStock` int(20) DEFAULT NULL,
  `productDiscription` varchar(20) DEFAULT NULL,
  `createdDate` date DEFAULT NULL,
  `createdBy` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`productId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `tblsellerproduct` */

insert  into `tblsellerproduct`(`productId`,`brandFK`,`productName`,`productPrice`,`productImage`,`discount`,`productStock`,`productDiscription`,`createdDate`,`createdBy`) values 
(3,4,'shoes',5000,'cdcdcc','20%',50,'flexible','2019-03-08',4),
(4,5,'gfdgfd',0,NULL,'10',0,'dfcsdfsdf','2019-03-08',1),
(5,6,'gfdgfd',12,NULL,'10',123,'werwwqd','2019-03-08',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
