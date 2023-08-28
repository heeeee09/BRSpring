<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>메뉴</title>
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
                    <div id="icecream" class="menuCategory"><a href="menu_iceCream.html">아이스크림</a></div>
                    <div id="icecreamCake" class="menuCategory"><a href="menu_iceCreamCake.html">아이스크림케이크</a></div>
                    <div id="beverage" class="menuCategory"><a href="#">음료</a></div>
                    <div id="coffee" class="menuCategory"><a href="#">커피</a></div>
                    <div id="dessert" class="menuCategory"><a href="#">디저트</a></div>
                </div>
                <div id="menuBox">
                <div id="menuTitle">ICE CREAM</div>
                <div class="menus">
                    <div>
                        <a href="/product/iceCream/31Yogurt.do"><img src="../resources/image/product/icecream/31요거트.png" alt="31요거트"></a>
                        <p class="iceName">31 요거트</p>
                        <p class="iceType">CONE & CUP</p>
                        <button class="orderBtn" name="31yogurt">장바구니에 담기</button>
                    </div>
                    <div>
                        <a href="/product/iceCream/greentea.do"><img src="../resources/image/product/icecream/그린티.png" alt="그린티"></a>
                        <p class="iceName">그린티</p>
                        <p class="iceType">CONE & CUP</p>
                        <button class="orderBtn" onclick="orderLink()">주문하기</button>
                        
                    </div>
                    <div>
                        <a href="/product/iceCream/newYorkCheeseCake.do"><img src="../resources/image/product/icecream/뉴욕_치즈케이크.png" alt="뉴욕 치즈케이크"></a>
                        <p class="iceName">뉴욕 치즈 케이크</p>
                        <p class="iceType">CONE & CUP</p>
                        <input type="hidden" name="newYorkCheeseCake">
                        <button class="orderBtn" onclick="orderLink()">주문하기</button>
                    </div>
                </div>
                <div class="menus">
                    <div>
                        <a href="/product/iceCream/dinoJelly.do"><img src="../resources/image/product/icecream/디노_젤리.png" alt="디노젤리"></a>
                        <p class="iceName">디노 젤리</p>
                        <p class="iceType">CONE & CUP</p>
                        <button class="orderBtn" onclick="orderLink()">주문하기</button>
                    </div>
                    <div>
                        <a href="/product/iceCream/ryanMangoMacaron.do"><img src="../resources/image/product/icecream/라이언_망고_마카롱.png" alt="라이언 망고 마카롱"></a>
                        <p class="iceName">라이언 망고 마카롱</p>
                        <p class="iceType">CONE & CUP</p>
                        <button class="orderBtn" onclick="orderLink()">주문하기</button>
                        
                    </div>
                    <div>
                        <a href="/product/iceCream/rainbowSherbet.do"><img src="../resources/image/product/icecream/레인보우_샤베트.png" alt="레인보우 샤베트"></a>
                        <p class="iceName">레인보우 샤베트</p>
                        <p class="iceType">CONE & CUP</p>
                        <button class="orderBtn" onclick="orderLink()">주문하기</button>
                    </div>
                </div>
                <div class="menus">
                    <div>
                        <a href="/product/iceCream/mintChocolateChip.do"><img src="../resources/image/product/icecream/민트_초콜릿_칩.png" alt="민트 초콜릿칩"></a>
                        <p class="iceName">민트 초콜릿칩</p>
                        <p class="iceType">CONE & CUP</p>
                        <button class="orderBtn" onclick="orderLink()">주문하기</button>
                    </div>
                    <div>
                        <a href="/product/iceCream/vanilla.do"><img src="../resources/image/product/icecream/바닐라.png" alt="바닐라"></a>
                        <p class="iceName">바닐라</p>
                        <p class="iceType">CONE & CUP</p>
                        <button class="orderBtn" onclick="orderLink()">주문하기</button>
                        
                    </div>
                    <div>
                        <a href="/product/iceCream/twinBerryCheeseCake.do"><img src="../resources/image/product/icecream/바람과_함께_사라지다.png" alt="바람과 함께 사라지다"></a>
                        <p class="iceName">바람과 함께 사라지다</p>
                        <p class="iceType">CONE & CUP</p>
                        <button class="orderBtn" onclick="orderLink()">주문하기</button>
                    </div>
                </div>
                <div class="menus">
                    <div>
                        <a href="/product/iceCream/verryVerryStrawberry.do"><img src="../resources/image/product/icecream/베리베리_스트로베리.png" alt="베리베리 스트로베리"></a>
                        <p class="iceName">베리베리 스트로베리</p>
                        <p class="iceType">CONE & CUP</p>
                        <button class="orderBtn" onclick="orderLink()">주문하기</button>
                    </div>
                    <div>
                        <a href="/product/iceCream/redRasberrySorbet.do"><img src="../resources/image/product/icecream/레드_라즈베리_소르베.png" alt="레드 라즈베리 소르베"></a>
                        <p class="iceName">레드 라즈베리 소르베</p>
                        <p class="iceType">CONE & CUP</p>
                        <button class="orderBtn" onclick="orderLink()">주문하기</button>
                        
                    </div>
                    <div>
                        <a href="/product/iceCream/blackSorbet.do"><img src="../resources/image/product/icecream/블랙소르베.png" alt="블랙소르베"></a>
                        <p class="iceName">블랙소르베</p>
                        <p class="iceType">CONE & CUP</p>
                        <button class="orderBtn" onclick="orderLink()">주문하기</button>
                    </div>
                </div>
                <div class="menus">
                    <div>
                        <a href="/product/iceCream/loveStruckStrawberry.do"><img src="../resources/image/product/icecream/사랑에_빠진_딸기.png" alt="사랑에 빠진 딸기"></a>
                        <p class="iceName">사랑에 빠진 딸기</p>
                        <p class="iceType">CONE & CUP</p>
                        <button class="orderBtn" onclick="orderLink()">주문하기</button>
                    </div>
                    <div>
                        <a href="/product/iceCream/shootingStar.do"><img src="../resources/image/product/icecream/슈팅스타.png" alt="슈팅스타"></a>
                        <p class="iceName">슈팅스타</p>
                        <p class="iceType">CONE & CUP</p>
                        <button class="orderBtn" onclick="orderLink()">주문하기</button>
                        
                    </div>
                    <div>
                        <a href="/product/iceCream/fritzCoffeeIceCream.do"><img src="../resources/image/product/icecream/프릳츠_커피_아이스크림.png" alt="프릳츠 커피 아이스크림"></a>
                        <p class="iceName">프릳츠 커피 아이스크림</p>
                        <p class="iceType">CONE & CUP</p>
                        <button class="orderBtn" onclick="orderLink()">주문하기</button>
                    </div>
                </div>
                <div class="menus">
                    <div>
                        <a href="/product/iceCream/almondBonBon.do"><img src="../resources/image/product/icecream/아몬드_봉봉.png" alt="아몬드 봉봉"></a>
                        <p class="iceName">아몬드 봉봉</p>
                        <p class="iceType">CONE & CUP</p>
                        <button class="orderBtn" onclick="orderLink()">주문하기</button>
                    </div>
                    <div>
                        <a href="/product/iceCream/vanilla.do"><img src="../resources/image/product/icecream/아이스_노티드_우유 생크림.png" alt="아이스 노티드 우유 생크림"></a>
                        <p class="iceName">아이스 노티드 우유 생크림</p>
                        <p class="iceType">CONE & CUP</p>
                        <button class="orderBtn" onclick="orderLink()">주문하기</button>
                        
                    </div>
                    <div>
                        <a href="/product/iceCream/vanilla.do"><img src="../resources/image/product/icecream/엄마는_외계인.png" alt="엄마는 외계인"></a>
                        <p class="iceName">엄마는 외계인</p>
                        <p class="iceType">CONE & CUP</p>
                        <button class="orderBtn" onclick="orderLink()">주문하기</button>
                    </div>
                </div>
                <div class="menus">
                    <div>
                        <a href="/product/iceCream/vanilla.do"><img src="../resources/image/product/icecream/오레오_쿠키_앤_카라멜.png" alt="오레오 쿠키 앤 카라멜"></a>
                        <p class="iceName">오레오 쿠키 앤 카라멜</p>
                        <p class="iceType">CONE & CUP</p>
                        <button class="orderBtn" onclick="orderLink()">주문하기</button>
                    </div>
                    <div>
                        <a href="/product/iceCream/vanilla.do"><img src="../resources/image/product/icecream/오레오_쿠키_앤_크림.png" alt="오레오 쿠키 앤 크림"></a>
                        <p class="iceName">오레오 쿠키 앤 크림</p>
                        <p class="iceType">CONE & CUP</p>
                        <button class="orderBtn" onclick="orderLink()">주문하기</button>
                        
                    </div>
                    <div>
                        <a href="/product/iceCream/vanilla.do"><img src="../resources/image/product/icecream/오레오_쿠키_앤_크림치즈.png" alt="오레오 쿠키 앤 크림치즈"></a>
                        <p class="iceName">오레오 쿠키 앤 크림치즈</p>
                        <p class="iceType">CONE & CUP</p>
                        <button class="orderBtn" onclick="orderLink()">주문하기</button>
                    </div>
                </div>
                <div class="menus">
                    <div>
                        <a href="/product/iceCream/vanilla.do"><img src="../resources/image/product/icecream/월넛.png" alt="월넛"></a>
                        <p class="iceName">월넛</p>
                        <p class="iceType">CONE & CUP</p>
                        <button class="orderBtn" onclick="orderLink()">주문하기</button>
                    </div>
                    <div>
                        <a href="/product/iceCream/vanilla.do"><img src="../resources/image/product/icecream/이상한_나라의_솜사탕.png" alt="이상한 나라의 솜사탕"></a>
                        <p class="iceName">이상한 나라의 솜사탕</p>
                        <p class="iceType">CONE & CUP</p>
                        <button class="orderBtn" onclick="orderLink()">주문하기</button>
                        
                    </div>
                    <div>
                        <a href="/product/iceCream/vanilla.do"><img src="../resources/image/product/icecream/자모카_아몬드훠지.png" alt="자모카 아몬드 훠지"></a>
                        <p class="iceName">자모카 아몬드 훠지</p>
                        <p class="iceType">CONE & CUP</p>
                        <button class="orderBtn" onclick="orderLink()">주문하기</button>
                    </div>
                </div>
                <div class="menus">
                    <div>
                        <a href="/product/iceCream/vanilla.do"><img src="../resources/image/product/icecream/청포도_샤베트.png" alt="청포토 샤베트"></a>
                        <p class="iceName">청포토 샤베트</p>
                        <p class="iceType">CONE & CUP</p>
                        <button class="orderBtn" onclick="orderLink()">주문하기</button>
                    </div>
                    <div>
                        <a href="/product/iceCream/vanilla.do"><img src="../resources/image/product/icecream/체리쥬빌레.png" alt="체리쥬빌레"></a>
                        <p class="iceName">체리쥬빌레</p>
                        <p class="iceType">CONE & CUP</p>
                        <button class="orderBtn" onclick="orderLink()">주문하기</button>
                        
                    </div>
                    <div>
                        <a href="/product/iceCream/vanilla.do"><img src="../resources/image/product/icecream/초코나무_숲.png" alt="초코나무 숲"></a>
                        <p class="iceName">초코나무 숲</p>
                        <p class="iceType">CONE & CUP</p>
                        <button class="orderBtn" onclick="orderLink()">주문하기</button>
                    </div>
                </div>
                <div class="menus">
                    <div>
                        <a href="/product/iceCream/vanilla.do"><img src="../resources/image/product/icecream/초코넛_마카다미아.png" alt="초코넛 마카다미아"></a>
                        <p class="iceName">초코넛 마카다미아</p>
                        <p class="iceType">CONE & CUP</p>
                        <button class="orderBtn" onclick="orderLink()">주문하기</button>
                    </div>
                    <div>
                        <a href="/product/iceCream/vanilla.do"><img src="../resources/image/product/icecream/초콜릿.png" alt="초콜릿"></a>
                        <p class="iceName">초콜릿</p>
                        <p class="iceType">CONE & CUP</p>
                        <button class="orderBtn" onclick="orderLink()">주문하기</button>
                        
                    </div>
                    <div>
                        <a href="/product/iceCream/vanilla.do"><img src="../resources/image/product/icecream/초콜릿_무스.png" alt="초콜릿 무스"></a>
                        <p class="iceName">초콜릿 무스</p>
                        <p class="iceType">CONE & CUP</p>
                        <button class="orderBtn" onclick="orderLink()">주문하기</button>
                    </div>
                </div>
                <div class="menus">
                    <div>
                        <a href="/product/iceCream/vanilla.do"><img src="../resources/image/product/icecream/춘식이가_반할수박에.png" alt="춘식이가 반할수박에"></a>
                        <p class="iceName">춘식이가 반할수박에</p>
                        <p class="iceType">CONE & CUP</p>
                        <button class="orderBtn" onclick="orderLink()">주문하기</button>
                    </div>
                    <div>
                        <a href="/product/iceCream/vanilla.do"><img src="../resources/image/product/icecream/투둠_초콜릿_프레첼.png" alt="투둠 초콜릿 프레첼"></a>
                        <p class="iceName">투둠 초콜릿 프레첼</p>
                        <p class="iceType">CONE & CUP</p>
                        <button class="orderBtn" onclick="orderLink()">주문하기</button>
                        
                    </div>
                    <div>
                        <a href="/product/iceCream/vanilla.do"><img src="../resources/image/product/icecream/피스타치오_아몬드.png" alt="피스타치오 아몬드"></a>
                        <p class="iceName">피스타치오 아몬드</p>
                        <p class="iceType">CONE & CUP</p>
                        <button class="orderBtn" onclick="orderLink()">주문하기</button>
                    </div>
                </div>
            </div>
            <div>
            	<button id="inserBtn" type="button" onclick="productInsert()">상품 등록하기</button>
            </div>
        </section>
        <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
    </div>

    <script>
    	<jsp:include page="/WEB-INF/views/include/headerLinkFunction.jsp"/>
    </script>
</html>