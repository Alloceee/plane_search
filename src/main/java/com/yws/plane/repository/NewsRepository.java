package com.yws.plane.repository;

import com.yws.plane.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: yewenshu https://github.com/Alloceee
 * @Date: 2019/11/10 15:06
 * @Project: plane_search
 */
@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {
}
