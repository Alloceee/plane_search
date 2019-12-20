package com.yws.plane.repository;

import com.yws.plane.entity.ChinaFight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChinaFightRepository extends JpaRepository<ChinaFight, Long> {

    List<ChinaFight> findTop12ByStartCityAndEndCityOrderByStartTime(String startCity, String endCity);

    List<ChinaFight> findByStartCityLikeOrEndCityLikeOrStartAirportLikeOrEndAirportOrStartTimeOrEndTimeOrPrice(String key1, String key2, String key3, String key4, String key5, String key6, String kry7);

    List<ChinaFight> findByStartCityAndEndCityAndStartTimeLikeAndEndTimeLike(String startCity,String endCity,String startTime,String endTime);
}
