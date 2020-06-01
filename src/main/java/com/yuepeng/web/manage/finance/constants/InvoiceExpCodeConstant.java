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
public class InvoiceExpCodeConstant extends ExpCodeConstant {

    public static final String ORDER_INVOICE_EDIT_COLUMN_ERROR = "17001";
    public static final String ORDER_INVOICE_EDIT_ID_ERROR = "17001";
    public static final String ORDER_INVOICE_EDIT_SET_ERROR = "17001";


    static {
        msgMap.put(ORDER_INVOICE_EDIT_COLUMN_ERROR, "编辑失败，请重新输入！");
        msgMap.put(ORDER_INVOICE_EDIT_ID_ERROR, "参数错误，请重新输入！");
        msgMap.put(ORDER_INVOICE_EDIT_SET_ERROR, "开票或取消开票操作失败，请联系管理员！");
    }

}
