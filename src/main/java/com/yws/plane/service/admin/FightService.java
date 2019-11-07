package com.yws.plane.service.admin;

import com.yws.plane.entity.ChinaFight;

public interface FightService {

    String show();

    String one(Integer id);

    String del(Integer id);

    String update(ChinaFight chinaFight);

    String addChina(ChinaFight chinaFight);
}
