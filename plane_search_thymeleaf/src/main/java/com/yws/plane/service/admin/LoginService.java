package com.yws.plane.service.admin;

import com.yws.plane.entity.Manager;

import javax.servlet.http.HttpSession;

/**
 * @author AlmostLover
 */
public interface LoginService {
    /**
     * 管理员登录
     * @param manager 管理员信息
     * @return 是否登录成功
     */
    String login(Manager manager, HttpSession session);

    /**
     * 初始化数据
     */
    void init();
}
