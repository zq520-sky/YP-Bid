<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ include file="/resources/platform/inc.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <script src="${ctx.path}/resources/js/common/DataForm.js?v=${ctx.version}"></script>
    <script src="${ctx.path}/resources/script/project/projectManage.js?v=${ctx.version}1"></script>
    <script src="${ctx.path}/resources/components/My97DatePicker/WdatePicker.js?v=${ctx.version}"></script>
    <script type="text/javascript" src="${ctx.path}/resources/components/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" src="${ctx.path}/resources/components/ueditor/ueditor.all.js"></script>
    <script type="text/javascript">
        $(function () {
            loadCriteria();
        });

        //加载查询条件
        function loadCriteria() {
        }
    </script>
    <style type="text/css">
        * {
            /*touch-action: pan-y;*/
            touch-action: none;
        }
    </style>
</head>
<body>
<div class="main_con">
    <form class="tableform" action="${ctx.path}/manage/project/info/queryProjectInfoList${ctx.pageSuffix}" method="post"
          id="pageForm">
        <div class="operation_box" id="operation_box">
            <div class="operation_con">
                <div class="currenttit"></div>
                <div class="operation_info">
                    <p:auth mcode="MENU_MANAGE_PROJECT_INFO_EXPORT">
                        <button type="button" class="btn add_btn"
                                onclick="fun_export('${ctx.path}/manage/project/info/exportProjectInfoList${ctx.bizSuffix}')">
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
                        <label class="radio" id="addRadioLable1" style="margin-top:6px"
                        ><input type="radio" name="searchType" value="1" <c:if test="${projectVo.searchType==1 }">checked</c:if>><em>标题搜索</em></label>
                    </li>
                    <li>
                        <label class="radio" id="addRadioLable2" style="margin-top:6px">
                            <input type="radio" name="searchType" value="2" <c:if test="${projectVo.searchType==2 }">checked</c:if>><em>全文搜索</em></label>
                    </li>
                    <li>
                        <input type="text" id="nickNameSearch" name="titleOrContext" class="inputtext"
                               placeholder="项目标题"
                               value="${projectVo.titleOrContext}"/>
                    </li>
                    <li>
                        <label class="inputlabel">新增时间：</label>
                        <input type="text" id="addDateBeginSearch" name="addDateBegin" class="inputtext"
                               onclick="WdatePicker({startDate:'%y-%M-%d 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'addDateEndSearch\')}'})"
                               style="min-width: 120px;"
                               value="<fmt:formatDate value='${projectVo.addDateBegin}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
                        <em class="inputto">至</em>
                        <input type="text" id="addDateEndSearch" name="addDateEnd" class="inputtext"
                               onclick="WdatePicker({startDate:'%y-%M-%d 23:59:59',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'addDateBeginSearch\')}'})"
                               style="min-width: 120px;"
                               value="<fmt:formatDate value='${projectVo.addDateEnd}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
                    </li>
                    <li>
                        <label class="inputlabel">对应招标信息类型：</label>
                        <st:commonSelect className="select" name="infotypeId" selectValue="${projectVo.infotypeId}"
                                         defaultText="全部" defaultValue=""
                                         sql="select infotype_id as val, infotype_name as text from t_infotype order by order_num"/>
                    </li>
                    <li>
                        <label class="inputlabel">对应招标行业类型：</label>
                        <st:commonSelect className="select" name="industryId" selectValue="${projectVo.industryId}"
                                         defaultText="全部" defaultValue=""
                                         sql="select industry_id as val, industry_name as text from t_industry order by order_num"/>
                    </li>
                </ul>
            </div>
            <div class="search_btncon">
                <p:auth mcode="MENU_MANAGE_PROJECT_INFO_SEARCH">
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
                                <th width="120">数据来源名称（网站）</th>
                                <th width="100">对应招标信息类型</th>
                                <th width="100">对应招标行业类型</th>
                                <th width="170">项目标题</th>
                                <th width="110">注册时间</th>
                                <th width="180" class="operation_th">操作</th>
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
                                <td title="${data.datasourceWebname }">${data.datasourceWebname }</td>
                                <td title="${data.infotypeName }">${data.infotypeName }</td>
                                <td title="${data.industryName }">${data.industryName }</td>
                                <td title="${data.projectTitle }">${data.projectTitle }</td>
                                <td title="<fmt:formatDate value='${data.addDate }' pattern='yyyy-MM-dd HH:mm:ss'/>">
                                    <fmt:formatDate value='${data.addDate }' pattern='yyyy-MM-dd HH:mm:ss'/>
                                </td>
                                <td class="operation_td">
                                    <p:auth mcode="MENU_MANAGE_PROJECT_INFO_VIEW">
                                        <button class="operationbtn" type="button"
                                                onclick="viewPage(${data.projectId});">
                                            <span>查看</span>
                                        </button>
                                    </p:auth>
                                    <p:auth mcode="MENU_MANAGE_PROJECT_INFO_UPDATE">
                                        <button class="operationbtn" type="button"
                                                onclick="editPage(${data.projectId});">
                                            <span>编辑</span>
                                        </button>
                                    </p:auth>
                                    <p:auth mcode="MENU_MANAGE_PROJECT_INFO_UPDATEDETAIL">
                                        <button class="operationbtn" type="button"
                                                onclick="editDetailPage(${data.projectId}, '${data.projectCode}');">
                                            <span>编辑详情</span>
                                        </button>
                                    </p:auth>
                                    <p:auth mcode="MENU_MANAGE_PROJECT_INFO_DEL">
                                        <button class="operationbtn" type="button"
                                                onclick="delPage(${data.projectId}, '${data.projectCode}');">
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
<div id="viewProject" class="detail_box mCustomScrollbar_y">
    <form method="post" id="viewForm">
        <table width="100%">
            <thead>
            <tr>
                <th><b>来源信息</b></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th>数据来源类型名称：</th>
                <td colspan="3" id="datasourceTypeNameView"></td>
            </tr>
            <tr>
                <th>数据来源名称（网站）：</th>
                <td colspan="3" id="datasourceWebnameView"></td>
            </tr>
            <tr>
                <th>数据来源网址：</th>
                <td colspan="3" id="datasourceWeburlView"></td>
            </tr>
            <tr>
                <th>所属省市：</th>
                <td colspan="3" id="addressView"></td>
            </tr>
            <tr>
                <th>来源行业类型名称：</th>
                <td id="datasourceIndustryNameView"></td>
                <th>对应招标行业类型：</th>
                <td id="industryNameView"></td>
            </tr>
            <tr>
                <th>来源信息类型名称：</th>
                <td id="datasourceInfotypeNameView"></td>
                <th>对应招标信息类型：</th>
                <td id="infotypeNameView"></td>
            </tr>
            </tbody>
        </table>
        <table width="100%">
            <thead>
            <tr>
                <th><b>项目信息</b></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th>项目名称：</th>
                <td colspan="3" id="projectTitleView"></td>
            </tr>
            <tr>
                <th>项目编号：</th>
                <td colspan="3" id="projectCodeView"></td>
            </tr>
            <tr>
                <th>招标单位：</th>
                <td colspan="3" id="projectCompanyNameView"></td>
            </tr>
            <tr>
                <th>新增日期：</th>
                <td colspan="3" id="addDateView"></td>
            </tr>
            <tr>
                <th></th>
                <td></td>
                <th></th>
                <td></td>
            </tr>
            </tbody>
        </table>
    </form>
