package com.yws.plane.entity;

import lombok.Data;

@Data
public class PageEntity {
    /**
     * 分页大小
     */
    private Integer pageSize;
    /**
     * 当前页数
     */
    private Integer currentPage;
    /**
     * 查询关键字
     */
    private String key;
    /**
     * 查询起始城市
     */
    private String startCity;
    private String endCity;
    /**
     * 排序字段
     */
    private String orderByField;
}