<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>글삭제</title>
<%
	String pageNo = (String)request.getAttribute("pageNo");
	int isChild = 0;
	isChild= (int)request.getAttribute("isChild");	
	session.getAttribute("ID");
%>
<script>
<%
	if(isChild!=0) {		
%>
		alert("답변글이 있습니다.");
		window.history.back();
<%
	} else {
%>
		alert("글이 성공적으로 삭제되었습니다.");
		location.href="list/<%=pageNo %>";
<%
	}
%>
</script>
</head>
<body>
</body> 
</html>