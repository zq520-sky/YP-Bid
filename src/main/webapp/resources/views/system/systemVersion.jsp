<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ include file="/resources/platform/inc.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <script src="${ctx.path}/resources/js/common/DataForm.js?v=${ctx.version}"></script>
    <script src="${ctx.path}/resources/script/system/systemVersion.js?v=${ctx.version}"></script>
    <script src="${ctx.path}/resources/components/My97DatePicker/WdatePicker.js?v=${ctx.version}"></script>
    <script type="text/javascript">
        $(function () {
            loadCriteria();
        });

        //加载查询条件
        function loadCriteria() {
        }
    </script>
    <script type="text/javascript">
        //加载查询条件
        function doSearch() {
            $("#pageForm").submit();
            top.progressbar(frameId);
        }
    </script>
    <style type="text/css">
        .hideTr {
            display: none;
        }
    </style>
</head>
<body>
<div class="main_con">
    <form class="tableform" action="${ctx.path}/manage/platform/version/queryVersionList${ctx.pageSuffix}" method="post"
          id="pageForm">
        <div class="operation_box" id="operation_box">
            <div class="operation_con">
                <div class="currenttit"></div>
                <div class="operation_info">
                    <p:auth mcode="MENU_SYSTEM_VERSION_ADD">
                        <button type="button" class="btn add_btn"
                                onclick="openAddPage()">
                            <i class="minicon exportoperation_icon"></i><span>新增</span>
                        </button>
                        <span class="line">|</span>
                    </p:auth>
                    <p:auth mcode="MENU_SYSTEM_VERSION_EXPORT">
                        <button type="button" class="btn add_btn"
                                onclick="fun_export('${ctx.path}/manage/platform/version/exportVersionList${ctx.bizSuffix}')">
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
                        <input type="text" id="hotwordame" name="mobile" class="inputtext" placeholder="热词内容"
                               value="${searchHotwordVo.hotwordName}"/>
                    </li>
                </ul>
            </div>
            <div class="search_btncon">
                <p:auth mcode="MENU_SYSTEM_VERSION_SEARCH">
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
                                <th width="150">App版本号</th>
                                <th width="150">是否强制更新</th>
                                <th width="150">更新内容</th>
                                <th width="150">发布时间</th>
                                <th width="200" class="operation_th">操作</th>
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
                                <td title="${data.versionCode }">${data.versionCode }</td>
                                <td title="${data.isForceUpdateCn }">${data.isForceUpdateCn }</td>
                                <td title="${data.updateMemo }">${data.updateMemo }</td>
                                <td title="<fmt:formatDate value='${data.publishTime }' pattern='yyyy-MM-dd HH:mm:ss'/>">
                                    <fmt:formatDate value='${data.publishTime }' pattern='yyyy-MM-dd HH:mm:ss'/>
                                </td>
                                <td class="operation_td">
                                    <p:auth mcode="MENU_SYSTEM_VERSION_VIEW">
                                        <button class="operationbtn" type="button"
                                                onclick="viewPage(${data.versionId});">
                                            <span>查看</span>
                                        </button>
                                    </p:auth>
                                    <p:auth mcode="MENU_SYSTEM_VERSION_UPDATE">
                                        <button class="operationbtn" type="button"
                                                onclick="editPage(${data.versionId});">
                                            <span>编辑</span>
                                        </button>
                                    </p:auth>
                                    <p:auth mcode="MENU_SYSTEM_VERSION_DEL">
                                        <button class="operationbtn" type="button"
                                                onclick="delHotWord(${data.versionId});">
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
<div id="viewId" class="add_box mCustomScrollbar_y">
    <form method="post" id="viewForm">
        <div class="add_list">
            <h5>App版本号：</h5>
            <div class="add_value">
                <span id="versionCode"></span>
            </div>
        </div>
        <div class="add_list">
            <h5>是否强制更新：</h5>
            <div class="add_value">
                <span id="isForceUpdateCn"></span>
            </div>
        </div>
        <div class="add_list">
            <h5>更新内容：</h5>
            <div class="add_value">
                <span id="updateMemo"></span>
            </div>
        </div>
        <div class="add_list">
            <h5>发布时间：</h5>
            <div class="add_value">
                <span id="publishTime"></span>
            </div>
        </div>
    </form>
