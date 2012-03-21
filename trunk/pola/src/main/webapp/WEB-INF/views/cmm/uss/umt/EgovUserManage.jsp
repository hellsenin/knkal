<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/inc/sst.jspf"%>



<script type="text/javaScript" language="javascript" >


function fnCheckAll() {
    var checkField = document.listForm.checkField;
    if(document.listForm.checkAll.checked) {
        if(checkField) {
            if(checkField.length > 1) {
                for(var i=0; i < checkField.length; i++) {
                    checkField[i].checked = true;
                }
            } else {
                checkField.checked = true;
            }
        }
    } else {
        if(checkField) {
            if(checkField.length > 1) {
                for(var j=0; j < checkField.length; j++) {
                    checkField[j].checked = false;
                }
            } else {
                checkField.checked = false;
            }
        }
    }
}
function fnDeleteUser() {
    var checkField = document.listForm.checkField;
    var id = document.listForm.checkId;
    var checkedIds = "";
    var checkedCount = 0;
    if(checkField) {
        if(checkField.length > 1) {
            for(var i=0; i < checkField.length; i++) {
                if(checkField[i].checked) {
                    checkedIds += ((checkedCount==0? "" : ",") + id[i].value);
                    checkedCount++;
                }
            }
        } else {
            if(checkField.checked) {
                checkedIds = id.value;
            }
        }
    }
    if(checkedIds.length > 0) {
        //alert(checkedIds);
        if(confirm("<spring:message code="common.delete.msg" />")){
            document.listForm.checkedIdForDel.value=checkedIds;
            document.listForm.action = "<c:url value='/uss/umt/user/EgovUserDelete.do'/>";
            document.listForm.submit();
        }
    }
}
function fnSelectUser(id) {
    document.listForm.selectedId.value = id;
    array = id.split(":");
    if(array[0] == "") {
    } else {
        userTy = array[0];
        userId = array[1];    
    }
    document.listForm.selectedId.value = userId;
    document.listForm.action = "<c:url value='/uss/umt/user/EgovUserSelectUpdtView.do'/>";
    document.listForm.submit();
      
}
function fnAddUserView() {
    document.listForm.action = "<c:url value='/uss/umt/user/EgovUserInsertView.do'/>";
    document.listForm.submit();
}
function fnLinkPage(pageNo){
    document.listForm.pageIndex.value = pageNo;
    document.listForm.action = "<c:url value='/uss/umt/user/EgovUserManage.do'/>";
    document.listForm.submit();
}
function fnSearch(){
    document.listForm.pageIndex.value = 1;
    document.listForm.action = "<c:url value='/uss/umt/user/EgovUserManage.do'/>";
    document.listForm.submit();
}
function fnViewCheck(){ 
    if(insert_msg.style.visibility == 'hidden'){
        insert_msg.style.visibility = 'visible';
    }else{
        insert_msg.style.visibility = 'hidden';
    }
}


</script>

