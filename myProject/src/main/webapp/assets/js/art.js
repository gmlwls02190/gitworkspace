// 페이지 진입시 관심 / 좋아요 판별
window.onload = function(){
		console.log('ready!!');
		$.ajax({
			url : 'checkFav.do',
			type : 'POST',
			data : 'id=${mem.id}&bid=${data.bid}',
			success : function(result){
				console.log(result);
				
				if(result=='success'){
					$('#favBtn').addClass('primary');
				}
				else{
					return;
				}
			}
		});
		
		$.ajax({
			url : 'isHeart.do',
			type : 'POST',
			data : 'id=${mem.id}&bid=${data.bid}',
			success : function(result){
				console.log(result);
				
				if(result=='like'){
					$('#heart').attr('src','images/like.png');
				}
				else{
					return;
				}
			}
		});
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//관심 등록/해제
function favart(){
	console.log("in");
	$.ajax({
		url : 'addArtist.do',
		type : 'POST',
		data : 'id=${mem.id}&bid=${data.bid}&title=${data.title}&artist=${data.artist}&gallery=${data.gallery}',
		success : function(result){
			console.log(result);
			
			if(result=='addSuccess'){
				$('#favBtn').addClass('primary');
				alert('관심작품 등록이 완료되었습니다');
			}
			else if(result=='delSuccess'){
				$('#favBtn').removeClass('primary');
				alert('관심작품 취소가 완료되었습니다');
			}
			else{
				alert('잘못된 요청입니다');
			}
		}
	});
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//좋아요 등록/해제
function heart(){
	$.ajax({
		url : 'checkHeart.do',
		type : 'POST',
		data : 'bid=${data.bid}&id=${mem.id}',
		success : function(result){
			console.log(result);
			
			if(result=='like'){
				$('#heart').attr('src','images/like.png');
			}
			else if(result=='unlike'){
				$('#heart').attr('src','images/unlike.png');
			}
			else{
				alert('잘못된 요청입니다')
			}
		}
	});
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////