</div>

<!-- 新增 -->
<div id="addId" name="addVersion" class="add_box mCustomScrollbar_y" data-mcs-theme="dark" style="display:none;">
    <form method="post" id="addForm" action="${ctx.path}/manage/platform/version/addVersion${ctx.bizSuffix}">
        <div class="add_list">
            <h5><em style="color: red;">*</em>App版本号：</h5>
            <div class="add_value">
                <input type="text" id="versionCodeAdd" name="versionCode" maxlength="32" class="inputtext"
                       style="width: 175px;"/>
            </div>
        </div>
        <div class="add_list">
            <h5><em style="color: red;">*</em>是否强制更新：</h5>
            <div class="add_value">
                <select class="select" name="isForceUpdate" id="isForceUpdateAdd" type="select" style="width: 175px;">
                    <option value="1">
                        是
                    </option>
                    <option value="0">
                        否
                    </option>
                </select>
            </div>
        </div>
        <div class="add_list">
            <h5><em style="color: red;">*</em>更新内容：</h5>
            <div class="add_value">
                <input type="text" id="updateMemoAdd" name="updateMemo" maxlength="32" class="inputtext"
                       style="width: 50px;"/>
            </div>
        </div>

        <div class="add_list">
            <h5><em style="color: red;">*</em>下载地址：</h5>
            <div class="add_value">
                <input type="text" id="downUrlAdd" name="downUrl" maxlength="32" class="inputtext"
                       style="width: 50px;"/>
            </div>
        </div>

        <div class="add_list">
            <h5><em style="color: red;">*</em>发布时间：</h5>
            <div class="add_value">
                <input type="text" id="publishTimeAdd" name="publishTime" class="inputtext"
                       onclick="WdatePicker({startDate:'%y-%M-%d 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss'})"
                       style="min-width: 120px;"/>
            </div>
        </div>

    </form>
</div>

<!-- 编辑 -->
<div id="editId" name="editName" class="add_box mCustomScrollbar_y" data-mcs-theme="dark" style="display:none;">
    <form method="post" id="editForm" action="${ctx.path}/manage/platform/version/updateVersion${ctx.bizSuffix}">
        <input type="hidden" id="versionIdEdit" name="versionId"/>
        <div class="add_list">
            <h5><em style="color: red;">*</em>App版本号：</h5>
            <div class="add_value">
                <input type="text" id="versionCodeEdit" name="versionCode" maxlength="32" class="inputtext"
                       style="width: 175px;"/>
            </div>
        </div>
        <div class="add_list">
            <h5><em style="color: red;">*</em>是否强制更新：</h5>
            <div class="add_value">
                <select class="select" name="isForceUpdate" id="isForceUpdateEdit" type="select" style="width: 175px;">
                    <option value="1">
                        是
                    </option>
                    <option value="0">
                        否
                    </option>
                </select>
            </div>
        </div>
        <div class="add_list">
            <h5><em style="color: red;">*</em>更新内容：</h5>
            <div class="add_value">
                <input type="text" id="updateMemoEdit" name="updateMemo" maxlength="32" class="inputtext"
                       style="width: 175px;"
                       style="width: 50px;"/>
            </div>
        </div>


        <div class="add_list">
            <h5><em style="color: red;">*</em>发布时间：</h5>
            <div class="add_value">
                <input type="text" id="publishTimeEdit" name="publishTime" class="inputtext"
                       onclick="WdatePicker({startDate:'%y-%M-%d 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss'})"
                       style="min-width: 120px;width:173px;"/>
            </div>
        </div>
    </form>
</div>

</body>
</html>