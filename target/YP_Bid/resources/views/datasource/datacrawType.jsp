<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ include file="/resources/platform/inc.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${ctx.path}/resources/components/zTree/css/zTreeStyle/zTreeStyle.css"/>
    <script type="text/javascript"
            src="${ctx.path}/resources/components/zTree/js/jquery.ztree.core-3.5.min.js"></script>
    <script type="text/javascript"
            src="${ctx.path}/resources/components/zTree/js/jquery.ztree.exedit-3.5.min.js"></script>
    <script type="text/javascript"
            src="${ctx.path}/resources/components/zTree/js/jquery.ztree.excheck-3.5.min.js"></script>
    <style type="text/css">
        .ztree li span.button.add {
            display: inline-block;
            margin-left: 2px;
            margin-top: 0px;
            margin-right: -1px;
            background-position: -144px 0;
            vertical-align: top;
            *vertical-align: middle
        }

        .ztree li span.button.up {
            display: inline-block;
            margin-left: 2px;
            margin-top: 0px;
            margin-right: 2px;
            width: 16px;
            height: 16px;
            vertical-align: top;
            *vertical-align: middle;
            background-image: url("${ctx.path}/resources/components/zTree/css/zTreeStyle/img/custom/up.png");
        }

        .ztree li span.button.down {
            display: inline-block;
            margin-left: 2px;
            margin-top: 0px;
            margin-right: 2px;
            width: 16px;
            height: 16px;
            vertical-align: top;
            *vertical-align: middle;
            background-image: url("${ctx.path}/resources/components/zTree/css/zTreeStyle/img/custom/down.png");
        }

        .ztree li span.button.disable {
            display: inline-block;
            margin-left: 2px;
            margin-top: 0px;
            margin-right: 2px;
            width: 16px;
            height: 16px;
            vertical-align: top;
            *vertical-align: middle;
            background-image: url("${ctx.path}/resources/components/zTree/css/zTreeStyle/img/custom/disable.png");
        }

        .ztree li span.button.enable {
            display: inline-block;
            margin-left: 2px;
            margin-top: 0px;
            margin-right: 2px;
            width: 16px;
            height: 16px;
            vertical-align: top;
            *vertical-align: middle;
            background-image: url("${ctx.path}/resources/components/zTree/css/zTreeStyle/img/custom/enable.png");
        }

        * {
            box-sizing: border-box;
        }

        body, h1, h2, h3, h4, h5 {
            padding: 0;
            margin: 0;
            font-family: "微软雅黑";
        }

        h1, h2, h3, h4, h5 {
            font-weight: normal;
        }

        .hr-30 {
            height: 30px;
        }

        .left {
            position: fixed;
            width: 215px;
            height: 100%;
            OVERFLOW-Y: auto;
            OVERFLOW-X: hidden;
        }

        .right {
            margin-left: 215px;
            margin-right: 10px;
            display: none;
        }

        .right h2 {
            font-size: 18px;
            color: #354052;
        }

        .right .new_con {
            position: relative;
            clear: both;
            min-height: 38px;
            padding: 10px 0;
        }

        .right .new_con .necessary {
            position: absolute;
            top: 14px;
            color: #ff4800;
        }

        .right .new_con .new_name {
            float: left;
            width: 95px;
            margin-left: 10px;
            line-height: 25px;
            color: #5f6b7e;
        }

        .right .new_con .new_content {
            position: relative;
            float: left;
            min-width: 400px;
            color: #5f6b7e
        }

        .right .new_con .new_text {
            width: 253px;
            height: 30px;
            padding: 7px 5px;
            border-radius: 4px;
            border: 1px solid #ddd;
        }

        .right .bottom {
            text-align: right;
            padding-right: 20px;
            border-top: 1px solid #dfdfdf;
        }

        .right .btn {
            display: inline-block;
            height: 30px;
            line-height: 27px;
            padding: 0 20px;
            background-color: #4d72a9;
            border: 1px solid #4d72a9;
            border-radius: 4px;
            font-size: 13px;
            color: #FFF;
            cursor: pointer;
        }

        .float-e-margins .btn {
            margin-bottom: 0px;
        }
    </style>
    <script src="${ctx.path}/resources/js/common/DataForm.js?v=1.0"></script>
    <script type="text/javascript"
            src="${ctx.path}/resources/script/datasource/datacrawType.js?v=${ctx.version}"></script>
    <script src="${ctx.path}/resources/components/My97DatePicker/WdatePicker.js?v=${ctx.version}1"></script>