<div id="main">
	<h3>사용자목록</h3>


                <!-- 검색 필드 박스 시작 -->
                <div id="search_field">
                    
				        <input name="selectedId" type="hidden" />
				        <input name="checkedIdForDel" type="hidden" />
				        <input name="pageIndex" type="hidden" value="<c:out value='${userSearchVO.pageIndex}'/>"/>
                        
                        <fieldset><legend>조건정보 영역</legend>    
                        <div class="sf_start">
                            <ul id="search_first_ul">
                                <li>
					                <select name="sbscrbSttus" id="sbscrbSttus" title="검색조건1-사용자상태">
					                    <option value="0" <c:if test="${empty userSearchVO.sbscrbSttus || userSearchVO.sbscrbSttus == '0'}">selected="selected"</c:if> >상태(전체)</option>
					                    <option value="A" <c:if test="${userSearchVO.sbscrbSttus == 'A'}">selected="selected"</c:if> >가입신청</option>
					                    <option value="D" <c:if test="${userSearchVO.sbscrbSttus == 'D'}">selected="selected"</c:if> >삭제</option>
					                    <option value="P" <c:if test="${userSearchVO.sbscrbSttus == 'P'}">selected="selected"</c:if> >승인</option>
					                </select>
					                <select name="searchCondition" id="searchCondition" title="검색조건2-검색어구분">
					                    <option value="0" <c:if test="${userSearchVO.searchCondition == '0'}">selected="selected"</c:if> >ID</option>
					                    <option value="1" <c:if test="${empty userSearchVO.searchCondition || userSearchVO.searchCondition == '1'}">selected="selected"</c:if> >Name</option>
					                </select>
                                </li>
                                <li>
					                <input name="searchKeyword" title="검색어" type="text" value="<c:out value="${userSearchVO.searchKeyword}"/>" title="검색" />
                                </li>
                            </ul>
                            <ul id="search_second_ul">
                                <li>
                                    <div class="buttons" style="float:right;">
                                        <a href="<c:url value='/uss/umt/user/EgovUserManage.do'/>" onclick="javascript:fnSearch(); return false;"><img src="<c:url value='/'/>images/img_search.gif" alt="search" />조회 </a>
				                        <a href="#LINK" onclick="javascript:fnDeleteUser(); return false;"><spring:message code="button.delete" /></a>
				                        <a href="<c:url value='/uss/umt/user/EgovUserManage.do'/>"><spring:message code="button.list" /></a>
				                        <a href="<c:url value='/uss/umt/user/EgovUserInsertView.do'/>" onclick="fnAddUserView(); return false;"><spring:message code="button.create" /></a>
                                    </div>                              
                                </li>
                            </ul>           
                        </div>          
                        </fieldset>
                </div>
                <!-- //검색 필드 박스 끝 -->

                <div id="page_info"><div id="page_info_align">사용자수  : <strong><c:out value="${paginationInfo.totalRecordCount}"/></strong></div></div>                    
                <!-- table add start -->
                <div class="default_tablestyle">
                    <table summary="사용자 목록을 제공한다." cellpadding="0" cellspacing="0">
                    <caption>사용자목록</caption>
                    <colgroup>
                    <col width="5%" >
                    <col width="5%" >
                    <col width="15%" >
                    <col width="15%" >
                    <col width="15%" >
                    <col width="15%" >
                    <col width="15%" >
                    <col width="15%" >
                    </colgroup>
                    <thead>
                    <tr>
                        <th scope="col" class="f_field" nowrap="nowrap"><strong>No.</strong></th>
                        <th scope="col" nowrap="nowrap"><input name="checkAll" type="checkbox" title="Check All" onclick="javascript:fnCheckAll();"/></th>
                        <th scope="col" nowrap="nowrap">아이디</th>
                        <th scope="col" nowrap="nowrap">사용자이름</th>
                        <th scope="col" nowrap="nowrap">사용자이메일</th>
                        <th scope="col" nowrap="nowrap">전화번호</th>
                        <th scope="col" nowrap="nowrap">등록일</th>
                        <th scope="col" nowrap="nowrap">가입상태</th>
                    </tr>
                    </thead>
                    <tbody>                 

                    <c:forEach var="result" items="${resultList}" varStatus="status">
                    <!-- loop 시작 -->                                
                      <tr>
	                    <td nowrap="nowrap"><strong><c:out value="${status.count}"/></strong></td>
	                    <td nowrap="nowrap">
	                        <input name="checkField" title="Check <c:out value="${status.count}"/>" type="checkbox"/>
	                        <input name="checkId" type="hidden" value="<c:out value='${result.userTy}'/>:<c:out value='${result.uniqId}'/>"/>
	                    </td>
	                    <td nowrap style="cursor:pointer;cursor:hand" >
	                        <span class="link"><a href="<c:url value='/uss/umt/user/EgovUserSelectUpdtView.do'/>?selectedId=<c:out value="${result.uniqId}"/>"  onclick="javascript:fnSelectUser('<c:out value="${result.userTy}"/>:<c:out value="${result.uniqId}"/>'); return false;"><c:out value="${result.userId}"/></a></span>
	                    </td>
	                    <td nowrap="nowrap"><c:out value="${result.userNm}"/></td>
	                    <td nowrap="nowrap"><c:out value="${result.emailAdres}"/></td>
	                    <td nowrap="nowrap"><c:out value="${result.areaNo}"/>)<c:out value="${result.middleTelno}"/>-<c:out value="${result.endTelno}"/></td>
	                    <td nowrap="nowrap"><c:out value="${result.sbscrbDe}"/></td>
	                    <td nowrap="nowrap">
	                        <c:forEach var="emplyrSttusCode_result" items="${emplyrSttusCode_result}" varStatus="status">
	                            <c:if test="${result.sttus == emplyrSttusCode_result.code}"><c:out value="${emplyrSttusCode_result.codeNm}"/></c:if>
	                        </c:forEach>
	                    </td>
                      </tr>
                     </c:forEach>     
                    </tbody>
                    </table>
                </div>
                <!-- 페이지 네비게이션 시작 -->
                <div id="paging_div">
                    <ul class="paging_align">
                        <ui:pagination paginationInfo = "${paginationInfo}"  type="image" jsFunction="fnLinkPage" />
                    </ul>
                </div>

				<div class="verticalSpace">&nbsp;</div>
              </form>

</div>
<!-- // main 끝 -->    


<div id="toolbar" style="width:480px;" >&nbsp;</div>


<%@include file="/WEB-INF/inc/end.jspf"%>
