package com.yws.plane.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * @Author: yewenshu https://github.com/Alloceee
 * @Date: 2019/11/24 18:21
 * @Project: plane_search
 */
@Data
public class Fight implements Serializable {

    /**
     * 始发地
     */
    private String startCity;

    /**
     * 目的地
     */
    private String endCity;

    /**
     * 起飞时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String startTime;

    /**
     * 抵达时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String endTime;

    /**
     * 航班类型 0 国内 1国外
     */
    private Integer type;

}
