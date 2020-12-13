<html>
<head>
	<title>Đăng Nhập</title>
<link rel="stylesheet" href="dinhdangdangnhap.css" type="text/css" />
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="shortcut icon" type="image/png" href="favicon.png"/ >
<script src="js/jquery.min.js"></script>
    <script src="js/popper.min.js"></script> 
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
body{
	background-color: #2c3e50;
}
div.noidung{
	
	padding: 0px;
	text-align:center;
	border:1px solid grey;
	border-radius: 10px;
	width:500px;
	height:280px;
	margin-top:120px !important; 	
	
	background-color: white;
	margin: auto;
}

div table tr th,td{
	font-weight:bold;
	font-size:15px;
	font-family: Montserrat-Light;
	text-align: center;
}
 table tr.fix td{
	 height: 70px;
	margin: 20px 0px !important;
}
div h3{
	margin:-1px 0px 0px -1px;
	width:500px;
	border-top-left-radius: 10px;
	border-top-right-radius: 10px;
	text-align:center;
	color: white;
	border-bottom:1px solid grey;
	font-family:Montserrat-Light;
	padding: 10px 0px !important;
	background-color: #df2029;
}
.dangnhap{
	font-weight:bold;
	width:80px;
	height:30px;
	margin-left:50px;
	margin-top:10px;	
}

#loi{
	text-align:center;
	width:300px;
	margin-left:500px;	
}
ul li{
	color:#F00;
	font-size:20px;
	list-style:none;	
}
.dangnhap{
	cursor:pointer;	
}
.dangnhap{
	font-size:17px;
	font-weight:bold;
	border-radius:10px;
	border:grey solid 1px;
	background-color:lightgreen;
	height:30px;
	width:100px;
}
.dangnhap:hover{
	color:yellow;
	background-color:#fff;
}
input.form-control{
	width: 300px !important;
}
input.btn{position: relative;
	left: 180px;
	margin-top: 30px;
}

</style>

</head>

<body>
 <script type="text/javascript">
function KiemTraDangNhap(){
	var f=document.formdangnhap;
	if(f.submit.value != ""){
		if(document.formdangnhap.dangnhap.value== ""){
			alert("Bạn chưa nhập tài khoản");
			document.formdangnhap.focus();
			return false;
		}
		if(document.formdangnhap.matkhau.value==""){
			alert("Bạn chưa nhập Mật Khâu");
			return false;
		}
		if(document.formdangnhap.dangnhap.value!="" && document.formdangnhap.matkhau.value!=""){
			<?php
					if(isset($_POST['submit'])){
					$errors=array();
					setcookie('dangnhap',$_POST['dangnhap'],time()+3600);
					setcookie('matkhau',$_POST['matkhau'],time()+3600);
					include("connect.php");
					$dangnhap=mysqli_real_escape_string($con,$_POST['dangnhap']);
					$matkhau=mysqli_real_escape_string($con,$_POST['matkhau']);	
					$matkhau=md5($matkhau);
					$query="SELECT * FROM taikhoan WHERE (SDT='$dangnhap' OR Email='$dangnhap') AND MatKhau='$matkhau' LIMIT 1";
					$result=$con->query($query);
					$row=$result->fetch_array();
					if(mysqli_num_rows($result) == 1 && $row['MaLoaiTK']==1){
						header('location: trangchu.php');
					}else {
						$errors[]="The account or password do not match those on file";	
						}
					}
			?>
			
			return true;
		}
	}
		return true;
}
function chuyendangki(){
	<?php
	if(isset($_POST['dangky'])){
	header('location: maxacnhan.php');
		}
	?>
}
</script>

<nav class="navbar navbar-expand-sm navbar-light bg-light">
    <div class="container">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId" aria-controls="collapsibleNavId"
        aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavId">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Link</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="dropdownId" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</a>
                <div class="dropdown-menu" aria-labelledby="dropdownId">
                    <a class="dropdown-item" href="#">Action 1</a>
                    <a class="dropdown-item" href="#">Action 2</a>
                </div>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="text" placeholder="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
    </div>
</nav>
<div class="noidung">
	<form action="" method="post" enctype="multipart/form-data" name="formdangnhap">
	<table>	
    	<tr>
        	<th colspan="2"><h3> Login</h3> </th>
        </tr>
    	<tr class="fix">
    	<td >Tên Đăng Nhập  </td>
           <td><input class="form-control " type="text" name="dangnhap" /></td>
           </tr>
         <tr class="fix">
          <td ><br/>Mật Khẩu </td>
         <td> <br/><input  class="form-control"type="password" name="matkhau" /></td>
         </tr>
         <tr>
         <td> <input type="submit" class="btn btn-primary " name="submit" value="Đăng Nhập" class="dangnhap" onClick="return KiemTraDangNhap()"/></td>
        <!-- <td> <input type="submit" class="btn btn-outline-primary"  name="dangky" value="Đăng Ký" id="dangki" onClick="return chuyendangki()"/> </td>  -->
         </tr>
    </table>
    </form>
  </div>
 <div id="loi">
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
