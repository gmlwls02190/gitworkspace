<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE HTML>
<html>
<head>
<title>HJ Art Gallery</title>
<mytag:favicon/>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<script src="assets/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
//페이지 진입시 관심 / 좋아요 판별
window.onload = function(){
	console.log('ready!!');
	$.ajax({
		url : 'checkFav.do',
		type : 'POST',
		data : 'id=${mem.id}&bid=${data.bid}',
		success : function(result){
			console.log(result);

			if(result=='success'){
				$('#favBtn').addClass('primary');
			}
			else{
				return;
			}
		}
	});

	$.ajax({
		url : 'isHeart.do',
		type : 'POST',
		data : 'id=${mem.id}&bid=${data.bid}',
		success : function(result){
			console.log(result);

			if(result=='like'){
				$('#heart').attr('src','images/like.png');
			}
			else{
				return;
			}
		}
	});
}
//관심 등록/해제
function favart(){
	console.log("in");
	$.ajax({
		url : 'addArtist.do',
		type : 'POST',
		data : 'id=${mem.id}&bid=${data.bid}&title=${data.title}&artist=${data.artist}&gallery=${data.gallery}',
		success : function(result){
			console.log(result);

			if(result=='addSuccess'){
				$('#favBtn').addClass('primary');
				alert('관심작품 등록이 완료되었습니다');
			}
			else if(result=='delSuccess'){
				$('#favBtn').removeClass('primary');
				alert('관심작품 취소가 완료되었습니다');
			}
			else{
				alert('잘못된 요청입니다');
			}
		}
	});
}

//좋아요 등록/해제
function heart(){
	$.ajax({
		url : 'checkHeart.do',
		type : 'POST',
		data : 'bid=${data.bid}&id=${mem.id}',
		success : function(result){
			console.log(result);

			if(result=='like'){
				$('#heart').attr('src','images/like.png');
			}
			else if(result=='unlike'){
				$('#heart').attr('src','images/unlike.png');
			}
			else{
				alert('잘못된 요청입니다')
			}
		}
	});
}
</script>
<link rel="stylesheet" href="assets/css/main.css" />
<noscript>
	<link rel="stylesheet" href="assets/css/noscript.css" />
</noscript>
</head>
<body class="is-preload">
	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Header -->
		<mytag:logoNnav />

		<!-- Menu -->
		<mytag:menuBar />

		<!-- Main -->
		<div id="main">
			<div class="inner">
			<section class="tiles">
					<article class="artImg">
						<span class="image"><img src="/images/${data.gallery}" alt="${data.title}" /></span>
					</article>
					<article class="artImg">
						<div>
							<div>
							<div id="imgTitle">
								<h1>${data.title}
								<c:if test="${(mem.id!=data.id) && (mem!=null)}">
									<a href="javascript:heart();" style="border-bottom: none;"><img id="heart" alt="heart" src="images/unlike.png" width="10%"></a>
								</c:if>
								</h1>
							</div>
							<c:if test="${mem.id==data.id}">
								<div id="editButton" style="text-align: right; margin: 0 0.5em 0.5em 0">
									<a href="editGallery.do?bid=${data.bid}" class="button"><spring:message code="message.art.edit"/></a>
								</div>
							</c:if>
							<c:if test="${(mem.id!=data.id) && (mem!=null)}">
								<div id="favButton" style="text-align: right; margin: 0 0.5em 0.5em 0">
									<button class="button" id="favBtn" onClick="favart()"><spring:message code="message.art.like"/></button>
								</div>
							</c:if>
							</div>
							<table>
								<tr>
									<td><spring:message code="message.art.artist"/></td><td>${data.artist}</td>
								</tr>
								<tr>
									<td><spring:message code="message.art.artNum"/></td><td>${data.bid}</td>
								</tr>
								<tr>
									<td><spring:message code="message.art.artInfo"/></td><td>${data.info}</td>
								</tr>
								<tr>
									<td><spring:message code="message.art.date"/></td><td>${data.wdate}</td>
								</tr>
							</table>
						</div>
					</article>
				</section>
				<ul style="list-style: none; text-align: center; padding: 0;">
					<li class="accordian button primary"><span id="accMenu"><spring:message code="message.art.origin"/></span></li>
					<ul class="accordianMenu">
						<li class="subMenu"><img src="/images/${data.gallery}" alt="${data.title}" style="width:100%; height:100%; display:block;"/></li>
					</ul>
				</ul>
				<div style="padding-top: 1.5em; text-align: center;">
					<a class="button primary" href="galleryList.do"><spring:message code="message.art.list"/></a>
				</div>
			</div>
		</div>

		<!-- Footer -->
		<mytag:footer />

	</div>

	<!-- Scripts -->
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>
	<!-- <script src="assets/js/art.js"></script> -->

</body>
</html>