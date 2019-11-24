package com.yws.plane.repository;

import com.yws.plane.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author AlmostLover
 */
public interface CompanyRepository extends JpaRepository<Company, Integer> {
    List<Company> findByNameLikeOrDescriptionLike(String key1,String key2);
}