</head>
<body>

<div class="tree_box">
    <div class="tree_con">
        <ul id="treeDemo" class="ztree"></ul>
    </div>
</div>
<div class="tree_tablelist">
    <iframe width="100%" id="crawList" height="100%" src="" frameborder="0" border="0" scrolling="auto"></iframe>
</div>


<!-- 查看 -->
<div id="viewCity" class="detail_box mCustomScrollbar_y">
    <form method="post" id="viewForm">
        <table width="100%">
            <thead>
            <tr>
                <th><b>数据来源信息</b></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th>数据来源类型名称：</th>
                <td colspan="4" id="datasourceTypeNameView"></td>
            </tr>
            <tr>
                <th>数据来源名称（网站）：</th>
                <td colspan="4" id="datasourceWebnameView"></td>
            </tr>
            <tr>
                <th>数据来源网址：</th>
                <td colspan="4" id="datasourceWeburlView"></td>
            </tr>
            <tr>
                <th>所属省市：</th>
                <td colspan="4" id="addressView"></td>
            </tr>
            </tbody>
        </table>
        <table width="100%">
            <thead>
            <tr>
                <th><b>爬虫服务规则</b></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th>执行时间/天：</th>
                <td colspan="4" id="distanceView"></td>
            </tr>
            <tr>
                <th>执行间隔(分钟)：</th>
                <td colspan="4" id="exeIntervalMinView"></td>
            </tr>
            <tr>
                <th>执行次数(次/天)：</th>
                <td colspan="4" id="exeNumsDayView"></td>
            </tr>
            <tr>
                <th>禁用状态：</th>
                <td colspan="4" id="isForbidCnView"></td>
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

<div id="addCity" class="detail_box mCustomScrollbar_y">
    <form method="post" id="addForm" action="/manage/datasource/craw/addCraw${ctx.bizSuffix}">
        <table width="100%">
            <thead>
            <tr>
                <th><b>数据来源信息</b></th>
            </tr>
            </thead>
            <tbody>
            <tr hidden="true">
                <th>服务类型：</th>
                <td colspan="3" id="datacrawlerServiceId" name="datacrawlerServiceId"></td>
            </tr>
            <tr>
                <th style="width: 103px;"><em style="color: red;">*</em>数据来源类型名称：</th>
                <td colspan="3">
                    <st:commonSelect name="datasourceTypeId" id="datasourceTypeIdAdd" className="select"
                                     onchange='changDatasourceType(this.options[this.options.selectedIndex].value, -1, "Add");'
                                     defaultText="请选择" defaultValue=""
                                     sql="select datasource_type_id as val, datasource_type_name as text from t_datasource_type order by datasource_type_id asc"/>

                </td>
            </tr>
            <tr>
                <th><em style="color: red;">*</em>数据来源名称：</th>
                <td colspan="3">
                    <select id="datasourceIdAdd" name="datasourceId" class="select"
                            onchange='changDatasource(this.options[this.options.selectedIndex].value, "Add");'>
                        <option value="">全部</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th><em style="color: red;">*</em>爬虫服务类型名称：</th>
                <td colspan="3">
                    <st:commonSelect name="datacrawlerServiceId" id="datacrawlerServiceIdAdd" className="select"
                                     defaultText="请选择" defaultValue=""
                                     sql="select datacrawler_service_id as val, datacrawler_service_name as text from t_datacrawler_service order by datacrawler_service_id asc"/>
                </td>
            </tr>
            <tr>
                <th>数据来源网址：</th>
                <td colspan="3" id="datasourceWeburlAddView"></td>
            </tr>
            <tr>
                <th>所属省市：</th>
                <td colspan="3" id="addressAddView"></td>
            </tr>
            </tbody>
        </table>
        <table width="100%">
            <thead>
            <tr>
                <th><b>爬虫服务规则</b></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th><em style="color: red;">*</em>执行时间：</th>
                <td colspan="3" style="display: inline">
                    <input type="text" id="exeStartTimeAdd" name="exeStartTime" class="inputtext"
                           onclick="WdatePicker({exeStartTime:'%y-%M-%d 00:00:00',dateFmt:'HH:mm:ss'})"
                           style="min-width: 120px;"/>-
                    <input type="text" id="exeEndTimeAdd" name="exeEndTime" class="inputtext"
                           onclick="WdatePicker({exeEndTime:'%y-%M-%d 00:00:00',dateFmt:'HH:mm:ss'})"
                           style="min-width: 120px;"/>
                </td>
            </tr>
            <tr>
                <th><em style="color: red;">*</em>执行间隔：</th>
                <td colspan="3">
                    <input type="text" name="exeIntervalMin" id="exeIntervalMinAdd" style="width: 171px;"
                           class="inputtext" maxlength="300"/>
                </td>
            </tr>
            <tr>
                <th><em style="color: red;">*</em>执行次数：</th>
                <td colspan="3">
                    <input type="text" name="exeNumsDay" id="exeNumsDayAdd" style="width: 171px;" class="inputtext"
                           maxlength="300"/>
                </td>
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

