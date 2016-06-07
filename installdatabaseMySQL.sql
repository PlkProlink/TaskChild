-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.1.13-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win32
-- HeidiSQL Versão:              9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Copiando estrutura do banco de dados para logbackup
CREATE DATABASE IF NOT EXISTS `logbackup` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `logbackup`;

CREATE TABLE IF NOT EXISTS `rotinas` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SITUACAO` varchar(245) NOT NULL DEFAULT '',
  `QUANTIDADE` varchar(50) NOT NULL DEFAULT '',
  `TAMANHO` varchar(50) NOT NULL DEFAULT '',
  `QUANTIDADE_RESTANTE` varchar(50) NOT NULL DEFAULT '',
  `TAMANHO_RESTANTE` varchar(50) NOT NULL DEFAULT '',
  `TEMPO` varchar(10) NOT NULL DEFAULT '',
  `DATA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`),
  KEY `PK_ID_ROTINA` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.


-- Copiando estrutura para tabela logbackup.detalhes_rotinas
CREATE TABLE IF NOT EXISTS `detalhes_rotinas` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_ROTINA` int(11) DEFAULT NULL,
  `HORA` varchar(10) NOT NULL DEFAULT '',
  `DETALHES` text,
  PRIMARY KEY (`ID`),
  KEY `FK_DETALHES` (`ID_ROTINA`),
  CONSTRAINT `FK_DETALHES` FOREIGN KEY (`ID_ROTINA`) REFERENCES `rotinas` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.


-- Copiando estrutura para tabela logbackup.rotinas
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
