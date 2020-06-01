<%@ page language="java" pageEncoding="utf-8" %>
<%@ include file="/resources/platform/inc.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <script src="${ctx.path}/resources/js/common/DataForm.js?v=${ctx.version}"></script>
    <script src="${ctx.path}/resources/script/finance/orderInvoiceManage.js?v=${ctx.version}1"></script>
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
    <form class="tableform" action="${ctx.path}/manage/finance/invoice/queryInvoiceList${ctx.pageSuffix}" method="post"
          id="pageForm">
        <div class="operation_box" id="operation_box">
            <div class="operation_con">
                <div class="currenttit"></div>
                <div class="operation_info">
                    <p:auth mcode="MENU_MANAGE_FINANCE_INVOICE_EXPORT">
                        <button type="button" class="btn add_btn"
                                onclick="fun_export('${ctx.path}/manage/finance/invoice/exportInvoiceList${ctx.bizSuffix}')">
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
                        <input type="text" id="custCodeOrMobileSearch" name="custCodeOrMobile" class="inputtext"
                               placeholder="客户编号\手机号码"
                               value="${orderInvoiceVo.custCodeOrMobile}"/>
                    </li>
                    <li>
                        <label class="inputlabel">支付方式：</label>
                        <select class="select" name="payMode" id="payModeSearch" type="select">
                            <option value="">全部</option>
                            <option value="0"
                                    <c:if test="${orderInvoiceVo.payMode == 0}">selected</c:if> >微信
                            </option>
                            <option value="1"
                                    <c:if test="${orderInvoiceVo.payMode == 1}">selected</c:if> >支付宝
                            </option>
                            <option value="2"
                                    <c:if test="${orderInvoiceVo.payMode == 2}">selected</c:if> >银联
                            </option>
                            <option value="10"
                                    <c:if test="${orderInvoiceVo.payMode == 10}">selected</c:if> >系统充值
                            </option>
                        </select>
                    </li>
                    <li>
                        <label class="inputlabel">开票状态：</label>
                        <select class="select" name="status" id="statusSearch" type="select">
                            <option value="">全部</option>
                            <option value="0"
                                    <c:if test="${orderInvoiceVo.status == 0}">selected</c:if> >未开票
                            </option>
                            <option value="1"
                                    <c:if test="${orderInvoiceVo.status == 1}">selected</c:if> >已开票
                            </option>
                            <option value="2"
                                    <c:if test="${orderInvoiceVo.status == 2}">selected</c:if> >取消开票
                            </option>
                        </select>
                    </li>
                    <li>
                        <label class="inputlabel">申请时间
                            ：</label>
                        <input type="text" id="applyTimeBeginSearch" name="applyTimeBegin" class="inputtext"
                               onclick="WdatePicker({startDate:'%y-%M-%d 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'applyTimeEndSearch\')}'})"
                               style="min-width: 120px;"
                               value="<fmt:formatDate value='${orderInvoiceVo.applyTimeBegin}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
                        <em class="inputto">至</em>
                        <input type="text" id="applyTimeEndSearch" name="applyTimeEnd" class="inputtext"
                               onclick="WdatePicker({startDate:'%y-%M-%d 23:59:59',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'applyTimeBeginSearch\')}'})"
                               style="min-width: 120px;"
                               value="<fmt:formatDate value='${orderInvoiceVo.applyTimeEnd}' pattern='yyyy-MM-dd HH:mm:ss'/>"/>
                    </li>
                </ul>
            </div>
            <div class="search_btncon">
                <p:auth mcode="MENU_MANAGE_FINANCE_INVOICE_SEARCH">
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
                                <th width="140">订单编号</th>
                                <th width="80">客户编号</th>
                                <th width="100">手机号码</th>
                                <th width="100">昵称</th>
                                <th width="120">发票类型</th>
                                <th width="80">发票金额</th>
                                <th width="80">开票状态</th>
                                <th width="140">开票时间</th>
                                <th width="140">申请时间</th>
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
                                <td title="${data.invoiceTypeCN }">${data.invoiceTypeCN }</td>
                                <td title="${data.invoiceMoney }">${data.invoiceMoney }</td>
                                <td title="${data.statusCN}">${data.statusCN}</td>
                                <td title="<fmt:formatDate value='${data.makeTime }' pattern='yyyy-MM-dd HH:mm:ss'/>">
                                    <fmt:formatDate value='${data.makeTime }' pattern='yyyy-MM-dd HH:mm:ss'/>
                                </td>
                                <td title="<fmt:formatDate value='${data.applyTime }' pattern='yyyy-MM-dd HH:mm:ss'/>">
                                    <fmt:formatDate value='${data.applyTime }' pattern='yyyy-MM-dd HH:mm:ss'/>
                                </td>
                                <td class="operation_td">
                                    <p:auth mcode="MENU_MANAGE_FINANCE_INVOICE_VIEW">
                                        <button class="operationbtn" type="button"
                                                onclick="viewPage(${data.invoiceId});">
                                            <span>查看</span>
                                        </button>
                                    </p:auth>
                                    <p:auth mcode="MENU_MANAGE_FINANCE_INVOICE_UPDATE">
                                        <c:if test="${data.status == 0}">
                                            <button class="operationbtn" type="button"
                                                    onclick="editPage(${data.invoiceId});">
                                                <span>编辑</span>
                                            </button>
                                        </c:if>
                                    </p:auth>
                                    <p:auth mcode="MENU_MANAGE_FINANCE_INVOICE_SET">
                                        <c:if test="${data.status == 0}">
                                            <button class="operationbtn" type="button"
                                                    onclick="setPage(${data.invoiceId});">
                                                <span>开票</span>
                                            </button>
                                        </c:if>
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
<div id="viewInvoice" class="detail_box mCustomScrollbar_y">
    <form method="post" id="viewForm">
        <table width="100%">
            <thead>
            <tr>
                <th><b>订单信息</b></th>
                <td></td>
                <th></th>
                <td style="font-size: 12px;">订单编号：<span id="orderCodeView"></span></td>
            </tr>
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
                <td id="cityInfoView"></td>
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
                <tr>
                    <th><b>发票信息</b></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th>发票类型：</th>
                    <td colspan="3" id="invoiceTypeCNView"></td>
                </tr>
                <tr>
                    <th>单位名称：</th>
                    <td id="unitNameView"></td>
                    <th>纳税人识别号：</th>
                    <td id="unitTinView"></td>
                </tr>
                <tr>
                    <th>企业地址：</th>
                    <td id="unitAddressView"></td>
                    <th>联系电话：</th>
                    <td id="unitTelView"></td>
                </tr>
                <tr>
                    <th>开户行：</th>
                    <td id="unitBankView"></td>
                    <th>银行账号：</th>
                    <td id="unitBankaccountView"></td>
                </tr>
                <tr>
                    <th>发票金额：</th>
                    <td id="invoiceMoneyView"></td>
                    <th>申请时间：</th>
                    <td id="applyTimeView"></td>
                </tr>
                <tr>
                    <th>开票状态：</th>
                    <td id="statusCNView"></td>
                    <th>开票时间：</th>
                    <td id="makeTimeView"></td>
                </tr>
            </tbody>
        </table>

        <table width="100%">
            <thead>
                <th><b>收件人信息</b></th>
            </thead>
            <tbody>
                <tr>
                    <th>收件人：</th>
                    <td id="addresseeView"></td>
                    <th>收件人电话：</th>
                    <td id="telView"></td>
                </tr>
                <tr>
                    <th>收件地址：</th>
                    <td colspan="3" id="addressView"></td>
                </tr>
            </tbody>
        </table>
    </form>
