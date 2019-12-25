package com.yws.plane.entity;

import com.baomidou.mybatisplus.enums.IdType;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yewenshu123
 * @since 2019-12-23
 */
@Data
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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date startTime;
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
