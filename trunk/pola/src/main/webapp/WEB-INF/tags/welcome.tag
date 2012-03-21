<%@ tag body-content="empty" pageEncoding="UTF-8" %>
<%
String msg = (String)request.getAttribute("ErrMessage");
if( msg != null && !"".equals(msg)) {
	String output = "<script>alert('"+ msg +"')</script>";
	out.print(output);
}
else {
	String output = "<script>alert('SSSS')</script>";
	out.print(output);
}
%>
<%-- 







--%>