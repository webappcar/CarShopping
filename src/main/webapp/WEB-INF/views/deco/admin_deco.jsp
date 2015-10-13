<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sitemesh" tagdir="/WEB-INF/tags/sitemesh" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>admin_deco</title>
<%@ include file="/WEB-INF/views/common.jspf" %>
<c:if test="${sessionScope.ID != 'admin' }">
	<script>
		alert("비정상적인 접근입니다.");
		location.href="javascript:history.go(-1)";
	</script>
</c:if>
<style type="text/css">
	#adminmain {margin-left: 180px !important;}
</style>

<sitemesh:write property="head"/>

</head>
<body>

	<nav class="w3-sidenav w3-white w3-card-2" style="width:180px">
	  <header class="w3-container">
	  	<h5>운영자메뉴</h5>
	  </header>
	  <a href="/index">메인으로</a>
	  <a href="memberPage">회원관리</a>		
	  <a href="productPage">상품관리</a>		
	  <a href="orderPage">주문관리</a>		
	  <a href="boardPage">게시판관리</a>				
	</nav>
	
	<div id="adminmain">
		<sitemesh:write property="body"/>
	</div>
</body>
</html>