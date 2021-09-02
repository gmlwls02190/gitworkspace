<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="product" class="model.Product" scope="session"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품</title>
</head>
<body>

<form action="B.jsp" method="post">
	<select name="data">
		<%
			for(String v: product.getPname()){
				%>
				<option><%= v %></option>
				<%
			}
		%>
	</select>
	<input type="number" name="cnt" min="0">
	<input type="submit" value="결제">
</form>

</body>
</html>