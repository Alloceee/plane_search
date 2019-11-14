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

    String show();

    String one(Long id);

    /**
     * 批量删除
     * @param messages
     * @return
     */
    String del(String messages);

    /**
     * 更新
     * @param task
     * @return
     */
    String update(Task task);
}
