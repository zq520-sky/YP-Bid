<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ include file="/resources/platform/inc.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <script src="${ctx.path}/resources/js/common/DataForm.js?v=${ctx.version}"></script>
    <script src="${ctx.path}/resources/script/plan/planDateSourceList.js?v=${ctx.version}"></script>
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
    <form class="tableform"
          action="${ctx.path}/manage/planproject/datasource/queryDatasourceList${ctx.noAuthSuffix}?cityId=${sysCityVo.cityId}"
          method="post"
          id="pageForm">
        <div class="operation_box" id="operation_box">
            <div class="operation_con">
                <div class="currenttit">
                    <i class="midicon systemset_icon"></i>
                    <span>
                        <em>拟建项目</em>&gt;
                        <em>拟建数据来源 </em>
                    </span>
                </div>
                <div class="operation_info">
                    <p:auth mcode="MENU_MANAGE_PLANPROJECT_DATASOURCE_ADD">
                        <button type="button" class="btn add_btn" onclick="parent.openAddPage();">
                            <i class="minicon addoperation_icon"></i>
                            <span>新增</span>
                        </button>
                    </p:auth>
                    <p:auth mcode="MENU_MANAGE_PLANPROJECT_DATASOURCE_EXPORT">
                        <button type="button" class="btn add_btn"
                                onclick="fun_export('${ctx.path}/manage/planproject/datasource/exportDatasourceList${ctx.bizSuffix}')">
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
                        <input type="text" id="datasourceWebname" name="datasourceWebname" class="inputtext"
                               placeholder="数据来源名称(网站)"
                               value="${planDatasourceVo.datasourceWebname}"/>
                    </li>
                    <li>
                        <input type="text" id="datasourceWeburl" name="datasourceWeburl" class="inputtext"
                               placeholder="数据来源网址"
                               value="${planDatasourceVo.datasourceWeburl}"/>
                    </li>
                    <li>
                        <label class="inputlabel">数据来源类型：</label>
                        <select class="select" name="datasourceType" id="datasourceType" type="select">
                            <option value="">全部</option>
                            <option value="1"
                                    <c:if test="${planDatasourceVo.datasourceType == 1}">selected</c:if>>省级在线审批监管平台
                            </option>
                            <option value="2" <c:if test="${planDatasourceVo.datasourceType == 2}">selected</c:if>>
                                省级政务服务网
                            </option>
                            <option value="3" <c:if test="${planDatasourceVo.datasourceType == 3}">selected</c:if>>其他
                            </option>
                        </select>
                    </li>
                    <li>
                        <label class="inputlabel">所属省市：</label>
                        <st:commonSelect name="provinceId" id="provinceId" className="select"
                                         defaultText="请选择" defaultValue="" style="width:174px"
                                         sql="select province_id as val, province_name as text from t_sys_province order by province_id asc"/>
                        &nbsp;&nbsp;<st:commonSelect name="cityId" id="cityId" className="select"
                                                     defaultText="请选择" defaultValue="" style="width:174px"
                                                     sql="select city_id as val, city_name as text from t_sys_city order by city_id asc"/>
                    </li>
                    <li>
                        <label class="inputlabel">禁用状态：</label>
                        <select class="select" name="isForbid" id="isForbid" type="select">
                            <option value="">全部</option>
                            <option value="0"
                                    <c:if test="${planDatasourceVo.isForbid == 0}">selected</c:if>>正常
                            </option>
                            <option value="1" <c:if test="${planDatasourceVo.isForbid == 1}">selected</c:if>>
                                禁用
                            </option>
                        </select>
                    </li>
                </ul>
            </div>
            <div class="search_btncon">
                <p:auth mcode="MENU_MANAGE_PLANPROJECT_DATASOURCE_SEARCH">
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
                                <th width="120">数据来源类型</th>
                                <th width="140">数据来源名称(网站)</th>
                                <th width="140">数据来源网址</th>
                                <th width="120">所属省市</th>
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
                                <td title="${data.datasourceTypeCn }">${data.datasourceTypeCn }</td>
                                <td title="${data.datasourceWebname }">${data.datasourceWebname }</td>
                                <td title="${data.datasourceWeburl }">${data.datasourceWeburl }</td>
                                <td title="${data.provinceName }">${data.provinceName }</td>
                                <td class="operation_td">
                                    <p:auth mcode="MENU_MANAGE_PLANPROJECT_DATASOURCE_VIEW">
                                        <button class="operationbtn" type="button"
                                                onclick="parent.viewPage(${data.datasourceId});">
                                            <span>查看</span>
                                        </button>
                                    </p:auth>
                                    <p:auth mcode="MENU_MANAGE_PLANPROJECT_DATASOURCE_UPDATE">
                                        <button class="operationbtn" type="button"
                                                onclick="parent.editPage(${data.datasourceId});">
                                            <span>编辑</span>
                                        </button>
                                    </p:auth>
                                    <p:auth mcode="MENU_MANAGE_PLANPROJECT_DATASOURCE_BID">
                                        <button class="operationbtn" type="button"
                                                onclick="parent.setPage(${data.datasourceId}, ${data.isForbid}, '${data.datasourceWebname}');">
                                            <span>
                                                <c:if test="${data.isForbid == 0}">启用</c:if>
                                                <c:if test="${data.isForbid == 1}">禁用</c:if>
                                            </span>
                                        </button>
                                    </p:auth>
                                    <p:auth mcode="MENU_MANAGE_PLANPROJECT_DATASOURCE_DEL">
                                        <button class="operationbtn" type="button"
                                                onclick="parent.delPage(${data.datasourceId})">
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