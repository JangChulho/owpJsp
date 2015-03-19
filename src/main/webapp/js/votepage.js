$(function(){
	var sheetNum = Number($(".meetnum").html())+9;
	var GSSurl = "https://spreadsheets.google.com/feeds/cells/1gD_HVQNVrCCNxuILkf57PloI81A2ZxQVOVn5ZV_8bI0/"+sheetNum+"/public/basic?alt=json-in-script&min-row=5&max-row=13&min-col=7&max-col=8&callback=?";
	$.ajax({
		type:"GET",
		url: GSSurl,
		dataType:'json',
		success: function(data){
			var entry=data.feed.entry; // 구글 스프레드 시트의 모든 내용
			for(var i in entry){ // 각 행에대해 아래 스크립트를 실행			
				if(i%2 == 0){
					$("form").append('<div data-toggle="buttons"><label class="btn btn-default"><input type="checkbox" name="votechk" value='+entry[parseInt(i)+1].content.$t+'><img class="img-responsive img-circle" alt="Responsive image" src="img/member.jpg"><span>'+entry[parseInt(i)+1].content.$t+'</span><span class="hidden-xs"> ('+entry[i].content.$t+') </span></label></div>');				
				}
			}		
		}	
	});
	
	$(document).on("change","input[name=votechk]",function(){		
		if($("input[name=votechk]:checked").length == 2){
			$("#votebtn").attr("disabled", false);			
		}else{
			$("#votebtn").attr("disabled", true);
		}
	});
		
	$(document).on("click","#votebtn",function(){
		var $objForm = $("form")[0];
		$objForm.method = "post";
		$objForm.action = "votecomplete.do";
		$objForm.submit();				
	});
});