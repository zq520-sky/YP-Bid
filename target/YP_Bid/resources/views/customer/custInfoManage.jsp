<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ include file="/resources/platform/inc.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <script src="${ctx.path}/resources/js/common/DataForm.js?v=${ctx.version}"></script>
    <script src="${ctx.path}/resources/script/customer/custInfoManage.js?v=${ctx.version}"></script>
    <script src="${ctx.path}/resources/components/My97DatePicker/WdatePicker.js?v=${ctx.version}"></script>
    <script src="${ctx.path}/resources/script/upload/cupload.js"></script>
    <script src="${ctx.path}/resources/components/multiSelect/verSelector/verSelect.2.0.js"></script>
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
    <form class="tableform" action="${ctx.path}/manage/customer/info/queryCustList${ctx.pageSuffix}" method="post"
          id="pageForm">
        <div class="operation_box" id="operation_box">
            <div class="operation_con">
                <div class="currenttit"></div>
                <div class="operation_info">
                    <p:auth mcode="MENU_MANAGE_CUSTOMER_INFO_EXPORT">
                        <button type="button" class="btn add_btn"
                                onclick="fun_export('${ctx.path}/manage/customer/info/exportCustList${ctx.bizSuffix}')">
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
                               value="${customerVo.custCode}"/>
                    </li>
                    <li>
                        <input type="text" id="mobileSearch" name="mobile" class="inputtext" placeholder="手机号码"
                               value="${customerVo.mobile}"/>
                    </li>
                    <li>
                        <input type="text" id="nickNameSearch" name="nickName" class="inputtext" placeholder="昵称"
                               value="${customerVo.nickName}"/>
                    </li>
                    <li>
                        <label class="inputlabel">是否会员：</label>
                        <select class="select" name="isMember" id="isMemberSearch" type="select">
                            <option value="">全部</option>
                            <option value="1"
                                    <c:if test="${customerVo.isMember == 1}">selected</c:if> >是
                            </option>
                            <option value="0"
                                    <c:if test="${customerVo.isMember == 0}">selected</c:if> >否
                            </option>
                        </select>
                    </li>
                    <li>
                        <label class="inputlabel">禁用状态：</label>
                        <select class="select" name="isForbid" id="isForbidSearch" type="select">
                            <option value="">全部</option>
                            <option value="0"
                                    <c:if test="${customerVo.isForbid == 0}">selected</c:if> >正常
                            </option>
                            <option value="1"
                                    <c:if test="${customerVo.isForbid == 1}">selected</c:if> >已禁用
                            </option>
                        </select>
                    </li>
                    <li>
                        <label class="inputlabel">注册日期：</label>
                        <input type="text" id="registerDateBeginSearch" name="registerDateBegin" class="inputtext"
                               onclick="WdatePicker({startDate:'%y-%M-%d 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'registerDateEndSearch\')}'})"
                               style="min-width: 120px;"
                               value="<fmt:formatDate value='${customerVo.registerDateBegin}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
                        <em class="inputto">至</em>
                        <input type="text" id="registerDateEndSearch" name="registerDateEnd" class="inputtext"
                               onclick="WdatePicker({startDate:'%y-%M-%d 23:59:59',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'registerDateBeginSearch\')}'})"
                               style="min-width: 120px;"
                               value="<fmt:formatDate value='${customerVo.registerDateEnd}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
                    </li>
                </ul>
            </div>
            <div class="search_btncon">
                <p:auth mcode="MENU_MANAGE_CUSTOMER_INFO_SEARCH">
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
                                <th width="60">性别</th>
                                <th width="120">所在省市</th>
                                <th width="80">是否会员</th>
                                <th width="80">是否禁用</th>
                                <th width="150">注册时间</th>
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
                                <td title="${data.sexCN }">${data.sexCN }</td>
                                <td title="${data.provinceName } ${data.cityName }">${data.provinceName } ${data.cityName }</td>
                                <td title="${data.isMember==1?'是':'否'}">${data.isMember==1?'是':'否'}</td>
                                <td title="${data.isForbid==0?'正常':'已禁用'}"><span
                                        class="recharge_statue ${data.isForbid==0?'recharge_success':'recharge_failed'}">${data.isForbid==0?'正常':'已禁用'}</span>
                                </td>
                                <td title="<fmt:formatDate value='${data.registerDate }' pattern='yyyy-MM-dd HH:mm:ss'/>">
                                    <fmt:formatDate value='${data.registerDate }' pattern='yyyy-MM-dd HH:mm:ss'/>
                                </td>
                                <td class="operation_td">
                                    <p:auth mcode="MENU_MANAGE_CUSTOMER_INFO_VIEW">
                                        <button class="operationbtn" type="button" onclick="viewPage(${data.custId});">
                                            <span>查看</span>
                                        </button>
                                    </p:auth>
                                    <p:auth mcode="MENU_MANAGE_CUSTOMER_INFO_SET">
                                        <button class="operationbtn" type="button"
                                                onclick="setMemberPage(${data.custId});">
                                            <span>设置会员</span>
                                        </button>
                                    </p:auth>
                                    <p:auth mcode="MENU_MANAGE_CUSTOMER_INFO_ENABLE">
                                        <button class="operationbtn" type="button"
                                                onclick="setPage(${data.custId}, ${data.isForbid}, '${data.custCode}');">
                                            <span>
                                                <c:if test="${data.isForbid == 0}">禁用</c:if>
                                                <c:if test="${data.isForbid == 1}">启用</c:if>
                                            </span>
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
<div id="viewCustomer" class="add_box mCustomScrollbar_y">
    <form method="post" id="viewForm">
        <div class="add_item">
            <div class="add_list">
                <h5>客户编号：</h5>
                <div class="add_value">
                    <span id="custCodeView"></span>
                </div>
            </div>
            <div class="add_list">
                <h5>手机号码：</h5>
                <div class="add_value">
                    <span id="mobileView"></span>
                </div>
            </div>
        </div>
        <div class="add_item">
            <div class="add_list">
                <h5>头像：</h5>
                <div class="add_value">
                    <div id="headImgView"></div>
                </div>
            </div>
            <div class="add_list">
                <h5>昵称：</h5>
                <div class="add_value">
                    <span id="nickNameView"></span>
                </div>
            </div>
        </div>
        <div class="add_item">
            <div class="add_list">
                <h5>性别：</h5>
                <div class="add_value">
                    <span id="sexCNView"></span>
                </div>
            </div>
            <div class="add_list">
                <h5>所在省市：</h5>
                <div class="add_value">
                    <span id="addressView"></span>
                </div>
            </div>
        </div>
        <div class="add_item">
            <div class="add_list">
                <h5>公司名称：</h5>
                <div class="add_value">
                    <span id="companyNameView"></span>
                </div>
            </div>
            <div class="add_list">
                <h5>职位名称：</h5>
                <div class="add_value">
                    <span id="jobView"></span>
                </div>
            </div>
        </div>
        <div class="add_item">
            <div class="add_list">
                <h5>是否会员：</h5>
                <div class="add_value">
                    <span id="isMemberView"></span>
                </div>
            </div>
            <div class="add_list">
                <h5>是否禁用：</h5>
                <div class="add_value">
                    <span id="isForbidView"></span>
                </div>
            </div>
        </div>
        <div class="add_item">
            <div class="add_list">
                <h5>注册时间：</h5>
                <div class="add_value">
                    <span id="registerDateView"></span>
                </div>
            </div>
        </div>
    </form>
