package com.yws.plane.config;

import org.springframework.boot.autoconfigure.quartz.SchedulerFactoryBeanCustomizer;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

public class SchedulerConfig implements SchedulerFactoryBeanCustomizer {
    @Override
    public void customize(SchedulerFactoryBean schedulerFactoryBean) {
        schedulerFactoryBean.setStartupDelay(2);
        schedulerFactoryBean.setAutoStartup(true);
        schedulerFactoryBean.setOverwriteExistingJobs(true);
    }
}
