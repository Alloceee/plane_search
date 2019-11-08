package com.yws.plane.controller.admin;

import com.yws.plane.entity.AbroadFight;
import com.yws.plane.service.admin.AbroadFightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author AlmostLover
 */
@RestController
@RequestMapping("/admin/fight/abroad")
public class AbroadFightController {
    @Autowired
    private AbroadFightService abroadFightService;

    @PostMapping("/add")
    public String add(AbroadFight abroadFight) {
        return abroadFightService.add(abroadFight);
    }

    @GetMapping("/show")
    public String show() {
        return abroadFightService.show();
    }

    @GetMapping("/one")
    public String one(Long id) {
        return abroadFightService.one(id);
    }

    @GetMapping("/del")
    public String del(String abroadFights) {
        return abroadFightService.del(abroadFights);
    }

    @PostMapping("/update")
    public String update(AbroadFight abroadFight) {
        return abroadFightService.update(abroadFight);
    }
}
