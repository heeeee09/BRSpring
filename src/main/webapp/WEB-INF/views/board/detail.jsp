<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>1:1 문의 내역</title>
	    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
   	    <link rel="stylesheet" href="../resources/css/board/board.css">
	    <link rel="stylesheet" href="../resources/css/common/reset.css">
	    <link rel="stylesheet" href="../resources/css/common/logo_nav_footer.css">
	    <link rel="stylesheet" href="../resources/css/board/boardDetail.css">
	</head>
	<body>
	    <div id="container">
			<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
	        <section>
	            <div class="boardBox">
	                <p id="subject">${memberName }님이 문의하신 내용입니다</p>
	                <div id="line1"></div>
	                    <div id="titles">
	                        <label class="titleLabel" for="">제목</label>
	                        <input id="titleBox" type="text" class="boardWrite" id="titleBox" name="boardSubject" value="${board.boardSubject }" readonly>
	                    </div> 	                
	                    <div>
	                        <input type="text" id="writeBox" class="boardWrite" id="writeBox" name="boardContent" value="${board.boardContent }" readonly>
	                    </div>
                            <c:if test="${board.boardFileRename ne null}">
			                    <div id="detailFile">
			                    	<p id="upload-name" >${board.boardFileName }</p>
			                    	<a href="../resources/buploadFiles/${board.boardFileRename}" download><button class="fileBtn" id="downBtn">파일 다운로드</button></a>
			                    </div>		                            
		                    </c:if>
                        </div>
	                <div class="submitBtnBox">
	                    <a href="/board/list.do?memberId=${memberId }"><button type="button" class="btn" id="back">문의 내역</button></a>
	                    <a href="/board/modify.do?boardNo=${board.boardNo }"><button type="button" class="btn" id="modify">수정하기</button></a>
	                </div>
	            </div>
	        </section>
		<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
	    <script>
	    	<jsp:include page="/WEB-INF/views/include/headerLinkFunction.jsp"/>
//     		document.getElementById('downBtn').addEventListener('click', function(event) {
// 			function downBtn(event){
//     		    var button = event.target;
// 	    		var filePath = button.getAttribute('data-filepath');
// 	    		var downLink = document.getElementById('downLink');
// 	    	    downLink.href = filePath;
// 	    	};
	    </script>
	</body>
</html>