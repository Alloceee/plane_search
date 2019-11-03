package com.yws.plane.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 航空公司
 * @author AlmostLover
 */
@Data
@Entity
@Table(name = "tb_company")
public class Company implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * 公司名称
     */
    @Column(length = 10,nullable = false)
    private String name;

    /**
     * 公司头像
     */
    private String icon;

}
