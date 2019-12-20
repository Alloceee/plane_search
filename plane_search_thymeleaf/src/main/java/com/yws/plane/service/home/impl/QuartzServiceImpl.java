package com.yws.plane.service.home.impl;

import com.yws.plane.entity.SchedulerJob;
import com.yws.plane.service.home.QuartzService;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class QuartzServiceImpl implements QuartzService {

    @Autowired
    @Qualifier("scheduler")
    private Scheduler scheduler;

    @SuppressWarnings("unchecked")
    @Override
    public void addTimerJob(SchedulerJob job) {
        try {
            JobDetail jobDetail = JobBuilder
                    .newJob((Class<? extends Job>) Class.forName(job.getClassname()))
                    // 指定执行类
                    .withIdentity(job.getJobName(), job.getJobGroup())
                    // 指定name和group
                    .requestRecovery().withDescription(job.getDescription())
                    .build();
            // 创建表达式调度构建器
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder
                    .cronSchedule(job.getCronExpression());
            // 创建触发器
            CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                    .withIdentity(job.getTriggerName(), job.getTriggerGroup())
                    .withSchedule(cronScheduleBuilder).build();
            scheduler.scheduleJob(jobDetail, cronTrigger);
            scheduler.start();// 触发器并不会立刻触发
            System.out.println("==================================创建Job成功！==================================");
        } catch (ClassNotFoundException | SchedulerException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    @Override
    public void runTimerJob(SchedulerJob job) {
        try {
            scheduler.triggerJob(JobKey.jobKey(job.getJobName(),
                    job.getJobGroup()));
            System.out.println("==================================Job执行成功！==================================");
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTimerJob(SchedulerJob job) {
        try {
            TriggerKey triggerKey = new TriggerKey(job.getTriggerName(),
                    job.getTriggerGroup());
            CronTrigger cronTrigger = (CronTrigger) scheduler
                    .getTrigger(triggerKey);
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder
                    .cronSchedule(job.getCronExpression());
            // 重新构件表达式
            CronTrigger trigger = cronTrigger.getTriggerBuilder()
                    .withIdentity(triggerKey).withSchedule(cronScheduleBuilder)
                    .build();
            scheduler.rescheduleJob(triggerKey, trigger);
            System.out.println("==================================更新Job成功！==================================");
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void pauseTimerJob(SchedulerJob job) {
        try {
            scheduler.pauseJob(JobKey.jobKey(job.getJobName(),
                    job.getJobGroup()));
            System.out.println("==================================暂停Job！==================================");
        } catch (SchedulerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void resumeTimerJob(SchedulerJob job) {
        try {
            scheduler.resumeJob(JobKey.jobKey(job.getJobName(),
                    job.getJobGroup()));
            System.out.println("==================================重启Job！==================================");
        } catch (SchedulerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTimerJob(SchedulerJob job) {
        try {
            scheduler.deleteJob(JobKey.jobKey(job.getJobName(),
                    job.getJobGroup()));
            System.out.println("==================================删除Job！==================================");
        } catch (SchedulerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public String selectTimerJob(SchedulerJob job) {
        TriggerKey triggerKey = new TriggerKey(job.getTriggerName(),
                job.getTriggerGroup());
        try {
            CronTrigger cronTrigger = (CronTrigger) scheduler
                    .getTrigger(triggerKey);
            return "expression:" + cronTrigger.getCronExpression()
                    + ",description:" + cronTrigger.getDescription()
                    + ",state:" + scheduler.getTriggerState(triggerKey);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return null;
    }
}
