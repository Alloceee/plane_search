package com.yws.plane.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tb_log")
public class Log implements Serializable {
    @Id
    private Long id;

    private String ip;


}
