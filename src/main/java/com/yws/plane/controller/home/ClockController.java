package com.yws.plane.controller.home;

import com.yws.plane.util.JSONData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clock")
public class ClockController {

    @PostMapping("/send")
    public String send(String account,String type){

        return JSONData.toJsonString(0,"发送成功","");
    }

    @PostMapping("/add")
    public String add(String account,String code){
        //验证验证码是否正确

        //验证码正确添加定时任务

        return JSONData.toJsonString(0,"添加成功","");
    }
}
