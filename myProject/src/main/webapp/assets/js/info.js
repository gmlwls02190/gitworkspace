// 구글맵 생성
$(function(){
	var map;
	function initMap(){
		var ll={
			lat : 37.50003,
			lng : 127.03559
		};
		map = new google.maps.Map(document.getElementById('map'),{
			zoom : 17,
			center : ll
		});
		var marker = new google.maps.Marker({
			position : ll,
			map : map
		});
	}
	initMap();
});
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////