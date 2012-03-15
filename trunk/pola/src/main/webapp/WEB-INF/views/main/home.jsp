<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/inc/sst.jspf"%>


<div id="main">
	<h3>개방형 리스크 관리 시스템</h3>

	<p>When developing the blog for our new web 2.0 startup, I got a
		template from the open source web design site. I found a picture on
		flickr, which I thought really helped to communicate the idea. It was
		very easy to turn the oswd template into a blogger template, and I was
		very quickly able to use the results to demonstrate to the rest of the
		team the basics of blogger. When it came time to deliver the Queen
		Street News, a syndication community based on a cool street in
		Toronto, each of the oswd templates that I tried, gave me some
		difficulties. Embracing this new constraint, I made a highly
		derivative template of my own. I am posting it back on the oswd, as a
		way of thanking my inspiration.</p>


	<!-- 최신업무공지 시작 -->
	<div id="main_rightcontent">
		<ul>
			<li>
				<div class="board_title2">
					<div class="t2_leftdiv">
						<img src="<c:url value='/'/>images/index/img_subtitle03.gif"
							width="107" height="17" alt="최신 업무공지 정보" />
					</div>
					<div class="t2_rightdiv">
						<a
							href="<c:url value='/cop/bbs/selectBoardList.do?bbsId=BBSMSTR_AAAAAAAAAAAA'/>"
							onclick="javascript:goMenuPage('1000000');"> more+ </a>
					</div>
				</div>
			</li>
		</ul>
		<c:forEach var="result" items="${notiList}" varStatus="status">
			<ul>
				<li><div class="dot_bl2">
						<a
							href="<c:url value='/cop/bbs/selectBoardList.do?bbsId=BBSMSTR_CCCCCCCCCCCC'/>"><c:out
								value="${result.nttSj}" /></a>
					</div></li>
				<li><div class="new">
						<img src="<c:url value='/'/>images/index/img_new.gif" alt="new" />
					</div></li>
				<li><div class="rwriter">
						<c:out value="${result.frstRegisterNm}" />
					</div></li>
				<li><div class="rdate">
						<c:out value="${result.frstRegisterPnttm}" />
					</div></li>
			</ul>
		</c:forEach>
	</div>

	<div class="clear"></div>


	<h3>Features</h3>

	<p>
		The site is intended to be a very readable online newspaper. There are
		no distractions from the news, but still a pleasing layout. I
		preserved the balance and use of fonts of my inspirations. It loads
		really, quickly, which hopefully also adds to a professional feel. The
		intent of our business is community marketing through storytelling,
		much like amazon selling books with reviews. We want English majors,
		to do the writing. The technical and design elements are to not
		distract from the excellent writing. The site is valid XHTML 1.1 and
		CSS, and I have maintained a standards based approach to the more
		technical aspects of the rest of the project as well.
	</p>

	<h3>About the author</h3>

	<p>
		My dad and I have raised 2 families basically from the avails of
		computing. We both find ourselves energized by students, and would
		like to provide an opportunity for learners to try their careers on
		for size while studying. Computers, are/were our livelihood, and we
		hope to profit financially from this application of our livelihood as
		well as help my son's to make some money.
	</p>
	
</div>
<!-- end of main -->

<%@include file="/WEB-INF/inc/end.jspf"%>
