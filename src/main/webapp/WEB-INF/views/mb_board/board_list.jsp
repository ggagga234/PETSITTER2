<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>Browse &mdash; Free Website Template by Free-Template.co</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="" />
<meta name="keywords" content="" />
<meta name="author" content="Free-Template.co" />
<link rel="shortcut icon" href="ftco-32x32.png">
<link href="https://fonts.googleapis.com/css?family=Rubik:400,700" rel="stylesheet">
<link rel="stylesheet" href="/resources/main/fonts/icomoon/style.css">
<link rel="stylesheet" href="/resources/main/css/bootstrap.min.css">
<link rel="stylesheet" href="/resources/main/css/magnific-popup.css">
<link rel="stylesheet" href="/resources/main/css/jquery-ui.css">
<link rel="stylesheet" href="/resources/main/css/owl.carousel.min.css">
<link rel="stylesheet" href="/resources/main/css/owl.theme.default.min.css">
<link rel="stylesheet" href="/resources/main/fonts/flaticon/font/flaticon.css">
<link rel="stylesheet" href="/resources/main/css/aos.css">
<link rel="stylesheet" href="/resources/main/css/rangeslider.css">
<link rel="stylesheet" href="/resources/mb/css/style.css">

<link href="/resources/mb/icofont/icofont.min.css" rel="stylesheet">
<link href='https://unpkg.com/boxicons@2.0.5/css/boxicons.min.css' rel='stylesheet'>
<script src="https://unpkg.com/boxicons@latest/dist/boxicons.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment-with-locales.min.js"></script>
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
<!-- 통합헤더 -->
		<header class="site-navbar" role="banner">
			<div class="container-fluid" style="padding:0 100px;">
				<div class="row align-items-center">
					<div class="col-12 col-xl-2">
						<h1 class="mb-2 site-logo">
							<a href="/"><img src="/resources/images/dogss.png"
								style="width: 250px; height: 60px;"></a>
						</h1>
					</div>
					<div class="col-12 col-md-10 d-none d-xl-block">
								<nav class="site-navigation position-relative text-right"
									role="navigation">
									<ul class="site-menu js-clone-nav mr-auto d-none d-lg-block">
										<li><a href="/member/login"><span>포인트 충전소<i class="icofont-money icofont-1x" style="color: #17a2b8;padding-right: 8px"></i></span></a></li>
										<li><a href="/member/login"><span>MY PAGE<i class="icofont-live-messenger icofont-1x" style="color: #17a2b8;padding-right: 8px"></i></span></a></li>
										<li><a href="/member/login"><span>메시지<i class="icofont-envelope icofont-1x" style="color: #17a2b8"></i></span></a></li>
										<li><a href="/member/logout"><span>LOGOUT</span></a></li>
									</ul>
								</nav>
							</div>
							<div class="col-12 col-md-12 d-none d-xl-block">
								<nav class="site-navigation position-relative text-right"
									role="navigation">
									<ul class="site-menu js-clone-nav mr-auto d-none d-lg-block">
										<li><a href="/admin/adminindex"><span
												style="font-size: 20px">팀 소개</span></a></li>
										<li><a href="/mb/mb_board?cpage=1"><span
												style="font-size: 20px">방문 돌봄</span></a></li>
										<li><a href="/board/outputList"><span
												style="font-size: 20px">위탁 돌봄</span></a></li>
										<li><a href="/member/login"><span
												style="font-size: 20px">게시판</span></a></li>
									</ul>
								</nav>
							</div>
					<!-- 끝 -->
		
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
								<h1>방문돌봄</h1>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>


		<div class="site-section bg-light">
			<div class="container">
				<div class="row">
					<div class="col-lg-8">
						<c:forEach var="i" items="${mblist}">
							<c:if
								test="${i.mb_restatus eq 'no' and i.mb_boardstatus eq 'yes'}">
								<div class="d-block d-md-flex listing-horizontal">
									<a href="/mb/modfilist?mb_seq=${i.mb_seq}" class="img d-block"
										style="background-image: url('/upload/${i.photo[0]}')"> </a>
									<div class="lh-content">
										<h3>
											<a href="/mb/modfilist?mb_seq=${i.mb_seq}">${i.mb_title}</a>
										</h3>
										<div>${i.date}</div>
									</div>
								</div>
							</c:if>
						</c:forEach>

						<div class="col-12 mt-5 text-center">
							<div class="custom-pagination">${navi}</div>
						</div>

					</div>
					<div class="col-lg-3 ml-auto">
						<div class="mb-5">
							<a href="/mb/home" class="btn btn-primary text-white"
								id="board_add" style="line-height: 35px">등록하기</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="py-5 bg-info">
			<div class="container">
				<div class="row">
					<div class="col-lg-7 mr-auto mb-4 mb-lg-0">
						<h2 class="mb-3 mt-0 text-white">전문적인 펫시터가 될 수 있습니다.</h2>
					</div>
					<div class="col-lg-4">
						<p class="mb-0">
							<a href="signup.html"
								class="btn btn-outline-white text-white btn-md px-5 font-weight-bold btn-md-block">펫시터 지원하기</a>
						</p>
					</div>
				</div>
			</div>
		</div>

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
</body>
</html>
