<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/inc/sst.jspf"%>


<div id="main">
	<h3>Code 등록</h3>


	<form:form action="${wc}/insertcode" method="post" commandName="codeData" modelAttribute="codeData"  ><!--commandName="codeData"  -->
		<div class="formInfo">
		<s:bind path="*" >
			<c:if test="${status.error}">
				<div class="error">저장에 실패했습니다. 아래 문제를 수정해 주십시요.</div>
			</c:if>
		</s:bind>
		</div>


		<jsp:include page="codeFormFragment.jsp" />
		
		<input type="hidden" name="_method" value="PUT" />
		<p><button type="submit">save</button></p>
		
    </form:form>
    
    
	<div class="verticalSpace">&nbsp;</div>
</div>
<!-- // main 끝 --> 


<%@include file="/WEB-INF/inc/end.jspf"%>
