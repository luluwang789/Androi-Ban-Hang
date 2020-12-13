<?php
ob_start();

if(isset($_POST['dangxuat'])){
		setcookie('dangnhap',$_POST['dangnhap'],time()-3600);
		setcookie('matkhau',$_POST['matkhau'],time()-3600);
		if(headers_sent()){
					die('<script type="text/javascript">window.location.href="'."dangnhap.php".'"</script>'); 
				}else{
					header("location:index.php");
					die();
					
				}
	}
if(isset($_COOKIE['dangnhap']) &&  isset($_COOKIE['matkhau'])){
			$matkhau=md5($_COOKIE['matkhau']);
			include("connect.php");
			$result="SELECT * FROM taikhoan WHERE matkhau='$matkhau' AND MaLoaiTK = 1 ";
			$select=mysqli_query($con, $result);
			$row=$select->fetch_array();
			
}
else{
	header("location:index.php");
		
}
 ?>

<html>
 <head>
	 <title>Trang Chủ</title>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery.min.js"></script>
	<script src="js/popper.min.js"></script> 
	<link rel="shortcut icon" type="image/png" href="favicon.png"/ >
    <script src="js/bootstrap.min.js"></script>
 <style>
	@font-face{
	font-family: Montserrat-Black;
	src: url("font/Montserrat-Black.ttf");
  }
@font-face{ 
	font-family: Montserrat-Light;
	src: url("font/Montserrat-Light.ttf");
}
@font-face{  
	font-family:Montserrat-Medium;
	src: url("font/Montserrat-Medium.ttf");
}
div.dinhdang{
	display:inline-block;
	background:  white;
	border-radius: 10px;
	border:1px solid grey;
	margin-left:100px;
	margin-top:20px;	
	width:700px;
	height:600px;
}
.dinhdang {
	margin: 37px 10px 10px 10px;
	color : black;
}
.acb{
	padding-right: 40px ;
	padding-left: 40px ;
}
ul li{
	font-size:20px;
	/* margin-bottom:20px; */
	list-style:none;
	margin-left:0px;	
}
div.dinhdang h3{
	border-top-left-radius: 10px;
	border-top-right-radius: 10px;
	text-align:center;
	color: wheat;
	
	font-family:Montserrat-Light;
	padding: 10px 0px !important;
	background-color: #df2029;
	
}
body{
	background-image: url("Slide4.PNG");
	background-size: cover;
}


#dangxuat{
	position:absolute;
	margin-top:30px;
	cursor:pointer;
	margin-left:300px;
}
div.sanpham{
	margin-top:20px;
	position:absolute;
	display:inline-block;
}

div.sanpham ul li a{
	font-size: 30px !important;
	font-family: Montserrat-Light;
	color: white ;
	text-decoration:none;
	transition: 0.2s;		
}
div.sanpham ul li:hover a{
	color: #c0392b;
	transition: 0.4s;
}


	
 </style>
 </head>
 <body>
 <div id="banner" > </div>


 <nav class="navbar navbar-expand-sm navbar-dark bg-dark ">
	<div class="container">
	
	 <a class="navbar-brand" href="trangchu.php">SPACE TEAM</a>
	 <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId" aria-controls="collapsibleNavId"
		 aria-expanded="false" aria-label="Toggle navigation"></button>
	 <div class="collapse navbar-collapse" id="collapsibleNavId">
		 <ul class="navbar-nav  mt-4 mt-lg-0">
			 <li class="nav-item active">
				 <a class="nav-link" href="trangchu.php">Home <span class="sr-only">(current)</span></a>
			 </li>
			 <li class="nav-item ">
				 <a class="nav-link" href="danhsachpsanpham.php">Danh Sách Sản Phẩm</a>
			 </li>
			 <li class="nav-item ">
			 	<a class="nav-link" href="themsanpham.php" > Thêm Danh Sách Sản Phẩm </a>
			 </li>
			 <li class="nav-item ">
			 	<a class="nav-link" href="doanhthu.php" > Doanh Thu </a>
			 </li>
			 <li class="nav-item ">
			 	<a class="nav-link" href="thongbao.php" > Thông Báo </a>
			 </li>
		 </ul>
		 
	 </div>
	 </div>
 </nav>


 <div class="dinhdang">
	<h3> Thông Tin Cá Nhân</h3> 	
    <div class="acb"> 
    	
			<div class="form-group">
			  <label for="">Họ và tên</label>
			  <input type="text" class="form-control" name="" id="" aria-describedby="emailHelpId" value="<?php echo $row['Ho'].' '.$row['Ten'] ?>">
			</div>
			<div class="form-group">
			  <label for="">Giới Tính</label>
			  <input type="text" class="form-control" name="" id="" aria-describedby="emailHelpId" value="<?php echo $row['GioiTinh'] ?>">
			</div>
			<div class="form-group">
			  <label for="">Email</label>
			  <input type="text" class="form-control" name="" id="" aria-describedby="emailHelpId" value="<?php echo $row['Email'] ?>">
			</div>
			<div class="form-group">
			  <label for="">Địa chỉ</label>
			  <input type="text" class="form-control" name="" id="" aria-describedby="emailHelpId" value="<?php echo $row['diachi'] ?>">
			</div>
			<div class="form-group">
			  <label for="">Số điện thoại</label>
			  <input type="text" class="form-control" name="" id="" aria-describedby="emailHelpId" value="<?php echo $row['SDT'] ?>">
			</div>
        
    </div>
    
     <form method="post" action="">
            <div class="adangxuat"> <a href="" ></a><input type="submit" name="dangxuat" class=" btn btn-danger" value="Đăng Xuất" id="dangxuat"></div>
     	 </form> 
     
 </div>

 </body>
 </html>