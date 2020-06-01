package com.yuepeng.utils;

import cn.hutool.core.util.StrUtil;
import com.yuepeng.dispose.exception.RRException;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @description:
 * @author: Administrator
 * @date: 2019-09-23 10:28
 */
@Slf4j
public class FileUtils {

    public static void downloadImage(String path, HttpServletResponse response) throws RRException {

        if (StrUtil.isNotEmpty(path)) {
            response.setHeader("pragma", "NO-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expries", 0);
            response.setContentType("image/jpeg;charset=utf-8");

            try (InputStream is = new FileInputStream(new File(path));
                 OutputStream out = response.getOutputStream();) {

                int length = 0;
                byte buffer[] = new byte[1024];
                while ((length = is.read(buffer)) != -1) {
                    out.write(buffer, 0, length);
                }
            } catch (Exception e) {
                log.error("FileUtils downloadImage error, file path: {}", path, e);
                throw new RRException("获取图片信息异常");
            }
        }
    }

    public static void downloadApk(String path, HttpServletResponse response) {

        if (StrUtil.isNotEmpty(path)) {
            response.setHeader("pragma", "NO-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expries", 0);
            response.setContentType("application/octet-stream;charset=UTF-8");
            response.setHeader("Content-disposition", "attachment; filename=app-release.apk");
            try (InputStream is = new FileInputStream(new File(path));
                 OutputStream out = response.getOutputStream();) {

                int length = 0;
                byte buffer[] = new byte[1024];
                while ((length = is.read(buffer)) != -1) {
                    out.write(buffer, 0, length);
                }

            } catch (Exception e) {
                throw new RRException("获取apk异常");
            }
        }
    }

}
