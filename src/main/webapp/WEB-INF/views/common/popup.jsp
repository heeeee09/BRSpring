<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${title }</title>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./resources/css/member/login.css">
    <link rel="stylesheet" href="./resources/css/common/reset.css">
    <link rel="stylesheet" href="./resources/css/common/logo_nav_footer.css">
    <style>
        p {
            margin-top: 25%;
            font-family: 'Nanum Gothic', sans-serif;
            font-size: 40px;
            text-align: center; 
        }
        #closebtn {
            display: flex;
            justify-content: center;
        }
        button {
            width: 250px;
            height: 70px;
            margin: 10px;
            border-radius: 50px;
            font-size: 30px;
            font-family: 'Nanum Gothic', sans-serif;
            border: 0px;
            font-weight: lighter;
            color: white;
            background-color: #F04DA3;
            cursor: pointer !important;
        }
    </style>
</head>
<body>
    <div id="container">
        <section>
	        <p>${msg }</p>
	        <div id="closebtn">
	        	<button onclick="window.close()">닫기</button>
	        </div>
        </section>
    </div>
    <script>
    </script>
</body>
</html>