<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>adminOrderPage</title>
<%@ include file="/WEB-INF/views/common.jspf" %>

</head>
<body>
	<H1>어드민 주문관리 페이지</H1>
	<div class="container">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>주문번호</th>
					<th>상품코드</th>
					<th>아이디</th>
					<th>배달주소</th>
					<th>전화번호</th>
					<th>이름</th>
					<th>주문날짜</th>
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
				</tr>
			</tbody>
		</table>
	</div>
	<a href="orderModify">주문수정</a>
	<a href="#">취소/환불</a>
</body>
</html>