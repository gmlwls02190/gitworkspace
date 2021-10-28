<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<nav id="menu">
	<h2><spring:message code="message.menuBar.menu"/></h2>
	<c:if test="${mem!=null}">
		<h4>${mem.artist}</h4>
	</c:if>
	<c:if test="${kakaoVO!=null}">
		<h4>${kakaoVO.user_name}</h4>
	</c:if>
	<ul>
		<li><a href="main.do"><spring:message code="message.menuBar.home"/></a></li>
		<li><a href="info.do"><spring:message code="message.menuBar.aboutUs"/></a></li>
		<li class="accordian" ><span id="accMenu"><spring:message code="message.menuBar.artist"/></span></li>
		<ul class="accordianMenu">
			<li><a href="galleryList.do?artist=tester">tester</a></li>
			<li><a href="galleryList.do?artist=">2번아티스트</a></li>
			<li><a href="galleryList.do?artist=">3번아티스트</a></li>
		</ul>
		<li><a href="galleryList.do"><spring:message code="message.menuBar.gallery"/></a></li>
		
		<c:if test="${mem==null && kakaoVO==null}">
			<li><a href="toLogin.do?mode=login"><spring:message code="message.menuBar.login"/></a></li>
		</c:if>
		
		<c:if test="${mem!=null || kakaoVO!=null}">
			<li class="accordian" ><span id="accMenu"><spring:message code="message.menuBar.my"/></span></li>
			<ul class="accordianMenu">
			<li><a href="myGallery.do"><spring:message code="message.menuBar.myGallery"/></a></li>
			<li><a href="insertArt.do"><spring:message code="message.menuBar.addArt"/></a></li>
			<li><a href="editMember.do"><spring:message code="message.menuBar.editMem"/></a></li>
			</ul>
			<li><a href="logout.do"><spring:message code="message.menuBar.logout"/></a></li>
		</c:if>
		<li class="accordian" ><span id="accMenu"><spring:message code="message.menuBar.lang"/></span></li>
		<ul class="accordianMenu">
			<li><a href="main.do?lang=en"><spring:message code="message.menuBar.en"/></a></li>
			<li><a href="main.do?lang=ko"><spring:message code="message.menuBar.ko"/></a></li>
		</ul>
	</ul>
</nav>