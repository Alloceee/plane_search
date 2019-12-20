package com.yws.plane.service.home;

import com.yws.plane.entity.AbroadFight;
import com.yws.plane.entity.ChinaFight;
import com.yws.plane.entity.Fight;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

public interface SearchService {

    List<ChinaFight> china_plane(String startCity, String endCity);

    <T>List<T> search(Fight fight);

    List<AbroadFight> abroad_plane(String startCity, String endCity);
}
