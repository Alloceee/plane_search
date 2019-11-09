package com.yws.plane.controller.admin;

import com.yws.plane.entity.Company;
import com.yws.plane.service.admin.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: yewenshu https://github.com/Alloceee
 * @Date: 2019/11/9 21:49
 * @Project: plane_search
 */
@RestController
@RequestMapping("/admin/news")
public class NewsController {
    @Autowired
    private CompanyService companyService;

    @RequestMapping("/icon")
    public String icon(@RequestParam("file") MultipartFile file) {
        return companyService.icon(file);
    }

    @PostMapping("/add")
    public String add(Company company) {
        return companyService.add(company);
    }

    @GetMapping("/all")
    public String manage() {
        return companyService.show();
    }

    @GetMapping("/one")
    public String one(Integer id) {
        return companyService.one(id);
    }

    @PostMapping("/del")
    public String del(String companies) {
        return companyService.del(companies);
    }

    @PostMapping("/update")
    public String update(Company company) {
        return companyService.update(company);
    }

}
