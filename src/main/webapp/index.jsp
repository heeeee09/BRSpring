<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>베스킨라빈스</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./resources/css/index.css">
    <link rel="stylesheet" href="./resources/css/common/reset.css">
    <link rel="stylesheet" href="/resources/css/common/logo_nav_footer.css">
</head>
<body>
    <div id="container">
		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>      
        <main>
            <section id="main1" class="mains">
                <a href="./product/menuDetail_10_CottonCandy.html"><img id="monthFlavor" src="./resources/image/main/main_Month_Flavor.png" alt=""></a>
            </section>
            <section id="main2" class="mains">
                <div id="eventImg">
                    <div id="slide0" class="slides">
                        <a href="./product/menuDetail_11_ChocoTree.html"><img src="./resources/image/main/main_Event_1.png" alt=""></a>
                    </div>
                    <div id="slide1" class="slides">
                        <a href="./product/menuDetail_05_windy.html"><img src="./resources/image/main/main_Event_2.png" alt=""></a>
                    </div>
                    <div id="slide2" class="slides">
                        <img src="./resources/image/main/main_Event_3.png" alt="">
                    </div>
                    <div id="slide3" class="slides">
                        <img src="./resources/image/main/main_Event_4.png" alt="">
                    </div>

                    <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
                    <a class="next" onclick="plusSlides(1)">&#10095;</a>
                    <br>
                    <div style="text-align:center">
                        <span class="dot" onclick="currentSlide(1)"></span>
                        <span class="dot" onclick="currentSlide(2)"></span>
                        <span class="dot" onclick="currentSlide(3)"></span>
                        <span class="dot" onclick="currentSlide(4)"></span>
                    </div>
                </div>
            </section>
            <div class="mainHeaders">
                <p id="bestMenu">BEST MENU</p>
            </div>
            <section id="main3" class="mains">
                <!-- // 베스트 맛 소개 -->
                <div id="bfLeft" class="bestFlavors">
                    <a href="./product/menuDetail_03_Rainbow.html"><img class="bfImg" src="/resources/image/menu/레인보우 샤베트.jpg" alt="레인보우 샤베트"></a>
                    <div class="img-caption">레인보우 샤베트</div>
                </div>
                <div id="bfCenter" class="bestFlavors">
                    <a href="./product/menuDetail_05_windy.html"><img class="bfImg" src="/resources/image/menu/바람과 함께 사라지다.jpg" alt="레인보우 샤베트"></a>
                    <div class="img-caption">바람과 함께 사라지다</div>
                </div>
                <div id="bfRight" class="bestFlavors">
                    <a href="./product/menuDetail_09_MomIsAlien.html"><img class="bfImg" src="/resources/image/menu/엄마는외계인.jpg" alt="레인보우 샤베트"></a>
                    <div class="img-caption">엄마는 외계인</div>
                </div>
            </section>
            <div class="mainHeaders">
                <p id="withBr">WITH BASKIN ROBBINS</p>
            </div>
            <section id="main4" class="mains">
                <!-- // SNS 이동 -->
                <div id="" class="SNS">
                    <a href="https://www.facebook.com/baskinrobbinskr/" target="_blank"><img src="/resources/image/main/sns_facebook.png"
                            alt=""></a>
                </div>
                <div id="" class="SNS">
                    <a href="https://twitter.com/BaskinrobbinsKR" target="_blank"><img src="/resources/image/main/sns_twitter.png"
                            alt=""></a>
                </div>
                <div id="" class="SNS">
                    <a href="https://blog.naver.com/brgirl31" target="_blank"><img src="/resources/image/main/sns_blog.png" alt=""></a>
                </div>
                <div id="" class="SNS">
                    <a href="https://www.instagram.com/baskinrobbinskorea/" target="_blank"><img
                            src="./resources/image/main/sns_instagram.png" alt=""></a>
                </div>
                <div id="" class="SNS">
                    <a href="https://www.youtube.com/user/baskinrobbinskorea" target="_blank"><img
                            src="./resources/image/main/sns_youtube.png" alt=""></a>
                </div>
                <div id="" class="SNS">
                    <a href="https://pf.kakao.com/_xjXcmM" target="_blank"><img src="/resources/image/main/sns_kakaotalk.png" alt=""></a>
                </div>
            </section>
        </main>
			<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
    </div>
    <script>
		<jsp:include page="/WEB-INF/views/include/headerLinkFunction.jsp"/>

        var slideIndex = 1;
        showSlides(slideIndex);

        function plusSlides(n) {
            showSlides(slideIndex += n);
        }

        function currentSlide(n) {
            showSlides(slideIndex = n);
        }

        function showSlides(n) {
            var i;
            var slides = document.getElementsByClassName("slides");
            var dots = document.getElementsByClassName("dot");
            if (n > slides.length) { slideIndex = 1 }
            if (n < 1) { slideIndex = slides.length }
            for (i = 0; i < slides.length; i++) {
                slides[i].style.display = "none";
            }
            for (i = 0; i < dots.length; i++) {
                dots[i].className = dots[i].className.replace(" active", "");
            }
            slides[slideIndex - 1].style.display = "block";
            dots[slideIndex - 1].className += " active";
            setTimeout(function() {
            	showSlides(slideIndex += 1);
            }, 2500);
        }


    </script>
</body>
</html>