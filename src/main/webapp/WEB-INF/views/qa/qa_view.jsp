<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String pageNo = (String)request.getAttribute("pageNo");
	int currentPage = Integer.parseInt(pageNo);
	session.getAttribute("ID");
%>
<c:set var="pageNo" value="<%= pageNo %>"/>
<c:if test = "${empty qaContentList }">
�������� �ʴ� ���Դϴ�.
</c:if>
<c:if test="${!empty qaContentList}">
		<table cellpadding="20" border="0"  width="80%" align="center">
			<tr><td>QnA �Խ���</td></tr>
			<tr><td>
			<table width="100%" align="center" border="1"  >
				<tr>
					<td width="30%">�۹�ȣ</td><td>${qaContentList.writing_id }</td>
				</tr>
				<tr>
					<td>����</td><td>${qaContentList.title }</td>
				</tr>
				<tr>
					<td>�ۼ���</td><td>${qaContentList.name }</td>
				</tr>
				<tr>
					<td>�ۼ���</td><td>${qaContentList.regdate }</td>
				</tr>
				<tr>
					<td>�۳���</td>
					<td><textarea rows="8" cols="70" disabled="disabled" style="background-color: white; color: black;">${qaContent.qa_content }</textarea></td>
				</tr>
				<tr>
			<td colspan="2">
			<a href="javascript:goReply()">[��۴ޱ�]</a>
			<a href="javascript:goUpdate()">[����]</a>
			<a href="javascript:goDelete()">[����]</a>
			<a href="javascript:goList()">[���]</a>
			</td>
		</tr>
		</table>
	</td></tr>
	<tr><td></td></tr>
</table>

</c:if>


<script language="JavaScript">
function goReply(){
	document.move.action="/qa/write";
	document.move.submit();
}
function goUpdate(){
	document.move.action = "QA_update.jsp";
	document.move.submit();
}
function goDelete(){
	document.move.action="QA_delete.jsp";
	document.move.submit();
}
function goList(){
	document.move.action="/qa/list/"+${pageNo};
	document.move.submit();
}
</script>
<form name="move" method="post">
<input type="hidden" name="id" value="${qaContentList.writing_id }"/>
<input type="hidden" name="parent_id" value="${qaContentList.writing_id }"/>
<input type="hidden" name="group_id" value="${qaContentList.group_id }"/>
<input type="hidden" name="pageNo" value="${pageNo}" />
</form>
