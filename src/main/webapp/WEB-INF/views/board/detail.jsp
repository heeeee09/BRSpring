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
	    <link rel="stylesheet" href="../resources/css/inquiryList.css">
	    <link rel="stylesheet" href="../resources/css/reset.css">
	    <link rel="stylesheet" href="../resources/css/logo_nav_footer.css">
	    <link rel="stylesheet" href="../resources/css/boardDetail.css">
	</head>
	<body>
	    <div id="container">
			<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
	        <section>
	            <div id="inquiryBox">
	                <p>${bList.boardWriterName }님이 문의하신 내용입니다</p>
	                <div id="line1"></div>
	                <table>
	                	<thead>
		                    <tr id="list1">
		                    <div id="Board">
	                            <div id="titleBox">
	                          	    ${bList.boardSubject }
	                            </div>
	                            <div id="contentBox">
	                            	 ${bList.boardContent }
	                            </div>
	                        </div>
							</tr>
	                    </tbody>
	                </table>
	                <div id="buttonBox">
	                    <a href="/board/boardList.do?currentPage=1"><button type="submit" id="write">문의 내역으로 돌아가기</button></a>
	                </div>
	            </div>
	        </section>
		<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
	    </div>
	    <script>
	    	<jsp:include page="/WEB-INF/views/include/headerLinkFunction.jsp"/>
	    </script>
	</body>
</html>