package com.yuepeng.web.manage.finance.constants;

import com.yuepeng.platform.framework.exception.constant.ExpCodeConstant;
import org.springframework.stereotype.Component;

/**
 * 〈功能概述〉<br>
 *
 * @className: MemberPriceExpCodeConstant
 * @package: com.yuepeng.web.manage.finance.constants
 * @author: wzq
 * @date: 2020/5/18 14:43
 */
@Component
public class MemberPriceExpCodeConstant extends ExpCodeConstant {

    public static final String PRICE_EDIT_COLUMN_ERROR = "14001";
    public static final String PRICE_EDIT_ID_ERROR = "14002";
    public static final String PRICE_EDIT_SET_ERROR = "14003";

    public static final String PRICE_DEL_ERROR = "14004";


    static {
        msgMap.put(PRICE_EDIT_COLUMN_ERROR, "编辑失败，请重新输入！");
        msgMap.put(PRICE_EDIT_ID_ERROR, "参数错误，请重新输入！");
        msgMap.put(PRICE_EDIT_SET_ERROR, "禁用或启用操作失败，请联系管理员！");
        msgMap.put(PRICE_DEL_ERROR, "删除失败，请联系管理员！");
    }

}
