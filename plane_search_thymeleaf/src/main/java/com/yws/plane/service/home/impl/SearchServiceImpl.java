package com.yws.plane.service.home.impl;

import com.yws.plane.entity.AbroadFight;
import com.yws.plane.entity.ChinaFight;
import com.yws.plane.entity.Fight;
import com.yws.plane.repository.AbroadFightRepository;
import com.yws.plane.repository.ChinaFightRepository;
import com.yws.plane.service.home.SearchService;
import com.yws.plane.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private ChinaFightRepository chinaFightRepository;
    @Autowired
    private AbroadFightRepository abroadFightRepository;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<ChinaFight> china_plane(String startCity, String endCity) {
        return chinaFightRepository.findTop12ByStartCityAndEndCityOrderByStartTime(startCity, endCity);
    }

    @Override
    public List<ChinaFight> search_china(Fight fight) {
        String startCity = fight.getStartCity();
        String endCity = fight.getEndCity();
        String startTime = fight.getStartTime();
        String endTime = fight.getEndTime();
//            list = redisUtil.lGet(startCity+endCity,0,-1);
//            if(list.isEmpty()){
        List<ChinaFight> chinaFights = chinaFightRepository.findByStartCityAndEndCityAndStartTimeLikeAndEndTimeLike(startCity, endCity, startTime, endTime);
//               redisUtil.lSet(startCity+endCity,list);
        return chinaFights;
    }

    @Override
    public List<AbroadFight> search_abroad(Fight fight) {
        String startCity = fight.getStartCity();
        String endCity = fight.getEndCity();
        String startTime = fight.getStartTime();
        String endTime = fight.getEndTime();
//            list = redisUtil.lGet(startCity+endCity,0,-1);
//            if(list.isEmpty()){
        List<AbroadFight> abroadFights = abroadFightRepository.findByStartCityAndEndCityAndStartTimeLikeAndEndTimeLike(startCity, endCity, startTime, endTime);
//               redisUtil.lSet(startCity+endCity,list);
        return abroadFights;
    }

    @Override
    public List<AbroadFight> abroad_plane(String startCity, String endCity) {
        return abroadFightRepository.findTop12ByStartCityAndEndCityOrderByStartTime(startCity, endCity);
    }
}
