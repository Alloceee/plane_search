package com.yws.plane.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Excel(name = "id")
    private Integer id;

    /**
     * 客机序号
     */
    @Excel(name = "客机序号")
    @Column(nullable = false, columnDefinition = "varchar(6) comment '客机序号'")
    private String number;

    /**
     * 客机型号,0小型，1中型，2大型
     */
    @Excel(name = "客机型号")
    @Column(nullable = false, columnDefinition = "int(1) comment '客机型号,0小型，1中型，2大型'")
    private Integer type;

    /**
     * 客机机型
     */
    @Excel(name = "客机机型")
    @Column(nullable = false, columnDefinition = "varchar(5) comment '客机机型'")
    private String model;

    /**
     * 所属公司
     */
    @Excel(name = "所属公司")
    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false, columnDefinition = "int(255) comment '所属公司'")
    private Company company;

}
