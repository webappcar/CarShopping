<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>adminMemberPage</title>
<%@ include file="/WEB-INF/views/common.jspf" %>

</head>
<body>
	<H1>어드민 회원관리 페이지</H1>
	<h3>회원목록</h3>
	<div class="container">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>닉네임</th>
					<th>이메일</th>
					<th>전화번호</th>
					<th>주소</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="member" items="${member}">
					<tr>
						<td>${member.id}</td>
						<td>${member.name}</td>
						<td>${member.nickname}</td>
						<td>${member.email}</td>
						<td>${member.phone}</td>
						<td>${member.address}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>