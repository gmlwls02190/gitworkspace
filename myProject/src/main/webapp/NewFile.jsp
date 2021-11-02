<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="assets/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	var map;
	$(document).ready(function(){
		var ll={lat:37.50003, lng:127.03559};
		map=new google.maps.Map()
	});
</script>
</head>
<body>
<h2>구글맵API</h2>

<span id="map"></span>

</body>
</html>