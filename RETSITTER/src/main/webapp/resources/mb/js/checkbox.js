<<<<<<< HEAD:RETSITTER/src/main/webapp/resources/mb/js/checkbox.js
$(function(){
	$("#checkAll").on("click",function(){
		if($("#checkAll").prop("checked")){ $("input[name='service']").prop("checked",true);
		} else {
			$("input[name='service']").prop("checked",false);
		}
	});
	var mpet = [];
	$(".petname").on("click",function(){
		var img = $(this).data("imgsrc");
		if($(".petname").prop("checked") == true){ 
				$(".petselec").html('<img src="/resources/images/'+img+'"/>');
		}else{ 
			$(".petselec").html("<img src='/resources/images/mypet.jpg'/>");
			
		}
	})
		
})



=======
$(function(){
	$("#checkAll").on("click",function(){
		if($("#checkAll").prop("checked")){ $("input[name='service']").prop("checked",true);
		} else {
			$("input[name='service']").prop("checked",false);
		}
	});
	var mpet = [];
	$(".petname").on("click",function(){
		var img = $(this).data("imgsrc");
		if($(this).is(":checked")==true){			
			$("#photo").attr("src","/upload/"+img);			
		}
	})

})



>>>>>>> b2951192f15074ad7e1f045f7cf5b29481d3ebff:src/main/webapp/resources/mb/js/checkbox.js
