package com.yws.plane.repository;

import com.yws.plane.entity.Company;
import com.yws.plane.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: yewenshu https://github.com/Alloceee
 * @Date: 2019/11/24 17:38
 * @Project: plane_search
 */
public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findByContentLikeOrStartTimeLikeOrCycleLikeOrIsStart(String key1, String key2,String key3,String key4);
}
