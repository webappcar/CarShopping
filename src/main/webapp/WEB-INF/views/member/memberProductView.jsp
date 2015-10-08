<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>memberProductView</title>
<%@ include file="/WEB-INF/views/common.jspf" %>

<style type="text/css">
	table {width:800px; margin:auto;}
</style>

<script type="text/javascript">

	$(document).ready(function(){
		$('#order').hide();
	});

	function orderButton(){
		if(confirm("주문하시겠습니까?")!=0) {
			$('#order').show();
		}
	}
	
	function goindex(){
		location.href="/index";
	}
</script>
</head>
<body>
<div id="viewDiv">
	<form method="post" action="/member/insertPurchase?car_id=${oneProduct.car_id}">
		
		<table class="table table-default">
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
					<td>구매수량 : <input type="text" value="1"></td>
				</tr>
				<tr>
					<td colspan="2">
						제품설명<br>
						${oneProduct.car_desc}
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<br>리뷰<br>
						<table width="100%" id="reviewTable" class="table table-hover">
							<tr><td>제목</td><td>글쓴이</td><td>등록일</td></tr>
							<c:forEach var="reviewlist" items="${reviewList}" varStatus="status">
								<tr>
									<td><a href="/review/view/${reviewlist.writing_id}/${oneProduct.car_id}">${reviewlist.title}</a></td>
									<td>${reviewlist.name}</td>
									<td>${reviewlist.register_date}</td>
								</tr>
							</c:forEach>
						</table>
						<br><a href="/review/write/${oneProduct.car_id}">[리뷰쓰기]</a><br>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<c:if test="${sessionScope.ID ne null}">
							<input type="button" value="주문하기" onclick="orderButton();">
							<input type="button" value="장바구니에 담기">
						</c:if>
						<input type="button" value="취소" onclick="goindex();">
					</td>
				</tr>
				<tr id="order">
					<td align="center">
						<br>
						이름 : <input type="text" id="name" name="name"><br>
						전화번호 : <input type="text" id="telnum" name="telnum"><br>
						주소 : <input type="text" id="address" name="address"><br>
					</td>
					<td>
						<br>
						<input type="button" value="주문하기">
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	</div>
</body>
</html>