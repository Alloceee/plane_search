package com.yws.plane.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 始发地
     */
    @Column(nullable = false, columnDefinition = "varchar(10) comment '始发地'")
    private String startCity;

    /**
     * 目的地
     */
    @Column(nullable = false, columnDefinition = "varchar(10) comment '目的地'")
    private String endCity;

    /**
     * 始发机场
     */
    @Column(nullable = false, columnDefinition = "varchar(10) comment '始发机场'")
    private String startAirport;

    /**
     * 目的机场
     */
    @Column(nullable = false, columnDefinition = "varchar(10) comment '目的机场'")
    private String endAirport;

    /**
     * 起飞时间
     */
    @Column(nullable = false, columnDefinition = "datetime comment '起飞时间'")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /**
     * 抵达时间
     */
    @Column(nullable = false, columnDefinition = "datetime comment '抵达时间'")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    /**
     * 所属航班
     */
    @Column(nullable = false, columnDefinition = "int(255) comment '所属航班'")
    private Integer planeId;

    @Column(nullable = false, columnDefinition = "float(10, 2) comment '价格'")
    private Float price;

    public String getStartTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(this.startTime);
    }

    public String getEndTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(this.endTime);
    }

}
