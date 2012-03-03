<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  헬로월드.
</h1>
<c:forEach var="qlist" items="${qList}">
  <li><c:out value="${qlist.name}"/>,<c:out value="${qlist.addr}"/>
 </c:forEach>



<img alt="" src="/Sprmvc/img/tum.png">
<P>  The time on the server is ${serverTime}. </P>
<a href="gone.jsp">여기</a>
</body>
</html>
