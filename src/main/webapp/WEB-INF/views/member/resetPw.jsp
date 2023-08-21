<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>비밀번호 재설정</title>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../resources/css/member/inputInfo.css">
    <link rel="stylesheet" href="../resources/css/common/reset.css">
    <link rel="stylesheet" href="../resources/css/common/logo_nav_footer.css">
</head>

<body>
    <div id="container">
		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
        <main>
            <section id="login-field">
	            <p>새 비밀번호 설정하기</p>
       			   	<form action="/member/resetPw.do" method="post">
	                <div id="loginBox">
	                	`<input type="hidden" name="memberId" value="${member}">
	                    <div class="inputBox">
	                        <label for="user-id">새 비밀번호</label>
	                        <div>
	                            <input type="password" name="memberPw"  onchange="resetBtn()" placeholder="  새로운 비밀번호를 입력하세요">
	                        </div>
	                    </div>
	                    <div id="line"></div>
	                    <div class="inputBox">
	                        <label for="user-id">새 비밀번호 확인</label>
	                        <div>
	                            <input type="password" name="memberPwCheck"  onchange="resetBtn()" placeholder="  새로운 비밀번호를 다시 입력하세요">
	                        </div>
	                    </div>
	                        <span id="attentionMsg"></span>
	                    <div id="line"></div>
	                    <div id="btnBox">
		                    <button id="loginbtn" type="submit">새 비밀번호 설정</button>
	                	</div>
                	</div>
           		</form>
            </section>
        </main>
	<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
    </div>

    <script>
  	  <jsp:include page="/WEB-INF/views/include/headerLinkFunction.jsp"/>
  	  
  	function resetBtn(e) {
  	    var memberPw = document.querySelector('input[name="memberPw"]').value;
  	    var memberPwCheck = document.querySelector('input[name="memberPwCheck"]').value;

  	    if(memberPw === '' && memberPwCheck === '') {
  	    	window.alert('변경할 비밀번호를 입력해주세요.');
  	    	e.preventDefault();
  	    	return;
  	    }
  	    if (memberPw.length >= 6 && memberPw.length <= 16) {
  	        if (memberPw === memberPwCheck) {
  	            document.getElementById('attentionMsg').innerHTML = '비밀번호가 일치합니다.';
  	            document.getElementById('attentionMsg').style.color = 'blue';
  	        } else {
  	            document.getElementById('attentionMsg').innerHTML = '비밀번호가 일치하지 않습니다.';
  	            document.getElementById('attentionMsg').style.color = 'red';
  	          	e.preventDefault();
  	          	return;
  	        }
  	    } else {
  	    	window.alert('비밀번호는 6글자 이상, 16글자 이하만 이용 가능합니다.');
  	        document.getElementById('attentionMsg').innerHTML = '';
  	      	e.preventDefault();
  	      	return;
  	    }
  	}
//         function success() {
//             let left = (screen.availWidth -400) / 2;
//             let top = (screen.availHeight -300) / 2;
//             var viewOpt = "left=" + left + ", top=" + top + ", width=400, height=300";
//             window.open("/popup/loginSuccess.jsp","", viewOpt)
//         }
    </script>
</body>
</html>