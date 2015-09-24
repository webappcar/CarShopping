<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
<%@ include file="/WEB-INF/views/common.jspf" %>
</head>
<body>
<h1>Car Shopping Home...member...</h1><br>
Member List<br><br>
<c:forEach var="memberlist" items="${memberlist}">
	${memberlist.name} - ${memberlist.id}<br>
</c:forEach>
</body>
</html>