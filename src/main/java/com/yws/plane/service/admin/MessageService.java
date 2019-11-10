package com.yws.plane.service.admin;

import com.yws.plane.entity.Company;
import com.yws.plane.entity.Message;

/**
 * @Author: yewenshu https://github.com/Alloceee
 * @Date: 2019/11/10 15:21
 * @Project: plane_search
 */
public interface MessageService {
    /**
     * 记录短信提醒的用户信息
     *
     * @param message
     * @return
     */
    String add(Message message);

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
     * @param message
     * @return
     */
    String update(Message message);
}
