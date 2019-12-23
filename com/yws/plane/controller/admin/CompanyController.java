package com.yws.plane.controller.admin;

//import com.yws.plane.elasticsearch.CompanyElasticRepository;

import com.yws.plane.entity.Company;
import com.yws.plane.service.admin.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author AlmostLover
 */
@RestController
@RequestMapping("/admin/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
//    @Autowired
//    private CompanyElasticRepository companyElasticRepository;

    @RequestMapping("/icon")
    public String icon(@RequestParam("file") MultipartFile file) {
        return companyService.icon(file);
    }

    @PostMapping("/add")
    public String add(Company company) {
        return companyService.add(company);
    }

    @GetMapping("/all")
    public String manage(String key) {
        return companyService.show(key);
    }

    @GetMapping("/one")
    public String one(Integer id) {
        return companyService.one(id);
    }

    @PostMapping("/del")
    public String del(String companies, Integer id) {
        return companyService.del(companies, id);
    }

    @PostMapping("/update")
    public String update(Company company) {
        return companyService.update(company);
    }

//    @GetMapping("/get")
//    public String search() {
//        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
//        builder.withQuery(QueryBuilders.fuzzyQuery("name", "南"))
//                .withQuery(QueryBuilders.fuzzyQuery("description", "南"));
//        Page<Com> company = companyElasticRepository.search(builder.build());
//        return JSONData.toJsonString(0, "", company);
//    }

    @PostMapping("/import")
    public String importExcel(@RequestParam("file") MultipartFile file,Integer title) {
        return companyService.importExcel(file, title);
    }

}
