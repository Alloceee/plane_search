package com.yws.plane.service.admin.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.yws.plane.entity.ChinaFight;
import com.yws.plane.repository.ChinaFightRepository;
import com.yws.plane.service.admin.ExcelService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class ExcelServiceImpl implements ExcelService {
    @Autowired
    private ChinaFightRepository chinaFightRepository;

    @Override
    public String list(HttpServletResponse response) {
        List<ChinaFight> chinaFights = chinaFightRepository.findAll();
        System.out.println(chinaFights);
        try {
            // 设置响应输出的头类型及下载文件的默认名称
            String fileName = new String("demo信息表.xls".getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
            response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.setContentType("application/vnd.ms-excel;charset=gb2312");

            //导出
            Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), ChinaFight.class, chinaFights);
            workbook.write(response.getOutputStream());
            return "导出成功";
//            log.info("请求 exportExcel end ......");
        } catch (IOException e) {
//            log.info("请求 exportExcel 异常：{}", e.getMessage());
        }
        return null;
    }

    @Override
    public String importExcel() {
//        try {
//            // 没有使用实体类注解的形式，这里用的Map
//            List<Map<String, Object>> list = ExcelImportUtil.importExcel(
//                    new File(PoiPublicUtil.getWebRootPath("check.xls")),
//                    Map.class,
//                    new ImportParams()
//            );
//            // 数据打印
//            for (Map<String, Object> map : list) {
//                System.out.println(JSON.toJSON(map));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
////            log.info(" Excel 导入异常：{}", e.getMessage());
//        }
        return null;
    }
}
