<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <header>
            <div id="logo">
                <a href="#"><img id="logoimg" onclick="logoLink()" src="/resources/image/header_Logo.png"
                        alt="로고이미지"></a>
            </div>
            <div id="user-category">
            	<c:if test="${memberId == null}">
                <a href="#" onclick="loginLink()" style="color: #F04DA3">LOGIN</a>
                </c:if>
            	<c:if test="${memberId != null}">
            <div class="user">
                <a href="/member/logout.do" style="color: #F04DA3">LOGOUT</a>
            </div>
            <div class="user">
                <a href="#" onclick="mypageLink()">MYPAGE</a>
            </div>
            <div id="basket" class="user">
                <a href="#" onclick="basketLink()"><img id="basketlink" src="/resources/image/header_Basket_Img.png"
                        alt="장바구니 링크"></a>
            </div>
                </c:if>
                </div>
        </header>
        <nav class="navi">
          <ul id="menu">
              <li><a href="#" onclick="menuLink()">MENU</a></li>
              <li style="text-align: center;"><a href="#">영양정보 및 <br>알레르기</a></li>
              <li><a href="#">EVENT</a></li>
              <li><a href="#" onclick="storeLink()">STORE</a></li>
              <li><a href="#">BRAND</a></li>
              <li><a href="#">DELIVERY</a></li>
          </ul>
  	   	</nav>