<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>아이디 비밀번호 찾기</title>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../resources/css/inputInfo.css">
    <link rel="stylesheet" href="../resources/css/reset.css">
    <link rel="stylesheet" href="../resources/css/logo_nav_footer.css">
</head>

<body>
    <div id="container">
		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
        <main>
            <section id="login-field">
	            <div id="findBox">
	            	<button id="loginbtn" type="button" onclick="findId()">아이디 찾기</button>
	                <button id="loginbtn" type="button" onclick="findPw()">비밀번호 찾기</button>
           		</div>
            </section>
        </main>
	<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
    </div>

    <script>
  	  <jsp:include page="/WEB-INF/views/include/headerLinkFunction.jsp"/>
	  	function findId(){
	  		location.href="/member/findId.do";
  	  	}
	  	function findPw(){
	  		location.href="/member/findPw.do";
  	  	}
    </script>
</body>
</html>