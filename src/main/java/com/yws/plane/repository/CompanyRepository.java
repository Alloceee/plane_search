package com.yws.plane.repository;

import com.yws.plane.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author AlmostLover
 */
public interface CompanyRepository extends JpaRepository<Company, Integer> {
//    @Query("select name,description from tb_company c where c.name like %?1% and c.description like %?1%")
//    List<Company> findByNameLikeOrDescriptionLike(String key);
}
