package com.yws.plane.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Author: yewenshu https://github.com/Alloceee
 * @Date: 2019/11/10 20:34
 * @Project: plane_search
 */
@Data
//@Document(indexName = "tb_com", type = "docs", shards = 1, replicas = 0)
public class Com {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 公司名称
     */
//    @Field(type = FieldType.Text, analyzer = "ik_max_word")
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
//    @Field(type = FieldType.Keyword)
    @Column(columnDefinition = "text comment '详细介绍'")
    private String description;
}
