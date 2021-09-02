<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커스텀태그 로그인/로그아웃</title>
</head>
<body>

<mytag:loginOut />
<hr>
아이디: ksh02190 <br>
비밀번호: 123123

</body>
</html>
<%-- 
1. 컨트롤로의 코드를 옮기는 것은 x
2. 커스텀태그내에서 EL x
3. EL ${ gt }
커스텀태그 ->> 로직이 섞인 뷰를 커스텀태그
 --%>