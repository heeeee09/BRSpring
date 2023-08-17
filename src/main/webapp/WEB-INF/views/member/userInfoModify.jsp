<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 정보 수정</title>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../resources/css/member/join.css">
    <link rel="stylesheet" href="../resources/css/common/reset.css">
    <link rel="stylesheet" href="../resources/css/common/logo_nav_footer.css">
    <style>
        #prevBtn {
            background-color: #402022;
        }
    </style>
</head>
<body>
    <div id="container">
		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
        <section>
            <div id="joinBox">
            <p>회원 정보 수정</p>
            <form action="/member/modify.do" method="post">
	            <div id="join_info">
	                <div id="id" class="infoBox">
	                    <label for="user-id" class="labels">아이디</label>
	                    <input type="text" value="${member.memberId }" readonly>
	                </div>
	                <div id="line"></div>
	                <div id="pw" class="infoBox">
	                    <label for="user-pw" class="labels">비밀번호</label>
	                    <input type="password" name="memberPw" placeholder="  수정할 비밀번호를 입력해주세요">
	                </div>
	                <div id="line"></div>
	                <div id="pw-confirm" class="infoBox">
	                    <label for="user-pw-confirm" class="labels">비밀번호 확인</label>
	                    <input type="password" placeholder="  수정할 비밀번호를 다시 입력해주세요">
	                </div>
	                <div id="line"></div>
	                <div id="name" class="infoBox">
	                    <label for="user-name" class="labels">이름</label>
	                    <input type="text"  value="${member.memberName }" readonly>
	                </div>
	                <div id="line"></div>
	                <div id="birthday" class="infoBox">
	                    <label for="user-birthday" class="labels">생년월일</label>
	                    <p>${member.memberBirth }</p>
	                </div>
	                <div id="line"></div>
	                <div id="gender" class="infoBox">
	                    <label for="user-gender" class="labels">성별</label>
						<input type="hidden" value="${member.memberGender }" name="member-gender" id="member-gender" readonly>
						<c:if test="${member.memberGender eq 'M'}" >남자</c:if>
						<c:if test="${member.memberGender eq 'F'}">여자</c:if>
	                </div>
	                <div id="line"></div>
	                <div id="email" class="infoBox">
	                    <label for="user-email" class="labels">이메일</label>
	                    <input type="text" name="memberEmail" value="${member.memberEmail }">
	                </div>
	                <div id="line"></div>
	                <div id="tell" class="infoBox">
	                    <label for="uer-tell" class="labels">연락처</label>
	                    <input type="text" name="memberPhone" value="${member.memberPhone }">
	                </div>
	                <div id="line"></div>
	                <div id="address" class="infoBox">
	                    <label for="uer-address" class="labels">주소</label>
	                    <input type="text" name="memberAddress"  value="${member.memberAddress }">
	                </div>
	                <div id="line"></div>
	            </div>
	            <div id="button">
	                <button type="submit" value="수정하기">수정하기</button>
	                <button type="button" id="prevBtn"><a href="/member/myPage.do?memberId=${member.memberId }" class="whiteFont">이전 페이지로 이동</a></button>
            </div>
            </form>
            </div>
        </section>
		<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
    </div>
    <script>
		<jsp:include page="/WEB-INF/views/include/headerLinkFunction.jsp"/>
    </script>
</body>
</html>