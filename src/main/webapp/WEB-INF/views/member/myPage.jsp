<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이페이지</title>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../resources/css/member/myPage.css">
    <link rel="stylesheet" href="../resources/css/common/reset.css">
    <link rel="stylesheet" href="../resources/css/common/logo_nav_footer.css">
</head>
<body>
    <div id="container">
		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
        <section>
            <div id="mypageBox">
                <div id="mypageList">
                    <div id="welcome">${memberName }님 <br>환영합니다</div>
                    <div id="line"></div>
                    <div class="mpList"><a href="./myBasket.html">장바구니</a></div>
                    <div class="mpList"><a href="/member/modify.do?memberId=${memberId }">회원정보 수정</a></div>
                    <div class="mpList"><a href="/member/delete.do?memberId=${memberId }">회원탈퇴</a></div>
                    <div class="mpList"><a href="/board/boardList.do?currentPage=1">1:1문의 내역</a></div>
                </div>
                <div id="linecol"></div>
                <div>
                    <div id="mpMain">
                        <p id="mpMain1">최근 주문내역</p>
                        <p id="mpMain2">최근 3개월 내의 주문내역입니다.</p>
                        <button id="recentbtn" value="이전내역">이전내역보기</button>
                    </div>
                    <div>
                        <table>
                            <tr id="list1">
                                <th>수령방법</th>
                                <th>주문일자</th>
                                <th>주문명</th>
                                <th>가격</th>
                                <th>상세보기</th>
                            </tr>
                            <tr>
                                <td>배달</td>
                                <td>2023-05-24</td>
                                <td>싱글레귤러 <br>외 2건</td>
                                <td>10,500</td>
                                <td><button class="detailbtn">상세보기</button></td>
                            </tr>
                            <tr>
                                <td>포장</td>
                                <td>2023-04-06</td>
                                <td>하프갤런</td>
                                <td>29,000</td>
                                <td><button class="detailbtn">상세보기</button></td>
                            </tr>
                            <tr>
                                <td>포장</td>
                                <td>2023-03-14</td>
                                <td>골라먹는<br>스노우볼</td>
                                <td>28,000</td>
                                <td><button class="detailbtn">상세보기</button></td>
                            </tr>
                        </table>
                    </div>
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