package com.yws.plane.service.admin.impl;

import com.alibaba.fastjson.JSONArray;
import com.yws.plane.entity.Task;
import com.yws.plane.repository.TaskRepository;
import com.yws.plane.service.admin.TaskService;
import com.yws.plane.util.JSONData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.yws.plane.util.BeanUtils.getNullPropertyNames;

/**
 * @author AlmostLover
 */
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public String add(Task task) {
        Task task1 = taskRepository.save(task);
        if (task1 != null) {
            return JSONData.toJsonString(0, "添加成功", "");
        }
        return JSONData.toJsonString(1, "添加失败", "");
    }

    @Override
    public String show(String key) {
        List<Task> tasks;
        if (key != null) {
            tasks = taskRepository.findByContentLikeOrStartTimeLikeOrCycleLikeOrIsStart('%'+key+'%', '%'+key+'%', '%'+key+'%', '%'+key+'%');
            System.out.println(tasks);
        } else {
            tasks = taskRepository.findAll();
        }
        return JSONData.toJsonString(0, "", tasks.size(), tasks);
    }

    @Override
    public String one(Long id) {
        Task task = taskRepository.getOne(id);
        return JSONData.toJsonString(0, "", task);
    }

    @Override
    public String del(String tasks, Long id) {
        //批量删除
        if (!StringUtils.isEmpty(tasks)) {
            JSONArray array = JSONArray.parseArray(tasks);
            List<Task> tasks1 = array.toJavaList(Task.class);
            taskRepository.deleteInBatch(tasks1);
        } else {
            taskRepository.deleteById(id);
        }
        return JSONData.toJsonString(0, "", "");
    }

    @Override
    public String update(Task task) {
        Task task1 = taskRepository.getOne(task.getId());
        //使用更新对象的非空值去覆盖待更新对象
        BeanUtils.copyProperties(task, task1, getNullPropertyNames(task));
        //执行更新操作
        Task c = taskRepository.save(task1);
        if (c != null) {
            return JSONData.toJsonString(0, "", "");
        }
        return JSONData.toJsonString(1, "", "");
    }
}
