<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width">
<title>투표</title>
<link rel="shortcut icon" href="img/codin_favicon.ico">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link type='text/css' rel='stylesheet' href="css/voteinfopage.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>		
<script charset="euc-kr" type='text/javascript' src="js/voteinfopage.js"></script>
</head>
<body>
	<div class="container">
		<div class="clearfix">
			<div class="row">
				<div class="col-md-6 col-md-offset-3">					
					<div id = "header" >
						<a href = "/">
							<img id = "header_img" class = "img-responsive" alt = "Responsive image" src = "img/codingcafelogo.png">
						</a>
					</div>
				</div>
			</div>
			<div class="row" id="bodyrow">				
				<div class="col-xs-10 col-md-2 col-xs-offset-1 col-md-offset-1" id="sideMenu">
					<a href="/">소개</a><br>
					<a href="loginCheck.do">투표하기</a>									
				</div>
				<div class="col-xs-12 col-md-8" id="contents">
					<h1>Best Speaker</h1>
					<hr>					
					<p>
					코딩카페에서 주로하는 발표는 테크세미나와 오픈 코스 소개가 있습니다.
					오픈 코스는 MOOC 사이트에서 각자 듣고 싶은 강의를 선택한 후,			
					코스별 주요 내용 및 앞으로의 공부 일정을 발표하는 것이고,		
					테크 세미나는 자기가 정한 오픈 코스대로 매주 공부한 내용을 다른 사람들과 공유하기 위한 발표입니다.					
					이를 통해 종합적인 스피치 능력 향상 및 발표 능력을 높일 수 있을 뿐 아니라,
					매주 베스트 스피커를 선정하여 멤버들 간의 목표 의식을 고취시킬 수 있습니다.<br>				
					(베스트 스피커에게는 소정의 상품이 주어집니다.)
					</p>
					<div class="col-md-6 col-md-offset-3">
						<button type="button" class="btn btn-primary btn-lg" id="votebtn">투표하러가기</button>
					</div>
				</div>
			</div>				
		</div>
	</div>	
</body>
</html>