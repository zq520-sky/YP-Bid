package com.yuepeng.web.manage.datasource.bean.vo;

import java.util.List;

/**
 * 〈功能概述〉<br>
 *
 * @className: DatasourceTreeVo
 * @package: com.yuepeng.web.manage.datasource.bean.vo
 * @author: wzq
 * @date: 2020/5/27 16:21
 */
public class DatasourceTreeVo {
    private Integer type;

    private Integer pId;

    private Integer id;

    private String name;

    private List<DatasourceTreeVo> children;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DatasourceTreeVo> getChildren() {
        return children;
    }

    public void setChildren(List<DatasourceTreeVo> children) {
        this.children = children;
    }
}
