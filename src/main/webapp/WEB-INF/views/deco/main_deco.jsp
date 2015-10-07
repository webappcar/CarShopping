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
	#divsize {width: 900px; margin: auto;}
	#cssmenu {float: center;}
	#cssmenu ul {float: center;}
	#logindiv {margin: 10px;}
	#loginbtn {width: 70px; height: auto;}
	#widthDiv {height: 100px;}
	#footerDiv {text-align: center; height: 100px; margin-top:100px; background-color: #EAEAEA;}
</style>

<script type="text/javascript">
	function dologin(){
		location.href = "/member/login";
	}
</script>

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
				<li><a href="/qa/list/1">QnA</a></li>
				<c:if test="${ID eq 'admin'}">
					<li><a href="/admin/memberPage">AdminPage</a></li>
				</c:if>
			</ul>
		</div>
		<div id="widthDiv">
			<div class="form-group">
				<div class="col-sm-9 slider autoplay">
					<div><img src="/img/ad/ad1.jpg" ></div>
					<div><img src="/img/ad/ad2.jpg" ></div>
					<div><img src="/img/ad/ad3.jpg" ></div>
				</div>
			<c:choose>
				<c:when test="${ID eq null}">
				<form action="/member/login" method="post">
					<div class="col-sm-3">
						<div>
							<input type="text" class="form-control" name="id" id="id" placeholder="아이디"/>
							<input type="password" class="form-control" name="password" id="password" placeholder="비밀번호"/>
						</div>
						<div>
							<span><a href="/member/memberJoin">회원가입</a></span>
							<input type="submit" value="로그인"/>
						</div>
					</div>
				</form>
				</c:when>
				<c:otherwise>
					<div class="col-sm-3">
						<div>
							NickName 님 환영합니다.
						</div>
						<div>
							<a href="/member/logout">로그아웃</a>
							장바구니
							정보수정
						</div>
					</div>
				</c:otherwise>
			</c:choose>
			</div>
		</div>
	<sitemesh:write property="body"/>
	
	
	<footer class="w3-container">
		<div id="footerDiv">
			<h1>Copyright (c) 2015</h1>
		</div>
	</footer>
</div>

<script type="text/javascript">
 	$('.autoplay').slick({
 		slidesToShow: 1,
		slidesToScroll: 1,
 		autoplay: true,
 		autoplaySpeed: 2000,
 	});
 </script>
</body>
</html>