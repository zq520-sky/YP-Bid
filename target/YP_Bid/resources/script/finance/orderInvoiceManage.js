var index = null;
var frameId = window.frameElement && window.frameElement.id || '';
var editInvoicdValidate;
//执行查询
function doSearch() {
    $("#pageForm").submit();
    top.progressbar(frameId);
}

$(function(){
    //校验表单
    editInvoicdValidate = $("#editForm").validate(
        {
            rules: {
                invoiceType : {
                    required : true
                },
                unitName : {
                    required : true
                },
                unitTin : {
                    required : true
                },
                unitAddress : {
                    required : true
                },
                unitTel : {
                    required : true
                },
                unitBank : {
                    required : true
                },
                unitBankaccount : {
                    required : true
                },
                invoiceMoney : {
                    required : true,
                    money : true
                },
                applyTime : {
                    required : true
                },
                status : {
                    required : true
                },
                makeTime : {
                    required : true
                },
                addressee : {
                    required : true
                },
                tel : {
                    required : true
                },
                address : {
                    required : true
                }
            },
            messages: {
                invoiceType : {
                    required : "请选择发票类型"
                },
                unitName : {
                    required : "请输入单位名称！"
                },
                unitTin : {
                    required : "请输入纳税人识别号！"
                },
                unitAddress : {
                    required : "请输入企业地址！"
                },
                unitTel : {
                    required : "请输入企业联系电话！"
                },
                unitBank : {
                    required : "请输入开户行！"
                },
                unitBankaccount : {
                    required : "请输入银行账号！"
                },
                invoiceMoney : {
                    required : "请输入发票金额！",
                    money : "请输入正确的发票金额！"
                },
                applyTime : {
                    required : "请输入申请时间！"
                },
                status : {
                    required : "请选择开票状态！"
                },
                makeTime : {
                    required : "请输入开票时间！"
                },
                addressee : {
                    required : "请输入收件人！"
                },
                tel : {
                    required : "请输入收件人电话！"
                },
                address : {
                    required : "请输入收件人地址！"
                }
            },
            submitHandler: function (form) {
                $(form).ajaxSubmit(
                    {
                        //表单提交成功后的回调
                        success: function (responseText, statusText,
                                           xhr, $form) {
                            if (responseText.rs > 0) {
                                top.toastr.success("编辑发票成功！");
                                FormUtil.resetForm("editForm");
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
            url : ctx.path + '/manage/finance/invoice/viewInvoice' + ctx.bizSuffix,
            async : true,
            dataType : 'json',
            type : 'POST',
            data : {invoiceId : id},
            success : function(data) {
                if (data.rs == -1) {
                    top.toastr.error("获取数据信息失败");
                    return false;
                }
                //返回的map对象参数
                let dataRet = data.data;
                for (var key in dataRet) {
                    //对页面属性赋值（要求页面id与map的key值保持一致）
                    $("#viewForm #"+ key + "View").html(dataRet[key]);
                }
                let provinceName = dataRet['provinceName']
                let cityName = dataRet['cityName']
                $("#viewForm #cityInfoView").html(provinceName + " " + cityName);
                parentIndex = layer.open({
                    title : '查看客户发票信息',
                    type : 1,
                    area : [ '60%', '80%' ], //宽高
                    content : $('#viewInvoice'),
                    btn : [ '关闭' ],
                    yes: function(index){
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
            url : ctx.path + '/manage/finance/invoice/viewInvoice' + ctx.bizSuffix,
            async : true,
            dataType : 'json',
            type : 'POST',
            data : {invoiceId : id},
            success : function(data) {
                if (data.rs == -1) {
                    top.toastr.error("获取数据信息失败");
                    return false;
                }
                //返回的map对象参数
                let dataRet = data.data;
                for (var key in dataRet) {
                    //对页面属性赋值（要求页面id与map的key值保持一致）
                    $("#editForm #"+ key + "EditView").html(dataRet[key]);
                    $("#editForm #"+ key + "Edit").val(dataRet[key]);
                }
                let provinceName = dataRet['provinceName']
                let cityName = dataRet['cityName']
                let invoiceId = dataRet['invoiceId']
                $("#editForm #cityInfoEditView").html(provinceName + " " + cityName);
                $("#editForm #invoiceIdEdit").val(invoiceId);
                parentIndex = layer.open({
                    title : '编辑发票信息',
                    type : 1,
                    area : [ '65%', '85%' ], //宽高
                    content : $('#editInvoice'),
                    btn : [ '确定', '取消' ],
                    yes : function(index, layero) {
                        $("#editForm").submit();
                    },
                    close: function(index, layero){
                        layer.close(index);
                    },
                    cancel : function(index) {
                        FormUtil.resetForm("editForm");
                        editInvoicdValidate.resetForm();
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

function setPage(id) {
    if (Number(id)) {
        $.ajax({
            url : ctx.path + '/manage/finance/invoice/viewInvoice' + ctx.bizSuffix,
            async : true,
            dataType : 'json',
            type : 'POST',
            data : {invoiceId : id},
            success : function(data) {
                if (data.rs == -1) {
                    top.toastr.error("获取数据信息失败");
                    return false;
                }
                //返回的map对象参数
                let dataRet = data.data;
                for (var key in dataRet) {
                    //对页面属性赋值（要求页面id与map的key值保持一致）
                    $("#setForm #"+ key + "Set").html(dataRet[key]);
                }
                let provinceName = dataRet['provinceName']
                let cityName = dataRet['cityName']
                $("#setForm #cityInfoSet").html(provinceName + " " + cityName);
                parentIndex = layer.open({
                    title : '开票',
                    type : 1,
                    area : [ '60%', '80%' ], //宽高
                    content : $('#setInvoice'),
                    btn : [ '确定开票', '取消开票', '取消' ],
                    btn1: function(index){
                        setInvoice(id, 1);
                    },
                    btn2: function(index){
                        setInvoice(id, 2);
                    },
                    btn3: function(index){
                        layer.close(index);
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

function setInvoice(id, status){
    let oprStr = status == 1 ? "开票" : "取消开票";
    $.post(ctx.path + "/manage/finance/invoice/setInvoice"+ ctx.bizSuffix,
        {
            invoiceId : id,
            status : status
        },
        function(result){
            if (result.rs == 1) {
                top.toastr.success(oprStr+"成功！");
                doSearch();
            }
        }, "json");
    layer.close(index);
}
