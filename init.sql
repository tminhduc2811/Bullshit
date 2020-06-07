/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for BPA
CREATE DATABASE IF NOT EXISTS `bpa` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bpa`;

-- Dumping structure for bpa.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
	`id`			bigint(20) 		NOT NULL AUTO_INCREMENT,
	`username` 		varchar(100) 	NOT NULL UNIQUE,
    `email`			varchar(100)	NOT NULL UNIQUE,
	`password` 		varchar(100) 	NOT NULL,
    `role`			varchar(20)		DEFAULT 'PATIENT',
	`full_name`		varchar(100) 	NOT NULL,
	`avatar`		varchar(200) 	DEFAULT NULL,
    `address`		varchar(200)	DEFAULT NULL,
    `phone_number`	varchar(20)		DEFAULT NULL,
    `gender`		smallint(1)		DEFAULT 0,
    `birthday`		date			DEFAULT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- Dumping structure for table bpa.bp_info
DROP TABLE IF EXISTS `bp_info`;
CREATE TABLE `bp_info` (
	`id`			bigint(20) 		NOT NULL AUTO_INCREMENT,
	`user_id`		bigint(20)		NOT NULL,
    `systolic`		int				NOT NULL,
    `diastolic`		int				NOT NULL,
    `heart_rate`	int 			NOT NULL,
	PRIMARY KEY (`id`),
    CONSTRAINT `FK_USER` FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `schedule_event`;
CREATE TABLE `schedule_event` (
	`id`			bigint(20)		NOT NULL AUTO_INCREMENT,
    `user_id`		bigint(20)		NOT NULL,
    `message`		varchar(200)	NOT NULL,
    `time`			datetime		NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `FK_USER2` FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;