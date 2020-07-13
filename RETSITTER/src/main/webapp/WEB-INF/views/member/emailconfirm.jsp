<<<<<<< HEAD:RETSITTER/src/main/webapp/WEB-INF/views/member/emailconfirm.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<title>email 인증</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty msg}">

			<h3>이메일 인증이 완료되었습니다. 로그인 후 사이트 이용이 가능합니다.</h3>
			<div>
				<button type="button" id="login">로그인</button>
			</div>

		</c:when>
	<c:otherwise>
		${msg}
	</c:otherwise>
	</c:choose>

	<script>
		$("#login").on("click", function() {
			location.href = "login"
		})
	</script>


</body>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<title>email 인증</title>
</head>
<body>


	<jsp:include page="/WEB-INF/views/member/header.jsp" />
	<c:choose>
		<c:when test="${empty msg}">

			<h3>이메일 인증이 완료되었습니다. 로그인 후 사이트 이용이 가능합니다.</h3>
			<div>
				<button type="button" id="login">로그인</button>
			</div>

		</c:when>
	<c:otherwise>
		${msg}
	</c:otherwise>
	</c:choose>

	<jsp:include page="/WEB-INF/views/member/footer.jsp" />
	<script>
		$("#login").on("click", function() {
			location.href = "login"
		})
	</script>


</body>
>>>>>>> 191f5e3c794f8c8321fff3efe96a2f5bbe4b79e1:src/main/webapp/WEB-INF/views/member/emailconfirm.jsp
</html>