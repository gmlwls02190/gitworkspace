// 페이지 이동
function deleteArt(){
		document.location.href="deleteGallery.do?bid=${data.bid}";
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// 이미지 미리보기
var selFile;

$(document).ready(function(){
	$("#fileUpload").on("change", handleImgFileSelect);
});

function handleImgFileSelect(e){
	var files=e.target.files;
	var filesArr=Array.prototype.slice.call(files);
	
	filesArr.forEach(function(f){
		if(!f.type.match("image.*")){
			alert("이미지만 등록가능합니다")
			return;
		}
		selFile=f;
		
		var reader=new FileReader();
		reader.onload=function(e){
			$("#preImg").attr("src",e.target.result);
			$("#nowImg").hide();
		}
		reader.readAsDataURL(f);
	});
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////