<%@ page language="java" pageEncoding="utf-8" %>
<%@ include file="/resources/platform/inc.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <script src="${ctx.path}/resources/js/common/DataForm.js?v=${ctx.version}"></script>
    <script src="${ctx.path}/resources/script/finance/orderManage.js?v=${ctx.version}"></script>
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
    <form class="tableform" action="${ctx.path}/manage/finance/order/queryOrderList${ctx.pageSuffix}" method="post"
          id="pageForm">
        <div class="operation_box" id="operation_box">
            <div class="operation_con">
                <div class="currenttit"></div>
                <div class="operation_info">
                    <p:auth mcode="MENU_MANAGE_FINANCE_ORDER_EXPORT">
                        <button type="button" class="btn add_btn"
                                onclick="fun_export('${ctx.path}/manage/finance/order/exportOrderList${ctx.bizSuffix}')">
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
                               value="${orderVo.custCode}"/>
                    </li>
                    <li>
                        <input type="text" id="mobileSearch" name="mobile" class="inputtext" placeholder="手机号码"
                               value="${orderVo.mobile}"/>
                    </li>
                    <li>
                        <label class="inputlabel">支付方式：</label>
                        <select class="select" name="payMode" id="payModeSearch" type="select">
                            <option value="">全部</option>
                            <option value="0"
                                    <c:if test="${orderVo.payMode == 0}">selected</c:if> >微信
                            </option>
                            <option value="1"
                                    <c:if test="${orderVo.payMode == 1}">selected</c:if> >支付宝
                            </option>
                            <option value="2"
                                    <c:if test="${orderVo.payMode == 2}">selected</c:if> >银联
                            </option>
                            <option value="10"
                                    <c:if test="${orderVo.payMode == 10}">selected</c:if> >系统充值
                            </option>
                        </select>
                    </li>
                    <li>
                        <label class="inputlabel">注册日期：</label>
                        <input type="text" id="orderDateBeginSearch" name="orderDateBegin" class="inputtext"
                               onclick="WdatePicker({startDate:'%y-%M-%d 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'orderDateEndSearch\')}'})"
                               style="min-width: 120px;"
                               value="<fmt:formatDate value='${orderVo.orderDateBegin}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
                        <em class="inputto">至</em>
                        <input type="text" id="orderDateEndSearch" name="orderDateEnd" class="inputtext"
                               onclick="WdatePicker({startDate:'%y-%M-%d 23:59:59',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'orderDateBeginSearch\')}'})"
                               style="min-width: 120px;"
                               value="<fmt:formatDate value='${orderVo.orderDateEnd}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
                    </li>
                </ul>
            </div>
            <div class="search_btncon">
                <p:auth mcode="MENU_MANAGE_FINANCE_ORDER_SEARCH">
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
                                <th width="120">订单编号</th>
                                <th width="80">客户编号</th>
                                <th width="100">手机号码</th>
                                <th width="100">昵称</th>
                                <th width="60">会员类型</th>
                                <th width="80">订单金额</th>
                                <th width="80">支付方式</th>
                                <th width="150">购买时间</th>
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
                                <td title="${data.orderCode }">${data.orderCode }</td>
                                <td title="${data.custCode }">${data.custCode }</td>
                                <td title="${data.mobile }">${data.mobile }</td>
                                <td title="${data.nickName }">${data.nickName }</td>
                                <td title="${data.memberTypeCN }">${data.memberTypeCN }</td>
                                <td title="${data.orderPrice }">${data.orderPrice }</td>
                                <td title="${data.payModeCN}">${data.payModeCN}</td>
                                <td title="<fmt:formatDate value='${data.orderDate }' pattern='yyyy-MM-dd HH:mm:ss'/>">
                                    <fmt:formatDate value='${data.orderDate }' pattern='yyyy-MM-dd HH:mm:ss'/>
                                </td>
                                <td class="operation_td">
                                    <p:auth mcode="MENU_MANAGE_FINANCE_ORDER_VIEW">
                                        <button class="operationbtn" type="button" onclick="viewPage(${data.custId});">
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
<div id="viewOrder" class="add_box mCustomScrollbar_y">
    <form method="post" id="viewForm">
        <div class="add_list">
            <h5>客户编号：</h5>
            <div class="add_value">
                <span id="custCodeView"></span>
            </div>
        </div>
        <div class="add_list">
            <h5>订单编号：</h5>
            <div class="add_value">
                <span id="orderCodeView"></span>
            </div>
        </div>
        <div class="add_list">
            <h5>手机号码：</h5>
            <div class="add_value">
                <span id="mobileView"></span>
            </div>
        </div>
        <div class="add_list">
            <h5>昵称：</h5>
            <div class="add_value">
                <span id="nickNameView"></span>
            </div>
        </div>
        <div class="add_list">
            <h5>会员类型：</h5>
            <div class="add_value">
                <span id="memberTypeCNView"></span>
            </div>
        </div>
        <div class="add_list">
            <h5>订单金额：</h5>
            <div class="add_value">
                <span id="orderPriceView"></span>
            </div>
        </div>
        <div class="add_list">
            <h5>支付方式：</h5>
            <div class="add_value">
                <span id="payModeCNView"></span>
            </div>
        </div>
        <div class="add_list">
            <h5>购买时间：</h5>
            <div class="add_value">
                <span id="orderDateView"></span>
            </div>
        </div>
    </form>
</div>

</body>
</html>