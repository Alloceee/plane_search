package com.yws.plane.controller.admin;

import com.yws.plane.entity.Plane;
import com.yws.plane.service.admin.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/plane")
public class PlaneController {
    @Autowired
    private PlaneService planeService;

    @PostMapping("/add")
    public String add(Plane plane,Integer companyId){
        return planeService.add(plane,companyId);
    }

    @GetMapping("/all")
    public String show(){
        return planeService.show();
    }

    @GetMapping("/one")
    public String one(Integer id){
        return planeService.one(id);
    }

    @PostMapping("/del")
    public String del(String planes,Integer id){
        return planeService.del(planes,id);
    }

    @PostMapping("/update")
    public String update(Plane plane){
        return planeService.update(plane);
    }

    @PostMapping("/getByCompany")
    public String getByCompany(Integer companyId){
        return planeService.getByCompany(companyId);
    }

}
