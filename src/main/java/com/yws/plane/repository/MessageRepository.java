package com.yws.plane.repository;

import com.yws.plane.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: yewenshu https://github.com/Alloceee
 * @Date: 2019/11/10 15:30
 * @Project: plane_search
 */
@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
