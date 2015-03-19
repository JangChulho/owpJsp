<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width">
<title>투표하기</title>
<link rel="shortcut icon" href="img/codin_favicon.ico">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link type='text/css' rel='stylesheet' href="css/adminpage.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>		
<script type='text/javascript' src="js/adminpage.js"></script>
</head>
<body>
	<div class="container">
		<div class="clearfix">
			<div class="row">
				<div class="col-md-6 col-md-offset-3">					
					<div id = "header" >
						<a href = "/">
							<img class = "img-responsive" alt = "Responsive image" src = "img/codingcafelogo.png">
						</a>
					</div>
				</div>
			</div>
			<div class="row" id="bodyrow">				
				<div class="col-xs-10 col-md-2 col-xs-offset-1 col-md-offset-1" id="sideMenu">
					<a href="/">소개</a><br>					
					<a href="logout.do">로그아웃</a>									
				</div>
				<div class="col-xs-12 col-md-8" id="contents">
					<h1>현재투표인원</h1>
					<hr>
					<form role="form">					
						<div class="col-xs-12 col-md-6 votemember1">																	
						</div>
						<div class="col-xs-12 col-md-6 votemember2">																						
						</div>
					</form>
					<div class="col-xs-12 col-md-6 col-md-offset-3">
						<button type="button" class="btn btn-primary btn-lg" id="votecancelbtn" disabled>투표취소하기</button>
					</div>					
				</div>
			</div>					
		</div>
	</div>
	<div class="sessionid" style="display:none">${sessionScope.loginInfo.id}</div>
</body>
</html>