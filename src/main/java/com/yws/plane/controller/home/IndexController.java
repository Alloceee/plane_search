package com.yws.plane.controller.home;

import com.yws.plane.service.QuartzTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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


}
