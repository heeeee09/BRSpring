<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        function logoLink() {
            location.href = "/index.jsp";
        }
        function loginLink() {
            location.href = "/member/login.do";
        }
        function mypageLink() {
            location.href = "/member/myPage.do?memberId="+'${memberId}';
        }
        function basketLink() {
            location.href = "./member/myBasket.html";
        }
        function menuLink() {
            location.href = "/product/menu.do";
        }
        function storeLink() {
            location.href = "./etc/storeSearch.html";
        }