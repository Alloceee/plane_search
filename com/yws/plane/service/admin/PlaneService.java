package com.yws.plane.service.admin;

import com.yws.plane.entity.Plane;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface PlaneService {
    String add(Plane plane,Integer companyId);

    String show(String key);

    String one(Integer id);

    String del(String planes,Integer id);

    String update(Plane plane);

    String getByCompany(Integer id);
    /**
     * 导入excel文件
     *
     * @param file 导入的文件流
     * @param title 含有标题的行数
     * @return
     */
    String importExcel(@RequestParam("file") MultipartFile file, Integer title);
}
