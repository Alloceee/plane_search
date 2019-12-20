package com.yws.plane.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * 错误日志表
 *
 * @Author: yewenshu https://github.com/Alloceee
 * @Date: 2019/11/10 21:09
 * @Project: plane_search
 */
@Entity
@Data
@Table(name = "tb_error")
public class Error implements Serializable {
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
    /**
     * 错误信息
     */
    @Column(nullable = false, columnDefinition = "varchar(255)  comment '错误信息'")
    private String errorMessage;
}