</div>

<!-- 编辑 -->
<div id="editInvoice" class="detail_box mCustomScrollbar_y">
    <form method="post" id="editForm" action="${ctx.path}/manage/finance/invoice/updateInvoice${ctx.bizSuffix}">
        <table width="100%">
            <thead>
            <tr>
                <th><b>订单信息</b></th>
                <td></td>
                <th></th>
                <td style="font-size: 12px;">订单编号：<span id="orderCodeEditView"></span></td>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th>客户编号：</th>
                <td id="custCodeEditView"></td>
                <th>手机号码：</th>
                <td id="mobileEditView"></td>
            </tr>
            <tr>
                <th>昵称：</th>
                <td id="nickNameEditView"></td>
                <th>性别：</th>
                <td id="sexCNEditView"></td>
            </tr>
            <tr>
                <th>公司名称：</th>
                <td id="companyNameEditView"></td>
                <th>所在省市：</th>
                <td id="cityInfoEditView"></td>
            </tr>
            <tr>
                <th>职位名称：</th>
                <td id="jobEditView"></td>
                <th>注册时间：</th>
                <td id="registerDateEditView"></td>
            </tr>
            </tbody>
        </table>

        <table width="100%">
            <thead>
            <tr>
                <th><b>发票信息</b></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th>发票类型：</th>
                <td colspan="3">
                    <select class="select" name="invoiceType" id="invoiceTypeEdit" type="select">
                        <option value="">全部</option>
                        <option value="1">增值税普通发票</option>
                        <option value="2">增值税专用发票</option>
                    </select>
                    <input type="hidden" name="invoiceId" id="invoiceIdEdit" />
                </td>
            </tr>
            <tr>
                <th>单位名称：</th>
                <td>
                    <input type="text" class="inputtext" id="unitNameEdit" name="unitName"/>
                </td>
                <th>纳税人识别号：</th>
                <td>
                    <input type="text" class="inputtext" id="unitTinEdit" name="unitTin"/>
                </td>
            </tr>
            <tr>
                <th>企业地址：</th>
                <td>
                    <input type="text" class="inputtext" id="unitAddressEdit" name="unitAddress"/>
                </td>
                <th>联系电话：</th>
                <td>
                    <input type="text" class="inputtext" id="unitTelEdit" name="unitTel"/>
                </td>
            </tr>
            <tr>
                <th>开户行：</th>
                <td>
                    <input type="text" class="inputtext" id="unitBankEdit" name="unitBank"/>
                </td>
                <th>银行账号：</th>
                <td>
                    <input type="text" class="inputtext" id="unitBankaccountEdit" name="unitBankaccount"/>
                </td>
            </tr>
            <tr>
                <th>发票金额：</th>
                <td>
                    <input type="text" class="inputtext" id="invoiceMoneyEdit" name="invoiceMoney"/>
                </td>
                <th>申请时间：</th>
                <td>
                    <input type="text" id="applyTimeEdit" name="applyTime" class="inputtext"
                           onclick="WdatePicker({startDate:'%y-%M-%d 23:59:59',dateFmt:'yyyy-MM-dd HH:mm:ss'})"
                           style="min-width: 120px;"/>
                </td>
            </tr>
            <tr>
                <th>开票状态：</th>
                <td>
                    <select class="select" name="status" id="statusEdit" type="select">
                        <option value="">全部</option>
                        <option value="0">未开票</option>
                        <option value="1">已开票</option>
                        <option value="2">取消开票</option>
                    </select>
                </td>
                <th>开票时间：</th>
                <td>
                    <input type="text" id="makeTimeEdit" name="makeTime" class="inputtext"
                           onclick="WdatePicker({startDate:'%y-%M-%d 23:59:59',dateFmt:'yyyy-MM-dd HH:mm:ss'})"
                           style="min-width: 120px;"/>
                </td>
            </tr>
            </tbody>
        </table>

        <table width="100%">
            <thead>
            <th><b>收件人信息</b></th>
            </thead>
            <tbody>
            <tr>
                <th>收件人：</th>
                <td>
                    <input type="text" class="inputtext" id="addresseeEdit" name="addressee"/>
                </td>
                <th>收件人电话：</th>
                <td>
                    <input type="text" class="inputtext" id="telEdit" name="tel"/>
                </td>
            </tr>
            <tr>
                <th>收件地址：</th>
                <td colspan="3">
                    <input type="text" class="inputtext" id="addressEdit" style="width: 75%;" name="address"/>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</div>


