<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sitemesh" tagdir="/WEB-INF/tags/sitemesh" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index.jsp</title>

<%@ include file="/WEB-INF/views/common.jspf" %>
</head>
<body>
	<div class="w3-container form-group">
		<div>
			hot 이미지
		</div>
		<div>
			<table>
				<tbody>
					<tr>
						<c:forEach var="product" items="${product}">
							<td><img src="/img/carimg/${product.car_image}" width="220px" height="220px"></td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="product" items="${product}">
							<td><a href="/member/productView?car_id=${product.car_id}">${product.car_name}</a></td>
						</c:forEach>
					</tr>
				</tbody>
			</table>
		</div>
		<div>
			new 이미지
		</div>
		<div>
			new 상품
		</div>
	</div>
</body>
</html>