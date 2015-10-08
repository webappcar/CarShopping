<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	String from_write = (String)request.getAttribute("from_write");

	String pageNo = (String)request.getAttribute("pageNo");
	String countQA = (String)request.getAttribute("countQA");
	String parent_id = (String)request.getAttribute("parent_id");
	String title = (String)request.getAttribute("title");
	
	if(title==null) title = "";
%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<c:if test="${sessionScope.ID == null}">
	<script language="javascript">
		function goLogin() {
			alert("로그인을 해주세요");
			document.goLogin.action = "/member/login/";
			document.goLogin.submit();
		}
	</script>
</c:if>
<c:set var="pageNum" value="<%= pageNo %>"/>
<c:set var="level_no" value=""/>
<script type="text/javascript">
function validate(form){
	if(form.qa_title.value == ""){
		alert("제목을 입력하세요."); return false;
	}else if(form.qa_content.value == ""){
		alert("내용을 입력하세요."); return false;
	}
}
</script>
</head>
<c:choose>
	<c:when test="${sessionScope.ID == null}">
		<body onload = "goLogin()">
	</c:when>
	<c:otherwise>
		<body>
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${sessionScope.ID == null }">
		<form name="goLogin" method="GET">
		<input type="hidden" name="from_write" value="true" />
		</form> 
	</c:when>
	<c:otherwise>
		<form name="write_qa" action="/qa/insert" method="post" onsubmit="return validate()">
			<input type="hidden" name="userId" value="${sessionScope.ID}" />
			<input type="hidden" name="pageNo" value="${pageNo}" />
			<input type="hidden" name="level_no" value="${ parentList.level_no+1}" />
			<input type="hidden" name="order_no" value="${ parentList.order_no+1}" />
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
							<td>${sessionScope.NAME}</td>
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
							<input type="button" value="취소" onclick="javascript:goQAList()"/>
							</td>
						</tr>
				<tr><td></td></tr>
			</table>
		</form>
	</c:otherwise>
</c:choose>
<script language="javascript">
	function goQAList() {
		document.write_qa.action = "/qa/list/1";
		document.write_qa.submit();		
	}
</script>
</body> 
</html>