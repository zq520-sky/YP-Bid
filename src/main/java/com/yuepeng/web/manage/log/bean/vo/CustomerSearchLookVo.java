package com.yuepeng.web.manage.log.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class CustomerSearchLookVo implements Serializable {
    /**
     * log.log_search_id,
     *         cust.cust_id,
     *         cust.cust_code,
     *         cust.mobile,
     *         cust.head_img,
     *         cust.nick_name,
     * 				cust.sex,
     * 				tsp.province_name,
     * 				tsc.city_name,
     *         log.search_word,
     *         log.search_time
     */
    private Integer logSearchId;//搜索日志id
    private Integer custId;//客户id
    private String custCode;//客户编号
    private String mobile;//客户手机号
    private String headImg;//客户头像
    private String nickName;//客户昵称
    private Integer sex;//客户性别
    private String provinceName;//客户所在省份
    private String cityName;//客户所在城市
    private String searchWord;// 搜索关键字
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date searchTime;//搜索时间

    public Integer getLogSearchId() {
        return logSearchId;
    }

    public void setLogSearchId(Integer logSearchId) {
        this.logSearchId = logSearchId;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getCustCode() {
        return custCode;
    }

    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getSearchWord() {
        return searchWord;
    }

    public void setSearchWord(String searchWord) {
        this.searchWord = searchWord;
    }

    public Date getSearchTime() {
        return searchTime;
    }

    public void setSearchTime(Date searchTime) {
        this.searchTime = searchTime;
    }
}
