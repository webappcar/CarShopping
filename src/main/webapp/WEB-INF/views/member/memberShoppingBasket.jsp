<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/common.jspf" %>
</head>
<body>
	<div class="container">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>선택</th>
						<th>상품이름</th>
						<th>가격</th>
						<th>회사명</th>
						<th>구분</th>
						<th>출시년도</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="sb" items="${sb}">
					<tr>
						<td><input type="checkbox" id="check" name="check" value="${sb.car_id}" onclick="oneCheckbox(this)"/></td>
						<td>${sb.car_name }</td>
						<td>${sb.price }</td>
						<td>${sb.company }</td>
						<td>${sb.gubun }</td>
						<td>${sb.year }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<input type="button" value="상품등록" onclick="productInsert();"/>
	<input type="button" value="상품수정" onclick="productModify();"/>
	<input type="button" value="상품삭제" onclick="productDelete();"/>
</body>
</html>