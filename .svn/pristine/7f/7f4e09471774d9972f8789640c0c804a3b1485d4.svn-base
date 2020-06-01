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
            url : ctx.path + '/manage/customer/keyword/viewKeyword' + ctx.bizSuffix,
            async : true,
            dataType : 'json',
            type : 'POST',
            data : {keywordCollectId : id},
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
                    title : '查看客户项目关键词信息',
                    type : 1,
                    area : [ '55%', '80%' ], //宽高
                    content : $('#viewKeyword'),
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