package com.yws.plane.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 客机信息表
 *
 * @author AlmostLover
 */
@Data
@Entity
@Table(name = "tb_plane")
public class Plane implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * 客机序号
     */
    @Column(length = 6,nullable = false)
    private String number;

    /**
     * 客机型号,0小型，1中型，2大型
     */
    @Column(length = 1,nullable = false)
    private Integer type;

    /**
     * 客机机型
     */
    @Column(length = 5,nullable = false)
    private String model;

    /**
     * 所属公司
     */
    @Column(nullable = false)
    private Integer companyId;

}
