package com.yws.plane.service.admin.impl;

import com.alibaba.fastjson.JSONArray;
import com.yws.plane.entity.News;
import com.yws.plane.repository.NewsRepository;
import com.yws.plane.service.admin.NewsService;
import com.yws.plane.util.JSONData;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.yws.plane.util.BeanUtils.getNullPropertyNames;

/**
 * @Author: yewenshu https://github.com/Alloceee
 * @Date: 2019/11/9 21:52
 * @Project: plane_search
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsRepository newsRepository;

    @Override
    public String add(News news) {
        News news1 = newsRepository.save(news);
        if (news1 != null) {
            if (news.getNotify_plane() != null) {
                //发送通知（邮件或者手机号）
            }
            return JSONData.toJsonString(0, "添加成功", "");
        }
        return JSONData.toJsonString(1, "添加失败", "");
    }

    @Override
    public String show(String key) {
        List<News> news;
        if (key != null) {
            news = newsRepository.findByTitleLikeOrContentLikeOrCreateTimeLike('%' + key + '%', '%' + key + '%', '%' + key + '%');
            System.out.println(news);
        } else {
            news = newsRepository.findAll();
        }
        return JSONData.toJsonString(0, "", news.size(), news);
    }

    @Override
    public String one(Integer id) {
        News news = newsRepository.getOne(id);
        return JSONData.toJsonString(0, "", news);
    }

    @Override
    public String del(String news) {
        JSONArray array = JSONArray.parseArray(news);
        List<News> news1 = array.toJavaList(News.class);
        //批量删除
        newsRepository.deleteInBatch(news1);
        return JSONData.toJsonString(0, "", "");
    }

    @Override
    public String update(News news) {
        News news1 = newsRepository.getOne(news.getId());
        //使用更新对象的非空值去覆盖待更新对象
        BeanUtils.copyProperties(news, news1, getNullPropertyNames(news));
        //执行更新操作
        News c = newsRepository.save(news1);
        if (c != null) {
            return JSONData.toJsonString(0, "", "");
        }
        return JSONData.toJsonString(1, "", "");
    }

    @Override
    public List<News> all() {
        return newsRepository.findTopByStatusOrderByCreateTime(1);
    }

}
