package com.yws.plane.repository;

import com.yws.plane.entity.Company;
import com.yws.plane.entity.Plane;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaneRepository extends JpaRepository<Plane, Integer> {

    List<Plane> findByCompany_IdLikeOrNumberLikeOrModelLike(String key1, String key2,String key3);

    List<Plane> findByCompany_Id(Integer companyId);
}
