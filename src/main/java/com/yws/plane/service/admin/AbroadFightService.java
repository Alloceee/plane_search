package com.yws.plane.service.admin;

import com.yws.plane.entity.AbroadFight;

/**
 * @author AlmostLover
 */
public interface AbroadFightService {

    String show();

    String one(Long id);

    String del(String abroadFights);

    String update(AbroadFight abroadFight);

    String add(AbroadFight abroadFight, String time, Integer planeId);
}
