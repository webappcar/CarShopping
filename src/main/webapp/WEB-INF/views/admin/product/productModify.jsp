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
	#car_image{float:left;}
	
	.YearDatePicker .ui-datepicker-month{display:none;}
	.HideTodayButton .ui-datepicker-buttonpane .ui-datepicker-current{
		visibility:hidden;
	}
	.hide-calendar .ui-datepicker-calendar{
		display:none!important;
		visibility:hidden!important
	}
	
	#inputFile label {
	  display: inline-block;
	  padding: .5em .75em;
	  color: #999;
	  font-size: inherit;
	  line-height: normal;
	  vertical-align: middle;
	  background-color: #fdfdfd;
	  cursor: pointer;
	  border: 1px solid #ebebeb;
	  border-bottom-color: #e2e2e2;
	  border-radius: .25em;
	}

	#inputFile input[type="file"] {  /* 파일 필드 숨기기 */
	  position: absolute;
	  width: 1px;
	  height: 1px;
	  padding: 0;
	  margin: -1px;
	  overflow: hidden;
	  clip:rect(0,0,0,0);
	  border: 0;
	}
</style>

<script type="text/javascript">
$(function(){
	$('#year').datepicker({
		dateFormat:"yy",
        changeYear: true,
        showButtonPanel: true,
        beforeShow: function (e, t) {
            $(this).datepicker("hide");
            $("#ui-datepicker-div").addClass("hide-calendar");
			$("#ui-datepicker-div").addClass('YearDatePicker');
			$("#ui-datepicker-div").addClass('HideTodayButton');
        },
        onClose: function(dateText, inst) { 
            var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
            $(this).datepicker('setDate', new Date(year, 1));
        }
	});
});

$(document).ready(function(){
	 var fileTarget = $('#inputFile #fileUpload');

	 fileTarget.on('change', function(){
	    if(window.FileReader){
	      var filename = $(this)[0].files[0].name;
	    } 
	    else {
	      var filename = $(this).val().split('/').pop().split('\\').pop();
	    }

	    $(this).siblings('#car_image').val(filename);
	 });
}); 
</script>

</head>
<body>
	<div id="productmodify">
		<form:form commandName="productinsert" action="modifyProduct?car_id=${product.car_id}">
			<div class="form-group">
				<h1>상품 등록</h1>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="car_name">
					<spring:message code="shoppingmall.productregist.productname"/>
				</label>
			    <div class="col-sm-9">
			    	<form:input path="car_name" cssClass="form-control" value="${product.car_name}"/>
			    </div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="price">
					<spring:message code="shoppingmall.productregist.price"/>
				</label>
				<div class="col-sm-9">
					<form:input path="price" cssClass="form-control" value="${product.price}"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="efficiency">
					<spring:message code="shoppingmall.productregist.mileage" />
				</label>
				<div class="col-sm-9">
					<form:input path="efficiency" cssClass="form-control" value="${product.efficiency}"/>
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
								<input id="${f.code}" name="fuel" 
								value="<spring:message code='shoppingmall.productregist.fuel.${f.code}'/>" 
								type="checkbox" class="checkbox"/> ${f.label}
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
					<form:input path="company" cssClass="form-control" value="${product.company}"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="gubun">
					<spring:message code="shoppingmall.productregist.divide"/>
				</label>
				<div class="col-sm-9">
					<select id="gubun" class="form-control">
						<option value="대형" <c:if test="${product.gubun eq '대형'}">selected</c:if>>대형</option>
						<option value="준중형" <c:if test="${product.gubun eq '준중형'}">selected</c:if>>준중형</option>
						<option value="소형" <c:if test="${product.gubun eq '소형'}">selected</c:if>>소형</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="year">
					<spring:message code="shoppingmall.productregist.showday"/>
				</label>
				<div class="col-sm-9">
					<form:input path="year" cssClass="form-control" value="${product.year}"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="car_image">
					<spring:message code="shoppingmall.productregist.imagefile"/>
				</label>
				<div class="col-sm-9">
					<div class="form-control" id="inputFile">
						<input id="car_image" name="car_image" value="${product.car_image}" disabled="disabled"/>
						<label for="fileUpload">파일찾기</label>
						<input type="file" id="fileUpload"/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="stock">
					<spring:message code="shoppingmall.productregist.stock"/>
				</label>
				<div class="col-sm-9">
					<form:input path="stock" cssClass="form-control" value="${product.stock}"/>
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
			<input type="submit" class="btn btn-default" value="수정"/>
			<input type="button" class="btn btn-default" onclick="history.back();" value="취소"/>
		</form:form>
	</div>
</body>
</html>