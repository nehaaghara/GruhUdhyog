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
  `brandPk` bigint(20) NOT NULL AUTO_INCREMENT,
  `productFk` bigint(20) DEFAULT NULL,
  `brandName` varchar(30) DEFAULT NULL,
  `createdBy` bigint(20) DEFAULT NULL,
  `createdOn` datetime DEFAULT NULL,
  PRIMARY KEY (`brandPk`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_brand` */

insert  into `tbl_brand`(`brandPk`,`productFk`,`brandName`,`createdBy`,`createdOn`) values 
(8,1,'jeans',2,'2019-03-11 00:00:00'),
(9,10,'aaaaaa',2,'2019-03-11 18:47:36'),
(13,1,'aaaaaa',1,'2019-03-11 18:58:58');

/*Table structure for table `tbl_category` */

DROP TABLE IF EXISTS `tbl_category`;

CREATE TABLE `tbl_category` (
  `categoryPK` bigint(20) NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(30) DEFAULT NULL,
  `createdBy` bigint(20) DEFAULT NULL,
  `createdOn` datetime DEFAULT NULL,
  PRIMARY KEY (`categoryPK`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_category` */

insert  into `tbl_category`(`categoryPK`,`categoryName`,`createdBy`,`createdOn`) values 
(1,'Snacks',2,'2019-03-07 00:00:00'),
(3,'Cloths',1,'2019-03-07 00:00:00'),
(4,'Art Work',2,'2019-03-07 00:00:00'),
(6,'Dairy Farm',2,'2019-03-07 00:00:00'),
(5,'Nursery',2,'2019-03-07 00:00:00');

/*Table structure for table `tbl_product` */

DROP TABLE IF EXISTS `tbl_product`;

CREATE TABLE `tbl_product` (
  `productPK` bigint(20) NOT NULL AUTO_INCREMENT,
  `categoryFK` bigint(20) DEFAULT NULL,
  `productName` varchar(30) DEFAULT NULL,
  `productPrice` double DEFAULT NULL,
  `discount` varchar(30) DEFAULT NULL,
  `productStock` int(20) DEFAULT NULL,
  `productDiscription` varchar(300) DEFAULT NULL,
  `createdBy` bigint(30) DEFAULT NULL,
  `createdOn` date DEFAULT NULL,
  PRIMARY KEY (`productPK`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_product` */

insert  into `tbl_product`(`productPK`,`categoryFK`,`productName`,`productPrice`,`discount`,`productStock`,`productDiscription`,`createdBy`,`createdOn`) values 
(1,3,'Khakhra',200,'10',2,'1',1,'2019-03-07'),
(6,3,'jeans',123,'10',12,'asda',1,'2019-03-11'),
(7,3,'jeans',123,'10',12,'asda',1,'2019-03-11'),
(8,3,'jeans',12334,'10',123,'qweqeqw',1,'2019-03-11'),
(9,3,'jeans',12334,'10',123,'qeqweqwe',2,'2019-03-11'),
(10,3,'tops',12334,'12',2,'dwqe',2,'2019-03-11'),
(11,3,'tops',12334,'12',2,'dwqe',2,'2019-03-11'),
(18,3,'jeans',1233,'10',3,'wqrewrw',1,'2019-03-11');

/*Table structure for table `tbl_productimagemapping` */

DROP TABLE IF EXISTS `tbl_productimagemapping`;

CREATE TABLE `tbl_productimagemapping` (
  `adminProductImagePk` bigint(20) NOT NULL AUTO_INCREMENT,
  `adminProductFk` bigint(20) DEFAULT NULL,
  `imagePath` varchar(500) DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `createdBy` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`adminProductImagePk`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_productimagemapping` */

insert  into `tbl_productimagemapping`(`adminProductImagePk`,`adminProductFk`,`imagePath`,`createdDate`,`createdBy`) values 
(9,17,'\\home\\gruhudhyog\\ProductImages\\Cloths\\jeans\\f478e9a0-81d3-42b6-a697-ed17fbdbb016.jpg','2019-03-11 00:00:00',2),
(10,17,'\\home\\gruhudhyog\\ProductImages\\Cloths\\jeans\\3434d9f2-10c4-4e60-9ff4-64e54a682405.jpg','2019-03-11 00:00:00',2),
(11,17,'\\home\\gruhudhyog\\ProductImages\\Cloths\\jeans\\0f59187b-9496-4fe8-879f-d73d40938cf8.jpg','2019-03-11 00:00:00',2),
(12,17,'\\home\\gruhudhyog\\ProductImages\\Cloths\\jeans\\4f1b30c5-0117-4498-bc0a-828a1064d4ad.jpg','2019-03-11 00:00:00',2),
(13,17,'\\home\\gruhudhyog\\ProductImages\\Cloths\\jeans\\564bcf89-cfda-4b97-af0c-5b3387fa08fa.jpg','2019-03-11 00:00:00',2),
(14,17,'\\home\\gruhudhyog\\ProductImages\\Cloths\\jeans\\7772be76-bee5-418e-bc16-c82db2b5cd48.jpg','2019-03-11 00:00:00',2),
(17,18,'\\home\\gruhudhyog\\ProductImages\\Cloths\\jeans\\be57d38d-637d-49e7-b2f3-9276bee7cf1e.jpg','2019-03-11 00:00:00',1),
(18,19,'\\home\\gruhudhyog\\ProductImages\\Snacks\\wafers\\4cd8bd30-7f31-4d6b-8c29-943235600a79.png','2019-03-11 17:54:06',1),
(19,20,'\\home\\gruhudhyog\\ProductImages\\Snacks\\tops\\21f181cf-ec82-470f-91bf-af44d4085176.png','2019-03-11 18:09:51',2);

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

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
