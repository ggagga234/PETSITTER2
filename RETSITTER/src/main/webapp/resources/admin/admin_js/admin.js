$(function(){
	$(".accept").on("click",function(){
		var id = $(this).attr("id");
		location.href="/admin/petaccept?id="+id;
	})
	
	$(".cencel").on("click",function(){
		var id = $(this).attr("id");
		location.href="/admin/cencel?id="+id;
	})
	
	$('#myModal').on('shown.bs.modal', function () {
	  $('#myInput').trigger('focus')
	})
	
	$('.no').on("click",function(){
		$("#msg_title").val("");
		$(".note-editable").html("");
	})
	
	$('.message').on("click",function(){
		var id = $(this).attr("id");
		$("#summernote").attr('class',id);
	})
	
	
	$(".stop_btn").on("click",function(){
		$("#s_stop_day").val($(this).parent().children('.state').val());
		$("#stop_id").val($(this).parent().parent().children('.id').html());
	})
	
	$(".messagesend").on("click",function(){
	
		var id = $("#summernote").attr("class");	
		var queryString = $("form[name=message_form]").serialize();
		
		console.log(id);
		$.ajax({
			type: "GET",
			url: "/admin/message?msg_reciever="+ id,
			data : queryString,
			cache: false,
			dataType : "json",
			success: function(data){
				check = data.re;
				if(check > 0 ){
					alert('성공적으로 메세지를 전송하였습니다.');
					location.reload();
				}
				else{
					alert('메세지 전송에 실패했습니다.');
				}		
			}	
		})
	})
	
	
	$(".stopsend").on("click",function(){
		var queryString = $("form[name=stop_info]").serialize();
		$.ajax({
			type: "GET",
			url: "/admin/mem_stop",
			cache: false,
			data : queryString,
			dataType : "json",
			success: function(data){
				check = data.re;
				if(check > 0 ){
					alert('해당 아이디를 정지 시켰습니다.');
					location.reload();
				}
				else{
					alert('정지 시키는 것을 실패했습니다.');
				}		
			}	
		})
	})
})