</div>
<%--<div id="viewCustomer" class="detail_box mCustomScrollbar_y">--%>
<%--    <form method="post" id="viewForm">--%>
<%--        <table width="100%">--%>
<%--            <tbody>--%>
<%--            <tr>--%>
<%--                <th>客户编号：</th>--%>
<%--                <td id="custCodeView"></td>--%>
<%--                <th>手机号码：</th>--%>
<%--                <td id="mobileView"></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th>头像：</th>--%>
<%--                <td>--%>
<%--                    <div id="headImgView"></div>--%>
<%--                </td>--%>
<%--                <th>昵称：</th>--%>
<%--                <td id="nickNameView"></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th>性别：</th>--%>
<%--                <td id="sexCNView"></td>--%>
<%--                <th>所在省市：</th>--%>
<%--                <td id="addressView"></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th>公司名称：</th>--%>
<%--                <td colspan="3" id="companyNameView"></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th>职位名称：</th>--%>
<%--                <td id="jobView"></td>--%>
<%--                <th>是否会员：</th>--%>
<%--                <td id="isMemberView"></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th>是否禁用：</th>--%>
<%--                <td id="isForbidView"></td>--%>
<%--                <th>注册时间：</th>--%>
<%--                <td id="registerDateView"></td>--%>
<%--            </tr>--%>
<%--            </tbody>--%>
<%--        </table>--%>
<%--    </form>--%>
<%--</div>--%>

<!-- 设置会员 -->
<div id="setMember" class="add_box mCustomScrollbar_y">
    <form method="post" id="setMemberForm" action="${ctx.path}/manage/customer/member/setMember${ctx.bizSuffix}"
          style="height: 100%;">
        <div class="add_list">
            <h5>客户编号：</h5>
            <div class="add_value">
                <span id="custCodeEdit"></span>
                <input type="hidden" name="custId" id="custIdEdit"/>
            </div>
        </div>
        <div class="add_list">
            <h5>手机号码：</h5>
            <div class="add_value">
                <span id="mobileEdit"></span>
                <input type="hidden" name="custCode" id="custCodeEdit2"/>
            </div>
        </div>

        <div class="add_list">
            <h5><em style="color: red;">*</em>会员类型：</h5>
            <div class="add_value">
                <select class="select" name="memberType" id="memberTypeEdit" type="select"
                        onchange="changeVipType(this.options[this.options.selectedIndex].value);">
                    <option value="">全部</option>
                    <option value="0">普通用户</option>
                    <option value="1">省级VIP</option>
                    <option value="2">高级VIP</option>
                    <option value="3">项目VIP</option>
                </select>
            </div>
        </div>

        <div class="add_list" id="roleAreas">
            <h5>权限区域：</h5>
            <div class="add_value">
                <div id="roleProvinceNameSelect"></div>
                <input type="hidden" name="roleProvinceIds" id="roleProvinceIdsPut">
                <input type="hidden" name="roleProvinceNames" id="roleProvinceNamesPut">
            </div>
        </div>

        <div class="add_list">
            <h5><em style="color: red;">*</em>会员开始时间：</h5>
            <div class="add_value">
                <input type="text" id="useStartTimeEdit" name="useStartTime" class="inputtext"
                       onclick="WdatePicker({startDate:'%y-%M-%d 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'useEndTimeEdit\')}'})"
                       style="min-width: 120px;"/>
            </div>
        </div>

        <div class="add_list">
            <h5><em style="color: red;">*</em>会员结束时间：</h5>
            <div class="add_value">
                <input type="text" id="useEndTimeEdit" name="useEndTime" class="inputtext"
                       onclick="WdatePicker({startDate:'%y-%M-%d 23:59:59',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'useStartTimeEdit\')}'})"
                       style="min-width: 120px;"/>
            </div>
        </div>
    </form>
</div>

</body>
</html>