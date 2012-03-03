<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- 메뉴 시작 -->
<div id="LoginStatus">
	<fieldset><legend></legend>
		<ul>
			<c:if test="${not empty loginVO}">
				<li><c:out value="${loginVO.name}" /><spring:message code="login.msg.nim" /> <spring:message code="login.msg.welcom" /></li>
				<li><span class="btn_blue"><a href="<c:url value='/j_spring_security_logout'/>"><spring:message code="login.msg.logout" /></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;" alt="로그아웃"/></span></li>
			</c:if>
			<c:if test="${empty loginVO}">
				<li><spring:message code="login.msg.login" /></li>
				<li><span class="btn_blue"><a href="<c:url value='/mbr/loginView.do'/>"><spring:message code="mbr.login" /></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;" alt="로그인"/></span>
			</c:if>
		</ul>
	</fieldset>
</div>
<div id="nav">
	<div class="navtop"></div>
	<div class="nav_style">
		<ul>
			<li class="leftmenu_dept01"><spring:message code="menu.user" />
				<ul>
					<li class="dept02"><a href="<c:url value='/brd/egovBoardList.do'/>" ><spring:message code="menu.board" /></a></li>
				</ul>
			</li>
			<li class="leftmenu_dept01"><spring:message code="menu.admin" />
				<ul>
					<li class="dept02"><a href="<c:url value='/springrest/cgr.html'/>" ><spring:message code="menu.category" /></a></li>
				</ul>
			</li>
		</ul>
	</div>
	<div class="bottom"></div>
</div>
<!-- //메뉴 끝 -->
