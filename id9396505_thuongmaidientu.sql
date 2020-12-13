-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 13, 2020 at 10:22 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id9396505_thuongmaidientu`
--

-- --------------------------------------------------------

--
-- Table structure for table `chitiecdonhang`
--

CREATE TABLE `chitiecdonhang` (
  `id` int(11) NOT NULL,
  `madonhang` int(11) NOT NULL,
  `masanpham` int(11) NOT NULL,
  `soluongsanpham` int(11) NOT NULL,
  `tientungsanpham` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `donhang`
--

CREATE TABLE `donhang` (
  `id` int(11) NOT NULL,
  `idkhachhang` int(11) DEFAULT NULL,
  `TONGTIEN` float DEFAULT NULL,
  `NgayThanhToan` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf32 COLLATE=utf32_unicode_ci;

--
-- Dumping data for table `donhang`
--

INSERT INTO `donhang` (`id`, `idkhachhang`, `TONGTIEN`, `NgayThanhToan`) VALUES
(48, 3, 12990000, '2020-05-15'),
(49, 3, 18980000, '2020-05-15'),
(50, 3, 42970000, '2020-05-15');

-- --------------------------------------------------------

--
-- Table structure for table `loaisanpham`
--

CREATE TABLE `loaisanpham` (
  `Id` int(11) NOT NULL,
  `TenLoaiSanPham` varchar(200) NOT NULL,
  `hinhanhloaisanpham` varchar(2000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `loaisanpham`
--

INSERT INTO `loaisanpham` (`Id`, `TenLoaiSanPham`, `hinhanhloaisanpham`) VALUES
(1, 'Điện Thoại', 'https://vn-test-11.slatic.net/p/huawei-gr5-mini-l31g-16gb-gold-8778-6189362-2eb679224529d3ff0f02a4f320843b9f-catalog.jpg_340x340q80.jpg_.webp'),
(2, 'Laptop', 'https://i.dell.com/sites/csimages/Videos_Images/en/9eb776ec-d2b3-450c-b340-e1b5f6f31eeb.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `loaitaikhoan`
--

CREATE TABLE `loaitaikhoan` (
  `STT` int(11) NOT NULL,
  `TenLoai` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `loaitaikhoan`
--

INSERT INTO `loaitaikhoan` (`STT`, `TenLoai`) VALUES
(1, 'Người Quản Trị'),
(2, 'Khách Hàng');

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE `sanpham` (
  `id` int(11) NOT NULL,
  `tensanpham` varchar(200) NOT NULL,
  `giasanpham` int(15) NOT NULL,
  `hinhanhsanpham` varchar(2000) NOT NULL,
  `motasanpham` varchar(1000) NOT NULL,
  `idsanpham` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`id`, `tensanpham`, `giasanpham`, `hinhanhsanpham`, `motasanpham`, `idsanpham`) VALUES
(5, '', 0, 'https://cdn.tgdd.vn/Products/Images/42/165189/oppo-find-x-2-400x460-400x460.png', ' ', 1),
(7, 'Điện thoại iPhone Xs Max 512GB', 43990000, 'https://cdn.tgdd.vn/Products/Images/42/191482/iphone-xs-max-512gb-gold-400x460.png', 'Là chiếc smartphone cao cấp nhất của Apple với mức giá khủng chưa từng có, bộ nhớ trong lên tới 512GB, iPhone XS Max 512GB - sở hữu cái tên khác biệt so với các thế hệ trước, trang bị tới 6.5 inch đầu tiên của hãng cùng các thiết kế cao cấp hiện đại từ chip A12 cho tới camera AI.', 1),
(12, 'CcccLaptop Acer Spin 3 SP314 51 39WK', 3129900, 'https://cdn.tgdd.vn/Products/Images/44/145919/acer-spin-3-sp314-51-39wk-i3-7130u-nxguwsv001-cava-600x600.jpg', ' ', 2),
(14, 'Laptop HP Pavilion 14 ce1011TU i3', 13290000, 'https://cdn.tgdd.vn/Products/Images/44/197626/hp-pavilion-14-ce1011tu-i3-8145u-4gb-1tb-win10-5j-600x600.jpg', 'Laptop HP Pavilion 14 ce1011TU (5JN17PA) với thiết kế trang nhã, mỏng nhẹ thuận tiện cho việc di chuyển. Cùng với đó là một cấu hình đáp ứng mượt mà các ứng dụng văn phòng cũng như xử lý khá tốt các ứng dụng đồ họa cơ bản, thì đây chắc hẳn sẽ là một sự lựa chọn đáng để cân nhắc dành cho các bạn sinh viên và nhân viên văn phòng trong phân khúc', 2),
(15, 'Laptop Lenovo IdeaPad 130', 8990000, 'https://cdn.tgdd.vn/Products/Images/44/187012/lenovo-ideapad-130-14ikb-81h60017vn-ava-600x600.jpg', 'Laptop Lenovo IdeaPad 130 14IKB có cấu hình ở mức khá với hệ điều hành Windows 10 bản quyền, chip Intel Core i3 thế hệ thứ 7, 4 GB RAM cùng ổ cứng lưu trữ HDD 1 TB, cho hiệu năng hoạt động ổn định đối với các tác vụ cơ bản như soạn thảo văn bản, nhập liệu, học anh văn, làm bài thuyết trình,... Đây sẽ là chiếc máy tính phù hợp với đối tượng người dùng như nhân viên văn phòng, học sinh - sinh viên', 2),
(17, ' Samsung Galaxy S9', 19990000, 'https://cdn.tgdd.vn/Products/Images/42/197080/samsung-galaxy-s9-plus-64gb-vang-do-400x460.png', 'ccGalaxy S9+ Vang Đỏ đã được Samsung chính thức mở bán vào dịp Noel, đầu năm mới. Máy tích hợp toàn bộ những tính năng cao cấp nhất như camera kép điều chỉnh khẩu độ, quét mống mắt, chống nước chống bụi và trang bị chip Exynos 9810 đầy mạnh mẽ ', 1),
(18, 'Samsung Galaxy A8 Star', 8990000, 'https://cdn.tgdd.vn/Products/Images/42/166247/samsung-galaxy-a8-star-tet-giatot-400x460-400x460.png', 'Samsung Galaxy A8 Star là một biến thể mới của dòng A trong gia đình Samsung với sự nâng cấp vượt trội về camera cũng như thay đổi trong thiết kế', 1),
(19, 'Laptop HP Pavilion 14', 16390000, 'https://cdn.tgdd.vn/Products/Images/44/196907/hp-pavilion-14-ce1018tu-i5-8265u-4gb-16gb-1tb-14f-33397-thumb-600x600.jpg', 'Laptop HP Pavilion 14 (5RL41PA) vừa được HP đưa ra thị trường với thiết kế tinh tế, cùng với trọng lượng khá nhẹ thuận tiện hơn cho việc di chuyển hằng ngày. Cấu hình đủ mạnh để chạy mượt mà các ứng dụng văn phòng, xử lý tốt các thao tác kéo thả trong ứng dụng đồ họa cơ bản. Đây sẽ là sự lựa chọn đáng cân nhắc cho các bạn nhà học sinh, sinh viên và nhân viên văn phòng', 2),
(28, 'iPhone 11 Pro 64GB', 26030000, 'https://cdn.tgdd.vn/Products/Images/42/188705/iphone-11-pro-black-400x460.png', 'Nếu như bây giờ để lựa chọn một thiết bị có thể sử dụng ổn định và được cập nhật trong khoảng 3 năm nữa thì không có sự lựa chọn nào xuất sắc hơn chiếc iPhone 11 Pro 64GB, siêu phẩm mới được giới thiệu cách đây không lâu tới từ Apple.', 1),
(29, 'iPhone Xs Max 256GB', 25990000, 'https://cdn.tgdd.vn/Products/Images/42/190322/iphone-xs-max-256gb-white-400x460.png', 'Đặc điểm nổi bật của iPhone Xs Max 256GB\r\n\r\nTìm hiểu thêm\r\nBộ sản phẩm chuẩn: Hộp, Sạc, Tai nghe, Sách hướng dẫn, Cáp, Cây lấy sim\r\n\r\nSau 1 năm mong chờ, chiếc smartphone cao cấp nhất của Apple đã chính thức ra mắt mang tên iPhone Xs Max 256 GB. Máy các trang bị các tính năng cao cấp nhất từ chip A12 Bionic, dàn loa đa chiều cho tới camera kép tích hợp trí tuệ nhân tạo.', 1),
(30, 'Samsung Galaxy S20 Ultra', 20990000, 'https://cdn.tgdd.vn/Products/Images/42/217937/samsung-galaxy-s20-ultra-400x460-1-400x460.png', 'Samsung Galaxy S20 Ultra siêu phẩm công nghệ hàng đầu của Samsung mới ra mắt với nhiều đột phá công nghệ, màn hình tràn viền không khuyết điểm, hiệu năng đỉnh cao, camera độ phân giải siêu khủng 108 MP cùng khả năng zoom 100X thách thức mọi giới hạn smartphone.', 1),
(31, 'Samsung Galaxy Z Flip', 36000000, 'https://cdn.tgdd.vn/Products/Images/42/213022/samsung-galaxy-z-flip-chitiet-2-788x544.png', 'Cuối cùng sau bao nhiêu thời gian chờ đợi, chiếc điện thoại Samsung Galaxy Z Flip đã được Samsung ra mắt tại sự kiện Unpacked 2020. Siêu phẩm với thiết kế màn hình gập vỏ sò độc đáo, hiệu năng tuyệt đỉnh cùng nhiều công nghệ thời thượng, dẫn dầu 2020.', 1),
(32, 'iPhone 8 Plus 64GB', 13990000, 'https://cdn.tgdd.vn/Products/Images/42/114110/iphone-8-plus-083120-053103-400x460.png', 'Thừa hưởng những thiết kế đã đạt đến độ chuẩn mực, thế hệ iPhone 8 Plus thay đổi phong cách bóng bẩy hơn và bổ sung hàng loạt tính năng cao cấp cho trải nghiệm sử dụng vô cùng tuyệt vời.', 1),
(33, 'Xiaomi Mi Note 10 Pro', 13990000, 'https://cdn.tgdd.vn/Products/Images/42/213590/xiaomi-mi-note-10-pro-black-400x460.png', 'Siêu phẩm tầm trung Xiaomi Mi Note 10 Pro, chiếc smartphone đầu tiên sở hữu ống kính độ phân giải 108 MP cùng hệ thống 5 camera độc đáo, công nghệ sạc siêu nhanh 30W đi kèm nhiều tính năng nổi trội khác.', 1),
(34, 'Xiaomi Redmi Note 8 Pro (6GB/128GB)', 5030000, 'https://cdn.tgdd.vn/Products/Images/42/214418/xiaomi-redmi-note-8-pro-6gb-128gb-white-400x460.png', 'Là phiên bản nâng cấp của chiếc Xiaomi Redmi Note 7 Pro đã \"làm mưa làm gió\" trên thị trường trước đó, chiếc Xiaomi Redmi Note 8 Pro (6GB/128GB) sẽ là sự lựa chọn hàng đầu dành cho người dùng quan tâm nhiều về hiệu năng và camera của một chiếc máy tầm trung.', 1),
(35, 'Samsung Galaxy Note 10', 15990000, 'https://cdn.tgdd.vn/Products/Images/42/191276/samsung-galaxy-note-10-silver-400x460.png', 'Nếu như từ trước tới nay dòng Galaxy Note của Samsung thường ít được các bạn nữ sử dụng bởi kích thước màn hình khá lớn khiến việc cầm nắm trở nên khó khăn thì Samsung Galaxy Note 10 sẽ là chiếc smartphone nhỏ gọn, phù hợp với cả những bạn có bàn tay nhỏ.', 1),
(36, 'Samsung Galaxy A80', 8990000, 'https://cdn.tgdd.vn/Products/Images/42/201228/samsung-galaxy-a80-050220-050225-400x460.png', 'Samsung Galaxy A80 là chiếc smartphone mang trong mình rất nhiều đột phá của Samsung và hứa hẹn sẽ là \"ngọn cờ đầu\" cho những chiếc smartphone sở hữu một màn hình tràn viền thật sự.', 1),
(37, 'Apple MacBook Air 2020 i5', 30990000, 'https://cdn.tgdd.vn/Products/Images/44/220173/apple-macbook-air-2020-gold-1-600x600.jpg', 'MacBook Air 2020 là phiên bản có nhiều nâng cấp vượt trội về cấu hình và thiết kế bàn phím, hứa hẹn đem tới trải nghiệm mượt mà, thoải mái hơn tới người dùng. Chiếc máy vẫn là lựa chọn số 1 dành cho các anh em văn phòng muốn sở hữu chiếc laptop mỏng nhẹ, mượt mà và pin lâu.', 2),
(38, 'MacBook Pro Touch 2020 i5', 34990000, 'https://cdn.tgdd.vn/Products/Images/44/224643/macbook-pro-touch-2020-i5-14ghz-8gb-256gb-mxk32sa-600x600.jpg', 'MacBook Pro Touch 2020 i5 (MXK32SA/A) mang đến thiết kế siêu mỏng nhẹ và sang trọng với cấu hình mạnh mẽ bên trong, màn hình Retina tuyệt mỹ cùng bàn phím cắt kéo thế hệ mới đem đến trải nghiệm tuyệt vời cho người dùng.', 2),
(39, 'Dell Vostro 3590 i7', 19990000, 'https://cdn.tgdd.vn/Products/Images/44/220718/dell-vostro-3590-i7-grmgk2-220718-220718-600x600.jpg', 'Laptop Dell Vostro 3590 i7 (GRMGK2) là phiên bản laptop đồ họa kĩ thuật có thiết kế hiện đại, cấu hình khỏe với vi xử lí gen 10 và card đồ họa rời. Đây chính là chiếc laptop đáng cân nhắc đối với dân đồ họa hay sinh viên khối ngành kĩ thuật.', 2),
(40, 'Dell Inspiron 7373 i5', 26990000, 'https://cdn.tgdd.vn/Products/Images/44/136214/dell-inspiron-7373-i5-8250u-8gb-256gb-win10-office-450-600x600.jpg', 'Dell Inspiron 7373 i5 8250U là mẫu laptop có thiết kế mỏng nhẹ và sang trọng với chất liệu nhôm nguyên khối thuộc phân khúc laptop phù hợp với doanh nhân, máy được trang bị cấu hình khá mạnh cho các nhu cầu làm việc, giải trí.', 2),
(41, 'Acer Nitro AN515 43 R9FD', 19490000, 'https://cdn.tgdd.vn/Products/Images/44/221409/acer-nitro-an515-43-r5-nhq6zsv003-600x600.jpg', 'Laptop Acer Nitro AN515 (NH.Q6ZSV.003) phiên bản 2019 là mẫu laptop gaming tầm trung có thiết kế hầm hố, cấu hình mạnh, đồ họa mượt mà với card màn hình Geforce GTX 1650. Đây là chiếc laptop không chỉ phù hợp cho chơi game mà còn làm việc, thiết kế đồ họa tốt. ', 2);

-- --------------------------------------------------------

--
-- Table structure for table `taikhoan`
--

CREATE TABLE `taikhoan` (
  `MaTaiKhoan` int(11) NOT NULL,
  `Ho` varchar(150) DEFAULT NULL,
  `Ten` varchar(150) DEFAULT NULL,
  `Email` varchar(150) DEFAULT NULL,
  `MatKhau` varchar(250) DEFAULT NULL,
  `SDT` varchar(150) DEFAULT NULL,
  `GioiTinh` varchar(150) DEFAULT NULL,
  `MaLoaiTK` int(11) DEFAULT NULL,
  `diachi` varchar(355) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `taikhoan`
--

INSERT INTO `taikhoan` (`MaTaiKhoan`, `Ho`, `Ten`, `Email`, `MatKhau`, `SDT`, `GioiTinh`, `MaLoaiTK`, `diachi`) VALUES
(3, 'Cuong', 'Nguyễn Quốc', 'spaceteam.hcmue@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', '0943597722', 'Nam', 2, '351A Lạc Long Quân Phường 5 Quận 11 TP.Hồ Chí Minh'),
(6, 'Phạm ', 'Duy', 'phamhjuynhquocduy@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', '0394668337', 'Nam', 2, '280 An Dương Vương Phường 4 Quận 5 TP.Hồ Chí Minh'),
(9, 'Admin', '', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '0943597722', 'Nam', 1, 'ĐH Sư Phạm TP.Hồ Chí Minh'),
(11, 'Dương', 'Thái', 'duongthainhata10@gmail.com\r\n\r\n\r\n', 'e10adc3949ba59abbe56e057f20f883e', '0795420051', 'Nam', 2, '351A Lạc Long Quân Phường 5 Quận 11 TP.Hồ Chí Minh'),
(12, 'Trần', 'Đức', 'duchoaikevin279@gmail.com\r\n\r\n\r\n', 'e10adc3949ba59abbe56e057f20f883e', '0945236581', 'Nam', 2, '351A Lạc Long Quân Phường 5 Quận 11 TP.Hồ Chí Minh');

-- --------------------------------------------------------

--
-- Table structure for table `yeuthich`
--

CREATE TABLE `yeuthich` (
  `idtaikhoan` int(11) NOT NULL,
  `idsanpham` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `yeuthich`
--

INSERT INTO `yeuthich` (`idtaikhoan`, `idsanpham`) VALUES
(3, 18),
(3, 19),
(6, 17),
(9, 19);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chitiecdonhang`
--
ALTER TABLE `chitiecdonhang`
  ADD PRIMARY KEY (`id`),
  ADD KEY `madonhang` (`madonhang`);

