package com.yws.plane.service.home.impl;

import com.yws.plane.entity.AbroadFight;
import com.yws.plane.entity.ChinaFight;
import com.yws.plane.repository.AbroadFightRepository;
import com.yws.plane.repository.ChinaFightRepository;
import com.yws.plane.service.home.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private ChinaFightRepository chinaFightRepository;
    @Autowired
    private AbroadFightRepository abroadFightRepository;

    @Override
    public List<ChinaFight> china_plane(String startCity, String endCity) {
        return chinaFightRepository.findTop12ByStartCityAndEndCityOrderByStartTime(startCity, endCity);
    }

    @Override
    public String search(String startCity, String endCity, String startTime, String endTime) {
        return null;
    }

    @Override
    public List<AbroadFight> abroad_plane(String startCity, String endCity) {
        return abroadFightRepository.findTop12ByStartCityAndEndCityOrderByStartTime(startCity, endCity);
    }
}
