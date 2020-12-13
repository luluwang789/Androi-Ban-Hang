<?php
$devicesToken="/topics/TopicName";
     if(isset($_POST['message'])&&isset($_POST['titlemessage'])){
        $messenger=$_POST['message'];
        $title=$_POST['titlemessage'];
        $data= [
            'title' => $title,
            'body' => $messenger,
        ];
        $messages = [
            'data' => $data,
            'to' => $devicesToken,
        ];
    
        $headers = [
            'Authorization: key=' . 'AAAAe6HcJXo:APA91bHQD5dPe4mVMKYFP-L-s7OMo5ktky6ucskxzT203qb-cGwCsy3isNgzwqVW_kaJT3244DU_TQCKFLTWuPb7Lr9UJHaC6EwOi-JZXXjRscwpQ52ZiG0q6eOKHu2_3y98R6ro9CS6',
            'Content-Type: application/json',
        ];
    
        $ch = curl_init();
        curl_setopt($ch, CURLOPT_URL, 'https://fcm.googleapis.com/fcm/send');
        curl_setopt($ch, CURLOPT_POST, true);
        curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
        curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
        curl_setopt($ch, CURLOPT_POSTFIELDS, json_encode($messages));
        //echo json_encode($messages);
        $result = curl_exec($ch);
        curl_close($ch);
    
        if ($result === FALSE) {
            throw new Exception('FCM Send Error: '  .  curl_error($ch), 500);
        }
     }
    else{
    }
   
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thông Báo</title>
    <!-- Link CSS -->
    <link rel="shortcut icon" type="image/png" href="favicon.png"/ >
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="font/font-awesome/css/all.min.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <style>
                    @font text-face{
                
                font text-family: Montserrat-Black;
                src: url("fonttext/Montserrat-Black.ttf");
            }
            @font text-face{
                
                font text-family: Montserrat-Light;
                src: url("fonttext/Montserrat-Light.ttf");
            }
            @font text-face{
                
                font text-family:Montserrat-Medium;
                src: url("fonttext/Montserrat-Medium.ttf");
            }
        body{
	
	
    }
    #bangthongbao{
        margin-top:100px;
        width: 600px;
        height: 280px;
        margin: auto;
        background-color: white;
        border-radius: 20px;

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
			 
		 </ul>
		 
	 </div>
	 </div>
 </nav>




<div id="bangthongbao">
    <form action="" method="POST" enctype="multipart/form-data" name="formthongbao" >
    <br>
    <br><br>
        <h1 style="margin-top:60px; margin-left: 220px;">Thông Báo</h1>
            <table class="m-auto"  class="form-group">
                <tr>
                <label for="">Tiêu Đề</label>
                   <input type="text" class="form-control"  name="titlemessage" style="margin-bottom: 20px;" >
                   
                </tr>
                <tr>
                    <br>
                    <label for="">Nội dung</label>
                    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="message"></textarea> 
                </tr>
            </table>
            <button class="btn btn-success " style="margin-top:30px; margin-left: 280px; width: 80px;">Gửi</button>


            
    </form>
</div>


    <!-- Link JS -->
    <script src="js/jquery-3.5.js"></script>
    <script src="js/jquery.min.js"></script>
    <script src="js/popper.min.js"></script> 
    <script src="js/bootstrap.min.js"></script>
  
</body>
</html>