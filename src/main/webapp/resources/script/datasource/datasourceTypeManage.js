var index = null;
var frameId = window.frameElement && window.frameElement.id || '';
var editDatasourceType, addDatasourceType;
//执行查询
function doSearch() {
    $("#pageForm").submit();
    top.progressbar(frameId);
}

$(function() {
    //校验表单
    editDatasourceType = $("#editForm").validate(
        {
            rules: {
                datasourceTypeName : {
                    required : true
                }
            },
            messages: {
                datasourceTypeName : {
                    required : "请输入来源类型名称！"
                }
            },
            submitHandler: function (form) {
                $(form).ajaxSubmit(
                    {
                        //表单提交成功后的回调
                        success: function (responseText, statusText,
                                           xhr, $form) {
                            if (responseText.rs > 0) {
                                top.toastr.success("编辑数据来源类型成功！");
                                FormUtil.resetForm("editForm");
                                doSearch();
                                layer.close(index); //再执行关闭
                            }
                        }
                    });
            }
        });
    addDatasourceType = $("#addForm").validate(
        {
            rules: {
                datasourceTypeName : {
                    required : true
                }
            },
            messages: {
                datasourceTypeName : {
                    required : "请输入来源类型名称！"
                }
            },
            submitHandler: function (form) {
                $(form).ajaxSubmit(
                    {
                        //表单提交成功后的回调
                        success: function (responseText, statusText,
                                           xhr, $form) {
                            if (responseText.rs > 0) {
                                top.toastr.success("新增数据来源类型成功！");
                                FormUtil.resetForm("addForm");
                                doSearch();
                                layer.close(index); //再执行关闭
                            }
                        }
                    });
            }
        });
});



function openAddPage() {
    //页面层
    index = layer.open({
        type : 1,
        title : '新增数据来源类型',
        move : true,
        area : [ '400px', '300px' ], //宽高
        content : $('#AddDatasourceType'),
        btn : [ '保存', '关闭' ],
        yes : function(index, layero) {
            $("#addForm").submit();
        },
        cancel : function(index) {
            FormUtil.resetForm("addForm");
            addDatasourceType.resetForm();
        }
    });

}

//打开查看页面
function viewPage(id) {
    if (Number(id)) {
        $.ajax({
            url : ctx.path + '/manage/datasource/type/viewDatasourceType' + ctx.bizSuffix,
            async : true,
            dataType : 'json',
            type : 'POST',
            data : {datasourceTypeId : id},
            success : function(data) {
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
                parentIndex = layer.open({
                    title : '查看数据来源类型',
                    type : 1,
                    area : [ '350px', '300px' ], //宽高
                    content : $('#viewDatasourceType'),
                    btn : [ '关闭' ],
                    yes : function(index, layero) {
                        layer.close(index);
                    },
                    cancel : function(index) {
                    }
                });
            },
            error : function(jqXHR, textStatus, errorThrown) {
                top.toastr.error("操作失败");
            }
        });
    } else {
        top.toastr.error("数据异常！");
    }

}

function editPage(id) {
    if (Number(id)) {
        $.ajax({
            url : ctx.path + '/manage/datasource/type/viewDatasourceType' + ctx.bizSuffix,
            async : true,
            dataType : 'json',
            type : 'POST',
            data : {datasourceTypeId : id},
            success : function(data) {
                if (data.rs == -1) {
                    top.toastr.error("获取数据信息失败");
                    return false;
                }
                //返回的map对象参数
                let dataRet = data.data;
                for (var key in dataRet) {
                    //对页面属性赋值（要求页面id与map的key值保持一致）
                    $("#editForm").find("#"+key+"Edit").val(dataRet[key]);
                }
                parentIndex = layer.open({
                    title : '编辑数据来源类型',
                    type : 1,
                    area : [ '400px', '300px' ], //宽高
                    content : $('#editDatasourceType'),
                    btn : [ '确定', '取消' ],
                    yes : function(index, layero) {
                        $("#editForm").submit();
                    },
                    close: function(index, layero){
                        layer.close(index);
                    },
                    cancel : function(index) {
                        FormUtil.resetForm("editForm");
                        editDatasourceType.resetForm();
                    }
                });
            },
            error : function(jqXHR, textStatus, errorThrown) {
                top.toastr.error("操作失败");
            }
        });
    } else {
        top.toastr.error("数据异常！");
    }

}

function delPage(id, name) {
    if (Number(id)) {
        var msg = "确定是否删除类型【"+name+"】吗？";
        layer.confirm(msg, {
            icon : 3,
            title : "提示信息"
        }, function(index) {
            $.post(ctx.path + "/manage/datasource/type/delDatasourceType"+ ctx.bizSuffix,
                {
                    datasourceTypeId : id,
                    datasourceTypeName: name
                },
                function(result){
                    if (result.rs == 1) {
                        top.toastr.success("删除来源类型【"+name+"】！");
                        doSearch();
                    }
                }, "json");
            layer.close(index);
        });
    } else {
        top.toastr.error("数据异常！");
    }
}