<!-- 开票 -->
<div id="setInvoice" class="detail_box mCustomScrollbar_y">
    <form method="post" id="setForm">
        <table width="100%">
            <thead>
            <tr>
                <th><b>订单信息</b></th>
                <td></td>
                <th></th>
                <td style="font-size: 12px;">订单编号：<span id="orderCodeSet"></span></td>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th>客户编号：</th>
                <td id="custCodeSet"></td>
                <th>手机号码：</th>
                <td id="mobileSet"></td>
            </tr>
            <tr>
                <th>昵称：</th>
                <td id="nickNameSet"></td>
                <th>性别：</th>
                <td id="sexCNSet"></td>
            </tr>
            <tr>
                <th>公司名称：</th>
                <td id="companyNameSet"></td>
                <th>所在省市：</th>
                <td id="cityInfoSet"></td>
            </tr>
            <tr>
                <th>职位名称：</th>
                <td id="jobSet"></td>
                <th>注册时间：</th>
                <td id="registerDateSet"></td>
            </tr>
            </tbody>
        </table>

        <table width="100%">
            <thead>
            <tr>
                <th><b>发票信息</b></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th>发票类型：</th>
                <td colspan="3" id="invoiceTypeCNSet"></td>
            </tr>
            <tr>
                <th>单位名称：</th>
                <td id="unitNameSet"></td>
                <th>纳税人识别号：</th>
                <td id="unitTinSet"></td>
            </tr>
            <tr>
                <th>企业地址：</th>
                <td id="unitAddressSet"></td>
                <th>联系电话：</th>
                <td id="unitTelSet"></td>
            </tr>
            <tr>
                <th>开户行：</th>
                <td id="unitBankSet"></td>
                <th>银行账号：</th>
                <td id="unitBankaccountSet"></td>
            </tr>
            <tr>
                <th>发票金额：</th>
                <td id="invoiceMoneySet"></td>
                <th>申请时间：</th>
                <td id="applyTimeSet"></td>
            </tr>
            <tr>
                <th>开票状态：</th>
                <td id="statusCNSet"></td>
                <th>开票时间：</th>
                <td id="makeTimeSet"></td>
            </tr>
            </tbody>
        </table>

        <table width="100%">
            <thead>
            <th><b>收件人信息</b></th>
            </thead>
            <tbody>
            <tr>
                <th>收件人：</th>
                <td id="addresseeSet"></td>
                <th>收件人电话：</th>
                <td id="telSet"></td>
            </tr>
            <tr>
                <th>收件地址：</th>
                <td colspan="3" id="addressSet"></td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>