package com.yws.plane.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 路由索引控制器
 *
 * @author yewenshu
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

    @GetMapping("/company/import")
    public String importExcel(){
        return "admin/company/file";
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

    @GetMapping("/chinaFight/show")
    public String chinaFightShow() {
        return "admin/fight/china";
    }

    @GetMapping("/abroadFight/show")
    public String abroadFightShow() {
        return "admin/fight/abroad";
    }

    @GetMapping("/news/add")
    public String newsAdd() {
        return "admin/news/add";
    }

    @GetMapping("/news/show")
    public String newsShow() {
        return "admin/news/show";
    }

    @GetMapping("/user/message")
    public String userMessage() {
        return "admin/user/message";
    }

    @GetMapping("/user/search")
    public String userSearch() {
        return "admin/user/search";
    }

}
