package com.yws.plane.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 热搜城市
 */
@Data
@Entity
@Table(name = "tb_hot_city")
public class HotCity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, columnDefinition = "datetime comment '开始时间'")
    private Date startTime;

    @Column(nullable = false, columnDefinition = "datetime comment '结束时间'")
    private Date endTime;

    @Column(nullable = false, columnDefinition = "varchar(10) comment '搜索城市'")
    private String city;

    @Column(nullable = false, columnDefinition = "Integer(255) comment '搜索次数'")
    private Integer number;
}
