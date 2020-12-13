<?php
ob_start();
	if(!isset($_COOKIE['dangnhap']) &&  !isset($_COOKIE['matkhau'])){
		header("location:index.php");
	}
	if(isset($_POST['dangxuat3'])){
		header("location:trangchu.php");
	}
	include("connect.php");
	$sql="SELECT d.id,t.ho,t.ten,d.NgayThanhToan,d.TONGTIEN
		FROM donhang d,taikhoan t
		WHERE d.idkhachhang=t.MaTaiKhoan";
		
	$select=$con->query($sql);
?>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Doanh Thu</title>
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


img{
	width:50px;
	height:50px;	
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
	margin: auto;
	width:800px;
	border-collapse:collapse;	
}
table tr th,td{
	border: 1px solid grey;	
	padding: 10px 0px;
}
table tr th{
	background-color:#bbbbbb;	
}
table tr td{
	border: 1px solid grey;
	background-color:white;
	font-size: 15px;
}
table tr td span{
	color: #cd201f;
	font-family: Montserrat-Medium;	
}

table.bangchitiec{
		border-collapse:collapse;
		border:1px solid grey;
		margin-top:50px;
		margin-left:150px;
		width:1000px;
		height:120px;
		background-color:#9F0;
}
table tr th{
	background-color: #df2029;
	padding: 10px;	
	font-family: Montserrat-Light;
	font-weight: 200;
	color: white;
}

table.bangchitiec tr th,td{
	font-size:23px;
	text-align:center;
	border:1px solid black;	
}
#hinhanhchitiecsanphamcuanguoidung{
		display:none;
		margin-top:100px;
		position:fixed;
		height:170px;
		width:180px;
		
}
.timkiem{
	margin-left:480px;	
	font-weight:bold;
	font-size:25px;
}
#timkiemsanpham{
	height:30px;
	border-radius:20px;
	
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
#date{
	width: 900px;
	margin-left: 370px;
	margin-top: 70px;
	margin-bottom: 30px;
}
a{
	text-decoration: none;
	transition: 0.4s;
	color: black;
}
a:hover{
	
	color: red;
	
}
h1{
	font-weight:bold;
	color:yellow;
	margin-top:50px;
	font-size:40px;
	margin-left:320px;
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
			 	<a class="nav-link" href="thongbao.php" > Thông Báo </a>
			 </li>
		 </ul>
		 
	 </div>
	 </div>
 </nav>
<form method="POST" action="" enctype="multipart/form-data" name="formdoanhthu">
	<div id="date" class="">
	<span style="font-family: Montserrat-Light;color: white; ;font-size:20px;"> Từ</span> &nbsp;&nbsp;&nbsp;&nbsp;<input type="date" name="fromdate"> &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; 
    <input type="submit" name="submitdate" onclick="return kiemtradate()" value="Thống Kê" class=" btn btn-danger">
	&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp
    <span style="font-family: Montserrat-Light;color: white; ;font-size:20px;"> Đến &nbsp;&nbsp;&nbsp </span><input type="date" name="totime">
    </div>
	<div class="noidung">
    	
    	<div class="tieude"> Chào bạn  <?php echo $_COOKIE['dangnhap'] ?></div>
        <div class="loinoi" > Danh Sách Khách Hàng Mua Hàng</div>
        
        
        <span id="danhsachsanphamcuausser">
    	<table> 
        <tr>
        	<th> STT</th>
            <th> Khách Hàng </th>
            <th> Ngày Thanh Toán</th>
			<th> Giá Sản Phẩm </th>
            <th colspan="3">  Chi Tiết Hóa Đơn</th>
        </tr>
        <?php 
			$i=1;
			$delete="avatar/delete.png";
			$edit="avatar/edit.png";
			$tongtien=0;
        	while($row =$select->fetch_assoc()){
			$price = $row['TONGTIEN'];
			$tongtien+=$price;
			$price = '<span>'. number_format($price ,0 ,'.' ,'.').'VNĐ' .'</span>';
            	echo "<tr>";
				echo "<td> ".$i."</td>";
				echo "<td>  ".$row['ho']."  ".$row['ten']."</td>";
				echo "<td> ".$row['NgayThanhToan']."</td>";
				echo "<td> ".$price." </td>";
				echo "<td> <a href='chitiecdonhangwed.php?id=".$row['id']."'> Chi Tiết</a></td>";
				echo "</tr>";
				$i=$i+1;
            }
		?>
        </table>
        </span>
        <input type="submit" name="dangxuat3" value=" Trang Chủ" class="dx btn btn-success my-4" /> 
        </form>
       
        
    </div>
   <span id="sanphamtrave"> </span>
    <h1 style=" font-family: Montserrat-Light;
				font-size: 18px;
				color: white;
				text-align: center;
	 " class=" my-5">Tổng Doanh Thu :  <?php  
					$tongtien = '<span>'. number_format($tongtien ,0 ,'.' ,'.').'VNĐ' .'</span>';
					echo  $tongtien 
					?> </h1>
<script type="text/jscript">
	var xhttp;
	var ok=true;
	var f=document.formdoanhthu;
function kiemtradate(){
		if(f.fromdate.value== "" || f.totime.value == "" ){
			window.alert("Bạn Vui lòng Chọn Ngày Trước Khi Thống Kê");
			ok= false;
			
		}if(f.fromdate.value!= "" && f.totime.value != ""){
				if(f.fromdate.value  >  f.totime.value  ){
				window.alert("Ngày Thống Kê Không Hợp Lệ");
				ok= false;
				}else{
					if(window.XMLHttpRequest){
						xhttp = new XMLHttpRequest();
						ok=false;
					}else{
						xhttp= new ActiveXObject("Microsoft.XMLHTTP");
						ok=false;
					}
				xhttp.onreadystatechange = function() {
					if (this.readyState == 4 && this.status == 200) {
						document.getElementById("danhsachsanphamcuausser").innerHTML=this.responseText;
					ok=false;
			
					}
				};
				xhttp.open("GET","donhang.php?from="+f.fromdate.value+","+f.totime.value,true);
				
				xhttp.send();
				return ok;	
				}
		}
		return ok;
		
	}
</script>

</body>
</html>