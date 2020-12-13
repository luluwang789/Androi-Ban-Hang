-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2020 at 08:28 AM
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
  `idsanpham` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`id`, `tensanpham`, `giasanpham`, `hinhanhsanpham`, `motasanpham`, `idsanpham`) VALUES
(1, 'Huawei Y9 2019', 5400000, 'https://cdn.tgdd.vn/Products/Images/42/192313/huawei-y9-2019-blue-600x600.jpg', 'Màn hình \"tai thỏ\" FullView kích thước lớn.Huawei Y9 (2019) mang trong mình tới 4 camera với camera kép phía trước độ phân giải 16 MP + 2 MP và camera kép phía sau là 13 MP + 2 MP, cả hai cụm camera đều tích hợp với công nghệ chụp ảnh AI .Công nghệ nhận diện vân tay 4.0\r\n', 1),
(2, 'Huawei Mate 20 Pro', 21990000, 'https://cdn.tgdd.vn/Products/Images/42/188963/huawei-mate-20-pro-tim-400x460.png', 'Huawei Mate 20 Pro được trang bị một không gian hiển thị rộng rãi có kích thước lên đến 6.39 inch đi kèm độ phân giải Quad HD+ (2K+) siêu nét.-Hiệu năng hàng đầu hiện nay.-6 GB RAM và 128 GB bộ nhớ trong đi kèm giúp bạn thỏa sức chạy đa nhiệm hay lưu trữ game và ứng dụng mà không cần lo lắng', 1),
(5, 'Điện thoại OPPO Find X', 20000, 'https://cdn.tgdd.vn/Products/Images/42/165189/oppo-find-x-2-400x460-400x460.png', '            Sức mạnh đến từ con chip Snapdragon 845 cùng 8 GB RAM sẽ là thông số đáng mơ ước trên một chiếc smartphone và nay đã có mặt trên OPPO Find X.    ', 1),
(7, 'Điện thoại iPhone Xs Max 512GB', 43990000, 'https://cdn.tgdd.vn/Products/Images/42/191482/iphone-xs-max-512gb-gold-400x460.png', 'Là chiếc smartphone cao cấp nhất của Apple với mức giá khủng chưa từng có, bộ nhớ trong lên tới 512GB, iPhone XS Max 512GB - sở hữu cái tên khác biệt so với các thế hệ trước, trang bị tới 6.5 inch đầu tiên của hãng cùng các thiết kế cao cấp hiện đại từ chip A12 cho tới camera AI.', 1),
(8, 'Laptop Dell Vostro 3468', 10490000, 'https://cdn.tgdd.vn/Products/Images/44/166382/dell-vostro-3468-70142649-450-600x600.jpg', 'Dell Vostro 3468 i3 6006U là chiếc máy tính xách tay có cấu hình tốt trong tầm giá, được trang bị chip Intel Core i3 cho hiệu năng ổn định, ổ cứng HDD lưu trữ lên đến 500 GB.', 2),
(9, 'Laptop Dell Inspiron', 11990000, 'https://cdn.tgdd.vn/Products/Images/44/189385/dell-inspiron-3476-8j61p11-450-600x600.png', 'Dell Inspiron 3476 i3 8130U là phiên bản máy tính xách tay được trang bị cấu hình cơ bản với chip Intel Core i3 Kabylake Refresh, RAM DDR4 4 GB, ổ cứng HDD lên đến 1 TB, cùng hệ điều hành Windows 10 được cài đặt sẵn. Đây sẽ là lựa chọn phù hợp cho đối tượng như học sinh - sinh viên cần một chiếc laptop đáp ứng tốt các nhu cầu cơ bản của công việc văn phòng cũng như học tập.', 2),
(10, 'Laptop Apple Macbook Air', 21990000, 'https://cdn.tgdd.vn/Products/Images/44/106875/apple-macbook-air-mqd32sa-a-i5-5350u-400-1-450x300-600x600.jpg', '   Macbook Air MQD32SA/A i5 5350U với thiết kế vỏ nhôm nguyên khối Unibody rất đẹp, chắc chắn và sang trọng. Macbook Air là một chiếc máy tính xách tay siêu mỏng nhẹ, hiệu năng ổn định mượt mà, thời lượng pin cực lâu, phục vụ tốt cho nhu cầu làm việc lẫn giải trí.. ', 2),
(11, 'Laptop Acer Aspire', 9990000, 'https://cdn.tgdd.vn/Products/Images/44/160296/acer-aspire-e5-476-i3-8130u-nxgwtsv002-ava-600x600.jpg', 'Acer Aspire E5 476 i3 8130U là phiên bản máy tính xách tay với cấu hình cao, sử dụng vi xử lý mạnh mẽ trong phân khúc nhưng vẫn rất tiết kiệm pin do sử dụng kiến trúc chip mới từ Intel. Laptop Acer với mức giá thành hợp lý cùng cấu hình cực kì mạnh mẽ, Aspire E5 476 có thể đáp ứng tốt cho người dùng phổ thông cần một chiếc máy laptop để học tập, giải trí.', 2),
(12, 'Laptop Acer Spin 3 SP314 51 39WK', 12990000, 'https://cdn.tgdd.vn/Products/Images/44/145919/acer-spin-3-sp314-51-39wk-i3-7130u-nxguwsv001-cava-600x600.jpg', '      Acer Spin 3 SP314 51 39WK là mẫu máy tính có thiên hướng thiết kế về thời trang và sự linh hoạt, tiện lợi vượt trội. Là một chiếc laptop nhỏ gọn, màn hình cảm ứng và có thể biến đổi nhiều hình dạng phù hợp với các nhu cầu sử dụng.  ', 2),
(13, 'Laptop HP Pavilion x360 ba080TU ', 12990000, 'https://cdn.tgdd.vn/Products/Images/44/179677/hp-pavilion-x360-ba080tu-3mr79pa-450-600x600.jpg', 'HP Pavilion x360 ba080TU là chiếc laptop xuất thân từ dòng sản phẩm Pavillion đến từ thương hiệu nổi tiếng HP. Với thiết kế vô cùng gọn nhẹ và cấu hình khá tốt, đáp ứng tốt cho người dùng có nhu cầu mang theo máy tính để học tập, làm việc', 2),
(14, 'Laptop HP Pavilion 14 ce1011TU i3', 13290000, 'https://cdn.tgdd.vn/Products/Images/44/197626/hp-pavilion-14-ce1011tu-i3-8145u-4gb-1tb-win10-5j-600x600.jpg', 'Laptop HP Pavilion 14 ce1011TU (5JN17PA) với thiết kế trang nhã, mỏng nhẹ thuận tiện cho việc di chuyển. Cùng với đó là một cấu hình đáp ứng mượt mà các ứng dụng văn phòng cũng như xử lý khá tốt các ứng dụng đồ họa cơ bản, thì đây chắc hẳn sẽ là một sự lựa chọn đáng để cân nhắc dành cho các bạn sinh viên và nhân viên văn phòng trong phân khúc', 2),
(15, 'Laptop Lenovo IdeaPad 130', 8990000, 'https://cdn.tgdd.vn/Products/Images/44/187012/lenovo-ideapad-130-14ikb-81h60017vn-ava-600x600.jpg', 'Laptop Lenovo IdeaPad 130 14IKB có cấu hình ở mức khá với hệ điều hành Windows 10 bản quyền, chip Intel Core i3 thế hệ thứ 7, 4 GB RAM cùng ổ cứng lưu trữ HDD 1 TB, cho hiệu năng hoạt động ổn định đối với các tác vụ cơ bản như soạn thảo văn bản, nhập liệu, học anh văn, làm bài thuyết trình,... Đây sẽ là chiếc máy tính phù hợp với đối tượng người dùng như nhân viên văn phòng, học sinh - sinh viên', 2),
(17, ' Samsung Galaxy S9', 19990000, 'https://cdn.tgdd.vn/Products/Images/42/197080/samsung-galaxy-s9-plus-64gb-vang-do-400x460.png', 'Galaxy S9+ Vang Đỏ đã được Samsung chính thức mở bán vào dịp Noel, đầu năm mới. Máy tích hợp toàn bộ những tính năng cao cấp nhất như camera kép điều chỉnh khẩu độ, quét mống mắt, chống nước chống bụi và trang bị chip Exynos 9810 đầy mạnh mẽ', 1),
(18, 'Samsung Galaxy A8 Star', 8990000, 'https://cdn.tgdd.vn/Products/Images/42/166247/samsung-galaxy-a8-star-tet-giatot-400x460-400x460.png', 'Samsung Galaxy A8 Star là một biến thể mới của dòng A trong gia đình Samsung với sự nâng cấp vượt trội về camera cũng như thay đổi trong thiết kế', 1),
(19, 'Laptop HP Pavilion 14', 16390000, 'https://cdn.tgdd.vn/Products/Images/44/196907/hp-pavilion-14-ce1018tu-i5-8265u-4gb-16gb-1tb-14f-33397-thumb-600x600.jpg', 'Laptop HP Pavilion 14 (5RL41PA) vừa được HP đưa ra thị trường với thiết kế tinh tế, cùng với trọng lượng khá nhẹ thuận tiện hơn cho việc di chuyển hằng ngày. Cấu hình đủ mạnh để chạy mượt mà các ứng dụng văn phòng, xử lý tốt các thao tác kéo thả trong ứng dụng đồ họa cơ bản. Đây sẽ là sự lựa chọn đáng cân nhắc cho các bạn nhà học sinh, sinh viên và nhân viên văn phòng', 2);

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
(3, 'Nguyễn Quốc', 'Cường', 'spaceteam.hcmue@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', '0943597722', 'Nam', 2, '351A Lạc Long Quân Phường 5 Quận 11 TP.Hồ Chí Minh'),
(6, 'Phạm ', 'Duy', 'phamhjuynhquocduy@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', '0947994443', 'Nam', 2, '280 An Dương Vương Phường 4 Quận 5 TP.Hồ Chí Minh'),
(9, 'Admin', 'Cường', 'nguyenquoccuongcn20@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', '0943597722', 'Nam', 1, 'ĐH Sư Phạm TP.Hồ Chí Minh'),
(11, 'Dương', 'Thái', 'duongthainhata10@gmail.com\r\n\r\n\r\n', 'e10adc3949ba59abbe56e057f20f883e', '0795420051', 'Nam', 2, '351A Lạc Long Quân Phường 5 Quận 11 TP.Hồ Chí Minh'),
(12, 'Trần', 'Đức', 'duchoaikevin279@gmail.com\r\n\r\n\r\n', 'e10adc3949ba59abbe56e057f20f883e', '0945236581', 'Nam', 2, '351A Lạc Long Quân Phường 5 Quận 11 TP.Hồ Chí Minh'),
(13, 'nguyễn', 'toan', 'toanbeob@gmail.com', '0494459ab444f856789bd049f000c5ce', '0123569854', 'Nam', 2, 'cầu giấy đống đa hà nội');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chitiecdonhang`
--
ALTER TABLE `chitiecdonhang`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `donhang`
--
ALTER TABLE `donhang`
  ADD PRIMARY KEY (`id`);

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
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`MaTaiKhoan`),
  ADD KEY `MaLoaiTK` (`MaLoaiTK`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `chitiecdonhang`
--
ALTER TABLE `chitiecdonhang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT for table `donhang`
--
ALTER TABLE `donhang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `taikhoan`
--
ALTER TABLE `taikhoan`
  MODIFY `MaTaiKhoan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD CONSTRAINT `taikhoan_ibfk_1` FOREIGN KEY (`MaLoaiTK`) REFERENCES `loaitaikhoan` (`STT`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
