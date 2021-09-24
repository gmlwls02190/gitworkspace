<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	function checkid(){
		document.form2.action.value="checkid";
		document.form2.submit();
	}
	$(function(){
		$("#success").hide();
		$("#danger").hide();
		$("#clear").hide();
		$("input").keyup(function(){
			var pw1=$("#pw1").val();
			var pw2=$("#pw2").val();
			if(pw1 != "" && pw2 != ""){
				if(pw1 == pw2){
					$("#success").show();
					$("#clear").show();
					$("#danger").hide();
					$("#submit").removeAttr("disabled");
				}
				else{
					$("#success").hide();
					$("#clear").hide();
					$("#danger").show();
					$("#submit").attr("disabled","disabled");
				}
			}
		});
	});
</script>

</head>
<body>
<h2>회원가입페이지</h2>
<hr>
<a href="controller.jsp?action=main">메인으로</a>
<hr>
<form action="controller.jsp" method="post" name="form2">
<input type="hidden" name="action" value="join">
	<table>
		<tr>
			<td>아이디</td><td><input type="text" name="mid" required></td><td><input type="button" value="아이디중복확인" onClick="checkid()"></td>
		</tr>
		<tr>
			<td>비밀번호</td><td><input type="password" name="mpw" id="pw1" required></td>
		</tr>
		<tr>
			<td>비밀번호확인</td><td><input type="password" name="rempw" id="pw2" required></td><td id="success">비밀번호 일치</td><td id="danger">비밀번호 불일치</td>
		</tr>
		<tr>
			<td>닉네임</td><td><input type="text" name="mname" required></td>
		</tr>
		<tr>
			<td>이메일</td><td><input type="email" name="memail" required></td>
			<td></td>
		</tr>
		<tr>
			<td colspan="2"></td><td align="left"><input type="submit" id="clear" value="회원가입"></td>
		</tr>
	</table>
</form>

</body>
</html>