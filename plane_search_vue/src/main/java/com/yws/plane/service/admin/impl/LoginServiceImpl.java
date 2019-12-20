package com.yws.plane.service.admin.impl;

import com.yws.plane.entity.Manager;
import com.yws.plane.repository.ManagerRepository;
import com.yws.plane.service.admin.LoginService;
import com.yws.plane.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

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
    public boolean login(Manager manager) {
        Manager res = managerRepository.findByUsernameAndPassword(manager.getUsername(),
                MD5Util.Md5(manager.getUsername(), "root"));
        if (res != null) {
            return true;
        }
        return false;
    }

    @Override
    public void init() {
        Manager m = new Manager();
        m.setUsername("admin");
        m.setPassword(MD5Util.Md5("admin", "root"));
        Manager res = managerRepository.findByUsernameAndPassword("admin", MD5Util.Md5("admin", "root"));
        if(res==null) {
            managerRepository.save(m);
        }
    }
}
