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
    <link rel="stylesheet" href="../resources/css/join.css">
    <link rel="stylesheet" href="../resources/css/reset.css">
    <link rel="stylesheet" href="../resources/css/logo_nav_footer.css">
</head>
<body>
    <div id="container">
		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
        <section>
            <form action="/member/register.do" method="post">
            <div id="joinBox">
            <p>회원가입</p>
            <div id="join_info">
                <div id="id" class="infoBox">
                    <label for="user-id" class="labels">아이디</label>
                    <input type="text" name="member-id" placeholder="  아이디를 입력해주세요">
                </div>
                <div id="line"></div>
                <div id="pw" class="infoBox">
                    <label for="user-pw" class="labels">비밀번호</label>
                    <input type="password" name="member-pw" placeholder="  비밀번호를 입력해주세요">
                </div>
                <div id="line"></div>
                <div id="pw-confirm" class="infoBox">
                    <label for="user-pw-confirm" class="labels">비밀번호 확인</label>
                    <input type="password" name="member-pw-config" placeholder="  비밀번호를 다시 입력해주세요">
                </div>
                <div id="line"></div>
                <div id="name" class="infoBox">
                    <label for="user-name" class="labels">이름</label>
                    <input type="text" name="member-name" placeholder="  이름을 입력해주세요">
                </div>
                <div id="line"></div>
                <div id="birthday" class="infoBox">
                    <label for="user-birthday" class="labels">생년월일</label>
                    <input type="date" name="member-birthday" >
                </div>
                <div id="line"></div>
                <div id="gender" class="infoBox">
                    <label for="user-gender" class="labels">성별</label>
                    <input type="radio" name="member-gender" value="M" id="male"><label for="male" id="genderM"> 남 </label>
                    <input type="radio" name="member-gender" value="F" id="female"><label for="female" id="genderF"> 여 </label>
                </div>
                <div id="line"></div>
                <div id="email" class="infoBox">
                    <label for="user-email" class="labels">이메일</label>
                    <input type="text" name="member-email" >
                </div>
                <div id="line"></div>
                <div id="tell" class="infoBox">
                    <label for="uer-tell" class="labels">연락처</label>
                    <input type="text" name="member-phone" >
                </div>
                <div id="line"></div>
                <div id="address" class="infoBox">
                    <label for="uer-address" class="labels">주소</label>
                    <input type="text" name="member-address" >
                </div>
                <div id="line"></div>
            </div>
	            <div id="button">
	                <button type="submit" value="가입하기">회원가입</button>
	<!--                 <a href="./join_Complite.html" class="whiteFont"> -->
	            </div>
            </div>
            </form>
        </section>
	<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
    </div>
    <script>
 	   <jsp:include page="/WEB-INF/views/include/headerLinkFunction.jsp"/>
    </script>
</body>

</html>