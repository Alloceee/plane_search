package com.yws.plane.service.admin;

import com.yws.plane.entity.ChinaFight;

/**
 * @author AlmostLover
 */
public interface ChinaFightService {

    String show();

    String one(Long id);

    String del(String fights,Long id);

    String update(ChinaFight chinaFight);

    String add(ChinaFight chinaFight, String time,Integer planeId);
}
