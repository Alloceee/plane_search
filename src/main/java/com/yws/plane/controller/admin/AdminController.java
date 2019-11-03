package com.yws.plane.controller.admin;

import com.yws.plane.entity.Manager;
import com.yws.plane.service.admin.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("/index")
    public String index() {
        return "admin/login";
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(Manager manager){
        return loginService.login(manager);
    }

    @RequestMapping("/home")
    public String home(){
        return "admin/manager";
    }

}
