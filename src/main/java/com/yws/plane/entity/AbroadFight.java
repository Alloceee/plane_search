package com.yws.plane.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * 国外航班信息
 *
 * @author AlmostLover
 */
@Data
@Entity
@Table(name = "tb_abroad_fight")
public class AbroadFight implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 始发地
     */
    @Column(length = 10)
    private String startCity;

    /**
     * 目的地
     */
    @Column(length = 10)
    private String endCity;

    /**
     * 始发机场
     */
    @Column(length = 10)
    private String startAirport;

    /**
     * 目的机场
     */
    @Column(length = 10)
    private String endAirport;

    /**
     * 起飞时间
     */
    private Date startTime;

    /**
     * 抵达时间
     */
    private Date endTime;

    /**
     * 所属航班
     */
    private Integer planeId;


}
