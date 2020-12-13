<?php
ob_start();
	if(!isset($_COOKIE['dangnhap']) &&  !isset($_COOKIE['matkhau'])){
		header("location:index.php");
	}
	if(isset($_POST['back'])){
		setcookie('dangnhap',$_POST['dangnhap'],time()-3600);
		setcookie('matkhau',$_POST['matkhau'],time()-3600);
		if(headers_sent()){
					die('<script type="text/javascript">window.location.href="'."dangnhap.php".'"</script>'); 
				}else{
					header("location:index.php");
					die();
					
				}
	}
	include("connect.php");
	$sql="SELECT * FROM sanpham ";
	$select=$con->query($sql);
	//if(isset($_GET['id'])){
	//	$id=$_GET['id'];
	//	$delete="DELETE FROM sanpham Where idsp='$idsp'";
	//	$con->query($delete);
	//}
	if(isset($_POST['trangchu'])){
		header("location:trangchu.php");
	}
	

?>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Danh Sách Sản Phẩm</title>
<!-- <link href="dinhdangdanhsachsanpham.css" type="text/css" rel="stylesheet" /> -->
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




#trove{
	position:absolute;
	left: 2%;
	top: 15%;
}
#trangchu{
	position:absolute;
	left: 2%;
	top: 5%;

}

img{
	width:150px;
	height:150px;	
}
.sp{
	background-color:#FFF;
	padding: 20px; 
	border-radius: 50px;
	border: 2px solid #73AD21;
	width:150px;
	margin-left:50px;
	margin-top:50px;
	height:230px;
	float:left;
	text-align:center;
	list-style-type:none;	
}

div.tieude{
	padding:5px;
	
	color: black ;
	font-size:27px;
		
	font-family: Montserrat-Medium;
}
div.loinoi{
	margin-left:30px;
	font-size:20px;
	padding:8px;
}

.dx{
	cursor:pointer;
	margin:12px;
	background-color:#a9a9a9;
	height:45px;
	color:#FFF;
	box-shadow: 3px 1px 8px 8px #FFF;
}
#hinhanhchitiecsanphamcuanguoidung{
		display:none;
		margin-top:100px;
		position:fixed;
		height:170px;
		width:180px;
		
}
.timkiem{
		
	color: white;
	font-family: Montserrat-Light;
	font-size:25px;
}
#timkiemsanpham{
	
	
	width: 200px;
	
}
#danhsachlietke{
	position:absolute;
	z-index:2;
}
span ul li{
	border-radius:20px;
	text-align:center;
	border:1px solid #ce9e6d; 
	width:200px;
	height:auto;
	background:#FFF;
	font-size:20px;
	font-family:"Times New Roman", Times, serif;
	margin-left:-220px;
	width:200px;
	list-style-type:none;

}
span ul li:hover{
	cursor:pointer;
	background:#e4c3a0;
}
#sanphamtrave{

	position:absolute;
}
div.noidung{
	
	margin-top:100px;	
	margin-left:50px;
}
#delete1{
	float:right;
	
}
#anhx{
	height:20px;
	width:20px;	
	
}
#delete1{
	position: relative;
	top: -7%;
	right: -7%;
}

#d{
	position:absolute;

}
#loaisp{
	margin-top:30px;
	position:absolute;
	margin-left:600px;
	
}

