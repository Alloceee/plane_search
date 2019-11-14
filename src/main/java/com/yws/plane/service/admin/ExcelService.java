package com.yws.plane.service.admin;

import javax.servlet.http.HttpServletResponse;

public interface ExcelService {

    String list(HttpServletResponse response);

    String importExcel();
}
