package com.yws.plane.web.home;

import com.baomidou.mybatisplus.plugins.Page;
import com.yws.plane.entity.FightCompanyPlaneVO;
import com.yws.plane.entity.PageEntity;
import com.yws.plane.service.AbroadFightService;
import com.yws.plane.service.ChinaFightService;
import com.yws.plane.util.JSONData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author AlmostLover
 */
@RestController
@RequestMapping("/api")
public class SearchController {
    @Autowired
    private ChinaFightService chinaFightService;
    @Autowired
    private AbroadFightService abroadFightService;

    @PostMapping("/china_plane")
    @CrossOrigin
    public String china_plane(@RequestBody PageEntity page) {
        Page<FightCompanyPlaneVO> page1 = new Page<>(page.getCurrentPage(), page.getPageSize(), page.getOrderByField(),false);
        return JSONData.toJsonString(200, "", chinaFightService.getChinaFightCompanyPlane(page1, page.getStartCity(), page.getEndCity()));
    }

    @PostMapping("/abroad_plane")
    @CrossOrigin
    public String abroad_plane(@RequestBody PageEntity page) {
        Page<FightCompanyPlaneVO> page1 = new Page<>(page.getCurrentPage(), page.getPageSize(), page.getOrderByField(),false);
        return JSONData.toJsonString(200, "", abroadFightService.getAbroadFightCompanyPlane(page1, page.getStartCity(), page.getEndCity()));
    }
}
