package com.yws.plane.service.admin.impl;

import com.alibaba.fastjson.JSONArray;
import com.yws.plane.entity.AbroadFight;
import com.yws.plane.entity.Plane;
import com.yws.plane.repository.AbroadFightRepository;
import com.yws.plane.service.admin.AbroadFightService;
import com.yws.plane.util.ExcelUtil;
import com.yws.plane.util.JSONData;
import com.yws.plane.util.TimeUtils;
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
public class AbroadFightServiceImpl implements AbroadFightService {
    @Autowired
    private AbroadFightRepository abroadFightRepository;

    @Override
    public String show() {
        List<AbroadFight> abroadFights = abroadFightRepository.findAll();
        return JSONData.toJsonString(0, "", abroadFights.size(), abroadFights);
    }

    @Override
    public String one(Long id) {
        AbroadFight abroadFight = abroadFightRepository.getOne(id);
        return JSONData.toJsonString(0, "", abroadFight);
    }

    @Override
    public String del(String fights, Long id) {
        if (!StringUtils.isEmpty(fights)) {
            JSONArray array = JSONArray.parseArray(fights);
            List<AbroadFight> abroadFights = array.toJavaList(AbroadFight.class);
            //批量删除
            abroadFightRepository.deleteInBatch(abroadFights);
        } else {
            abroadFightRepository.deleteById(id);
        }
        return JSONData.toJsonString(0, "", "");
    }

    @Override
    public String update(AbroadFight abroadFight) {
        AbroadFight abroadFight1 = abroadFightRepository.getOne(abroadFight.getId());
        //使用更新对象的非空值去覆盖待更新对象
        BeanUtils.copyProperties(abroadFight, abroadFight1, getNullPropertyNames(abroadFight));
        //执行更新操作
        AbroadFight c = abroadFightRepository.save(abroadFight1);
        if (c != null) {
            return JSONData.toJsonString(0, "", "");
        }
        return JSONData.toJsonString(1, "", "");
    }

    @Override
    public String add(AbroadFight abroadFight, String time, Integer planeId) {
        Plane plane = new Plane();
        plane.setId(planeId);
        abroadFight.setPlane(plane);
        abroadFight.setStartTime(TimeUtils.stringToDate(TimeUtils.subStartTime(time), TimeUtils.PATTERN1));
        abroadFight.setEndTime(TimeUtils.stringToDate(TimeUtils.subEndTime(time), TimeUtils.PATTERN1));
        AbroadFight abroadFight1 = abroadFightRepository.save(abroadFight);
        if (abroadFight1 != null) {
            return JSONData.toJsonString(0, "添加成功", "");
        }
        return JSONData.toJsonString(1, "添加失败", "");
    }

    @Override
    public String importExcel(MultipartFile file, Integer title) {
        List<AbroadFight> abroadFights = ExcelUtil.importExcel(file, title, 1, AbroadFight.class);
        try {
            abroadFightRepository.saveAll(abroadFights);
        } catch (Exception e) {
            return JSONData.toJsonString(1, "导入失败(请检查格式是否正确)", "");
        }
        return JSONData.toJsonString(0, "导入成功", "");
    }
}
