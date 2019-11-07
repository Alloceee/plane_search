package com.yws.plane.repository;

import com.yws.plane.entity.AbroadFight;
import com.yws.plane.entity.ChinaFight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AbroadFightRepository extends JpaRepository<AbroadFight, Integer> {

    List<AbroadFight> findTop12ByStartCityAndEndCityOrderByStartTime(String startCity, String endCity);

}
