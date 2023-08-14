<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
	<head>
	    <meta charset="UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>탈퇴 확인</title>
	    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
	    <link rel="stylesheet" href="../resources/css/join_complite.css">
	    <link rel="stylesheet" href="../resources/css/reset.css">
	    <link rel="stylesheet" href="../resources/css/logo_nav_footer.css">
	    <style>
	        #listMove {
	            background-color: #402022;
	        }
	        #closebtn {
	            display: flex;
	            justify-content: center;
	        }
	        button {
	            width: 250px;
	            height: 80px;
	            margin: 10px;
	            margin-bottom: 180px;
	            border-radius: 50px;
	            font-size: 30px;
	            font-family: 'Nanum Gothic', sans-serif;
	            border: 0px;
	            font-weight: lighter;
	            color: white;
	            background-color: #F04DA3;
	            cursor: pointer !important;
	        }
	        #deleteBtn {
	            background-color: #402022;
	        }
	        #complite {
	        	margin-top: 160px;
	        	margin-bottom: 160px;
	        }
	    </style>
	</head>
	<body>
	    <div id="container">
			<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
		        <section>
		        <form action="/member/deleteConfirm.do" method="post">
			        <p id="complite">정말 탈퇴하시겠습니까?<br>
			        	탈퇴 후 취소할 수 없습니다.</p>
			        <div id="closebtn">
			        <button id="deleteBtn" type="submit" value="탈퇴하기">탈퇴하기</button>
			        <button type="button"><a href="/member/myPage.do">취소</a></button>
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