<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>adminProductPage</title>
<%@ include file="/WEB-INF/views/common.jspf" %>

</head>
<body>
	<H1>어드민 상품관리 페이지</H1>
	<div class="container">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>상품코드</th>
					<th>상품이름</th>
					<th>가격</th>
					<th>연비</th>
					<th>사용연료</th>
					<th>회사명</th>
					<th>구분</th>
					<th>출시년도</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>2</td>
					<td>3</td>
					<td>4</td>
					<td>5</td>
					<td>6</td>
					<td>7</td>
					<td>8</td>
				</tr>
			</tbody>
		</table>
	</div>
	<a href="productInsert">상품등록</a>
	<a href="productModify">상품수정</a>
</body>
</html>