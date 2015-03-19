$(function(){	
	$("#userId").change(function(){idchk();});
	$("#userPw").change(function(){pwchk();});
	$("#userPwCheck").change(function(){pwcchk();});
	$("#userName").change(function(){namechk();});
	$("#userPhoneNumber").change(function(){phonechk();});
	$("#userPhoneNumber").keyup(function(){
		var phonenum = $("#userPhoneNumber").val();
		$("#userPhoneNumber").val(autoHypenPhone(phonenum));
	});
	
	$("#joinbtn").click(function(){
		if(!idchk()){
			$("#userId").focus();
		}else if(!pwchk()){
			$("#userPw").focus();
		}else if(!pwcchk()){
			$("#userPwCheck").focus();
		}else if(!namechk()){
			$("#userName").focus();
		}else if(!phonechk()){
			$("#userPhoneNumber").focus();
		}else if(!genderchk()){
			genderchk();
		}else{
			var $objForm = $("form")[0];
			$objForm.method = "post";
			$objForm.action = "signup.do";
			$objForm.submit();
		}
	});
	
	$("#cancelbtn").click(function(){
		location.href = "loginform.do";
	});
});
function idchk(){
	var reg = /^[a-z0-9]*$/;
	if($("#userId").val().trim().length != 0){
		if(!reg.test($("#userId").val())){
			$("#idgroup").attr("class","form-group has-error");
			$("#err_id_reg").attr("style","display:block");
			$("#err_input_id").attr("style","display:none");
			return false;
		}else{
			$.ajax({
				type:"POST",
				url:"dupcheck.do",
				data:{userId:$("#userId").val()},					
				success: function(data){
					if(data=="false"){
						$("#idgroup").attr("class","form-group has-success");
						$("#err_id_reg").attr("style","display:none");
						$("#err_input_id").attr("style","display:none");
						$("#err_id_dup").attr("style","display:none");
					}else{
						$("#idgroup").attr("class","form-group has-error");
						$("#err_id_dup").attr("style","display:block");
						$("#err_id_reg").attr("style","display:none");
						$("#err_input_id").attr("style","display:none");
					}		
				}
			});
			if($("#idgroup").attr("class")=="form-group has-error"){
				return false;
			}else{
				return true;
			}
		}
	}else{
		$("#idgroup").attr("class","form-group");
		$("#err_id_reg").attr("style","display:none");
		$("#err_input_id").attr("style","display:block");
		$("#err_id_dup").attr("style","display:none");
		return false;
	}
}
function pwchk(){
	//var reg = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{1,20}$/;
	var reg = /^[a-z0-9]*$/;
	if($("#userPw").val().trim().length != 0){
		if(!reg.test($("#userPw").val())){
			$("#pwgroup").attr("class","form-group has-error");
			$("#err_pw_reg").attr("style","display:block");
			$("#err_input_pw1").attr("style","display:none");
			$("#err_input_pw2").attr("style","display:none");
			return false;
		}else{			
			if($("#userPw").val().length > 2){
				$("#pwgroup").attr("class","form-group has-success");
				$("#err_pw_reg").attr("style","display:none");
				$("#err_input_pw1").attr("style","display:none");
				$("#err_input_pw2").attr("style","display:none");
				return true;
			}else{
				$("#err_input_pw1").attr("style","display:none");
				$("#err_input_pw2").attr("style","display:block");
				$("#err_pw_reg").attr("style","display:none");
				return false;
			}
		}
	}else{
		$("#pwgroup").attr("class","form-group");
		$("#err_pw_reg").attr("style","display:none");			
		$("#err_input_pw1").attr("style","display:block");
		$("#err_input_pw2").attr("style","display:none");
		return false;
	}
}
function pwcchk(){
	if($("#userPwCheck").val().trim().length != 0){
		if($("#userPwCheck").val() != $("#userPw").val()){
			$("#pwchkgroup").attr("class","form-group has-error");
			$("#err_input_pwCheck1").attr("style","display:none");
			$("#err_input_pwCheck2").attr("style","display:block");
			return false;
		}else{			
			$("#pwchkgroup").attr("class","form-group has-success");
			$("#err_input_pwCheck1").attr("style","display:none");
			$("#err_input_pwCheck2").attr("style","display:none");
			return true;
		}
	}else{
		$("#pwchkgroup").attr("class","form-group");
		$("#err_input_pwCheck1").attr("style","display:block");
		$("#err_input_pwCheck2").attr("style","display:none");
		return false;
	}
}
function namechk(){
	var reg = /^[A-Za-z\uac00-\ud7a3]*$/;
	//var reg = /^[A-Za-z]*$/;
	if($("#userName").val().trim().length != 0){
		if(!reg.test($("#userName").val())){
			$("#namegroup").attr("class","form-group has-error");
			$("#err_name_reg").attr("style","display:block");
			$("#err_input_name").attr("style","display:none");
			return false;
		}else{			
			$("#namegroup").attr("class","form-group has-success");
			$("#err_name_reg").attr("style","display:none");
			$("#err_input_name").attr("style","display:none");
			return true;
		}
	}else{
		$("#namegroup").attr("class","form-group");
		$("#err_name_reg").attr("style","display:none");			
		$("#err_input_name").attr("style","display:block");
		return false;
	}
}
function phonechk(){
	var reg = /^01[0-9]{1}-[0-9]{3,4}-[0-9]{4}$/;	
	if($("#userPhoneNumber").val().trim().length != 0){
		if(!reg.test($("#userPhoneNumber").val())){
			$("#phonegroup").attr("class","form-group has-error");
			$("#err_phone_reg").attr("style","display:block");
			$("#err_input_phoneNumber").attr("style","display:none");
			return false;
		}else{			
			$("#phonegroup").attr("class","form-group has-success");
			$("#err_phone_reg").attr("style","display:none");
			$("#err_input_phoneNumber").attr("style","display:none");
			return true;
		}
	}else{
		$("#phonegroup").attr("class","form-group");
		$("#err_phone_reg").attr("style","display:none");			
		$("#err_input_phoneNumber").attr("style","display:block");
		return false;
	}
}
function genderchk(){
	if($("input[name=userSex]").is(":checked")===false){
		$("#err_input_sex").attr("style","display:block");
		return false;
	}else{
		$("#err_input_sex").attr("style","display:none");
		return true;
	}
}
function autoHypenPhone(str){
	str = str.replace(/[^0-9]/g, '');		
	var tmp = '';
	if( str.length < 4){
		return str;
	}else if(str.length < 7){
		tmp += str.substr(0, 3);
		tmp += '-';
		tmp += str.substr(3);
		return tmp;
	}else if(str.length < 11){
		tmp += str.substr(0, 3);
		tmp += '-';
		tmp += str.substr(3, 3);
		tmp += '-';
		tmp += str.substr(6);
		return tmp;
	}else{				
		tmp += str.substr(0, 3);
		tmp += '-';
		tmp += str.substr(3, 4);
		tmp += '-';
		tmp += str.substr(7);
		return tmp;
	}
	return str;
}