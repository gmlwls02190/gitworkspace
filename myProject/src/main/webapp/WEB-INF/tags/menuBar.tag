<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<nav id="menu">
	<h2><spring:message code="message.menuBar.menu" /></h2>
	<c:if test="${mem!=null}">
		<h4><spring:message code="message.menuBar.name" />${mem.artist}</h4>
	</c:if>
	<c:if test="${kakaoVO!=null}">
		<h4>${kakaoVO.user_name}</h4>
	</c:if>
	<c:if test="${googleVO!=null}">
		<h4>${googleVO.user_name}</h4>
	</c:if>
	<c:if test="${naverVO!=null}">
		<h4>${naverVO.nickname}</h4>
	</c:if>
	<ul>
		<li><a href="main.do"><spring:message code="message.menuBar.home" /></a></li>
		<li><a href="info.do"><spring:message code="message.menuBar.aboutUs" /></a></li>
		<li class="accordian"><span id="accMenu"><spring:message code="message.menuBar.artist" /></span></li>
		<ul class="accordianMenu">
			<c:if test="${mem==null && kakaoVO==null && googleVO==null && naverVO==null}">
				<li class="subMenu"><a href="toLogin.do?mode=login"><spring:message code="message.menuBar.artistList" /></a></li>
			</c:if>
			<c:if test="${mem!=null || kakaoVO!=null || googleVO!=null || naverVO!=null}">
				<c:forEach var="v" items="${memdatas}">
					<li class="subMenu"><a href="galleryList.do?artist=${v.artist}">${v.artist}</a></li>
				</c:forEach>
			</c:if>
		</ul>
		<li><a href="galleryList.do"><spring:message code="message.menuBar.gallery" /></a></li>

		<c:if test="${mem==null && kakaoVO==null && googleVO==null && naverVO==null}">
			<li><a href="toLogin.do?mode=login"><spring:message code="message.menuBar.login" /></a></li>
		</c:if>

		<c:if test="${mem!=null || kakaoVO!=null || googleVO!=null || naverVO!=null}">
			<li class="accordian"><span id="accMenu"><spring:message code="message.menuBar.my" /></span></li>
			<ul class="accordianMenu">
				<li class="subMenu"><a href="myGallery.do?artist=${mem.artist}"><spring:message code="message.menuBar.myGallery" /></a></li>
				<li class="subMenu"><a href="myArtist.do?id=${mem.id}"><spring:message code="message.menuBar.favGallery" /></a></li>
				<li class="subMenu"><a href="editMember.do"><spring:message code="message.menuBar.editMem" /></a></li>
			</ul>
			<li><a href="logout.do"><spring:message code="message.menuBar.logout" /></a></li>
		</c:if>
		<li class="accordian"><span id="accMenu"><spring:message code="message.menuBar.lang" /></span></li>
		<ul class="accordianMenu">
			<li class="subMenu"><a href="main.do?lang=en"><spring:message code="message.menuBar.en" /></a></li>
			<li class="subMenu"><a href="main.do?lang=ko"><spring:message code="message.menuBar.ko" /></a></li>
		</ul>
	</ul>
</nav>