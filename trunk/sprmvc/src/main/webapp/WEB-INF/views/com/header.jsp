<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- 행정안전부 로고 및 타이틀 시작 -->
<div id="logoarea" style="padding-top: 10px;">
	<h1><a href="<c:url value='/'/>"><font color=black><img src="<c:url value='/images/egovframework/header/img_egovframe_logo.gif'/>"  alt="go main" /></font></a></h1>
</div>
<div id="project_title" style="padding-top: 10px;"><span class="maintitle"><spring:message code="main.egov" /></span> <strong><spring:message code="main.rte" /></strong>
</div>
<!-- //행정안전부 로고 및 타이틀 끝 -->
