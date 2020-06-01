var index = null;
var frameId = window.frameElement && window.frameElement.id || '';
var setMemberValidate;
//执行查询
function doSearch() {
	$("#pageForm").submit();
	top.progressbar(frameId);
}


$(function() {
    //校验新增表单
    setMemberValidate = $("#setMemberForm").validate(
        {
            rules: {
                memberType : {
                    required : true
                },
                useStartTime : {
                    required : true
                },
                useEndTime : {
                    required : true
                }
            },
            messages: {
                memberType : {
                    required : "请选择会员类型！"
                },
                useStartTime : {
                    required : "请选择会员开始时间！"
                },
                useEndTime : {
                    required : "请选择会员结束时间！"
                }
            },
            submitHandler: function (form) {
                $(form).ajaxSubmit(
                    {
                        //表单提交成功后的回调
                        success: function (responseText, statusText,
                                           xhr, $form) {
                            if (responseText.rs > 0) {
                                top.toastr.success("设置会员成功！");
                                FormUtil.resetForm("setMemberForm");
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
            url : ctx.path + '/manage/customer/info/viewCust' + ctx.bizSuffix,
            async : true,
            dataType : 'json',
            type : 'POST',
            data : {custId : id},
            success : function(data) {
                if (data.rs == -1) {
                    top.toastr.error("获取数据信息失败");
                    return false;
                }
                //返回的map对象参数
                let dataRet = data.data;
                console.log(JSON.stringify(dataRet))
                let imagePath = ctx.path + dataRet['headImg'];
                let address = dataRet['provinceName'] + " " + dataRet['cityName'];
                let isMember = dataRet['isMember'] == 0 ? '否' : '是';
                let isForbid = dataRet['isForbid'] == 0 ? '正常' : '已禁用';
                $("#viewForm #addressView").html(address);
                $("#viewForm #isMemberView").html(isMember);
                $("#viewForm #isForbidView").html(isForbid);
                //初始化，显示图片
                var cuploadUpdate = new Cupload ({
                    ele	 : '#headImgView',
                    num  : 1,
                    name : 'file',
                    data : [imagePath],
                    download : true,
                    width: 80,
                    height: 80
                });
                for (var key in dataRet) {
                    if(key === 'headImg' || key === 'isMember' || key === 'isForbid'){
                        continue
                    }
                    //对页面属性赋值（要求页面id与map的key值保持一致）
                    $("#viewForm #"+ key + "View").html(dataRet[key]);
                }
                parentIndex = layer.open({
                    title : '查看客户信息',
                    type : 1,
                    area : [ '60%', '80%' ], //宽高
                    content : $('#viewCustomer'),
                    btn : [ '关闭' ],
                    yes: function(index){
                        $('#headImgView').empty();
                        layer.close(index);
                    },
                    cancel : function(index) {
                        $('#headImgView').empty();
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
function setPage(id, flag, name) {
    //操作禁用和启用的时候正好相反
    var oprStr = flag == 0 ? "禁用" : "启用";
    var opr = flag == 0 ? 1 : 0;
    if (Number(id)) {
        var msg = "确定"+oprStr+"客户【" + name + "】吗？";
        layer.confirm(msg, {
            icon : 3,
            title : "提示信息"
        }, function(index) {
            $.post(ctx.path + "/manage/customer/info/disAndEnableCust"+ ctx.bizSuffix,
                {
                    custId : id,
                    isForbid : opr,
                    custCode : name
                },
                function(result){
                    if (result.rs == 1) {
                        top.toastr.success(oprStr+"客户【" + name + "】成功！");
                        doSearch();
                    }
                }, "json");
            layer.close(index);
        });
    } else {
        top.toastr.error("数据异常！");
    }
}

//设置会员
function setMemberPage(id){
    if (Number(id)) {
        $.ajax({
            url : ctx.path + '/manage/customer/info/viewCust' + ctx.bizSuffix,
            async : true,
            dataType : 'json',
            type : 'POST',
            data : {custId : id},
            success : function(data) {
                if (data.rs == -1) {
                    top.toastr.error("获取数据信息失败");
                    return false;
                }
                //返回的map对象参数
                let dataRet = data.data;
                console.log(JSON.stringify(dataRet))
                let custId = dataRet['custId'];
                let custCode = dataRet['custCode'];
                let mobile = dataRet['mobile'];
                let memberType = dataRet['memberType'];
                let useStartTime = dataRet['useStartTime'];
                let useEndTime = dataRet['useEndTime'];
                let roleProvinceIds = dataRet['roleProvinceIds'];
                $("#memberTypeEdit").find("option[value='"+memberType+"']").attr("selected",'selected');
                $("#setMemberForm #custIdEdit").val(custId);
                $("#setMemberForm #custCodeEdit").html(custCode);
                $("#setMemberForm #custCodeEdit2").val(custCode);
                $("#setMemberForm #mobileEdit").html(mobile);
                $("#setMemberForm #useStartTimeEdit").val(useStartTime);
                $("#setMemberForm #useEndTimeEdit").val(useEndTime);
                initProvinceSelect(roleProvinceIds);

                if(memberType != 1){
                    $("#roleAreas").addClass('hideTr');
                }

                parentIndex = layer.open({
                    title : '设置会员',
                    type : 1,
                    area : [ '50%', '80%' ], //宽高
                    content : $('#setMember'),
                    btn : [ '确定', '取消' ],
                    yes : function(index, layero) {
                        setProvinceData();
                        $("#setMemberForm").submit();
                    },
                    close: function(index, layero){
                        $("#roleProvinceNameSelect").empty();
                        layer.close(index);
                    },
                    cancel : function(index) {
                        $("#roleProvinceNameSelect").empty();
                        FormUtil.resetForm("setMemberForm");
                        setMemberValidate.resetForm();
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



let select;
function initProvinceSelect(roleProvinceIds){
    //初始化选中项和下拉选
    let pidsArr = [];
    if(roleProvinceIds != '' && roleProvinceIds != undefined){
        let ids = roleProvinceIds.split(",");
        ids.forEach(function(data,index,arr){
            pidsArr.push(+data);
        });
    }
    $.get(ctx.path + '/platform/common/getProvinceSelect' + ctx.noAuthSuffix,function(data){
        if(select == undefined || select == ''){
            select = new verjs_select();
        }
        select.render({
            elem: "#roleProvinceNameSelect",
            data: data,
            init_value: pidsArr,
            body_height: '140',
            width: "234px",
            checkbox: true,
            zIndex: '99',
            name: "roleProvinceNames"
        });
    });
}

//当为省级VIP时，提交时将多选的值填充到对应input标签
function setProvinceData(){
    let val = $("#memberTypeEdit").val();
    if(val == 1){
        let ids = new Array();
        let names = new Array();
        let provinces = select.get_value('roleProvinceNameSelect');
        for(let i=0,len=provinces.length; i<len; i++){
            let pdata = provinces[i];
            ids.push(pdata['id']);
            names.push(pdata['name']);
        }
        $("#roleProvinceIdsPut").val(ids)
        $("#roleProvinceNamesPut").val(names)
    }
}


function changeVipType(id){
    if(id == 1){
        $("#roleAreas").removeClass('hideTr');
    }else{
        $("#roleAreas").addClass('hideTr');
    }
}