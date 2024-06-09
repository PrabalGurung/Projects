-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 10, 2024 at 08:42 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `nexusnimbus`
--

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `ID` int(11) NOT NULL,
  `customerId` int(11) NOT NULL,
  `prodId` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cart`
--

INSERT INTO `cart` (`ID`, `customerId`, `prodId`, `quantity`, `amount`) VALUES
(58, 1, 2, 1, 1200),
(59, 1, 3, 1, 1200),
(67, 1, 6, 1, 123),
(68, 1, 7, 1, 1232),
(70, 1, 6, 1, 123),
(71, 1, 7, 1, 1232),
(84, 1, 32, 1, 12333),
(85, 9, 36, 1, 899);

-- --------------------------------------------------------

--
-- Table structure for table `contact`
--

CREATE TABLE `contact` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `message` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `contact`
--

INSERT INTO `contact` (`id`, `name`, `email`, `message`) VALUES
(1, 'asd', 'asd', 'asd'),
(2, 'aaw', '@asd', 'asd'),
(3, 'sdasd3w', '@asfa', 'sfdadfva'),
(4, 'sdasd', 'adad', 'sdasjd'),
(5, 'sdasd', 'adad', 'sdasjd'),
(6, 'sad', 'sad', 'asd'),
(7, 'asd asd', 'asdfa@dfdgsd', 'asd'),
(8, 'asd asd', 'asdfa@dfdgsd', 'asdasxaseqww'),
(9, 'asd asd', 'asdfa@dfdgsd', 'asdfe2'),
(10, 'asd asd', 'asdfa@dfdgsd', 'asdfe2aa'),
(11, 'asd asd', 'asdfa@dfdgsd', 'asd'),
(12, 'asd asd', 'asdfa@dfdgsd', 'asdas\r\n'),
(13, 'asd asd', 'asdfa@dfdgsd', 'asdas\r\n'),
(14, 'asd asd', 'asdfa@dfdgsd', 'asd'),
(15, 'asd asd', 'asdfa@dfdgsd', 'sdaefc '),
(16, 'asd asd', 'asdfa@dfdgsd', 'sdkajhc'),
(17, 'gh', 'gh', 'ghfghfgh'),
(18, 'fgh', 'fgh', 'fghfghfgh'),
(19, 'cvbc', 'cvbc', 'cbvbcfvb'),
(20, 'cvbc', 'cvbc', 'cbvbcfvb'),
(21, '', '', ''),
(22, 'asdwq', 'gprabal505@gmail.com', 'asdawq'),
(23, 'as', 'gprabal505@gmail.com', 'asdw');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `customerId` int(11) NOT NULL,
  `date` date NOT NULL DEFAULT current_timestamp(),
  `totalAmt` int(11) NOT NULL,
  `Status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `customerId`, `date`, `totalAmt`, `Status`) VALUES
(1, 1, '2024-05-09', 1446, 'Delivered'),
(2, 1, '2024-05-09', 1200, 'Pending'),
(3, 1, '2024-05-09', 699, 'Pending'),
(4, 1, '2024-05-09', 24666, 'Pending'),
(5, 1, '2024-05-10', 64897, 'Delivered'),
(6, 10, '2024-05-10', 8595, 'Pending'),
(7, 10, '2024-05-10', 8595, 'Pending'),
(8, 10, '2024-05-10', 9794, 'Pending');

-- --------------------------------------------------------

--
-- Table structure for table `product_info`
--

