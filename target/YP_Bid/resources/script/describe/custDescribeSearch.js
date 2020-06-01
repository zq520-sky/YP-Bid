var index = null;
var frameId = window.frameElement && window.frameElement.id || '';
var editValidate;

//打开查看页面
function viewPage(id) {
    if (Number(id)) {
        $.ajax({
            url: ctx.path + '/manage/subscribe/search/viewSubscribeSearch' + ctx.bizSuffix,
            async: true,
            dataType: 'json',
            type: 'POST',
            data: {subscribeSearchId: id},
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
                    area: ['450px', '500px'], //宽高
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