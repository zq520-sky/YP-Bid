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
            rules: {
                industryId: {
                    required: true
                },
                industrySubId: {
                    required: true
                },
                keyWords: {
                    required: true
                },
                orderNum: {
                    required: true
                }
            },
            messages: {
                industryId: {
                    required: "请选择行业大类！"
                },
                industrySubId: {
                    required: "请选择行业分类！"
                },
                keyWords: {
                    required: "请输入分类关键字！"
                },
                orderNum: {
                    required: "请输入顺序号！"
                }
            },
            submitHandler: function (form) {
                $(form).ajaxSubmit(
                    {
                        //表单提交成功后的回调
                        success: function (responseText, statusText,
                                           xhr, $form) {
                            if (responseText.rs > 0) {
                                $("#industrySubList")[0].contentWindow.doSearch();
                                top.toastr.success("新增行业分类信息成功！");
                                FormUtil.resetForm("addForm");
                                layer.close(parentIndex); //再执行关闭
                            }
                        }
                    });
            }
        });

    editDatasourceValidate = $("#editForm").validate(
        {
            rules: {
                industryId: {
                    required: true
                },
                industrySubId: {
                    required: true
                },
                keyWords: {
                    required: true
                },
                orderNum: {
                    required: true
                }
            },
            messages: {
                industryId: {
                    required: "请选择行业大类！"
                },
                industrySubId: {
                    required: "请选择行业分类！"
                },
                keyWords: {
                    required: "请输入分类关键字！"
                },
                orderNum: {
                    required: "请输入顺序号！"
                }
            },
            submitHandler: function (form) {
                $(form).ajaxSubmit(
                    {
                        //表单提交成功后的回调
                        success: function (responseText, statusText,
                                           xhr, $form) {
                            if (responseText.rs > 0) {
                                $("#industrySubList")[0].contentWindow.doSearch();
                                top.toastr.success("编辑来源站点成功！");
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
    $("#industrySubList").load(function () {
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
        url: ctx.path + "/manage/dict/industry/getIndustryTypes" + ctx.noAuthSuffix,
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
            name: "industryName",
            //点击跳转url，当后台数据只能生成 url 属性，又不想实现点击节点跳转的功能时，可以直接修改此属性为其他不存在的属性名称，默认值："url"
            url: "none"
        },
        //设置数据显示的id和pid对应的数据库字段
        simpleData: {
            enable: true,
            idKey: "industryId",
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
    let zNode = [{industryName: "全部行业大类", open: true, children: childNodes.data}]
    return zNode;
}


function onAsyncSuccess(event, treeId, treeNode, msg) {
    zTree = $.fn.zTree.getZTreeObj(treeId);
    zTree.expandAll(true);
}

//treeId: treeDemo
function zTreeOnClick(event, treeId, treeNode) {
    if (treeNode.parentTId) {
        $("#industrySubList").attr('src', ctx.path + "/manage/dict/industry/queryIndustrySubList" + ctx.noAuthSuffix + "?industryId=" + treeNode.industryId);
    } else {
        $("#industrySubList").attr('src', ctx.path + "/manage/dict/industry/queryIndustrySubList" + ctx.noAuthSuffix);
    }
}


function viewPage(id) {
    if (Number(id)) {
        $.ajax({
            url: ctx.path + '/manage/dict/industry/viewIndustryList' + ctx.bizSuffix,
            async: true,
            dataType: 'json',
            type: 'POST',
            data: {industrySubId: id},
            success: function (data) {
                if (data.rs == -1) {
                    top.toastr.error("获取数据信息失败");
                    return false;
                }
                //返回的map对象参数
                let dataRet = data.data;
                for (var key in dataRet) {
                    //对页面属性赋值（要求页面id与map的key值保持一致）
                    $("#viewForm #" + key + "View").html(dataRet[key]);
                }
                let provinceName = dataRet['provinceName']
                let cityName = dataRet['cityName']
                $("#viewForm #addressView").html(provinceName + " " + cityName)
                parentIndex = layer.open({
                    title: '查看行业分类信息',
                    type: 1,
                    area: ['450px', '500px'], //宽高
                    content: $('#viewDatasource'),
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
        title: '新增行业分类信息',
        type: 1,
        area: ['450px', '400px'], //宽高
        content: $('#addIndustry'),
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
            url: ctx.path + '/manage/dict/industry/viewIndustryList' + ctx.bizSuffix,
            async: true,
            dataType: 'json',
            type: 'POST',
            data: {industrySubId: id},
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
                    title: '编辑行业信息',
                    type: 1,
                    area: ['450px', '400px'], //宽高
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
        var msg = "确定删除该行业分类信息吗？";
        layer.confirm(msg, {
            icon: 3,
            title: "提示信息"
        }, function (index) {
            $.get(ctx.path + "/manage/dict/industry/delIndustry" + ctx.bizSuffix + "?industrySubId=" + id, function (result) {
                if (result.rs == 1) {
                    top.toastr.success("删除成功！");
                    $("#industrySubList")[0].contentWindow.doSearch();
                    //刷新表单
                }
            }, "json");
            layer.close(index);
        });
    } else {
        top.toastr.error("数据异常！");
    }
}
