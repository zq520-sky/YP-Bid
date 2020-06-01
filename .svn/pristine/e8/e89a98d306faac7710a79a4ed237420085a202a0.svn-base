<%@ page language="java" pageEncoding="utf-8" %>
<%@ include file="/resources/platform/inc.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <script src="${ctx.path}/resources/js/common/DataForm.js?v=${ctx.version}"></script>
    <script src="${ctx.path}/resources/script/finance/memberPriceManage.js?v=${ctx.version}"></script>
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
    <form class="tableform" action="${ctx.path}/manage/finance/price/combo/queryPriceList${ctx.pageSuffix}" method="post"
          id="pageForm">
        <div class="operation_box" id="operation_box">
            <div class="operation_con">
                <div class="currenttit"></div>
                <div class="operation_info">
                    <p:auth mcode="MENU_MANAGE_FINANCE_PRICE_ADD">
                        <button type="button" class="btn add_btn" onclick="openAddPage();">
                            <i class="minicon addoperation_icon"></i>
                            <span>新增</span>
                        </button>
                    </p:auth>
                    <span class="line">|</span>
                    <p:auth mcode="MENU_MANAGE_FINANCE_PRICE_EXPORT">
                        <button type="button" class="btn add_btn"
                                onclick="fun_export('${ctx.path}/manage/finance/price/combo/exportPriceList${ctx.bizSuffix}')">
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
                        <label class="inputlabel">会员类型：</label>
                        <select class="select" name="memberType" id="memberTypeSearch" type="select">
                            <option value="">全部</option>
                            <option value="1"
                                    <c:if test="${memberPriceVo.memberType == 1}">selected</c:if> >省级VIP
                            </option>
                            <option value="2"
                                    <c:if test="${memberPriceVo.memberType == 2}">selected</c:if> >高级VIP
                            </option>
                            <option value="3"
                                    <c:if test="${memberPriceVo.memberType == 3}">selected</c:if> >项目VIP
                            </option>
                        </select>
                    </li>
                </ul>
            </div>
            <div class="search_btncon">
                <p:auth mcode="MENU_MANAGE_FINANCE_PRICE_SEARCH">
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
                                <th width="60">会员类型</th>
<%--                                <th width="80">权限范围</th>--%>
                                <th width="80">原价（元）</th>
                                <th width="80">现价（元）</th>
                                <th width="90">时间范围（月）</th>
                                <th width="90">赠送月数（月）</th>
                                <th width="200">备注</th>
                                <th width="60">是否禁用</th>
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
                                <td title="${data.memberTypeCN }">${data.memberTypeCN }</td>
<%--                                <td title="${data.memberType == 1 ? '全省' : '全国' }">${data.memberType == 1 ? '全省' : '全国'  }</td>--%>
                                <td title="${data.oldPrice }">${data.oldPrice }</td>
                                <td title="${data.newPrice }">${data.newPrice }</td>
                                <td title="${data.months }">${data.months }</td>
                                <td title="${data.giveMonths }">${data.giveMonths }</td>
                                <td title="${data.remark}">${data.remark}</td>
                                <td title="${data.isForbid==0?'正常':'已禁用'}"><span
                                        class="recharge_statue ${data.isForbid==0?'recharge_success':'recharge_failed'}">${data.isForbid==0?'正常':'已禁用'}</span>
                                </td>
                                <td class="operation_td">
                                    <p:auth mcode="MENU_MANAGE_FINANCE_PRICE_VIEW">
                                        <button class="operationbtn" type="button" onclick="viewPage(${data.priceId});">
                                            <span>查看</span>
                                        </button>
                                    </p:auth>
                                    <p:auth mcode="MENU_MANAGE_FINANCE_PRICE_UPDATE">
                                        <button class="operationbtn" type="button" onclick="editPage(${data.priceId});">
                                            <span>编辑</span>
                                        </button>
                                    </p:auth>
                                    <p:auth mcode="MENU_MANAGE_FINANCE_PRICE_ENABLE">
                                        <button class="operationbtn" type="button"
                                                onclick="setPage(${data.priceId}, ${data.isForbid});">
                                            <span>
                                                <c:if test="${data.isForbid == 0}">禁用</c:if>
                                                <c:if test="${data.isForbid == 1}">启用</c:if>
                                            </span>
                                        </button>
                                    </p:auth>
                                    <p:auth mcode="MENU_MANAGE_FINANCE_PRICE_DEL">
                                        <button class="operationbtn" type="button" onclick="delPage(${data.priceId});">
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
<div id="viewMemberPrice" class="add_box mCustomScrollbar_y">
    <form method="post" id="viewForm">
        <div class="add_list">
            <h5>会员类型：</h5>
            <div class="add_value">
                <span id="memberTypeCNView"></span>
            </div>
        </div>
        <div class="add_list">
            <h5>原价（元）：</h5>
            <div class="add_value">
                <span id="oldPriceView"></span>
            </div>
        </div>
        <div class="add_list">
            <h5>现价（元）：</h5>
            <div class="add_value">
                <span id="newPriceView"></span>
            </div>
        </div>
        <div class="add_list">
            <h5>时间范围（月）：</h5>
            <div class="add_value">
                <span id="monthsView"></span>
            </div>
        </div>
        <div class="add_list">
            <h5>赠送月数（月）：</h5>
            <div class="add_value">
                <span id="giveMonthsView"></span>
            </div>
        </div>
        <div class="add_list">
            <h5>是否禁用：</h5>
            <div class="add_value">
                <span id="isForbidCNView"></span>
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

