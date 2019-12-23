package com.yws.plane.controller.admin;

import com.yws.plane.entity.News;
import com.yws.plane.service.admin.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yewenshu https://github.com/Alloceee
 * @Date: 2019/11/9 21:49
 * @Project: plane_search
 */
@RestController
@RequestMapping("/admin/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @PostMapping("/add")
    public String add(News news) {
        return newsService.add(news);
    }

    @GetMapping("/all")
    public String manage(String Key) {
        return newsService.show(Key);
    }

    @GetMapping("/one")
    public String one(Integer id) {
        return newsService.one(id);
    }

    @PostMapping("/del")
    public String del(String news) {
        return newsService.del(news);
    }

    @PostMapping("/update")
    public String update(News news) {
        return newsService.update(news);
    }

}
