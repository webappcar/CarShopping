<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String car_id = (String)request.getAttribute("car_id");
%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>글삭제</title>
<script>
	alert("글이 성공적으로 삭제되었습니다.");
	location.href="/member/productView?car_id=<%=car_id%>";
</script>
</head>
<body>
</body> 
</html>