<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<c:if test="${sessionScope.ID == null }">
	<script>
		//alert("로그인을 해주세요");
		//location.href="login";
	</script>
</c:if>

<%
	String pageNo = (String)request.getAttribute("pageNo");
	String countQA = (String)request.getAttribute("countQA");
	String parent_id = (String)request.getAttribute("parent_id");
	String title= (String)request.getAttribute("title");
%>
<c:set var="pageNum" value="<%= pageNo %>"/>
<c:set var="level_no" value=""/>
<script type="text/javascript">
function validate(form){
	if(form.title.value == ""){
		alert("제목을 입력하세요."); return false;
	}else if(form.qacontent.value == ""){
		alert("내용을 입력하세요."); return false;
	}
}
</script>
</head>
<body>
<form action="/qa/insert" method="post" onsubmit="return validate()">
<!-- <form action="/qa/insert" method="post" enctype="multipart/form-data" onsubmit="return validate()"> -->
<input type="hidden" name="pageNo" value="${pageNo}" />
<input type="hidden" name="level_no" value="${ parentList.level_no+1}"  />
<input type="hidden" name="order_no" value="${ parentList.order_no+1}"  />
<c:if test="${! empty parentList.group_id }">
	<input type="hidden" name="group_id" value="${ parentList.group_id}"  />
</c:if>
<c:if test="${! empty parent_id }">
	<input type="hidden" name="parent_id" value="${ parent_id}"  />
</c:if>
<table width="80%" align="center"border="0" cellpadding="10">
	<tr><td>QnA 게시판</td></tr>
	<tr><td>
		<table width="100%" align="center" border="1">
			<tr>
				<td width="30%">글제목</td>
					<td>
					<input type="text" size="20" name="qa_title" value="<%=title%>">
				</td>
			</tr>
			<tr>
				<td>작성자</td>
<%-- 				<td><input type="text" size="20" name="id" value="${sessionScope.ID }" ></td> --%>
				<td><input type="text" size="20" name="id" value="${sessionScope.ID }" ></td>
			</tr>
			<tr>
				<td>썸네일 이미지</td>
				<td><input type="file" name="image" /></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="8" cols="90" name="qa_content"></textarea></td>
			</tr>
		</table>
	</td></tr>	
			<tr>
				<td align="center" colspan="2">
				<input type="submit" value="글올리기"/> 
				<input type="button" value="취소" onclick="javascript:history.go(-1)"/>
				</td>
			</tr>
	<tr><td></td></tr>
</table>
 </form>
</body> 
</html>