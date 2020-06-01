package com.yuepeng.platform.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 */
@Component
public class CommonTask {

    //@Resource
    //private ICustTaskService iCustTaskService;

    private static final Logger log = LoggerFactory.getLogger(CommonTask.class);

    //每天0点5分触发一次执行
    @Scheduled(cron = "0 5 0 * * *")
    public void clearCallCenter(){
        log.info("========================== 定时分配任务autoAllocateTask开始 ======================");
        try {
            //Integer record = iCustTaskService.autoAllocateTask(2);
            //log.info("========================== 定时分配任务autoAllocateTask结束{} ====================", record);
        } catch (Exception e) {
            log.error("========================== 定时分配任务autoAllocateTask失败！ ====================！", e);
        }
    }
}