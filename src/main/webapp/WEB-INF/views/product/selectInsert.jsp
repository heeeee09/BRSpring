<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>메뉴 등록</title>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../resources/css/product/insertSelect.css">
    <link rel="stylesheet" href="../resources/css/common/reset.css">
    <link rel="stylesheet" href="../resources/css/common/logo_nav_footer.css">
</head>

<body>
    <div id="container">
		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
        <main>
            <section id="main">
            	<div class="msg">
	            <p id="print">등록할 메뉴를 선택해주세요</p>
            	</div>
	            <div id="insertBox">
	            	<button class="btn" type="button" onclick="product()">메뉴 등록</button>
	                <button class="btn" id="flavor" type="button" onclick="iceCream()">아이스크림 상세 등록</button>
           		</div>
            </section>
        </main>
	<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
    </div>

    <script>
  	  <jsp:include page="/WEB-INF/views/include/headerLinkFunction.jsp"/>
	  	function product(){
	  		location.href="/product/insertProduct.do";
  	  	}
	  	function iceCream(){
	  		location.href="/product/insertIceCream.do";
  	  	}
    </script>
</body>
</html>