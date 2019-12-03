package com.yws.plane.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 用户进行短信提醒
 */
@Entity
@Data
@Table(name = "tb_message")
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(20) comment '手机号码'")
    private String phone;

    @Column(columnDefinition = "varchar(20) comment '邮箱'")
    private String email;

    @Column(nullable = false,columnDefinition = "bigint(255) comment '航班Id'")
    private Long plane_id;
}
