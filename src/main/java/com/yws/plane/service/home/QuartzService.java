package com.yws.plane.service.home;

import com.yws.plane.entity.SchedulerJob;

public interface QuartzService {
    /**
     * 创建Job
     * @param job
     */
    void addTimerJob(SchedulerJob job);

    /**
     * 执行Job
     * @param job
     */
    void runTimerJob(SchedulerJob job);

    /**
     * 修改Job
     * @param job
     */
    void updateTimerJob(SchedulerJob job);

    /**
     * 暂定Job
     * @param job
     */
    void pauseTimerJob(SchedulerJob job);

    /**
     * 唤醒Job
     * @param job
     */
    void resumeTimerJob(SchedulerJob job);

    /**
     * 删除Job
     * @param job
     */
    void deleteTimerJob(SchedulerJob job);

    /**
     * 获取Job
     * @param job
     */
    String selectTimerJob(SchedulerJob job);
}
