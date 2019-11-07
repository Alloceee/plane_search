package com.yws.plane.service.home;

import com.yws.plane.entity.AbroadFight;
import com.yws.plane.entity.ChinaFight;

import java.util.List;

public interface SearchService {

    List<ChinaFight> china_plane(String startCity, String endCity);

    String search(String startCity, String endCity, String startTime, String endTime);

    List<AbroadFight> abroad_plane(String startCity, String endCity);
}
