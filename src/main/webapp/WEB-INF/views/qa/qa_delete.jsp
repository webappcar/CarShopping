<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>글삭제</title>
<%
	String pageNo = (String)request.getAttribute("pageNo");
%>
<c:set var="pageNo" value="<%= pageNo %>"/>
<c:choose>
     <c:when test="${sessionScope.ID == null}">
	   <script>
		   alert("로그인을 해주세요");
		   location.href="/member/login";
	   </script>
     </c:when>
     <c:otherwise>
         <c:if test="${sessionScope.ID != qaContentList.id }">
	         <script>
		         alert("권한이 없습니다.");
		         location.href="javascript:history.go(-1)";
	         </script>
         </c:if>     
     </c:otherwise>
</c:choose>
</head>
<body>
<form action="/qa/deleteQA" method="post">
<input type="hidden" name="pageNo" value="${pageNo}" />
	<table width="80%" align="center" border="0" cellpadding="10">
		<tr><td>QnA 게시판</td></tr>
		
		<tr><td>
			<table width="100%" align="center" border="1"> 
				<tr>
					<td>글제목</td>
					<td>${qaContentList.title}</td>
				</tr>
				<tr>
					<td>작성자</td>
					<td>${qaContentList.name }</td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea rows="8" cols="70" disabled="disabled" style="background-color: white; color: black;">${qaContent.qa_content }</textarea></td>
				</tr>
			</table>
		</td></tr>
		<tr>
			<td colspan="2" align="center"><h5>위 글을 삭제하시겠습니까?</h5></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="예" />
				<input type="button" value="아니오" onclick="javascript:history.go(-1)">
			</td>
		</tr>
		<tr><td></td></tr>
	</table>
</form>

</body> 
</html>	