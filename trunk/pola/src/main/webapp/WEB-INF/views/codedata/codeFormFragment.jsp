<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<fieldset> <!-- path의 첫문자가 대문자인지 중요하지 않네. 확인 요망. 단 form:errors 태그의 path는 대문자여야함? -->
	<form:label path="codeId" >Code Id <form:errors path="CodeId" cssClass="error" /></form:label>
	<form:input path="codeId" /><br />
	<form:label path="codeIdNm" >Code Id Name <form:errors path="CodeIdNm" cssClass="error" /></form:label>
	<form:input path="codeIdNm" /><br />
	<form:label path="codeIdDc" >Code Id Description </form:label>
	<form:input path="codeIdDc" /><br />
	<form:label path="code" >Code <form:errors path="Code" cssClass="error" /></form:label>
	<form:input path="code" /><br />
	<form:label path="FrstRegistPnttm" >First Reg </form:label>
	<form:input path="FrstRegistPnttm" /><br />
	<form:label path="FrstRegisterId" >First Reg User </form:label>
	<form:input path="FrstRegisterId" /><br />
	<form:label path="LastUpdtPnttm" >Last Update </form:label>
	<form:input path="LastUpdtPnttm" /><br />
	<form:label path="LastUpdusrId" >Last Update User </form:label>
	<form:input path="LastUpdusrId" /><br />
</fieldset>
