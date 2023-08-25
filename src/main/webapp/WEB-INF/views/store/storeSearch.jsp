<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>매장 검색</title>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../resource/css/storeSearch.css">
    <link rel="stylesheet" href="../resource/css/reset.css">
    <link rel="stylesheet" href="../resource/css/logo_nav_footer.css">
</head>
<body>
    <div id="container">
        <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
        <section>
            <div id="searchPage">
                <p>매장 검색</p>
                <div id="searchBox">
                    <div>
                        <div>
                        <select name="" id="">
                            <option value="">서울</option>
                            <option value="">경기도</option>
                        </select>
                        <select name="" id="">
                            <option value="">종로구</option>
                            <option value="">중구</option>
                            <option value="">용산구</option>
                        </select>
                        <a href="#"><img src="../resource/image/search.png" alt="" id="searchIcon"></a>
                        </div>
                        <div id="line1"></div>
                        <div class="searchList">
                            <div>
                                <p class="storeName">광화문점</p>
                                <p class="storeAddress">서울 종로구 청진동 <br>
                                    종로 5길 Tower8 1층</p>
                                    <p class="storeTell">02-6226-8130</p>
                            </div>
                                <button id="storeBtn"><a href="https://goo.gl/maps/FSXN8e3Surd1CY2n6"  target="_blank" class="whiteFont">상세<br>보기</a></button>
                            </div>
                            <div id="line1"></div>
                        <div class="searchList">
                            <div>
                                <p class="storeName">종로2가점</p>
                                <p class="storeAddress">서울 종로구 관철동 <br>
                                    종로 12길 9</p>
                                    <p class="storeTell">02-733-3130</p>
                            </div>
                                <button id="storeBtn"><a href="https://goo.gl/maps/FSXN8e3Surd1CY2n6"  target="_blank" class="whiteFont">상세<br>보기</a></button>
                            </div>
                            <div id="line1"></div>
                    </div>
                    <div id="lineCol"></div>
                    <div id="map">
                    </div>
                </div>
            </div>
        </section>
        <footer class="flex">
            <section>
                <ul id="bottomMenu1" class="footers">
                    <li><a href="#">1:1 문의</a></li>
                    <li><a href="#">자주묻는질문</a></li>
                    <li><a href="#">이용약관</a></li>
                    <li><a href="#">개인정보처리방침</a></li>
                    <li><a href="#">위치서비스기반이용약관</a></li>
                </ul>
                <ul id="bottomMenu2">
                    <li>사업자 등록번호 : 303-81-09535 비알코리아(주) 대표이사 이주연
                        서울특별시 서초구 남부순환로 2620(양재동 11-149번지)
                    </li>
                    <li>TEL : 080-555-3131 개인정보관이책임자 : 김경우</li>
                    <li>Copyrightⓒ 2016 BRKOREA Company. All Rights Reserved.</li>
                </ul>
            </section>
        </footer>
    </div>
    <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBEAgVkVw2ATyuPxCvBQ2xROvykAfaMrpA&callback=initMap&region=kr"></script>
    <script>
    <jsp:include page="/WEB-INF/views/include/headerLinkFunction.jsp"/>
        function initMap() {
        var seoul = { lat: 37.5642135 ,lng: 127.0016985 };
        var map = new google.maps.Map(
            document.getElementById('map'), {
            zoom: 12,
            center: seoul
            });
        
        }
    </script>
</body>
</html>