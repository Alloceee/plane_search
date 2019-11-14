package com.yws.plane.service.admin;

import com.yws.plane.entity.Company;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author AlmostLover
 */
public interface CompanyService {

    /**
     * 添加公司信息
     * @param company 公司信息
     * @return
     */
    String add(Company company);

    String show(String key);

    /**
     * 根据id查询某条公司信息
     * @param id 公司id
     * @return
     */
    String one(Integer id);

    /**
     * 批量删除
     * @param companies 多条公司信息
     * @return
     */
    String del(String companies,Integer id);

    /**
     * 更新
     * @param company 更新的公司信息
     * @return
     */
    String update(Company company);

    /**
     * 上传图片
     * @param file 上传的图片信息
     * @return
     */
    String icon(MultipartFile file);

}
