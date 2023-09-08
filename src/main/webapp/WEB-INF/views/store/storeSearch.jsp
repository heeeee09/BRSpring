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
	</head>
	<body>
		<input type="hidden" value="sList">
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
			<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
	    </div>
	    <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBEAgVkVw2ATyuPxCvBQ2xROvykAfaMrpA&callback=initMap&region=kr"></script>
	    <script>
	    <jsp:include page="/WEB-INF/views/include/headerLinkFunction.jsp"/>
	    
// 	        function initMap() {
// 	        var seoul = { lat: 37.5543, lng: 126.9712 };
// 	        var map = new google.maps.Map(
// 	            document.getElementById('map'), {
// 	   			disableDefaultUI:true,
// 	   			zoomControl: true,
// 	            zoom: 15,
// 	            center: seoul
// 	            });
	        
// 		     // DB에서 가져온 위도와 경도 정보를 반복하여 마커 생성
// 		     var locations = [
// 		         { lat: 37.5543, lng: 126.9712 }, // 예시 데이터, 실제 데이터로 바꿔주세요
// 		         // 추가 데이터...
// 		     ];
		
// 		     for (var i = 0; i < locations.length; i++) {
// 		         var marker = new google.maps.Marker({
// 		             position: locations[i],
// 		             map: map,
// 		             title: '매장 ' + i // 마커에 툴팁 텍스트 설정 (선택사항)
// 		         });
// 		     }
		        
// 		        }
	    
	//         function initMap() {
	//         var seoul = { lat: 37.5642135 ,lng: 127.0016985 };
	//         var store = {lat: 37.566554, lng: 126.978546};
	//         var defaultOption = {
	//         		disableDefaultUI:true,
	//     			zoomControl: true
	//         }
	//         var map = new google.maps.Map(
	//             document.getElementById('map'), defaultOption {
	//             zoom: 10,
	//             center: seoul
	//             });
	        
	//         var marker = new google.maps.Marker({position: store, map: map});
	        
	//         }
	        
	        
	        
	//         function initMap() {
	//             var map = new google.maps.Map(document.getElementById('map'), {
	//                 center: { lat: 37.7749, lng: -122.4194 }, // 초기 맵 중심 좌표 설정
	//                 zoom: 10 // 초기 줌 레벨 설정
	//             });
	
	//             // DB에서 가져온 위도와 경도 정보를 반복하여 마커 생성
	//             var locations = [
	//                 { lat: 37.7749, lng: -122.4194 }, // 예시 데이터, 실제 데이터로 바꿔주세요
	//                 { lat: 37.7752, lng: -122.4186 }, // 예시 데이터, 실제 데이터로 바꿔주세요
	//                 // 추가 데이터...
	//             ];
	
	//             for (var i = 0; i < locations.length; i++) {
	//                 var marker = new google.maps.Marker({
	//                     position: locations[i],
	//                     map: map,
	//                     title: '매장 ' + i // 마커에 툴팁 텍스트 설정 (선택사항)
	//                 });
	//             }
	//         }
	    </script>
	</body>
</html>