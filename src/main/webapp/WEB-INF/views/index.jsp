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

<style>
	table tr td img{border: 1px solid #EAEAEA; margin: 1px;}
	#hotItemDiv table{margin:auto;}
	#hotItemImage{margin-bottom: 10px; margin-top: 50px;}
	#newItemImage{margin-bottom: 10px; margin-top: 80px;}
</style>
</head>
<body>
	<div class="w3-container form-group" id="mainProductDiv">
		<div id="hotItemImage">
			<img src="/img/hotItem.jpg">
		</div>
		<div id="hotItemDiv">
			<table>
				<tbody>
					<tr>
						<c:forEach var="hotItemProduct" items="${hotItemProduct}">
							<td>
								<a href="/member/productView?car_id=${hotItemProduct.car_id}">
									<img src="/img/carimg/${hotItemProduct.car_image}" width="200px" height="200px">
								</a>
							</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="hotItemProduct" items="${hotItemProduct}">
							<td>
								<a href="/member/productView?car_id=${hotItemProduct.car_id}">
									[${hotItemProduct.company}] ${hotItemProduct.car_name}
								</a>
							</td>
						</c:forEach>
					</tr>
				</tbody>
			</table>
		</div>
		<div id="newItemImage">
			<img src="/img/newItem.jpg">
		</div>
		<div>
			<table>
				<tbody>
					<tr>
						<c:forEach var="newItemProduct" items="${newItemProduct}">
							<td>
								<a href="/member/productView?car_id=${newItemProduct.car_id}">
									<img src="/img/carimg/${newItemProduct.car_image}" width="200px" height="200px">
								</a>
							</td>
						</c:forEach>
					</tr>
					<tr>
						<c:forEach var="newItemProduct" items="${newItemProduct}">
							<td>
								<a href="/member/productView?car_id=${newItemProduct.car_id}">
									[${newItemProduct.company}] ${newItemProduct.car_name}
								</a>
							</td>
						</c:forEach>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>