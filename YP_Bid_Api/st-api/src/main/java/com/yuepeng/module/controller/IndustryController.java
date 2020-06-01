package com.yuepeng.module.controller;


import com.yuepeng.module.service.IIndustryService;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

/**
 * 招标行业大类表：
 * <p>
 * 工程建设
 * 医疗卫生
 * 环保绿化
 * 信息建设
 * 办公文教
 * 商业服务
 * 机械设备
 * 服装家电
 * 农林牧渔
 * 能源化工
 * 智能制造
 * 资源交易
 * 政府采购
 * 土地矿产
 * 产权交易
 * PPP项目
 * 其他(Industry)表控制层
 *
 * @author wzq
 * @since 2020-05-30 15:11:04
 */
@Slf4j
@RestController
@RequestMapping("/api/industry")
@Api(value = "招标行业大类", tags = "招标行业大类")
public class IndustryController {
    /**
     * 服务对象
     */
    @Resource
    private IIndustryService industryService;

}