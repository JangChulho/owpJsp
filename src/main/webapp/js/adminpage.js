$(function(){
	var sessionid=$(".sessionid").html();
	console.log(sessionid);
	if(sessionid != "admin"){
		alert("관리자만 접근가능합니다.");
		history.back();
	}else{
		$.ajax({
			url:"votemember.do",
			type:"POST",		
			dataType:'json',
			success: function(data){
				$.each(data, function(){
					if(this.no%2==1){
						$(".votemember1").append('<div data-toggle="buttons"><label class="btn btn-default"><input type="checkbox" name="votechk" value='+this.id+'><img class="img-responsive img-circle" alt="Responsive image" src="img/member.jpg"><span>'+decodeURIComponent(this.name)+'</span></label></div>');
					}else{
						$(".votemember2").append('<div data-toggle="buttons"><label class="btn btn-default"><input type="checkbox" name="votechk" value='+this.id+'><img class="img-responsive img-circle" alt="Responsive image" src="img/member.jpg"><span>'+decodeURIComponent(this.name)+'</span></label></div>');
					}
				});				
			}	
		});
	}
	$(document).on("change","input[name=votechk]",function(){		
		if($("input[name=votechk]:checked").length == 0){
			$("#votecancelbtn").attr("disabled", true);			
		}else{
			$("#votecancelbtn").attr("disabled", false);
		}
	});
		
	$(document).on("click","#votecancelbtn",function(){
		var $objForm = $("form")[0];
		$objForm.method = "post";
		$objForm.action = "votecancel.do";
		$objForm.submit();				
	});
});