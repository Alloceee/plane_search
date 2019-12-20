package com.yws.plane.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "tb_email")
@Data
public class Email implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 接收人邮箱(多个逗号分开)
     */
    @Column(name = "receive_email", nullable = false, length = 500)
    private String receiveEmail;

    /**
     * 主题
     */
    @Column(name = "subject", nullable = false, length = 100)
    private String subject;

    /**
     * 发送内容
     */
    @Column(nullable = false, columnDefinition = "text comment '详细介绍'")
    private String content;

    /**
     * 模板
     */
    @Column(name = "template", nullable = false, length = 100)
    private String template;

    /**
     * 发送时间
     */
    @Column(name = "send_time", nullable = false, length = 19)
    private Date sendTime;


    public String[] getEmail() {
        return receiveEmail.split(",");
    }

}
