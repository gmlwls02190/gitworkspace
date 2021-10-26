<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://developers.kakao.com/sdk/js/kakao.min.js" charset="utf-8"></script>
<script type="text/javascript">
//초기화 시키기. 
	$(document).ready(function(){
		Kakao.init('cc78e1e3d846c9f6c4dafc8b6247aed0');
		Kakao.isInitialized(); 
	});
</script>
<script type="text/javascript">
	function loginWithKakao() {
		Kakao.Auth.authorize({
			redirectUri: 'http://localhost:8088/kakaologin/loginpage_kakao_callback' });
		}
</script>
</head>
<body>

<a><img alt="" src="images/kakaoLogin.png"></a>

</body>
</html>