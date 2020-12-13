<?php
	include("connect.php");
	if(!isset($_COOKIE['dangnhap']) &&  !isset($_COOKIE['matkhau'])){
		header("location:index.php");
	}
	if(isset($_GET['s'])){
		$id=$_GET['s'];
		$result="SELECT * FROM sanpham WHERE id=$id";
		$select=$con->query($result);
		$row=$select->fetch_assoc();
	}
	if(isset($_POST['edit'])){
		$idsp=$row['id'];
		$tensanpham=$_POST["suatensanpam"];
		$chitiec=$_POST["suachitiecsanpham"];
		$gia=$_POST["giasanpham"];
		$anh=$_POST['anhsanphamt'];
		if($anh!=""){
			$duongdan=$_POST['anhsanphamt'];
		}else{
			$duongdan=$row['hinhanhsanpham'];
		}
		$sql="UPDATE sanpham SET tensanpham='$tensanpham',motasanpham='$chitiec',giasanpham='$gia',hinhanhsanpham='$duongdan' WHERE id='$idsp'";
		$con->query($sql);
		header('location: danhsachpsanpham.php');
		

	}
	if(isset($_POST['back'])){
		header("location:danhsachpsanpham.php");
	}
	
	
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Sửa Sản Phẩm</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery.min.js"></script>
    <script src="js/popper.min.js"></script> 
	<script src="js/bootstrap.min.js"></script>
	<link rel="shortcut icon" type="image/png" href="favicon.png"/ >
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


#suatensanpam ,#exampleFormControlTextarea1 ,#giasanpham{	
	
	font-weight:bold;
	
	
	margin : auto;
}

#noidung{
	text-align:center;
}
#anhsanphamt{
	width:320px;
	margin: auto;
}
#trove{
	
	
	position:absolute;
	left: 2%;
	top: 5%;
	

}

</style>
</head>

<body>
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
<div class="container">
<br>
<br>
<br>	
		<form>
		<div class="form-group">
			<label for="exampleFormControlInput1">Tên Sản Phẩm :</label>
			<input  class="form-control" type="text"  id="suatensanpam" name="suatensanpam" value="<?php echo $row['tensanpham'] ?>"/>  
		</div>
		<div class="form-group">
			<label for="exampleFormControlInput1">Hình Sản Phẩm :</label>
			<img width="150px" height="180px" src="<?php echo $row['hinhanhsanpham'] ?>"> 
		</div>
		<div class="form-group">
			<label for="exampleFormControlInput1">Giá :</label>
			<input  class="form-control" type="text" id="giasanpham" value="<?php echo $row['giasanpham'] ?>"/>
		</div>
		
		<div class="form-group">
			<label for="exampleFormControlTextarea1">Mô Tả : </label>
			<textarea class="form-control" id="exampleFormControlTextarea1" rows="10" cols="10"><?php echo $row['motasanpham'] ?> </textarea></textarea>
		</div>
		</form>
</div>


<form action="" method="POST" enctype="multipart/form-data"> 
<input id="trove" type="submit" class="btn btn-danger" value="Đăng Xuất" name="back"/>

	
        
	<div class="nut">
       <input type="submit"  name="edit"  value="Sửa" class="sua btn btn-success"/> 
       <!-- <input type="submit"   name="troilai"  value="Trở Lại" class="back btn-danger"/>  -->
      </div>
	  <br>
	  <br>
	  <br>
 </form>
</div>
</body>
</html>