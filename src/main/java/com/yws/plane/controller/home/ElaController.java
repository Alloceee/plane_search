package com.yws.plane.controller.home;

import com.alibaba.fastjson.JSON;
import com.yws.plane.elasticsearch.CompanyElasticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ElaController {
    @Autowired
    private CompanyElasticRepository companyRepository;

    @GetMapping("/elastic")
    public String index(){
        return JSON.toJSONString(companyRepository.findAll());
    }
}
