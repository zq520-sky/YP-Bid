<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/resources/platform/inc.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>每日爬取统计报表</title>
	<script src="${ctx.path}/resources/js/common/DataForm.js?v=1.0"></script>
	<script src="${ctx.path}/resources/components/My97DatePicker/WdatePicker.js?v=1.0"></script>
	<script src="${ctx.path}/resources/script/count/ererydayCrawlerReport.js?v=1.0"></script>
	<script type="text/javascript">

	</script>
</head>
<body>
<div class="main_con">
	<form class="tableform" action="/manage/count/queryDataCrawlerReportList.do" method="post" id="pageForm">
		<div class="operation_box" id="operation_box">
			<div class="operation_con">
				<div class="currenttit"></div>
				<div class="operation_info">
					<p:auth mcode="MENU_MANAGE_REPORT_CRAWLER_DAYREPORT_SEARCH">
						<button type="button" class="btn add_btn" onclick="fun_export('/manage/count/exportDataCrawlerReportList.json')">
							<i class="minicon exportoperation_icon"></i><span>导出</span>
						</button>
					</p:auth>
				</div>
			</div>
		</div>
		<div class="search_box" id="search_box">
			<div class="search_nav">
				<ul>
					<li>
						<label class="inputlabel">项目类型：</label>
						<select class="select" name="projectType">
							<option value="">全部</option>
							<option value= "1" <c:if test="${searchDataShow.projectType == 1}">selected</c:if>>招标项目</option>
							<option value= "2" <c:if test="${searchDataShow.projectType == 2}">selected</c:if>>拟建项目</option>
						</select>
					</li>
					<li>
						<label class="inputlabel">爬取日期：</label>
						<input value="<c:if test="${searchDataShow.startDateTime != null}"><fmt:formatDate value="${searchDataShow.startDateTime}" pattern="yyyy-MM-dd" /></c:if>" type="text" id="startDateTime" name="startDateTime" class="inputtext" onclick="WdatePicker({startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'endDateTime\')}'})" style="min-width: 120px;" />
						<em class="inputto">至</em>
						<input value="<c:if test="${searchDataShow.endDateTime != null}"><fmt:formatDate value="${searchDataShow.endDateTime}" pattern="yyyy-MM-dd" /></c:if>" type="text" id="endDateTime" name="endDateTime" class="inputtext" onclick="WdatePicker({startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'startDateTime\')}'})" style="min-width: 120px;" />
					</li>
				</ul>
			</div>
			<div class="search_btncon">
				<p:auth mcode="MENU_MANAGE_REPORT_CRAWLER_DAYREPORT_SEARCH">
					<button type="button" class="btn add_btn" onClick="doSearch()">
						<i class="minicon search_icon"></i>
						<span>查询</span>
					</button>
				</p:auth>
				<button type="button" class="btn export_btn clearToolBtn">
					<i class="minicon reload_icon"></i>
					<span>重置</span>
				</button>
			</div>
		</div>

		<div class="tablelist_box tablelistboxH">
			<div class="tablelist_con">
				<div class="tablelist_theadbox">
					<div class="tablelist_thead">
						<table>
							<tr>
								<th width="50">序号</th>
								<th style="text-align:center" width="130" class="change">项目类型</th>
								<th style="text-align:center" width="130" class="change">爬取总数量(当天)</th>
								<th style="text-align:center" width="160" class="change">爬取日期</th>
							</tr>
						</table>
					</div>
				</div>
				<div class="tablelist_tbody">
					<table>
						<c:if test="${empty pageData.data}">
							<tr>
								<td align="center" colspan="5">查无此数据！</td>
							</tr>
						</c:if>
						<c:forEach items="${pageData.data }" var="data" varStatus="staus">
							<tr>
								<td width="50" title="${((pageData.page-1)>0?pageData.page-1:0)*pageData.rows+(staus.index + 1) }">
										${((pageData.page-1)>0?pageData.page-1:0)*pageData.rows+(staus.index + 1) }
								</td>
								<c:if test="${data.projectType == 1}">
									<td style="text-align:center" width="130" align="center">招投标项目</td>
								</c:if>
								<c:if test="${data.projectType == 2}">
									<td style="text-align:center" width="130" align="center">拟建项目</td>
								</c:if>
								<td style="text-align:center" width="130" title="${data.crawlerNum }">${data.crawlerNum }</td>
								<td style="text-align:center" width="160"><fmt:formatDate value="${data.crawlerDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
		<jsp:include page="/resources/common/page.jsp"></jsp:include>
	</form>
</div>
</body>
</html>