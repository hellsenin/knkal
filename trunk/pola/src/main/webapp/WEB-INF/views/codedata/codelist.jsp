<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/inc/sst.jspf"%>
    <script type="text/javascript" src="${wc}/js/paging.js"></script>
    <style>
        .x-grid-cell-topic b {
            display: block;
        }
        .x-grid-cell-topic .x-grid-cell-inner {
            white-space: normal;
        }
        .x-grid-cell-topic a {
            color: #385F95;
            text-decoration: none;
        }
        .x-grid-cell-topic a:hover {
            text-decoration:underline;
        }
		.x-grid-cell-topic .x-grid-cell-innerf {
			padding: 5px;
		}
		.x-grid-rowbody {
	        padding: 0 5px 5px 5px; 
		}
    </style>



<div id="main">
	<h3>Code Data 목록</h3>


			<form>

                <div id="page_info"></div>                    

						<div id="topic-grid"></div>


				<div class="verticalSpace">&nbsp;</div>
				
            </form>

</div>
<!-- // main 끝 --> 


<%@include file="/WEB-INF/inc/end.jspf"%>
