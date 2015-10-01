<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>checkPassword</title>
<%@ include file="/WEB-INF/views/common.jspf" %>

</head>
<body>
	
	<form:form commandName="checkpassword" action="">
		<div class="form-group">
			<div class="form-control">
				<span>비밀번호 입력</span>
			</div>
			<div class="form-control">
				<form:password path="password" cssClass="form-control"/>
				<form:button value="확인"/>
			</div>
		</div>
	</form:form>
	
</body>
</html>