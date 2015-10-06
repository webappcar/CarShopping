<%@page import="com.shoppingmall.controller.QAController"%>
<%@page import="com.shoppingmall.model.QA"%>
<%@ page import="java.util.*" %>
<%@page import="com.shoppingmall.service.QAListService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%! static int PAGE_SIZE = 10;%> 
<%

String pageNo = (String)request.getAttribute("pageNo");
int currentPage = Integer.parseInt(pageNo);

int count = (Integer)request.getAttribute("count");
int number = (Integer)request.getAttribute("number");

int startRow = (Integer)request.getAttribute("startRow");
int endRow = (Integer)request.getAttribute("endRow");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
<%@ include file="/WEB-INF/views/common.jspf" %>
</head>
<body>
<h1>Car Shopping Home...qa...</h1><br>

<%-- ${requestScope.pageNo}, ${requestScope.count} --%>

<br><br>

<c:set var="pageNum" value="<%= pageNo %>"/>
<c:set var="num" value="<%=number %>"/>

<table width="80%" cellpadding="10" align="center" border="0">
	<tr><td>QnA 게시판 &nbsp; <a href="/member/logout">[logout]</a></td></tr>
	<tr><td>
		<c:if test="<%= count > 0%>">
		<table width="100%" cellpadding="1" cellspacing="0">
			<%-- <tr>
				<td align="right">
					<b><%=startRow %>~<%=endRow %>&nbsp;/&nbsp;<%= count %></b>
				</td>
			</tr> --%>
		</table>
		</c:if>
	</td></tr>
	<tr><td>	
		<table width="100%" cellpadding="1" cellspacing="2">
			<tr style="color: white;" bgcolor="#464646" align="center">	
				<td>번호</td>
				<td>제목</td>
				<td>글쓴이</td>
				<td>등록일</td>
			</tr>
			<c:if test="${empty qalist }">
				<tr align="center">
				<td bgcolor="#f0f0f0" colspan="5" align="center">
				등록된 문의가 없습니다.
				</td>
				</tr>
			</c:if>
			<c:if test="${!empty qalist }">
			<c:forEach var="qalist" items="${qalist}" varStatus="status">
			<tr bgcolor="#f0f0f0">
				<td>
				</td>
			<tr bgcolor="#f0f0f0">
				<td align="center">${num - status.count}</td>
				<td><a href="javascript:goView(${qalist.writing_id })">${qalist.title }</a></td>
				<td align="center">${qalist.name}</td>
				<td align="center">${qalist.register_date }</td>
			</tr>
		</c:forEach>
		</c:if>
			<tr><td align="right" colspan="4">
				<a href="javascript:goWrite()">[글쓰기]</a>
			</td></tr>
		</table>
	</td></tr>
	<tr><td align="center">
		<c:set var="count" value="<%= Integer.toString(count) %>"/>
		<c:set var="PAGE_SIZE" 
					value="<%= Integer.toString(PAGE_SIZE) %>"/>
		<c:set var="currentPage" 
					value="<%= Integer.toString(currentPage) %>" />
		<c:if test="${count > 0 }">
			<c:set var="pageCount" 
				value="${count / PAGE_SIZE + 
						(count % PAGE_SIZE == 0 ? 0 : 1) }"/>
			<c:set var="startPage"
				value="${currentPage - 
				(currentPage % 10 == 0 ? 10: (currentPage % 10)) 
				+ 1 }"/>
			<c:set var="endPage"
				value="${startPage + 9 }"/>
			<c:if test="${endPage > pageCount }">
				<c:set var="endPage" value="${pageCount }"/>
			</c:if>
			<c:if test="${startPage > 10 }">
			<a href="javascript:goPage(${startPage-10 })">[이전]</a>
			</c:if>
			<c:forEach var="pageNo" begin="${startPage }"
									end = "${endPage }">
			<c:if test="${currentPage == pageNo }"><font size="4" style="font-weight: bolder;"  ></c:if>
			<a href="javascript:goPage(${pageNo })">[${pageNo }]</a>
			<c:if test="${currentPage == pageNo }"></font></c:if>
			</c:forEach>
			<c:if test="${endPage < pageCount }">
			<a href="javascript:goPage(${startPage+10 })">[다음]</a>
			</c:if>
		</c:if>
	</td></tr>
</table>
<script language="JavaScript">
	function goPage(pageNo){
		document.move.action = "/qa/list/"+pageNo;
		document.move.submit();
	}
	function goView(id){
		document.move.action = "/qa/view/"+id;
		document.move.submit();
	}
	function goWrite(){
		document.move.action = "/qa/write";
		document.move.submit();
	}
</script>
<form name="move" method="post">
<input type="hidden" name="id" value="" />
<input type="hidden" name="pageNo" value="${pageNo}" />
</form>

<%-- <c:forEach var="qalist" items="${qalist}"> --%>
<%-- 	${qalist.id} - ${qalist.title}<br> --%>
<%-- </c:forEach> --%>
</body>
</html>