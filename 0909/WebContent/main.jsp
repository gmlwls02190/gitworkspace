<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>Bank1</h2>
<table>
	<tr>
		<td>bid</td><td>name</td><td>balance</td>
	</tr>
		<tr>
			<td>${b1.b1id}</td><td>${b1.b1name }</td><td>${b1.b1balance }</td>
		</tr>
</table>

<h2>Bank2</h2>
<table>
	<tr>
		<td>bid</td><td>name</td><td>balance</td>
	</tr>
		<tr>
			<td>${b2.b2id}</td><td>${b2.b2name }</td><td>${b2.b2balance }</td>
		</tr>
</table>

<h2>Bank1에서 송금</h2>
<form action="control.jsp?action=trans1" method="post" name="form1">
	<table>
		<tr>
			<td>balance</td><td><input type="number" name="bal" placeholder="balance 작성" min="0" required></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="송금"></td>
		</tr>
	</table>
</form>

<h2>Bank2에서 송금</h2>
<form action="control.jsp?action=trans2" method="post" name="form2">
	<table>
		<tr>
			<td>balance</td><td><input type="number" name="bal" placeholder="balance 작성" min="0" required></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="송금"></td>
		</tr>
	</table>
</form>

</body>
</html>