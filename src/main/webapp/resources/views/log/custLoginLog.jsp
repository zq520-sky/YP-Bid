<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/resources/platform/inc.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script src="${ctx.path}/resources/js/common/DataForm.js?v=1.0"></script>
		<script src="${ctx.path}/resources/script/log/custLoginLogManage.js?v=1.0"></script>
		
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
			<form class="tableform" action="${ctx.path}/manage/log/queryAppLogLoginList${ctx.pageSuffix}" method="post" id="pageForm">
				<div class="operation_box" id="operation_box">
					<div class="operation_con">
						<div class="currenttit"></div>
						<div class="operation_info">
							<p:auth mcode="MENU_MANAGE_CUST_LOG_EXPORT">
								<button type="button" class="btn add_btn" onclick="fun_export('${ctx.path}/manage/log/exportCustLoginLogList${ctx.bizSuffix}')">
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
								</li>
								<li>
									<input type="text" id="mobile" name="mobile" class="inputtext" placeholder="手机号" value="${searchDataShow.mobile}" />
								</li>
								<li>
									<input type="text" id="loginIp" name="loginIp" class="inputtext" placeholder="登录ip" value="${searchDataShow.loginIp}" />
								</li>
								<li>
									<label class="inputlabel">登陆方式：</label>
									<select class="select" name="loginType">
										<option value="">全部</option>
										<option value= "1" <c:if test="${searchDataShow.loginType == 1}">selected</c:if>>密码登录</option>
										<option value= "2" <c:if test="${searchDataShow.loginType == 2}">selected</c:if>>验证码登录</option>
									</select>
								</li>
							</ul>
						</div>
						<div class="search_btncon">
							<p:auth mcode="MENU_MANAGE_CUST_LOG_SEARCH">
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
											<th width="120">客户编号</th>
											<th width="120">手机号</th>
											<th width="120">头像</th>
											<th width="120">昵称</th>
											<th width="120">登陆方式</th>
											<th width="160">登陆IP</th>
											<th width="160">登陆时间</th>
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
											<td title="${data.custCode }" width="120">${data.custCode }</td>
											<td title="${data.mobile }" width="120">${data.mobile }</td>
											<c:if test="${empty data.headImg}">
												<td align="center">暂无头像</td>
											</c:if>
											<c:if test="${!empty data.headImg}">
												<td align="center" width="120">${data.headImg} </td>
											</c:if>
											<td title="${data.nickName }" width="120">${data.nickName }</td>
											<c:if test="${data.loginType == 1}">
												<td align="center">密码登录</td>
											</c:if>
											<c:if test="${data.loginType == 2}">
												<td align="center">验证码登录</td>
											</c:if>
											<td title="${data.loginIp }" width="160">${data.loginIp }</td>
											<td width="160" title="<fmt:formatDate value='${data.loginDate }' pattern='yyyy-MM-dd HH:mm:ss'/>">
												<fmt:formatDate value='${data.loginDate }' pattern='yyyy-MM-dd HH:mm:ss'/>
											</td>

											<td width="180" class="operation_td">
												<p:auth mcode="MENU_MANAGE_CUST_LOG_LOOK">
													<button class="operationbtn" type="button" onclick="viewPage(${data.logLoginId});">
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
					<h5>登陆方式：</h5>
					<div class="add_value">
						<span id="loginTypeView"></span>
					</div>
				</div>
				<div class="add_list">
					<h5>登陆ip：</h5>
					<div class="add_value">
						<span id="loginIpView"></span>
					</div>
				</div>
				<div class="add_list">
					<h5>登陆时间：</h5>
					<div class="add_value">
						<span id="loginDateView"></span>
					</div>
				</div>
			</form>
		</div>

	</body>
</html>

