// 初始化树节点
var zTree = null;
var validator;
var parentIndex = null;
let addDatasourceValidate, editDatasourceValidate;

$(function () {

    var zNodes = [
        {
            name: "全部来源类型",
            children: [
                {
                    "id": 1,
                    "name": "省级在线审批监管平台"
                },
                {
                    "id": 2,
                    "name": "省级政务服务网"

                },
                {
                    "id": 3,
                    "name": "其他"
                }
            ]
        }
    ]

    $.fn.zTree.init($("#treeDemo"), setting, zNodes);

    $("#tree").height($(window).height() - 155);

    $(window).bind('resize', function () {
        $("#tree").height($(window).height() - 155);
    });

    addDatasourceValidate = $("#addForm").validate(
        {
            rules: {
                datasourceType: {
                    required: true
                },
                datasourceWebname: {
                    required: true
                },
                datasourceWeburl: {
                    required: true
                },
                provinceId: {
                    required: true
                },
                cityId: {
                    required: true
                }
            },
            messages: {
                datasourceType: {
                    required: "请选择来源类型！"
                },
                datasourceWebname: {
                    required: "请输入网站名称"
                },
                datasourceWeburl: {
                    required: "请输入网页地址"
                },
                provinceId: {
                    required: "请选择省份！"
                },
                cityId: {
                    required: "请选择所属城市！"
                }
            },
            submitHandler: function (form) {
                $(form).ajaxSubmit(
                    {
                        //表单提交成功后的回调
                        success: function (responseText, statusText,
                                           xhr, $form) {
                            if (responseText.rs > 0) {
                                $("#planDataSourceList")[0].contentWindow.doSearch();
                                top.toastr.success("新增拟建数据来源成功！");
                                FormUtil.resetForm("addForm");
                                layer.close(parentIndex); //再执行关闭
                            }
                        }
                    });
            }
        });

    editDatasourceValidate = $("#editForm").validate(
        {
            rules: {},
            messages: {},
            submitHandler: function (form) {
                $(form).ajaxSubmit(
                    {
                        //表单提交成功后的回调
                        success: function (responseText, statusText,
                                           xhr, $form) {
                            if (responseText.rs > 0) {
                                $("#planDataSourceList")[0].contentWindow.doSearch();
                                top.toastr.success("编辑拟建数据来源成功！");
                                FormUtil.resetForm("editForm");
                                layer.close(parentIndex); //再执行关闭
                            }
                        }
                    });
            }
        });
});

//单独触发滚动条
function progress() {
    var index = top.layer.load(0, {
        shade: [0.3, '#000']
    });
    $("#planDataSourceList").load(function () {
        top.layer.close(index);
    });
}

// setting 节点配置
var setting = {
    //设置鼠标悬停和移除按钮事件
    view: {
        selectedMulti: false,
        showIcon: false
    },

    data: {
        //keep不用写，用默认即可，除非用到对应功能
        keep: {
            //叶子节点属性锁,默认false,为true时，则所有 isParent = false 的节点，都无法添加子节点
            leaf: false,
            parent: false
        },
        key: {
            //zTree 节点数据中保存子节点数据的属性名称。
            children: "children",
            //定义树中要显示的数据对应的后台字段名
            name: "name",
            //点击跳转url，当后台数据只能生成 url 属性，又不想实现点击节点跳转的功能时，可以直接修改此属性为其他不存在的属性名称，默认值："url"
            url: "none"
        },
        //设置数据显示的id和pid对应的数据库字段
        simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "",
            //用于修正根节点父节点数据，即 pIdKey 指定的属性值
            rootPId: "0"
        }
    },
    //回调
    callback: {
        onAsyncSuccess: onAsyncSuccess,
        //设置节点点击事件
        onClick: zTreeOnClick
    }
};


function onAsyncSuccess(event, treeId, treeNode, msg) {
    zTree = $.fn.zTree.getZTreeObj(treeId);
    zTree.expandAll(true);
}

//treeId: treeDemo
function zTreeOnClick(event, treeId, treeNode) {
    if (treeNode.parentTId) {
        $("#planDataSourceList").attr('src', ctx.path + "/manage/planproject/datasource/queryDatasourceList" + ctx.noAuthSuffix + "?datasourceId=" + treeNode.id);
    } else {
        $("#planDataSourceList").attr('src', ctx.path + "/manage/planproject/datasource/queryDatasourceList" + ctx.noAuthSuffix);
    }
}


