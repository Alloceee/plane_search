package com.yws.plane.repository;

import com.yws.plane.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: yewenshu https://github.com/Alloceee
 * @Date: 2019/11/10 18:57
 * @Project: plane_search
 */
public interface LogRepository extends JpaRepository<Log, Long> {
}
