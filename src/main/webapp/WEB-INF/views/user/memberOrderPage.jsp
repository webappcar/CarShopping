<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/common.jspf" %>

</head>
<body>
	<form:form commandName="memberOrder" action="">
		<div class="form-group">
			<label class="control-label col-sm-3" for="ordername">
				수령자
			</label>
			<div class="col-sm-9">
				<input type="text" id="ordername" name="ordername" value="">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3" for="ordertelnum">
				수령자 전화번호
			</label>
			<div class="col-sm-9">
				<input type="text" id="ordertelnum" name="ordertelnum" value="">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-3" for="orderaddress">
				수령주소
			</label>
			<div class="col-sm-9">
				<input type="text" id="orderaddress" name="orderaddress" value="">
			</div>
		</div>
	</form:form>
</body>
</html>