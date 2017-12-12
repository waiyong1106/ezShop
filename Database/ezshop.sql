-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 12, 2017 at 11:42 AM
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
-- Database: `ezshop`
--

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

CREATE TABLE `location` (
  `locationID` int(11) NOT NULL,
  `locationName` varchar(50) NOT NULL,
  `locationAddress` varchar(150) NOT NULL,
  `locationCategory` varchar(25) NOT NULL,
  `locationDescription` varchar(100) NOT NULL,
  `locationOwner` varchar(40) NOT NULL,
  `locationEmailAddress` varchar(30) DEFAULT NULL,
  `locationContact` varchar(11) NOT NULL,
  `Latitude` double DEFAULT NULL,
  `Longtitude` double DEFAULT NULL,
  `averageRating` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `location`
--

INSERT INTO `location` (`locationID`, `locationName`, `locationAddress`, `locationCategory`, `locationDescription`, `locationOwner`, `locationEmailAddress`, `locationContact`, `Latitude`, `Longtitude`, `averageRating`) VALUES
(1, 'Orange Esports Stadium', '2, Jalan Prima Setapak 1, Taman Setapak, 53000 Kuala Lumpur, Wilayah Persekutuan Kuala Lumpur, Malaysia', 'Etc', 'Place for entertainment and e-sport', 'Orangean', 'Orangaen@gmail.com', '0163953135', 3.1989599999999996, 101.713865, 4.375),
(2, 'Loud Speaker Family Karaoke Setapak', 'Jalan 2/23d, Taman Danau Kota, 53300 Kuala Lumpur, Wilayah Persekutuan Kuala Lumpur, Malaysia', 'Etc', 'Place for singer :D', 'Choon Ket', 'ckgaaey@gmail.com', '01635479891', 3.1984703000000008, 101.7141455, 3.1666666666667),
(3, 'DK ABA', '53100 Kuala Lumpur, Federal Territory of Kuala Lumpur, Malaysia', 'Etc', 'TARUC favourite place', 'TARUC', 'taruc@gmail.com', '0199353135', 3.2152841999999997, 101.7311256, 5),
(4, 'Taiwan Tea House', '20-1, Jalan Prima Setapak 3, Off Jalan Genting Klang, 53300 Kuala Lumpur, Taman Setapak, 53000 Kuala Lumpur, Federal Territory of Kuala Lumpur, Malays', 'Food and Beverages', 'Made by tawianese', 'Taiwan', 'tw@gmail.com', '01639531354', 3.1980401000000005, 101.7123783, 3),
(5, 'First Step Dance & Art', '19-2, Jalan Prima Setapak 5, Off Jalan Genting Klang, Setapak, Kuala Lumpur, 53300, Setapak, WP Kuala Lumpur, Taman Setapak, 53000 Kuala Lumpur, Feder', 'Clothes', 'Selling shirt for 30 year', 'shirt', 'shirt@gmail.com', '01678998787', 3.1986130999999993, 101.7126878, 4),
(6, 'Kfc Testing', 'Taman Setapak, 53100 Kuala Lumpur, Wilayah Persekutuan Kuala Lumpur, Malaysia', 'Food and Beverages', 'KFC', 'Old uncle', 'olduncleswag@gmail.com', '01678789841', 3.1982725, 101.7110751, 1),
(7, 'Pizza Hut Genting Kelang', 'Lot No G-11,G-12 & G-13 Ground Floor, Mutiara Genting, Jalan Genting Kelang, Setapak, 53000 Kuala Lumpur, Kuala Lumpur Federal Territory, Malaysia', 'Food and Beverages', 'I love domino', 'Domino', 'Pizza@gmail.com', '0109531351', 3.1966037, 101.7140289, 1),
(8, 'Value Plus Resources', '261-A, Jalan Genting Kelang, Taman Ayer Panas, 53300 Kuala Lumpur, Wilayah Persekutuan Kuala Lumpur, Malaysia', 'Clothes', 'Shirt confirmed', 'shirt', 'sirrr@gmail.com', '0119531351', 3.1962143, 101.7134904, 3),
(9, 'Kedai Motor Jalan Setapak', 'Setapak, 53200 Kuala Lumpur, Federal Territory of Kuala Lumpur, Malaysia', 'Electronic', 'Motor meow', 'motorr', 'motorr@gmail.com', '0163953135', 3.1882989999999993, 101.70416200000001, 5),
(10, 'Taman Kajang Utama', 'Taman Kajang Utama, 43000 Kajang, Selangor, Malaysia', 'Food and Beverages', 'kajang', 'Najib', 'najib@gmail.com', '0163953135', 2.9737493000000006, 101.7958728, 0);

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `memberID` int(5) NOT NULL,
  `name` varchar(50) NOT NULL,
  `dob` varchar(20) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `address` varchar(100) NOT NULL,
  `ic` varchar(12) NOT NULL,
  `email` varchar(40) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`memberID`, `name`, `dob`, `phone`, `address`, `ic`, `email`, `password`) VALUES
