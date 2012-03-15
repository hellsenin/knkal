<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
/**
 * @JSP Name : EgovBoardList.jsp
 * @Description : 게시판 화면
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
<title>게시판 목록</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/egovframework/egov.css'/>" >

<script type="text/javaScript" language="javascript" defer="defer">

	/* pagination 페이지 링크 function */
	function fn_egov_link_page(pageNo) {
		document.listForm.pageIndex.value = pageNo;
		document.listForm.action = "<c:url value='/brd/egovBoardList.do'/>";
		document.listForm.submit();
	}
</script>
</head>
<body
	style="text-align: center; margin: 0 auto; display: inline; padding-top: 100px;">
<!-- 전체 레이어 시작 -->
<div id="wrap">
	<!-- header 시작 -->
	<div id="header"><%@ include file="/WEB-INF/views/com/header.jsp" %></div>
	<!-- //header 끝 -->	
	<!-- container 시작 -->
	<div id="container">
		<!-- 좌측메뉴 시작 -->
		<div id="leftmenu"><%@ include file="/WEB-INF/views/com/leftmenu.jsp" %></div>
		<!-- //좌측메뉴 끝 -->	
	<!-- content 시작 -->
	<div id="content_pop">
	<form:form commandName="searchVO" name="listForm" method="post">
		<input type="hidden" name="selectedId" />
			<!-- 타이틀 -->
			<div id="title">
				<ul>
					<li><img src="<c:url value='/images/egovframework/rte/title_dot.gif'/>" alt=""/> 게시판</li>
				</ul>
			</div>
			<div id="table">
				<table width="100%" border="0" cellpadding="0" cellspacing="0" summary="게시판 목록을 확인 할 수 있습니다.">
					<caption>게시판 목록</caption>
					<colgroup>
						<col width="40" >
						<col width="150" >
						<col width="80" >
						<col width="80" >
					</colgroup>
					<thead>
					<tr>
						<th align="center"><spring:message code="board.header.no" />
						</th>
						<th align="center"><spring:message code="board.header.title" />
						</th>
						<th align="center"><spring:message code="board.header.writer" />
						</th>
						<th align="center"><spring:message code="board.header.date" />
						</th>
					</tr>
					</thead>
					<c:forEach var="result" items="${resultList}" varStatus="status">
						<tr>
							<td align="center" class="listtd"><c:out value="${status.count}" /></td>
							<td align="left" class="listtd"><c:out	value="${result.sj}" /></td>
							<td align="center" class="listtd"><c:out value="${result.mberId}" />&nbsp;</td>
							<td align="center" class="listtd"><c:out value="${result.registDt}" />&nbsp;</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<!-- /List -->
			<div id="paging">
				<ui:pagination paginationInfo="${paginationInfo}" type="image"
					jsFunction="fn_egov_link_page" />
				<form:hidden path="pageIndex" />
			</div>
	</form:form>
</div>
<!-- //content 끝-->
	</div>
	<!-- //container 끝-->
	<!-- footer 시작 -->
	<div id="footer"><%@ include file="/WEB-INF/views/com/footer.jsp" %></div>
	<!-- //footer 끝 -->
	</div>
	<!--// 전체 레이어 끝 -->

</body>
</html>
