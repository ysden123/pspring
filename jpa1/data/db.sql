-- --------------------------------------------------------
-- Host:                         sql4.freemysqlhosting.net
-- Server version:               5.5.54-0ubuntu0.12.04.1 - (Ubuntu)
-- Server OS:                    debian-linux-gnu
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Dumping structure for table sql4465495.generic
CREATE TABLE IF NOT EXISTS `generic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_id` int(11) NOT NULL,
  `language` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table sql4465495.generic: ~1 rows (approximately)
/*!40000 ALTER TABLE `generic` DISABLE KEYS */;
INSERT INTO `generic` (`id`, `resource_id`, `language`) VALUES
	(1, 2, 'Java'),
	(2, 4, 'NodeJs');
/*!40000 ALTER TABLE `generic` ENABLE KEYS */;

-- Dumping structure for table sql4465495.resource
CREATE TABLE IF NOT EXISTS `resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Dumping data for table sql4465495.resource: ~3 rows (approximately)
/*!40000 ALTER TABLE `resource` DISABLE KEYS */;
INSERT INTO `resource` (`id`, `name`) VALUES
	(1, 'resource 1'),
	(2, 'resource 2'),
	(3, 'resource 3'),
	(4, 'resource 4');
/*!40000 ALTER TABLE `resource` ENABLE KEYS */;

-- Dumping structure for table sql4465495.scala
CREATE TABLE IF NOT EXISTS `scala` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_id` int(11) NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table sql4465495.scala: ~1 rows (approximately)
/*!40000 ALTER TABLE `scala` DISABLE KEYS */;
INSERT INTO `scala` (`id`, `resource_id`, `version`) VALUES
	(1, 3, '2.1'),
	(2, 4, '2.2');
/*!40000 ALTER TABLE `scala` ENABLE KEYS */;

-- Dumping structure for table sql4465495.table1
CREATE TABLE IF NOT EXISTS `table1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table sql4465495.table1: ~3 rows (approximately)
/*!40000 ALTER TABLE `table1` DISABLE KEYS */;
INSERT INTO `table1` (`id`, `name`, `age`) VALUES
	(1, 'name 1', 12),
	(2, 'name 2', NULL),
	(3, 'name 3', 54);
/*!40000 ALTER TABLE `table1` ENABLE KEYS */;

-- Dumping structure for table sql4465495.table2
CREATE TABLE IF NOT EXISTS `table2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table sql4465495.table2: ~2 rows (approximately)
/*!40000 ALTER TABLE `table2` DISABLE KEYS */;
INSERT INTO `table2` (`id`, `name`, `height`) VALUES
	(1, 'name 2', 33),
	(2, 'name 3', 15);
/*!40000 ALTER TABLE `table2` ENABLE KEYS */;

-- Dumping structure for table sql4465495.table3
CREATE TABLE IF NOT EXISTS `table3` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table sql4465495.table3: ~2 rows (approximately)
/*!40000 ALTER TABLE `table3` DISABLE KEYS */;
INSERT INTO `table3` (`id`, `name`, `width`) VALUES
	(1, 'name 3', 81),
	(2, 'name 4', 17);
/*!40000 ALTER TABLE `table3` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
