<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ include file="/resources/platform/inc.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <script src="${ctx.path}/resources/js/common/DataForm.js?v=${ctx.version}"></script>
    <script src="${ctx.path}/resources/script/customer/projectKeywordManage.js?v=${ctx.version}8"></script>
    <script src="${ctx.path}/resources/components/My97DatePicker/WdatePicker.js?v=${ctx.version}"></script>
    <script type="text/javascript">
        $(function () {
            loadCriteria();
        });

        //加载查询条件
        function loadCriteria() {
        }
    </script>
    <style type="text/css">
        .hideTr{
            display: none;
        }
    </style>
</head>
<body>
<div class="main_con">
    <form class="tableform" action="${ctx.path}/manage/customer/keyword/queryKeywordList${ctx.pageSuffix}" method="post"
          id="pageForm">
        <div class="operation_box" id="operation_box">
            <div class="operation_con">
                <div class="currenttit"></div>
                <div class="operation_info">
                    <p:auth mcode="MENU_MANAGE_CUSTOMER_KEYWORD_EXPORT">
                        <button type="button" class="btn add_btn"
                                onclick="fun_export('${ctx.path}/manage/customer/keyword/exportKeywordList${ctx.bizSuffix}')">
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
                        <input type="text" id="custCodeSearch" name="custCode" class="inputtext" placeholder="客户编号"
                               value="${projectKeywordCollectVo.custCode}"/>
                    </li>
                    <li>
                        <input type="text" id="mobileSearch" name="mobile" class="inputtext" placeholder="手机号码"
                               value="${projectKeywordCollectVo.mobile}"/>
                    </li>
                    <li>
                        <label class="inputlabel">会员类型：</label>
                        <select class="select" name="memberType" id="memberTypeSearch" type="select">
                            <option value="">全部</option>
                            <option value="1"
                                    <c:if test="${projectKeywordCollectVo.memberType == 1}">selected</c:if> >省级VIP
                            </option>
                            <option value="2"
                                    <c:if test="${projectKeywordCollectVo.memberType == 2}">selected</c:if> >高级VIP
                            </option>
                            <option value="3"
                                    <c:if test="${projectKeywordCollectVo.memberType == 3}">selected</c:if> >项目VIP
                            </option>
                        </select>
                    </li>
                </ul>
            </div>
            <div class="search_btncon">
                <p:auth mcode="MENU_MANAGE_CUSTOMER_KEYWORD_SEARCH">
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
                                <th width="80">客户编号</th>
                                <th width="100">手机号码</th>
                                <th width="100">头像</th>
                                <th width="100">昵称</th>
                                <th width="160">项目关键词</th>
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
                                <td title="${data.custCode }">${data.custCode }</td>
                                <td title="${data.mobile }">${data.mobile }</td>
                                <c:choose>
                                    <c:when test="${data.headImg == null || data.headImg ==''}">
                                        <td title="无"><span>无</span></td>
                                    </c:when>
                                    <c:when test="${data.headImg !=null || data.headImg !='' }">
                                        <td>
                                            <img src="${ctx.path}${data.headImg }" height="30px" width="50px"
                                                 onclick="previewImg('${ctx.path}${data.headImg }')">
                                        </td>
                                    </c:when>
                                </c:choose>
                                <td title="${data.nickName }">${data.nickName }</td>
                                <td title="${data.projectKeywords }">${data.projectKeywords }</td>
                                <td class="operation_td">
                                    <p:auth mcode="MENU_MANAGE_CUSTOMER_KEYWORD_VIEW">
                                        <button class="operationbtn" type="button"
                                                onclick="viewPage(${data.keywordCollectId});">
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
<div id="viewKeyword" class="detail_box mCustomScrollbar_y"  data-mcs-theme="dark" style="display:none;">
    <form method="post" id="viewForm" style="height: 100%;">
        <table width="100%">

            <thead>
            <tr colspan="2"><b>基本信息</b></tr>
            </thead>

            <tbody>
            <tr>
                <th>客户编号：</th>
                <td id="custCodeView"></td>
                <th>手机号码：</th>
                <td id="mobileView"></td>
            </tr>
            <tr>
                <th>昵称：</th>
                <td id="nickNameView"></td>
                <th>性别：</th>
                <td id="sexCNView"></td>
            </tr>
            </tbody>

        </table>

        <table width="100%">
            <thead>
            <tr colspan="2"><b>关键词信息</b></tr>
            </thead>

            <tbody>
            <tr>
                <th>项目关键词：</th>
                <td id="projectKeywordsView"></td>
                <th></th>
                <td></td>
            </tr>
            </tbody>

        </table>
    </form>
</div>

</body>
</html>