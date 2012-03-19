<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/inc/sst.jspf"%>
<script>



$(document).ready(function(){
	alert('wow');
	$.ajax({
		type:"post",
		url:"<c:url value='/kfc/brands/popup/getMessageByTncodeKeyMsg.web'/>",
		dataType:"text",
//한글로 보내고,
		data:{tncode:'oper',key:'123',msg:encodeURIComponent('한글로 메시지 보내')},
		success:function(data){
//한글로 받는다.
			$('#memo').append(decodeURIComponent(data).split("+").join(" "));
		},
		error:function(data){
			alert("status = " + data.status + " , error = " + error);
		}
	});
});



</script>
 
<body>
<form id="form" method=post >
<input id="path" type="hidden" name="upfile" value="검둥이"><br>
<input id="btn" type="button" value="업로드" >﻿
</form>
<div id="memo">wow </div>
</body>
