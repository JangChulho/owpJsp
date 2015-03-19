<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width">
<title>투표시간안내</title>
<link rel="shortcut icon" href="img/codin_favicon.ico">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link type='text/css' rel='stylesheet' href="css/nextvotetime.css">
<link rel="stylesheet" href="css/jquery.countdown.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="js/jquery.countdown.js"></script>
<script>
$(function(){	
	var note = $('#note'),
		ts = parseInt($('#sec').html()),
		tds = parseInt($('#todaysec').html());
	
	$('#countdown').countdown({
		timestamp	: ts,
		today		: tds,
		callback	: function(days, hours, minutes, seconds){
			
			var message = "";
						
			message += days + " 일 ";
			message += hours + " 시간 ";
			message += minutes + " 분 ";
			message += seconds + " 초"+" <br />";			
			message += "투표는 매주 수요일에 실시합니다.";			
						
			note.html(message);
		}
	});
	$("#votebtn").click(function(){
		location.href = "/";		
	});
});
</script>        
</head>
<body>
	<div class="container">
		<div class="clearfix">
			<div class="row">
				<div class="col-md-6 col-md-offset-3">					
					<div id = "header" >
						<a href = "homepage.jsp">
							<img id = "header_img" class = "img-responsive" alt = "Responsive image" src = "img/codingcafelogo.png">
						</a>
					</div>													
				</div>
			</div>
			<div class="row" id="bodyrow">				
				<div class="col-xs-10 col-md-2 col-xs-offset-1 col-md-offset-1" id="sideMenu">
					<a href="homepage.jsp">소개</a><br>
					<a href="loginCheck.do">투표하기</a><br>
					<a href="logout.do">로그아웃</a>									
				</div>
				<div class="col-xs-12 col-md-8" id="contents">
					<h1>투표시간안내</h1>
					<hr>
					<div id="countdown"></div>
					<p id="note"></p>
					<div class="col-md-6 col-md-offset-3">
						<button type="button" class="btn btn-primary btn-lg" id="votebtn">확인</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="sec" style="display:none">${requestScope.sec}</div>
	<div id="todaysec" style="display:none">${requestScope.todaysec}</div>
</body>
</html>