package com.yws.plane.controller.home;


import com.yws.plane.entity.SchedulerJob;
import com.yws.plane.service.home.QuartzService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quartz")
@Api(tags="Quartz测试")
public class QuartzController {

    @Autowired
    private QuartzService quartzService;

    @RequestMapping("/add")
    @ApiOperation("创建Quartz任务")
    public String addJob(@RequestBody SchedulerJob job) throws Exception {
        if (job == null) throw new Exception("job is null");
        quartzService.addTimerJob(job);
        return "创建Quartz任务成功";
    }

    @RequestMapping("/run")
    @ApiOperation("启动Quartz任务")
    public String runJob(@RequestBody SchedulerJob job) throws Exception {
        if (job == null) throw new Exception("job is null");
        quartzService.runTimerJob(job);
        return "启动Quartz任务成功";
    }

    @RequestMapping("/update")
    @ApiOperation("修改Quartz任务")
    public String updateJob(@RequestBody SchedulerJob job) throws Exception {
        if (job == null) throw new Exception("job is null");
        quartzService.updateTimerJob(job);
        return "修改Quartz任务成功";
    }

    @RequestMapping("/pause")
    @ApiOperation("暂停Quartz任务")
    public String pauseJob(@RequestBody SchedulerJob job) throws Exception {
        if (job == null) throw new Exception("job is null");
        quartzService.pauseTimerJob(job);
        return "暂停Quartz任务成功";
    }

    @RequestMapping("/resume")
    @ApiOperation("重启Quartz任务")
    public String resumeJob(@RequestBody SchedulerJob job) throws Exception {
        if (job == null) throw new Exception("job is null");
        quartzService.resumeTimerJob(job);
        return "重启Quartz任务成功";
    }

    @RequestMapping("/delete")
    @ApiOperation("删除Quartz任务")
    public String deleteJob(@RequestBody SchedulerJob job) throws Exception {
        if (job == null) throw new Exception("job is null");
        quartzService.deleteTimerJob(job);
        return "删除Quartz任务成功";
    }

    @RequestMapping("/select")
    @ApiOperation("获取Quartz任务")
    public String selectJob(@RequestBody SchedulerJob job) throws Exception {
        if (job == null) throw new Exception("job is null");
        return quartzService.selectTimerJob(job);
    }
}
