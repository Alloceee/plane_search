package com.yws.plane.service;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class QuartzTask {
    @Autowired
    private Scheduler scheduler;

    /**
     * 业务逻辑
     */
    public void reptilian() {
        System.out.println("执行业务处理逻辑：" + new Date());
    }

    @RequestMapping("/start")
    @ResponseBody
    public String start() throws Exception {
        System.out.println( scheduler );
        JobKey key = new JobKey("job1");
        scheduler.resumeJob(key);
        return "start";
    }

    @RequestMapping("/trigger")
    @ResponseBody
    public String trigger() throws Exception {
        // 获取任务
        JobKey jobKey = new JobKey("job1");
        // 获取 jobDetail
        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
        // 生成 trigger
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withSchedule(CronScheduleBuilder.cronSchedule("0/1 * * * * ?"))
                .build();
        // 删除任务，不删除会报错。报任务已存在
        scheduler.deleteJob(jobKey);
        // 启动任务
        System.out.println(jobDetail);
        scheduler.scheduleJob(jobDetail, trigger);
        return "trigger";
    }

    @RequestMapping("/pause")
    @ResponseBody
    public String pause() throws Exception {
        System.out.println( scheduler );
        JobKey key = new JobKey("job1");
        scheduler.pauseJob(key);
        return "pause";
    }
}
