package com.yws.plane.repository;

import com.yws.plane.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: yewenshu https://github.com/Alloceee
 * @Date: 2019/11/10 15:06
 * @Project: plane_search
 */
@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {

    List<News> findByTitleLikeOrContentLikeOrCreateTimeLike(String key1, String key2,String key3);

    List<News> findTopByStatusOrderByCreateTime(Integer status);
}
