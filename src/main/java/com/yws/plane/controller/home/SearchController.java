package com.yws.plane.controller.home;

import com.yws.plane.entity.AbroadFight;
import com.yws.plane.entity.ChinaFight;
import com.yws.plane.entity.Fight;
import com.yws.plane.service.home.SearchService;
import com.yws.plane.util.JSONData;
import com.yws.plane.util.RedisUtil;
import com.yws.plane.util.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author AlmostLover
 */
@RestController
public class SearchController {
    @Autowired
    private SearchService searchService;
    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/china_plane")
    public String china_plane(String startCity, String endCity) {
        List<ChinaFight> chinaFights = searchService.china_plane(startCity, endCity);
        return JSONData.toJsonString(0, "", chinaFights);
    }

    @GetMapping("/abroad_plane")
    public String abroad_plane(String startCity, String endCity) {
        List<AbroadFight> abroadFights = searchService.abroad_plane(startCity, endCity);
        return JSONData.toJsonString(0, "", abroadFights);
    }

    @GetMapping("/search")
    public String search(Fight fight) {
        System.out.println("fight.getUserIp() " + fight.getUserIp());
        redisUtil.pfadd(fight.getEndCity(), TimeUtils.getMd5Day() + "_" + fight.getUserIp());
//        System.out.println(""+redisUtil.pfcount("hot_city"));
        if (fight.getType() == 0) {
            List<ChinaFight> fights = searchService.search_china(fight);
            return JSONData.toJsonString(0, "", fights);
        } else {
            List<AbroadFight> fights = searchService.search_abroad(fight);
            return JSONData.toJsonString(0, "", fights);
        }
    }

}
