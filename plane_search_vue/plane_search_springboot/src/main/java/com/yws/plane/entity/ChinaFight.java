package com.yws.plane.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
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
@Entity
@TableName("tb_china_fight")
public class ChinaFight implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @TableId(value = "fid", type = IdType.AUTO)
    private Long fid;
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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    /**
     * 所属客机
     */
    @TableField("plane_id")
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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    /**
     * 价格
     */
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
