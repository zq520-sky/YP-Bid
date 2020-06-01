var index = null;
var frameId = window.frameElement && window.frameElement.id || '';
var editProjectValidate, editProjectDetailValidate;


$(function() {
    //校验表单
    editProjectValidate = $("#editForm").validate(
        {
            rules: {

            },
            messages: {

            },
            submitHandler: function (form) {
                $(form).ajaxSubmit(
                    {
                        //表单提交成功后的回调
                        success: function (responseText, statusText,
                                           xhr, $form) {
                            if (responseText.rs > 0) {
                                top.toastr.success("编辑项目信息成功！");
                                FormUtil.resetForm("editForm");
                                doSearch();
                                layer.close(index); //再执行关闭
                            }
                        }
                    });
            }
        });

    editProjectDetailValidate = $("#editDetailForm").validate(
        {
            rules: {
            },
            messages: {
            },
            submitHandler: function (form) {
                $(form).ajaxSubmit(
                    {
                        //表单提交成功后的回调
                        success: function (responseText, statusText,
                                           xhr, $form) {
                            if (responseText.rs > 0) {
                                top.toastr.success("编辑项目详情成功！");
                                FormUtil.resetForm("editDetailForm");
                                doSearch();
                                layer.close(index); //再执行关闭
                            }
                        }
                    });
            }
        });
});



//执行查询
function doSearch() {
    $("#pageForm").submit();
    top.progressbar(frameId);
}