<div id="AddMemberPrice" class="add_box mCustomScrollbar_y">
    <form method="post" id="addForm" action="${ctx.path}/manage/finance/price/combo/addPrice${ctx.bizSuffix}">
        <div class="add_list">
            <h5><em style="color: red;">*</em>会员类型：</h5>
            <div class="add_value">
                <select class="select" name="memberType" id="memberTypeAdd" type="select">
                    <option value="">全部</option>
                    <option value="1">省级VIP</option>
                    <option value="2">高级VIP</option>
                    <option value="3">项目VIP</option>
                </select>
            </div>
        </div>
        <div class="add_list">
            <h5><em style="color: red;">*</em>原价（元）：</h5>
            <div class="add_value">
                <input type="text" class="inputtext" name="oldPrice" id="oldPriceAdd"/>
            </div>
        </div>
        <div class="add_list">
            <h5><em style="color: red;">*</em>现价（元）：</h5>
            <div class="add_value">
                <input type="text" class="inputtext" name="newPrice" id="newPriceAdd"/>
            </div>
        </div>
        <div class="add_list">
            <h5><em style="color: red;">*</em>时间范围（月）：</h5>
            <div class="add_value">
                <input type="text" class="inputtext" name="months" id="monthsAdd"/>
            </div>
        </div>
        <div class="add_list">
            <h5><em style="color: red;">*</em>赠送月数（月）：</h5>
            <div class="add_value">
                <input type="text" class="inputtext" name="giveMonths" id="giveMonthsAdd"/>
            </div>
        </div>
        <div class="add_list">
            <h5>备注：</h5>
            <div class="add_value">
                <textarea class="textarea" name="remark" id="remarkAdd" maxlength="50"></textarea>
            </div>
        </div>
    </form>
</div>

<!-- 编辑 -->
<div id="editMemberPrice" class="add_box mCustomScrollbar_y">
    <form method="post" id="editForm" action="${ctx.path}/manage/finance/price/combo/updatePrice${ctx.bizSuffix}">
        <div class="add_list">
            <h5><em style="color: red;">*</em>会员类型：</h5>
            <div class="add_value">
                <select class="select" name="memberType" id="memberTypeEdit" type="select">
                    <option value="">全部</option>
                    <option value="1">省级VIP</option>
                    <option value="2">高级VIP</option>
                    <option value="3">项目VIP</option>
                </select>
                <input type="hidden" name="priceId" id="priceIdEdit">
            </div>
        </div>
        <div class="add_list">
            <h5><em style="color: red;">*</em>原价（元）：</h5>
            <div class="add_value">
                <input type="text" class="inputtext" name="oldPrice" id="oldPriceEdit"/>
            </div>
        </div>
        <div class="add_list">
            <h5><em style="color: red;">*</em>现价（元）：</h5>
            <div class="add_value">
                <input type="text" class="inputtext" name="newPrice" id="newPriceEdit"/>
            </div>
        </div>
        <div class="add_list">
            <h5><em style="color: red;">*</em>时间范围（月）：</h5>
            <div class="add_value">
                <input type="text" class="inputtext" name="months" id="monthsEdit"/>
            </div>
        </div>
        <div class="add_list">
            <h5><em style="color: red;">*</em>赠送月数（月）：</h5>
            <div class="add_value">
                <input type="text" class="inputtext" name="giveMonths" id="giveMonthsEdit"/>
            </div>
        </div>
        <div class="add_list">
            <h5>备注：</h5>
            <div class="add_value">
                <textarea class="textarea" name="remark" id="remarkEdit" maxlength="50"></textarea>
            </div>
        </div>
    </form>
</div>

</body>
</html>