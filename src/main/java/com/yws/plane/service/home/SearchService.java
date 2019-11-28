package com.yws.plane.service.home;

import com.yws.plane.entity.AbroadFight;
import com.yws.plane.entity.ChinaFight;
import com.yws.plane.entity.Fight;

import java.util.List;

public interface SearchService {

    List<ChinaFight> china_plane(String startCity, String endCity);

    List<ChinaFight> search_china(Fight fight);

    List<AbroadFight> search_abroad(Fight fight);

    List<AbroadFight> abroad_plane(String startCity, String endCity);
}
