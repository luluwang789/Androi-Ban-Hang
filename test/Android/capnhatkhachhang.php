<?php
	include("connect.php");
	$ma=$_POST['MaTaiKhoan'];
    $diachi=$_POST['diachi'];
    $ho=$_POST['ho'];
    $ten=$_POST['ten'];
    $email=$_POST['email'];
    $diachi=$_POST['diachi'];
    $sdt=$_POST['sdt'];
	$sql="UPDATE taikhoan SET Ho='$ho', Ten='$ten', Email='$email',SDT='$sdt', diachi='$diachi'  WHERE MaTaiKhoan = '$ma' ";
	if($con->query($sql))
	{
		echo "success";
		}
	else 
	{
		echo "error";
	}
?>