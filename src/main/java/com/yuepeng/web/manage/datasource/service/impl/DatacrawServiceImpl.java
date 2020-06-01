package com.yuepeng.web.manage.datasource.service.impl;

import com.yuepeng.platform.common.service.impl.SuperServiceIntegerImpl;
import com.yuepeng.web.manage.datasource.bean.entity.TDatacrawlerService;
import com.yuepeng.web.manage.datasource.dao.TDatacrawlerServiceMapper;
import com.yuepeng.web.manage.datasource.service.IDatacrawlerService;
import com.yuepeng.web.manage.datasource.service.IDatacrawlerSetService;
import org.springframework.stereotype.Service;

/**
 * @Description: 客户爬取服务类
 * @Author: ZhongShengbin
 * @Date: 2020/05/29 10:02
 * Copyright (c) 2019, Samton. All rights reserved
 */
@Service
public class DatacrawServiceImpl extends SuperServiceIntegerImpl<TDatacrawlerServiceMapper, TDatacrawlerService> implements IDatacrawlerService {
}
