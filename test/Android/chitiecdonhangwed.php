
<!-- DONE -->
<?php
ob_start();
	if(!isset($_COOKIE['dangnhap']) &&  !isset($_COOKIE['matkhau'])){
		header("location:dangnhaptrenweb.php");
	}
	if(isset($_POST['dangxuat3'])){
		header("location:doanhthu.php");
	}
	$id=$_GET['id'];
	include("connect.php");
	$sql="SELECT s.tensanpham,s.giasanpham,s.hinhanhsanpham,c.soluongsanpham,c.tientungsanpham
		FROM chitiecdonhang c,sanpham s
		WHERE c.masanpham=s.id AND c.madonhang=".$id; 
	$select=$con->query($sql);
	if(isset($_POST['submitdate'])){
		echo "success";
	}

?>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Chi Tiết Đơn Hàng</title>
<link href="dinhdangdanhsachsanpham.css" type="text/css" rel="stylesheet" />
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
	
	background-color: #2c3e50;
	
}
img{
	width:150px;
	height:150px;	
}
div.noidung{
	position:relative;
	 background-color: white; 
	text-align:center;
	
	border-radius: 20px;
	
	margin: auto;
	margin-top:50px;
	margin-bottom: 50px;
	width:900px;
	height:auto;
	transition: 0.4s;	
	border:1px solid grey;
	
}
div.noidung:hover{
	box-shadow: 5px 5px 25px grey ;
	
}
div.tieude{
	padding:5px;
	border-bottom:1px solid grey;
	color: #564f4f;
	font-size:27px;
	
	font-family: Montserrat-Medium;
}

div.loinoi{
	
	font-size:20px;
	margin-left: 20px;
	padding:8px;
	font-family:Montserrat-Light;
}
table{
	margin:auto;
	width:800px;
	border-collapse:collapse;	
	
}
table tr td span{
	color: #cd201f;
	font-family: Montserrat-Medium;	
}
table tr th,td{
	border: 1px solid grey;	
}

table tr th{
	background-color: #df2029;
	padding: 10px;	
	font-family: Montserrat-Light;
	font-weight: 200;
	color: white;
}
table tr td{
	border:1px solid grey;
	background-color: white;
}
.dx{
	margin: 20px;
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
#date{
	margin-left:280px;	
	margin-top:50px;
}
a{
	text-decoration: none;
}
a:hover{
	
	color:white;
}
</style>
</head>

<body>
<form method="POST" action="" enctype="multipart/form-data" name="formdoanhthu">
	<div class="noidung">
    	
    	<div class="tieude"> Chào bạn <?php echo $_COOKIE['dangnhap'] ?></div>
        <div class="loinoi" > Danh Sách Sản Phẩm Trong Giỏ Hàng</div>
        
        <span id="danhsachsanphamcuausser">
    	<table> 
        <tr>
        	<th> STT</th>
            <th> Tên Sản Phẩm </th>
            <th> Giá Sản Phẩm</th>
			<th> Hình Ảnh </th>
			<th> Số Lượng</th>
            <th colspan="1"> Tổng Tiền</th>
            <th colspan="3"> Địa Chỉ</th>
			
        </tr>
        <?php 
			$i=1;
        	while($row =$select->fetch_assoc()){
			$price = $row['giasanpham'];
			$price = '<span>'. number_format($price ,0 ,'.' ,'.').'VNĐ' .'</span>';
			$tong = $row['tientungsanpham'];
			$tong = '<span>'. number_format($tong ,0 ,'.' ,'.').'VNĐ' .'</span>';
            	echo "<tr>";
				echo "<td> ".$i."</td>";
				echo "<td>  ".$row['tensanpham']."</td>";
				echo "<td> ".$price." </td>";
				echo "<td> <img src=".$row['hinhanhsanpham']."></td>";
				echo "<td>  ".$row['soluongsanpham']."</td>";
				echo "<td> ".$tong." </td>";
				echo "<td> ".$tong." </td>";
				echo "</tr>";
				$i=$i+1;
            }
		?>
        </table>
        </span>
        <input type="submit"  name="dangxuat3" value="Quay Lại" class="dx btn btn-success " /> 
        </form>
       
        
    </div>
	
   <span id="sanphamtrave"> </span>
   
    

</body>
</html>