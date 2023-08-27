<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../resources/css/member/register.css">
    <link rel="stylesheet" href="../resources/css/common/reset.css">
    <link rel="stylesheet" href="../resources/css/common/logo_nav_footer.css">
</head>
<body>
    <div id="container">
		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
        <section>
            <form name="registerForm" action="/member/register.do" method="post">
            <div id="joinBox">
            <p id="subject">회원가입</p>
            <div id="join_info">
                <div id="id" class="infoBox">
                    <label for="user-id" class="labels">* 아이디</label>
                    <input type="text" name="memberId" id="memberId" onchange="regCheck()" placeholder="  아이디를 입력해주세요">
                    <button type="button" class="checkBtn" onclick="idCheck()">아이디 중복 확인</button>
                </div>
					<c:if test="${not empty msg}">
					    <span id="idCheckMsg" class="checkMsg" style="color: ${color };">
					        ${msg}
					    </span>
					</c:if>
                	<span id="idCheckMsg" class="checkMsg"></span>
                <div id="line"></div>
                <div id="pw" class="infoBox">
                    <label for="user-pw" class="labels">* 비밀번호</label>
                    <input type="password" name="memberPw" id="memberPw" onchange="pwCheck();regCheck();" placeholder="  비밀번호를 입력해주세요">
                </div>
                <span id="pwCheckMsg" class="checkMsg"></span>
                <div id="line"></div>
                <div id="pw-confirm" class="infoBox">
                    <label for="user-pw-confirm" class="labels">비밀번호 확인</label>
                    <input type="password" name="memberPwCheck" id="memberPwCheck" onchange="pwCheck()" placeholder="  비밀번호를 다시 입력해주세요">
                </div>
                	<span id="attentionMsg" class="checkMsg"></span>
                <div id="line"></div>
                <div id="name" class="infoBox">
                    <label for="user-name" class="labels">* 이름</label>
                    <input type="text" name="memberName" id="memberName" onchange="regCheck()" placeholder="  이름을 입력해주세요">
                </div>
                <span id="nameCheckMsg" class="checkMsg"></span>
                <div id="line"></div>
                <div id="birthday" class="infoBox">
                    <label for="user-birthday" class="labels">* 생년월일</label>
                    <input type="date" id="memberBirth" name="memberBirth" >
                </div>
                <div id="line"></div>
                <div id="gender" class="infoBox">
                    <label for="user-gender" class="labels">  성별</label>
                    <input type="radio" name="memberGender" value="M" class="memberGender" id="male"><label for="male" id="genderM" class="memberGender" > 남 </label>
                    <input type="radio" name="memberGender" value="F" class="memberGender" id="female"><label for="female" id="genderF" class="memberGender" > 여 </label>
                </div>
                <div id="line"></div>
                <div id="email" class="infoBox">
                    <label for="user-email" class="labels">* 이메일</label>
                    <input type="text" name="memberEmail" id="memberEmail">
                </div>
                <div id="line"></div>
                <div id="tell" class="infoBox">
                    <label for="uer-tell" class="labels">* 연락처</label>
                    <input type="text" name="memberPhone" onchange="regCheck()" id="memberPhone">
                </div>
                <div id="line"></div>
                <div id="address" class="infoBox">
                    <label for="uer-address" class="labels">  주소</label>
                    <input type="text" name="memberAddress" id="memberAddress">
                    <button type="button" class="checkBtn" onclick="daumPostcode()">우편번호 찾기</button>
                </div>
                <div id="line"></div>
            </div>
	            <div id="button">
	                <button type="button" onclick="registerCheck()" value="가입하기">회원가입</button>
	<!--                 <a href="./join_Complite.html" class="whiteFont"> -->
	            </div>
            </div>
            </form>
        </section>
	<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
    </div>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script>
 	   <jsp:include page="/WEB-INF/views/include/headerLinkFunction.jsp"/>
 	   
 	   function idCheck() {
 		  var memberId = document.querySelector('#memberId').value;
 		  console.log("memberId", memberId);
 		  if(memberId.trim() != ""){
 			 location.href = "/member/registerIdCheck.do?memberId="+memberId;
 		       var newUrl =  "/member/register.do";
 		       window.history.replaceState({}, document.title, newUrl);
 		  }else {
 			  window.alert('아이디를 입력해주세요.');
 		  }
 		  return false;
 	   }
 	   
 	  	function pwCheck() {
 	  		var memberPw = document.querySelector('#memberPw').value;
 	  		var memberPwCheck = document.querySelector('#memberPwCheck').value;

 	  	    if(memberPw === '' && memberPwCheck === '') {
 	  	    	window.alert('비밀번호를 입력해주세요.');
// 	   	    	e.stopPropagation();
 	  	    	return false;
 	  	    }
 	  	    if (memberPw.length >= 6 && memberPw.length <= 16) {
 	  	        if (memberPw === memberPwCheck) {
 	  	            document.getElementById('attentionMsg').innerHTML = '비밀번호가 일치합니다.';
 	  	            document.getElementById('attentionMsg').style.color = 'blue';
 	  	        } else {
 	  	            document.getElementById('attentionMsg').innerHTML = '비밀번호가 일치하지 않습니다.';
 	  	            document.getElementById('attentionMsg').style.color = 'red';
// 	   	          	e.preventDefault();
 	  	          	return false;
 	  	        }
 	  	    } else {
 	  	    	window.alert('비밀번호는 6글자 이상, 16글자 이하만 이용 가능합니다.');
 	  	        document.getElementById('attentionMsg').innerHTML = '';
// 	   	      	e.stopPropagation();
 	  	      	return false;
 	  	    }
 	  	}
 	  	
 	  	function regCheck() {
  		   var memberId = document.querySelector('#memberId').value;
 		   var memberPw = document.querySelector('#memberPw').value;
 		   var memberName = document.querySelector('#memberName').value;
 		   var memberBirth = document.querySelector('#memberBirth').value;
 		   var memberEmail = document.querySelector('#memberEmail').value;
 		   var memberPhone = document.querySelector('#memberPhone').value;
 		   
 		   /*
 		    * <정규표현식으로 유효성 체크(아이디, 비밀번호, 이름, 전화번호)>
 		   	* 아이디 : 4글자 이상, 20글자 이하, 영문, 숫자만 허용
 		   	* 비밀번호 : 6글자 이상, 16글자 이하, 영문, 숫자, 특수문자(~, !, @, #, $, %, ^, _, .)만, 적어도 하나 이상의 영문, 숫자, 특수문자 포함
 		   	* 이름 : 2글자 이상, 15글자 이하 
 		   	* 전화번호 11글자
 		    */
 		   
 		  var regId = /^[a-zA-Z0-9]{4,20}$/;
 		  var regPw = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[~!@#$%^_.])[A-Za-z\!@#$%^_.\d]{6,20}$/;
 	      var regName = /^[가-힣a-zA-Z]{2,15}$/;
 	      var regPhone = /^\d{11}$/;
 	      
 	      // 정규표현식과 입력받은 값을 비교해서 허용하지 않으면 메시지 출력, 허용되면 메시지 사라짐
 	      // 아이디
 	      if(!regId.test(memberId)){
 	    	 document.getElementById('idCheckMsg').innerHTML = '아이디는 4글자 이상, 20글자 이하의 영문, 숫자로된 것만 허용합니다.';
             document.getElementById('idCheckMsg').style.color = 'red';
             return false;
 	      }else{
 	    	 document.getElementById('idCheckMsg').innerHTML = '';
 	      }
 	      // 비밀번호
 	      if(!regPw.test(memberPw)){
 	    	 const msg = '비밀번호는 6글자 이상, 16글자 이하의 영문, 숫자, 특수문자(~, !, @, #, $, %, ^, _, .)만 허용하며\n 적어도 하나 이상의 영문, 숫자, 특수문자를 포함해야 합니다.'
 	    	 document.getElementById('pwCheckMsg').innerHTML = msg;
             document.getElementById('pwCheckMsg').style.color = 'red';
             return false;
 	      }else{
 	    	 document.getElementById('pwCheckMsg').innerHTML = '';
 	      }
 	      // 이름
 	      if(!regName.test(memberName)){
 	    	 document.getElementById('nameCheckMsg').innerHTML = '이름은 2글자 이상, 15글자 이하만 허용합니다.';
             document.getElementById('nameCheckMsg').style.color = 'red';
             return false;
 	      }else{
 	    	 document.getElementById('nameCheckMsg').innerHTML = '';
 	      }
 	      // 전화번호
 	      if(!regPhone.test(memberPhone)){
 	    	 document.getElementById('phoneCheckMsg').innerHTML = '전화번호는 11글자의 숫자만 허용합니다.';
             document.getElementById('phoneCheckMsg').style.color = 'red';
             return false;
 	      }else{
 	    	 document.getElementById('phoneCheckMsg').innerHTML = '';
 	      }
 	      
 	  	}
 	  	
 	  	function daumPostcode(){
 	  		// 객체 만들어서(주소가 저장될) 창 띄우기 -> API 실행
			new daum.Postcode({
				oncomplete : function(data){
				document.querySelector("#memberAddress").value="("+data.zonecode + ") "+ data.autoJibunAddress +", "+data.buildingName;
				}
			}).open(); 	  		
 	  	}
 	   
 		   //아이디, 비밀번호, 이름. 생일, 이메일, 전화번호
 	   function registerCheck() {
 		   var memberId = document.querySelector('#memberId').value;
 		   var memberPw = document.querySelector('#memberPw').value;
 		   var memberName = document.querySelector('#memberName').value;
 		   var memberBirth = document.querySelector('#memberBirth').value;
 		   var memberEmail = document.querySelector('#memberEmail').value;
 		   var memberPhone = document.querySelector('#memberPhone').value;
 		   
//  		   var idCheck = document;

 		   if(memberName === '' || memberBirth === '' || memberEmail === '' || memberPhone === '') {
 		   		window.alert("필수정보는 반드시 입력해야 합니다.");
 		   		return false;
 		   } else{
 			  document.registerForm.submit();
 		   }
 	   }
    </script>
    
</body>

</html>