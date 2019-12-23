package com.yws.plane.service.impl;

import com.yws.plane.entity.News;
import com.yws.plane.mapper.NewsMapper;
import com.yws.plane.service.NewsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yewenshu123
 * @since 2019-12-23
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {

}
