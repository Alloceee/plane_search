package com.yws.plane.service.home.impl;

import com.yws.plane.entity.AbroadFight;
import com.yws.plane.entity.ChinaFight;
import com.yws.plane.entity.Fight;
import com.yws.plane.repository.AbroadFightRepository;
import com.yws.plane.repository.ChinaFightRepository;
import com.yws.plane.service.home.SearchService;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author AlmostLover
 */
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
    public <T> List<T> search(Fight fight) {
        Integer type = fight.getType();
        String startCity = fight.getStartCity();
        String endCity = fight.getEndCity();
        String startTime = fight.getStartTime();
        String endTime = fight.getEndTime();
        if (type == 0) {
            return (List<T>) chinaFightRepository.findByStartCityAndEndCityAndStartTimeLikeAndEndTimeLike(startCity, endCity, startTime, endTime);
        } else {
            return (List<T>) abroadFightRepository.findByStartCityAndEndCityAndStartTimeLikeAndEndTimeLike(startCity, endCity, startTime, endTime);
        }
    }

    @Override
    public List<AbroadFight> abroad_plane(String startCity, String endCity) {
        return abroadFightRepository.findTop12ByStartCityAndEndCityOrderByStartTime(startCity, endCity);
    }
}
