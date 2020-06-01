<%@ page language="java" pageEncoding="utf-8" %>
<%@ include file="/resources/platform/inc.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <script src="${ctx.path}/resources/script/datasource/datasourceTypeManage.js?v=${ctx.version}1"></script>
    <script src="${ctx.path}/resources/js/common/DataForm.js?v=${ctx.version}"></script>
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
    <form class="tableform" action="${ctx.path}/manage/datasource/type/queryDatasourceTypeList${ctx.pageSuffix}" method="post"
          id="pageForm">
        <div class="operation_box" id="operation_box">
            <div class="operation_con">
                <div class="currenttit"></div>
                <div class="operation_info">
                    <p:auth mcode="MENU_MANAGE_DATASOURCE_TYPE_ADD">
                        <button type="button" class="btn add_btn" onclick="openAddPage();">
                            <i class="minicon addoperation_icon"></i>
                            <span>新增</span>
                        </button>
                    </p:auth>
                    <span class="line">|</span>
                    <p:auth mcode="MENU_MANAGE_DATASOURCE_TYPE_EXPORT">
                        <button type="button" class="btn add_btn"
                                onclick="fun_export('${ctx.path}/manage/datasource/type/exportDatasourceTypeList${ctx.bizSuffix}')">
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
                        <input type="text" id="datasourceTypeNameSearch" name="datasourceTypeName" class="inputtext"
                               placeholder="数据来源类型名称"
                               value="${datasourceTypeVo.datasourceTypeName}"/>
                    </li>
                </ul>
            </div>
            <div class="search_btncon">
                <p:auth mcode="MENU_MANAGE_DATASOURCE_TYPE_SEARCH">
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
                                <th width="160">数据来源名称</th>
                                <th width="180">备注</th>
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
                                <td title="${data.datasourceTypeName }">${data.datasourceTypeName }</td>
                                <td title="${data.remark }">${data.remark }</td>
                                <td class="operation_td">
                                    <p:auth mcode="MENU_MANAGE_DATASOURCE_TYPE_VIEW">
                                        <button class="operationbtn" type="button" onclick="viewPage(${data.datasourceTypeId});">
                                            <span>查看</span>
                                        </button>
                                    </p:auth>
                                    <p:auth mcode="MENU_MANAGE_DATASOURCE_TYPE_UPDATE">
                                        <button class="operationbtn" type="button" onclick="editPage(${data.datasourceTypeId});">
                                            <span>编辑</span>
                                        </button>
                                    </p:auth>
                                    <p:auth mcode="MENU_MANAGE_DATASOURCE_TYPE_DEL">
                                        <button class="operationbtn" type="button" onclick="delPage(${data.datasourceTypeId}, '${data.datasourceTypeName}');">
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
<div id="viewDatasourceType" class="add_box mCustomScrollbar_y">
    <form method="post" id="viewForm">
        <div class="add_list">
            <h5>数据来源类型名称：</h5>
            <div class="add_value">
                <span id="datasourceTypeNameView"></span>
            </div>
        </div>
        <div class="add_list">
            <h5>备注：</h5>
            <div class="add_value">
                <span id="remarkView"></span>
            </div>
        </div>
    </form>
</div>

<div id="AddDatasourceType" class="add_box mCustomScrollbar_y">
    <form method="post" id="addForm" action="${ctx.path}/manage/datasource/type/addDatasourceType${ctx.bizSuffix}">
        <div class="add_list">
            <h5><em style="color: red;">*</em>数据来源类型名称：</h5>
            <div class="add_value">
                <input type="text" class="inputtext" name="datasourceTypeName" maxlength="50" id="datasourceTypeNameAdd"/>
            </div>
        </div>
        <div class="add_list">
            <h5>备注：</h5>
            <div class="add_value">
                <textarea class="textarea" id="remarkAdd" name="remark" maxlength="200" style="height:90px;"></textarea>
            </div>
        </div>
    </form>
</div>

<!-- 编辑 -->
<div id="editDatasourceType" class="add_box mCustomScrollbar_y">
    <form method="post" id="editForm" action="${ctx.path}/manage/datasource/type/updateDatasourceType${ctx.bizSuffix}">
        <div class="add_list">
            <h5><em style="color: red;">*</em>数据来源类型名称：</h5>
            <div class="add_value">
                <input type="text" class="inputtext" name="datasourceTypeName" maxlength="50" id="datasourceTypeNameEdit"/>
                <input type="hidden" name="datasourceTypeId" id="datasourceTypeIdEdit"/>
            </div>
        </div>
        <div class="add_list">
            <h5>备注：</h5>
            <div class="add_value">
                <textarea class="textarea" id="remarkEdit" name="remark" maxlength="200" style="height:90px;"></textarea>
            </div>
        </div>
    </form>
</div>
</body>
</html>