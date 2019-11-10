package com.yws.plane.service.admin.impl;

import com.alibaba.fastjson.JSONArray;
import com.yws.plane.entity.Company;
import com.yws.plane.repository.CompanyRepository;
import com.yws.plane.service.admin.CompanyService;
import com.yws.plane.util.FileUploadUtils;
import com.yws.plane.util.JSONData;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static com.yws.plane.util.BeanUtils.getNullPropertyNames;

/**
 * @author AlmostLover
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public String add(Company company) {
        Company company1 = companyRepository.save(company);
        if (company1 != null) {
            return JSONData.toJsonString(0, "添加成功", "");
        }
        return JSONData.toJsonString(1, "添加失败", "");
    }

    @Override
    public String show(String key) {
        List<Company> companies;
//        if (key != null) {
////            companies = companyRepository.findByNameLikeOrDescriptionLike(key);
//        } else {
            companies = companyRepository.findAll();
//        }
        return JSONData.toJsonString(0, "", companies.size(), companies);
    }

    @Override
    public String one(Integer id) {
        Company company = companyRepository.getOne(id);
        return JSONData.toJsonString(0, "", company);
    }

    @Override
    public String del(String companies) {
        JSONArray array = JSONArray.parseArray(companies);
        List<Company> companies1 = array.toJavaList(Company.class);
        //批量删除
        companyRepository.deleteInBatch(companies1);
        return JSONData.toJsonString(0, "", "");
    }

    @Override
    public String update(Company company) {
        Company company1 = companyRepository.getOne(company.getId());
        //使用更新对象的非空值去覆盖待更新对象
        BeanUtils.copyProperties(company, company1, getNullPropertyNames(company));
        //执行更新操作
        Company c = companyRepository.save(company1);
        if (c != null) {
            return JSONData.toJsonString(0, "", "");
        }
        return JSONData.toJsonString(1, "", "");
    }


    @Override
    public String icon(MultipartFile file) {
        try {
            //将图片上传至七牛云
            String filename = FileUploadUtils.fileUpload(file.getBytes());
            if (filename != null) {
                return JSONData.toJsonString(0, "图标上传成功", filename);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return JSONData.toJsonString(1, "图标上传失败", "");
    }


}
