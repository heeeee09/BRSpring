<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>메뉴 안내</title>
	    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
	    <link rel="stylesheet" href="../../resources/css/product/menuDetail.css">
	    <link rel="stylesheet" href="../../resources/css/common/reset.css">
	    <link rel="stylesheet" href="../../resources/css/common/logo_nav_footer.css">
	</head>
	
	<body>
	    <div id="container">
	        <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
	        <section>
	            <div id="menuBox">
	                <p>메뉴 안내</p>
	                <div id="menuPage">
	                    <div id="menuImg">
	                        <img src="../../resources/image/product/icecream/바닐라.png" alt="바닐라">
	                    </div>
	                    <div>
	                        <div>
                                <form action="" method="post">
		                            <div id="menuTop">
	                               	 	<p id="menuName">바닐라</p>
		                                <input type="hidden" name="vanilla">
	                               		<button id="order" onclick="orderLink()">주문하기</button>
		                            </div>
                                </form>
	                            <p id="detail">부드럽고 깔끔한 바닐라 아이스크림</p>
                        	</div>
	                        <div>
	                            <p id="con">CONE & CUP</p>
	                            <div class="leftTop">
	                                <div class="menuDetails">
	                                    <img src="../../resources/image/product/icecream/size/사이즈_콘_싱글레귤러.png" alt="싱글레귤러">
	                                    <div class="size">
	                                        <p class="iceName">싱글레귤러</p>
	                                        <p class="iceDetail">한 가지 맛을 센스있게
	                                            <br>즐길 수 있는 사이즈
	                                            <br>(용기 무게 제외 중량 115g)
	                                        </p>
	                                        <p class="icePrice">3,500원</p>
	                                    </div>
	                                </div>
	                                <div class="menuDetails">
	                                    <img src="../../resources/image/product/icecream/size/사이즈_콘_싱글킹.png" alt="싱글킹">
	                                    <div class="size">
	                                        <p class="iceName">싱글킹</p>
	                                        <p class="iceDetail">좋아하는 맛 한가지만 <br>
	                                            듬뿍 맛볼 수 있는 사이즈 <br>
	                                            (중량 145g)</p>
	                                        <p class="icePrice">4,300원</p>
	                                    </div>
	                                </div>
	                            </div>
	                            <div class="leftTop">
	                                <div class="menuDetails">
	                                    <img src="../../resources/image/product/icecream/size/사이즈_콘_더블주니어.png" alt="더블주니어">
	                                    <div class="size">
	                                        <p class="iceName">더블주니어</p>
	                                        <p class="iceDetail">두가지 맛을 조금씩 한번에
	                                            <br>즐기는 사이즈
	                                            <br>(용기 무게 제외 중량 150g)
	                                        </p>
	                                        <p class="icePrice">4,7500원</p>
	                                    </div>
	                                </div>
	                                <div class="menuDetails">
	                                    <img src="../../resources/image/product/icecream/size/사이즈_콘_더블레귤러.png" alt="더블레귤러">
	                                    <div class="size">
	                                        <p class="iceName">더블레귤러</p>
	                                        <p class="iceDetail">아이스크림매니아를 위한 <br>
	                                            진정한 더블 사이즈 <br>
	                                            (중량 230g)</p>
	                                        <p class="icePrice">6,700원</p>
	                                    </div>
	                                </div>
	                            </div>
	                            <p id="con">HAND PACK</p>
	                            <div class="leftTop">
	                                <div class="menuDetails">
	                                    <img src="../../resources/image/product/icecream/size/사이즈_컵_파인트.png" alt="파인트">
	                                    <div class="size">
	                                        <p class="iceName">파인트</p>
	                                        <p class="iceDetail">3가지 맛을 골라먹는
	                                            <br>재미가 있는 사이즈
	                                            <br>(용기 무게 제외 중량 320g)
	                                        </p>
	                                        <p class="icePrice">8,900원</p>
	                                    </div>
	                                </div>
	                                <div class="menuDetails">
	                                    <img src="../../resources/image/product/icecream/size/사이즈_컵_쿼터.png" alt="쿼터">
	                                    <div class="size">
	                                        <p class="iceName">쿼터</p>
	                                        <p class="iceDetail">4가지 맛을 골라먹는 <br>
	                                            재미가 있는 사이즈 <br>
	                                            (중량 620g)</p>
	                                        <p class="icePrice">17,000원</p>
	                                    </div>
	                                </div>
	                            </div>
	                            <div class="leftTop">
	                                <div class="menuDetails">
	                                    <img src="../../resources/image/product/icecream/size/사이즈_컵_패밀리.png" alt="패밀리">
	                                    <div class="size">
	                                        <p class="iceName">패밀리</p>
	                                        <p class="iceDetail">5가지 맛을 나눠먹는
	                                            <br>재미가 있는 사이즈
	                                            <br>(용기 무게 제외 중량 960g)
	                                        </p>
	                                        <p class="icePrice">24,000원</p>
	                                    </div>
	                                </div>
	                                <div class="menuDetails">
	                                    <img src="../../resources/image/product/icecream/size/사이즈_컵_하프갤런.png" alt="하프갤런">
	                                    <div class="size">
	                                        <p class="iceName">하프갤런</p>
	                                        <p class="iceDetail">6가지 맛을 나눠먹는  <br>
	                                            재미가 있는 사이즈 <br>
	                                            (중량 1200g)</p>
	                                        <p class="icePrice">29,000원</p>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
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