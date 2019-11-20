package com.yws.plane.service.admin;

import com.yws.plane.entity.AbroadFight;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author AlmostLover
 */
public interface AbroadFightService {

    String show();

    String one(Long id);

    String del(String fights,Long id);

    String update(AbroadFight abroadFight);

    String add(AbroadFight abroadFight, String time, Integer planeId);
    /**
     * 导入excel文件
     *
     * @param file 导入的文件流
     * @param title 含有标题的行数
     * @return
     */
    String importExcel(@RequestParam("file") MultipartFile file, Integer title);
}
