<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Language" content="ko" >
<title>로그인</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


<link href="<c:url value='/css/login.css'/>" rel="stylesheet" type="text/css" >
<script type="text/javascript">
<!--
function actionLogin() {

    if (document.loginForm.id.value =="") {
        alert("아이디를 입력하세요");
        return false;
    } else if (document.loginForm.password.value =="") {
        alert("비밀번호를 입력하세요");
        return false;
    } else {
        document.loginForm.action="<c:url value='/uat/uia/actionSecurityLogin.do'/>";
        //document.loginForm.j_username.value = document.loginForm.userSe.value + document.loginForm.username.value;
        //document.loginForm.action="<c:url value='/j_spring_security_check'/>";
        document.loginForm.submit();
    }
}

function setCookie (name, value, expires) {
    document.cookie = name + "=" + escape (value) + "; path=/; expires=" + expires.toGMTString();
}

function getCookie(Name) {
    var search = Name + "="
    if (document.cookie.length > 0) { // 쿠키가 설정되어 있다면
        offset = document.cookie.indexOf(search)
        if (offset != -1) { // 쿠키가 존재하면
            offset += search.length
            // set index of beginning of value
            end = document.cookie.indexOf(";", offset)
            // 쿠키 값의 마지막 위치 인덱스 번호 설정
            if (end == -1)
                end = document.cookie.length
            return unescape(document.cookie.substring(offset, end))
        }
    }
    return "";
}

function saveid(form) {
    var expdate = new Date();
    // 기본적으로 30일동안 기억하게 함. 일수를 조절하려면 * 30에서 숫자를 조절하면 됨
    if (form.checkId.checked)
        expdate.setTime(expdate.getTime() + 1000 * 3600 * 24 * 30); // 30일
    else
        expdate.setTime(expdate.getTime() - 1); // 쿠키 삭제조건
    setCookie("saveid", form.id.value, expdate);
}

function getid(form) {
    form.checkId.checked = ((form.id.value = getCookie("saveid")) != "");
}

function fnInit() {
    var message = document.loginForm.message.value;
    if (message != "") {
        alert(message);
    }
    getid(document.loginForm);
}
//-->
</script>
</head>
<body  onload="fnInit();" >
<noscript>자바스크립트를 지원하지 않는 브라우저에서는 일부 기능을 사용하실 수 없습니다.</noscript>    




<div id="layer01_holder">
  <div id="left"></div>
  <div id="center"></div>
  <div id="right"></div>
</div>

<div id="layer02_holder">
  <div id="left"></div>
  <div id="center"></div>
  <div id="right"></div>
</div>

<div id="layer03_holder">
  <div id="left"></div>
  <div id="center">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>LOGIN<br /><br /></td>
  </tr>
  <tr>
    <td><form:form name="loginForm" method="post" >
      <label>Name 
        <input type="text" title="아이디를 입력하세요." id="id" name="id" maxlength="10" style="width:140px" />
      </label>
      <label>Password  
      <input type="password" maxlength="20" title="비밀번호를 입력하세요." id="password" name="password" 
	                                       onkeydown="javascript:if (event.keyCode == 13) { actionLogin(); }" style="width:140px" />
      </label>
      <!-- input type="checkbox" name="checkId" title="로그인ID 저장여부" onclick="javascript:saveid(this.form);" id="checkId" />ID저장 -->
      <label>
       <input  type="button" onclick="javascript:actionLogin()" name="button" id="button" value="Login" />
      </label>
      <input type="hidden" name="message" value="${message}" />
      <input type="hidden" name="userSe"  value="USR"/>
      <input name="j_username" type="hidden"/>
    </form:form>    </td>
  </tr>
</table>
  </div>
  <div id="right"></div>
</div>

<div id="layer04_holder">
  <div id="left"></div>
  <div id="center" style="font-size:8px;">
  If you forgot your password, please contact administrator or <a href="#">click here</a></div>
  <div id="right"></div>
</div>


</body>
</html>





