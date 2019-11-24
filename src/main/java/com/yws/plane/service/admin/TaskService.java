package com.yws.plane.service.admin;

import com.yws.plane.entity.Task;

/**
 * 定时器管理
 */
public interface TaskService {
    /**
     * 记录短信提醒的用户信息
     *
     * @param task
     * @return
     */
    String add(Task task);

    String show(String key);

    String one(Long id);

    /**
     * 批量删除
     * @param tasks
     * @return
     */
    String del(String tasks,Long id);

    /**
     * 更新
     * @param task
     * @return
     */
    String update(Task task);
}
