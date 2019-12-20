package com.yws.plane.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 定时器
 */
@Data
@Entity
@Table(name = "tb_task")
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 定时器内容
     */
    private String content;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 循环周期
     */
    private String cycle;

    /**
     * 是否启动
     */
    private Integer isStart;
}
