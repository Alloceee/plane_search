package com.yws.plane.service.admin;

import com.yws.plane.entity.Manager;

/**
 * @author AlmostLover
 */
public interface LoginService {
    /**
     * 管理员登录
     * @param manager 管理员信息
     * @return 是否登录成功
     */
    String login(Manager manager);
}
