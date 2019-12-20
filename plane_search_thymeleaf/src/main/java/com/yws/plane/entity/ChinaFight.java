package com.yws.plane.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    @Excel(name = "id", width = 25, orderNum = "0")
    private Long id;

    /**
     * 始发地
     */
    @Excel(name = "始发地", width = 25, orderNum = "1")
    @Column(nullable = false, columnDefinition = "varchar(10) comment '始发地'")
    private String startCity;

    /**
     * 目的地
     */
    @Excel(name = "目的地", width = 25, orderNum = "2")
    @Column(nullable = false, columnDefinition = "varchar(10) comment '目的地'")
    private String endCity;

    /**
     * 始发机场
     */
    @Excel(name = "始发机场", width = 25, orderNum = "3")
    @Column(nullable = false, columnDefinition = "varchar(10) comment '始发机场'")
    private String startAirport;

    /**
     * 目的机场
     */
    @Excel(name = "目的机场", orderNum = "4")
    @Column(nullable = false, columnDefinition = "varchar(10) comment '目的机场'")
    private String endAirport;

    /**
     * 起飞时间
     */
    @Column(nullable = false, columnDefinition = "datetime comment '起飞时间'")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "起飞时间", orderNum = "5", importFormat = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /**
     * 抵达时间
     */
    @Column(nullable = false, columnDefinition = "datetime comment '抵达时间'")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "抵达时间", orderNum = "6", importFormat = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    /**
     * 客机ID
     */
    @ManyToOne
    @JoinColumn(name = "plane_id", nullable = false, columnDefinition = "int(255) comment '客机ID'")
    @Excel(name = "客机ID", orderNum = "7")
    private Plane plane;

    /**
     * 价格
     */
    @Excel(name = "价格", orderNum = "8")
    @Column(nullable = false, columnDefinition = "float(10, 2) comment '价格'")
    private Float price;

    public String getStartTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (this.startTime == null) {
            return "";
        }
        return sdf.format(this.startTime);
    }

    public String getEndTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (this.endTime == null) {
            return "";
        }
        return sdf.format(this.endTime);
    }

}
