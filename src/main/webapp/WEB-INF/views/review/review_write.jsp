<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	String car_id = (String)request.getAttribute("car_id");
	String from_review = (String)request.getAttribute("from_review");
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
		<input type="hidden" name="car_id" value="${car_id}" />
		<input type="hidden" name="from_review" value="true" />
		</form> 
	</c:when>
	<c:otherwise>
		<form name="write_review" action="/review/insert" method="post" onsubmit="return validate()">
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
						<c:choose>
							<c:when test="${from_review!=null}">						
								<input type="button" value="취소" onclick="javascript:goProduct()"/>
							</c:when>
							<c:otherwise>
								<input type="button" value="취소" onclick="javascript:history.go(-1)"/>
							</c:otherwise>
						</c:choose>
						</td>
					</tr>
			<tr><td></td></tr>
		</table>
		</form>
	</c:otherwise>
</c:choose>
 <script language="javascript">
	function goProduct() {
		document.write_review.action = "/member/productView?car_id="+${car_id};
		document.write_review.submit();		
	}
</script>
</body> 
</html>