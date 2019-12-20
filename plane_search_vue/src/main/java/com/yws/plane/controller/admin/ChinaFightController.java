package com.yws.plane.controller.admin;

import com.yws.plane.entity.ChinaFight;
import com.yws.plane.service.admin.ChinaFightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author AlmostLover
 */
@RestController
@RequestMapping("/admin/fight/china")
public class ChinaFightController {
    @Autowired
    private ChinaFightService chinaFightService;

    @PostMapping("/add")
    public String add(ChinaFight chinaFight, String time,Integer planeId) {
        return chinaFightService.add(chinaFight,time,planeId);
    }

    @GetMapping("/show")
    public String show(String key) {
        return chinaFightService.show(key);
    }

    @GetMapping("/one")
    public String one(Long id) {
        return chinaFightService.one(id);
    }

    @GetMapping("/del")
    public String del(String fights,Long id) {
        return chinaFightService.del(fights,id);
    }

    @PostMapping("/update")
    public String update(ChinaFight chinaFight) {
        return chinaFightService.update(chinaFight);
    }
}
