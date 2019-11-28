package com.yws.plane.repository;

import com.yws.plane.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailRepository extends JpaRepository<Email,Long> {
}
