var index = null;
var frameId = window.frameElement && window.frameElement.id || '';
var editMemberPriceValidate, addMemberPriceValidate;
//执行查询
function doSearch() {
    $("#pageForm").submit();
    top.progressbar(frameId);
}



$(function() {
    //校验表单
    editMemberPriceValidate = $("#editForm").validate(
        {
            rules: {
                memberType : {
                    required : true
                },
                oldPrice : {
                    required : true,
                    money : true
                },
                newPrice : {
                    required : true,
                    money : true
                },
                months : {
                    required : true,
                    negative : true
                },
                giveMonths : {
                    required : true,
                    negative : true
                }
            },
            messages: {
                memberType : {
                    required : "请选择会员类型！"
                },
                oldPrice : {
                    required : "请输入原价！",
                    money : "请输入正确的金额！"
                },
                newPrice : {
                    required : "请输入现价！",
                    money : "请输入正确的金额！"
                },
                months : {
                    required : "请输入时间范围！",
                    negative : "请输入正整数！"
                },
                giveMonths : {
                    required : "请输入赠送月数！",
                    negative : "请输入正整数！"
                }
            },
            submitHandler: function (form) {
                $(form).ajaxSubmit(
                    {
                        //表单提交成功后的回调
                        success: function (responseText, statusText,
                                           xhr, $form) {
                            if (responseText.rs > 0) {
                                top.toastr.success("编辑价格套餐成功！");
                                FormUtil.resetForm("editForm");
                                doSearch();
                                layer.close(index); //再执行关闭
                            }
                        }
                    });
            }
        });
    addMemberPriceValidate = $("#addForm").validate(
        {
            rules: {
                memberType : {
                    required : true
                },
                oldPrice : {
                    required : true,
                    money : true
                },
                newPrice : {
                    required : true,
                    money : true
                },
                months : {
                    required : true,
                    negative : true
                },
                giveMonths : {
                    required : true,
                    negative : true
                }
            },
            messages: {
                memberType : {
                    required : "请选择会员类型！"
                },
                oldPrice : {
                    required : "请输入原价！",
                    money : "请输入正确的金额！"
                },
                newPrice : {
                    required : "请输入现价！",
                    money : "请输入正确的金额！"
                },
                months : {
                    required : "请输入时间范围！",
                    negative : "请输入正整数！"
                },
                giveMonths : {
                    required : "请输入赠送月数！",
                    negative : "请输入正整数！"
                }
            },
            submitHandler: function (form) {
                $(form).ajaxSubmit(
                    {
                        //表单提交成功后的回调
                        success: function (responseText, statusText,
                                           xhr, $form) {
                            if (responseText.rs > 0) {
                                top.toastr.success("新增价格套餐成功！");
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
        title : '新增价格套餐',
        move : true,
        area : [ '500px', '450px' ], //宽高
        content : $('#AddMemberPrice'),
        btn : [ '保存', '关闭' ],
        yes : function(index, layero) {
            $("#addForm").submit();
        },
        cancel : function(index) {
            FormUtil.resetForm("addForm");
            addMemberPriceValidate.resetForm();
        }
    });

}

//打开查看页面
function viewPage(id) {
    if (Number(id)) {
        $.ajax({
            url : ctx.path + '/manage/finance/price/combo/viewPrice' + ctx.bizSuffix,
            async : true,
            dataType : 'json',
            type : 'POST',
            data : {priceId : id},
            success : function(data) {
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
                parentIndex = layer.open({
                    title : '查看价格套餐信息',
                    type : 1,
                    area : [ '500px', '450px' ], //宽高
                    content : $('#viewMemberPrice'),
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
            url : ctx.path + '/manage/finance/price/combo/viewPrice' + ctx.bizSuffix,
            async : true,
            dataType : 'json',
            type : 'POST',
            data : {priceId : id},
            success : function(data) {
                if (data.rs == -1) {
                    top.toastr.error("获取数据信息失败");
                    return false;
                }
                //返回的map对象参数
                var dataRet = data.data;
                for (var key in dataRet) {
                    //对页面属性赋值（要求页面id与map的key值保持一致）
                    $("#editForm").find("#"+key+"Edit").val(dataRet[key]);
                }
                parentIndex = layer.open({
                    title : '编辑价格套餐信息',
                    type : 1,
                    area : [ '500px', '450px' ], //宽高
                    content : $('#editMemberPrice'),
                    btn : [ '确定', '取消' ],
                    yes : function(index, layero) {
                        $("#editForm").submit();
                    },
                    close: function(index, layero){
                        layer.close(index);
                    },
                    cancel : function(index) {
                        FormUtil.resetForm("editForm");
                        editMemberPriceValidate.resetForm();
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


//禁用/启用
function setPage(id, flag) {
    //操作禁用和启用的时候正好相反
    var oprStr = flag == 0 ? "禁用" : "启用";
    var opr = flag == 0 ? 1 : 0;
    if (Number(id)) {
        var msg = "确定是否"+oprStr+"该价格套餐吗？";
        layer.confirm(msg, {
            icon : 3,
            title : "提示信息"
        }, function(index) {
            $.post(ctx.path + "/manage/finance/price/combo/disAndEnablePrice"+ ctx.bizSuffix,
                {
                    priceId : id,
                    isForbid : opr
                },
                function(result){
                    if (result.rs == 1) {
                        top.toastr.success(oprStr+"价格套餐成功！");
                        doSearch();
                    }
                }, "json");
            layer.close(index);
        });
    } else {
        top.toastr.error("数据异常！");
    }
}

function delPage(id) {
    if (Number(id)) {
        var msg = "确定是否删除该价格套餐吗？";
        layer.confirm(msg, {
            icon : 3,
            title : "提示信息"
        }, function(index) {
            $.post(ctx.path + "/manage/finance/price/combo/delPrice"+ ctx.bizSuffix,
                {
                    priceId : id
                },
                function(result){
                    if (result.rs == 1) {
                        top.toastr.success("删除价格套餐成功！");
                        doSearch();
                    }
                }, "json");
            layer.close(index);
        });
    } else {
        top.toastr.error("数据异常！");
    }
}