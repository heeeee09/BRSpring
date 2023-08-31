<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>음료 메뉴</title>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../resources/css/product/menu.css">
    <link rel="stylesheet" href="../resources/css/common/reset.css">
    <link rel="stylesheet" href="../resources/css/common/logo_nav_footer.css">
</head>
<body>
    <div id="container">
        <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
        <section>
                <div id="menuCategory">
                    <div id="icecream" class="menuCategory"><a href="/product/menu.do?menuType=iceCream">아이스크림</a></div>
                    <div id="icecreamCake" class="menuCategory"><a href="/product/menu.do?menuType=iceCreamCake">아이스크림케이크</a></div>
                    <div id="beverage" class="menuCategory"><a href="/product/menu.do?menuType=beverage">음료</a></div>
                    <div id="coffee" class="menuCategory"><a href="/product/menu.do?menuType=coffee">커피</a></div>
                    <div id="dessert" class="menuCategory"><a href="/product/menu.do?menuType=dessert">디저트</a></div>
                </div>
                <div id="menuBox">
                <div id="menuTitle">BEVERAGE</div>
                <input type="hidden" name="menuType" value="Coffee">
                <!-- 반복문과 조건문을 사용해 리스트 출력하기
                	iceList : 컨트롤러에서 보낸 DB의 데이터를 가진 List
                	status : 반복 상태를 알 수 있는 변수
                	${status.index % 4 eq 0 } :  status가 4의 배수일 때 if문 실행(한 줄에 4개씩 만들어짐)
                	var="i"(반복하는 변수) begin="${ status.index }" (인덱스 번호 ) 
                	end="${ status.index + (4 - 1) }" (인덱스 +3일 때까지(인덱스는 0부터 시작하니)) step="1" (1씩 증가)
                	${iceList[i] ne null } : 리스트의 값이 비어있을 때까지
                 -->
                	<c:forEach var="product" items="${productList }" varStatus="status">
                		<div class="menus">
                		<c:if test="${status.index % 4 eq 0 }">
		                    	<c:forEach var="i" begin="${ status.index }" end="${ status.index + (4 - 1) }" step="1">
		                    		<c:if test="${productList[i] ne null }">
					                    <div>
					                        <a href="/product/menu/detail.do"><img src="${productList[i].menuImgPath }" alt="${productList[i].menuName }"></a>
					                        <p class="iceName">${productList[i].menuName }</p>
					                        <p class="iceType">${productList[i].menuHotIce }</p>
					                        <button class="orderBtn" name="${productList[i].menuPkName }">장바구니에 담기</button>
					                    </div>
		                    		</c:if>
		                    	</c:forEach>
                		</c:if>
                    </div>
                    </c:forEach>
            </div>
            <c:if test="${memberId == 'brsystem' }">
	            <div id="insert">
	            	<button id="insertBtn" type="button" onclick="productInsert()">메뉴 등록하기</button>
	            </div>
			</c:if>	            
        </section>
        <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
    </div>

    <script>
    	<jsp:include page="/WEB-INF/views/include/headerLinkFunction.jsp"/>
   		productInsert = () => {
    		location.href="/product/selectInsert.do"
    	}
    </script>
</html>