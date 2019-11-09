package com.yws.plane.config;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Spring Schedule 这是spring自带的任务框架 优点就是配置简单，依赖少，缺点就是
 * 同一个task，如果前一个还没跑完后面一个就不会触发，不同的task也不能同时运行。
 * 因为scheduler的默认线程数为1，配置pool-size为2的话，会导致同一个task前一个还没跑完后面又被触发的问题，不支持集群等。
 */
@Component
@EnableScheduling
public class SpringScheduleTask {

    /**
     *  每分钟执行一次
     */
    @Scheduled(cron = "0 0/1 * * * ?")
    public void reptilian(){
        System.out.println("spring 执行调度任务："+new Date());
    }

}
