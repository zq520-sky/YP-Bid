package com.yuepeng.module.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuepeng.module.mapper.SearchHotwordDao;
import com.yuepeng.module.entity.SearchHotwordEntity;
import com.yuepeng.module.service.ISearchHotwordService;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

/**
 * 项目搜索热词表(SearchHotword)表服务实现类
 *
 * @author wzq
 * @since 2020-05-30 15:11:44
 */
@Slf4j
@Service("searchHotwordService")
public class SearchHotwordServiceImpl extends ServiceImpl<SearchHotwordDao, SearchHotwordEntity> implements ISearchHotwordService {

}