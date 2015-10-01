<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String pageNo = (String)request.getAttribute("pageNo");
%>
<script>
	alert("게시판에 새로운 글을 등록했습니다.");
	location.href="/qa/list/"+${pageNo};
</script>
<form name="move" method="post">
<input type="hidden" name="pageNo" value="${pageNo}" />
</form>