--
-- Indexes for table `donhang`
--
ALTER TABLE `donhang`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idkhachhang` (`idkhachhang`);

--
-- Indexes for table `loaisanpham`
--
ALTER TABLE `loaisanpham`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `loaitaikhoan`
--
ALTER TABLE `loaitaikhoan`
  ADD PRIMARY KEY (`STT`);

--
-- Indexes for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idsanpham` (`idsanpham`);

--
-- Indexes for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`MaTaiKhoan`),
  ADD KEY `MaLoaiTK` (`MaLoaiTK`);

--
-- Indexes for table `yeuthich`
--
ALTER TABLE `yeuthich`
  ADD PRIMARY KEY (`idtaikhoan`,`idsanpham`),
  ADD KEY `idsanpham` (`idsanpham`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `chitiecdonhang`
--
ALTER TABLE `chitiecdonhang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;

--
-- AUTO_INCREMENT for table `donhang`
--
ALTER TABLE `donhang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;

--
-- AUTO_INCREMENT for table `loaisanpham`
--
ALTER TABLE `loaisanpham`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `loaitaikhoan`
--
ALTER TABLE `loaitaikhoan`
  MODIFY `STT` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT for table `taikhoan`
--
ALTER TABLE `taikhoan`
  MODIFY `MaTaiKhoan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chitiecdonhang`
--
ALTER TABLE `chitiecdonhang`
  ADD CONSTRAINT `chitiecdonhang_ibfk_1` FOREIGN KEY (`madonhang`) REFERENCES `donhang` (`id`);

--
-- Constraints for table `donhang`
--
ALTER TABLE `donhang`
  ADD CONSTRAINT `donhang_ibfk_1` FOREIGN KEY (`idkhachhang`) REFERENCES `taikhoan` (`MaTaiKhoan`);

--
-- Constraints for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `sanpham_ibfk_1` FOREIGN KEY (`idsanpham`) REFERENCES `loaisanpham` (`Id`);

--
-- Constraints for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD CONSTRAINT `taikhoan_ibfk_1` FOREIGN KEY (`MaLoaiTK`) REFERENCES `loaitaikhoan` (`STT`);

--
-- Constraints for table `yeuthich`
--
ALTER TABLE `yeuthich`
  ADD CONSTRAINT `yeuthich_ibfk_1` FOREIGN KEY (`idtaikhoan`) REFERENCES `taikhoan` (`MaTaiKhoan`),
  ADD CONSTRAINT `yeuthich_ibfk_2` FOREIGN KEY (`idsanpham`) REFERENCES `sanpham` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
