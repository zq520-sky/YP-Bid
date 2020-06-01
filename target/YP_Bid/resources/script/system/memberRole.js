var index = null;
var frameId = window.frameElement && window.frameElement.id || '';
var addValidate, editValidate;

//校验
$(function () {
    //编辑校验
    editValidate = $("#editForm").validate({
        rules: {
            readProjectNum: {
                required: true
            },
            subscribeNum: {
                required: true
            },
            collectNum: {
                required: true
            },
            recommendNum: {
                required: true
            },
            planProjectNum: {
                required: true
            },
            advancedNum: {
                required: true
            }
        },
        messages: {
            readProjectNum: {
                required: "请输入项目查看数量！"
            },
            subscribeNum: {
                required: "请输入项目订阅数量！"
            },
            collectNum: {
                required: "请输入项目收藏数量！"
            },
            recommendNum: {
                required: "请输入项目推荐数量！"
            },
            planProjectNum: {
                required: "请输入拟建项目数量！"
            },
            advancedNum: {
                required: "请输入高级项目数量！"
            }
        },
        submitHandler: function (form) {
            $(form).ajaxSubmit({
                //表单提交成功后的回调
                success: function (responseText, statusText, xhr, $form) {
                    if (responseText.rs > 0) {
                        top.toastr.success("编辑会员权限信息成功！");
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
            url: ctx.path + '/manage/platform/memberRole/viewMemberRoleList' + ctx.bizSuffix,
            async: true,
            dataType: 'json',
            type: 'POST',
            data: {memberRoleId: id},
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
                    title: '查看会员权限信息',
                    type: 1,
                    area: ['400px', '450px'], //宽高
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

//打开编辑页面
function editPage(id) {
    if (Number(id)) {
        $.ajax({
            url: ctx.path + '/manage/platform/memberRole/viewMemberRoleList' + ctx.bizSuffix,
            async: true,
            dataType: 'json',
            type: 'POST',
            data: {
                memberRoleId: id
            },
            success: function (data) {
                if (data.rs == -1) {
                    top.toastr.error("操作失败");
                    return false;
                }
                var dataRet = data.data;
                //返回的map对象参数
                console.log(dataRet);
                var mC = dataRet['memberTypeCn'];
                var readProjectNum = dataRet['readProjectNum'];
                var subscribeNum = dataRet['subscribeNum'];
                var cn = dataRet['cNum'];
                var recommendNum = dataRet['recommendNum'];
                var pn = dataRet['pNum'];
                var an = dataRet['aNum'];
                for (var key in dataRet) {
                    //对页面属性赋值（要求页面id与map的key值保持一致）
                    $("#editForm #" + key + "Edit").val(dataRet[key]);
                }
                $("#editId #memberTypeCnEdit").html(mC);
                $("#editId #readProjectNumEdit").val(readProjectNum);
                $("#editId #subscribeNumEdit").val(subscribeNum);
                $("#editId #collectNumEdit").val(dataRet['cNum']);
                $("#editId #recommendNumEdit").val(recommendNum);
                $("#editId #planProjectNumEdit").val(pn);
                $("#editId #advancedNumEdit").val(an);
                parentIndex = layer.open({
                    title: '编辑会员权限信息',
                    type: 1,
                    area: ['450px', '350px'], //宽高
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
