<?php
		include("connect.php");
		$khachhang=array();
		// $taikhoan=$_POST['taikhoan'];
		// $matkhau=md5($_POST['matkhau']);
		$taikhoan = "spaceteam.hcmue@gmail.com";
		$matkhau = md5("123456");
		$sql="SELECT * FROM taikhoan WHERE Email = '$taikhoan' OR SDT = '$taikhoan' AND MatKhau = '$matkhau' ";
		$Dta=$con->query($sql);
		while($row = $Dta->fetch_assoc()){
			array_push($khachhang,
			new Khachhang(	
			$row['MaTaiKhoan'],
			$row['Ho'],
			$row['Ten'],
			$row['SDT'],
			$row['Email'],
			$row['MatKhau'],
			$row['diachi']));
	}
		class Khachhang{
			function Khachhang($MaTaiKhoan,$ho,$ten,$sdt,$email,$MatKhau,$diachi){
				$this->MaTaiKhoan=$MaTaiKhoan;
				$this->ho=$ho;
				$this->ten=$ten;
				$this->sdt=$sdt;
				$this->MatKhau=$MatKhau;
				$this->email=$email;
				$this->diachi=$diachi;
			}
		}
		echo json_encode($khachhang);
	// $row=$Dta->fetch_array();
	// if($row!=null){
	// 	echo json_encode ('['.$row.']');
	// }
?>