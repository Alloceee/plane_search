package com.yws.plane.service.admin.impl;

import com.alibaba.fastjson.JSONArray;
import com.yws.plane.entity.Company;
import com.yws.plane.entity.Plane;
import com.yws.plane.repository.PlaneRepository;
import com.yws.plane.service.admin.PlaneService;
import com.yws.plane.util.ExcelUtil;
import com.yws.plane.util.JSONData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.yws.plane.util.BeanUtils.getNullPropertyNames;

/**
 * @author AlmostLover
 */
@Service
public class PlaneServiceImpl implements PlaneService {
    @Autowired
    private PlaneRepository planeRepository;

    @Override
    public String add(Plane plane, Integer companyId) {
        Company company = new Company();
        company.setId(companyId);
        plane.setCompany(company);
        Plane plane1 = planeRepository.save(plane);
        if (plane1 != null) {
            return JSONData.toJsonString(0, "添加成功", "");
        }
        return JSONData.toJsonString(1, "添加失败", "");
    }

    @Override
    public String show(String key) {
        List<Plane> planes;
        if (key != null) {
            planes = planeRepository.findByCompany_IdLikeOrNumberLikeOrModelLike('%'+key+'%', '%'+key+'%', '%'+key+'%');
            System.out.println(planes);
        } else {
            planes = planeRepository.findAll();
        }
        return JSONData.toJsonString(0, "", planes.size(), planes);
    }

    @Override
    public String one(Integer id) {
        Plane plane = planeRepository.getOne(id);
        return JSONData.toJsonString(0, "", plane);
    }

    @Override
    public String del(String planes, Integer id) {
        //批量删除
        if (!StringUtils.isEmpty(planes)) {
            JSONArray array = JSONArray.parseArray(planes);
            List<Plane> planes1 = array.toJavaList(Plane.class);
            planeRepository.deleteInBatch(planes1);
        } else {
            planeRepository.deleteById(id);
        }
        return JSONData.toJsonString(0, "", "");
    }

    @Override
    public String update(Plane plane) {
        Plane plane1 = planeRepository.getOne(plane.getId());
        //使用更新对象的非空值去覆盖待更新对象
        BeanUtils.copyProperties(plane, plane1, getNullPropertyNames(plane));
        //执行更新操作
        Plane c = planeRepository.save(plane1);
        if (c != null) {
            return JSONData.toJsonString(0, "", "");
        }
        return JSONData.toJsonString(1, "", "");
    }

    @Override
    public String getByCompany(Integer id) {
        List<Plane> planes = planeRepository.findByCompany_Id(id);
        System.out.println(planes);
        return JSONData.toJsonString(0, "", planes);
    }

    @Override
    public String importExcel(MultipartFile file, Integer title) {
        List<Plane> planes = ExcelUtil.importExcel(file, title, 1, Plane.class);
        try {
            planeRepository.saveAll(planes);
        } catch (Exception e) {
            return JSONData.toJsonString(1, "导入失败(请检查格式是否正确)", "");
        }
        return JSONData.toJsonString(0, "导入成功", "");
    }

}
