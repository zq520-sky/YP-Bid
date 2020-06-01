<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/resources/platform/inc.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script src="${ctx.path}/resources/js/common/DataForm.js?v=1.0"></script>
		<script src="${ctx.path}/resources/script/log/custVisitLogManage.js?v=1.0"></script>
		
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
			<form class="tableform" action="${ctx.path}/manage/log/queryCstVisitLogList${ctx.pageSuffix}" method="post" id="pageForm">
				<div class="operation_box" id="operation_box">
					<div class="operation_con">
						<div class="currenttit"></div>
						<div class="operation_info">
							<p:auth mcode="MENU_MANAGE_LOG_CUST_VISIT_LOG_EXPORT">
								<button type="button" class="btn add_btn" onclick="fun_export('${ctx.path}/manage/log/exportCstVisitLogList${ctx.bizSuffix}')">
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
									<input type="text" id="custCode" name="custCode" class="inputtext" placeholder="客户编号" value="${searchDataShow.custCode}"/>
									<%--<st:commonSelect className="select" name="sysRole.departId" sql="select depart_id as val, depart_name as text from t_sys_depart where status = 1 order by order_num"/>--%>
								</li>
								<li>
									<input type="text" id="mobile" name="mobile" class="inputtext" placeholder="手机号" value="${searchDataShow.mobile}" />
								</li>


							</ul>
						</div>
						<div class="search_btncon">
							<p:auth mcode="MENU_MANAGE_LOG_CUST_VISIT_LOG_SEARCH">
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
											<th width="90">客户编号</th>
											<th width="100">手机号</th>
											<th width="120">招标行业类型</th>
											<th width="120">项目标题</th>
											<th width="160">访问时间</th>
											<th width="180" class="operation_th">操作</th>
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
											<td title="${data.custCode }" width="90">${data.custCode }</td>
											<td title="${data.mobile }" width="100">${data.mobile }</td>
											<td title="${data.industryName }" width="120">${data.industryName }</td>
											<td title="${data.projectTitle }" width="120">${data.projectTitle }</td>
											<td width="160" title="<fmt:formatDate value='${data.visitDate }' pattern='yyyy-MM-dd HH:mm:ss'/>">
												<fmt:formatDate value='${data.visitDate }' pattern='yyyy-MM-dd HH:mm:ss'/>
											</td>
											<td width="180" class="operation_td">
												<p:auth mcode="MENU_MANAGE_CUST_LOG_LOOK">
													<button class="operationbtn" type="button" onclick="viewPage(${data.visitId});">
														<span>查看</span>
													</button>
												</p:auth>
											</td>
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
					<h5>项目标题：</h5>
					<div class="add_value">
						<span id="projectTitleView"></span>
					</div>
				</div>
				<div class="add_list">
					<h5>招标行业类型：</h5>
					<div class="add_value">
						<span id="industryNameView"></span>
					</div>
				</div>
				<div class="add_list">
					<h5>访问时间：</h5>
					<div class="add_value">
						<span id="visitDateView"></span>
					</div>
				</div>
			</form>
		</div>

	</body>
</html>

