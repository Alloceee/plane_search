package com.yws.plane.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author AlmostLover
 */
@Controller
@RequestMapping("/admin/company")
public class CompanyController {

    @GetMapping("/upload")
    public String index(){
        return "admin/company/upload";
    }

    @PostMapping("/upload")
    public String upload(){
        return "";
    }
}
