package com.yuepeng.web.manage.dict.constant;

import com.yuepeng.platform.framework.exception.constant.ExpCodeConstant;
import org.springframework.stereotype.Component;

/**
 * @Description: 招标信息类型Exp
 * @Author: ZhongShengbin
 * @Date: 2020/05/21 09:39
 * Copyright (c) 2019, Samton. All rights reserved
 */
@Component
public class InfoTypeExpCodeConstant extends ExpCodeConstant {

    public static final String INFO_EDIT_COLUMN_ERROR = "13001";
    public static final String INFO_EDIT_ID_ERROR = "13002";
    public static final String INFO_EDIT_SET_ERROR = "13005";

    public static final String MEMBER_SET_ERROR = "13006";
    public static final String MEMBER_EDIT_ERROR = "13007";




    static {
        msgMap.put(INFO_EDIT_COLUMN_ERROR, "编辑失败，请重新输入！");
        msgMap.put(INFO_EDIT_ID_ERROR, "参数错误，请重新输入！");
        msgMap.put(INFO_EDIT_SET_ERROR, "禁用或启用操作失败，请联系管理员！");
        msgMap.put(MEMBER_SET_ERROR, "设置会员，请联系管理员！");
        msgMap.put(MEMBER_EDIT_ERROR, "编辑失败，请联系管理员！");
    }
}
