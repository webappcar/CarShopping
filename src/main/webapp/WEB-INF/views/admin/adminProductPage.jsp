<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>adminProductPage</title>
<%@ include file="/WEB-INF/views/common.jspf" %>
<script type="text/javascript">
	//$('input[name=check]:checked').val();
	function oneCheckbox(a){
        var obj = document.getElementsByName("check");
        for(var i=0; i<obj.length; i++){
            if(obj[i] != a){
                obj[i].checked = false;
            }
        }
    }
	
	function productModify(){
		var car_id = $('input[name=check]:checked').val();
		location.href = "productModify?car_id="+car_id;
	}
</script>

</head>
<body>
	<H1>어드민 상품관리 페이지</H1>
	<div class="container">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>선택</th>
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
				<c:forEach var="product" items="${product}">
					<tr>
						<td><input type="checkbox" id="check" name="check" value="${product.car_id}" onclick="oneCheckbox(this)"/></td>
						<td>${product.car_id}</td>
						<td>${product.car_name }</td>
						<td>${product.price }</td>
						<td>${product.efficiency }</td>
						<td>${product.fuel }</td>
						<td>${product.company }</td>
						<td>${product.gubun }</td>
						<td>${product.year }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<a href="productInsert">상품등록</a>
	<input type="button" value="상품수정" onclick="productModify();"/>
</body>
</html>