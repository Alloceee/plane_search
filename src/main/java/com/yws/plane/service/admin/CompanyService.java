package com.yws.plane.service.admin;

import com.yws.plane.entity.Company;
import org.springframework.web.multipart.MultipartFile;

public interface CompanyService {

    String add(Company company);

    String show();

    String one(Integer id);

    String del(String companies);

    String update(Company company);

    String icon(MultipartFile file);

    String all();
}
