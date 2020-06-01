var index = null;
var frameId = window.frameElement && window.frameElement.id || '';
var advertiseAddValidate, advertiseEditdValidate;

//执行查询
function doSearch() {
	$("#pageForm").submit();
	top.progressbar(frameId);
}


//打开查看页面
function viewPage(id) {
	if(Number(id)){
		$.ajax({
			url : ctx.path + '/manage/log/queryCstMsgByLogLoginId.do',
			async : true,
			dataType : 'json',
			type : 'POST',
			data : {logLoginId : id},
			success : function(data) {
				if (!data.flag) {
					top.toastr.error("获取数据信息失败");
					return false;
				}
				//返回的map对象参数
				var dataRet = data.data;
				for (var key in dataRet) {
					//对页面属性赋值（要求页面id与map的key值保持一致）
					if(key == "sex"){
						var sex = dataRet[key]== 0 ? '未知' : '';
						sex = dataRet[key]== 1 ? '男' : '女';
						$("#viewForm #"+ key + "View").html(sex);
					}else if(key == "loginType"){
						var loginType = dataRet[key]== 1 ? '密码登陆' : '验证码登陆';
						$("#viewForm #"+ key + "View").html(loginType);
					}else if(key == "headImg"){
						var imgEl = "";
						if(key == null || dataRet[key] == ""){
							imgEl = "暂无头像"
						}else{
							imgEl = "<img src='"+dataRet[key]+"'/>"
						}
						$("#viewForm #"+ key + "View").html(imgEl);
					}else {
						$("#viewForm #"+ key + "View").html(dataRet[key]);
					}

				}
				var nickNameShow = dataRet['nickName'];
				parentIndex = layer.open({
					title : "查看『"+nickNameShow+"』客户登录日志",
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
	}
}




