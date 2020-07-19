<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>Browse &mdash; Free Website Template by Free-Template.co</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="" />
<meta name="keywords" content="" />
<meta name="author" content="Free-Template.co" />
<link rel="shortcut icon" href="ftco-32x32.png">
<link href="https://fonts.googleapis.com/css?family=Rubik:400,700"
	rel="stylesheet">
<link rel="stylesheet" href="/resources/main/fonts/icomoon/style.css">
<link rel="stylesheet" href="/resources/main/css/bootstrap.min.css">
<link rel="stylesheet" href="/resources/main/css/magnific-popup.css">
<link rel="stylesheet" href="/resources/main/css/jquery-ui.css">
<link rel="stylesheet" href="/resources/main/css/owl.carousel.min.css">
<link rel="stylesheet"
	href="/resources/main/css/owl.theme.default.min.css">
<link rel="stylesheet"
	href="/resources/main/fonts/flaticon/font/flaticon.css">
<link rel="stylesheet" href="/resources/main/css/aos.css">
<link rel="stylesheet" href="/resources/main/css/rangeslider.css">
<link rel="stylesheet" href="/resources/mb/css/style.css">

<link href="/resources/mb/icofont/icofont.min.css" rel="stylesheet">
<link href='https://unpkg.com/boxicons@2.0.5/css/boxicons.min.css'
	rel='stylesheet'>
