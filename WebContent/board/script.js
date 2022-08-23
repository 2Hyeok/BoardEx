/** 
 * 게시판
 */
var inserterror = "글 작성에 실패했습니다. \n 잠시후 다시 시도하세요";

var writermsg = "작성자를 입력하세요";
var subjectmsg = "글 제목을 입력하세요";
var contentmsg = "글 내용을 입력하세요";
var passwdmsg = "비밀번호를 입력하세요";

var passwderror = "비밀번호가 다릅니다. \n 다시 확인하세요."
var deleteerror = "글 삭제에 실패했습니다. \n 잠시후 다시 시도하세요";
var modifyerror = "글 수정에 실패했습니다. \n 잠시후 다시 시도하세요";

function erroralert(msg){
	alert(msg);
	history.back();
}
// 글 수정
function modifycheck(){
	if (! modifyform.subject.value){
		alert(subjectmsg);
		modifyform.subject.focus();
		return false;
	}else if(! modifyform.content.value){
		alert(contentmsg);
		modifyform.content.focus();
		return false;
	}else if(! modifyform.passwd.value){
		alert(passwdmsg);
		modifyform.passwd.focus();
		return false;
	}
}


// 글 삭제
function passwdcheck() {
	if(! passwdform.passwd.value){
		alert(passwdmsg);
		passwdform.passwd.focus();
		return false;
	}
}

function writecheck(){
	if(! writeform.writer.value){
		alert(writermsg);
		writeform.writer.focus();
		return false;
	} else if (! writeform.subject.value) {
		alert(subjectmsg);
		writeform.subject.focus();
		return false;
	}else if (! writeform.content.value) {
		alert(contentmsg);
		writeform.content.focus();
		return false;
	}else if (! writeform.passwd.value) {
		alert(passwdmsg);
		writeform.passwd.focus();
		return false;
	}
}