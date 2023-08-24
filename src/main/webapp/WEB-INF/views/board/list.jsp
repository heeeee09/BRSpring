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
	    <link rel="stylesheet" href="../resources/css/board/boardList.css">
	    <link rel="stylesheet" href="../resources/css/common/reset.css">
	    <link rel="stylesheet" href="../resources/css/common/logo_nav_footer.css">
	</head>
	<body>
	    <div id="container">
			<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
	        <section>
	            <div id="inquiryBox">
	                <p class="listText">${memberName }님이 문의하신 내용입니다</p>
	                <div id="line1"></div>
	                <table>
	                	<thead>
		                    <tr id="list1">
		                        <th>문의날짜</th>
		                        <th class="titles">제목</th>
		                        <th>답변여부</th>
		                        <th>삭제하기</th>
		                    </tr>
	                    </thead>
	                    <tbody>
	                    	<c:forEach var="board" items="${bList }">
							<tr>
								<td>${board.boardDate }</td>
								<td><a href="/board/detail.do?boardNo=${board.boardNo }">${board.boardSubject }</a></td>
								<td>확인중</td>
								<td><a href="javascript:void(0)" onclick="deleteCheck('${board.boardNo}')">X</a></td>
							</tr>
							</c:forEach>
							<tr align="center">
								<td colspan="5">
									<!-- 이전 -->
									<c:if test="${pInfo.startNavi != 1 }">
										<c:url var="prevUrl" value="/board/list.do">
											<c:param name="page" value="${pInfo.startNavi -1 }"></c:param>
										</c:url>
										<a href="${prevUrl }"><</a>
									</c:if>
									<!-- 페이지 네비 -->
									<c:forEach begin="${pInfo.startNavi }" end="${pInfo.endNavi }" var="p">
										<c:url var="pageUrl" value="/board/list.do?memberId=${memberId }">
											<c:param name="page" value="${p }"></c:param>
										</c:url>
										<a href="${pageUrl }">${p }</a>
									</c:forEach>
									<!-- 다음 -->
									<c:if test="${pInfo.startNavi != 1 }">
										<c:url var="nextUrl" value="/board/list.do">
											<c:param name="page" value="${pInfo.endNavi + 1 }"></c:param>
										</c:url>
										<a href="${nextUrl }">></a>
									</c:if>									
								</td>
							</tr>
	                    </tbody>
	                </table>
	                <div id="buttonBox">
	                    <a href="/board/insert.do"><button type="submit" id="write">1:1 문의하기</button></a>
	                </div>
	            </div>
	        </section>
		<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
	    </div>
	    <script>
			const deleteCheck = (boardNo) => {
				if(confirm("정말로 삭제하시겠습니까?")){
					location.href = "/board/delete.do?boardNo="+boardNo;
				}
			}
				<jsp:include page="/WEB-INF/views/include/headerLinkFunction.jsp"/>
	    </script>
	</body>
</html>