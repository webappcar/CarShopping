<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
	String car_id = (String)request.getAttribute("car_id");
	String from_review = (String)request.getAttribute("from_review");
	String from_write = (String)request.getAttribute("from_write");
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
<%@ include file="/WEB-INF/views/common.jspf" %>
<c:if test="${!empty idPasswordNotMatch}">
<script Language="Javascript">
	function idPasswordNotMatch() {
		alert("아이디와 비밀번호를 확인하세요.");
	}
</script>
</c:if>
</head>
<body onload="idPasswordNotMatch();">
<h1>Login</h1>

<form:form commandName="login" action="/member/login" method="POST" cssClass="w3-container">
	<input type="hidden" name="car_id" value="<%=car_id %>"/>
	<input type="hidden" name="from_review" value="<%=from_review %>"/>
	<input type="hidden" name="from_write" value="<%=from_write %>"/>
	<form:errors element="div"/>
	<!-- Id -->
	<div class="w3-group">
		<form:input path="id" cssClass="w3-input" required="required"/>
		<label for="id" class="w3-label">ID</label>
	</div>
	<!-- Password -->
	<div class="w3-group">
		<form:password path="password" cssClass="w3-input" required="required"/>
		<label for="password" class="w3-label">Password</label>
	</div>

	<!-- Remember -->
<%-- 	<div>
		<label for="remember" class="w3-checkbox">
		<c:choose>
			<c:when test="${login.remember eq true }">
				<input id="remember" name="remember" type="checkbox" value="true" checked="checked"/>
			</c:when>
			<c:otherwise>
				<input id="remember" name="remember" type="checkbox" value="true"/>
			</c:otherwise>
		</c:choose>
		<span class="w3-checkmark"></span> Remember
		</label>
	</div> --%>
	<input class="w3-btn" type="submit" value="Login"/>
</form:form>

</body>
</html>