function viewPage(id) {
    if (Number(id)) {
        $.ajax({
            url : ctx.path + '/manage/project/info/viewProjectInfo' + ctx.bizSuffix,
            async : true,
            dataType : 'json',
            type : 'POST',
            data : {projectId : id},
            success : function(data) {
                if (data.rs == -1) {
                    top.toastr.error("获取数据信息失败");
                    return false;
                }
                //返回的map对象参数
                let dataRet = data.data;
                let provinceName = dataRet['provinceName']
                let cityName = dataRet['cityName']
                $("#viewForm #addressView").html(provinceName + " " + cityName)
                for (var key in dataRet) {
                    //对页面属性赋值（要求页面id与map的key值保持一致）
                    $("#viewForm #" + key + "View").html(dataRet[key]);
                }
                parentIndex = layer.open({
                    title : '查看项目信息',
                    type : 1,
                    area : [ '60%', '80%' ], //宽高
                    content : $('#viewProject'),
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
            url : ctx.path + '/manage/project/info/viewProjectInfo' + ctx.bizSuffix,
            async : true,
            dataType : 'json',
            type : 'POST',
            data : {projectId : id},
            success : function(data) {
                if (data.rs == -1) {
                    top.toastr.error("获取数据信息失败");
                    return false;
                }
                //返回的map对象参数
                let dataRet = data.data;
                let provinceName = dataRet['provinceName']
                let cityName = dataRet['cityName']
                $("#editForm #addressEdit").html(provinceName + " " + cityName)
                for (var key in dataRet) {
                    //对页面属性赋值（要求页面id与map的key值保持一致）
                    $("#editForm").find("#"+key+"Edit").val(dataRet[key]);
                }
                let weburl = dataRet['datasourceWeburl']
                let addDate = dataRet['addDate']
                $("#editForm #datasourceWeburlEdit").html(weburl)
                $("#editForm #addDateEdit").html(addDate)
                parentIndex = layer.open({
                    title : '编辑项目信息',
                    type : 1,
                    area : [ '75%', '90%' ], //宽高
                    content : $('#editProject'),
                    btn : [ '确定', '取消' ],
                    yes : function(index, layero) {
                        setFormValue();
                        $("#editForm").submit();
                    },
                    close: function(index, layero){
                        layer.close(index);
                    },
                    cancel : function(index) {
                        FormUtil.resetForm("editForm");
                        editProjectValidate.resetForm();
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

function setFormValue(){
    let datasourceTypeName = $("#datasourceTypeIdEdit").find("option:selected").text();
    $("#datasourceTypeNameEdit").val(datasourceTypeName);
    let datasourceIndustryName = $("#datasourceIndustryIdEdit").find("option:selected").text();
    $("#datasourceIndustryNameEdit").val(datasourceIndustryName);
    let industryName = $("#industryIdEdit").find("option:selected").text();
    $("#industryNameEdit").val(industryName);
    let datasourceInfotypeName = $("#datasourceInfotypeIdEdit").find("option:selected").text();
    $("#datasourceInfotypeNameEdit").val(datasourceInfotypeName);
    let infotypeName = $("#infotypeIdEdit").find("option:selected").text();
    $("#infotypeNameEdit").val(infotypeName);
}

//删除
function delPage(id, code, name) {
    if (Number(id)) {
        var msg = "确定是否删除项目【"+name+"】吗？";
        layer.confirm(msg, {
            icon : 3,
            title : "提示信息"
        }, function(index) {
            $.post(ctx.path + "/manage/project/info/delProjectInfo"+ ctx.bizSuffix,
                {
                    projectId : id,
                    projectCode : code,
                    projectTitle : name
                },
                function(result){
                    if (result.rs == 1) {
                        top.toastr.success("删除项目成功！");
                        doSearch();
                    }
                }, "json");
            layer.close(index);
        });
    } else {
        top.toastr.error("数据异常！");
    }
}

//编辑详情
function editDetailPage(id){
    if (Number(id)) {
        $.ajax({
            url : ctx.path + '/manage/project/info/viewProjectInfo' + ctx.bizSuffix,
            async : true,
            dataType : 'json',
            type : 'POST',
            data : {projectId : id},
            success : function(data) {
                if (data.rs == -1) {
                    top.toastr.error("获取数据信息失败");
                    return false;
                }
                //返回的map对象参数
                let dataRet = data.data;
                let projectName = dataRet['projectTitle']
                let projectDetail = dataRet['projectDetail']
                let projectId = dataRet['projectId']
                let projectCode = dataRet['projectCode']
                $("#editDetailForm #projectIdEditDetail").val(projectId)
                $("#editDetailForm #projectCodeEditDetail").val(projectCode)
                $("#editDetailForm #projectNameEditDetail").html(projectName)
                var ue = UE.getEditor('projectDetailEdit', {
                    autoHeightEnabled: false
                });
                ue.addListener("ready", function () {
                    ue.setContent(htmlDecode(projectDetail));
                    ue.setHeight('200');
                });
                // 自定义文件上传的controller
                // UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
                // UE.Editor.prototype.getActionUrl = function(action) {
                //     if (action == 'uploadimage' || action == 'uploadscrawl') {
                //         return ctx.path+'/platform/common/ueditor/1/fileUpload'+ctx.noAuthSuffix;
                //     } else if (action == 'uploadvideo') {
                //         return ctx.path+'/platform/common/ueditor/2/fileUpload'+ctx.noAuthSuffix;
                //     } else {
                //         return this._bkGetActionUrl.call(this, action);
                //     }
                // }
                parentIndex = layer.open({
                    title : '编辑项目详情信息',
                    type : 1,
                    area : [ '75%', '95%' ], //宽高
                    content : $('#editDetailProject'),
                    btn : [ '确定', '取消' ],
                    yes : function(index, layero) {
                        $("#editDetailForm").submit();
                    },
                    close: function(index, layero){
                        layer.close(index);
                    },
                    cancel : function(index) {
                        FormUtil.resetForm("editDetailForm");
                        editProjectDetailValidate.resetForm();
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

function htmlEncode(value){
    if (value) {
        return jQuery('<div />').text(value).html();
    } else {
        return '';
    }
}

function htmlDecode(value) {
    if (value) {
        return $('<div />').html(value).text();
    } else {
        return '';
    }
}