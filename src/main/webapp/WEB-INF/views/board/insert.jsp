<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>1:1 문의 작성하기</title>
	    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
	    <link rel="stylesheet" href="../resources/css/board/board.css">
	    <link rel="stylesheet" href="../resources/css/board/boardWrite.css">
	    <link rel="stylesheet" href="../resources/css/common/reset.css">
	    <link rel="stylesheet" href="../resources/css/common/logo_nav_footer.css">
	</head>
	<body>
	    <div id="container">
	        <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
	        <section>
	            <form action="/board/insert.do" method="post" enctype="multipart/form-data">
		            <div class="boardBox">
		                <p id="subject">1:1 문의하기</p>
		                <div id="line1"></div>
		                    <div id="titles">
		                        <label class="titleLabel" for="">제목</label>
		                        <input id="titleBox" type="text" class="boardWrite" name="boardSubject" placeholder="  게시글의 제목을 입력해주세요">
		                    </div>    
		                    <div>
		                        <input type="text" id="writeBox" class="boardWrite" name="boardContent" placeholder="문의내용을 작성해주세요. 욕설 및 비방은 무통보 삭제될 수 있습니다.">
		                    </div>
		                    <div id="file">
		                    	<input class="upload-name" value="첨부파일" placeholder="첨부파일">
		                    	<label for="fileBtn" id="fileLabel">파일첨부</label>
		                    	<input type="file" name="uploadFile" id="fileBtn" class="fileBtn">
		                    </div>
		                <div class="submitBtnBox">
		                    <button type="submit" class="btn" id="write">1:1 문의하기</button>
		                </div>
		            </div>
	            </form>
	        </section>
			<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
	    </div>
	    
	    <script>
	    	<jsp:include page="/WEB-INF/views/include/headerLinkFunction.jsp"/>
	    		document.getElementById('fileBtn').addEventListener('change', () => {
	    		    var fileName = document.getElementById('fileBtn').value;
	    		    document.querySelector('.upload-name').value = fileName;
	    		});
	    </script>
	</body>
</html>