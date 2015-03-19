<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE htmle>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width">
<title>Codin9Cafe</title>
<link rel="shortcut icon" href="img/codin_favicon.ico">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link type='text/css' rel='stylesheet' href="css/homepage.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script>
$(function(){
	var id = "${sessionScope.loginInfo}";
	if(id!=""){
		$(".logout").attr("style", "display:block");
	}
});
</script>
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
					<a href="loginCheck.do">투표하기</a><br>
					<a href="logout.do" class="logout" style="display:none">로그아웃</a>								
				</div>
				<div class="col-xs-12 col-md-8" id="contents">
					<h1>Codin9Cafe</h1>
					<hr>
					<h3>코딩 배우면 취업되나요?</h3>
					<p>
						:)<br>
						2015년 코딩에 도전하세요!<br>
						코딩까페와 함께 하면 누구나 코딩을 할 수 있습니다.
					</p>
					<h3>코딩까페는 오픈코스로 코딩을 배우고 오픈소스로 코딩을 익히는 모임입니다.</h3>
					<p>
						오픈코스는 열린강의입니다.<br>
						오픈코스를 이용하면 누구나 대학강의나 전문분야의 강의를 무료로 들을 수 있습니다.					
					</p>
					<h2>※ 모임</h2>
						<ul>
							<li>장소 : 충남대 앞 북스앤빈스</li>
							<li>시간 : 3/18(수) 저녁 7시</li>
							<li>문의 : 010-3440-8535<br>(문의는 문자로 부탁드립니다.)</li>
							<li>facebook group: <a href="https://www.facebook.com/groups/codin9cafe">Codin9Cafe</a></li>
						</ul>
				</div>
			</div>					
		</div>
	</div>
</body>
</html>