<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>productInsert</title>
<%@ include file="/WEB-INF/views/common.jspf" %>

<style type="text/css">
	#productinsert{width:500px; text-align: center;}
</style>

<script type="text/javascript">
$(function(){
	$('#showday').datepicker({
		dateFormat:"yy-mm-dd"
	});
});
</script>

</head>
<body>
	<div id="productinsert">
		<form class="form-horizontal" role="form">
			<div class="form-group">
				<h1>상품 등록</h1>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="productName">상품명 :</label>
			    <div class="col-sm-9">
			      <input type="text" class="form-control" id="productName" placeholder="상품이름을 입력하세요.">
			    </div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="price">가격 :</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="price" placeholder="가격을 입력하세요">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="mileage">연비 :</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="mileage" placeholder="연비를 입력하세요">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="fuel">사용연료 :</label>
				<div class="checkbox col-sm-9">
	  				<label><input type="checkbox" value="디젤">디젤</label>
	  				<label><input type="checkbox" value="가솔린">가솔린</label>
	  				<label><input type="checkbox" value="LPG">LPG</label>
	  				<label><input type="checkbox" value="하이브리드">하이브리드</label>
	  				<label><input type="checkbox" value="전기">전기</label>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="company">회사명 :</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="company" placeholder="회사명을 입력하세요">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="divide">구분 :</label>
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
				<label class="control-label col-sm-3" for="showday">출시연도 :</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="showday" placeholder="출시연도를 입력하세요">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-3" for="imagefile">이미지파일 :</label>
				<div class="col-sm-9">
					<input type="file" class="form-control" id="imagefile" placeholder="전송할 이미지 파일">
				</div>
			</div>
			<input type="submit" class="btn btn-default" value="등록"/>
			<input type="button" class="btn btn-default" id="cancel" value="취소"/>
		</form>
	</div>
</body>
</html>