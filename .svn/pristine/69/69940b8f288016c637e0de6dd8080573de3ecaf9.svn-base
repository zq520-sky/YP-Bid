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
	$.ajax({
		url : ctx.path + '/manage/log/queryCustSearchByCustId.do',
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
			var dataRet = data.data;
			for (var key in dataRet) {
				//对页面属性赋值（要求页面id与map的key值保持一致）
				if(key == "sex"){
					var sex = dataRet[key]== 0 ? '未知' : '';
					sex = dataRet[key]== 1 ? '男' : '女';
					$("#viewForm #"+ key + "View").html(sex);
				}else if(key == "isMember"){
					var isMember = dataRet[key]== 0 ? '否' : '是';
					$("#viewForm #"+ key + "View").html(isMember);
				}else if(key == "isForbid"){
					var isForbid = dataRet[key]== 0 ? '是' : '否';
					$("#viewForm #"+ key + "View").html(isForbid);
				}else if(key == "headImg"){
					var imgEl = "<img src='"+key+"'/>"
					$("#viewForm #"+ key + "View").html(imgEl);
				}else if(key == "registerDate"){
					/*<fmt:formatDate value="${loginLog.loginDate}" pattern="yyyy-MM-dd HH:mm:ss" />*/
					var time = dataRet[key];
					console.log("time:"+time);
					var registerDate = "<fmt:formatDate value='"+time+"' pattern='yyyy-MM-dd HH:mm:ss' />";
					$("#viewForm #"+ key + "View").html(registerDate);
				}else {
					$("#viewForm #"+ key + "View").html(dataRet[key]);
				}

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
}




