package com.yws.plane.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * 国内航班信息
 *
 * @author AlmostLover
 */
@Data
@Entity
@Table(name = "tb_china_fight")
public class ChinaFight implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 始发地
     */
    @Column(length = 10,nullable = false)
    private String startCity;

    /**
     * 目的地
     */
    @Column(length = 10,nullable = false)
    private String endCity;

    /**
     * 始发机场
     */
    @Column(length = 10,nullable = false)
    private String startAirport;

    /**
     * 目的机场
     */
    @Column(length = 10,nullable = false)
    private String endAirport;

    /**
     * 起飞时间
     */
    @Column(nullable = false)
    private Date startTime;

    /**
     * 抵达时间
     */
    @Column(nullable = false)
    private Date endTime;

    /**
     * 所属航班
     */
    @Column(nullable = false)
    private Integer planeId;


}
