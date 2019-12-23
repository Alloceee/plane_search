package com.yws.plane.controller.admin;

//import com.yws.plane.elasticsearch.CompanyElasticRepository;

import com.yws.plane.entity.Task;
import com.yws.plane.service.admin.CompanyService;
import com.yws.plane.service.admin.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author AlmostLover
 */
@RestController
@RequestMapping("/admin/task")
public class TaskController {
    @Autowired
    private TaskService taskService;
//    @Autowired
//    private CompanyElasticRepository companyElasticRepository;

    @PostMapping("/add")
    public String add(Task task) {
        return taskService.add(task);
    }

    @GetMapping("/all")
    public String manage(String key) {
        return taskService.show(key);
    }

    @GetMapping("/one")
    public String one(Long id) {
        return taskService.one(id);
    }

    @PostMapping("/del")
    public String del(String tasks, Long id) {
        return taskService.del(tasks, id);
    }

    @PostMapping("/update")
    public String update(Task task) {
        return taskService.update(task);
    }

//    @GetMapping("/get")
//    public String search() {
//        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
//        builder.withQuery(QueryBuilders.fuzzyQuery("name", "南"))
//                .withQuery(QueryBuilders.fuzzyQuery("description", "南"));
//        Page<Com> company = companyElasticRepository.search(builder.build());
//        return JSONData.toJsonString(0, "", company);
//    }

//    @PostMapping("/import")
//    public String importExcel(@RequestParam("file") MultipartFile file, Integer title) {
//        return taskService.importExcel(file, title);
//    }

}
