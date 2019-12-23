package com.yws.plane.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
//import org.springframework.data.elasticsearch.annotations.Document;
//import org.springframework.data.elasticsearch.annotations.Field;
//import org.springframework.data.elasticsearch.annotations.FieldType;

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
    @Excel(name = "id", orderNum = "0")
    private Integer id;

    /**
     * 公司名称
     */
//    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    @Column(nullable = false, columnDefinition = "varchar(10) comment '公司名称'")
    @Excel(name = "公司名称", orderNum = "1")
    private String name;

    /**
     * 公司头像
     */
    @Column(columnDefinition = "varchar(50) comment '公司头像'")
    @Excel(name = "公司头像", orderNum = "2")
    private String icon;

    /**
     * 详细介绍
     */
//    @Field(type = FieldType.Keyword)
    @Column(columnDefinition = "text comment '详细介绍'")
    @Excel(name = "详细介绍", orderNum = "3")
    private String description;

}
