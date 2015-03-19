<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width">
<title>Message</title>
<link rel="shortcut icon" href="img/codin_favicon.ico">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script>
$(function(){
	var msg = "${requestScope.message}";
	
	if(msg.indexOf("관리자님 반갑습니다.") != -1){
		$(".modal-title").html('<span class="glyphicon glyphicon-ok"></span> Success');
		$(".modal-body").html('<h4>'+msg+'</h4>');
		$('#myModal').modal();
		$(".complete").click(function(){
			location.href="admin.do";
		});	
	}else if(msg.indexOf("환영합니다.") != -1){
		$(".modal-title").html('<span class="glyphicon glyphicon-ok"></span> Success');
		$(".modal-body").html('<h4>'+msg+'</h4>');
		$('#myModal').modal();
		$(".complete").click(function(){
			location.href="votedupcheck.do";
		});	
	}else if(msg.indexOf("Codin9Cafe에 가입해 주셔서 감사합니다.") != -1){
		$(".modal-title").html('<span class="glyphicon glyphicon-ok"></span> Success');
		$(".modal-body").html('<h4>'+msg+'</h4>');
		$('#myModal').modal();
		$(".complete").click(function(){
			location.href="loginform.do";
		});		
	}else if(msg.indexOf("투표가 완료되었습니다.") != -1){
		$(".modal-title").html('<span class="glyphicon glyphicon-ok"></span> Success');
		$(".modal-body").html('<h4>'+msg+'</h4>');
		$('#myModal').modal();
		$(".complete").click(function(){
			location.href="votedupcheck.do";
		});	
	}else if(msg.indexOf("투표가 취소되었습니다.") != -1){
		$(".modal-title").html('<span class="glyphicon glyphicon-ok"></span> Success');
		$(".modal-body").html('<h4>'+msg+'</h4>');
		$('#myModal').modal();
		$(".complete").click(function(){
			location.href="admin.do";
		});	
	}else{
		$(".modal-title").html('<span class="glyphicon glyphicon-ban-circle" style="color:red"></span> Error Message');
		$(".modal-body").html('<h4>'+msg+'</h4>');
		$('#myModal').modal();
		$(".complete").click(function(){
			history.back();
		});
	}
});
</script>
<style>
body{
	font-family: "맑은 고딕","돋움",dotum,arial,sans-serif;
}
.glyphicon{
	color: green;
	font-size: 15pt;
}
</style>
</head>
<body>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">        
        <h3 class="modal-title"></h3>
      </div>
      <div class="modal-body">        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default complete">확인</button>        
      </div>
    </div>
  </div>
</div>
</body>
</html>