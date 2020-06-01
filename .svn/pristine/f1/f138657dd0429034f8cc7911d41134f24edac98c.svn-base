// 初始化树节点
var zTree = null;
var validator;
var parentIndex = null;
let addDatasourceValidate, editDatasourceValidate;

$(function () {
    $.fn.zTree.init($("#treeDemo"), setting, []);

    $("#tree").height($(window).height() - 155);

    $(window).bind('resize', function () {
        $("#tree").height($(window).height() - 155);
    });

    addDatasourceValidate = $("#addForm").validate(
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
                                $("#crawList")[0].contentWindow.doSearch();
                                top.toastr.success("新增省市信息成功！");
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
                                $("#crawList")[0].contentWindow.doSearch();
                                top.toastr.success("编辑数据爬取规则成功！");
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
    $("#crawList").load(function () {
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
    //设置异步数据加载，初始化tree
    async: {
        enable: true,
        //获取树节点信息
        url: ctx.path + "/manage/datasource/craw/getCrawTypes" + ctx.noAuthSuffix,
        //异步回调数据处理
        dataFilter: filter
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
            name: "datacrawlerServiceName",
            //点击跳转url，当后台数据只能生成 url 属性，又不想实现点击节点跳转的功能时，可以直接修改此属性为其他不存在的属性名称，默认值："url"
            url: "none"
        },
        //设置数据显示的id和pid对应的数据库字段
        simpleData: {
            enable: true,
            idKey: "datacrawlerServiceId",
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

//对 Ajax 返回数据进行预处理
function filter(treeId, parentNode, childNodes) {
    if (!childNodes) {
        return null;
    }
    let zNode = [{datacrawlerServiceName: "全部爬虫服务", open: true, children: childNodes.data}]
    return zNode;
}


function onAsyncSuccess(event, treeId, treeNode, msg) {
    zTree = $.fn.zTree.getZTreeObj(treeId);
    zTree.expandAll(true);
}

//treeId: treeDemo
function zTreeOnClick(event, treeId, treeNode) {
    if (treeNode.parentTId) {
        $("#crawList").attr('src', ctx.path + "/manage/datasource/craw/queryCrawList" + ctx.noAuthSuffix + "?datacrawlerServiceId=" + treeNode.datacrawlerServiceId);
    } else {
        $("#crawList").attr('src', ctx.path + "/manage/datasource/craw/queryCrawList" + ctx.noAuthSuffix);
    }
}


function viewPage(id) {
    if (Number(id)) {
        $.ajax({
            url: ctx.path + '/manage/datasource/craw/viewCraw' + ctx.bizSuffix,
            async: true,
            dataType: 'json',
            type: 'POST',
            data: {datacrawlerSetId: id},
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
                let provinceName = dataRet['provinceName']
                let cityName = dataRet['cityName']
                let exeBeginTime = dataRet['exeStartTime']
                let exeEndTime = dataRet['exeEndTime']
                $("#viewForm #addressView").html(provinceName + " " + cityName)
                parentIndex = layer.open({
                    title: '查看数据爬取规则',
                    type: 1,
                    area: ['450px', '550'], //宽高
                    content: $('#viewCity'),
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
        title: '新增数据爬取规则',
        type: 1,
        area: ['450px', '550px'], //宽高
        content: $('#addCity'),
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
            url: ctx.path + '/manage/datasource/craw/viewCraw' + ctx.bizSuffix,
            async: true,
            dataType: 'json',
            type: 'POST',
            data: {datacrawlerSetId: id},
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
                console.log("####################" + JSON.stringify(dataRet))
                let datasourceTypeId = dataRet['datasourceTypeId']
                let datasourceId = dataRet['datasourceId']
                changDatasourceType(datasourceTypeId, datasourceId, "Edit")
                changDatasource(datasourceId, "Edit")
                let provinceName = dataRet.provinceName;
                let cityName = dataRet.cityName;
                let weburl = dataRet.datasourceWeburl;
                $("#datasourceWeburlEditView").html(weburl);
                $("#addressEditView").html(provinceName + " " + cityName);
                parentIndex = layer.open({
                    title: '编辑数据爬取规则',
                    type: 1,
                    area: ['450px', '550px'], //宽高
                    content: $('#editIndustry'),
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
        var msg = "确定删除爬取规则信息吗？";
        layer.confirm(msg, {
            icon: 3,
            title: "提示信息"
        }, function (index) {
            $.get(ctx.path + "/manage/datasource/craw/delCraw" + ctx.bizSuffix + "?datacrawlerSetId=" + id, function (result) {
                if (result.rs == 1) {
                    top.toastr.success("删除成功！");
                    $("#crawList")[0].contentWindow.doSearch();
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
    var oprStr = flag == 0 ? "禁用" : "启用";
    var opr = flag == 0 ? 1 : 0;
    if (Number(id)) {
        var msg = "确定是否" + oprStr + "该来源站点吗？";
        layer.confirm(msg, {
            icon: 3,
            title: "提示信息"
        }, function (index) {
            $.post(ctx.path + "/manage/datasource/craw/bidCraw" + ctx.bizSuffix,
                {
                    datacrawlerSetId: id,
                    isForbid: opr,
                    datacrawlerServiceName: name
                },
                function (result) {
                    if (result.rs == 1) {
                        top.toastr.success(oprStr + "站点成功！");
                        $("#crawList")[0].contentWindow.doSearch();
                    }
                }, "json");
            layer.close(index);
        });
    } else {
        top.toastr.error("数据异常！");
    }
}

function changDatasourceType(id, datasourceId, type) {
    $("#datasourceId" + type).empty();
    $('#datasourceId' + type).append('<option value="">全部</option>');
    $("#datasourceWeburl" + type + "View").html('');
    $("#address" + type + "View").html('');
    if (id) {
        $.get(ctx.path + "/manage/datasource/info/getDatasourceByTypeId" + ctx.noAuthSuffix + "?datasourceTypeId=" + id, function (data) {
            for (var j = 0; j < data.length; j++) {
                if (datasourceId && datasourceId == data[j].datasource_id) {
                    $('#datasourceId' + type).append('<option selected value="' + data[j].datasource_id + '">' + data[j].datasource_webname + '</option>');
                } else {
                    $('#datasourceId' + type).append('<option value="' + data[j].datasource_id + '">' + data[j].datasource_webname + '</option>');
                }
            }
        }, "json");
    }
}

function changDatasource(id, type) {
    $("#datasourceWeburl" + type + "View").html('');
    $("#address" + type + "View").html('');
    if (id) {
        $.get(ctx.path + "/manage/datasource/info/getDatasourceById" + ctx.noAuthSuffix + "?datasourceId=" + id, function (data) {
            let datasourceWeburl = data.datasourceWeburl;
            let provinceName = data.provinceName;
            let cityName = data.cityName;
            $("#datasourceWeburl" + type + "View").html(datasourceWeburl);
            $("#address" + type + "View").html(provinceName + " " + cityName);
        }, "json");
    }
}