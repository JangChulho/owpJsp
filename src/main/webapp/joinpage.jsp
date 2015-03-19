<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width">
<title>회원가입</title>
<link rel="shortcut icon" href="img/codin_favicon.ico">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link type='text/css' rel='stylesheet' href = "css/joinpage.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>		
<script type='text/javascript' src="js/joinpage.js"></script>
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
							<input type="text" class="form-control input-lg" id="userId" name="userId" placeholder="아이디" maxlength="20">
							<span style = "display : none;" class="glyphicon glyphicon-ok form-control-feedback"></span>							   
						</div>													
						<div id = "err_input_id" class = "error" style = "display : none;">아이디를 입력하세요.</div>
						<div id = "err_id_reg" class = "error" style = "display : none;">아이디는 영문 소문자 또는 숫자만 가능합니다.</div>
						<div id = "err_id_dup" class = "error" style = "display : none;">이미 존재하는 아이디입니다.</div>
						
						<div class = "form-group" id="pwgroup">
							<label for="inputPassword1" class="sr-only">PASSWORD1</label>
							<input type="password" class="form-control input-lg" id="userPw" name="userPw" placeholder="비밀번호" maxlength="20">								
						</div>
						<div id = "err_input_pw1" class = "error" style = "display : none;">비밀번호를 입력하세요.</div>
						<div id = "err_input_pw2" class = "error" style = "display : none;">비밀번호를 3자리 이상 입력하세요.</div>
						<div id = "err_pw_reg" class = "error" style = "display : none;">비밀번호는 영문 소문자 또는 숫자만 가능합니다.</div>
						
						<div class = "form-group" id="pwchkgroup">
							<label for="inputPassword2" class="sr-only">PASSWORD2</label>
							<input type="password" class="form-control input-lg" id="userPwCheck" name="userPwCheck" placeholder="비밀번호확인" maxlength="20">
						</div>				
						<div id = "err_input_pwCheck1" class = "error" style = "display : none;">비밀번호를 한 번 더 입력하세요.</div>
						<div id = "err_input_pwCheck2" class = "error" style = "display : none;">비밀번호가 일치하지 않습니다.</div>
						
						<div class = "form-group" id="namegroup">
							<label for="inputName" class="sr-only">NAME</label>
							<input type="text" class="form-control input-lg" id="userName" name="userName" placeholder="이름" maxlength="20">
						</div>	    			
						<div id = "err_input_name" class = "error" style = "display : none;"> 이름을 입력하세요.</div>			
						<div id = "err_name_reg" class = "error" style = "display : none;">이름은 영어 또는 한글만 가능합니다.</div>
						
						<div class = "form-group" id="phonegroup">
							<label for="inputPhone" class="sr-only">PHONE</label>
							<input type="tel" class="form-control input-lg" id="userPhoneNumber" name="userPhoneNumber" placeholder="연락처" maxlength="13">				    				
						</div>
						<div id = "err_input_phoneNumber" class = "error" style = "display : none;">연락처를 입력하세요.</div>
						<div id = "err_phone_reg" class = "error" style = "display : none;">연락처는 01로 시작하며 10자리 또는 11자리만 가능합니다.</div>
						
						<div class = "form-group" id="gendergroup">			
							<div class="btn-group" data-toggle="buttons">
								<label class="btn btn-default btn-lg">
									<input type="radio" name="userSex" value="M">남					
								</label>
								<label class="btn btn-default btn-lg">
									<input type="radio" name="userSex" value="F">여					
								</label>
							</div>
						</div>						
						<div id = "err_input_sex" class = "error" style = "display : none;">성별을 선택해주세요.</div>
						
						<div class = "form-group">
							<div class = "btndiv">				
								<button type = "button" class="btn btn-primary btn-lg" id="joinbtn">가입</button>
								<button type = "button" class="btn btn-primary btn-lg" id="cancelbtn">취소</button>
							</div>								
						</div>					
					</form>	
				</div>
			</div>
		</div>
	</div>	
</body>
</html>