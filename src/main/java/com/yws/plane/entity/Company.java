package com.yws.plane.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 航空公司
 *
 * @author AlmostLover
 */
@Data
@Entity
@Table(name = "tb_company")
public class Company implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 公司名称
     */
    @Column(nullable = false, columnDefinition = "varchar(10) comment '公司名称'")
    private String name;

    /**
     * 公司头像
     */
    @Column(columnDefinition = "varchar(50) comment '公司头像'")
    private String icon;

    /**
     * 详细介绍
     */
    @Column(columnDefinition = "text comment '详细介绍'")
    private String description;

}
