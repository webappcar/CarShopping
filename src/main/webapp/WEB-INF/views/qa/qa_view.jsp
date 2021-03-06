<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>글보기</title>
<%
	String pageNo = (String)request.getAttribute("pageNo");
	int currentPage = Integer.parseInt(pageNo);
	session.getAttribute("ID");
%>
</head>
<body>
<c:set var="pageNo" value="<%= pageNo %>"/>
<c:if test = "${empty qaContentList }">
존재하지 않는 글입니다.
</c:if>
<c:if test="${!empty qaContentList}">
		<table cellpadding="20" border="0"  width="80%" align="center">
			<tr><td>QnA 게시판</td></tr>
			<tr><td>
			<table width="100%" align="center" border="1"  >
<!-- 				<tr> -->
<%-- 					<td width="30%">글번호</td><td>${qaContentList.writing_id }</td> --%>
<!-- 				</tr> -->
				<tr>
					<td>제목</td><td>${qaContentList.title }</td>
				</tr>
				<tr>
					<td>작성자</td><td>${qaContentList.name }</td>
				</tr>
				<tr>
					<td>작성일</td><td>${qaContentList.register_date }</td>
				</tr>
				<tr>
					<td>글내용</td>
					<td><textarea rows="8" cols="70" disabled="disabled" style="background-color: white; color: black;">${qaContent.qa_content }</textarea></td>
				</tr>
				<tr>
			<td colspan="2">
			<a href="javascript:goReply()">[답글달기]</a>
			<a href="javascript:goUpdate(${qaContentList.writing_id})">[수정]</a>
			<a href="javascript:goDelete(${qaContentList.writing_id})">[삭제]</a>
			<a href="javascript:goList()">[목록]</a>
			</td>
		</tr>
		</table>
	</td></tr>
	<tr><td></td></tr>
</table>

</c:if>


<script language="JavaScript">
function goReply(){
	document.move.action="/qa/write";
	document.move.submit();
}
function goUpdate(id){
	document.move.action = "/qa/update/"+id;
	document.move.submit();
}
function goDelete(id){
	document.move.action="/qa/delete/"+id;
	document.move.submit();
}
function goList(){
	document.move.action="/qa/list/"+${pageNo};
	document.move.submit();
}
</script>
<form name="move" method="post">
<input type="hidden" name="id" value="${qaContentList.writing_id }"/>
<input type="hidden" name="parent_id" value="${qaContentList.writing_id }"/>
<input type="hidden" name="group_id" value="${qaContentList.group_id }"/>
<input type="hidden" name="pageNo" value="${pageNo}" />
</form>

</body> 
</html>