package com.yws.plane.repository;

import com.yws.plane.entity.AbroadFight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AbroadFightRepository extends JpaRepository<AbroadFight, Long> {

    List<AbroadFight> findTop12ByStartCityAndEndCityOrderByStartTime(String startCity, String endCity);

    List<AbroadFight> findByStartCityLikeOrEndCityLikeOrStartAirportLikeOrEndAirportOrStartTimeOrEndTimeOrPrice(String key1, String key2, String key3,String key4,String key5,String key6,String kry7);

    @Query(value = "select a from AbroadFight a where start_city= ?1 and end_city=?2 and start_time > ?3 and end_time < ?4 ORDER BY start_time DESC")
    List<AbroadFight> findByStartCityAndEndCityAndStartTimeLikeAndEndTimeLike(String startCity, String endCity, String startTime, String endTime);

}
