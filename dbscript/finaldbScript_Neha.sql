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

/*Table structure for table `tbl_cart` */

DROP TABLE IF EXISTS `tbl_cart`;

CREATE TABLE `tbl_cart` (
  `cartPK` bigint(20) NOT NULL AUTO_INCREMENT,
  `productFK` bigint(20) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `isOrder` tinyint(1) DEFAULT NULL,
  `isActive` tinyint(1) DEFAULT NULL,
  `createdDate` date DEFAULT NULL,
  `createdBy` bigint(20) DEFAULT NULL,
  `totalPrice` double DEFAULT NULL,
  PRIMARY KEY (`cartPK`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_cart` */

insert  into `tbl_cart`(`cartPK`,`productFK`,`quantity`,`isOrder`,`isActive`,`createdDate`,`createdBy`,`totalPrice`) values 
(34,36,1,1,1,'2019-03-19',1,60),
(37,38,1,1,1,'2019-03-19',1,45),
(40,38,1,0,1,'2019-03-19',1,45),
(41,35,1,1,1,'2019-03-19',1,152),
(44,36,1,0,1,'2019-03-26',1,60),
(49,41,1,1,1,'2019-03-27',1,569),
(50,41,1,0,1,'2019-03-27',1,569),
(51,36,1,1,1,'2019-03-27',3,60),
(52,35,1,1,1,'2019-03-27',3,152),
(54,39,1,1,1,'2019-03-27',3,51),
(55,42,1,1,1,'2019-03-27',3,2323),
(57,37,1,1,1,'2019-03-27',3,159),
(58,36,1,0,1,'2019-03-27',3,60);

/*Table structure for table `tbl_category` */

DROP TABLE IF EXISTS `tbl_category`;

CREATE TABLE `tbl_category` (
  `categoryPK` bigint(20) NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(30) DEFAULT NULL,
  `createdBy` bigint(20) DEFAULT NULL,
  `createdOn` datetime DEFAULT NULL,
  PRIMARY KEY (`categoryPK`)
) ENGINE=MyISAM AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_category` */

insert  into `tbl_category`(`categoryPK`,`categoryName`,`createdBy`,`createdOn`) values 
(1,'Snacks',2,'2019-03-07 00:00:00'),
(3,'Cloths',1,'2019-03-07 00:00:00'),
(4,'Art Work',2,'2019-03-07 00:00:00'),
(6,'Dairy Farm',2,'2019-03-07 00:00:00'),
(5,'Nursery',2,'2019-03-07 00:00:00'),
(8,'njknjkdc',2,'2019-03-12 18:20:45'),
(7,'njknjkdc',2,'2019-03-12 18:20:47'),
(9,'njknjkdc',2,'2019-03-12 18:20:48'),
(10,'njknjkdc',2,'2019-03-12 18:20:49'),
(11,'njknjkdc',2,'2019-03-12 18:20:51'),
(12,'njknjkdc',2,'2019-03-12 18:21:04');

/*Table structure for table `tbl_order` */

DROP TABLE IF EXISTS `tbl_order`;

CREATE TABLE `tbl_order` (
  `orderPK` bigint(20) NOT NULL AUTO_INCREMENT,
  `orderno` int(11) DEFAULT NULL,
  `orderdeliverydate` date DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `orderTotal` double DEFAULT NULL,
  `paymentFK` bigint(100) DEFAULT NULL,
  `isPaid` tinyint(1) DEFAULT NULL,
  `createdBy` bigint(20) DEFAULT NULL,
  `createdon` date DEFAULT NULL,
  PRIMARY KEY (`orderPK`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_order` */

insert  into `tbl_order`(`orderPK`,`orderno`,`orderdeliverydate`,`address`,`orderTotal`,`paymentFK`,`isPaid`,`createdBy`,`createdon`) values 
(1,857455,'2019-04-06',NULL,281,1,0,1,'2019-03-27'),
(2,316154,'2019-04-06','INMLqawsqwbdcdcbchbcbPinCode34253456',805,1,0,1,'2019-03-27'),
(3,437870,'2019-04-06','INMLqawsqwbdcdcbchbcbPinCode34253456',805,1,0,1,'2019-03-27'),
(4,469459,'2019-04-06','INMLqawsqwbdcdcbchbcbPinCode34253456',591,1,0,1,'2019-03-27'),
(5,229755,'2019-04-06',NULL,151,1,0,3,'2019-03-27'),
(6,685120,'2019-04-06',NULL,265,1,0,3,'2019-03-27'),
(7,327303,'2019-04-06',NULL,151,1,0,3,'2019-03-27'),
(8,245339,'2019-04-06',NULL,6,1,0,3,'2019-03-27'),
(9,17682,'2019-04-06',NULL,2267,1,0,3,'2019-03-27'),
(10,692726,'2019-04-06',NULL,114,1,0,3,'2019-03-27'),
(11,129669,'2019-04-06','INASahmedabad11/5698 shahibaug damrucirclePinCode380016',118,1,0,3,'2019-03-27');

/*Table structure for table `tbl_orderproduct` */

DROP TABLE IF EXISTS `tbl_orderproduct`;

CREATE TABLE `tbl_orderproduct` (
  `orderproductPK` bigint(20) NOT NULL AUTO_INCREMENT,
  `orderFK` bigint(20) DEFAULT NULL,
  `productFK` bigint(20) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderproductPK`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_orderproduct` */

/*Table structure for table `tbl_paymentsmethod` */

DROP TABLE IF EXISTS `tbl_paymentsmethod`;

CREATE TABLE `tbl_paymentsmethod` (
  `paymentmethodPk` bigint(20) NOT NULL AUTO_INCREMENT,
  `mathodName` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`paymentmethodPk`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_paymentsmethod` */

insert  into `tbl_paymentsmethod`(`paymentmethodPk`,`mathodName`) values 
(1,'Cash On Deivery');

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
  `createdOn` date DEFAULT '0000-00-00',
  PRIMARY KEY (`productPK`)
) ENGINE=MyISAM AUTO_INCREMENT=45 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_product` */

insert  into `tbl_product`(`productPK`,`categoryFK`,`productName`,`productPrice`,`discount`,`productStock`,`productDiscription`,`createdBy`,`createdOn`) values 
(1,3,'Khakhra',200,'0',2,'1',1,'2019-03-07'),
(6,3,'jeans',123,'0',12,'asda',1,'2019-03-11'),
(7,3,'top',123,'0',12,'asda',1,'2019-03-11'),
(8,3,'jeans',12334,'0',123,'qweqeqw',1,'2019-03-11'),
(9,3,'jeans',12334,'0',123,'qeqweqwe',2,'2019-03-11'),
(10,3,'tops',12334,'0',2,'dwqe',2,'2019-03-11'),
(11,3,'tops',12334,'0',2,'dwqe',2,'2019-03-11'),
(18,3,'jeans',1233,'0',3,'wqrewrw',1,'2019-03-11'),
(19,3,'cefer',123,'0',2,'hgh',1,'2019-03-11'),
(39,4,'pateto',51,'45',23,'csvcsvfv',2,'2019-03-14'),
(38,3,'cdcsd',45,'1',25,'dcsdcsdcc',2,'2019-03-14'),
(37,3,'shirt',159,'45',50,'good quality',2,'2019-03-14'),
(36,4,'sketch',60,'56',10,'deddwd',2,'2019-03-14'),
(35,1,'pateto',152,'5',15,'xqwxqwx',2,'2019-03-14'),
(34,5,'dcd',40,'5',80,'csdcsdc',2,'2019-03-14'),
(33,6,'milk',20,'5',20,'testy',2,'2019-03-14'),
(40,1,'cdcsd',569,'45',56,'vdfvfv',2,'2019-03-14'),
(41,3,'patola',569,'45',23,'nnnnnnnnnn',2,'2019-03-14'),
(42,4,'k.kl.l',2323,'56',56,'bm,jhjh',2,'2019-03-14'),
(43,1,'mamra',20,'1',20,'nxjjnxjskndj',2,'2019-03-14'),
(44,1,'mamra',20,'1',20,'nxjjnxjskndj',2,'2019-03-14');

/*Table structure for table `tbl_productimagemapping` */

DROP TABLE IF EXISTS `tbl_productimagemapping`;

CREATE TABLE `tbl_productimagemapping` (
  `adminProductImagePk` bigint(20) NOT NULL AUTO_INCREMENT,
  `adminProductFk` bigint(20) DEFAULT NULL,
  `imagePath` varchar(500) DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `createdBy` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`adminProductImagePk`)
) ENGINE=MyISAM AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_productimagemapping` */

insert  into `tbl_productimagemapping`(`adminProductImagePk`,`adminProductFk`,`imagePath`,`createdDate`,`createdBy`) values 
(9,6,'\\home\\gruhudhyog\\ProductImages\\Cloths\\jeans\\f478e9a0-81d3-42b6-a697-ed17fbdbb016.jpg','2019-03-11 00:00:00',2),
(10,7,'\\home\\gruhudhyog\\ProductImages\\Cloths\\jeans\\3434d9f2-10c4-4e60-9ff4-64e54a682405.jpg','2019-03-11 00:00:00',2),
(11,8,'\\home\\gruhudhyog\\ProductImages\\Cloths\\jeans\\0f59187b-9496-4fe8-879f-d73d40938cf8.jpg','2019-03-11 00:00:00',2),
(12,9,'\\home\\gruhudhyog\\ProductImages\\Cloths\\jeans\\4f1b30c5-0117-4498-bc0a-828a1064d4ad.jpg','2019-03-11 00:00:00',2),
(13,17,'\\home\\gruhudhyog\\ProductImages\\Cloths\\jeans\\564bcf89-cfda-4b97-af0c-5b3387fa08fa.jpg','2019-03-11 00:00:00',2),
(14,17,'\\home\\gruhudhyog\\ProductImages\\Cloths\\jeans\\7772be76-bee5-418e-bc16-c82db2b5cd48.jpg','2019-03-11 00:00:00',2),
(17,18,'\\home\\gruhudhyog\\ProductImages\\Cloths\\jeans\\be57d38d-637d-49e7-b2f3-9276bee7cf1e.jpg','2019-03-11 00:00:00',1),
(18,19,'\\home\\gruhudhyog\\ProductImages\\Snacks\\wafers\\4cd8bd30-7f31-4d6b-8c29-943235600a79.png','2019-03-11 17:54:06',1),
(19,20,'\\home\\gruhudhyog\\ProductImages\\Snacks\\tops\\21f181cf-ec82-470f-91bf-af44d4085176.png','2019-03-11 18:09:51',2),
(20,33,'\\home\\gruhudhyog\\ProductImages\\Dairy Farm\\milk\\4b6edbc4-f234-4dfc-be57-f5c36dd02fda.jpg','2019-03-14 13:00:12',2),
(21,34,'\\home\\gruhudhyog\\ProductImages\\Nursery\\dcd\\14cd01b3-9842-4426-b193-5cfc9149290b.jpg','2019-03-14 13:01:16',2),
(22,35,'\\home\\gruhudhyog\\ProductImages\\Snacks\\pateto\\124e640c-d705-4686-8549-0ebda35ed0cf.jpg','2019-03-14 13:01:52',2),
(23,36,'\\home\\gruhudhyog\\ProductImages\\Art Work\\sketch\\a393561f-cd82-496b-ad52-71bae30e4e71.jpg','2019-03-14 13:03:35',2),
(24,37,'\\home\\gruhudhyog\\ProductImages\\Cloths\\shirt\\43bb6cce-384b-4627-9d6d-bb0be66a0f7d.jpg','2019-03-14 13:04:14',2),
(25,38,'\\home\\gruhudhyog\\ProductImages\\Cloths\\cdcsd\\0ec22c03-7807-4f3d-ae18-800cc701af88.jpg','2019-03-14 13:04:48',2),
(26,39,'\\home\\gruhudhyog\\ProductImages\\Art Work\\pateto\\1d324564-86c4-40ec-a537-115f876ed320.jpg','2019-03-14 13:05:23',2),
(27,40,'\\home\\gruhudhyog\\ProductImages\\Snacks\\cdcsd\\3c99118a-3226-4961-ae16-36de275ea633.jpg','2019-03-14 13:05:55',2),
(28,41,'\\home\\gruhudhyog\\ProductImages\\Cloths\\patola\\290ac26f-6453-43d0-9dc9-92fdf35bbb50.jpg','2019-03-14 13:08:09',2),
(29,42,'\\home\\gruhudhyog\\ProductImages\\Art Work\\k.kl.l\\b25d6a76-40e0-4f40-9ec0-fdb1d9626d05.jpg','2019-03-14 13:08:39',2),
(30,43,'\\home\\gruhudhyog\\ProductImages\\Snacks\\mamra\\1e56997c-03f7-45f9-b162-67d7459bd9f5.jpg','2019-03-14 15:04:12',2),
(31,44,'\\home\\gruhudhyog\\ProductImages\\Snacks\\mamra\\d8a3c1a2-0a1f-414e-b4d4-4f31b3ff41d8.jpg','2019-03-14 15:04:12',2),
(32,43,'\\home\\gruhudhyog\\ProductImages\\Snacks\\mamra\\23a104a4-7844-43e7-a1b1-afd38cdee5f4.jpg','2019-03-14 15:04:12',2),
(33,44,'\\home\\gruhudhyog\\ProductImages\\Snacks\\mamra\\83935021-a6ff-4bc8-88e5-f45407112dde.jpg','2019-03-14 15:04:12',2);

/*Table structure for table `tbl_shipping` */

DROP TABLE IF EXISTS `tbl_shipping`;

CREATE TABLE `tbl_shipping` (
  `shippingPK` bigint(20) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(30) DEFAULT NULL,
  `lastName` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `contactNumber` varchar(30) DEFAULT NULL,
  `address` varchar(250) DEFAULT NULL,
  `country` varchar(20) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `postcode` int(20) DEFAULT NULL,
  `createdBy` bigint(20) DEFAULT NULL,
  `createdOn` date DEFAULT NULL,
  PRIMARY KEY (`shippingPK`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_shipping` */

insert  into `tbl_shipping`(`shippingPK`,`firstName`,`lastName`,`email`,`contactNumber`,`address`,`country`,`state`,`city`,`postcode`,`createdBy`,`createdOn`) values 
(3,'Yashvi','Aghara','yashvi@gmail.com','346556','11/127 netaginagar meghannagar ahmedabad','IN','ML','qawsqw',34253456,1,'2019-03-26'),
(5,'Yashvi','Aghara','yashvi@gmail.com','346556','bdcdcbchbcb','IN','ML','qawsqw',34253456,1,'2019-03-26'),
(6,'hemal','dodiya','hemal@gmail.com','8140321630','11/5698 shahibaug damrucircle ','IN','AS','ahmedabad',380016,3,'2019-03-27'),
(7,'hemal','dodiya','hemal@gmail.com','8140321630','11/5698 shahibaug damrucircle','IN','AS','ahmedabad',380016,3,'2019-03-27'),
(8,'hemal','dodiya','hemal@gmail.com','8140321630','11/5698 shahibaug damrucircle','IN','AS','ahmedabad',380016,3,'2019-03-27');

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_user` */

insert  into `tbl_user`(`userid`,`first_name`,`last_name`,`email_address`,`password`,`phonenumber`,`roleFK`,`createdDate`) values 
(1,'vikas','hingu','vikas34@bnjkvn.com','vikas',1213546789,3,NULL),
(2,'admin','admin','admin123@gmail.com','123',9825434543,1,NULL),
(3,'hemal','dodiya','hemal@gmail.com','hemal',8140321630,3,NULL);

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

/*Table structure for table `tblpayment` */

DROP TABLE IF EXISTS `tblpayment`;

CREATE TABLE `tblpayment` (
  `paymentPk` bigint(20) NOT NULL AUTO_INCREMENT,
  `paymentmethodFk` bigint(30) DEFAULT NULL,
  `createdOn` date DEFAULT NULL,
  `createdBy` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`paymentPk`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

/*Data for the table `tblpayment` */

insert  into `tblpayment`(`paymentPk`,`paymentmethodFk`,`createdOn`,`createdBy`) values 
(10,1,'2019-03-27',1),
(11,1,'2019-03-27',3),
(12,1,'2019-03-27',3),
(13,1,'2019-03-27',3);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
