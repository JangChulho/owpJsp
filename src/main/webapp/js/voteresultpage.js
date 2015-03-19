$(function(){
	var sheetNum = Number($(".meetnum").html())+9;
	var GSSurl = "https://spreadsheets.google.com/feeds/cells/1gD_HVQNVrCCNxuILkf57PloI81A2ZxQVOVn5ZV_8bI0/"+sheetNum+"/public/basic?alt=json-in-script&min-row=5&max-row=13&min-col=7&max-col=8&callback=?";
	$.ajax({
		url: GSSurl,
		type:"GET",		
		dataType:'json',
		success: function(data){
			var nlist = "";
			var entry=data.feed.entry; // 구글 스프레드 시트의 모든 내용
			for(var i in entry){ // 각 행에대해 아래 스크립트를 실행			
				if(i%2 == 0){
					$("form").append('<div><label class="btn btn-default"><span class="badge pull-right badgenumber" id='+entry[parseInt(i)+1].content.$t+'>0</span><img class="img-responsive img-circle" alt="Responsive image" src="img/member.jpg"><span>'+entry[parseInt(i)+1].content.$t+'</span><span class="hidden-xs"> ('+entry[i].content.$t+') </span></label></div>');
					nlist += entry[parseInt(i)+1].content.$t+",";
				}
			}
			poll(nlist);
		}	
	});
});
function poll(vlist){			
	$.ajax({
		url:"votecount.do",
		type:"POST",
		data:{name:vlist},
		dataType:'json',
		success: function(data){
			$.each(data, function(){
				$("#"+decodeURIComponent(this.name)).html(this.votenum);							
			});
			setTimeout(function(){poll(vlist);}, 3000);
		}
	});				
}