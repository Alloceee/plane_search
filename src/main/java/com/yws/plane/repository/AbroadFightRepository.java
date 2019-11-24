package com.yws.plane.repository;

import com.yws.plane.entity.AbroadFight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AbroadFightRepository extends JpaRepository<AbroadFight, Long> {

    List<AbroadFight> findTop12ByStartCityAndEndCityOrderByStartTime(String startCity, String endCity);

    List<AbroadFight> findByStartCityLikeOrEndCityLikeOrStartAirportLikeOrEndAirportOrStartTimeOrEndTimeOrPrice(String key1, String key2, String key3,String key4,String key5,String key6,String kry7);

    List<AbroadFight> findByStartCityAndEndCityAndStartTimeLikeAndEndTimeLike(String startCity,String endCity,String startTime,String endTime);

}
