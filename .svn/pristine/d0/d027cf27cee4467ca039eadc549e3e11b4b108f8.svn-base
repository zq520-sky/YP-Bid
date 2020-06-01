var index = null;
var frameId = window.frameElement && window.frameElement.id || '';
var editMemberValidate;
//执行查询
function doSearch() {
	$("#pageForm").submit();
	top.progressbar(frameId);
}


$(function() {
    //校验新增表单
    editMemberValidate = $("#editMemberForm").validate(
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
                                top.toastr.success("编辑会员成功！");
                                FormUtil.resetForm("editMemberForm");
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
            url : ctx.path + '/manage/customer/member/viewMember' + ctx.bizSuffix,
            async : true,
            dataType : 'json',
            type : 'POST',
            data : {memberId : id},
            success : function(data) {
                if (data.rs == -1) {
                    top.toastr.error("获取数据信息失败");
                    return false;
                }
                //返回的map对象参数
                let dataRet = data.data;
                let address = dataRet['provinceName'] + " " + dataRet['cityName'];
                let roleProvinceNames = dataRet['roleProvinceNames'];
                $("#viewForm #addressView").html(address);
                for (var key in dataRet) {
                    //对页面属性赋值（要求页面id与map的key值保持一致）
                    $("#viewForm #"+ key + "View").html(dataRet[key]);
                }
                if(roleProvinceNames == '' || roleProvinceNames == undefined){
                    $("#viewForm #roleProvinceNamesView").html("全国");
                }
                parentIndex = layer.open({
                    title : '查看会员信息',
                    type : 1,
                    area : [ '55%', '80%' ], //宽高
                    content : $('#viewMember'),
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
            url : ctx.path + '/manage/customer/member/viewMember' + ctx.bizSuffix,
            async : true,
            dataType : 'json',
            type : 'POST',
            data : {memberId : id},
            success : function(data) {
                if (data.rs == -1) {
                    top.toastr.error("获取数据信息失败");
                    return false;
                }
                //返回的map对象参数
                let dataRet = data.data;
                console.log(JSON.stringify(dataRet))
                //输入框赋值
                let memberId = dataRet['memberId'];
                let custId = dataRet['custId'];
                let useStartTime = dataRet['useStartTime']
                let useEndTime = dataRet['useEndTime']
                let address = dataRet['provinceName'] + " " + dataRet['cityName'];
                let roleProvinceNames = dataRet['roleProvinceNames'];
                let roleProvinceIds = dataRet['roleProvinceIds'];
                let memberType = dataRet['memberType'];
                $("#editMemberForm #memberIdPut").val(memberId)
                $("#editMemberForm #custIdPut").val(custId)
                $("#editMemberForm #useStartTimeEdit").val(useStartTime)
                $("#editMemberForm #useEndTimeEdit").val(useEndTime)
                $("#editMemberForm #addressEdit").html(address);
                if(roleProvinceNames == '' || roleProvinceNames == undefined){
                    $("#editMemberForm #roleProvinceNamesEdit").html("全国");
                }
                if(memberType !== 1){
                    $("#roleProvinceNameSelectTd").addClass('hideTr');
                    $("#roleProvinceNamesEdit").removeClass('hideTr');
                }
                $("#memberTypeEdit").find("option[value='"+memberType+"']").attr("selected",'selected');
                initProvinceSelect(roleProvinceIds);
                //文本显示赋值
                for (var key in dataRet) {
                    if(key === 'roleProvinceNames' || key === 'useStartTime' || key === 'useEndTime' || key === 'memberType'){
                        continue;
                    }
                    //对页面属性赋值（要求页面id与map的key值保持一致）
                    $("#editMemberForm #"+ key + "Edit").html(dataRet[key]);
                }
                parentIndex = layer.open({
                    title : '编辑会员信息',
                    type : 1,
                    area : [ '70%', '95%' ], //宽高
                    content : $('#editMember'),
                    btn : [ '确定', '取消' ],
                    yes : function(index, layero) {
                        setProvinceData();
                        $("#editMemberForm").submit();
                    },
                    close: function(index, layero){
                        $("#roleProvinceNameSelect").empty();
                        layer.close(index);
                    },
                    cancel : function(index) {
                        $("#roleProvinceNameSelect").empty();
                        FormUtil.resetForm("editMemberForm");
                        editMemberValidate.resetForm();
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
            body_height: 140,
            width: "164px",
            checkbox: true,
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
    if(id == 0 && id != '' && id != undefined){
        $(".roleTh").addClass('hideTr');
        $(".roleHi").removeClass('hideTr');
        $("#roleProvinceNamesEdit").addClass('hideTr');
        $("#roleProvinceNameSelectTd").addClass('hideTr');
    }else if(id == 1){
        $(".roleTh").removeClass('hideTr');
        $(".roleHi").addClass('hideTr');
        $("#roleProvinceNameSelectTd").removeClass('hideTr');
        $("#roleProvinceNamesEdit").addClass('hideTr');
    }else{
        $(".roleTh").removeClass('hideTr');
        $(".roleHi").addClass('hideTr');
        $("#roleProvinceNameSelectTd").addClass('hideTr');
        $("#roleProvinceNamesEdit").removeClass('hideTr');
        $("#roleProvinceNamesEdit").html('全国');
    }
}