<script src="https://unpkg.com/boxicons@latest/dist/boxicons.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment-with-locales.min.js"></script>
</head>
<body>
	<div class="site-wrap">

		<div class="site-mobile-menu">
			<div class="site-mobile-menu-header">
				<div class="site-mobile-menu-close mt-3">
					<span class="icon-close2 js-menu-toggle"></span>
				</div>
			</div>
			<div class="site-mobile-menu-body"></div>
		</div>

		<header class="site-navbar" role="banner">

			<div class="container-fluid" style="padding: 0 100px;">
				<div class="row align-items-center">
					<div class="col-12 col-xl-2">
						<h1 class="mb-2 site-logo">

							<c:choose>
								<c:when
									test="${loginInfo.mem_id eq '관리자' && loginInfo.mem_address1 eq 'admin_address'}">
									<a href="/admin/adminindex"><img
										src="resources/images/dogss.png"
										style="width: 250px; height: 60px;"></a>
								</c:when>
								<c:otherwise>
									<a href="/"><img src="resources/images/dogss.png"
										style="width: 250px; height: 60px;"></a>
								</c:otherwise>
							</c:choose>

						</h1>
					</div>
					<c:choose>
						<c:when test="${empty loginInfo}">
							<div class="col-12 col-md-10 d-none d-xl-block">
								<nav class="site-navigation position-relative text-right"
									role="navigation">
									<ul class="site-menu js-clone-nav mr-auto d-none d-lg-block">
										<li><a href="/team"><span>팀소개</span></a></li>
										<li><a href="#introduce"><span>서비스소개</span></a></li>
										<li><a data-toggle="modal" href="#login1"><span>로그인</span></a></li>
										<li><a href="/member/signup"><span>회원가입</span></a></li>
									</ul>
								</nav>
							</div>
							<!-- 로그인-->
							<div class="modal fade" id="login1" data-keyboard="false"
								tabindex="-1" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-body">
											<div class="limiter">
												<div class="container-login100">
													<div class="wrap-login100">
														<button type="button" class="close" data-dismiss="modal"
															aria-label="Close">
															<span aria-hidden="true">&times;</span>
														</button>
														<form class="login100-form validate-form"
															action="/member/loginProc" name="loginProc" method="post">
															<span class="logo100 p-10">
																<p class="logo">
																	<span class="lnr lnr-paw"></span>뭐하냥 도와주개
																</p>
															</span> <span class="login100-form-title p-b-23"> LOGIN </span>
															<div class="wrap-input100 validate-input"
																data-validate="ID를 입력하세요.">
																<input class="input100" type="text" name="mem_id">
																<span class="focus-input100"></span> <span
																	class="label-input100">ID</span>
															</div>

															<div class="wrap-input100 validate-input"
																data-validate="비밀번호를 입력하세요.">
																<input class="input100" type="password" name="mem_pw">
																<span class="focus-input100"></span> <span
																	class="label-input100">Password</span>
															</div>
															<div class="flex-sb-m w-full p-t-3 p-b-32">
																<div class="contact100-form-checkbox">
																	<a href="/member/findInfo" class="txt1"> Forgot
																		ID/Password? </a>
																</div>
																<div>
																	<a href="/member/signup" class="txt1"> Sign Up </a>
																</div>
															</div>


															<div class="container-login100-form-btn">
																<button class="login100-form-btn" type="button"
																	id="login">Login</button>
															</div>
															<div class="text-center p-t-46 p-b-20">
																<span class="txt2"> OR SNS LOGIN </span>
															</div>

															<!-- href="https://kauth.kakao.com/oauth/authorize?client_id=4dd67a91f5b80223eb0934cae5fa4c50&redirect_uri=http://www.sojuhanjan.com/member/kakao&response_type=code"> -->
															<div class="login100-form-social flex-c-m bg2 m-r-5">
																<a class="btns"
																	href="https://kauth.kakao.com/oauth/authorize?client_id=4dd67a91f5b80223eb0934cae5fa4c50&redirect_uri=http://localhost/member/kakao&response_type=code">
																	<span><img
																		src="/resources/member/images/kakao_icon.png"></span> <span
																	class="txt3">Kakao Login</span>
																</a> <a class="btns" href="/member/naver"> <span><img
																		src="/resources/member/images/naver_icon.PNG"
																		width="34px" height="35px"></span> <span class="txt3">Naver
																		Login</span>
																</a>
															</div>
														</form>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</c:when>
						<c:otherwise>
							<div class="col-12 col-md-10 d-none d-xl-block">
								<nav class="site-navigation position-relative text-right"
									role="navigation">
									<ul class="site-menu js-clone-nav mr-auto d-none d-lg-block">

										<li><a href="/mypage/Introduction"><span>포인트 충전소<i
													class="icofont-money icofont-1x"
													style="color: #17a2b8; padding-right: 8px"></i></span></a></li>
										<li><a href="/mypage/mypage"><span>MY PAGE<i
													class="icofont-live-messenger icofont-1x"
													style="color: #17a2b8; padding-right: 8px"></i></span></a></li>
										<li><a href="/message/recievelist"
											onclick="window.open(this.href,'_blank','width=600, height=600, scrollbars=yes'); return false;"><span>메세지<i
													class="icofont-envelope icofont-1x" style="color: #17a2b8"></i></span></a></li>

										<li><a href="/member/logout" a><span>LOGOUT</span></></li>
									</ul>
								</nav>
							</div>
							<div class="col-12 col-md-12 d-none d-xl-block">
								<nav class="site-navigation position-relative text-right"
									role="navigation">
									<ul class="site-menu js-clone-nav mr-auto d-none d-lg-block">
										<li><a href="/team"><span style="font-size: 20px">팀
													소개</span></a></li>
										<li><a href="/mb/mb_board"><span
												style="font-size: 20px">방문 돌봄</span></a></li>
										<li><a href="/board/outputList"><span
												style="font-size: 20px">위탁 돌봄</span></a></li>
										<li><a href="/community/list"><span
												style="font-size: 20px">게시판</span></a></li>

									</ul>
								</nav>
							</div>
						</c:otherwise>
					</c:choose>

					<div class="d-inline-block d-xl-none ml-md-0 mr-auto py-3"
						style="position: relative; top: 3px;">
						<a href="#" class="site-menu-toggle js-menu-toggle text-white"><span
							class="icon-menu h3"></span></a>
					</div>
				</div>
			</div>
		</header>
		<div class="site-blocks-cover inner-page-cover overlay"
			style="background-image: url(/resources/mb/images/man.jpg);"
			data-aos="fade" data-stellar-background-ratio="0.5">
			<div class="container">
				<div
					class="row align-items-center justify-content-center text-center">
					<div class="col-md-10" data-aos="fade-up" data-aos-delay="400">
						<div class="row justify-content-center">
							<div class="col-md-8 text-center">
								<h1>알콜 코딩</h1>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="site-section bg-light">
			<div class="container">
				<div class="row justify-content-center mb-5">
					<div class="col-md-7 text-center border-primary">
						<h2 class="font-weight-light text-primary">Petsitter 팀 소개</h2>
					</div>
				</div>

				<div class="slide-one-item home-slider owl-carousel">
					<div>
						<div class="testimonial">
							<div class="row align-items-center">
								<div class="col-md-6">
									<img src="/resources/images/k1.jpg"
										alt="Free website template by Free-Template.co"
										class="img-fluid rounded">
								</div>
								<div class="col-md-5 ml-auto">
									<h2 class="text-primary mb-3">팀장 소용주</h2>
									<p>프로젝트에서 방문돌봄 서비스 게시판을 담당하여 방문돌봄 예약 시스템을 개발했습니다.</p>
								</div>
							</div>
						</div>
					</div>
					<div>
						<div class="testimonial">
							<div class="row align-items-center">
								<div class="col-md-6">
									<img src="/resources/images/k2.jpg"
										alt="Free website template by Free-Template.co"
										class="img-fluid rounded">
								</div>
								<div class="col-md-5 ml-auto">
									<h2 class="text-primary mb-3">이정아</h2>
									<p>프로젝트에서 회원가입과 로그인, SNS간편가입, SNS로그인, 마이페이지에서 내 정보 확인과 수정, 회원탈퇴를 맡았습니다.</p>
								</div>
							</div>
						</div>
					</div>
					<div>
						<div class="testimonial">
							<div class="row align-items-center">
								<div class="col-md-6">
									<img src="/resources/images/k4.jpg"
										alt="Free website template by Free-Template.co"
										class="img-fluid rounded">
								</div>
								<div class="col-md-5 ml-auto">
									<h2 class="text-primary mb-3">안진주</h2>
									<p>데이터베이스, 서버구축, 자유게시판, 간식 담당 잘 먹고 잘 놀고 잘 쉬자</p>
								</div>
							</div>
						</div>
					</div>
					<div>
						<div class="testimonial">
							<div class="row align-items-center">
								<div class="col-md-6">
									<img src="/resources/images/k3.jpg"
										alt="Free website template by Free-Template.co"
										class="img-fluid rounded">
								</div>
								<div class="col-md-5 ml-auto">
									<h2 class="text-primary mb-3">김선우</h2>
									<p>프로젝트에서 메세지와 관리자 페이지를 담당하고 있습니다 잘 부탁드립니다.</p>
								</div>
							</div>
						</div>
					</div>
					<div>
						<div class="testimonial">
							<div class="row align-items-center">
								<div class="col-md-6">
									<img src="/resources/images/k5.jpg"
										alt="Free website template by Free-Template.co"
										class="img-fluid rounded">
								</div>
								<div class="col-md-5 ml-auto">
									<h2 class="text-primary mb-3">설유빈</h2>
									<p>프로젝트에서 방문돌봄 서비스 게시판을 담당하여 방문돌봄 예약 시스템을 개발했습니다.</p>
								</div>
							</div>
						</div>
					</div>
					<div>
						<div class="testimonial">
							<div class="row align-items-center">
								<div class="col-md-6">
									<img src="/resources/images/k6.jpg"
										alt="Free website template by Free-Template.co"
										class="img-fluid rounded">
								</div>
								<div class="col-md-5 ml-auto">
									<h2 class="text-primary mb-3">유명근</h2>
									<p>프로젝트에서 방문돌봄 서비스 게시판을 담당하여 방문돌봄 예약 시스템을 개발했습니다.</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>


		<c:choose>
			<c:when test="${empty loginInfo}">

				<div class="py-5 bg-info">
					<div class="container">
						<div class="row">
							<div class="col-lg-7 mr-auto mb-4 mb-lg-0">
								<h2 class="mb-3 mt-0 text-white">Let's get started. Create
									your account</h2>
							</div>
							<div class="col-lg-4">
								<p class="mb-0">
									<a href="/member/signup"
										class="btn btn-outline-white text-white btn-md px-5 font-weight-bold btn-md-block">Sign
										Up</a>
								</p>
							</div>
						</div>
					</div>
				</div>
			</c:when>
			<c:otherwise>


				<div class="py-5 bg-info">
					<div class="container">
						<div class="row">
							<div class="col-lg-7 mr-auto mb-4 mb-lg-0">
								<h2 class="mb-3 mt-0 text-white">전문적인 펫시터가 될 수 있습니다.</h2>
							</div>
							<div class="col-lg-4">
								<p class="mb-0">
									<a href="signup.html"
										id="register_btn" class="btn btn-outline-white text-white btn-md px-5 font-weight-bold btn-md-block">펫시터
										지원하기</a>
								</p>
							</div>
						</div>
					</div>
				</div>
			</c:otherwise>
		</c:choose>

		<footer style="padding-bottom: 80px;">
			<div class="container">
				<div class="row pt-5 mt-5">
					<div class="col-12 text-md-center text-left">
						<p>
							<!-- Link back to Free-Template.co can't be removed. Template is licensed under CC BY 3.0. -->
							&copy; 2020 <strong class="text-black">Petsitter</strong>MohaNangdowajulge<br>
							Design by <a href="https://free-template.co/" target="_blank"
								class="text-black">mohanangdowajulge.co</a>
						</p>
					</div>
				</div>
			</div>
		</footer>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script src="/resources/main/js/jquery-migrate-3.0.1.min.js"></script>
	<script src="/resources/main/js/jquery-ui.js"></script>
	<script src="/resources/main/js/popper.min.js"></script>
	<script src="/resources/main/js/bootstrap.min.js"></script>
	<script src="/resources/main/js/owl.carousel.min.js"></script>
	<script src="/resources/main/js/jquery.stellar.min.js"></script>
	<script src="/resources/main/js/jquery.countdown.min.js"></script>
	<script src="/resources/main/js/jquery.magnific-popup.min.js"></script>
	<script src="/resources/main/js/bootstrap-datepicker.min.js"></script>
	<script src="/resources/main/js/aos.js"></script>
	<script src="/resources/main/js/rangeslider.min.js"></script>
	<script src="/resources/main/js/main.js"></script>
	<script>
	$("#register_btn").on("click",function(){
	       if(${sessionScope.loginInfo.mem_type == '2'}){
	          alert("이미 펫시터로 활동 중입니다. 마이페이지로 이동합니다.");
	          location.href="/petsitter/outputSingle";
	       } else if(${sessionScope.loginInfo.mem_type == '1'}){
	          location.href="/petsitter/petsitter_register_form";
	       } 
	     });
	</script>
</body>
</html>
