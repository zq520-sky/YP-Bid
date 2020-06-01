<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ include file="/resources/platform/inc.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <script src="${ctx.path}/resources/js/common/DataForm.js?v=${ctx.version}"></script>
    <script src="${ctx.path}/resources/script/customer/memberManage.js?v=${ctx.version}8"></script>
    <script src="${ctx.path}/resources/components/My97DatePicker/WdatePicker.js?v=${ctx.version}"></script>
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
    <form class="tableform" action="${ctx.path}/manage/customer/member/queryMemberList${ctx.pageSuffix}" method="post"
          id="pageForm">
        <div class="operation_box" id="operation_box">
            <div class="operation_con">
                <div class="currenttit"></div>
                <div class="operation_info">
                    <p:auth mcode="MENU_MANAGE_CUSTOMER_MEMBER_EXPORT">
                        <button type="button" class="btn add_btn"
                                onclick="fun_export('${ctx.path}/manage/customer/member/exportMemberList${ctx.bizSuffix}')">
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
                               value="${memberVo.custCode}"/>
                    </li>
                    <li>
                        <input type="text" id="mobileSearch" name="mobile" class="inputtext" placeholder="手机号码"
                               value="${memberVo.mobile}"/>
                    </li>
                    <li>
                        <label class="inputlabel">会员类型：</label>
                        <select class="select" name="memberType" id="memberTypeSearch" type="select">
                            <option value="">全部</option>
                            <option value="1"
                                    <c:if test="${memberVo.memberType == 1}">selected</c:if> >省级VIP
                            </option>
                            <option value="2"
                                    <c:if test="${memberVo.memberType == 2}">selected</c:if> >高级VIP
                            </option>
                            <option value="3"
                                    <c:if test="${memberVo.memberType == 3}">selected</c:if> >项目VIP
                            </option>
                        </select>
                    </li>
                    <li>
                        <label class="inputlabel">入会时间：</label>
                        <input type="text" id="createDateBeginSearch" name="createDateBegin" class="inputtext"
                               onclick="WdatePicker({startDate:'%y-%M-%d 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'createDateEndSearch\')}'})"
                               style="min-width: 120px;"
                               value="<fmt:formatDate value='${memberVo.createDateBegin}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
                        <em class="inputto">至</em>
                        <input type="text" id="createDateEndSearch" name="createDateEnd" class="inputtext"
                               onclick="WdatePicker({startDate:'%y-%M-%d 23:59:59',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'createDateBeginSearch\')}'})"
                               style="min-width: 120px;"
                               value="<fmt:formatDate value='${memberVo.createDateEnd}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
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
                                <th width="100">会员类型</th>
                                <th width="100">权限区域</th>
                                <th width="150">会员开始时间</th>
                                <th width="150">会员结束时间</th>
                                <th width="150">入会时间</th>
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
                                <td title="${data.memberTypeCN }">${data.memberTypeCN }</td>
                                <c:choose>
                                    <c:when test="${data.roleProvinceNames == null || data.roleProvinceNames ==''}">
                                        <td title="全国">全国</td>
                                    </c:when>
                                    <c:when test="${data.headImg !=null || data.headImg !='' }">
                                        <td title="${data.roleProvinceNames }">${data.roleProvinceNames }</td>
                                    </c:when>
                                </c:choose>
                                <td title="<fmt:formatDate value='${data.useStartTime }' pattern='yyyy-MM-dd HH:mm:ss'/>">
                                    <fmt:formatDate value='${data.useStartTime }' pattern='yyyy-MM-dd HH:mm:ss'/>
                                </td>
                                <td title="<fmt:formatDate value='${data.useEndTime }' pattern='yyyy-MM-dd HH:mm:ss'/>">
                                    <fmt:formatDate value='${data.useEndTime }' pattern='yyyy-MM-dd HH:mm:ss'/>
                                </td>
                                <td title="<fmt:formatDate value='${data.createDate }' pattern='yyyy-MM-dd HH:mm:ss'/>">
                                    <fmt:formatDate value='${data.createDate }' pattern='yyyy-MM-dd HH:mm:ss'/>
                                </td>
                                <td class="operation_td">
                                    <p:auth mcode="MENU_MANAGE_CUSTOMER_MEMBER_VIEW">
                                        <button class="operationbtn" type="button"
                                                onclick="viewPage(${data.memberId});">
                                            <span>查看</span>
                                        </button>
                                    </p:auth>
                                    <p:auth mcode="MENU_MANAGE_CUSTOMER_MEMBER_UPDATE">
                                        <button class="operationbtn" type="button"
                                                onclick="editPage(${data.memberId});">
                                            <span>编辑</span>
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
<div id="viewMember" class="detail_box mCustomScrollbar_y" data-mcs-theme="dark" style="display:none;">
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
            <tr>
                <th>公司名称：</th>
                <td id="companyNameView"></td>
                <th>所在省市：</th>
                <td id="addressView"></td>
            </tr>
            <tr>
                <th>职位名称：</th>
                <td id="jobView"></td>
                <th>注册时间：</th>
                <td id="registerDateView"></td>
            </tr>
            </tbody>

        </table>

        <table width="100%">
            <thead>
            <tr colspan="2"><b>会员信息</b></tr>
            </thead>

            <tbody>
            <tr>
                <th>会员类型：</th>
                <td id="memberTypeCNView"></td>
                <th>入会时间：</th>
                <td id="createDateView"></td>
            </tr>
            <tr>
                <th>权限区域：</th>
                <td colspan="3" id="roleProvinceNamesView"></td>
            </tr>
            <tr>
                <th>会员开始时间：</th>
                <td id="useStartTimeView"></td>
                <th>会员结束时间：</th>
                <td id="useEndTimeView"></td>
            </tr>
            </tbody>

        </table>
    </form>