</div>

<!-- 编辑信息 -->
<div id="editProject" class="detail_box mCustomScrollbar_y">
    <form method="post" id="editForm" action="${ctx.path}/manage/project/info/updateProjectInfo${ctx.bizSuffix}">
        <table width="100%">
            <thead>
            <tr>
                <th><b>来源信息</b></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th><em style="color: red;">*</em>数据来源类型名称：</th>
                <td colspan="3">
                    <st:commonSelect name="datasourceTypeId" id="datasourceTypeIdEdit" className="select"
                                     defaultText="请选择" defaultValue=""
                                     sql="select datasource_type_id as val, datasource_type_name as text from t_datasource_type order by datasource_type_id asc"/>
                    <input type="hidden" name="datasourceTypeName" id="datasourceTypeNameEdit"/>
                </td>
            </tr>
            <tr>
                <th><em style="color: red;">*</em>数据来源名称（网站）：</th>
                <td colspan="3">
                    <input type="text" name="datasourceWebname" id="datasourceWebnameEdit" style="width: 70%;" class="inputtext" maxlength="50"/>
                </td>
            </tr>
            <tr>
                <th>数据来源网址：</th>
                <td colspan="3" id="datasourceWeburlEdit"></td>
            </tr>
            <tr>
                <th>所属省市：</th>
                <td colspan="3" id="addressEdit"></td>
            </tr>
            <tr>
                <th><em style="color: red;">*</em>来源行业类型名称：</th>
                <td>
                    <st:commonSelect name="datasourceIndustryId" id="datasourceIndustryIdEdit" className="select"
                                     defaultText="请选择" defaultValue=""
                                     sql="select datasource_industry_id as val, datasource_industry_name as text from t_datasource_industry ORDER BY datasource_industry_id ASC"/>
                    <input type="hidden" name="datasourceIndustryName" id="datasourceIndustryNameEdit"/>
                </td>
                <th><em style="color: red;">*</em>对应招标行业类型：</th>
                <td>
                    <st:commonSelect name="industryId" id="industryIdEdit" className="select"
                                     defaultText="请选择" defaultValue=""
                                     sql="select industry_id as val, industry_name as text from t_industry ORDER BY order_num ASC"/>
                    <input type="hidden" name="industryName" id="industryNameEdit"/>
                </td>
            </tr>
            <tr>
                <th><em style="color: red;">*</em>来源信息类型名称：</th>
                <td>
                    <st:commonSelect name="datasourceInfotypeId" id="datasourceInfotypeIdEdit" className="select"
                                     defaultText="请选择" defaultValue=""
                                     sql="select datasource_infotype_id as val, datasource_infotype_name as text from t_datasource_infotype order by datasource_infotype_id asc"/>
                    <input type="hidden" name="datasourceInfotypeName" id="datasourceInfotypeNameEdit"/>
                </td>
                <th><em style="color: red;">*</em>对应招标信息类型：</th>
                <td>
                    <st:commonSelect name="infotypeId" id="infotypeIdEdit" className="select"
                                     defaultText="请选择" defaultValue=""
                                     sql="select infotype_id as val, infotype_name as text from t_infotype order by order_num asc"/>
                    <input type="hidden" name="infotypeName" id="infotypeNameEdit"/>
                </td>
            </tr>
            </tbody>
        </table>
        <table width="100%">
            <thead>
            <tr>
                <th><b>项目信息</b></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th><em style="color: red;">*</em>项目名称：</th>
                <td colspan="3">
                    <input type="text" name="projectTitle" id="projectTitleEdit" style="width: 70%;" class="inputtext" maxlength="300"/>
                    <input type="hidden" name="projectId" id="projectIdEdit"/>
                </td>
            </tr>
            <tr>
                <th><em style="color: red;">*</em>项目编号：</th>
                <td colspan="3">
                    <input type="text" name="projectCode" id="projectCodeEdit" style="width: 70%;" class="inputtext" maxlength="50"/>
                </td>
            </tr>
            <tr>
                <th><em style="color: red;">*</em>招标单位：</th>
                <td colspan="3">
                    <input type="text" name="projectCompanyName" id="projectCompanyNameEdit" style="width: 70%;" class="inputtext" maxlength="300"/>
                </td>
            </tr>
            <tr>
                <th>新增日期：</th>
                <td colspan="3" id="addDateEdit"></td>
            </tr>
            <tr>
                <th></th>
                <td></td>
                <th></th>
                <td></td>
            </tr>
            </tbody>
        </table>
    </form>
</div>

<!-- 编辑详情 -->
<div id="editDetailProject" class="add_box mCustomScrollbar_y">
    <form action="${ctx.path}/manage/project/info/updateDetail${ctx.bizSuffix}" method="post" id="editDetailForm">
        <div class="add_list">
            <h5>项目名称：</h5>
            <div class="add_value">
                <span id="projectNameEditDetail"></span>
                <input type="hidden" name="projectId" id="projectIdEditDetail"/>
                <input type="hidden" name="projectCode" id="projectCodeEditDetail"/>
            </div>
        </div>
        <script id="projectDetailEdit" name="projectDetail" type="text/plain"></script>
    </form>
</div>
</body>
</html>