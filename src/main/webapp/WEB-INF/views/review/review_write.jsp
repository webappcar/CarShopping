<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	String car_id = (String)request.getAttribute("car_id");
%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<c:if test="${sessionScope.ID == null }">
	<script>
		alert("로그인을 해주세요");
		location.href="/member/login";
	</script>
</c:if>
<script type="text/javascript">
function validate(form){
	if(form.review_title.value == ""){
		alert("제목을 입력하세요."); return false;
	}else if(form.review_content.value == ""){
		alert("내용을 입력하세요."); return false;
	}
}
</script>
</head>
<body>
<form action="/review/insert" method="post" onsubmit="return validate()">
<input type="hidden" name="user_id" value="${sessionScope.ID}" />
<input type="hidden" name="car_id" value="${car_id}" />
<table width="80%" align="center"border="0" cellpadding="10">
	<tr><td>리뷰쓰기</td></tr>
	<tr><td>
		<table width="100%" align="center" border="1">
			<tr>
				<td width="30%">제 목</td>
					<td>
					<input type="text" size="20" name="review_title" value="">
				</td>
			</tr>
			<tr>
				<td>리뷰작성자</td>
				<td>${sessionScope.NAME}</td>
			</tr>
			<tr>
				<td>리뷰내용</td>
				<td><textarea rows="8" cols="90" name="review_content"></textarea></td>
			</tr>
		</table>
	</td></tr>	
			<tr>
				<td align="center" colspan="2">
				<input type="submit" value="리뷰쓰기"/> 
				<input type="button" value="취소" onclick="javascript:history.go(-1)"/>
				</td>
			</tr>
	<tr><td></td></tr>
</table>
 </form>
</body> 
</html>