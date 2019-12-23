package com.yws.plane.controller.home;

import com.alibaba.fastjson.JSON;
import com.yws.plane.entity.Company;
import com.yws.plane.entity.Fight;
import com.yws.plane.repository.CompanyRepository;
import com.yws.plane.service.QuartzTask;
import com.yws.plane.util.ExcelUtil;
import com.yws.plane.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author AlmostLover
 */
@Controller
public class IndexController {
    @Autowired
    private QuartzTask quartzTask;
    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("/")
    public String index() {
        quartzTask.reptilian();
        return "home/index";
    }

    @RequestMapping("/send")
    @ResponseBody
    public String send() {
        return MessageUtil.sendCode("18855109072",121);
    }

    @RequestMapping("/export")
    public void export(HttpServletResponse response){
        List<Company> companies = companyRepository.findAll();
        ExcelUtil.exportExcel(companies,"公司信息","公司信息",Company.class,"公司信息.xls",response);
    }

    @PostMapping("/search")
    public String search(Fight fight, Model model) {
        model.addAttribute("fight", JSON.toJSONString(fight));
        return "home/search";
    }
}
