package com.yuepeng.wx.model;

import com.yuepeng.model.BaseModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * @ClassName: BatchQueryCommentModel
 * @Description: 拉取用户评价信息model
 * @Author: wuzhiqiang
 * @Date: 2020-03-04 14:21

 **/
@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BatchQueryCommentModel extends BaseModel {
    private String appid;
    private String mch_id;
    private String nonce_str;
    private String sign;
    private String sign_type;
    private String begin_time;
    private String end_time;
    private String offset;
    private String limit;
}