package com.yuepeng.web.manage.project.constants;

import com.yuepeng.platform.framework.exception.constant.ExpCodeConstant;
import org.springframework.stereotype.Component;

/**
 * 〈功能概述〉<br>
 *
 * @className: ProjectExpCodeConstant
 * @package: com.yuepeng.web.manage.finance.constants
 * @author: wzq
 * @date: 2020/5/18 14:43
 */
@Component
public class ProjectExpCodeConstant extends ExpCodeConstant {

    public static final String PROJECT_EDIT_COLUMN_ERROR = "16001";
    public static final String PROJECT_EDIT_ID_ERROR = "16002";
    public static final String PROJECT_DEL_ERROR = "16004";

    public static final String PROJECT_COMPANY_EDIT_COLUMN_ERROR = "16011";
    public static final String PROJECT_COMPANY_EDIT_ID_ERROR = "16012";
    public static final String PROJECT_COMPANY_DEL_ERROR = "16014";
    public static final String PROJECT_COMPANY_DEL_NOT_ALLOW = "16016";
    public static final String PROJECT_COMPANY_ADD_ERROR = "16015";

    static {
        msgMap.put(PROJECT_EDIT_COLUMN_ERROR, "编辑失败，请重新输入！");
        msgMap.put(PROJECT_EDIT_ID_ERROR, "参数错误，请重新输入！");
        msgMap.put(PROJECT_DEL_ERROR, "删除失败，请联系管理员！");
        msgMap.put(PROJECT_COMPANY_EDIT_COLUMN_ERROR, "编辑失败，请重新输入！");
        msgMap.put(PROJECT_COMPANY_EDIT_ID_ERROR, "参数错误，请重新输入！");
        msgMap.put(PROJECT_COMPANY_DEL_ERROR, "删除失败，请联系管理员！");
        msgMap.put(PROJECT_COMPANY_DEL_NOT_ALLOW, "该单位有招标项目，无法删除！");
        msgMap.put(PROJECT_COMPANY_ADD_ERROR, "添加失败，请联系管理员！");
    }

}
