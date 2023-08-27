<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 탈퇴</title>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../resources/css/member/account_delete.css">
    <link rel="stylesheet" href="../resources/css/common/reset.css">
    <link rel="stylesheet" href="../resources/css/common/logo_nav_footer.css">
</head>
<body>
    <div id="container">
		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
        <section>
            <div>
                <div id="deletePage">
                    <p id="subject">회원 탈퇴</p>
                    <form action="/member/delete.do" method="POST">
	                    <div id="deleteBox">
	                        <div id="pwBox1" class="pwBoxs">
	                            <label for="password">비밀번호</label>
	                            <input type="password" name="memberPwCheck" placeholder="  비밀번호를 입력해주세요">
	                        </div>
	                        <div id="line"></div>
	                    </div>
	                    <div id="buttons">
	                   		<input type="hidden" name="memberId" value="${member.memberId}"> 
                        	<button type="submit" onclick="deleteBtn()">탈퇴하기</button>
	                        <button type="button" id="back"><a href="/member/myPage.do?memberId=${memberId }">이전 페이지로<br>이동</a></button>
	                    
	                    </div>
                    </form>
                </div>
            </div>
        </section>
	<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
    </div>

    <script>
  	  <jsp:include page="/WEB-INF/views/include/headerLinkFunction.jsp"/>

		function deleteBtn() {
		    const memberPwCheck = document.querySelector('input[name="memberPwCheck"]').value;
		    const memberPw = '${member.memberPw}';
		    const memberId =  document.querySelector('input[name="memberId"]').value;

		    if (memberPw == memberPwCheck) {
		        if (confirm("정말로 탈퇴하시겠습니까?\n탈퇴 후 취소할 수 없습니다.")) {
		            location.href = "/member/delete.do?memberId="+memberId;
		        }
		    } else {
		        alert("비밀번호가 다릅니다.");
		        location.href = "/member/myPage.do?memberId="+memberId;
		    }
		}
    </script>
</body>
</html>