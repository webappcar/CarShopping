<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sitemesh" tagdir="/WEB-INF/tags/sitemesh" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>logo_deco</title>
<%@ include file="/WEB-INF/views/common.jspf" %>

<style type="text/css">
	#topmenu{
		height: 60px; 
		margin-top: 50px; 
		width: 900px; 
		margin-left: auto; 
		margin-right: auto;
	}
	#search {
		border: 5px inset; 
		border-color: #141414; 
		height: 50px; width:85%; 
		font-size: 20px; 
		font-weight: bold;
	}
	#searchbtn {height: 50px;}
	#searchCar {text-align: left;}
</style>
<sitemesh:write property="head"/>
</head>
<body>

<div id="topmenu">
	<div class="col-sm-3">
		<a href="/index"><img src="/img/mainlogo.png"/></a>
	</div>
	<div class="col-sm-6">
		<form id="searchCar" action="">
			<input type="text" id="search"/>
			<img src="/img/search.jpg">
		</form>
	</div>
	<div class="col-sm-3">
		<img src="/img/mark.png"/>
	</div>
</div>

<sitemesh:write property="body"/>

</body>
</html>