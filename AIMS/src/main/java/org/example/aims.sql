-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 22, 2023 at 10:13 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `aims`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `book_id` int(11) NOT NULL,
  `media_id` int(11) DEFAULT NULL,
  `author` varchar(45) DEFAULT NULL,
  `cover_type` varchar(45) DEFAULT NULL,
  `publisher` varchar(45) DEFAULT NULL,
  `publish_date` varchar(45) DEFAULT NULL,
  `num_of_pages` int(11) DEFAULT NULL,
  `language` varchar(45) DEFAULT NULL,
  `book_category` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`book_id`, `media_id`, `author`, `cover_type`, `publisher`, `publish_date`, `num_of_pages`, `language`, `book_category`) VALUES
(1, 1, 'John Doe', 'Hardcover', 'Example Publisher', '2022-01-01', 300, 'English', 'Fiction'),
(2, 2, 'Jane Smith', 'Paperback', 'Another Publisher', '2021-12-15', 250, 'Spanish', 'Non-Fiction'),
(3, 3, 'Bob Johnson', 'Hardcover', 'Great Books Publishing', '2022-03-10', 400, 'French', 'Mystery');

-- --------------------------------------------------------

--
-- Table structure for table `cd`
--

CREATE TABLE `cd` (
  `cd_id` int(11) NOT NULL,
  `media_id` int(11) DEFAULT NULL,
  `artist` varchar(45) DEFAULT NULL,
  `released_date` varchar(45) DEFAULT NULL,
  `record_lable` varchar(45) DEFAULT NULL,
  `music_type` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `delivery_info`
--

CREATE TABLE `delivery_info` (
  `delivery_info_id` int(11) NOT NULL,
  `name` varchar(10) DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  `province` varchar(45) DEFAULT NULL,
  `instruction` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `is_rush` smallint(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `delivery_info`
--

INSERT INTO `delivery_info` (`delivery_info_id`, `name`, `phone_number`, `province`, `instruction`, `address`, `email`, `is_rush`) VALUES
(5, '1', '1', 'Hà Nội', '1', 'Địa chỉ: ', 'Email', 0),
(6, '1', '1', 'Hà Nội', '1', 'Địa chỉ: ', 'Email', 0),
(7, '1', '1', 'Điện Biên', '1', 'Địa chỉ: ', 'Email', 0),
(8, '1', '1', 'Đắk Nông', '1', 'Địa chỉ: ', 'Email', 0),
(9, '1', '1', 'Hà Nội', '1', 'Địa chỉ: ', 'Email', 0),
(10, '1', '1', 'Hà Nội', '1', 'Địa chỉ: ', 'Email', 0),
(11, '1', '1', 'Hà Nội', '1', 'Địa chỉ: ', 'Email', 0),
(12, '1', '1', 'Hà Nội', '1', 'Địa chỉ: ', 'Email', 0),
(13, '1', '1', 'Hà Nội', '1', 'Địa chỉ: ', 'Email', 0),
(14, '1', '1', 'Hà Nội', '1', 'Địa chỉ: ', 'Email', 0),
(15, '1', '1', 'Hà Nội', '1', 'Địa chỉ: ', 'Email', 0),
(16, '1', '1', 'Hà Nội', '1', 'Địa chỉ: ', 'Email', 0),
(17, '', '', 'Hà Nội', '', 'Địa chỉ: ', 'Email', 0),
(18, '1', '1', 'Đắk Lắk', '1', 'Địa chỉ: ', 'Email', 0),
(19, '', '', 'Hà Nội', '', 'Địa chỉ: ', 'Email', 0),
(20, '', '', 'Hà Nội', '', 'Địa chỉ: ', 'Email', 0),
(21, '', '', 'Hà Nội', '', 'Địa chỉ: ', 'Email', 0),
(22, '', '', 'Hà Nội', '', 'Địa chỉ: ', 'Email', 0),
(23, '', '', 'Hà Nội', '', 'Địa chỉ: ', 'Email', 0),
(24, '', '', 'Hà Nội', '', 'Địa chỉ: ', 'Email', 0),
(25, '', '', 'Hà Nội', '', 'Địa chỉ: ', 'Email', 0),
(26, '', '', 'Hà Nội', '', 'Địa chỉ: ', 'Email', 0),
(27, '', '', 'Hà Nội', '', 'Địa chỉ: ', 'Email', 0),
(28, '', '', 'Hà Nội', '', 'Địa chỉ: ', 'Email', 0),
(29, '', '', 'Hà Nội', '', 'Địa chỉ: ', 'Email', 0),
(30, '', '', 'Hà Nội', '', 'Địa chỉ: ', 'Email', 0),
(31, '', '', 'Hà Nội', '', 'Địa chỉ: ', 'Email', 0),
(32, '', '', 'Hà Nội', '', 'Địa chỉ: ', 'Email', 0),
(33, '', '', 'Hà Nội', '', 'Địa chỉ: ', 'Email', 0),
(34, '', '', 'Hà Nội', '', 'Địa chỉ: ', 'Email', 0),
(35, '', '', 'Hà Nội', '', 'Địa chỉ: ', 'Email', 0),
(36, '', '', 'Hà Nội', '', 'Địa chỉ: ', 'Email', 0),
(37, '', '', 'Hà Nội', '', 'Địa chỉ: ', 'Email', 0),
(38, '', '', 'Hà Nội', '', 'Địa chỉ: ', 'Email', 0),
(39, '', '', 'Hà Nội', '', 'Địa chỉ: ', 'Email', 0);

-- --------------------------------------------------------

--
-- Table structure for table `dvd`
--

CREATE TABLE `dvd` (
  `dvd_id` int(11) NOT NULL,
  `media_id` int(11) DEFAULT NULL,
  `disc_type` varchar(45) DEFAULT NULL,
  `director` varchar(45) DEFAULT NULL,
  `studio` varchar(45) DEFAULT NULL,
  `released_date` varchar(45) DEFAULT NULL,
  `subtitle` varchar(45) DEFAULT NULL,
  `runtime` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE `invoice` (
  `invoice_id` int(11) NOT NULL,
  `transaction_id` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  `amount` float DEFAULT NULL,
  `status` char(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `media`
--

CREATE TABLE `media` (
  `media_id` int(11) NOT NULL,
  `price` float DEFAULT NULL,
  `available` int(11) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `imageURL` char(45) DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  `weight` float DEFAULT NULL,
  `support_rush_delivery` smallint(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `media`
--

INSERT INTO `media` (`media_id`, `price`, `available`, `name`, `imageURL`, `category`, `weight`, `support_rush_delivery`) VALUES
(1, 19000, 50, 'Book Title 1', 'book_image_url_1.jpg', 'Book', 1.5, 1),
(2, 15000, 30, 'Book Title 2', 'book_image_url_2.jpg', 'Book', 1.2, 0),
(3, 23000, 25, 'Book Title 3', 'book_image_url_3.jpg', 'Book', 1.8, 1);

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE `order` (
  `order_id` int(11) NOT NULL,
  `delivery_info_id` int(11) DEFAULT NULL,
  `shipping_amounts` float DEFAULT NULL,
  `total_amounts` float DEFAULT NULL,
  `cart_amounts` float DEFAULT NULL,
  `rush_order` smallint(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `order`
--

INSERT INTO `order` (`order_id`, `delivery_info_id`, `shipping_amounts`, `total_amounts`, `cart_amounts`, `rush_order`) VALUES
(3, 5, 37000, 94000, 57000, 0),
(4, 6, 37000, 94000, 57000, 0),
(5, 7, 78000, 135000, 57000, 0),
(6, 8, 63000, 101000, 38000, 0),
(7, 9, 22000, 56000, 34000, 0),
(8, 10, 37000, 94000, 57000, 0),
(9, 11, 22000, 41000, 19000, 0),
(10, 12, 22000, 41000, 19000, 0),
(11, 13, 22000, 41000, 19000, 0),
(12, 14, 22000, 41000, 19000, 0),
(13, 15, 22000, 41000, 19000, 0),
(14, 16, 22000, 41000, 19000, 0),
(15, 17, 22000, 41000, 19000, 0),
(16, 18, 48000, 67000, 19000, 0),
(17, 19, 22000, 37000, 15000, 0),
(18, 20, 22000, 37000, 15000, 0),
(19, 21, 22000, 41000, 19000, 0),
(20, 22, 22000, 41000, 19000, 0),
(21, 23, 22000, 41000, 19000, 0),
(22, 24, 22000, 41000, 19000, 0),
(23, 25, 22000, 41000, 19000, 0),
(24, 26, 22000, 41000, 19000, 0),
(25, 27, 22000, 60000, 38000, 0),
(26, 28, 22000, 41000, 19000, 0),
(27, 29, 22000, 60000, 38000, 0),
(28, 30, 22000, 60000, 38000, 0),
(29, 31, 22000, 60000, 38000, 0),
(30, 32, 22000, 45000, 23000, 0),
(31, 33, 22000, 60000, 38000, 0),
(32, 34, 22000, 60000, 38000, 0),
(33, 35, 22000, 56000, 34000, 0),
(34, 36, 22000, 60000, 38000, 0),
(35, 37, 22000, 60000, 38000, 0),
(36, 38, 37000, 94000, 57000, 0),
(37, 39, 22000, 60000, 38000, 0);

-- --------------------------------------------------------

--
-- Table structure for table `order_media`
--

CREATE TABLE `order_media` (
  `media_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `delivery_info_id` int(11) NOT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `order_media`
--

INSERT INTO `order_media` (`media_id`, `order_id`, `delivery_info_id`, `quantity`) VALUES
(1, 3, 5, 3),
(1, 4, 6, 3),
(1, 5, 7, 1),
(1, 6, 8, 2),
(1, 7, 9, 1),
(1, 8, 10, 1),
(1, 9, 11, 1),
(1, 10, 12, 1),
(1, 11, 13, 1),
(1, 12, 14, 1),
(1, 13, 15, 1),
(1, 14, 16, 1),
(1, 15, 17, 1),
(1, 16, 18, 1),
(1, 19, 21, 1),
(1, 20, 22, 1),
(1, 21, 23, 1),
(1, 22, 24, 1),
(1, 23, 25, 1),
(1, 24, 26, 1),
(1, 25, 27, 2),
(1, 26, 28, 1),
(1, 27, 29, 2),
(1, 28, 30, 2),
(1, 29, 31, 2),
(1, 31, 33, 2),
(1, 32, 34, 2),
(1, 33, 35, 1),
(1, 34, 36, 2),
(1, 35, 37, 2),
(1, 36, 38, 3),
(1, 37, 39, 2),
(2, 5, 7, 1),
(2, 7, 9, 1),
(2, 8, 10, 1),
(2, 17, 19, 1),
(2, 18, 20, 1),
(2, 33, 35, 1),
(3, 5, 7, 1),
(3, 8, 10, 1),
(3, 30, 32, 1);

-- --------------------------------------------------------

--
-- Table structure for table `rush_delivery_info`
--

CREATE TABLE `rush_delivery_info` (
  `delivery_info_id` int(11) NOT NULL,
  `rd_time` varchar(45) DEFAULT NULL,
  `rd_address` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `transaction_id` int(11) NOT NULL,
  `amount` float DEFAULT NULL,
  `contents` varchar(45) DEFAULT NULL,
  `error_message` varchar(45) DEFAULT NULL,
  `time` timestamp(6) NOT NULL DEFAULT current_timestamp(6) ON UPDATE current_timestamp(6)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`transaction_id`, `amount`, `contents`, `error_message`, `time`) VALUES
(1, 41000, 'Paying for order 24 for 41000', '', '2023-12-21 19:28:20.000000');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`book_id`),
  ADD KEY `media_id` (`media_id`);

--
-- Indexes for table `cd`
--
ALTER TABLE `cd`
  ADD PRIMARY KEY (`cd_id`),
  ADD KEY `media_id` (`media_id`);

--
-- Indexes for table `delivery_info`
--
ALTER TABLE `delivery_info`
  ADD PRIMARY KEY (`delivery_info_id`);

--
-- Indexes for table `dvd`
--
ALTER TABLE `dvd`
  ADD PRIMARY KEY (`dvd_id`),
  ADD KEY `media_id` (`media_id`);

--
-- Indexes for table `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`invoice_id`),
  ADD UNIQUE KEY `transaction_id` (`transaction_id`),
  ADD KEY `order_id` (`order_id`);

--
-- Indexes for table `media`
--
ALTER TABLE `media`
  ADD PRIMARY KEY (`media_id`);

--
-- Indexes for table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `delivery_info_id` (`delivery_info_id`);

--
-- Indexes for table `order_media`
--
ALTER TABLE `order_media`
  ADD PRIMARY KEY (`media_id`,`order_id`,`delivery_info_id`),
  ADD KEY `order_id` (`order_id`);

--
-- Indexes for table `rush_delivery_info`
--
ALTER TABLE `rush_delivery_info`
  ADD PRIMARY KEY (`delivery_info_id`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`transaction_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `book_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `cd`
--
ALTER TABLE `cd`
  MODIFY `cd_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `delivery_info`
--
ALTER TABLE `delivery_info`
  MODIFY `delivery_info_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT for table `dvd`
--
ALTER TABLE `dvd`
  MODIFY `dvd_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `invoice`
--
ALTER TABLE `invoice`
  MODIFY `invoice_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `media`
--
ALTER TABLE `media`
  MODIFY `media_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `order`
--
ALTER TABLE `order`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `transaction_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `book_ibfk_1` FOREIGN KEY (`media_id`) REFERENCES `media` (`media_id`);

--
-- Constraints for table `cd`
--
ALTER TABLE `cd`
  ADD CONSTRAINT `cd_ibfk_1` FOREIGN KEY (`media_id`) REFERENCES `media` (`media_id`);

--
-- Constraints for table `dvd`
--
ALTER TABLE `dvd`
  ADD CONSTRAINT `dvd_ibfk_1` FOREIGN KEY (`media_id`) REFERENCES `media` (`media_id`);

--
-- Constraints for table `invoice`
--
ALTER TABLE `invoice`
  ADD CONSTRAINT `invoice_ibfk_1` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`transaction_id`),
  ADD CONSTRAINT `invoice_ibfk_2` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`);

--
-- Constraints for table `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `order_ibfk_1` FOREIGN KEY (`delivery_info_id`) REFERENCES `delivery_info` (`delivery_info_id`);

--
-- Constraints for table `order_media`
--
ALTER TABLE `order_media`
  ADD CONSTRAINT `order_media_ibfk_1` FOREIGN KEY (`media_id`) REFERENCES `media` (`media_id`),
  ADD CONSTRAINT `order_media_ibfk_2` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`);

--
-- Constraints for table `rush_delivery_info`
--
ALTER TABLE `rush_delivery_info`
  ADD CONSTRAINT `rush_delivery_info_ibfk_1` FOREIGN KEY (`delivery_info_id`) REFERENCES `delivery_info` (`delivery_info_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
