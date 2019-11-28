package com.yws.plane.quartz;

import com.yws.plane.service.home.MailService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class CustomJob implements Job {
    @Autowired
    private MailService emailService;

    private void before() {
        System.out.println("开始执行");
    }

    @Override
    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        before();
        //发送邮件


        //获取job id
        String name = context.getJobDetail().getKey().getName();
        System.out.println("["+Thread.currentThread().getName()+"],执行Job"+name+",当前时间："+new Date());
        after();
    }

    private void after() {
        System.out.println("执行结束");
    }
}
