package com.yuepeng.module.vo;

import lombok.Data;

/**
 * 〈功能概述〉<br>
 *
 * @className: CustomInfoVo
 * @package: com.yuepeng.module.vo
 * @author: wzq
 * @date: 2020/5/26 17:05
 */
@Data
public class CustomInfoVo {

    private String token;

    private Integer custId;

    private String custCode;

    private String mobile;

    private String nickName;

    private Integer sex;

    private Integer provinceId;

    private Integer cityId;

    private Integer isMember;

    private String companyName;

    private String job;

    /** 是否订阅项目： 1-是， 0-否*/
    private Integer isSubscribed = 0;
}