</div>

<!-- 编辑会员 -->
<div id="editMember" class="detail_box mCustomScrollbar_y">
    <form method="post" id="editMemberForm" action="${ctx.path}/manage/customer/member/updateMember${ctx.bizSuffix}"
          style="height: 100%;">
        <table width="100%">

            <thead>
            <tr colspan="2"><b>基本信息</b></tr>
            </thead>

            <tbody>
            <tr>
                <th>客户编号：</th>
                <td id="custCodeEdit"></td>
                <th>手机号码：</th>
                <td id="mobileEdit"></td>
            </tr>
            <tr>
                <th>昵称：</th>
                <td id="nickNameEdit"></td>
                <th>性别：</th>
                <td id="sexCNEdit"></td>
            </tr>
            <tr>
                <th>公司名称：</th>
                <td id="companyNameEdit"></td>
                <th>所在省市：</th>
                <td id="addressEdit"></td>
            </tr>
            <tr>
                <th>职位名称：</th>
                <td id="jobEdit"></td>
                <th>注册时间：</th>
                <td id="registerDateEdit"></td>
            </tr>
            </tbody>

        </table>

        <table width="100%">
            <thead>
            <tr colspan="2"><b>会员信息</b></tr>
            </thead>

            <tbody>
            <tr>
                <th>会员类型：</th>
                <td>
                    <select class="select" name="memberType" id="memberTypeEdit" type="select"
                            onchange="changeVipType(this.options[this.options.selectedIndex].value);">
                        <option value="">全部</option>
                        <option value="0">普通用户</option>
                        <option value="1">省级VIP</option>
                        <option value="2">高级VIP</option>
                        <option value="3">项目VIP</option>
                    </select>
                    <input type="hidden" id="memberIdPut" name="memberId"/>
                    <input type="hidden" id="custIdPut" name="custId"/>
                </td>
                <th class="hideTr roleHi"></th>
                <td class="hideTr roleHi"></td>
                <th class="roleTh">权限区域：</th>
                <td class="hideTr" id="roleProvinceNamesEdit"></td>
                <td id="roleProvinceNameSelectTd">
                    <div id="roleProvinceNameSelect"></div>
                    <input type="hidden" name="roleProvinceIds" id="roleProvinceIdsPut">
                    <input type="hidden" name="roleProvinceNames" id="roleProvinceNamesPut">
                </td>
            </tr>
            <tr>
                <th>入会时间：</th>
                <td id="createDateEdit"></td>
                <th></th>
                <td></td>
            </tr>
            <tr>
                <th>会员开始时间：</th>
                <td>
                    <input type="text" id="useStartTimeEdit" name="useStartTime" class="inputtext"
                           onclick="WdatePicker({startDate:'%y-%M-%d 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'useEndTimeEdit\')}'})"
                           style="min-width: 120px;"/>
                </td>
                <th>会员结束时间：</th>
                <td>
                    <input type="text" id="useEndTimeEdit" name="useEndTime" class="inputtext"
                           onclick="WdatePicker({startDate:'%y-%M-%d 23:59:59',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'useStartTimeEdit\')}'})"
                           style="min-width: 120px;"/>
                </td>
            </tr>
            </tbody>

        </table>
    </form>
</div>

</body>
</html>