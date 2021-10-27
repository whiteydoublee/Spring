/**
 * 
 */
// Validation(유효성 검증 )


// 정규표현식(Regular Expression)
var reUid  = /^[a-z]+[a-z0-9]{3,10}$/;
var rePass = /^(?=.*[a-zA-Z])(?=.*[0-9]).{4,}$/;
var reName = /^[가-힣]{2,10}$/;
var reNick = /^[a-z가-힣0-9]{2,10}$/;


// 최종 유효성 검사에 사용될 상태변수
var isUidOk  = false;
var isPassOk = false;
var isNameOk = false;
var isNickOk = false;

$(document).ready(function(){
	
	$('.register > form').submit(function(){
		
		if(!isUidOk){
			alert('아이디가 유효하지 않습니다. 다시 입력하세요.');
			return false; // 전송취소 
		}
		
		if(!isPassOk){
			alert('비밀번호 유효하지 않습니다. 다시 입력하세요.');
			return false; // 전송취소
		}
		
		if(!isNameOk){
			alert('이름이 유효하지 않습니다. 다시 입력하세요.');
			return false; // 전송취소
		}
		
		if(!isNickOK){
			alert('닉네임이 유효하지 않습니다. 다시 입력하세요.');
			return false; // 전송취
		}
		
		return true; // 전송 시작 
	});
	
	
	
});