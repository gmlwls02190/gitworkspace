<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="NewFile1.jsp" method="post">
	<jsp:useBean id="dataBean" class="model.DataBean" scope="session"/>
	<select name="data">
		<%
			for(String v: dataBean.getDataList()){
				// out.println("<option>"+v+"</option>");
				%>
				<option><%=v %></option>
				<%
			}
		%>
	</select>
	<input type="submit" value="클릭">
</form>

</body>
</html>