<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav id="menu">
	<h2>Menu</h2>
	<h4>닉네임</h4>
	<ul>
		<li><a href="main.do">Home</a></li>
		<li><a href="info.jsp">AboutUs</a></li>
		<li class="accordian" ><span>Artist</span></li>
		<ul class="accordianMenu">
			<li><a href="galleryList.do?artist=">1번아티스트</a></li>
			<li><a href="galleryList.do?artist=">2번아티스트</a></li>
			<li><a href="galleryList.do?artist=">3번아티스트</a></li>
		</ul>
		<li><a href="galleryList.do">Gallery</a></li>
		
		<c:if test="${mem==null}">
			<li><a href="login.jsp?mode=login">Login</a></li>
		</c:if>
		
		<c:if test="${mem!=null}">
			<li><a href="myGallery.do">myGallery</a></li>
			<li><a href="logout.do">Logout</a></li>
		</c:if>
		
	</ul>
</nav>