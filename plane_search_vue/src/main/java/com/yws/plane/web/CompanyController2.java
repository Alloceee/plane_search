package com.yws.plane.web;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yws.plane.model.Company;
import com.yws.plane.service2.CompanyService2;
import com.yws.plane.util.JSONData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author yewenshu123
 * @since 2019-12-21
 */
@RestController
@RequestMapping("/api/admin/company")
public class CompanyController2 {
    @Autowired
    private CompanyService2 companyService2;

    @GetMapping("/all")
    @CrossOrigin
    public String all() {
        return JSONData.toJsonString(200, "", companyService2.selectList(null));
    }

    @PostMapping("/del")
    @CrossOrigin
    public String del(@RequestBody String companies) {
        System.out.println(companies);
        JSONArray array = JSON.parseArray(companies);
        boolean flag = companyService2.deleteBatchIds(array.toJavaList(Company.class));
        if (flag) {
            return JSONData.toJsonString(200, "删除成功", null);
        }
        return JSONData.toJsonString(500, "删除失败", null);
    }

    @PostMapping("/update")
    @CrossOrigin
    public String update(Company company) {
        boolean flag = companyService2.update(company, null);
        if (flag) {
            return JSONData.toJsonString(200, "修改成功", null);
        }
        return JSONData.toJsonString(500, "修改失败", null);
    }

}

