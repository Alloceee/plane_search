package com.yws.plane.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

/**
 * 机场动态
 *
 * @author AlmostLover
 */
@Data
@Entity
@Table(name = "tb_news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 新闻标题
     */
    @Column(nullable = false, columnDefinition = "varchar(20) comment '新闻标题'")
    private String title;

    /**
     * 新闻内容
     */
    @Column(nullable = false, columnDefinition = "text comment '新闻内容'")
    private String content;

    /**
     * 新闻时间
     */
    @Column(nullable = false, columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP comment '新闻时间'")
    private Date createTime;

    /**
     * 状态
     */
    @Column(nullable = false,columnDefinition = "int(1) comment '状态'")
    private Integer status;

    /**
     * 通知航班
     */
    @Column(columnDefinition = "varchar(10) comment '通知航班'")
    private Long notify_plane;

    /**
     * 通知内容
     */
    @Column(columnDefinition = "text comment '通知内容'")
    private String notify_content;
}
