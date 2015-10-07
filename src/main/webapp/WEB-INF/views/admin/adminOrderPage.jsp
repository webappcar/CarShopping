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
					<th>상품이름</th>
					<th>이름</th>
					<th>배달주소</th>
					<th>전화번호</th>
					<th>주문날짜</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="purchaseList" items="${purchaseList}">
					<tr>
						<td>${purchaseList.purchase_no}</td>
						<td>${purchaseList.code}</td>
						<td>${purchaseList.id}</td>
						<td>${purchaseList.address}</td>
						<td>${purchaseList.telnum}</td>
						<td>${purchaseList.name}</td>
						<td>${purchaseList.purchase_date}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<a href="orderModify">주문수정</a>
	<a href="#">취소/환불</a>
</body>
</html>