CREATE TABLE `product_info` (
  `prodId` int(11) NOT NULL,
  `prodName` varchar(255) NOT NULL,
  `brand` varchar(255) NOT NULL,
  `prodPrice` varchar(255) NOT NULL,
  `prodSpecs` varchar(255) NOT NULL,
  `processor` varchar(255) NOT NULL,
  `gpu` varchar(255) NOT NULL,
  `display` varchar(255) NOT NULL,
  `memory` varchar(255) NOT NULL,
  `storage` varchar(255) NOT NULL,
  `path` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product_info`
--

INSERT INTO `product_info` (`prodId`, `prodName`, `brand`, `prodPrice`, `prodSpecs`, `processor`, `gpu`, `display`, `memory`, `storage`, `path`) VALUES
(34, 'XPS 15 ', 'Dell', '2499', 'New', '13th Gen IntelÂ® Coreâ¢ i9-13900H (24 MB cache, 14 cores, up to 5.40 GHz Turbo)', 'NVIDIAÂ® GeForce RTXâ¢ 4060, 8 GB GDDR6', '15.6\", FHD+ 1920x1200, 60Hz, Non-Touch, Anti-Glare, 500 nit, InfinityEdge', '32 GB: 2 x 16 GB, DDR5, 4800 MT/s', '1 TB, M.2, PCIe NVMe, SSD', 'Dell_XPS_15.png'),
(35, 'Victus', 'hp', '1199', 'New', '\" 13th Gen IntelÂ® Coreâ¢ i7-13650HX (24 MB cache, 14 cores, 20 threads, up to 4.90 GHz Turbo)\"', 'NVIDIAÂ® GeForce RTXâ¢ 4060, 8 GB GDDR6', '15.6\", FHD 1920x1080, 360Hz, Non-Touch*, 100% sRGB, 1ms, NVIDIA G-SYNC, ComfortView Plus, DDS', '16 GB: 2 x 8 GB, DDR5, 4800 MT/s', '1 TB, M.2, PCIe NVMe, SSD', 'HP_pavillion_plus.png'),
(38, 'OMEN Laptop', 'HP', '1699', 'New', 'IntelÂ® Coreâ¢ i7-13700HX (up to 5.0 GHz, 30 MB L3 cache, 16 cores, 24 threads)Â ', 'Â NVIDIAÂ® GeForce RTXâ¢ 4060 Laptop GPU (8 GB)', '17.3\" diagonal, FHD (1920 x 1080), 144 Hz, 7 ms response time, IPS, micro-edge, anti-glare, Low Blue Light, 300 nits', '16 GB DDR5-4800 SDRAM (2 x 8 GB)', '\"512 GB PCIeÂ® NVMeâ¢ TLC M.2 SSD (4x4 SSD) \"', 'HP_zbook_firely.png'),
(40, 'IdeaPad 3', 'HP', '899', 'New', 'IntelÂ® Coreâ¢ i7-13700HX (up to 5.0 GHz, 30 MB L3 cache, 16 cores, 24 threads)Â ', 'Â NVIDIAÂ® GeForce RTXâ¢ 4060 Laptop GPU (8 GB)', '17.3\" diagonal, FHD (1920 x 1080), 144 Hz, 7 ms response time, IPS, micro-edge, anti-glare, Low Blue Light, 300 nits', '16 GB DDR5-4800 SDRAM (2 x 8 GB)', '\"512 GB PCIeÂ® NVMeâ¢ TLC M.2 SSD (4x4 SSD) \"', 'HP_spectre_x360.png'),
(41, 'Megapad', 'Asus', '899', 'New', 'IntelÂ® Coreâ¢ i7-13700HX (up to 5.0 GHz, 30 MB L3 cache, 16 cores, 24 threads)Â ', 'Â NVIDIAÂ® GeForce RTXâ¢ 4060 Laptop GPU (8 GB)', '17.3\" diagonal, FHD (1920 x 1080), 144 Hz, 7 ms response time, IPS, micro-edge, anti-glare, Low Blue Light, 300 nits', '16 GB DDR5-4800 SDRAM (2 x 8 GB)', '\"512 GB PCIeÂ® NVMeâ¢ TLC M.2 SSD (4x4 SSD) \"', 'Asus_ROG_strix_g15.png'),
(42, 'Chill', 'Asus', '1899', 'New', 'IntelÂ® Coreâ¢ i7-13700HX (up to 5.0 GHz, 30 MB L3 cache, 16 cores, 24 threads)Â ', 'Â NVIDIAÂ® GeForce RTXâ¢ 4060 Laptop GPU (8 GB)', '17.3\" diagonal, FHD (1920 x 1080), 144 Hz, 7 ms response time, IPS, micro-edge, anti-glare, Low Blue Light, 300 nits', '16 GB DDR5-4800 SDRAM (2 x 8 GB)', '\"512 GB PCIeÂ® NVMeâ¢ TLC M.2 SSD (4x4 SSD) \"', 'Asus_2021_ROG_zephyrus_m16.png'),
(43, 'legion', 'Lenovo', '1222', 'New', 'IntelÂ® Coreâ¢ i7-13700HX (up to 5.0 GHz, 30 MB L3 cache, 16 cores, 24 threads)Â ', 'Â NVIDIAÂ® GeForce RTXâ¢ 4060 Laptop GPU (8 GB)', '17.3\" diagonal, FHD (1920 x 1080), 144 Hz, 7 ms response time, IPS, micro-edge, anti-glare, Low Blue Light, 300 nits', '16 GB DDR5-4800 SDRAM (2 x 8 GB)', '\"512 GB PCIeÂ® NVMeâ¢ TLC M.2 SSD (4x4 SSD) \"', 'Asus_2021_ROG_zephyrus_m16.png');

-- --------------------------------------------------------

--
-- Table structure for table `user_info`
--

CREATE TABLE `user_info` (
  `id` int(11) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `is_admin` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_info`
--

INSERT INTO `user_info` (`id`, `first_name`, `last_name`, `phone_number`, `address`, `email`, `password`, `is_admin`) VALUES
(8, 'aman', 'gurung', '9822222222', 'gharipatan', 'rachit@gmail.com', 'LinaQVSDHACvi9ZZopqKBbbn5mkyr0+gVaw6Jmat9ShsiaT3K76WwCqG8gbSrPe0VOZv', '0'),
(9, 'prabal', 'gurung', '9812345678', 'rambazar', 'prabal.gurung@gmail.com', '/Hgaq6FylsEzVEMaS2A7kBlZzBudCz7H/9P1ljJtqrzRhTvt8071oTSrDIh/2ZYzkZg=', '1'),
(10, 'asd', 'asd', '9827145355', 'rambazar', 'prabal.gurung.a22@icp.edu.np', 'IeZKc+CvnKHscrtXa9siUcRJsf9vMpKH7xFK/IcCpeNDYDGNa0jIlOk9UK7Sh/A=', '0');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `contact`
--
ALTER TABLE `contact`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product_info`
--
ALTER TABLE `product_info`
  ADD PRIMARY KEY (`prodId`);

--
-- Indexes for table `user_info`
--
ALTER TABLE `user_info`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=95;

--
-- AUTO_INCREMENT for table `contact`
--
ALTER TABLE `contact`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `product_info`
--
ALTER TABLE `product_info`
  MODIFY `prodId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

--
-- AUTO_INCREMENT for table `user_info`
--
ALTER TABLE `user_info`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
