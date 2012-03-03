<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
/**
 * @JSP Name : EgovMain.jsp
 * @Description : 메인화면
 * @Modification Information
 * 
 *   수정일         수정자                   수정내용
 *  -------    --------    ---------------------------
 *  2011.07.11  신혜연          최초 생성
 *
 * author 실행환경팀 
 * Copyright (C) 2011 by MOPAS  All right reserved.
 */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" >
<meta http-equiv="content-language" content="ko">
<title>main</title>

<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/egov.css'/>" >

<script type="text/javaScript" language="javascript" defer="defer">

</script>

</head>
<body style="text-align: center; margin: 0 auto; display: inline; padding-top: 100px;">
	<!-- 전체 레이어 시작 -->
	<div id="wrap">
		<!-- header 시작 -->
		<div id="header"><%@ include
				file="/WEB-INF/views/com/header.jsp"%></div>
		<!-- //header 끝 -->
		<!-- container 시작 -->
		<div id="container">
			<!-- 좌측메뉴 시작 -->
			<div id="leftmenu"><%@ include
					file="/WEB-INF/views/com/leftmenu.jsp"%></div>
			<!-- //좌측메뉴 끝 -->

			<!-- content 시작 -->
			<div id="content_pop">
			
			Spring Security 예제<br /><br />
			
			Board 메뉴 : 관리자, 로그인 한 사용자만 접근 가능<br />
			Category 메뉴: 관리자만 접근 가능<br /><br />
			
			샘플 아이디 / 패스워드<br />
			* 관리자 : admin / admin<br />
			* 일반사용자: user / user<br />
			<!-- //content 끝-->
		</div>
		<!-- //container 끝-->
		<!-- footer 시작 -->
		<div id="footer"><%@ include file="/WEB-INF/views/com/footer.jsp"%></div>
		</div>
		<!-- //footer 끝 -->
	</div>
	<!--// 전체 레이어 끝 -->
</body>
</html>

