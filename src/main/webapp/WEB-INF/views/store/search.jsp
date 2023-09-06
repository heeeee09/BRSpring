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
	    <link rel="stylesheet" href="../resources/css/storeSearch.css">
	    <link rel="stylesheet" href="../resources/css/common/reset.css">
	    <link rel="stylesheet" href="../resources/css/common/logo_nav_footer.css">
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=b06988fd7f30cd45bebd62c3b1a52a32"></script>     
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
	<script type="text/javascript">
    <jsp:include page="/WEB-INF/views/include/headerLinkFunction.jsp"/>
		
		var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
		var options = { //지도를 생성할 때 필요한 기본 옵션
			center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
			level: 3 //지도의 레벨(확대, 축소 정도)
		};
	
		var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
		
		// 마커가 표시될 위치입니다 
		var markerPosition  = new kakao.maps.LatLng(33.450701, 126.570667); 

		// 마커를 생성합니다
		var marker = new kakao.maps.Marker({
		    position: markerPosition
		})
		    
		 // 마커가 지도 위에 표시되도록 설정합니다
	    marker.setMap(map);

	    // 아래 코드는 지도 위의 마커를 제거하는 코드입니다
	    // marker.setMap(null); 	
	    
	    // 마커를 표시할 위치와 title 객체 배열입니다 
		var positions = [
		    {
		        title: '카카오', 
		        latlng: new kakao.maps.LatLng(33.450705, 126.570677)
		    },
		    {
		        title: '생태연못', 
		        latlng: new kakao.maps.LatLng(33.450936, 126.569477)
		    },
		    {
		        title: '텃밭', 
		        latlng: new kakao.maps.LatLng(33.450879, 126.569940)
		    },
		    {
		        title: '근린공원',
		        latlng: new kakao.maps.LatLng(33.451393, 126.570738)
		    }
		];
	    
        var data = ${sList };
        console.log(data);
//         display.innerHTML = 'Title: ' + sList.title + '<br>' +
//                             'Lat: ' + sList.lat + '<br>' +
//                             'Lng: ' + sList.lng;
		
		// 마커 이미지의 이미지 주소입니다
		var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
		    
		for (var i = 0; i < positions.length; i ++) {
		    
		    // 마커 이미지의 이미지 크기 입니다
		    var imageSize = new kakao.maps.Size(24, 35); 
		    
		    // 마커 이미지를 생성합니다    
		    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
		    
		    // 마커를 생성합니다
		    var marker = new kakao.maps.Marker({
		        map: map, // 마커를 표시할 지도
		        position: positions[i].latlng, // 마커를 표시할 위치
		        title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
		        image : markerImage // 마커 이미지 
		    });
		}
	</script>
</body>
</html>