function viewPage(id) {
    if (Number(id)) {
        $.ajax({
            url: ctx.path + '/manage/planproject/datasource/viewDatasource' + ctx.bizSuffix,
            async: true,
            dataType: 'json',
            type: 'POST',
            data: {datasourceId: id},
            success: function (data) {
                if (data.rs == -1) {
                    top.toastr.error("获取数据信息失败");
                    return false;
                }
                //返回的map对象参数
                var dataRet = data.data;
                for (var key in dataRet) {
                    //对页面属性赋值（要求页面id与map的key值保持一致）
                    $("#viewForm #" + key + "View").html(dataRet[key]);
                }
                var provinceId = dataRet['provinceId']
                var provinceName = dataRet['provinceName']
                var cityName = dataRet['cityName']
                $("#viewForm #addressView").html(provinceName + " " + cityName)
                parentIndex = layer.open({
                    title: '查看拟建项目来源',
                    type: 1,
                    area: ['400px', '500'], //宽高
                    content: $('#viewPlanSource'),
                    btn: ['关闭'],
                    yes: function (index) {
                        layer.close(index);
                    },
                    cancel: function (index) {
                    }
                });
            },
            error: function (jqXHR, textStatus, errorThrown) {
                top.toastr.error("操作失败");
            }
        });
    } else {
        top.toastr.error("数据异常！");
    }

}

function openAddPage() {
    parentIndex = layer.open({
        title: '新增拟建项目来源',
        type: 1,
        area: ['400px', '500px'], //宽高
        content: $('#addPlanSource'),
        btn: ['保存', '关闭'],
        yes: function (index, layero) {
            $("#addForm").submit();
        },
        cancel: function (index) {
            FormUtil.resetForm("addForm");
            addDatasourceValidate.resetForm();
        }
    });
}

function editPage(id) {
    if (Number(id)) {
        $.ajax({
            url: ctx.path + '/manage/planproject/datasource/viewDatasource' + ctx.bizSuffix,
            async: true,
            dataType: 'json',
            type: 'POST',
            data: {datasourceId: id},
            success: function (data) {
                if (data.rs == -1) {
                    top.toastr.error("获取数据信息失败");
                    return false;
                }
                //返回的map对象参数
                let dataRet = data.data;
                for (var key in dataRet) {
                    //对页面属性赋值（要求页面id与map的key值保持一致）
                    $("#editForm").find("#" + key + "Edit").val(dataRet[key]);
                }
                parentIndex = layer.open({
                    title: '编辑拟建项目来源',
                    type: 1,
                    area: ['400px', '500px'], //宽高
                    content: $('#editDatasource'),
                    btn: ['保存', '关闭'],
                    yes: function (index, layero) {
                        $("#editForm").submit();
                    },
                    cancel: function (index) {
                        FormUtil.resetForm("editForm");
                        editDatasourceValidate.resetForm();
                    }
                });
            },
            error: function (jqXHR, textStatus, errorThrown) {
                top.toastr.error("操作失败");
            }
        });
    } else {
        top.toastr.error("数据异常！");
    }
}


function delPage(id) {
    if (Number(id)) {
        var msg = "确定删除拟建项目来源信息吗？";
        layer.confirm(msg, {
            icon: 3,
            title: "提示信息"
        }, function (index) {
            $.get(ctx.path + "/manage/planproject/datasource/delDatasource" + ctx.bizSuffix + "?datasourceId=" + id, function (result) {
                if (result.rs == 1) {
                    top.toastr.success("删除成功！");
                    $("#planDataSourceList")[0].contentWindow.doSearch();
                    //刷新表单
                }
            }, "json");
            layer.close(index);
        });
    } else {
        top.toastr.error("数据异常！");
    }
}

function setPage(id, flag, name) {
    //操作禁用和启用的时候正好相反
    var oprStr = flag == 0 ? "启用" : "禁用";
    var opr = flag == 0 ? 1 : 0;
    if (Number(id)) {
        var msg = "确定是否" + oprStr + "该来源站点吗？";
        layer.confirm(msg, {
            icon: 3,
            title: "提示信息"
        }, function (index) {
            $.post(ctx.path + "/manage/planproject/datasource/bidDatasourceList" + ctx.bizSuffix,
                {
                    datasourceId: id,
                    isForbid: opr,
                    datasourceWebname: name
                },
                function (result) {
                    if (result.rs == 1) {
                        top.toastr.success(oprStr + "站点成功！");
                        $("#planDataSourceList")[0].contentWindow.doSearch();
                    }
                }, "json");
            layer.close(index);
        });
    } else {
        top.toastr.error("数据异常！");
    }
}