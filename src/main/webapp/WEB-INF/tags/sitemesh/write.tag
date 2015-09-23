<%@ tag language="java" pageEncoding="EUC-KR" trimDirectiveWhitespaces="true"%>
<%@ attribute name="property" required="true"%>

<%
	out.print("<sitemesh:write property=\""+property+"\" />");
%>