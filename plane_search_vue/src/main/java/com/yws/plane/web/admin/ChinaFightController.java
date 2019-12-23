package com.yws.plane.web.admin;


import com.baomidou.mybatisplus.plugins.Page;
import com.yws.plane.entity.FightCompanyPlaneVO;
import com.yws.plane.entity.PageEntity;
import com.yws.plane.service.ChinaFightService;
import com.yws.plane.util.JSONData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yewenshu123
 * @since 2019-12-23
 */
@Controller
@RequestMapping("/api/chinaFight")
public class ChinaFightController {
    @Autowired
    private ChinaFightService chinaFightService;

    @PostMapping("/all")
    @CrossOrigin
    public String show(@RequestBody PageEntity page) {
        Page<FightCompanyPlaneVO> page1 = new Page<>(page.getCurrentPage(), page.getPageSize(),"start_time");
        return JSONData.toJsonString(200, "", chinaFightService.getChinaFightCompanyPlane(page1,page.getStartCity(),page.getEndCity()));
    }
}

