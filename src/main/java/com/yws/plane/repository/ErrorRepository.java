package com.yws.plane.repository;

import com.yws.plane.entity.Error;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: yewenshu https://github.com/Alloceee
 * @Date: 2019/11/10 21:14
 * @Project: plane_search
 */
public interface ErrorRepository extends JpaRepository<Error, Long> {
}