.sp{
	width: 200px;
	height: 300px;
	border: 1px solid grey;
	border-radius: 10px;
	transition: 0.4s;
}
.sp img.img-fluid{
	border: 1px solid grey;
	padding: 10px;
	border-radius: 10px;
}
.sp:hover{
	box-shadow: 1px 1px 5px gray;
	background: white;

}
.noidung{
	margin-left: 120px !important;
}
#loaisp input{
	color: white;
}
div.tieude{
	padding:0px;
	width:500px;
	height:60px;
	text-align:center;
	margin:auto;
	font-family:Montserrat-Light;
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
			 
			 <li class="nav-item dropdown">
				 <a class="nav-link dropdown-toggle" href="#" id="dropdownId" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">DS Sản Phẩm</a>
				 <div class="dropdown-menu" aria-labelledby="dropdownId">
				 <a class="dropdown-item" href="#" id="lt" onclick="return loaisanpham(3)">Tất Cả</a>
					 <a class="dropdown-item" href="#" id="dt" onclick="return loaisanpham(1)">Điện Thoại</a>
					 <a class="dropdown-item" href="#" id="lt" onclick="return loaisanpham(2)">LapTop</a>
					
					
				 </div>
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
		 <form class="form-inline my-2 my-lg-0 timkiem">
			 <input class="form-control mr-sm-2" type="text" placeholder="Search"  id="timkiemsanpham" onkeyup="lietke(this.value)">
			 <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Search &nbsp;&nbsp;</button>
		 </form>
		 
	 </div>
	 </div>
 </nav>

 <div class="tieude" >
	 <br>
	 
	<h3> Danh Sách Sản Phẩm</h3>
</div>


	<img src="go.jpg" class="idanhsanpham" id="hinhanhchitiecsanphamcuanguoidung"/>
	<div class="noidung" id="noidung">
		<?php 
			$i=1;
			$delete="avatar/delete1.png";
			$edit="avatar/edit.png";
			while($row =$select->fetch_assoc()){
				echo "<ul class='sp'>";
				echo "<li id='delete1'><a href=xoa.php?id=".$row['id']."> <img id='anhx'src=".$delete."> </a></li>";
				echo "<li><a href=sua.php?s=".$row['id']."><img class='img-fluid' src=".$row['hinhanhsanpham']."></a></li>";
				echo "<li style='color:#0077b5; font-family: Montserrat-Medium; font-size: 15px;'>".$row['tensanpham']."</li>";
				echo "<li style=' font-family: Montserrat-Medium; font-size: 15px;'> Giá : ".$row['giasanpham']."VND"."</li>";
				
				echo "</ul>";
				$i=$i+1;
			}
		?>
		</div>
		
<span id="sanphamtrave"> </span>
<script type="text/jscript">
	var xhttp;
	var ok=true;
	
function chitieccuasanpham(str){
	if(window.XMLHttpRequest){
		xhttp = new XMLHttpRequest();
		ok=false;
	}else{
		xhttp= new ActiveXObject("Microsoft.XMLHTTP");
		ok=false;
	}
	xhttp.onreadystatechange = function() {
		 if (this.readyState == 4 && this.status == 200) {
			 document.getElementById("sanphamtrave").innerHTML=this.responseText;
			 ok=false;
		
		 }
	};
	xhttp.open("GET","chitiec.php?ct="+str,true);
	xhttp.send();
	return ok;
	
}
var xt;
var hinhanh;
function hienhinh(ten){
	if(window.XMLHttpRequest){
		xt = new XMLHttpRequest();
	}else{
		xt= new ActiveXObject("Microsoft.XMLHTTP");
	}
	xt.onreadystatechange = function() {
		 if (this.readyState == 4 && this.status == 200) {
			hinhanh=this.responseText;
			document.getElementById("hinhanhchitiecsanphamcuanguoidung").setAttribute("src",hinhanh);
			document.getElementById("hinhanhchitiecsanphamcuanguoidung").style.display="block";
		
		 }
	};
	xt.open("GET","layanh.php?ctspa="+ten,true);
	xt.send();
	
}
function xoa(){
		hinhanh="";
		document.getElementById("hinhanhchitiecsanphamcuanguoidung").style.display="none";
}
var ko1=true;
var kn;
function lietke(t){
	if(window.XMLHttpRequest){
		kn = new XMLHttpRequest();
		ko1=false;
	}else{
		kn= new ActiveXObject("Microsoft.XMLHTTP");
		ko1=false;
	}
	kn.onreadystatechange = function() {
		 if (this.readyState == 4 && this.status == 200) {
			document.getElementById("noidung").innerHTML=this.responseText;
			 ko1=false;
		
		 }
	};
	kn.open("GET","danhsachlietke.php?ten="+t,true);
	kn.send();
	return ko1;
	
}
function loaisanpham(t){
	if(window.XMLHttpRequest){
		kn = new XMLHttpRequest();
		ko1=false;
	}else{
		kn= new ActiveXObject("Microsoft.XMLHTTP");
		ko1=false;
	}
	kn.onreadystatechange = function() {
		 if (this.readyState == 4 && this.status == 200) {
			document.getElementById("noidung").innerHTML=this.responseText;
			 ko1=false;
		
		 }
	};
	kn.open("GET","danhsachlietketheoloai.php?ten="+t,true);
	kn.send();
	return ko1;
}

</script>


</form>
</body>
</html>