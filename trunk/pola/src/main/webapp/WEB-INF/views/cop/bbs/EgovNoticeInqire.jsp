<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/inc/sst.jspf"%>



<script type="text/javascript" src="<c:url value='/js/EgovBBSMng.js' />"></script>
<c:if test="${anonymous == 'true'}"><c:set var="prefix" value="/anonymous"/></c:if>
<script type="text/javascript">

    
    function fn_egov_select_noticeList(pageNo) {
        document.frm.pageIndex.value = pageNo; 
        document.frm.action = "<c:url value='/cop/bbs${prefix}/selectBoardList.do'/>";
        document.frm.submit();  
    }
    
    function fn_egov_delete_notice() {
        if ("<c:out value='${anonymous}'/>" == "true" && document.frm.password.value == '') {
            alert('등록시 사용한 패스워드를 입력해 주세요.');
            document.frm.password.focus();
            return;
        }
        
        if (confirm('<spring:message code="common.delete.msg" />')) {
            document.frm.action = "<c:url value='/cop/bbs${prefix}/deleteBoardArticle.do'/>";
            document.frm.submit();
        }   
    }
    
    function fn_egov_moveUpdt_notice() {
        if ("<c:out value='${anonymous}'/>" == "true" && document.frm.password.value == '') {
            alert('등록시 사용한 패스워드를 입력해 주세요.');
            document.frm.password.focus();
            return;
        }

        document.frm.action = "<c:url value='/cop/bbs${prefix}/forUpdateBoardArticle.do'/>";
        document.frm.submit();          
    }
    
    function fn_egov_addReply() {
        document.frm.action = "<c:url value='/cop/bbs${prefix}/addReplyBoardArticle.do'/>";
        document.frm.submit();          
    }   
</script>
<!-- 2009.06.29 : 2단계 기능 추가  -->
<c:if test="${useComment == 'true'}">
<c:import url="/cop/bbs/selectCommentList.do" charEncoding="utf-8">
    <c:param name="type" value="head" />
</c:import>
</c:if>
<c:if test="${useSatisfaction == 'true'}">
<c:import url="/cop/bbs/selectSatisfactionList.do" charEncoding="utf-8">
    <c:param name="type" value="head" />
</c:import>
</c:if>
<c:if test="${useScrap == 'true'}">
<script type="text/javascript">
    function fn_egov_addScrap() {
        document.frm.action = "<c:url value='/cop/bbs/addScrap.do'/>";
        document.frm.submit();          
    }
</script>
</c:if>
<!-- 2009.06.29 : 2단계 기능 추가  -->
<title><c:out value='${result.bbsNm}'/> - 글조회</title>

<style type="text/css">
    h1 {font-size:12px;}
    caption {visibility:hidden; font-size:0; height:0; margin:0; padding:0; line-height:0;}
</style>

