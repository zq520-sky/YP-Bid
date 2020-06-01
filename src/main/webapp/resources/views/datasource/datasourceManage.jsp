<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/resources/platform/inc.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${ctx.path}/resources/components/zTree/css/zTreeStyle/zTreeStyle.css" />
    <script type="text/javascript" src="${ctx.path}/resources/components/zTree/js/jquery.ztree.core-3.5.min.js"></script>
    <script type="text/javascript" src="${ctx.path}/resources/components/zTree/js/jquery.ztree.exedit-3.5.min.js"></script>
    <script type="text/javascript" src="${ctx.path}/resources/components/zTree/js/jquery.ztree.excheck-3.5.min.js"></script>
    <style type="text/css">
        .ztree li span.button.add {display:inline-block; margin-left:2px; margin-top:0px; margin-right: -1px; background-position:-144px 0; vertical-align:top; *vertical-align:middle}
        .ztree li span.button.up {display:inline-block;margin-left:2px; margin-top:0px; margin-right: 2px; width:16px; height:16px; vertical-align:top; *vertical-align:middle;background-image: url("${ctx.path}/resources/components/zTree/css/zTreeStyle/img/custom/up.png");}
        .ztree li span.button.down {display:inline-block;margin-left:2px; margin-top:0px; margin-right: 2px; width:16px; height:16px; vertical-align:top; *vertical-align:middle;background-image: url("${ctx.path}/resources/components/zTree/css/zTreeStyle/img/custom/down.png");}
        .ztree li span.button.disable {display:inline-block;margin-left:2px; margin-top:0px; margin-right: 2px; width:16px; height:16px; vertical-align:top; *vertical-align:middle;background-image: url("${ctx.path}/resources/components/zTree/css/zTreeStyle/img/custom/disable.png");}
        .ztree li span.button.enable {display:inline-block;margin-left:2px; margin-top:0px; margin-right: 2px; width:16px; height:16px; vertical-align:top; *vertical-align:middle;background-image: url("${ctx.path}/resources/components/zTree/css/zTreeStyle/img/custom/enable.png");}

        *{ box-sizing: border-box;}
        body,h1,h2,h3,h4,h5{padding:0;margin:0;font-family: "微软雅黑";}
        h1,h2,h3,h4,h5{ font-weight: normal;}
        .hr-30{height:30px;}
        .left{position:fixed; width:215px; height:100%; OVERFLOW-Y: auto;OVERFLOW-X: hidden;}
        .right{ margin-left:215px; margin-right:10px;display:none;}
        .right h2{ font-size:18px;color:#354052;}
        .right .new_con{ position:relative; clear: both; min-height: 38px; padding:10px 0;}
        .right .new_con .necessary{ position:absolute; top:14px; color:#ff4800;}
        .right .new_con .new_name{ float:left; width:95px; margin-left:10px; line-height:25px; color:#5f6b7e;}
        .right .new_con .new_content{position: relative; float:left; min-width:400px;color:#5f6b7e}
        .right .new_con .new_text{ width:253px; height:30px; padding:7px 5px; border-radius:4px; border:1px solid #ddd;}
        .right .bottom{ text-align:right; padding-right:20px; border-top:1px solid #dfdfdf;}
        .right .btn{ display:inline-block; height:30px; line-height:27px; padding:0 20px; background-color:#4d72a9; border:1px solid #4d72a9; border-radius:4px; font-size:13px; color:#FFF; cursor:pointer;}
        .float-e-margins .btn {margin-bottom: 0px;}
    </style>
    <script src="${ctx.path}/resources/js/common/DataForm.js?v=1.0"></script>
    <script type="text/javascript" src="${ctx.path}/resources/script/datasource/datasourceManage.js?v=${ctx.version}"></script>
</head>
<body>

<div class="tree_box">
    <div class="tree_con">
        <ul id="treeDemo" class="ztree"></ul>
    </div>
</div>
<div class="tree_tablelist">
    <iframe width="100%" id="datasourceList" height="100%" src="" frameborder="0" border="0" scrolling="auto"></iframe>
</div>


<!-- 查看 -->
<div id="viewDatasource" class="add_box mCustomScrollbar_y">
    <form method="post" id="viewForm">
        <div class="add_list">
            <h5>数据来源类型名称：</h5>
            <div class="add_value">
                <span id="datasourceTypeNameView"></span>
            </div>
        </div>
        <div class="add_list">
            <h5>数据来源名称（网站）：</h5>
            <div class="add_value">
                <span id="datasourceWebnameView"></span>
            </div>
        </div>
        <div class="add_list">
            <h5>数据来源网址：</h5>
            <div class="add_value">
                <span id="datasourceWeburlView"></span>
            </div>
        </div>
        <div class="add_list">
            <h5>所属省市：</h5>
            <div class="add_value">
                <span id="addressView"></span>
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

<div id="addDatasource" class="add_box mCustomScrollbar_y">
    <form method="post" id="addForm" action="/manage/datasource/info/addInfo${ctx.bizSuffix}">
        <div class="add_list">
            <h5><em style="color: red;">*</em>数据来源类型名称：</h5>
            <div class="add_value">
                <st:commonSelect name="datasourceTypeId" id="datasourceTypeIdAdd" className="select"
                                 defaultText="请选择" defaultValue=""
                                 sql="select datasource_type_id as val, datasource_type_name as text from t_datasource_type order by datasource_type_id asc"/>
            </div>
        </div>
        <div class="add_list">
            <h5><em style="color: red;">*</em>数据来源名称：</h5>
            <div class="add_value">
                <input type="text" class="inputtext" name="datasourceWebname" id="datasourceWebnameAdd" maxlength="100"/>
            </div>
        </div>
        <div class="add_list">
            <h5><em style="color: red;">*</em>数据来源网址：</h5>
            <div class="add_value">
                <input type="text" class="inputtext" name="datasourceWeburl" id="datasourceWeburlAdd" maxlength="100"/>
            </div>
        </div>
        <div class="add_list">
            <h5><em style="color: red;">*</em>所属省市：</h5>
            <div class="add_value">
                <st:commonSelect className="select" name="provinceId" id="provinceIdAdd" style="width: 80px"
                                 defaultText="全部" defaultValue="" onchange='changeProvince(this.options[this.options.selectedIndex].value, -1, "Add");'
                                 sql="select province_id as val, province_name as text from t_sys_province order by province_id asc"/>
                <select id="cityIdAdd" name="cityId" class="select" style="margin-left: 5px; width: 80px;">
                    <option value="">全部</option>
                </select>
            </div>
        </div>
        <div class="add_list">
            <h5>备注：</h5>
            <div class="add_value">
                <textarea class="textarea" id="remarkAdd" name="remark" maxlength="200" style="width: 357px;height:90px;"></textarea>
            </div>
        </div>
    </form>
</div>

<div id="editDatasource" class="add_box mCustomScrollbar_y">
    <form method="post" id="editForm" action="/manage/datasource/info/updateInfo${ctx.bizSuffix}">
        <div class="add_list">
            <h5><em style="color: red;">*</em>数据来源类型名称：</h5>
            <div class="add_value">
                <st:commonSelect name="datasourceTypeId" id="datasourceTypeIdEdit" className="select"
                                 defaultText="请选择" defaultValue=""
                                 sql="select datasource_type_id as val, datasource_type_name as text from t_datasource_type order by datasource_type_id asc"/>
            </div>
        </div>
        <div class="add_list">
            <h5><em style="color: red;">*</em>数据来源名称：</h5>
            <div class="add_value">
                <input type="text" class="inputtext" name="datasourceWebname" id="datasourceWebnameEdit" maxlength="100"/>
            </div>
        </div>
        <div class="add_list">
            <h5><em style="color: red;">*</em>数据来源网址：</h5>
            <div class="add_value">
                <input type="text" class="inputtext" name="datasourceWeburl" id="datasourceWeburlEdit" maxlength="100"/>
            </div>
        </div>
        <div class="add_list">
            <h5><em style="color: red;">*</em>所属省市：</h5>
            <div class="add_value">
                <st:commonSelect className="select" name="provinceId" id="provinceIdEdit" style="width: 80px"
                                 defaultText="全部" defaultValue="" onchange='changeProvince(this.options[this.options.selectedIndex].value, -1, "Edit");'
                                 sql="select province_id as val, province_name as text from t_sys_province order by province_id asc"/>
                <select id="cityIdEdit" name="cityId" class="select" style="margin-left: 5px; width: 80px;">
                    <option value="">全部</option>
                </select>
            </div>
        </div>
        <div class="add_list">
            <h5>备注：</h5>
            <div class="add_value">
                <textarea class="textarea" id="remarkEdit" name="remark" maxlength="200" style="width: 357px;height:90px;"></textarea>
            </div>
        </div>
    </form>
</div>

</body>
</html>