(1, 'Kaka', '123', '123', '123', '123', 'wock-wa14@student.tarc.edu.my', '123'),
(8, 'Aa', '11', '11', 'Aa', '11', 'aa@hotmail.com', '123'),
(9, 'Aa', '11', '11', 'Aa', '11', 'junjie_960828@hotmail.com', '258'),
(10, 'Tsang Wai Yong', '19951106', '0183847668', 'Malaysia', '951106145739', 'waiyong1106@gmail.com', '666');

-- --------------------------------------------------------

--
-- Table structure for table `reviewarating`
--

CREATE TABLE `reviewarating` (
  `reviewID` int(11) NOT NULL,
  `rating` int(11) NOT NULL,
  `review` varchar(500) NOT NULL,
  `rrDate` varchar(14) NOT NULL,
  `locationID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reviewarating`
--

INSERT INTO `reviewarating` (`reviewID`, `rating`, `review`, `rrDate`, `locationID`) VALUES
(1, 5, 'Bad service and bad haviours', '2017-11-02', 1),
(2, 5, 'Bad service and bad haviours', '2017-11-02', 1),
(3, 5, 'Good service ! :D', '2017-11-02', 1),
(4, 3, 'Average', '2017-11-02', 1),
(5, 5, 'Very good', '2017-11-02', 3),
(6, 5, 'good', '2017-11-02', 1),
(7, 4, 'good', '2017-11-02', 1),
(8, 4, 'not bad', '2017-11-17', 1),
(9, 4, 'meh', '2017-11-19', 1),
(10, 4, 'meh still okay', '2017-11-23', 2),
(11, 4, 'Average meh', '2017-11-26', 4),
(12, 4, '', '2017-11-27', 2),
(13, 3, 'Still okay LAH', '2017-12-05', 8),
(14, 5, 'meow meow', '2017-12-06', 2),
(15, 4, 'Still okay', '2017-12-06', 2),
(16, 1, 'bad service ! ', '2017-12-06', 2),
(17, 1, 'bad service ! ', '2017-12-06', 2),
(18, 1, 'Cheeza more llike noza', '2017-12-06', 6),
(19, 1, 'No wifi how to play walao', '2017-12-06', 1),
(20, 3, 'okok', '2017-12-06', 8),
(21, 5, 'I love TARUC', '2017-12-06', 3),
(22, 1, 'Disappointment ! ', '2017-12-06', 6),
(23, 1, 'Domino still de best', '2017-12-06', 7),
(24, 5, 'Motor de best', '2017-12-06', 9),
(25, 5, 'Offer is good ...', '2017-12-06', 2),
(26, 5, 'TARUC THE bEST <3', '2017-12-06', 3),
(27, 2, 'TOO EXPENSIVE FANCY FANCY', '2017-12-06', 4),
(28, 3, 'ok only.', '2017-12-06', 4),
(29, 4, 'Still okay only.....', '2017-12-06', 5),
(30, 5, 'Pizza hut > Domino', '2017-12-06', 7),
(31, 5, 'Not bad Not bad', '2017-12-06', 9),
(32, 5, 'good', '2017-12-06', 9),
(33, 5, 'not bad', '2017-12-06', 9);

-- --------------------------------------------------------

--
-- Table structure for table `shopoperation`
--

CREATE TABLE `shopoperation` (
  `operationID` int(11) NOT NULL,
  `dayOfWeek` varchar(10) NOT NULL,
  `openTime` varchar(7) NOT NULL,
  `closeTime` varchar(7) NOT NULL,
  `locationID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `shopoperation`
--

INSERT INTO `shopoperation` (`operationID`, `dayOfWeek`, `openTime`, `closeTime`, `locationID`) VALUES
(1, 'Monday', '13.00', '13.00', 1),
(2, 'Tuesday', '13.00', '13.00', 1),
(3, 'Wednesday', '13.00', '13.00', 1),
(4, 'Thursday', '13.00', '13.00', 1),
(5, 'Friday', '13.00', '13.00', 1),
(6, 'Saturday', '13.00', '13.00', 1),
(7, 'Sunday', '13.00', '13.00', 1),
(8, 'Monday', '24.00', '24.00', 2),
(9, 'Tuesday', '24.00', '24.00', 2),
(10, 'Wednesday', '24.00', '24.00', 2),
(11, 'Thursday', '24.00', '24.00', 2),
(12, 'Friday', '24.00', '24.00', 2),
(13, 'Saturday', '24.00', '24.00', 2),
(14, 'Sunday', '24.00', '24.00', 2),
(15, 'Monday', '24.00', '24.00', 3),
(16, 'Tuesday', '24.00', '24.00', 3),
(17, 'Wednesday', '24.00', '24.00', 3),
(18, 'Thursday', '24.00', '24.00', 3),
(19, 'Friday', '24.00', '24.00', 3),
(20, 'Saturday', '24.00', '24.00', 3),
(21, 'Sunday', '24.00', '24.00', 3),
(22, 'Monday', '12.00', '12.00', 4),
(23, 'Tuesday', '12.00', '12.00', 4),
(24, 'Wednesday', '12.00', '12.00', 4),
(25, 'Thursday', '12.00', '12.00', 4),
(26, 'Friday', '12.00', '12.00', 4),
(27, 'Saturday', '12.00', '12.00', 4),
(28, 'Sunday', '12.00', '12.00', 4),
(29, 'Monday', '24.00', '24.00', 5),
(30, 'Tuesday', '24.00', '24.00', 5),
(31, 'Wednesday', '24.00', '24.00', 5),
(32, 'Thursday', '24.00', '24.00', 5),
(33, 'Friday', '24.00', '24.00', 5),
(34, 'Saturday', '24.00', '24.00', 5),
(35, 'Sunday', '24.00', '24.00', 5),
(36, 'Monday', '09.00', '22.00', 6),
(37, 'Tuesday', '09.00', '22.00', 6),
(38, 'Wednesday', '09.00', '22.00', 6),
(39, 'Thursday', '09.00', '22.00', 6),
(40, 'Friday', '09.00', '22.00', 6),
(41, 'Saturday', '09.00', '22.00', 6),
(42, 'Sunday', '09.00', '22.00', 6),
(43, 'Monday', '09.00', '24.00', 7),
(44, 'Tuesday', '09.00', '24.00', 7),
(45, 'Wednesday', '09.00', '24.00', 7),
(46, 'Thursday', '09.00', '24.00', 7),
(47, 'Friday', '09.00', '24.00', 7),
(48, 'Saturday', '09.00', '24.00', 7),
(49, 'Sunday', '09.00', '24.00', 7),
(50, 'Monday', '03.00', '04.00', 8),
(51, 'Tuesday', '03.00', '04.00', 8),
(52, 'Wednesday', '03.00', '04.00', 8),
(53, 'Thursday', '03.00', '04.00', 8),
(54, 'Friday', '03.00', '04.00', 8),
(55, 'Saturday', '03.00', '04.00', 8),
(56, 'Sunday', '03.00', '04.00', 8),
(57, 'Monday', '12.00', '24.00', 9),
(58, 'Tuesday', '12.00', '24.00', 9),
(59, 'Wednesday', '12.00', '24.00', 9),
(60, 'Thursday', '12.00', '24.00', 9),
(61, 'Friday', '12.00', '24.00', 9),
(62, 'Saturday', '12.00', '24.00', 9),
(63, 'Sunday', '12.00', '24.00', 9),
(64, 'Monday', '1200', '2400', 10),
(65, 'Tuesday', '1200', '2400', 10),
(66, 'Wednesday', '1200', '2400', 10),
(67, 'Thursday', '1200', '2400', 10),
(68, 'Friday', '1200', '2400', 10),
(69, 'Saturday', '1200', '2400', 10),
(70, 'Sunday', '1200', '2400', 10);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`locationID`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`memberID`);
ALTER TABLE `member` ADD FULLTEXT KEY `email` (`email`);

--
-- Indexes for table `reviewarating`
--
ALTER TABLE `reviewarating`
  ADD PRIMARY KEY (`reviewID`);

--
-- Indexes for table `shopoperation`
--
ALTER TABLE `shopoperation`
  ADD PRIMARY KEY (`operationID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `location`
--
ALTER TABLE `location`
  MODIFY `locationID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
  MODIFY `memberID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `reviewarating`
--
ALTER TABLE `reviewarating`
  MODIFY `reviewID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT for table `shopoperation`
--
ALTER TABLE `shopoperation`
  MODIFY `operationID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=71;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
