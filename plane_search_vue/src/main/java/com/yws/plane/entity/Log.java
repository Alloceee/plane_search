package com.yws.plane.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * 用户日志表
 *
 * @author AlmostLover
 */
@Entity
@Data
@Table(name = "tb_log")
public class Log implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 请求ip
     */
    @Column(nullable = false, columnDefinition = "varchar(255) comment '用户请求IP'")
    private String ip;

    /**
     * 请求方法参数
     */
    @Column(nullable = false, columnDefinition = "varchar(255) comment '请求方法参数'")
    private String args;

    /**
     * 请求路径
     */
    @Column(nullable = false, columnDefinition = "varchar(100)  comment '请求路径'")
    private String url;
    /**
     * 请求时间
     */
    @Column(columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP comment '请求时间'")
    private Date requestTime;
}