<div id="editIndustry" class="detail_box mCustomScrollbar_y">
    <form method="post" id="editForm" action="/manage/datasource/craw/updateCraw${ctx.bizSuffix}">
        <table width="100%">
            <thead>
            <tr>
                <th><b>数据来源信息</b></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th style="width: 103px;"><em style="color: red;">*</em>数据来源类型名称：</th>
                <td colspan="3">
                    <st:commonSelect name="datasourceTypeId" id="datasourceTypeIdAdd" className="select"
                                     onchange='changDatasourceType(this.options[this.options.selectedIndex].value, -1, "Edit");'
                                     defaultText="请选择" defaultValue=""
                                     sql="select datasource_type_id as val, datasource_type_name as text from t_datasource_type order by datasource_type_id asc"/>
                    <input type="hidden" name="datasourceTypeName" id="datasourceTypeNameEdit"/>
                    <input type="hidden" name="datacrawlerSetId" id="datacrawlerSetIdEdit">
                </td>
            </tr>
            <tr>
                <th><em style="color: red;">*</em>数据来源名称：</th>
                <td colspan="3">
                    <select id="datasourceIdEdit" name="datasourceId" class="select"
                            onchange='changDatasource(this.options[this.options.selectedIndex].value, "Edit");'>
                        <option value="">全部</option>
                    </select>
                </td>
            <tr>
                <th>数据来源网址：</th>
                <td colspan="3" id="datasourceWeburlEditView"></td>
            </tr>
            <tr>
                <th>所属省市：</th>
                <td colspan="3" id="addressEditView"></td>
            </tr>
            </tbody>
        </table>
        <table width="100%">
            <thead>
            <tr>
                <th><b>爬虫服务规则</b></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th><em style="color: red;">*</em>执行时间：</th>
                <td colspan="3" style="display: inline">
                    <input type="text" id="exeStartTimeEdit" name="exeStartTime" class="inputtext"
                           onclick="WdatePicker({exeStartTime:'%y-%M-%d 00:00:00',dateFmt:'HH:mm:ss'})"
                           style="min-width: 120px;"/>-
                    <input type="text" id="exeEndTimeEdit" name="exeEndTime" class="inputtext"
                           onclick="WdatePicker({exeEndTime:'%y-%M-%d 00:00:00',dateFmt:'HH:mm:ss'})"
                           style="min-width: 120px;"/>
                </td>
            </tr>
            <tr>
                <th><em style="color: red;">*</em>执行间隔：</th>
                <td colspan="3">
                    <input type="text" name="exeIntervalMin" id="exeIntervalMinEdit" style="width: 171px;"
                           class="inputtext" maxlength="300"/>
                </td>
            </tr>
            <tr>
                <th><em style="color: red;">*</em>执行次数：</th>
                <td colspan="3">
                    <input type="text" name="exeNumsDay" id="exeNumsDayEdit" style="width: 171px;" class="inputtext"
                           maxlength="300"/>
                </td>
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
</body>
</html>