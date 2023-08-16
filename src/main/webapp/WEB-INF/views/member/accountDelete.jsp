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
    <link rel="stylesheet" href="../resources/css/account_delete.css">
    <link rel="stylesheet" href="../resources/css/reset.css">
    <link rel="stylesheet" href="../resources/css/logo_nav_footer.css">
</head>
<body>
    <div id="container">
		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
        <section>
            <div>
                <div id="deletePage">
                    <p>회원 탈퇴</p>
                    <form action="/member/delete.do" method="post">
	                    <div id="deleteBox">
	                        <div id="pwBox1" class="pwBoxs">
	                            <label for="password">비밀번호</label>
	                            <input type="password" name="memberPwCheck" placeholder="  비밀번호를 입력해주세요">
	                        </div>
	                        <div id="line"></div>
	                    </div>
	                    <div id="buttons">
	                        	<button type="button" onclick="deleteBtn()">탈퇴하기</button>
	                        <button type="button" id="back"><a href="/member/myPage.do">이전 페이지로<br>이동</a></button>
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

		    if (memberPw === memberPwCheck) {
		        if (confirm("정말로 탈퇴하시겠습니까?\n탈퇴 후 취소할 수 없습니다.")) {
		            confirm("탈퇴되었습니다.") {
		                location.href = "/index.jsp";
		            }
		        }
		    } else {
		        alert("비밀번호가 다릅니다.");
		    }
		}
    </script>
</body>
</html>