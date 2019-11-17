package com.yws.plane.controller.home;

import com.yws.plane.service.QuartzTask;
import com.yws.plane.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

;

/**
 * @author AlmostLover
 */
@Controller
public class IndexController {
    @Autowired
    private QuartzTask quartzTask;

    @RequestMapping("/")
    public String index() {
        quartzTask.reptilian();
        return "home/index";
    }

    @RequestMapping("/send")
    @ResponseBody
    public String send() {
        return MessageUtil.sendCode("18855109072",121);
    }

}
