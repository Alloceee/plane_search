package com.yws.plane.service.admin;

import com.yws.plane.entity.Plane;

public interface PlaneService {
    String add(Plane plane,Integer companyId);

    String show();

    String one(Integer id);

    String del(String planes,Integer id);

    String update(Plane plane);

    String getByCompany(Integer id);
}
