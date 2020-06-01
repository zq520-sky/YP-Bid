<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ include file="/resources/platform/inc.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <script src="${ctx.path}/resources/js/common/DataForm.js?v=${ctx.version}"></script>
    <script src="${ctx.path}/resources/script/datasource/datasourceIndustryList.js?v=${ctx.version}"></script>
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
    <form class="tableform" action="${ctx.path}/manage/datasource/industry/queryIndustryList${ctx.noAuthSuffix}?datasourceTypeId=${datasourceIndustryVo.datasourceTypeId}&datasourceId=${datasourceIndustryVo.datasourceId}" method="post"
          id="pageForm">
        <div class="operation_box" id="operation_box">
            <div class="operation_con">
                <div class="currenttit">
                    <i class="midicon systemset_icon"></i>
                    <span>
                        <em>数据源管理</em>&gt;
                        <em>来源行业类型</em>
                    </span>
                </div>
                <div class="operation_info">
                    <p:auth mcode="MENU_MANAGE_DATASOURCE_INDUSTRY_ADD">
                        <button type="button" class="btn add_btn" onclick="parent.openAddPage();">
                            <i class="minicon addoperation_icon"></i>
                            <span>新增来源行业类型</span>
                        </button>
                    </p:auth>
                    <p:auth mcode="MENU_MANAGE_DATASOURCE_INDUSTRY_EXPORT">
                        <button type="button" class="btn add_btn"
                                onclick="fun_export('${ctx.path}/manage/datasource/industry/exportIndustryList${ctx.bizSuffix}')">
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
                        <input type="text" id="datasourceWebnameSearch" name="datasourceWebname" class="inputtext" placeholder="数据来源名称（网站）"
                               value="${datasourceIndustryVo.datasourceWebname}"/>
                    </li>
                </ul>
            </div>
            <div class="search_btncon">
                <p:auth mcode="MENU_MANAGE_DATASOURCE_INDUSTRY_SEARCH">
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
                                <th width="120">数据来源类型名称</th>
                                <th width="140">数据来源名称（网站）</th>
                                <th width="80">行业类型名称</th>
                                <th width="100">对应招标行业类型</th>
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
                                <td title="${data.datasourceTypeName }">${data.datasourceTypeName }</td>
                                <td title="${data.datasourceWebname }">${data.datasourceWebname }</td>
                                <td title="${data.datasourceIndustryName }">${data.datasourceIndustryName }</td>
                                <td title="${data.industryName }">${data.industryName }</td>
                                <td class="operation_td">
                                    <p:auth mcode="MENU_MANAGE_DATASOURCE_INDUSTRY_VIEW">
                                        <button class="operationbtn" type="button" onclick="parent.viewPage(${data.datasourceIndustryId});">
                                            <span>查看</span>
                                        </button>
                                    </p:auth>
                                    <p:auth mcode="MENU_MANAGE_DATASOURCE_INDUSTRY_UPDATE">
                                        <button class="operationbtn" type="button" onclick="parent.editPage(${data.datasourceIndustryId});">
                                            <span>编辑</span>
                                        </button>
                                    </p:auth>
                                    <p:auth mcode="MENU_MANAGE_DATASOURCE_INDUSTRY_DEL">
                                        <button class="operationbtn" type="button" onclick="parent.delPage(${data.datasourceIndustryId}, '${data.datasourceIndustryName}');">
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

</body>
</html>