-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.24 - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL version:             7.0.0.4053
-- Date/time:                    2015-04-07 00:23:22
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;

-- Dumping database structure for statistics
CREATE DATABASE IF NOT EXISTS `statistics` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `statistics`;


-- Dumping structure for table statistics.author
CREATE TABLE IF NOT EXISTS `author` (
  `author_id` int(10) NOT NULL DEFAULT '0',
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`author_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table statistics.news
CREATE TABLE IF NOT EXISTS `news` (
  `news_id` int(10) NOT NULL DEFAULT '0',
  `author_id` int(10) DEFAULT NULL,
  `news_contents` varchar(50) NOT NULL DEFAULT '0',
  `publish_data` date DEFAULT NULL,
  PRIMARY KEY (`news_id`),
  KEY `news_author` (`author_id`),
  CONSTRAINT `news_author` FOREIGN KEY (`author_id`) REFERENCES `author` (`author_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table statistics.region
CREATE TABLE IF NOT EXISTS `region` (
  `region_id` int(10) NOT NULL DEFAULT '0',
  `title` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`region_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table statistics.smi
CREATE TABLE IF NOT EXISTS `smi` (
  `smi_id` int(10) NOT NULL DEFAULT '0',
  `title` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`smi_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.


-- Dumping structure for table statistics.smi_news_region
CREATE TABLE IF NOT EXISTS `smi_news_region` (
  `smi_news_region_id` int(10) NOT NULL DEFAULT '0',
  `news_id` int(10) DEFAULT NULL,
  `region_id` int(10) DEFAULT NULL,
  `smi_id` int(10) DEFAULT NULL,
  `purchase_count` int(10) DEFAULT NULL,
  PRIMARY KEY (`smi_news_region_id`),
  KEY `FK1` (`news_id`),
  KEY `FK__region` (`region_id`),
  KEY `FK__smi` (`smi_id`),
  CONSTRAINT `FK1` FOREIGN KEY (`news_id`) REFERENCES `news` (`news_id`),
  CONSTRAINT `FK__region` FOREIGN KEY (`region_id`) REFERENCES `region` (`region_id`),
  CONSTRAINT `FK__smi` FOREIGN KEY (`smi_id`) REFERENCES `smi` (`smi_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
/*!40014 SET FOREIGN_KEY_CHECKS=1 */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
