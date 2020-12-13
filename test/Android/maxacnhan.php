<?php
$errors="";
	if(isset($_POST['sub'])){
		$xnhan=md5($_POST['pass']);
		
		$query="SELECT * FROM taikhoan WHERE SDT='0943597722' AND MatKhau='$xnhan' LIMIT 1";
		include("connect.php");
		$result=$con->query($query);
		$row=$result->fetch_array();
		if(mysqli_num_rows($result)==1){
				header('location: dangkitrenweb.php');
			}else {
		$errors="Mã Xác Nhận Không Hợp Lệ";	
		}
	}
?>
<html>
<title>Mã Xác Nhận</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery.min.js"></script>
    <script src="js/popper.min.js"></script> 
	<script src="js/bootstrap.min.js"></script>
	<link rel="shortcut icon" type="image/png" href="favicon.png"/ >
</html>
<style>
body{
	background-color:#2c3e50;
	
}
p{
	font-size:20px;
	font-weight:bold;
}
form{
	border-radius:20px;
	background-color:white;
	width:400px;
	height:220px;
	margin:50px auto;
	text-align:center;
}
.form-control{
	width: 200px;margin:auto;
}
</style>
<head>
</head>

<body>
<form action="" method="POST">
<p>Mã Xác Nhận<br></p>
<input type="password" class="form-control" name="pass"> <br>
<p><input type="submit" class=" btn btn-success" name="sub" value="Xác Nhận" id="sub"> </p>
<span style="color:red"> <?php  echo "$errors" ?></span>
</form>
</body>