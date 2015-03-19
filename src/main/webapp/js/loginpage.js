$(function(){
	$("#userId").change(function(){idchk();});
	$("#userPw").change(function(){pwchk();});
	$("#userPw").keydown(function(event){
		if(event.keyCode==13){
			$("#loginbtn").click();
		}
	});
	$("#loginbtn").click(function(){
		if(!idchk()){
			$("#userId").focus();
		}else if(!pwchk()){
			$("#userPw").focus();
		}else{
			var $objForm = $("form")[0];
			$objForm.method = "post";
			$objForm.action = "login.do";
			$objForm.submit();		
		}
	});
	$("#signupbtn").click(function(){
		location.href = "joinform.do";
	});	
});
function idchk(){
	if($("#userId").val().trim().length == 0){
		$("#err_id").attr("style","display:block");			
		return false;
	}else{
		$("#err_id").attr("style","display:none");		
		return true;
	}
}
function pwchk(){
	if($("#userPw").val().trim().length == 0){	
		$("#err_pwd").attr("style","display:block");		
		return false;
	}else{	
		$("#err_pwd").attr("style","display:none");
		return true;
	}
}