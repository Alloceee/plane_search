package com.yws.plane.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class FightCompanyPlaneVO implements Serializable {
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
    private Date startTime;
    private Float price;

    @Excel(name = "公司头像", orderNum = "2")
    private String icon;
    /**
     * 公司名称
     */
    @Excel(name = "公司名称", orderNum = "1")
    private String name;
    /**
     * 详细介绍
     */
    @Excel(name = "详细介绍", orderNum = "3")
    private String description;

    /**
     * 所属公司
     */
    @TableField("company_id")
    private Integer companyId;
    /**
     * 客机机型
     */
    private String model;
    /**
     * 客机序号
     */
    private String number;
    /**
     * 客机型号,0小型，1中型，2大型
     */
    private Integer type;
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
