var index = null;
var frameId = window.frameElement && window.frameElement.id || '';
//执行查询
function doSearch() {
    $("#pageForm").submit();
    top.progressbar(frameId);
}

//打开查看页面
function viewPage(id) {
    if (Number(id)) {
        $.ajax({
            url : ctx.path + '/manage/finance/order/viewOrder' + ctx.bizSuffix,
            async : true,
            dataType : 'json',
            type : 'POST',
            data : {orderId : id},
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
                parentIndex = layer.open({
                    title : '查看订单信息',
                    type : 1,
                    area : [ '500px', '450px' ], //宽高
                    content : $('#viewOrder'),
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


