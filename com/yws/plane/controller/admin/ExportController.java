package com.yws.plane.controller.admin;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yws.plane.entity.Company;
import com.yws.plane.util.ExcelUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/api/admin/export")
public class ExportController {
    @PostMapping("/company")
    @CrossOrigin
    public void export(@RequestBody String companies, HttpServletResponse response) {
        JSONObject com = JSONObject.parseObject(companies);
        Object value = com.get("companies");
        JSONArray array = JSONArray.parseArray(value.toString());
        List<Company> companies1 = array.toJavaList(com.yws.plane.entity.Company.class);
        System.out.println(companies1);
        ExcelUtil.exportExcel(companies1, "航空公司信息表", "航空公司信息表"
                , Company.class, "航空公司信息表.xls", true, response);
    }
}
