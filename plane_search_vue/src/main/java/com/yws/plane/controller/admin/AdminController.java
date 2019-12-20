package com.yws.plane.controller.admin;

import com.yws.plane.entity.Manager;
import com.yws.plane.service.admin.LoginService;
import com.yws.plane.util.JSONData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping("/api")
public class AdminController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    @ResponseBody
    @CrossOrigin
    public String login(@RequestBody Manager manager){
        if(loginService.login(manager)){
            return JSONData.toJsonString(200,"登录成功","");
        }
        return JSONData.toJsonString(500,"用户名或密码错误","");
    }

    @PostConstruct
    public void init(){
        loginService.init();
    }
}
