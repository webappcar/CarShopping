<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>productModify</title>
<%@ include file="/WEB-INF/views/common.jspf" %>

<style type="text/css">
	#productmodify{width:550px; text-align: center;}
</style>

<script type="text/javascript">
$(function(){
	$('#showday').datepicker({
		dateFormat:"yy"
	});
});
</script>

</head>
<body>
	<div id="productmodify">
		<form:form commandName="productinsert" action="">
			<div class="form-group">
				<h1>상품 등록</h1>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="car_name">
					<spring:message code="shoppingmall.productregist.productname"/>
				</label>
			    <div class="col-sm-9">
			    	<form:input path="car_name" cssClass="form-control" />
			    </div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="price">
					<spring:message code="shoppingmall.productregist.price"/>
				</label>
				<div class="col-sm-9">
					<form:input path="price" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="efficiency">
					<spring:message code="shoppingmall.productregist.mileage"/>
				</label>
				<div class="col-sm-9">
					<form:input path="efficiency" cssClass="form-control" />
				</div>
			</div>
			<div>
				<label class="control-label col-sm-3" for="fuel">
					<spring:message code="shoppingmall.productregist.fuel"/>
				</label>
				<div class="col-sm-9">
					<div class="checkbox">
						<c:forEach var="f" items="${fuel}">
							<label for="${f.code}" class="checkbox-inline">
								<input id="${f.code}" type="checkbox" value="" class="checkbox"/> ${f.label}
							</label>
						</c:forEach>
	  				</div>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="company">
					<spring:message code="shoppingmall.productregist.company"/>
				</label>
				<div class="col-sm-9">
					<form:input path="company" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="gubun">
					<spring:message code="shoppingmall.productregist.divide"/>
				</label>
				<div class="col-sm-9">
					<select id="gubun" class="form-control">
						<option value="대형">대형</option>
						<option value="중형">중형</option>
						<option value="준중형">준중형</option>
						<option value="소형">소형</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="year">
					<spring:message code="shoppingmall.productregist.showday"/>
				</label>
				<div class="col-sm-9">
					<form:input path="year" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="car_image">
					<spring:message code="shoppingmall.productregist.imagefile"/>
				</label>
				<div class="col-sm-9">
					<input type="file" class="form-control" id="car_image" name="car_image">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="stock">
					<spring:message code="shoppingmall.productregist.stock"/>
				</label>
				<div class="col-sm-9">
					<form:input path="stock" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="car_desc">
					<spring:message code="shoppingmall.productregist.carinfo"/>
				</label>
				<div class="col-sm-9">
					<form:textarea path="car_desc" cssClass="form-control" rows="10"/>
				</div>
			</div>
			<input type="submit" class="btn btn-default" value="등록"/>
			<input type="button" class="btn btn-default" onclick="history.back();" value="취소"/>
		</form:form>
	</div>
</body>
</html>