package com.yws.plane.service.admin;

import com.yws.plane.entity.Plane;

public interface PlaneService {
    String add(Plane plane);

    String show();

    String one(Integer id);

    String del(Integer id);

    String update(Plane plane);

}
