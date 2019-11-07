package com.yws.plane.service.admin.impl;

import com.yws.plane.entity.Plane;
import com.yws.plane.repository.PlaneRepository;
import com.yws.plane.service.admin.PlaneService;
import com.yws.plane.util.JSONData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class planeServiceImpl implements PlaneService {
    @Autowired
    private PlaneRepository planeRepository;

    @Override
    public String add(Plane plane) {
        return null;
    }

    @Override
    public String show() {
        List<Plane> planes = planeRepository.findAll();
        return JSONData.toJsonString(0, "", planes.size(), planes);
    }

    @Override
    public String one(Integer id) {
        return null;
    }

    @Override
    public String del(Integer id) {
        return null;
    }

    @Override
    public String update(Plane plane) {
        return null;
    }

}
