package com.yuepeng.module.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuepeng.module.entity.CustomerEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 文件
 * @Author fujh
 * @Date 2019/9/6
 */
public interface FileService extends IService<CustomerEntity> {

    /**
     * 头像上传
     * @author: wuzhiqiang
     * @date: 2020/4/7
     * @param imageFile:
     * @return: java.lang.String
     */
    String upload(MultipartFile imageFile);

    /**
     * 多文件上传
     * @author: wuzhiqiang
     * @date: 2020/4/7
     * @param files:
     * @return: java.util.List<java.lang.String>
     */
    List<String> upload(MultipartFile[] files);

    /**
     * 移除旧图片
     * @author: wuzhiqiang
     * @date: 2020/4/7
     * @param oldUrl:
     * @return: void
     */
    void moveBak(String oldUrl);

    /**
     * 图片下载
     * @author: wuzhiqiang
     * @date: 2020/4/7
     * @param imageurl:
     * @return: java.lang.String
     */
    String headDownload(String imageurl);

    /**
     * 图片上传
     * @author: wuzhiqiang
     * @date: 2020/4/7
     * @param imageFile:
     * @param typePath: 按不同类型存不同目录，如头像， 则传"/head"
     * @return: java.lang.String
     */
    String upload(MultipartFile imageFile, String typePath);
}
