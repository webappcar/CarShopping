<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>memberJoin</title>
<%@ include file="/WEB-INF/views/common.jspf" %>
<style type="text/css">
	form {
		width: 400px;
		border-top: 1px double red;
		border-bottom: 1px double red;
	}
	
	.center {
		text-align: center;
		text-shadow: 5px 5px 1px blue;	
	}
	#member {
		margin: auto auto;
	}
	label[for^=gender], label[for^=hobby] {
		padding-left: 5px;
		padding-right: 10px;
		color: orange;
	}
</style>

<script type="text/javascript">
// 준비(ready) 헨들러
$(document).ready(function() {
	
	$('form11111111111111').slideToggle().slideToggle(1000)
			 .fadeOut(500).fadeIn(1000, function() {
				 $('label[for^=gender]').css('background-color', 'pink')
				 						.fadeOut(1000).fadeIn(1000);
			});
	
});

</script>
<style type="text/css">
	#register {width:400px; height: 600px; margin:auto;}
</style>
</head>
<body>

<h1 class="center"><a href="#"><spring:message code="member.regist.title"/></a></h1>

<form:form commandName="member" action="/member/memberJoin" method="post">
	
	<form:errors element="div"/>
	
	<!-- Id -->
	<div class="form-group">
		<label for="id"><spring:message code="member.regist.id"/></label>
		<form:input path="id" cssClass="form-control"/>
		<form:errors path="id"/>
	</div>
	<!-- Name -->
	<div class="form-group">
		<label for="name"><spring:message code="member.regist.name"/></label>
		<form:input path="name" cssClass="form-control"/>
		<form:errors path="name"/>
	</div>
	<!-- Password -->
	<div class="form-group">
		<label for="password"><spring:message code="member.regist.password"/></label>
		<form:input path="password" cssClass="form-control"/>
		<form:errors path="password"/>
	</div>
	<!-- Nick -->
	<div class="form-group">
		<label for="nickname"><spring:message code="member.regist.nickname"/></label>
		<form:input path="nickname" cssClass="form-control"/> <input type="button" value="중복확인">
		<form:errors path="nickname"/>
	</div>
	<!-- Email -->
	<div class="form-group">
		<label for="email"><spring:message code="member.regist.email"/></label>
		<form:input path="email" cssClass="form-control"/>
		<form:errors path="email"/>
	</div>
	<!-- Phone -->
	<div class="form-group">
		<label for="phone">전화번호</label>
		<form:input path="phone" cssClass="form-control"/>
		<form:errors path="phone"/>
	</div>
	<!-- Address -->
	<div class="form-group">
		<label for="address">주소</label>
		<form:input path="address" cssClass="form-control"/>
		<form:errors path="address"/>
	</div>
	<input type="submit" value="회원가입"/>
</form:form>

<br><br>

</body>
</html>