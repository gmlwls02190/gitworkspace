<%@ tag language="java" pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>

<h1>결제</h1>
<hr>
${param.data}(를)을 ${param.cnt}개 구매<br>
<hr>
총 결제 금액: ${product.calc(param.data,param.cnt)}원