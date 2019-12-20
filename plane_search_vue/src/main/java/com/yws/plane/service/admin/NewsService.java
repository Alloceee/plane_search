package com.yws.plane.service.admin;

import com.yws.plane.entity.News;

/**
 * @Author: yewenshu https://github.com/Alloceee
 * @Date: 2019/11/9 21:51
 * @Project: plane_search
 */
public interface NewsService {
    /**
     * 添加公司新闻动态
     *
     * @param news 新闻信息
     */
    String add(News news);

    /**
     * 公司信息管理
     *
     * @return
     */
    String show(String key);

    /**
     * 根据id查询某条公司信息
     *
     * @param id
     * @return
     */
    String one(Integer id);

    /**
     * 批量删除
     *
     * @param news
     * @return
     */
    String del(String news);

    /**
     * 更新
     *
     * @param news
     * @return
     */
    String update(News news);

}
