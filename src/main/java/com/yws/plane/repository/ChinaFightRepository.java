package com.yws.plane.repository;

import com.yws.plane.entity.ChinaFight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChinaFightRepository extends JpaRepository<ChinaFight, Long> {

    List<ChinaFight> findTop12ByStartCityAndEndCityOrderByStartTime(String startCity, String endCity);

}
