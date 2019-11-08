package com.yws.plane.controller.admin;

import com.yws.plane.entity.Manager;
import com.yws.plane.service.admin.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

/**
 * 后台管理
 *
 * @author AlmostLover
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    @ResponseBody
    public String login(Manager manager, HttpSession session){
        return loginService.login(manager,session);
    }

    @RequestMapping("/home")
    public String home(){
        return "admin/manager";
    }

    @PostConstruct
    public void init(){
        loginService.init();
    }
}
