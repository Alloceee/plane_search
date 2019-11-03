package com.yws.plane.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author AlmostLover
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "home/index";
    }

}
