package com.yws.plane.service.admin.impl;

import com.alibaba.fastjson.JSONArray;
import com.yws.plane.entity.ChinaFight;
import com.yws.plane.entity.Plane;
import com.yws.plane.repository.ChinaFightRepository;
import com.yws.plane.service.admin.ChinaFightService;
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
public class ChinaFightServiceImpl implements ChinaFightService {
    @Autowired
    private ChinaFightRepository chinaFightRepository;

    @Override
    public String show() {
        List<ChinaFight> chinaFights = chinaFightRepository.findAll();
        return JSONData.toJsonString(0, "", chinaFights.size(), chinaFights);
    }

    @Override
    public String one(Long id) {
        ChinaFight chinaFight = chinaFightRepository.getOne(id);
        return JSONData.toJsonString(0, "", chinaFight);
    }

    @Override
    public String del(String fights,Long id) {
        if(!StringUtils.isEmpty(fights)){
            JSONArray array = JSONArray.parseArray(fights);
            List<ChinaFight> chinaFights1 = array.toJavaList(ChinaFight.class);
            //批量删除
            chinaFightRepository.deleteInBatch(chinaFights1);
        }else{
            chinaFightRepository.deleteById(id);
        }
        return JSONData.toJsonString(0, "", "");
    }

    @Override
    public String update(ChinaFight chinaFight) {
        ChinaFight chinaFight1 = chinaFightRepository.getOne(chinaFight.getId());
        //使用更新对象的非空值去覆盖待更新对象
        BeanUtils.copyProperties(chinaFight, chinaFight1, getNullPropertyNames(chinaFight));
        //执行更新操作
        ChinaFight c = chinaFightRepository.save(chinaFight1);
        if (c != null) {
            return JSONData.toJsonString(0, "", "");
        }
        return JSONData.toJsonString(1, "", "");
    }

    @Override
    public String add(ChinaFight chinaFight, String time, Integer planeId) {
        Plane plane = new Plane();
        plane.setId(planeId);
        chinaFight.setPlane(plane);
        chinaFight.setStartTime(TimeUtils.stringToDate(TimeUtils.subStartTime(time), TimeUtils.PATTERN1));
        chinaFight.setEndTime(TimeUtils.stringToDate(TimeUtils.subEndTime(time), TimeUtils.PATTERN1));
        ChinaFight chinaFight1 = chinaFightRepository.save(chinaFight);
        if (chinaFight1 != null) {
            return JSONData.toJsonString(0, "添加成功", "");
        }
        return JSONData.toJsonString(1, "添加失败", "");
    }

    @Override
    public String importExcel(MultipartFile file, Integer title) {
        List<ChinaFight> chinaFights = ExcelUtil.importExcel(file, title, 1, ChinaFight.class);
        try {
            chinaFightRepository.saveAll(chinaFights);
        } catch (Exception e) {
            return JSONData.toJsonString(1, "导入失败(请检查格式是否正确)", "");
        }
        return JSONData.toJsonString(0, "导入成功", "");
    }
}
