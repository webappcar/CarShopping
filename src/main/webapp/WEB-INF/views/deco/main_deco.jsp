<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sitemesh" tagdir="/WEB-INF/tags/sitemesh" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>main_deco</title>
<%@ include file="/WEB-INF/views/common.jspf" %>

<style type="text/css">
	#divsize {height: auto; width: 900px; margin: auto;}
	#cssmenu {float: center;}
	#cssmenu ul {float: center;}
	#logindiv {margin: 10px;}
	#loginbtn {width: 70px; height: auto;}
	#widthDiv {height: 100px;}
</style>

<sitemesh:write property="head"/>

</head>
<body>
<div id="divsize">
	<!-- 메뉴 -->
		<div id="cssmenu" class="w3-container align-center">
			<ul>
				<li><a href="/index">Home</a></li>
				<li class="active has-sub"><a href="#">대형</a>
					<ul>
						<li class="has-sub"><a href="#">기아자동차</a></li>
						<li class="has-sub"><a href="#">쉐보레</a></li>
						<li class="has-sub"><a href="#">현대자동차</a></li>
					</ul>
				</li>
				<li class="active has-sub"><a href="#">준중형</a>
					<ul>
						<li class="has-sub"><a href="#">기아자동차</a></li>
						<li class="has-sub"><a href="#">쉐보레</a></li>
						<li class="has-sub"><a href="#">현대자동차</a></li>
					</ul>
				</li>
				<li class="active has-sub"><a href="#">소형</a>
					<ul>
						<li class="has-sub"><a href="#">기아자동차</a></li>
						<li class="has-sub"><a href="#">쉐보레</a></li>
						<li class="has-sub"><a href="#">현대자동차</a></li>
					</ul>
				</li>
				<li><a href="/QA/list">QnA</a></li>
				<li><a href="/admin/memberPage">AdminPage</a></li>
			</ul>
		</div>
		<div id="widthDiv">
	<!-- 로그인 -->
	<!-- 	<div class="form-group" id="logindiv"> -->
	<!-- 		<div class="col-sm-9" > -->
	<!-- 			AD or 아무거나 -->
	<!-- 		</div> -->
	<!-- 		<div class="col-sm-3"> -->
	<!-- 			<div> -->
	<!-- 				<input type="text" class="form-control" id="loginid" placeholder="아이디"/> -->
	<!-- 				<input type="password" class="form-control" id="password" placeholder="비밀번호"/> -->
	<!-- 			</div> -->
	<!-- 			<div> -->
	<!-- 				<span><a href="/memberJoin">회원가입</a></span> -->
	<!-- 				<button id="loginbtn">로그인</button> -->
	<!-- 			</div> -->
	<!-- 		</div> -->
	<!-- 	</div> -->
			
			<div class="form-group">
				<div class="col-sm-9">
					AD or 아무거나
				</div>
				<div class="col-sm-3">
					<div>
						NickName 님 환영합니다.
					</div>
					<div>
						로그아웃
						장바구니
						정보수정
					</div>
				</div>
			</div>
		</div>
	<sitemesh:write property="body"/>
	
	
	<footer border="1" class="w3-container">
		<h1>footer</h1>
	</footer>
</div>
</body>
</html>