// 페이지이동
function reg() {
	document.location.href = "toLogin.do?mode=signUp";
}
function kakaoLogin(){
	document.location.href="kakaoLogin.do";
}
function googleLogin(){
	document.location.href="googleLogin.do";
}
function naverLogin(){
	document.location.href="naverLogin.do";
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// 다음주소검색
function SearchAddr(){
	new daum.Postcode({
		oncomplete: function(data) {
			// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
			// 예제를 참고하여 다양한 활용법을 확인해 보세요.
			var extraRoadAddr='';

			if(data.bname!=='' && /[동|로|가]$/g.test(data.bname)){
				extraRoadAddr+=data.bname;
			}
			if(data.buildingName !== '' && data.apartment === 'Y'){
				extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
			}
			if(extraRoadAddr!==''){
				extraRoadAddr='('+extraRoadAddr+')';
			}

			addrNum.value=data.zonecode;
			roadAddr.value=data.roadAddress;

			autoClose: true;

			var detailAddr=document.getElementById('detailAddr');
			detailAddr.focus();
		}
	}).open();
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// 회원가입 유효성 검사
$(function(){
	/* 이메일 유효성 검사 */
	/*
	$('#firstemail').keyup(function(){
		var emailRegex=new RegExp("^([0-9a-zA-Z])*([\.\-])([0-9a-zA-Z])*$","i");
		// var emailRegex=new RegExp("^([0-9a-zA-Z])*([\.\-])*([0-9a-zA-Z])*$","i");
		
		if($('#firstemail').val().length<3){
			$('#wrongEmail').text('');
			$('#emailCheck').text('');
		}
		
		if(emailRegex.test($(this).val())==false){
			$('#emailCheck').text('');
			$('#wrongEmail').text('잘못된 형식입니다');
			$('#wrongEmail').css('color','firebrick');
			$('#wrongEmail').css('font-weight','bold');
		}
		else{
			$('#wrongEmail').text('');
			$('#emailCheck').text('√');
			$('#emailCheck').css('color','green');
			$('#emailCheck').css('font-weight','bold');
		}
	});
	*/
	
	/* 핸드폰번호 숫자만 입력 체크 */
	$('#callNum').keyup(function(){
		var callNumRegex=new RegExp("^(01[016789]{1})-([0-9]{4})-([0-9]{4})$","g");
		
		if($('#callNum').val().length!=13 || callNumRegex.test($(this))==false){
			$('#callNumCheck').text('');
			$('#wrongNum').text('-을 포함한 핸드폰번호 13자리를 입력하세요');
			$('#wrongNum').css('color','firebrick');
			$('#wrongNum').css('font-weight','bold');
		}
		
		if($('#callNum').val().length==13 && callNumRegex.test($(this).val())){
			$('#wrongNum').text('');
			$('#callNumCheck').text('√');
			$('#callNumCheck').css('color','green');
			$('#callNumCheck').css('font-weight','bold');
		}
	});
	
	/* 비밀번호 보안성 체크 */
	$('#checkPw').keyup(function(){
		console.log('1');
		$('#repwCheck').text('');
		
		var strongRegex=new RegExp("^(?=.{8,})(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*\\W).*$", "g");
		var mediumRegex=new RegExp("^(?=.{7,})(((?=.*[A-Z])(?=.*[a-z]))|((?=.*[A-Z])(?=.*[0-9]))|((?=.*[a-z])(?=.*[0-9]))).*$", "g");
		var weakRegex=new RegExp("(?=.{6,}).*", "g");
		
		if($('#checkPw').val()=='' || $('#checkPw').val()==null){
			console.log('pw');
			$('#pwStr').text('');
			$('#pwCheck').text('');
			$('#pwReg').text('');
		}
		
		if(weakRegex.test($(this).val())===false){
			console.log('more pw');
			$('#pwStr').text('비밀번호 안전도');
			$('#pwStr').css('font-weight','bold');
			$('#pwReg').text('6자리 이상 입력해주세요');
			$('#pwReg').css('color','gray');
		}
		else if(strongRegex.test($(this).val())){
			console.log('strong');
			$('#pwStr').text('비밀번호 안전도 | ');
			$('#pwStr').css('font-weight','bold');
			$('#pwCheck').text('높음 ■■■');
			$('#pwCheck').css('color','green');
			$('#pwCheck').css('font-weight','bold');
			$('#pwReg').text('예측하기 힘든 비밀번호입니다');
			$('#pwReg').css('color','gray');
		}
		else if(mediumRegex.test($(this).val())){
			console.log('normal');
			$('#pwStr').text('비밀번호 안전도 | ');
			$('#pwStr').css('font-weight','bold');
			$('#pwCheck').text('보통 ■■');
			$('#pwCheck').css('color','royalblue');
			$('#pwCheck').css('font-weight','bold');
			$('#pwReg').text('대소문자 숫자 특수기호를 사용하여 보안을 높일수 있습니다');
			$('#pwReg').css('color','gray');
		}
		else{
			console.log('weak');
			$('#pwStr').text('비밀번호 안전도 | ');
			$('#pwStr').css('font-weight','bold');
			$('#pwCheck').text('낮음 ■');
			$('#pwCheck').css('color','firebrick');
			$('#pwCheck').css('font-weight','bold');
			$('#pwReg').text('대소문자 숫자를 2가지이상 포함시켜 보안을 높일수 있습니다');
			$('#pwReg').css('color','gray');
		}
	});
	
	/* 비밀번호 일치여부 체크 */
	$('#repw').keyup(function(){
		if($('#checkPw').val() != $('#repw').val()){
			console.log('2');
			$('#repwCheck').text('불일치 X');
			$('#repwCheck').css('color','firebrick');
			$('#repwCheck').css('font-weight','bold');
		}
		else{
			console.log('3');
			$('#repwCheck').text('일치 √');
			$('#repwCheck').css('color','green');
			$('#repwCheck').css('font-weight','bold');
		}
	});
});
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// 아이디 중복검사
function check(){
	console.log('func in');
	var id=$('#checkId').val();
	$.ajax({
		url : 'checkID.do?id='+id,
		type : 'GET',
		data : id,
		success : function(result){
			console.log(result);
			
			if(result=='fail'){
				console.log('fail ID');
				$('#idCheck').text('아이디사용불가');
			}
			else{
				if($('#checkId').val()==''){
					console.log('no ID');
					$('#idCheck').text('아이디입력');
				}
				else{
					console.log('success ID');
					$('#idCheck').text('아이디사용가능');
				}
			}
		}
	});
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// 아티스트 중복검사
function checkart(){
	var artist=$('#checkArtist').val();
	$.ajax({
		url : 'checkArtist.do?artist='+artist,
		type : 'GET',
		data : artist,
		success : function(result){
			console.log(result);
			
			if(result=='fail'){
				console.log('fail artist');
				$('#artistCheck').text('아티스트사용불가');
			}
			else{
				if($('#checkArtist').val()==''){
					console.log('no artist');
					$('#artistCheck').text('아티스트입력');
				}
				else{
					console.log('success artist');
					$('#artistCheck').text('아티스트사용가능');
				}
			}
		}
	});
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



