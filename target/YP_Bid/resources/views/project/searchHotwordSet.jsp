<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ include file="/resources/platform/inc.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <script src="${ctx.path}/resources/js/common/DataForm.js?v=${ctx.version}"></script>
    <script src="${ctx.path}/resources/script/project/searchHotwordSet.js?v=${ctx.version}"></script>
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
    <form class="tableform" action="${ctx.path}/manage/project/hotword/queryHotwordList${ctx.pageSuffix}" method="post"
          id="pageForm">
        <div class="operation_box" id="operation_box">
            <div class="operation_con">
                <div class="currenttit"></div>
                <div class="operation_info">
                    <p:auth mcode="MENU_MANAGE_PROJECT_HOTWORD_ADD">
                        <button type="button" class="btn add_btn"
                                onclick="openAddPage()">
                            <i class="minicon exportoperation_icon"></i><span>新增</span>
                        </button>
                        <span class="line">|</span>
                    </p:auth>
                    <p:auth mcode="MENU_MANAGE_PROJECT_HOTWORD_EXPORT">
                        <button type="button" class="btn add_btn"
                                onclick="fun_export('${ctx.path}/manage/project/hotword/exportHotwordList${ctx.bizSuffix}')">
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
                        <input type="text" id="hotwordName" name="hotwordName" class="inputtext" placeholder="热词内容"
                               value="${searchHotwordVo.hotwordName}"/>
                    </li>
                </ul>
            </div>
            <div class="search_btncon">
                <p:auth mcode="MENU_MANAGE_PROJECT_HOTWORD_SEARCH">
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
                                <th width="150">热词内容</th>
                                <th width="150">搜索次数</th>
                                <th width="150">新增时间</th>
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
                                <td title="${data.hotwordName }">${data.hotwordName }</td>
                                <td title="${data.searchTimes }">${data.searchTimes }</td>
                                <td title="<fmt:formatDate value='${data.createDate }' pattern='yyyy-MM-dd HH:mm:ss'/>">
                                    <fmt:formatDate value='${data.createDate }' pattern='yyyy-MM-dd HH:mm:ss'/>
                                </td>
                                <td class="operation_td">
                                    <p:auth mcode="MENU_MANAGE_PROJECT_HOTWORD_VIEW">
                                        <button class="operationbtn" type="button" onclick="viewPage(${data.hotwordId});">
                                            <span>查看</span>
                                        </button>
                                    </p:auth>
                                    <p:auth mcode="MENU_MANAGE_PROJECT_HOTWORD_UPDATE">
                                        <button class="operationbtn" type="button" onclick="editPage(${data.hotwordId});">
                                            <span>编辑</span>
                                        </button>
                                    </p:auth>
                                    <p:auth mcode="MENU_MANAGE_PROJECT_HOTWORD_DEL">
                                        <button class="operationbtn" type="button" onclick="delHotWord(${data.hotwordId});">
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
<div id="viewId" class="add_box mCustomScrollbar_y" >
    <form method="post" id="viewForm">
        <div class="add_list">
            <h5>搜索热词：</h5>
            <div class="add_value">
                <span id="hotwordName"></span>
            </div>
        </div>
        <div class="add_list">
            <h5>搜索次数：</h5>
            <div class="add_value">
                <span id="searchTimes"></span>
            </div>
        </div>
        <div class="add_list">
            <h5>新增时间：</h5>
            <div class="add_value">
                <span id="createDate"></span>
            </div>
        </div>
    </form>
</div>

<!-- 新增 -->
<div id="addId" name="addHotWord" class="add_box mCustomScrollbar_y" data-mcs-theme="dark" style="display:none;">
    <form method="post" id="addForm" action="${ctx.path}/manage/project/hotword/addHotword${ctx.bizSuffix}">
        <div class="add_list">
            <h5><em style="color: red;">*</em>搜索热词：</h5>
            <div class="add_value">
                <input type="text" id="hotwordNameAdd" name="hotwordName" maxlength="32" class="inputtext" />
            </div>
        </div>
        <div class="add_list">
            <h5><em style="color: red;">*</em>所属类别：</h5>
            <div class="add_value">
                <select class="select" name="projectType" id="projectTypeAdd" type="select">
                    <option value="">全部</option>
                    <option value="1">
                        招投标项目
                    </option>
                </select>
            </div>
        </div>
        <div class="add_list">
            <h5><em style="color: red;">*</em>搜索次数：</h5>
            <div class="add_value">
                <input type="text" id="searchTimesAdd" name="searchTimes" maxlength="64" class="inputtext" />
            </div>
        </div>

    </form>
</div>

<!-- 编辑 -->
<div id="editId" name="editName" class="add_box mCustomScrollbar_y" data-mcs-theme="dark" style="display:none;">
    <form method="post" id="editForm" action="${ctx.path}/manage/project/hotword/updateHotword${ctx.bizSuffix}">
        <input type="hidden" id="hotwordIdEdit" name="hotwordId" />
        <div class="add_list">
            <h5><em style="color: red;">*</em>热词内容：</h5>
            <div class="add_value">
                <input type="text" class="inputtext" name="hotwordName" id="hotwordNameEdit"/>
            </div>
        </div>
        <div class="add_list">
            <h5><em style="color: red;">*</em>搜索次数：</h5>
            <div class="add_value">
                <input type="text" class="inputtext" name="searchTimes" id="searchTimesEdit"/>
            </div>
        </div>

        <div class="add_list">
            <h5><em style="color: red;">*</em>新增时间：</h5>
            <div class="add_value">
                <input type="text" id="createDateEdit" name="createDate" class="inputtext"
                       onclick="WdatePicker({createDate:'%y-%M-%d 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss'})"
                       style="min-width: 120px;"/>
            </div>
        </div>
    </form>
</div>

</body>
</html>