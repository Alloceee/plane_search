package com.yws.plane.service;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class QuartzTask {

    /**
     * 业务逻辑
     */
    public void reptilian(){
        System.out.println("执行业务处理逻辑："+new Date());
    }
}
