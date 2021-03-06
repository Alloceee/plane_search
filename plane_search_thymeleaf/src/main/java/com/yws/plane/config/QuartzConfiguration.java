package com.yws.plane.config;

import com.yws.plane.service.QuartzTask;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;


/**
 * @author AlmostLover
 */
//@Configuration
public class QuartzConfiguration {
    /**
     *  配置任务
     * @param quartzTask QuartzTask为需要执行的任务
     * @return
     */
//    @Bean(name = "reptilianJob")
    public MethodInvokingJobDetailFactoryBean detailFactoryBean(QuartzTask quartzTask) {
        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
        // 是否并发执行
        jobDetail.setConcurrent(true);
        // 设置任务的名字
        jobDetail.setName("reptilianJob");
        // 设置任务的分组，在多任务的时候使用
        jobDetail.setGroup("reptilianJobGroup");
        // 需要执行的对象
        jobDetail.setTargetObject(quartzTask);
        /*
         * TODO  非常重要
         * 执行QuartzTask类中的需要执行方法
         */
        jobDetail.setTargetMethod("reptilian");
        return jobDetail;
    }

    /**
     * 定时触发器
     * @param reptilianJob 任务
     * @return
     */
//    @Bean(name = "jobTrigger")
    public CronTriggerFactoryBean cronJobTrigger(JobDetail reptilianJob){
        CronTriggerFactoryBean triggers = new CronTriggerFactoryBean();
        triggers.setJobDetail(reptilianJob);
        //cron表达式，每1分钟执行一次
        triggers.setCronExpression("0 0/1 * * * ?");
        triggers.setName("reptilianTrigger");
        return triggers;
    }

    /**
     * 调度工厂
     * @param triggers 触发器
     * @return
     */
//    @Bean(name = "scheduler")
    public SchedulerFactoryBean schedulerFactory(Trigger ...triggers) {

        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
        // 用于quartz集群,QuartzScheduler 启动时更新己存在的Job
        factoryBean.setOverwriteExistingJobs(true);

        // 延时启动，应用启动1秒后
//        factoryBean.setStartupDelay(1);
        factoryBean.setAutoStartup(true);
        // 注册触发器
        factoryBean.setTriggers(triggers);
        return factoryBean;
    }
}
