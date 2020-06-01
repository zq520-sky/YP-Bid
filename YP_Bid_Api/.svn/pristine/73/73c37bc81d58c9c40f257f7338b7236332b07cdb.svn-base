package com.yuepeng.dispose.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wzq
 */
@Data
@Configuration
@ConfigurationProperties(GlobalDefaultProperties.PREFIX)
public class GlobalDefaultProperties {

    public static final String PREFIX = "dispose";

    /**
     * 统一返回过滤包
     */
    private List<String> adviceFilterPackage = new ArrayList<>();

    /**
     * 统一返回过滤类
     */
    private List<String> adviceFilterClass = new ArrayList<>();

    GlobalDefaultProperties() {
        init();
    }

    private void init() {
        adviceFilterPackage.add("org.springframework");
        adviceFilterPackage.add("springfox.documentation.swagger");
    }

}
