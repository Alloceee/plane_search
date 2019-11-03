package com.yws.plane.service.admin.impl;

import ch.qos.logback.core.pattern.color.RedCompositeConverter;
import com.yws.plane.entity.Manager;
import com.yws.plane.repository.ManagerRepository;
import com.yws.plane.service.admin.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 管理员登录
 *
 * @author AlmostLover
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public String login(Manager manager) {
        String username = manager.getUsername();
        String password = manager.getPassword();

        boolean res = managerRepository.findByUsernameAndPassword(manager.getUsername(),manager.getPassword());
        System.out.println(res);

        if (username.equals(password)) {
            return "true";
        }
        return "false";
    }
}
