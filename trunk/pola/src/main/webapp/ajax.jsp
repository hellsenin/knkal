<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/inc/sst.jspf"%>
<script>
// 서버는 ccom.uro.sprmvc.common.controller.JSONController.java에 있음.


/* $(document).ready(function(){
	alert('wow');
	$.ajax({
		type:"post",
		url:"<c:url value='/kfc/brands/popup/getMessageByTncodeKeyMsg.web'/>",
		dataType:"text",
//한글로 보내고,
		data:{tncode:'oper',key:'123',msg:encodeURIComponent('한글로 메시지 보내')},
		success:function(data){
//한글로 받는다.
//			$('#memo').append(decodeURIComponent(data).split("+").join(" "));
			$('#memo').append(data);
		},
		error:function(data){
			alert("status = " + data.status + " , error = " + error);
		}
	});
});

 */


Ext.onReady(function(){
	
	Ext.Msg.alert('Status', 'Changes saved successfully.');
	
	Ext.Ajax.request({
	    url: '<c:url value='/kfc/brands/popup/getMessageByTncodeKeyMsg.web'/>',
	    params: {
	    	tncode:'oper',key:'123',msg:encodeURIComponent('한글로 메시지 보내')
	    },
	    method: 'POST',
	    success: function(response){
	        var text = response.responseText;
	        Ext.Msg.alert('Status', text);
	        Ext.get('memo').appendChild('<p>err</p>');
	        //Ext.get('memo').boxWrap();
	        
	        // process server response here
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
