-- phpMyAdmin SQL Dump
-- version 4.2.7
-- http://www.phpmyadmin.net
--
-- Host: localhost:3306
-- Generation Time: Jul 19, 2015 at 07:43 PM
-- Server version: 5.6.17-debug-log
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `reinforcement_learning`
--

-- --------------------------------------------------------

--
-- Table structure for table `turn_0`
--

CREATE TABLE IF NOT EXISTS `turn_0` (
`id` int(10) unsigned NOT NULL,
  `value` int(11) NOT NULL DEFAULT '1000',
  `0-0` int(3) DEFAULT NULL,
  `0-1` int(3) DEFAULT NULL,
  `0-2` int(3) DEFAULT NULL,
  `1-0` int(3) DEFAULT NULL,
  `1-1` int(3) DEFAULT NULL,
  `1-2` int(3) DEFAULT NULL,
  `2-0` int(3) DEFAULT NULL,
  `2-1` int(3) DEFAULT NULL,
  `2-2` int(3) DEFAULT NULL,
  `move` varchar(3) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

-- --------------------------------------------------------

--
-- Table structure for table `turn_1`
--

CREATE TABLE IF NOT EXISTS `turn_1` (
`id` int(10) unsigned NOT NULL,
  `value` int(11) NOT NULL DEFAULT '1000',
  `0-0` int(3) DEFAULT NULL,
  `0-1` int(3) DEFAULT NULL,
  `0-2` int(3) DEFAULT NULL,
  `1-0` int(3) DEFAULT NULL,
  `1-1` int(3) DEFAULT NULL,
  `1-2` int(3) DEFAULT NULL,
  `2-0` int(3) DEFAULT NULL,
  `2-1` int(3) DEFAULT NULL,
  `2-2` int(3) DEFAULT NULL,
  `move` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `turn_2`
--

CREATE TABLE IF NOT EXISTS `turn_2` (
`id` int(10) unsigned NOT NULL,
  `value` int(11) NOT NULL DEFAULT '1000',
  `0-0` int(3) DEFAULT NULL,
  `0-1` int(3) DEFAULT NULL,
  `0-2` int(3) DEFAULT NULL,
  `1-0` int(3) DEFAULT NULL,
  `1-1` int(3) DEFAULT NULL,
  `1-2` int(3) DEFAULT NULL,
  `2-0` int(3) DEFAULT NULL,
  `2-1` int(3) DEFAULT NULL,
  `2-2` int(3) DEFAULT NULL,
  `move` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `turn_3`
--

CREATE TABLE IF NOT EXISTS `turn_3` (
`id` int(10) unsigned NOT NULL,
  `value` int(11) NOT NULL DEFAULT '1000',
  `0-0` int(3) DEFAULT NULL,
  `0-1` int(3) DEFAULT NULL,
  `0-2` int(3) DEFAULT NULL,
  `1-0` int(3) DEFAULT NULL,
  `1-1` int(3) DEFAULT NULL,
  `1-2` int(3) DEFAULT NULL,
  `2-0` int(3) DEFAULT NULL,
  `2-1` int(3) DEFAULT NULL,
  `2-2` int(3) DEFAULT NULL,
  `move` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `turn_4`
--

CREATE TABLE IF NOT EXISTS `turn_4` (
`id` int(10) unsigned NOT NULL,
  `value` int(11) NOT NULL DEFAULT '1000',
  `0-0` int(3) DEFAULT NULL,
  `0-1` int(3) DEFAULT NULL,
  `0-2` int(3) DEFAULT NULL,
  `1-0` int(3) DEFAULT NULL,
  `1-1` int(3) DEFAULT NULL,
  `1-2` int(3) DEFAULT NULL,
  `2-0` int(3) DEFAULT NULL,
  `2-1` int(3) DEFAULT NULL,
  `2-2` int(3) DEFAULT NULL,
  `move` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `turn_5`
--

CREATE TABLE IF NOT EXISTS `turn_5` (
`id` int(10) unsigned NOT NULL,
  `value` int(11) NOT NULL DEFAULT '1000',
  `0-0` int(3) DEFAULT NULL,
  `0-1` int(3) DEFAULT NULL,
  `0-2` int(3) DEFAULT NULL,
  `1-0` int(3) DEFAULT NULL,
  `1-1` int(3) DEFAULT NULL,
  `1-2` int(3) DEFAULT NULL,
  `2-0` int(3) DEFAULT NULL,
  `2-1` int(3) DEFAULT NULL,
  `2-2` int(3) DEFAULT NULL,
  `move` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `turn_6`
--

CREATE TABLE IF NOT EXISTS `turn_6` (
`id` int(10) unsigned NOT NULL,
  `value` int(11) NOT NULL DEFAULT '1000',
  `0-0` int(3) DEFAULT NULL,
  `0-1` int(3) DEFAULT NULL,
  `0-2` int(3) DEFAULT NULL,
  `1-0` int(3) DEFAULT NULL,
  `1-1` int(3) DEFAULT NULL,
  `1-2` int(3) DEFAULT NULL,
  `2-0` int(3) DEFAULT NULL,
  `2-1` int(3) DEFAULT NULL,
  `2-2` int(3) DEFAULT NULL,
  `move` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `turn_7`
--

CREATE TABLE IF NOT EXISTS `turn_7` (
`id` int(10) unsigned NOT NULL,
  `value` int(11) DEFAULT '1000',
  `0-0` int(3) DEFAULT NULL,
  `0-1` int(3) DEFAULT NULL,
  `0-2` int(3) DEFAULT NULL,
  `1-0` int(3) DEFAULT NULL,
  `1-1` int(3) DEFAULT NULL,
  `1-2` int(3) DEFAULT NULL,
  `2-0` int(3) DEFAULT NULL,
  `2-1` int(3) DEFAULT NULL,
  `2-2` int(3) DEFAULT NULL,
  `move` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `turn_8`
--

CREATE TABLE IF NOT EXISTS `turn_8` (
`id` int(10) unsigned NOT NULL,
  `value` int(11) NOT NULL DEFAULT '1000',
  `0-0` int(3) DEFAULT NULL,
  `0-1` int(3) DEFAULT NULL,
  `0-2` int(3) DEFAULT NULL,
  `1-0` int(3) DEFAULT NULL,
  `1-1` int(3) DEFAULT NULL,
  `1-2` int(3) DEFAULT NULL,
  `2-0` int(3) DEFAULT NULL,
  `2-1` int(3) DEFAULT NULL,
  `2-2` int(3) DEFAULT NULL,
  `move` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `turn_0`
--
ALTER TABLE `turn_0`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `turn_1`
--
ALTER TABLE `turn_1`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `turn_2`
--
ALTER TABLE `turn_2`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `turn_3`
--
ALTER TABLE `turn_3`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `turn_4`
--
ALTER TABLE `turn_4`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `turn_5`
--
ALTER TABLE `turn_5`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `turn_6`
--
ALTER TABLE `turn_6`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `turn_7`
--
ALTER TABLE `turn_7`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `turn_8`
--
ALTER TABLE `turn_8`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `turn_0`
--
ALTER TABLE `turn_0`
MODIFY `id` int(10) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `turn_1`
--
ALTER TABLE `turn_1`
MODIFY `id` int(10) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `turn_2`
--
ALTER TABLE `turn_2`
MODIFY `id` int(10) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `turn_3`
--
ALTER TABLE `turn_3`
MODIFY `id` int(10) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `turn_4`
--
ALTER TABLE `turn_4`
MODIFY `id` int(10) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `turn_5`
--
ALTER TABLE `turn_5`
MODIFY `id` int(10) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `turn_6`
--
ALTER TABLE `turn_6`
MODIFY `id` int(10) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `turn_7`
--
ALTER TABLE `turn_7`
MODIFY `id` int(10) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `turn_8`
--
ALTER TABLE `turn_8`
MODIFY `id` int(10) unsigned NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
