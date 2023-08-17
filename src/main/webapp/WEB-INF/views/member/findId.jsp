<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>아이디 찾기</title>
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
	            <p>아이디 찾기</p>
	                <div id="loginBox">
            		<form action="/member/findId.do" method="post">
	                    <div class="inputBox">
	                        <label for="userPw">이름</label>
	                        <div>
	                            <input type="text" name="memberName" placeholder="  이름을 입력하세요">
	                        </div>
	                     </div>
                         <div id="line"></div>
	                     <div class="inputBox">
	                        <label for="userPw">이메일</label>
	                        <div>
	                            <input type="text" name="memberEmail" placeholder="  이메일 주소를 입력하세요">
	                        </div>
	                    </div>
	                    <div id="line"></div>
	                    <div id="btnBox">
		                    <button id="loginbtn" type="submit">아이디 찾기</button>
	                	</div>
               	 	</form>
                </div>
            </section>
        </main>
	<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
    </div>

    <script>
  	  <jsp:include page="/WEB-INF/views/include/headerLinkFunction.jsp"/>
//         function success() {
//             let left = (screen.availWidth -400) / 2;
//             let top = (screen.availHeight -300) / 2;
//             var viewOpt = "left=" + left + ", top=" + top + ", width=400, height=300";
//             window.open("/popup/loginSuccess.jsp","", viewOpt)
//         }
    </script>
</body>
</html>