// 初始化树节点
var zTree = null;
var validator;
var parentIndex = null;
let addDatasourceInfotypeValidate, editDatasourceInfotypeValidate;




$(function() {
    $.fn.zTree.init($("#treeDemo"), setting, []);

    $("#tree").height($(window).height() - 155);

    $(window).bind('resize', function() {
        $("#tree").height($(window).height() - 155);
    });


    addDatasourceInfotypeValidate = $("#addForm").validate(
        {
            rules: {
                datasourceInfotypeName : {
                    required : true
                },
                infotypeId : {
                    required : true
                },
                datasourceIndustryId : {
                    required : true
                }
            },
            messages: {
                datasourceInfotypeName : {
                    required : "请输入信息类型名称！"
                },
                infotypeId : {
                    required : "请选择对应招标信息类型！"
                },
                datasourceIndustryId : {
                    required : "请选择来源行业类型！"
                }
            },
            submitHandler: function (form) {
                $(form).ajaxSubmit(
                    {
                        //表单提交成功后的回调
                        success: function (responseText, statusText,
                                           xhr, $form) {
                            if (responseText.rs > 0) {
                                $("#datasourceInfotypeList")[0].contentWindow.doSearch();
                                top.toastr.success("新增来源信息类型成功！");
                                FormUtil.resetForm("addForm");
                                layer.close(parentIndex); //再执行关闭
                            }
                        }
                    });
            }
        });

    editDatasourceInfotypeValidate = $("#editForm").validate(
        {
            rules: {
                datasourceInfotypeName : {
                    required : true
                },
                infotypeId : {
                    required : true
                },
                datasourceIndustryId : {
                    required : true
                }
            },
            messages: {
                datasourceInfotypeName : {
                    required : "请输入信息类型名称！"
                },
                infotypeId : {
                    required : "请选择对应招标信息类型！"
                },
                datasourceIndustryId : {
                    required : "请选择来源行业类型！"
                }
            },
            submitHandler: function (form) {
                $(form).ajaxSubmit(
                    {
                        //表单提交成功后的回调
                        success: function (responseText, statusText,
                                           xhr, $form) {
                            if (responseText.rs > 0) {
                                $("#datasourceInfotypeList")[0].contentWindow.doSearch();
                                top.toastr.success("编辑来源信息类型成功！");
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
        shade : [ 0.3, '#000' ]
    });
    $("#datasourceInfotypeList").load(function() {
        top.layer.close(index);
    });
}

// setting 节点配置
var setting = {
    //设置鼠标悬停和移除按钮事件
    view : {
        selectedMulti : false,
        showIcon : false
    },
    //设置异步数据加载，初始化tree
    async : {
        enable : true,
        //获取树节点信息
        url : ctx.path + "/manage/datasource/type/getDatasourceTypeDetails"+ ctx.noAuthSuffix ,
        //异步回调数据处理
        dataFilter : filter
    },
    data : {
        //keep不用写，用默认即可，除非用到对应功能
        keep : {
            //叶子节点属性锁,默认false,为true时，则所有 isParent = false 的节点，都无法添加子节点
            leaf : false,
            parent : false
        },
        key : {
            //zTree 节点数据中保存子节点数据的属性名称。
            children : "children",
            //定义树中要显示的数据对应的后台字段名
            name : "name",
            //点击跳转url，当后台数据只能生成 url 属性，又不想实现点击节点跳转的功能时，可以直接修改此属性为其他不存在的属性名称，默认值："url"
            url : "none"
        },
        //设置数据显示的id和pid对应的数据库字段
        simpleData : {
            enable : true,
            idKey : "id",
            pIdKey : "pId",
            //用于修正根节点父节点数据，即 pIdKey 指定的属性值
            rootPId : ""
        }
    },
    //回调
    callback : {
        onAsyncSuccess : onAsyncSuccess,
        //设置节点点击事件
        onClick : zTreeOnClick
    }
};

//对 Ajax 返回数据进行预处理
function filter(treeId, parentNode, childNodes) {
    if (!childNodes) {
        return null;
    }
    let zNode = [{name: "全部来源类型", open: true, children: childNodes.data}]
    return zNode;
}


function onAsyncSuccess(event, treeId, treeNode, msg) {
    zTree = $.fn.zTree.getZTreeObj(treeId);
    zTree.expandAll(true);
}

//treeId: treeDemo
function zTreeOnClick(event, treeId, treeNode) {
    if (treeNode.parentTId) {
        let params = '';
        if(treeNode.type == 1){
            params = "?datasourceTypeId=" + treeNode.id;
        }else if(treeNode.type == 2){
            params = "?datasourceId=" + treeNode.id;
        }else if(treeNode.type == 3){
            params = "?datasourceIndustryId=" + treeNode.id;
        }
        $("#datasourceInfotypeList").attr('src', ctx.path + "/manage/datasource/infoType/queryInfoTypeList"+  ctx.noAuthSuffix +params);
    } else {
        $("#datasourceInfotypeList").attr('src', ctx.path + "/manage/datasource/infoType/queryInfoTypeList"+  ctx.noAuthSuffix);
    }
}

function viewPage(id) {
    if (Number(id)) {
        $.ajax({
            url : ctx.path + '/manage/datasource/infoType/viewInfoType' + ctx.bizSuffix,
            async : true,
            dataType : 'json',
            type : 'POST',
            data : {datasourceInfotypeId : id},
            success : function(data) {
                if (data.rs == -1) {
                    top.toastr.error("获取数据信息失败");
                    return false;
                }
                //返回的map对象参数
                let dataRet = data.data;
                if(!dataRet.remark){
                    dataRet.remark = '';
                }
                for (var key in dataRet) {
                    //对页面属性赋值（要求页面id与map的key值保持一致）
                    $("#viewForm #"+ key + "View").html(dataRet[key]);
                }
                let provinceName = dataRet['provinceName']
                let cityName = dataRet['cityName']
                $("#viewForm #addressView").html(provinceName + " " + cityName)
                parentIndex = layer.open({
                    title : '查看来源信息类型',
                    type : 1,
                    area : [ '500px', '300px' ], //宽高
                    content : $('#viewDatasourceInfotype'),
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

function openAddPage(){
    parentIndex = layer.open({
        title : '新增来源信息类型',
        type : 1,
        area : [ '550px', '430px' ], //宽高
        content : $('#addDatasourceInfotype'),
        btn : [ '保存', '关闭' ],
        yes : function(index, layero) {
            $("#addForm").submit();
        },
        cancel : function(index) {
            FormUtil.resetForm("addForm");
            addDatasourceInfotypeValidate.resetForm();
        }
    });
}

function editPage(id) {
    if (Number(id)) {
        $.ajax({
            url : ctx.path + '/manage/datasource/infoType/viewInfoType' + ctx.bizSuffix,
            async : true,
            dataType : 'json',
            type : 'POST',
            data : {datasourceInfotypeId : id},
            success : function(data) {
                if (data.rs == -1) {
                    top.toastr.error("获取数据信息失败");
                    return false;
                }
                //返回的map对象参数
                let dataRet = data.data;
                console.log(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>."+JSON.stringify(dataRet))
                for (var key in dataRet) {
                    //对页面属性赋值（要求页面id与map的key值保持一致）
                    $("#editForm").find("#"+key+"Edit").val(dataRet[key]);
                }
                let datasourceTypeId = dataRet['datasourceTypeId']
                let datasourceId = dataRet['datasourceId']
                let datasourceIndustryId = dataRet['datasourceIndustryId']
                changDatasourceType(datasourceTypeId, datasourceId, "Edit")
                changDatasource(datasourceId, datasourceIndustryId, "Edit")
                let provinceName = dataRet.provinceName;
                let cityName = dataRet.cityName;
                let weburl = dataRet.datasourceWeburl;
                $("#datasourceWeburlEditView").html(weburl);
                $("#addressEditView").html(provinceName + " " +cityName);
                parentIndex = layer.open({
                    title : '编辑来源信息类型',
                    type : 1,
                    area : [ '550px', '430px' ], //宽高
                    content : $('#editDatasourceInfotype'),
                    btn : [ '保存', '关闭' ],
                    yes : function(index, layero) {
                        $("#editForm").submit();
                    },
                    cancel : function(index) {
                        FormUtil.resetForm("editForm");
                        editDatasourceInfotypeValidate.resetForm();
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

function delPage(id, name){
    if (Number(id)) {
        var msg = "确定删除信息类型【"+name+"】吗？";
        layer.confirm(msg, {
            icon : 3,
            title : "提示信息"
        }, function(index) {
            $.post(ctx.path + "/manage/datasource/infoType/delInfoType"+ ctx.bizSuffix,
                {
                    datasourceInfotypeId : id,
                    datasourceInfotypeName : name
                },
                function(result){
                    if (result.rs == 1) {
                        top.toastr.success("删除来源信息类型成功！");
                        $("#datasourceInfotypeList")[0].contentWindow.doSearch();
                    }
                }, "json");
            layer.close(index);
        });
    } else {
        top.toastr.error("数据异常！");
    }
}


function changDatasourceType(id, datasourceId, type){
    $("#datasourceId"+type).empty();
    $('#datasourceId'+type).append('<option value="">全部</option>');
    $("#datasourceIndustryId"+type).empty();
    $('#datasourceIndustryId'+type).append('<option value="">全部</option>');
    $("#datasourceWeburl"+type+"View").html('');
    $("#address"+type+"View").html('');
    if(id){
        $.get(ctx.path +"/manage/datasource/info/getDatasourceByTypeId"+ ctx.noAuthSuffix +"?datasourceTypeId=" + id, function(data){
            for(var j=0;j<data.length;j++){
                if(datasourceId && datasourceId == data[j].datasource_id){
                    $('#datasourceId'+type).append('<option selected value="'+data[j].datasource_id+'">'+data[j].datasource_webname+'</option>');
                }else{
                    $('#datasourceId'+type).append('<option value="'+data[j].datasource_id+'">'+data[j].datasource_webname+'</option>');
                }
            }
        }, "json");
    }
}

function changDatasource(id, datasourceIndustryId, type) {
    $("#datasourceIndustryId"+type).empty();
    $('#datasourceIndustryId'+type).append('<option value="">全部</option>');
    $("#datasourceWeburl"+type+"View").html('');
    $("#address"+type+"View").html('');
    if(id){
        $.get(ctx.path +"/manage/datasource/info/getDatasourceById"+ ctx.noAuthSuffix +"?datasourceId=" + id, function(data){
            let datasourceWeburl = data.datasourceWeburl;
            let provinceName = data.provinceName;
            let cityName = data.cityName;
            $("#datasourceWeburl"+type+"View").html(datasourceWeburl);
            $("#address"+type+"View").html(provinceName + " " + cityName);
        }, "json");
    }
}