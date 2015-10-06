<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>리뷰보기</title>
<%
	String pageNo = "1";//(String)request.getAttribute("pageNo");
	int currentPage = Integer.parseInt(pageNo);
%>
</head>
<body>
<c:set var="pageNo" value="<%= pageNo %>"/>
<c:if test = "${empty review}">
존재하지 않는 글입니다.
</c:if>
<c:if test="${!empty review}">
		<table cellpadding="20" border="0"  width="80%" align="center">
			<tr><td>리 뷰</td></tr>
			<tr><td>
			<table width="100%" align="center" border="1"  >
				<tr>
					<td>제목</td><td>${review.title }</td>
				</tr>
				<tr>
					<td>작성자</td><td>${review.name }</td>
				</tr>
				<tr>
					<td>작성일</td><td>${review.register_date }</td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea rows="8" cols="70" disabled="disabled" style="background-color: white; color: black;">${reviewContent.review_content }</textarea></td>
				</tr>
				<tr>
			<td colspan="2">
			<a href="javascript:goUpdate(${review.writing_id})">[수정]</a>
			<a href="javascript:goDelete(${review.writing_id})">[삭제]</a>
<!-- 			<a href="javascript:goList()">[목록]</a> -->
			</td>
		</tr>
		</table>
	</td></tr>
	<tr><td></td></tr>
</table>

</c:if>


<script language="JavaScript">
function goUpdate(id){
	document.move.action = "/review/update/"+id;
	document.move.submit();
}
function goDelete(id){
	document.move.action="/review/delete/"+id;
	document.move.submit();
}
function goList(){
	document.move.action="";
	document.move.submit();
}
</script>
<form name="move" method="post">
<input type="hidden" name="writing_id" value="${review.writing_id }"/>
<input type="hidden" name="pageNo" value="${pageNo}" />
</form>

</body> 
</html>