<?php
	include("connect.php");
	$ma=$_POST['MaTaiKhoan'];
	$hinh=$_POST['hinh'];
	$hinh=base64_encode($hinh);

	$sql="UPDATE taikhoan SET hinh='$hinh'  WHERE MaTaiKhoan = '$ma' ";
	if($con->query($sql))
	{
		echo "success";
		}
	else 
	{
		echo "error".mysqli_error($con);
		}
?>