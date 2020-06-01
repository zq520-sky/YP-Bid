<%@ page language="java" pageEncoding="utf-8" %>
<%@ include file="/resources/platform/inc.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <script src="${ctx.path}/resources/script/project/projectCompanyManage.js?v=${ctx.version}1"></script>
    <script src="${ctx.path}/resources/js/common/DataForm.js?v=${ctx.version}"></script>
    <script src="${ctx.path}/resources/components/My97DatePicker/WdatePicker.js?v=${ctx.version}"></script>
    <script type="text/javascript">
        $(function () {
            loadCriteria();
        });

        //加载查询条件
        function loadCriteria() {
        }
    </script>
</head>
<body>
<div class="main_con">
    <form class="tableform" action="${ctx.path}/manage/project/company/queryCompanyList${ctx.pageSuffix}"
          method="post"
          id="pageForm">
        <div class="operation_box" id="operation_box">
            <div class="operation_con">
                <div class="currenttit"></div>
                <div class="operation_info">
                    <p:auth mcode="MENU_MANAGE_PROJECT_COMPANY_ADD">
                        <button type="button" class="btn add_btn" onclick="openAddPage();">
                            <i class="minicon addoperation_icon"></i>
                            <span>新增</span>
                        </button>
                    </p:auth>
                    <span class="line">|</span>
                    <p:auth mcode="MENU_MANAGE_PROJECT_COMPANY_EXPORT">
                        <button type="button" class="btn add_btn"
                                onclick="fun_export('${ctx.path}/manage/project/company/exportCompanyList${ctx.bizSuffix}')">
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
                        <input type="text" id="projectCompanyNameSearch" name="projectCompanyName" class="inputtext"
                               placeholder="招标单位名称"
                               value="${projectCompanyVo.projectCompanyName}"/>
                    </li>
                    <li>
                        <label class="inputlabel">更新时间：</label>
                        <input type="text" id="updateDateBeginSearch" name="updateDateBegin" class="inputtext"
                               onclick="WdatePicker({startDate:'%y-%M-%d 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'updateDateEndSearch\')}'})"
                               style="min-width: 120px;"
                               value="<fmt:formatDate value='${projectCompanyVo.updateDateBegin}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
                        <em class="inputto">至</em>
                        <input type="text" id="updateDateEndSearch" name="updateDateEnd" class="inputtext"
                               onclick="WdatePicker({startDate:'%y-%M-%d 23:59:59',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'updateDateBeginSearch\')}'})"
                               style="min-width: 120px;"
                               value="<fmt:formatDate value='${projectCompanyVo.updateDateEnd}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
                    </li>
                </ul>
            </div>
            <div class="search_btncon">
                <p:auth mcode="MENU_MANAGE_PROJECT_COMPANY_SEARCH">
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
                                <th width="120">招标单位编号</th>
                                <th width="160">招标单位名称</th>
                                <th width="80">招标项目数量</th>
                                <th width="120">更新时间</th>
                                <th width="100" class="operation_th">操作</th>
                            </tr>
                        </table>
                    </div>
                </div>
                <div class="tablelist_tbody">
                    <table>
                        <c:if test="${empty pageData.data}">
                            <tr>
                                <td align="center" colspan="10">对不起，没有找到相关数据！</td>
                            </tr>
                        </c:if>
                        <c:forEach items="${pageData.data }" var="data" varStatus="staus">
                            <tr>
                                <td title="${((pageData.page-1)>0?pageData.page-1:0)*pageData.rows+(staus.index + 1) }">
                                        ${((pageData.page-1)>0?pageData.page-1:0)*pageData.rows+(staus.index + 1) }
                                </td>
                                <td title="${data.projectCompanyCode }">${data.projectCompanyCode }</td>
                                <td title="${data.projectCompanyName }">${data.projectCompanyName }</td>
                                <td title="${data.ifbAmount }">${data.ifbAmount }</td>
                                <td title="<fmt:formatDate value='${data.updateDate }' pattern='yyyy-MM-dd HH:mm:ss'/>">
                                    <fmt:formatDate value='${data.updateDate }' pattern='yyyy-MM-dd HH:mm:ss'/>
                                </td>
                                <td class="operation_td">
                                    <p:auth mcode="MENU_MANAGE_PROJECT_COMPANY_VIEW">
                                        <button class="operationbtn" type="button"
                                                onclick="viewPage(${data.projectCompanyId});">
                                            <span>查看</span>
                                        </button>
                                    </p:auth>
                                    <p:auth mcode="MENU_MANAGE_PROJECT_COMPANY_UPDATE">
                                        <button class="operationbtn" type="button"
                                                onclick="editPage(${data.projectCompanyId});">
                                            <span>编辑</span>
                                        </button>
                                    </p:auth>
                                    <p:auth mcode="MENU_MANAGE_PROJECT_COMPANY_DEL">
                                        <button class="operationbtn" type="button"
                                                onclick="delPage(${data.projectCompanyId}, '${data.projectCompanyName}');">
                                            <span>删除</span>
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
<div id="viewProjectCompany" class="add_box mCustomScrollbar_y">
    <form method="post" id="viewForm">
        <div class="add_list">
            <h5>招标单位编号：</h5>
            <div class="add_value">
                <span id="projectCompanyCodeView"></span>
            </div>
        </div>
        <div class="add_list">
            <h5>招标单位名称：</h5>
            <div class="add_value">
                <span id="projectCompanyNameView"></span>
            </div>
        </div>
        <div class="add_list">
            <h5>招标项目数量：</h5>
            <div class="add_value">
                <span id="ifbAmountView"></span>
            </div>
        </div>
        <div class="add_list">
            <h5>更新时间：</h5>
            <div class="add_value">
                <span id="updateDateView"></span>
            </div>
        </div>
    </form>
