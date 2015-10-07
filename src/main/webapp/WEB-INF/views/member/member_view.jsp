<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>사용자정보</title>
<c:choose>
     <c:when test="${sessionScope.ID == null}">
	   <script>
		   alert("로그인을 해주세요");
		   location.href="/member/login";
	   </script>
     </c:when>
     <c:otherwise>
         <c:if test="${sessionScope.ID != member.id }">
	         <script>
		         alert("권한이 없습니다.");
		         location.href="javascript:history.go(-1)";
	         </script>
         </c:if>     
     </c:otherwise>
</c:choose>
</head>
<body>
	<table cellpadding="20" border="0"  width="80%" align="center">
		<tr><td>사용자정보</td></tr>
		<tr><td>
		<table width="100%" align="center" border="1"  >
			<tr>
				<td width="30%">ID</td><td>${member.id }</td>
			</tr>
			<tr>
				<td>이름</td><td>${member.name }</td>
			</tr>
			<tr>
				<td>별명</td><td>${member.nickname }</td>
			</tr>
			<tr>
				<td>이메일</td><td>${member.email }</td>
			</tr>
			<tr>
				<td>전화번호</td><td>${member.phone }</td>
			</tr>
			<tr>
				<td>주소</td><td>${member.address }</td>
			</tr>
		</table>
	</td></tr>
	<tr><td><a href="javascript:goHome()">[Home]</a></td></tr>
</table>

<script language="JavaScript">
function goHome(){
	document.move.action="/index";
	document.move.submit();
}
</script>
<form name="move" method="post">
</form>

</body> 
</html>