<div id="main">
	<h3>내용 보기</h3>

                <form name="frm" method="post" action="<c:url value='/cop/bbs${prefix}/selectBoardList.do'/>">
                    <input type="hidden" name="pageIndex" value="<c:out value='${searchVO.pageIndex}'/>">
                    <input type="hidden" name="bbsId" value="<c:out value='${result.bbsId}'/>" >
                    <input type="hidden" name="nttId" value="<c:out value='${result.nttId}'/>" >
                    <input type="hidden" name="parnts" value="<c:out value='${result.parnts}'/>" >
                    <input type="hidden" name="sortOrdr" value="<c:out value='${result.sortOrdr}'/>" >
                    <input type="hidden" name="replyLc" value="<c:out value='${result.replyLc}'/>" >
                    <input type="hidden" name="nttSj" value="<c:out value='${result.nttSj}'/>" >
                    <input type="submit" id="invisible" class="invisible"/>

                    <div class="modify_user" >
                        <table>
                          <tr> 
                            <th width="15%" height="23" nowrap >제목</th>
                            <td width="85%" colspan="5" nowrap="nowrap"><c:out value="${result.nttSj}" />
                            </td>
                          </tr>
                          <tr> 
                            <th width="15%" height="23" nowrap >작성자</th>
                            <td width="15%" nowrap="nowrap">
                            
                            <c:choose>
                                
                                
                                <c:when test="${anonymous == 'true'}">
                                    ******
                                </c:when>
                                <c:when test="${result.ntcrNm == ''}">
                                    <c:out value="${result.frstRegisterNm}" />
                                </c:when>
                                <c:otherwise>
                                    <c:out value="${result.ntcrNm}" />
                                </c:otherwise>
                                
                            </c:choose>
                    
                            </td>
                            <th width="15%" height="23" nowrap >작성시간</th>
                            <td width="15%" nowrap="nowrap"><c:out value="${result.frstRegisterPnttm}" />
                            </td>
                            <th width="15%" height="23" nowrap >조회수</th>
                            <td width="15%" nowrap="nowrap"><c:out value="${result.inqireCo}" />
                            </td>
                          </tr>    
                          <tr> 
                            <th height="23" >글내용</th>
                            <td colspan="5">
                             <div id="bbs_cn">
                               <textarea id="nttCn" name="nttCn"  cols="75" rows="20"  style="width:99%;font-size:10px;" readonly="readonly" title="글내용"><c:out value="${result.nttCn}" escapeXml="true" /></textarea>
                             </div>
                            </td>
                          </tr>
                          <c:if test="${not empty result.atchFileId}">
                              <c:if test="${result.bbsAttrbCode == 'BBSA02'}">
                              <tr> 
                                <th height="23" >첨부이미지</th>
                                <td colspan="5">
                                        <c:import url="/cmm/fms/selectImageFileInfs.do" charEncoding="utf-8">
                                            <c:param name="atchFileId" value="${result.atchFileId}" />
                                        </c:import>
                                </td>
                              </tr>
                              </c:if>
                              <tr> 
                                <th height="23">첨부파일 목록</th>
                                <td colspan="5">
                                    <c:import url="/cmm/fms/selectFileInfs.do" charEncoding="utf-8">
                                        <c:param name="param_atchFileId" value="${result.atchFileId}" />
                                    </c:import>
                                </td>
                              </tr>
                          </c:if>
                          <c:if test="${anonymous == 'true'}">
                          <tr> 
                            <th height="23"><label for="password"><spring:message code="cop.password" /></label></th>
                            <td colspan="5">
                                <input name="password" title="암호" type="password" size="20" value="" maxlength="20" >
                            </td>
                          </tr>
                          </c:if>   
                        </table>
                    </div>

                    <!-- 버튼 시작(상세지정 style로 div에 지정) -->
                    <div class="buttons" style="padding-top:10px;padding-bottom:10px;">
                      <!-- 목록/저장버튼  -->
                      <table border="0" cellspacing="0" cellpadding="0" align="center">
                        <tr>
                         <c:if test="${result.frstRegisterId == sessionUniqId}">     
                              <td>
                                 <a href="#LINK" onclick="javascript:fn_egov_moveUpdt_notice(); return false;">수정</a> 
                              </td>
                              
                              <td width="10"></td>
                              <td>
                                 <a href="#LINK" onclick="javascript:fn_egov_delete_notice(); return false;">삭제</a> 
                              </td>
                         </c:if>    
                         <c:if test="${result.replyPosblAt == 'Y'}">     
                              <td width="10"></td>
                              <td>
                                 <a href="#LINK" onclick="javascript:fn_egov_addReply(); return false;">답글작성</a> 
                              </td>
                          </c:if>
                          <td width="10"></td>
                          <td>
                              <a href="#LINK" onclick="javascript:fn_egov_select_noticeList('1'); return false;">목록</a> 
                          </td>
                        </tr>
                      </table>
                    </div>
                    <!-- 버튼 끝 -->                           
                </form>
</div>
<%@include file="/WEB-INF/inc/end.jspf"%>