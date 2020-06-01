package com.yuepeng.module.service.impl;


import cn.hutool.http.HttpUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuepeng.dispose.exception.RRException;
import com.yuepeng.module.entity.CustomerEntity;
import com.yuepeng.module.mapper.CustomerDao;
import com.yuepeng.module.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author fujh
 * @Date 2019/9/6
 */
@Service("fileService")
public class FileServiceImpl extends ServiceImpl<CustomerDao, CustomerEntity> implements FileService {
    /**
     * 头像上传路径
     */
    @Value("${file.pic.uploadPath}")
    private String picUploadPath;

    /**
     * 头像历史路径
     */
    @Value("${file.pic.oldPath}")
    private String picOldPath;

    /**
     * 头像大小限制
     */
    @Value("${file.pic.maxSize}")
    private String picMaxSize;

    /**
     * 下载头像
     * @param imageurl
     * @return
     */
    @Override
    public String headDownload(String imageurl) {
        String fileName = UUID.randomUUID().toString().replaceAll("-", "")+".jpg";
        File file = prefile(fileName, picUploadPath);
        HttpUtil.downloadFile(imageurl,file,1000);
        return file.getAbsolutePath();
    }

    @Override
    public String upload(MultipartFile imageFile, String typePath) {
        typePath = typePath == null ? "" : typePath;
        if (imageFile.isEmpty()) {
            throw new RRException("请选择图片！");
        }
        //上传文件的大小, 单位为字节
        Long len = imageFile.getSize();
        if (len > Long.valueOf(picMaxSize)) {
            throw new RRException("图片不能超过5M！");
        }
        String accessUrl=up(imageFile, picUploadPath + File.separator + typePath);
        return accessUrl;
    }

    /**
     * 上传头像
     *
     * @param imageFile
     * @return
     */
    @Override
    public String upload(MultipartFile imageFile) {
        return up(imageFile, null);
    }

    /**
     * 上传图片文件
     *
     * @param files
     * @return
     */
    @Override
    public List<String> upload(MultipartFile[] files) {
        List<String> list = new ArrayList<>();
        if (files == null) {
            return list;
        }
        for(MultipartFile file :files){
            String accessUrl=up(file,picUploadPath);
            list.add(accessUrl);
        }
        return list;
    }

    /**
     * 清理图片文件
     *
     * @param oldUrl
     */
    @Override
    public void moveBak(String oldUrl) {
        String filepath = picOldPath.endsWith(File.separator) ? picOldPath : picOldPath + File.separator;
        File filePath = new File(filepath);
        if (!filePath.exists() && !filePath.isDirectory()) {
            filePath.mkdirs();
        }
        File file = new File(oldUrl);
        if (file != null) {
            file.renameTo(new File(filepath, file.getName()));
        }

    }

    private String up(MultipartFile file, String path){
        String filename = file.getOriginalFilename();
        File targetFile = prefile(filename,path);
        try {
            file.transferTo(targetFile);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RRException("上传异常！");
        }
        return targetFile.getAbsolutePath();
    }


    private File prefile(String filename,String path){
        String ext = null;
        if (filename.contains(".")) {
            ext = filename.substring(filename.lastIndexOf("."));
        } else {
            ext = "";
        }
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String nfileName = uuid + ext;

        String filepath = path.endsWith(File.separator) ? path : path + File.separator;
        File filePath = new File(filepath);
        if (!filePath.exists() && !filePath.isDirectory()) {
            filePath.mkdirs();
        }
        String accessUrl = filepath+ nfileName;
        File targetFile = new File(accessUrl);
        if (targetFile.exists()) {
            targetFile.delete();
        }
        return targetFile;
    }
}
