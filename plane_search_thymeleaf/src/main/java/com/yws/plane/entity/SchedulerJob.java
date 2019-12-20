package com.yws.plane.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel
@Data
public class SchedulerJob {

    @ApiModelProperty(value = "jobId", dataType = "String", name = "jobId", example = "1")
    private String jobId;

    /**
     * 执行任务的Job类全限名
     */
    @ApiModelProperty(value = "classname", dataType = "String", name = "classname", example = "com.yws.plane.quartz.CustomJob")
    private String classname;

    /**
     * 触发器执行周期
     */
    @ApiModelProperty(value = "cronExpression", dataType = "String", name = "cronExpression", example = "0/5 * * * * ?")
    private String cronExpression;

    @ApiModelProperty(value = "jobName", dataType = "String", name = "jobName", example = "job1")
    private String jobName;

    @ApiModelProperty(value = "jobGroup", dataType = "String", name = "jobGroup", example = "group1")
    private String jobGroup;

    @ApiModelProperty(value = "triggerName", dataType = "String", name = "triggerName", example = "triggerName1")
    private String triggerName;

    @ApiModelProperty(value = "triggerGroup", dataType = "String", name = "triggerGroup", example = "triggerGroup1")
    private String triggerGroup;

    @ApiModelProperty(value = "pause", dataType = "Boolean", name = "pause", example = "true")
    private Boolean pause;

    private Boolean enable;

    @ApiModelProperty(value = "description", dataType = "String", name = "description", example = "秒杀活动")
    private String description;

    private Date createTime;

    private Date lastUpDatetime;

    private String owner;
}
