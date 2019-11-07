package com.yws.plane.controller.admin;

import com.yws.plane.entity.ChinaFight;
import com.yws.plane.entity.Company;
import com.yws.plane.service.admin.CompanyService;
import com.yws.plane.service.admin.FightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author AlmostLover
 */
@Controller
@RequestMapping("/admin/fight")
public class FightController {
    @Autowired
    private FightService fightService;

    @GetMapping("/add")
    public String index(){
        return "admin/fight/add";
    }

    @PostMapping("/addChina")
    public String add(ChinaFight chinaFight){
        return fightService.addChina(chinaFight);
    }

    @GetMapping("/show")
    public String show(){
        return fightService.show();
    }

    @GetMapping("/one")
    public String one(Integer id){
        return fightService.one(id);
    }

    @GetMapping("/del")
    public String del(Integer id){
        return fightService.del(id);
    }

    @PostMapping("/update")
    public String update(ChinaFight chinaFight){
        return fightService.update(chinaFight);
    }
}
