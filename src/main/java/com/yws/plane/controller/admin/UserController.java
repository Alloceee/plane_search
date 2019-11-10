package com.yws.plane.controller.admin;

import com.yws.plane.entity.Company;
import com.yws.plane.entity.Message;
import com.yws.plane.service.admin.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yewenshu https://github.com/Alloceee
 * @Date: 2019/11/10 15:19
 * @Project: plane_search
 */
@RestController
@RequestMapping("/admin/message")
public class UserController {
    @Autowired
    private MessageService messageService;

    @PostMapping("/add")
    public String add(Message message) {
        return messageService.add(message);
    }

    @GetMapping("/all")
    public String show() {
        return messageService.show();
    }

    @GetMapping("/one")
    public String one(Long id) {
        return messageService.one(id);
    }

    @PostMapping("/del")
    public String del(String companies) {
        return messageService.del(companies);
    }

    @PostMapping("/update")
    public String update(Message message) {
        return messageService.update(message);
    }

}
