package com.yws.plane.controller.home;

import com.yws.plane.entity.AbroadFight;
import com.yws.plane.entity.ChinaFight;
import com.yws.plane.entity.Fight;
import com.yws.plane.service.home.SearchService;
import com.yws.plane.util.JSONData;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author AlmostLover
 */
@RestController
@RequestMapping("/api")
public class SearchController {
    @Autowired
    private SearchService searchService;

    @PostMapping("/china_plane")
    @CrossOrigin
    public String chinaPlane(@RequestBody ChinaFight chinaFight) {
        List<ChinaFight> chinaFights = searchService.china_plane(chinaFight.getStartCity(), chinaFight.getEndCity());
        return JSONData.toJsonString(200,"",chinaFights);
    }

    @PostMapping("/abroad_plane")
    @CrossOrigin
    public String abroadPlane(@RequestBody AbroadFight abroadFight) {
        List<AbroadFight> abroadFights = searchService.abroad_plane(abroadFight.getStartCity(), abroadFight.getEndCity());
        return JSONData.toJsonString(200,"",abroadFights);
    }

    @GetMapping("/search")
    public String search(Fight fight) {
        List<T> fights =  searchService.search(fight);
        return JSONData.toJsonString(0,"",fights);
    }

}
