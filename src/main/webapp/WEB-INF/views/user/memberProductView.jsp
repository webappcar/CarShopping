<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>memberProductView</title>

<style type="text/css">
	table {width:800px; margin:auto; border: 1px solid red;}
	table tr {border: 1px solid red;}
</style>

</head>
<body>
	<table>
		<tbody>
			<tr>
				<td rowspan="8" width="400px" align="center"><img src="/img/carimg/${oneProduct.car_image}"></td>
				<td>상품명 : ${oneProduct.car_name}</td>
			</tr>
			<tr>
				<td>연비 : ${oneProduct.efficiency}</td>
			</tr>
			<tr>
				<td>사용연료 : ${oneProduct.fuel}</td>
			</tr>
			<tr>
				<td>구분 : ${oneProduct.gubun}</td>
			</tr>
			<tr>
				<td>회사명 : ${oneProduct.company}</td>
			</tr>
			<tr>
				<td>출시년도 : ${oneProduct.year}</td>
			</tr>
			<tr>
				<td>가격 : ${oneProduct.price}</td>
			</tr>
			<tr>
				<td>수량 : ${oneProduct.stock}</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="주문하기">
					<input type="button" value="장바구니에 담기">
					<input type="button" value="취소">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					제품설명<br>
					${oneProduct.car_desc}
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>