</div>

<div id="addProjectCompany" class="add_box mCustomScrollbar_y">
    <form method="post" id="addForm" action="${ctx.path}/manage/project/company/addCompany${ctx.bizSuffix}">
        <div class="add_list">
            <h5><em style="color: red;">*</em>招标单位编号：</h5>
            <div class="add_value">
                <input type="text" class="inputtext" name="projectCompanyCode" maxlength="255"
                       id="projectCompanyCodeAdd"/>
            </div>
        </div>
        <div class="add_list">
            <h5><em style="color: red;">*</em>招标单位名称：</h5>
            <div class="add_value">
                <input type="text" class="inputtext" name="projectCompanyName" maxlength="200"
                       id="projectCompanyNameAdd"/>
            </div>
        </div>
        <div class="add_list">
            <h5>招标项目数量：</h5>
            <div class="add_value">
                <input type="text" class="inputtext" name="ifbAmount"
                       id="ifbAmountAdd"/>
            </div>
        </div>
        <div class="add_list">
            <h5><em style="color: red;">*</em>更新时间：</h5>
            <div class="add_value">
                <input type="text" id="updateDateAdd" name="updateDate" class="inputtext"
                       onclick="WdatePicker({startDate:'%y-%M-%d 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss'})"
                       style="min-width: 120px;"/>
            </div>
        </div>
    </form>
</div>

<!-- 编辑 -->
<div id="editProjectCompany" class="add_box mCustomScrollbar_y">
    <form method="post" id="editForm" action="${ctx.path}/manage/project/company/updateCompany${ctx.bizSuffix}">
        <div class="add_list">
            <h5><em style="color: red;">*</em>招标单位编号：</h5>
            <div class="add_value">
                <input type="text" class="inputtext" name="projectCompanyCode" maxlength="255"
                       id="projectCompanyCodeEdit"/>
                <input type="hidden" id="projectCompanyIdEdit" name="projectCompanyId">
            </div>
        </div>
        <div class="add_list">
            <h5><em style="color: red;">*</em>招标单位名称：</h5>
            <div class="add_value">
                <input type="text" class="inputtext" name="projectCompanyName" maxlength="200"
                       id="projectCompanyNameEdit"/>
            </div>
        </div>
        <div class="add_list">
            <h5><em style="color: red;">*</em>招标项目数量：</h5>
            <div class="add_value">
                <input type="text" class="inputtext" name="ifbAmount"
                       id="ifbAmountEdit"/>
            </div>
        </div>
        <div class="add_list">
            <h5><em style="color: red;">*</em>更新时间：</h5>
            <div class="add_value">
                <input type="text" id="updateDateEdit" name="updateDate" class="inputtext"
                       onclick="WdatePicker({startDate:'%y-%M-%d 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss'})"
                       style="min-width: 120px;"/>
            </div>
        </div>
    </form>
</div>
</body>
</html>