-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 28, 2017 at 04:31 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `easyexpress`
--

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `bookID` varchar(15) NOT NULL,
  `memID` varchar(15) NOT NULL,
  `scheID` varchar(15) NOT NULL,
  `seatType` varchar(15) NOT NULL,
  `seatBook` int(11) NOT NULL,
  `price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `bus`
--

CREATE TABLE `bus` (
  `busID` varchar(15) NOT NULL,
  `busName` varchar(50) NOT NULL,
  `seat` int(11) NOT NULL,
  `vip` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `driver`
--

CREATE TABLE `driver` (
  `driverID` varchar(15) NOT NULL,
  `driverName` varchar(50) NOT NULL,
  `hp` int(11) NOT NULL,
  `address` varchar(50) NOT NULL,
  `birth` varchar(17) NOT NULL,
  `salary` double NOT NULL,
  `busID` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `memID` varchar(50) NOT NULL,
  `memName` varchar(50) NOT NULL,
  `gender` varchar(50) NOT NULL,
  `hp` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL,
  `birth` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`memID`, `memName`, `gender`, `hp`, `address`, `birth`, `username`, `password`) VALUES
('M10001', 'wawaawwa', 'Male', '0103953135', 'qweqweqwe', '1995-11-06', 'abc', '123');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `payID` varchar(50) NOT NULL,
  `bookID` varchar(50) NOT NULL,
  `memID` varchar(50) NOT NULL,
  `scheID` varchar(50) NOT NULL,
  `scheDate` varchar(50) NOT NULL,
  `scheTime` int(11) NOT NULL,
  `seatType` varchar(50) NOT NULL,
  `seatBook` int(11) NOT NULL,
  `price` double NOT NULL,
  `payMethod` varchar(50) NOT NULL,
  `cardNo` varchar(50) NOT NULL,
  `cardPin` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `refund`
--

CREATE TABLE `refund` (
  `refundID` varchar(50) NOT NULL,
  `payID` varchar(50) NOT NULL,
  `memID` varchar(50) NOT NULL,
  `hp` varchar(50) NOT NULL,
  `rprice` double NOT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `scheduler`
--

CREATE TABLE `scheduler` (
  `scheID` varchar(50) NOT NULL,
  `scheDate` varchar(50) NOT NULL,
  `dest` varchar(50) NOT NULL,
  `departure` varchar(50) NOT NULL,
  `busID` varchar(50) NOT NULL,
  `driverID` varchar(50) NOT NULL,
  `normal` varchar(50) NOT NULL,
  `vip` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `seat`
--

CREATE TABLE `seat` (
  `scheID` varchar(50) NOT NULL,
  `normal` int(11) NOT NULL,
  `vip` int(11) NOT NULL,
  `priceN` double NOT NULL,
  `priceVip` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `staffID` varchar(50) NOT NULL,
  `staffName` varchar(50) NOT NULL,
  `hp` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL,
  `birth` varchar(50) NOT NULL,
  `salary` double NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
