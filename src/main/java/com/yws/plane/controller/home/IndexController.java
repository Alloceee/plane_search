package com.yws.plane.controller.home;

import com.yws.plane.service.QuartzTask;
import com.yws.plane.service.admin.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

;import javax.servlet.http.HttpServletResponse;

/**
 * @author AlmostLover
 */
@Controller
public class IndexController {
    @Autowired
    private QuartzTask quartzTask;
    @Autowired
    private ExcelService excelService;

    @RequestMapping("/")
    public String index() {
        quartzTask.reptilian();
        return "home/index";
    }

    @RequestMapping("/excel")
    @ResponseBody
    public String outExcel(HttpServletResponse response){
        return  excelService.list(response);
    }


}
