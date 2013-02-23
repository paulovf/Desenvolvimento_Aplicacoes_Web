-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tempo de Geração: 23/02/2013 às 16h54min
-- Versão do Servidor: 5.5.29
-- Versão do PHP: 5.3.10-1ubuntu3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `dbExames`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `agenda`
--

CREATE TABLE IF NOT EXISTS `agenda` (
  `dataHora` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idMedico` int(11) NOT NULL,
  `idExame` int(11) NOT NULL,
  `idPaciente` int(11) NOT NULL,
  `obs` text,
  `resultado` text,
  PRIMARY KEY (`dataHora`,`idMedico`,`idExame`,`idPaciente`),
  KEY `FK_MEDICO_AGENDA` (`idMedico`),
  KEY `FK_EXAME_AGENDA` (`idExame`),
  KEY `FK_PAC_AGENDA` (`idPaciente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `exame`
--

CREATE TABLE IF NOT EXISTS `exame` (
  `idExame` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(40) NOT NULL DEFAULT '',
  `valor` float(9,3) NOT NULL,
  PRIMARY KEY (`idExame`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `medico`
--

CREATE TABLE IF NOT EXISTS `medico` (
  `idMedico` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(60) NOT NULL DEFAULT '',
  `crm` varchar(15) NOT NULL DEFAULT '',
  PRIMARY KEY (`idMedico`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `medico`
--

INSERT INTO `medico` (`idMedico`, `nome`, `crm`) VALUES
(1, 'bene', '123456');

-- --------------------------------------------------------

--
-- Estrutura da tabela `paciente`
--

CREATE TABLE IF NOT EXISTS `paciente` (
  `idPaciente` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(60) NOT NULL DEFAULT '',
  `dataNasc` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `logradouro` varchar(60) DEFAULT NULL,
  `numero` varchar(10) DEFAULT NULL,
  `bairro` varchar(60) DEFAULT NULL,
  `cidade` varchar(60) DEFAULT NULL,
  `uf` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`idPaciente`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `paciente`
--

INSERT INTO `paciente` (`idPaciente`, `nome`, `dataNasc`, `logradouro`, `numero`, `bairro`, `cidade`, `uf`) VALUES
(1, 'teste', '2000-01-10 02:10:00', 'teste', '10', 'teste', 'teste', 'mg');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(40) NOT NULL,
  `login` varchar(40) NOT NULL,
  `senha` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Extraindo dados da tabela `usuarios`
--

INSERT INTO `usuarios` (`id`, `nome`, `login`, `senha`) VALUES
(1, 'admin', 'admin', '123'),
(4, 'root', 'root', '123');

--
-- Restrições para as tabelas dumpadas
--

--
-- Restrições para a tabela `agenda`
--
ALTER TABLE `agenda`
  ADD CONSTRAINT `FK_MEDICO_AGENDA` FOREIGN KEY (`idMedico`) REFERENCES `medico` (`idMedico`),
  ADD CONSTRAINT `FK_EXAME_AGENDA` FOREIGN KEY (`idExame`) REFERENCES `exame` (`idExame`),
  ADD CONSTRAINT `FK_PAC_AGENDA` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`idPaciente`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
