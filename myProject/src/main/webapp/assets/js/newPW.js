// 임시비밀번호 발급 절차
window.onload=function(){
		$('#checkCallNum').hide();
		$('#checkSMSNum').hide();
		$('#sendEmail').hide();
		$('#confirmBtn').hide();
		$('#sendSMSBtn').hide();
		$('#reSendSMSBtn').hide();
	}

function newpwidcheck(){
	console.log('in');
	var id=$('#checkId').val();
	$.ajax({
		url : 'checkID.do',
		type : 'POST',
		data : 'id='+id,
		success : function(result){
			console.log(result);
			
			if(result=='fail'){
				$('#newpwCheck').text('일치 √');
				$('#newpwCheck').css('color','green');
				$('#newpwCheck').css('font-weight','bold');
				$('#IDCheckBtn').hide();
				$('#checkCallNum').show();
			}
			else{
				alert('존재하지 않는 아이디입니다');
			}
		}
	});
}

function checknum(){
	var id=$('#checkId').val();
	var callNum=$('#callNum').val();
	$.ajax({
		url : 'checkCallNum.do',
		type : 'POST',
		data : 'id='+id+'&callNum='+callNum,
		success : function(result){
			console.log(result);
			
			if(result=='success'){
				$('#callNumstr').text('인증번호 발급 버튼 클릭');
				$('#callNumstr').css('color','green');
				$('#callNumstr').css('font-weight','bold');
				$('#checkNumBtn').hide();
				$('#sendSMSBtn').show();
			}
			else{
				alert('일치하지 않는 번호입니다');
			}
		}
	});
}

function sendsms(){
	var callNum=$('#callNum').val();
	$.ajax({
		url : 'sendSMS.do',
		type : 'POST',
		data : 'callNum='+callNum,
		success : function(result){
			$('#sendSMSBtn').hide();
			$('#reSendSMSBtn').show();
			$('#checkSMSNum').show();
			$('#randNum').text(result);
		}
	});
}

function checksms(){
	if($('#SMSNum').val()==$('#randNum').text()){
		$('#SMSCheck').text('인증완료');
		$('#SMSCheck').css('color','green');
		$('#SMSCheck').css('font-weight','bold');
		$('#SMSBtn').hide();
		$('#sendEmail').show();
		$('#confirmBtn').show();
	}
	else{
		$('#SMSCheck').text('잘못된 인증번호입니다');
		$('#SMSCheck').css('color','firebrick');
		$('#SMSCheck').css('font-weight','bold');
	}
}
function sendnewpw(){
	var email=$('#myEmail').val();
	console.log(email);
	if(email==null || email==''){
		alert('이메일을 입력해주세요');
		$('#myEmail').focus();
		return false;
	}
	
	var to=$('#to').val();
	var firstemail=$('#myEmail').val();
	var lastemail=$('#lastemail').val();
	
	$.ajax({
		url : 'sendNewPW.do',
		type : 'POST',
		data : 'to='+to+'&firstemail='+firstemail+'&lastemail='+lastemail,
		success : function(){
			window.close();
		}
	});
}