<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>productModify</title>
<%@ include file="/WEB-INF/views/common.jspf" %>

<style type="text/css">
	#productregist{width:550px; text-align: center;}
</style>

<script type="text/javascript">
$(function(){
	$('#showday').datepicker({
		dateFormat:"yy-mm"
	});
});
</script>

</head>
<body>
	<div id="productregist">
		<form:form commandName="productinsert" action="">
			<div class="form-group">
				<h1>상품 수정</h1>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="productName">
					<spring:message code="shoppingmall.productregist.productname"/>
				</label>
			    <div class="col-sm-9">
			    	<input type="text" class="form-control" id="productName" name="productName" value=""/>
			    </div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="price">
					<spring:message code="shoppingmall.productregist.price"/>
				</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="price" name="price" value=""/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="mileage">
					<spring:message code="shoppingmall.productregist.mileage"/>
				</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="mileage" name="mileage" value=""/>
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
				<label class="control-label col-sm-3" for="divide">
					<spring:message code="shoppingmall.productregist.divide"/>
				</label>
				<div class="col-sm-9">
					<select id="divide" class="form-control">
						<option value="대형">대형</option>
						<option value="중형">중형</option>
						<option value="준중형">준중형</option>
						<option value="소형">소형</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="showday">
					<spring:message code="shoppingmall.productregist.showday"/>
				</label>
				<div class="col-sm-9">
					<form:input path="showday" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="imagefile">
					<spring:message code="shoppingmall.productregist.imagefile"/>
				</label>
				<div class="col-sm-9">
					<input type="file" class="form-control" id="imagefile" placeholder="전송할 이미지 파일">
				</div>
			</div>
			<input type="submit" class="btn btn-default" value="등록"/>
			<input type="button" class="btn btn-default" id="cancel" value="취소"/>
		</form:form>
	</div>
</body>
</html>