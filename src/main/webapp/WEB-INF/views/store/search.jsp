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
                        <a href="#"><img src="../resources/image/search.png" alt="" id="searchIcon"></a>
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
		<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
    </div>
	<script type="text/javascript">
    <jsp:include page="/WEB-INF/views/include/headerLinkFunction.jsp"/>
		
		var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
		var options = { //지도를 생성할 때 필요한 기본 옵션
			center: new kakao.maps.LatLng(37.715133, 126.734086), //지도의 중심좌표.
			level: 3 //지도의 레벨(확대, 축소 정도)
		};
	
		var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
		
		// 마커가 표시될 위치입니다 
// 		var markerPosition  = new kakao.maps.LatLng(33.450701, 126.570667); 

		// 마커를 생성합니다
		var marker = new kakao.maps.Marker({
		    position: markerPosition
		})
		    
		 // 마커가 지도 위에 표시되도록 설정합니다
	    marker.setMap(map);

	    // 아래 코드는 지도 위의 마커를 제거하는 코드입니다
	    // marker.setMap(null); 	
	    
	    // 컨트롤러에서 보낸 데이터를 저장받는 변수
	    
    // JSON 데이터를 JavaScript 배열로 파싱합니다.
    var jsonDataArray = ${jSList };

        var positions = [];
    // 배열을 반복하여 모든 데이터를 처리합니다.
    for (var i = 0; i < jsonDataArray.length; i++) {
        var storeData = jsonDataArray[i];

        // 필요한 정보 추출
        var storeNo = storeData.storeNo;
        var storeName = storeData.storeName;
        var storeAddress = storeData.storeAddress;
        var storeTell = storeData.storeTell;
        var storeLat = storeData.storeLat;
        var storeLng = storeData.storeLng;

        // 추출한 정보를 원하는 방식으로 사용합니다.
        
//         // 데이터들을 저장할 배열 선언

// 여기에서 필요한 작업을 수행할 수 있습니다.
	         positions.push({
	             title: storeName,
	             latlng: new kakao.maps.LatLng(storeLat, storeLng)
	         });
	     }        

//         // 데이터를 저장한 변수를 positions 배열에 담음
//         var positions = [{
//         	title: title, 
//             latlng: new kakao.maps.LatLng(parseFloat(lat), parseFloat(lng))
// 		    }
//         ]
        console.log(positions);	    
        

// 	     // 100개의 데이터를 추가하는 for 루프
// 	     for (var i = 0; i < ${jSize }; i++) {
//         var title =  "${title }";
//         var address =  "${address }";
//         var lat =  "${lat }";
//         var lng =  "${lng }";
//         console.log(${size})
// // 	         var title = "데이터 " + (i + 1);
// // 	         var lat = Math.random() * 90; // 임의의 위도 생성
// // 	         var lng = Math.random() * 180; // 임의의 경도 생성
	         
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