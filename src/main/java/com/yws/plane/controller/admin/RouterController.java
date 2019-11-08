package com.yws.plane.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 路由索引控制器
 */
@Controller
@RequestMapping("/admin")
public class RouterController {

    @GetMapping("/index")
    public String index() {
        return "admin/login";
    }

    @GetMapping("/company/add")
    public String companyAdd() {
        return "admin/company/add";
    }

    @GetMapping("/company/show")
    public String companyShow() {
        return "admin/company/show";
    }

    @GetMapping("/plane/add")
    public String planeAdd() {
        return "admin/plane/add";
    }

    @GetMapping("/plane/show")
    public String planeShow() {
        return "admin/plane/show";
    }

    @GetMapping("/fight/add")
    public String fightAdd() {
        return "admin/fight/add";
    }

    @GetMapping("/fight/show")
    public String fightShow() {
        return "admin/fight/show";
    }
}
