package com.yws.plane.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Data
@Table(name = "tb_log")
public class Log implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,columnDefinition = "varchar(255) comment '用户请求IP'")
    private String ip;

    @Column(nullable = false,columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP comment '请求时间'")
    private Date requestTime;

}
