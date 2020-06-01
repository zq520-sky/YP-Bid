<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ include file="/resources/platform/inc.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <script src="${ctx.path}/resources/js/common/DataForm.js?v=${ctx.version}"></script>
    <script src="${ctx.path}/resources/script/customer/custFeedback.js?v=${ctx.version}"></script>
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
        .hideTr {
            display: none;
        }
    </style>
</head>
<body>
<div class="main_con">
    <form class="tableform" action="${ctx.path}/manage/customer/feedback/queryFeedBackList${ctx.pageSuffix}" method="post"
          id="pageForm">
        <div class="operation_box" id="operation_box">
            <div class="operation_con">
                <div class="currenttit"></div>
                <div class="operation_info">
                    <p:auth mcode="MENU_MANAGE_CUSTOMER_FEEDBACK_EXPORT">
                        <button type="button" class="btn add_btn"
                                onclick="fun_export('${ctx.path}/manage/customer/feedback/exportFeedBackList${ctx.bizSuffix}')">
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
                        <input type="text" id="mobile" name="mobile" class="inputtext" placeholder="客户编号"
                               value="${describeVo.mobile}"/>
                    </li>
                    <li>
                        <input type="text" id="keyWords" name="keyWords" class="inputtext" placeholder="关键字"
                               value="${describeVo.keyWords}"/>
                    </li>
                </ul>
            </div>
            <div class="search_btncon">
                <p:auth mcode="MENU_MANAGE_CUSTOMER_FEEDBACK_SEARCH">
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
                                <th width="60">反馈内容</th>
                                <th width="120">反馈时间</th>
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
                                <td title="${data.custCode }">${data.custCode }</td>
                                <td title="${data.mobile }">${data.mobile }</td>
                                <c:choose>
                                    <c:when test="${data.headImg == null || data.headImg ==''}">
                                        <td title="无"><span>无</span></td>
                                    </c:when>
                                    <c:when test="${data.headImg !=null || data.headImg !='' }">
                                        <td>
                                            <img src="${ctx.path}${data.headImg }" height="30px" width="50px">
                                        </td>
                                    </c:when>
                                </c:choose>
                                <td title="${data.nickName }">${data.nickName }</td>
                                <td title="${data.feedbackOpinion}">${data.feedbackOpinion }</td>
                                <td title="<fmt:formatDate value='${data.feedbackTime }' pattern='yyyy-MM-dd HH:mm:ss'/>">
                                    <fmt:formatDate value='${data.feedbackTime }' pattern='yyyy-MM-dd HH:mm:ss'/>
                                </td>
                                <td class="operation_td">
                                    <p:auth mcode="MENU_MANAGE_CUSTOMER_FEEDBACK_VIEW">
                                        <button class="operationbtn" type="button" onclick="viewPage(${data.feedbackId});">
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
<div id="viewId" class="add_box mCustomScrollbar_y" >
    <form method="post" id="viewForm">
        <div class="add_list">
            <h5>客户编号：</h5>
            <div class="add_value">
                <span id="custCode"></span>
            </div>
        </div>
        <div class="add_list">
            <h5>手机号码：</h5>
            <div class="add_value">
                <span id="mobile"></span>
            </div>
        </div>
        <div class="add_list">
            <h5>头像：</h5>
            <div class="add_value">
                <c:choose>
                    <c:when test="${data.headImg == null || data.headImg ==''}">
                        <span title="无"><span>无</span></span>
                    </c:when>
                    <c:when test="${data.headImg !=null || data.headImg !='' }">
                        <span>
                            <img src="${ctx.path}${data.headImg }" height="30px" width="50px">
                        </span>
                    </c:when>
                </c:choose>
            </div>
        </div>
        <div class="add_list">
            <h5>昵称：</h5>
            <div class="add_value">
                <span id="nickName"></span>
            </div>
        </div>
        <div class="add_list">
            <h5>反馈内容：</h5>
            <div class="add_value">
                <span id="feedbackOpinion"></span>
            </div>
        </div>
        <div class="add_list">
            <h5>反馈时间：</h5>
            <div class="add_value">
                <span id="feedbackTime"></span>
            </div>
        </div>

    </form>
</div>