<%@ tag language="java" pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="product" class="model.Product" scope="session" />

<%
	for (String v : product.getPname()) {
		%>
		<option><%=v%></option>
		<%
	}
%>