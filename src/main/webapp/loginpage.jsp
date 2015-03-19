<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width">
<title>로그인</title>
<link rel="shortcut icon" href="img/codin_favicon.ico">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link type='text/css' rel='stylesheet' href="css/loginpage.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>		
<script charset="euc-kr" type='text/javascript' src="js/loginpage.js"></script>
</head>
<body>
	<div class="container">
		<div class="clearfix">
			<div class="row">
				<div class="col-md-6 col-md-offset-3 ">
					<div id = "header" >
						<a href = "/">
							<img id = "header_img" class = "img-responsive" alt = "Responsive image" src = "img/codingcafelogo.png">
						</a>
					</div>		
					<form role="form" autocomplete="off">
						<div class="form-group" id="idgroup">
							<label for="inputId" class="sr-only">ID</label>
							<input type="text" class="form-control input-lg" id="userId" name="userId" placeholder="아이디">											   
						</div>			
						<div id="err_id" class="error" style="display:none;">아이디를 입력해주세요.</div>
						
						<div class="form-group" id="pwgroup">
							<label for="inputPassword" class="sr-only">PASSWORD</label>
							<input type="password" class="form-control input-lg" id="userPw" name="userPw" placeholder="비밀번호">								
						</div>			
						<div id="err_pwd" class="error" style="display:none;">비밀번호를 입력해주세요.</div>
						
						<div class="form-group">
							<div class = "btndiv">				
								<button type = "button" class="btn btn-primary btn-lg" id="loginbtn">로그인</button>
								<button type = "button" class="btn btn-primary btn-lg" id="signupbtn">회원가입</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>	
</body>
</html>