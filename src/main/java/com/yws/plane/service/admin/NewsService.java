package com.yws.plane.service.admin;

import com.yws.plane.entity.Company;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: yewenshu https://github.com/Alloceee
 * @Date: 2019/11/9 21:51
 * @Project: plane_search
 */
public interface NewsService {
    /**
     * 添加公司信息
     * @param company
     * @return
     */
    String add(Company company);

    String show();

    /**
     * 根据id查询某条公司信息
     * @param id
     * @return
     */
    String one(Integer id);

    /**
     * 批量删除
     * @param companies
     * @return
     */
    String del(String companies);

    /**
     * 更新
     * @param company
     * @return
     */
    String update(Company company);

    /**
     * 上传图片
     * @param file
     * @return
     */
    String icon(MultipartFile file);
}
