<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>아이스크림 메뉴 등록</title>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../resources/css/product/insert.css">
    <link rel="stylesheet" href="../resources/css/common/reset.css">
    <link rel="stylesheet" href="../resources/css/common/logo_nav_footer.css">
</head>
<body>
    <div id="container">
		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
        <section>
            <form name="insertForm" action="/product/insert.do" method="post" enctype="multipart/form-data">
            	<div id="productInsert">
	            <p id="subject">아이스크림 메뉴 등록</p>
	                <div id="id" class="insertBox">
	                    <label for="productName" class="labels">메뉴 이름</label>
	                    <input type="text" name="iceName" id="iceName" >
	                </div>	            
	                <div id="id" class="insertBox">
	                    <label for="productExplain" class="labels">메뉴 설명</label>
	                    <input type="text" name="menuExplain" id="menuExplain" >
	                </div>	            
                    <div id="file">
                    	<label class="labels">이미지 등록</label>
                    	<input class="upload-name" value="메뉴 이미지" >
                    	<label for="fileBtn" id="fileLabel">메뉴 이미지</label>
                    	<input type="file" name="uploadFile" id="fileBtn" class="fileBtn">
                    </div>	          
                    <button type="button" id="insertBtn" onclick="iceInsertBtn()">등록</button>      
	            </div>
            </form>
        </section>
	<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
    </div>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script>
 	   <jsp:include page="/WEB-INF/views/include/headerLinkFunction.jsp"/>
 	   function iceInsertBtn(){
 		  const iceName = document.querySelector("#iceName").value;
		  const menuExplain = document.querySelector("#menuExplain").value;
		  const menuImg = document.querySelector(".upload-name").value;
		  if(iceName == '' || menuExplain == '' || menuImg == ''){
			  alert("모든 정보를 입력 후 상품 등록을 할 수 있습니다.");
		  } else {
			  document.insertForm.submit();
		  } 		   
 	   }
		document.getElementById('fileBtn').addEventListener('change', () => {
		    var fileName = document.getElementById('fileBtn').value;
		    document.querySelector('.upload-name').value = fileName;
		});
    </script>
</body>

</html>