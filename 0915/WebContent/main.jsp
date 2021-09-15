<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.main{
	width:60%;
	display: inline-block;
}
.ad{
	float: right;
}
.fav{
	text-decoration:none;
}
</style>
<script type="text/javascript">
	function insertM(){
		document.location.href="insertM.jsp";
	}
	function editM(mid){
		document.location.href="control.jsp?action=editM&mid="+mid;
	}
	function delR(rid){
		document.location.href="control.jsp?action=deleteR&rid="+rid;
	}
	function myPage(){
		document.location.href="control.jsp?action=main";
	}
	function reg(){
		openWin();
	}
	function openWin(){
		window.open("reg.jsp","reg","width=300,height=300,resizable=no");
	}
</script>
</head>
<body>
<div class="main">
<ol>
	<li><a href="control.jsp?action=mainAll">전체목록보기</a></li>
</ol>
<hr>
<h2>전체목록</h2>
<my:forEach/>
<hr>
<my:more/>
<hr>
<my:login/>
<hr>
<h3>회원목록</h3>
<c:forEach var="v" items="${newUsers}">
<a href="control.jsp?action=otherMain&mcnt=${mcnt}&userid=${v.userid}">[${v.uname}]</a>님 환영! <br>
</c:forEach>

<a href="control2.jsp">test</a>
</div>

<div class="ad">
<a href="https://petoria.co.kr/?gclid=EAIaIQobChMIrf-ts7yA8wIVlQ6RCh39oQXnEAAYASAAEgJ8CPD_BwE" target="_blank"><img alt="puppy" src="img/puppy.jpg" width="100%" height="300px"></a>
</div>

</body>
</html>