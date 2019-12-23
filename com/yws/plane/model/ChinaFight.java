package com.yws.plane.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yewenshu123
 * @since 2019-12-23
 */
@TableName("tb_china_fight")
public class ChinaFight implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 目的机场
     */
    private String endAirport;
    /**
     * 目的地
     */
    private String endCity;
    /**
     * 抵达时间
     */
    private Date endTime;
    /**
     * 所属航班
     */
    private Integer planeId;
    /**
     * 始发机场
     */
    private String startAirport;
    /**
     * 始发地
     */
    private String startCity;
    /**
     * 起飞时间
     */
    private Date startTime;
    private Float price;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEndAirport() {
        return endAirport;
    }

    public void setEndAirport(String endAirport) {
        this.endAirport = endAirport;
    }

    public String getEndCity() {
        return endCity;
    }

    public void setEndCity(String endCity) {
        this.endCity = endCity;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getPlaneId() {
        return planeId;
    }

    public void setPlaneId(Integer planeId) {
        this.planeId = planeId;
    }

    public String getStartAirport() {
        return startAirport;
    }

    public void setStartAirport(String startAirport) {
        this.startAirport = startAirport;
    }

    public String getStartCity() {
        return startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ChinaFight{" +
        ", id=" + id +
        ", endAirport=" + endAirport +
        ", endCity=" + endCity +
        ", endTime=" + endTime +
        ", planeId=" + planeId +
        ", startAirport=" + startAirport +
        ", startCity=" + startCity +
        ", startTime=" + startTime +
        ", price=" + price +
        "}";
    }
}
