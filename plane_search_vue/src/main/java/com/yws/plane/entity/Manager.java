package com.yws.plane.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 管理员信息表
 *
 * @author AlmostLover
 */
@Data
@Entity
@Table(name = "tb_manager")
public class Manager implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String username;

    @Column(length = 32, nullable = false)
    private String password;
}
