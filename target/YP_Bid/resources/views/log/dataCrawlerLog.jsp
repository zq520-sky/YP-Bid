<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/resources/platform/inc.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script src="${ctx.path}/resources/js/common/DataForm.js?v=1.0"></script>
		<script src="${ctx.path}/resources/components/My97DatePicker/WdatePicker.js?v=1.0"></script>
		<script src="${ctx.path}/resources/script/log/custSearchLogManage.js?v=1.0"></script>
		
		<script type="text/javascript">
			$(function() {
				loadCriteria();
			});
			//加载查询条件
			function loadCriteria() {

			}
		</script>
	</head>
	<body>
		<div class="main_con">
			<form class="tableform" action="${ctx.path}/manage/log/queryDataCrawlerLogList${ctx.pageSuffix}" method="post" id="pageForm">
				<div class="operation_box" id="operation_box">
					<div class="operation_con">
						<div class="currenttit"></div>
						<div class="operation_info">
							<p:auth mcode="MENU_MANAGE_LOG_DATA_CRAWLER_LOG_EXPORT">
								<button type="button" class="btn add_btn" onclick="fun_export('${ctx.path}/manage/log/exportDataCrawlerLogList${ctx.bizSuffix}')">
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
									<input type="text" id="datasourceWebname" name="datasourceWebname" class="inputtext" placeholder="数据来源名称" value="${searchDataShow.datasourceWebname}"/>
								</li>
								<li>
									<label class="inputlabel">爬虫执行时间：</label>
									<input type="text" id="startDateTime" name="startDateTime" class="inputtext"
										   onclick="WdatePicker({startDate:'%y-%M-%d 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'endDateTime\')}'})"
										   style="min-width: 120px;"
										   value="<fmt:formatDate value='${searchDataShow.startDateTime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
									<em class="inputto">爬虫结束时间：</em>
									<input type="text" id="endDateTime" name="endDateTime" class="inputtext"
										   onclick="WdatePicker({startDate:'%y-%M-%d 23:59:59',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'startDateTime\')}'})"
										   style="min-width: 120px;"
										   value="<fmt:formatDate value='${searchDataShow.endDateTime}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
								</li>

							</ul>
						</div>
						<div class="search_btncon">
							<p:auth mcode="MENU_MANAGE_LOG_DATA_CRAWLER_LOG_SEARCH">
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
											<th style="text-align:center" width="100">爬虫服务名称</th>
											<th style="text-align:center" width="120">数据来源名称</th>
											<th style="text-align:center" width="140">爬虫执行时间</th>
											<th style="text-align:center" width="140">爬虫结束时间</th>
											<th style="text-align:center" width="80" class="operation_th">爬取数量</th>
										</tr>
									</table>
								</div>
							</div>
							<div class="tablelist_tbody">
								<table>
									<c:if test="${empty pageData.data}">
										<tr>
											<td align="center" colspan="5">对不起，没有找到相关数据！</td>
										</tr>
									</c:if>
									<c:forEach items="${pageData.data }" var="data" varStatus="staus">
										<tr>
											<td title="${((pageData.page-1)>0?pageData.page-1:0)*pageData.rows+(staus.index + 1) }">
												${((pageData.page-1)>0?pageData.page-1:0)*pageData.rows+(staus.index + 1) }
											</td>
											<td style="text-align:center" title="${data.datacrawlerServiceName }" width="100">${data.datacrawlerServiceName }</td>
											<td style="text-align:center" title="${data.datasourceWebname }" width="120">${data.datasourceWebname }</td>
											<td style="text-align:center" width="140" title="<fmt:formatDate value='${data.crawlerStartTime }' pattern='yyyy-MM-dd HH:mm:ss'/>">
												<fmt:formatDate value='${data.crawlerStartTime }' pattern='yyyy-MM-dd HH:mm:ss'/>
											</td>
											<td style="text-align:center" width="140" title="<fmt:formatDate value='${data.crawlerEndTime }' pattern='yyyy-MM-dd HH:mm:ss'/>">
												<fmt:formatDate value='${data.crawlerEndTime }' pattern='yyyy-MM-dd HH:mm:ss'/>
											</td>
											<td style="text-align:center" title="${data.crawlerNum }" width="80">${data.crawlerNum }</td>
										</tr>
									</c:forEach>
								</table>
							</div>
						</div>
					</div>
				<jsp:include page="/resources/common/page.jsp"></jsp:include>
			</form>
		</div>

		<!-- 查看 -->
		<div id="viewCustomer" class="add_box mCustomScrollbar_y">
			<form method="post" id="viewForm">
				<div class="add_list">
					<h5>客户编号：</h5>
					<div class="add_value">
						<span id="custCodeView"></span>
					</div>
				</div>
				<div class="add_list">
					<h5>手机号码：</h5>
					<div class="add_value">
						<span id="mobileView"></span>
					</div>
				</div>
				<div class="add_list">
					<h5>头像：</h5>
					<div class="add_value">
						<span id="headImgView"></span>
					</div>
				</div>
				<div class="add_list">
					<h5>昵称：</h5>
					<div class="add_value">
						<span id="nickNameView"></span>
					</div>
				</div>
				<div class="add_list">
					<h5>性别：</h5>
					<div class="add_value">
						<span id="sexView"></span>
					</div>
				</div>
				<div class="add_list">
					<h5>所在省市：</h5>
					<div class="add_value">
						<span id="provinceNameView"></span>
						<span id="provinceShortView"></span>
					</div>
				</div>
				<div class="add_list">
					<h5>公司名称：</h5>
					<div class="add_value">
						<span id="companyNameView"></span>
					</div>job
				</div>
				<div class="add_list">
					<h5>职业名称：</h5>
					<div class="add_value">
						<span id="jobView"></span>
					</div>
				</div>
				<div class="add_list">
					<h5>是否会员：</h5>
					<div class="add_value">
						<span id="isMemberView"></span>
					</div>
				</div>
				<div class="add_list">
					<h5>是否禁用：</h5>
					<div class="add_value">
						<span id="isForbidView"></span>
					</div>
				</div>
				<div class="add_list">
					<h5>注册时间：</h5>
					<div class="add_value">
						<span id="registerDateView"></span>
					</div>
				</div>
			</form>
		</div>

	</body>
</html>

