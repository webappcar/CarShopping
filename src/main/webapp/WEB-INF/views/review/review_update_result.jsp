<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String writing_id = (String)request.getAttribute("writing_id");
%>
<script>
	alert("���� ���������� �����Ǿ����ϴ�.");
	location.href="/review/view/"+${writing_id};
</script>