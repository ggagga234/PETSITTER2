<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<title>ID 찾기</title>
</head>

<link rel="stylesheet" href="/resources/member/css/bootstrap.min.css">
<link rel="stylesheet" href="/resources/member/css/style.css">

<style>
.btn-primary {
	background-color: #81DAD6;
	border-color: ;
}

#strong {
	font-weight: bold;
	color: green;
}
.btn {
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 16px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  -webkit-transition-duration: 0.4s; /* Safari */
  transition-duration: 0.4s;
  cursor: pointer;
  border-radius: 10px;
}
.btn1 {
  background-color: #81DAD6; 
  color: white; 
  border: 2px solid #81DAD6;
  
}

.btn1:hover {
  background-color: turquoise;
  color: white;
}



</style>

<body>

	<jsp:include page="/WEB-INF/views/member/header.jsp"/>

	<div class="site-section bg-light">
		<div class="container">
			<div class="row">
				<div class="col-md-6 mb-5">

					<div class="row form-group">
						<div class="col-12">
							<label class="text-black" for="fname">ID찾기</label>
						</div>
					</div>

					<div class="row form-group">

						<div class="col-md-8">
							<label class="text-black" for="email">Email</label> <input
								type="text" id="email" class="form-control">
						</div>
					</div>

					<div class="row form-group">
						<div class="col-md-12">
						
							<button type="button" class="btn btn1"
								id="findid">ID 찾기</button>
						</div>
					</div>
					<div class="row form-group">
						<div class="col-md-12">
							<div id='yourid'></div>
						</div>
					</div>


				</div>
				<div class="col-md-6 mb-5">
					<div class="row form-group">

						<div class="col-md-12">
							<label class="text-black" for="email">비밀번호 재설정</label>
						</div>
					</div>
					<div class="row form-group">
						<div class="col-md-8">
							<label class="text-black" for="email">ID</label> <input
								type="text" id="id" class="form-control">
						</div>
					</div>
					<div class="row form-group">

						<div class="col-md-8">
							<label class="text-black" for="email">Email</label> <input
								type="text" id="email" class="form-control">
						</div>
					</div>
					<div class="row form-group">
						<div class="col-md-12">
							<button type="button" class="btn btn1">비밀번호
								재설정</button>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/member/footer.jsp"/>
	<script>
		$("#findid").on("click",
							function() {
							var email = $("#email").val();

							$.ajax({	url : "/member/findIdProc",
										type : "post",
										dataType : "json",
										data : {
											"email" : $("#email").val()
										},
										success : function(data) {
											var id = data.id

											if (id != null) {

												$("#yourid")
														.html(
																"<p>당신의 아이디는 <span id=strong>"+ id + "</span> 입니다.")
												$("#email").val("");

											} else if (id == null) {

												$("#yourid")
														.html(
																"<p>확인 되는 ID가 없습니다. Email 주소를 다시 확인하세요.")
											}
										},
										error : function(request, status, error) {
											alert("code:" + request.status
													+ "\n" + "message:"
													+ request.responseText
													+ "\n" + "error:" + error);
										}

									})
						}); //아이디 찾기

		$("#findpw").on("click",function() {
							var email = $("#email").val()
							var id = $("#id").val()

							if ((id != null && id != "")
									&& (email != null && email != "")) {

								$.ajax({ url : "/member//findPwProc",
											type : "post",
											dataType : "json",
											data : {
												"id" : id,
												"email" : email
											},
											success : function(data) {
												if (data == 1) {

													alert("등록 된 이메일로 임시비밀번호가 발송되었습니다.\n임시비밀번호로 로그인 후, 마이페이지에서 비밀번호를 수정해주세요.")

												} else if (data == 0) {

													alert("확인되는 정보가 없습니다. ID 또는 Email을 확인해주세요.")

												}
											}
										})

							}

						}); //비번찾기

		$("#login").on("click", function() {
			location.href = "/member/login";
		})
		$("#findpw").on("click", function() {
			location.href = "/member/findPw";
		})
	</script>


</body>

</html>
