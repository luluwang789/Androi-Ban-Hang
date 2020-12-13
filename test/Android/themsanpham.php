<?php
if(!isset($_COOKIE['dangnhap']) &&  !isset($_COOKIE['matkhau'])){
		header("location:index.php");
	}
if(isset($_POST['luulai'])){
	$errors=array();
	$required=array('tensanpham','chitiec','gia','anhsanpham');
	foreach($required as $filedname){
		if(empty($_POST[$filedname])){
				$errors[]="<strong> [$filedname] </strong> chưa được điền.";	
		}
	}
	if(empty($errors)){
				include("connect.php");
				$tensanpham=$_POST["tensanpham"];
				$chitiec=$_POST["chitiec"];
				$anh=$_FILES['anhsanpham']['name'];
				$gia=$_POST["gia"];
				$loaisp=$_POST["loaisanpham"];
				$duongdan=$_POST["anhsanpham"];
				$sql="INSERT INTO sanpham(tensanpham,giasanpham,hinhanhsanpham,motasanpham,idsanpham) VALUES('$tensanpham','$gia','$duongdan','$chitiec','$loaisp')";
				$con->query($sql);
				header('location: danhsachpsanpham.php');
				$con->close();
				}
	
}
			if(isset($_POST['lamlai'])){
				header('location: themsanpham.php');
			}

	if(isset($_POST['back'])){
		header("location:trangchu.php");
	}

?>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Thêm Sản Phẩm</title>
<!-- <link href="dinhdangthemsanpham.css" type="text/css" rel="stylesheet"/> -->
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
body{
	background: white;
}
.luulai, .lamlai{
	cursor:pointer;
}
div.tieude{
	padding:0px;
	width:500px;
	height:60px;
	text-align:center;
	margin:auto;
	font-family:Montserrat-Light;
}
h3{
	margin:30px;
	
	color: black;
	font-size:25px;
}
h5{
	margin:0px;
	padding:0px;
	font-size:20px;
}
div.themsampham{

	background-color: white;
	width:600px;
	height:655px;
	margin: auto;
	
	font-family:Montserrat-Light;
}
form{
	/* border:1px solid grey; */
	background-color: transparent;
	

	padding-left:10px;	
	padding-top:10px;
}
/* table tr th, td{
	
	padding: 10px 0px !important; */

/* table tr td input, textarea ,select{
	margin-left: 40px;
} */

div.loi{
	width:500px;
	height:20px;
	text-align:center;
	margin-left:350px;
}
div.loi ul li{
	list-style:none;
	color:#F00;
	font-size:20px;	
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
			 	<a class="nav-link" href="doanhthu.php" > Doanh Thu </a>
			 </li>
			 <li class="nav-item ">
			 	<a class="nav-link" href="thongbao.php" > Thông Báo </a>
			 </li>
		 </ul>
		 
	 </div>
	 </div>
 </nav>
<div class="tieude" >
	<h3> Thêm Sản Phẩm Mới</h3>
</div>
<div class="themsampham">

		<form action="" method="post" enctype="multipart/form-data">
		<div class="form-group">
			<label for="exampleFormControlInput1">Tên Sản Phẩm</label>
			<input  type="text" class="form-control" name="tensanpham" placeholder="Tên Sản Phẩm">
		</div>
		<div class="form-group">
			<label for="exampleFormControlTextarea1">Chi Tiết Sản Phẩm</label>
			<textarea class="form-control" rows="10" cols="30" name="chitiec" id="exampleFormControlTextarea1" rows="3"></textarea>
		</div>
		<div class="form-group">
			<label for="exampleFormControlInput1">Giá</label>
			<input type="number" class="form-control" name="gia"  placeholder="Giá Sản Phẩm">
		</div>
		<div class="form-group">
			<label for="exampleFormControlInput1">HìnhSản Phẩm</label>
			<input    type="text" class="form-control" name="anhsanpham" type="number"  placeholder="Ảnh">
		</div>
		<div class="form-group">
		<label for="">Loại Sản Phẩm</label>
		<select class="form-control" name="loaisanpham" id="">
			<option value="1">Điện Thoại</option>
			<option value="2">Laptop</option>
			<option></option>
		</select>
		</div>
		

		<div class="footer  text-center"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="luulai" value="Lưu Lại" class=" btn btn-success"  class="luulai"/>&nbsp;&nbsp;<input type="submit" name="lamlai" value="Làm Lại" class="btn btn-danger"  class="lamlai"/></div>
		<br>
		<br>
		<br>
		<br>
</form>

	
    	
        <!-- 
         <th> Chi Tiết Sản Phẩm</th>
        <textarea  class="form-control" rows="10" cols="30" name="chitiec">  </textarea></td>
        </tr>
        <tr>
        <th> Giá Sản Phẩm</th>
        <td> <input class="form-control" type="number"  name="gia"/> </td>
        </tr>
        <tr>
        <th> Hình Ảnh </th>
        <td> <input class="form-control"  type="text" name="anhsanpham" /> </td>
        </tr>
        <tr>
        <th> Loại Sản Phẩm </th> 
        <td> 
        <select name="loaisanpham" class="form-control">
            	<option value="1">Điện Thoại </option>
                <option value="2"> Laptop </option> 
            </select>
        </td> 
        
    
</form> -->
</div>
<div class="loi"> 
<?php if(!empty($errors)){
                echo "<ul>";
                foreach($errors as $error){
                    echo "<li> $error </li>";	
                }
                echo "<ul/>";
            }
        ?>


</div>
</body>
</html>