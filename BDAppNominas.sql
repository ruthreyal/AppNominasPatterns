-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         11.2.2-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.3.0.6589
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para gestion_nominas
CREATE DATABASE IF NOT EXISTS `gestion_nominas` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_uca1400_ai_ci */;
USE `gestion_nominas`;

-- Volcando estructura para tabla gestion_nominas.categoria
CREATE TABLE IF NOT EXISTS `categoria` (
  `categoria` int(2) NOT NULL,
  `sueldo` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Volcando datos para la tabla gestion_nominas.categoria: ~10 rows (aproximadamente)
INSERT INTO `categoria` (`categoria`, `sueldo`) VALUES
	(1, 50000.00),
	(2, 70000.00),
	(3, 90000.00),
	(4, 110000.00),
	(5, 130000.00),
	(6, 150000.00),
	(7, 170000.00),
	(8, 190000.00),
	(9, 210000.00),
	(10, 230000.00);

-- Volcando estructura para tabla gestion_nominas.empleados
CREATE TABLE IF NOT EXISTS `empleados` (
  `dni` varchar(9) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `sexo` char(1) DEFAULT NULL,
  `categoria` int(2) DEFAULT NULL,
  `anyos` int(2) DEFAULT NULL,
  PRIMARY KEY (`dni`),
  CONSTRAINT `sex_chck` CHECK (`sexo` = 'F' or `sexo` = 'M')
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Volcando datos para la tabla gestion_nominas.empleados: ~5 rows (aproximadamente)
INSERT INTO `empleados` (`dni`, `nombre`, `sexo`, `categoria`, `anyos`) VALUES
	('11223344C', 'Carlos Perez', 'M', 1, 2),
	('12345678A', 'Juan Gonzalez', 'M', 3, 5),
	('32000031R', 'Ada Lovelace', 'F', 1, 1),
	('32000032G', 'James Cosling', 'M', 9, 7),
	('44332211D', 'Ana Fernández', 'F', 4, 10),
	('55667788E', 'Luis Martínez', 'M', 3, 7),
	('87654321B', 'María López', 'F', 2, 8);

-- Volcando estructura para tabla gestion_nominas.nominas
CREATE TABLE IF NOT EXISTS `nominas` (
  `dni` varchar(9) NOT NULL,
  `categoria` int(2) NOT NULL,
  `sueldo_final` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`dni`),
  KEY `fk_c` (`categoria`),
  CONSTRAINT `fk_c` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`categoria`),
  CONSTRAINT `fk_d` FOREIGN KEY (`dni`) REFERENCES `empleados` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Volcando datos para la tabla gestion_nominas.nominas: ~7 rows (aproximadamente)
INSERT INTO `nominas` (`dni`, `categoria`, `sueldo_final`) VALUES
	('11223344C', 1, 60000.00),
	('12345678A', 3, 115000.00),
	('32000031R', 1, 55000.00),
	('32000032G', 9, 245000.00),
	('44332211D', 4, 160000.00),
	('55667788E', 3, 125000.00),
	('87654321B', 2, 110000.00);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
