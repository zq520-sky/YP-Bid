var index = null;
var frameId = window.frameElement && window.frameElement.id || '';
var addValidate, editValidate;

function doSearch() {
    $("#pageForm").submit();
    parent.progress();
}

//校验
$(function () {
    //编辑校验
    editValidate = $("#editForm").validate({
        rules: {
            hotwordName: {
                required: true
            },
            searchTimes: {
                required: true
            },
            createDate: {
                required: true
            }
        },
        messages: {
            hotwordName: {
                required: "请输入热词！"
            },
            searchTimes: {
                required: "请输入搜索次数(店铺名称)！"
            },
            createDate: {
                required: "请输入新增时间！"
            }
        },
        submitHandler: function (form) {
            $(form).ajaxSubmit({
                //表单提交成功后的回调
                success: function (responseText, statusText, xhr, $form) {
                    if (responseText.rs > 0) {
                        top.toastr.success("编辑热词信息【" + $("#editForm").find("#hotwordNameEdit").text() + "】成功！");
                        FormUtil.resetForm("editForm");
                        doSearch();
                        layer.close(index); //再执行关闭
                    }
                }
            });
        }
    });

    addValidate = $("#addForm").validate({
        rules: {
            hotwordName: {
                required: true
            },
            searchTimes: {
                required: true
            }
        },
        messages: {
            hotwordName: {
                required: "请输入热词内容！"
            },
            searchTimes: {
                required: "请输入搜索次数！"
            }
        },
        submitHandler: function (form) {
            $(form).ajaxSubmit({
                //表单提交成功后的回调
                success: function (responseText, statusText, xhr, $form) {
                    if (responseText.rs > 0) {
                        top.toastr.success("新增热词内容成功！");
                        FormUtil.resetForm("addForm");
                        doSearch();
                        layer.close(index); //再执行关闭
                    }
                }
            });
        }
    });
});


//打开查看页面
function viewPage(id) {
    if (Number(id)) {
        $.ajax({
            url: ctx.path + '/manage/planproject/hotword/viewHotword' + ctx.bizSuffix,
            async: true,
            dataType: 'json',
            type: 'POST',
            data: {hotwordId: id},
            success: function (data) {
                if (data.rs == -1) {
                    top.toastr.error("获取数据信息失败");
                    return false;
                }
                //返回的map对象参数
                var dataRet = data.data;
                for (var key in dataRet) {
                    //对页面属性赋值（要求页面id与map的key值保持一致）
                    $("#viewForm #" + key).html(dataRet[key]);
                }
                parentIndex = layer.open({
                    title: '查看',
                    type: 1,
                    area: ['380px', '420px'], //宽高
                    content: $('#viewId'),
                    btn: ['关闭'],
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

//删除
function delHotWord(id) {
    if (Number(id)) {
        var msg = "确定删除该热词吗？";
        layer.confirm(msg, {
            icon: 3,
            title: "提示信息"
        }, function (index) {
            $.get(ctx.path + "/manage/planproject/info/delPlanproject" + ctx.bizSuffix + "?hotwordId=" + id, function (result) {
                if (result.rs == 1) {
                    top.toastr.success("删除成功！");
                    doSearch();
                    //刷新表单
                }
            }, "json");
            layer.close(index);
        });
    } else {
        top.toastr.error("数据异常！");
    }
}

//打开编辑页面
function editPage(id) {
    if (Number(id)) {
        $.ajax({
            url: ctx.path + '/manage/planproject/hotword/updateHotword' + ctx.bizSuffix,
            async: true,
            dataType: 'json',
            type: 'POST',
            data: {
                hotwordId: id
            },
            success: function (data) {
                if (data.rs == -1) {
                    top.toastr.error("操作失败");
                    return false;
                }
                var dataRet = data.data;
                for (var key in dataRet) {
                    //对页面属性赋值（要求页面id与map的key值保持一致）
                    $("#editForm #" + key + "Edit").val(dataRet[key]);
                }
                $("#editForm #hotwordNameEdit").text(dataRet.hotwordName);
                $("#editForm #searchTimesEdit").text(dataRet.searchTimes);
                $("#editForm #createDateEdit").text(dataRet.createDate);
                parentIndex = layer.open({
                    title: '编辑搜索热词信息',
                    type: 1,
                    area: ['450px', '320px'], //宽高
                    btn: ['保存', '关闭'],
                    yes: function (index, layero) {
                        $("#editForm").submit();
                    },
                    content: $('#editId'),
                    cancel: function (index) {
                        FormUtil.resetForm("editForm");
                        editValidate.resetForm();
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


//新增
function openAddPage() {
    //获取所有部门
    index = layer.open({
        type: 1,
        title: '新增项目关键词',
        move: false,
        area: ['420px', '300px'], //宽高
        content: $('#addId'),
        btn: ['保存', '关闭'],
        yes: function (index, layero) {
            $("#addForm").submit();
        },
        cancel: function (index) {
            FormUtil.resetForm("addForm");
            addValidate.resetForm();
        }
    })
}