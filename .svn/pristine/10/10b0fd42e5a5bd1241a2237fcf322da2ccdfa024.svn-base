<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ include file="/resources/platform/inc.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <script src="${ctx.path}/resources/js/common/DataForm.js?v=${ctx.version}"></script>
    <script src="${ctx.path}/resources/script/upload/cupload.js"></script>
    <script type="text/javascript">
        $(function () {
            initPage();
            setMemberValidate = $("#setSysForm").validate(
                {
                    rules: {
                        sysName : {
                            required : true
                        },
                        unitName : {
                            required : true
                        },
                        dayNumAdd : {
                            required : true,
                            negative : true
                        }
                    },
                    messages: {
                        sysName : {
                            required : "请输入系统名称！"
                        },
                        unitName : {
                            required : "请输入单位名称！"
                        },
                        dayNumAdd : {
                            required : "请输入新增数量！",
                            negative : "请输入正整数！"
                        }
                    },
                    submitHandler: function (form) {
                        $(form).ajaxSubmit(
                            {
                                //表单提交成功后的回调
                                success: function (responseText, statusText,
                                                   xhr, $form) {
                                    if (responseText.rs > 0) {
                                        top.toastr.success("设置系统信息成功！");
                                    }
                                }
                            });
                    }
                });
        });

        function initPage(){

            let img = '${data.sysLogo}';
            let imagePath = ctx.path + img;
            let cuploadCreate;
            if(img){
                cuploadCreate = new Cupload ({
                    ele	 : '#sysLogoAdd',
                    num  : 1,
                    name : 'file',
                    data : [imagePath],
                    download : false
                });
            }else{
                cuploadCreate = new Cupload({
                    ele: '#sysLogoAdd',
                    num: 1,
                    name: 'file'
                });
            }
        }

        let sysSetValidate;

        function showPic(){
            let src = $("#sysLogoAdd .cupload-image-box .cupload-image-preview")[0].src;
            previewImgs(src)
        }

        function previewImgs(src) {
            let exists = CheckImgExists(src);
            if(!exists){
                layer.alert("图片不存在！");
            }
            var img_infor = "<img  src='" + src + "' />";
            //捕获页
            index = top.layer.open({
                title: false,
                type: 1,
                shade: [0.1, '#fff'],
                shadeClose: true,
                area: [ '80%', '75%' ],
                content: img_infor,
                cancel: function () {
                }
            });
        }

    </script>
    <style type="text/css">
        #sys_set{
            width: 100%;
            height: 100%;
            padding-top:85px;
            padding-left:150px;
        }
    </style>
</head>
<body>

<!-- 系统设置 -->
<div id="sys_set">
    <form method="post" id="setSysForm" action="${ctx.path}/manage/system/info/addSys${ctx.bizSuffix}">
        <div class="add_list">
            <h5 hidden="true">
                <em style="color: red;">*</em>用户id：
            </h5>
            <div class="add_value" hidden="true">
                <input type="text" id="setId" name="setId" maxlength="22" class="inputtext" value="${data.setId}"/>
            </div>
            <h5>
                <em style="color: red;">*</em>系统名称：
            </h5>
            <div class="add_value">
                <input type="text" id="sysName" name="sysName" maxlength="22" class="inputtext" value="${data.sysName}"/>
            </div>
        </div>
        <div class="add_list">
            <h5>
                <em style="color: red;">*</em>单位名称：
            </h5>
            <div class="add_value">
                <input type="text" id="unitName" name="unitName" maxlength="22" class="inputtext" value="${data.unitName}"/>
            </div>
        </div>
        <div class="add_list">
            <h5>
                <em style="color: red;">*</em>系统LOGO：
            </h5>
            <div class="add_value" style="display: flex">
                <div id="sysLogoAdd"></div>
                <span onclick="showPic();">预览</span>
            </div>
        </div>
        <div class="add_list">
            <h5>
                <em style="color: red;">*</em>每日新增累加值：
            </h5>
            <div class="add_value">
                <input type="text" id="dayNumAdd" name="dayNumAdd" maxlength="22" class="inputtext"
                       value="${data.dayNumAdd}"/>
            </div>
        </div>
        <input type="submit" style="margin-left:320px;margin-top:15px;" value="确定">
    </form>
</div>
</body>
</html>
