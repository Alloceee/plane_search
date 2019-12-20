package com.yws.plane.repository;

import com.yws.plane.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author AlmostLover
 */
@org.springframework.stereotype.Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {
    /**
     * 判断管理员密码是否正确
     * @return
     */
    Manager findByUsernameAndPassword(String username,String password);
}
