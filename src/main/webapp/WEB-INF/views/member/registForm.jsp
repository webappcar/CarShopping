<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>registForm.jsp</title>
<%@ include file="/WEB-INF/views/common.jspf" %>
<style type="text/css">
	form {
		width: 400px;
		border-top: 1px double red;
		border-bottom: 1px double red;
	}
	
	.center {
		text-align: center;
		text-shadow: 5px 5px 1px blue;	
	}
	#member {
		margin: auto auto;
	}
	label[for^=gender], label[for^=hobby] {
		padding-left: 5px;
		padding-right: 10px;
		color: orange;
	}
</style>

<script type="text/javascript">
// 준비(ready) 헨들러
$(document).ready(function() {
	
	$('form').slideToggle().slideToggle(1000)
			 .fadeOut(500).fadeIn(1000, function() {
				 $('label[for^=gender]').css('background-color', 'pink')
				 						.fadeOut(1000).fadeIn(1000);
			});
	
});

</script>

</head>
<body>

<h1 class="center"><a href="regist"><spring:message code="member.regist.title"/></a></h1>

<form:form commandName="member" action="regist" method="post">
	
	<form:errors element="div"/>
	
	<!-- Email -->
	<div class="form-group">
		<label for="email"><spring:message code="member.regist.email"/></label>
		<form:input path="email" cssClass="form-control"/>
		<form:errors path="email"/>
	</div>
	<!-- Password -->
	<div class="form-group">
		<label for="password"><spring:message code="member.regist.password"/></label>
		<form:input path="password" cssClass="form-control"/>
		<form:errors path="password"/>
	</div>
	<!-- Name -->
	<div class="form-group">
		<label for="name"><spring:message code="member.regist.name"/></label>
		<form:input path="name" cssClass="form-control"/>
		<form:errors path="name"/>
	</div>
	<!-- Gender -->
	<div class="form-group">
		<div><spring:message code="member.regist.gender"/></div>
		<form:radiobuttons path="gender" items="${gender}"/>
		<form:errors path="gender"/>
	</div>
	<!-- Hobby -->
	<div class="form-group">
		<div><spring:message code="member.regist.hobby"/></div>
		<form:checkboxes items="${hobby}" path="hobby" itemLabel="label" itemValue="code"/>
		<form:errors path="hobby"/>	
	</div>
	<!-- Comment -->
	<div class="form-group">
		<div><spring:message code="member.regist.comment"/></div>
		<form:textarea path="comment" cssClass="form-control" rows="10"/>
		<form:errors path="comment"/>
	</div>
	<!-- Email Reception true/false -->
	<div class="form-group">
		<label for="reception1"><spring:message code="member.regist.reception"/></label>
		<form:checkbox path="reception"/>
		<form:errors path="reception"/>
	</div>

	<input type="submit" value="회원가입"/>
</form:form>



</body>
</html>





