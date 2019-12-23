package com.yws.plane.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yewenshu123
 * @since 2019-12-21
 */
@TableName("tb_company")
@Data
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    @Excel(name = "id", orderNum = "0")
    private Integer id;
    /**
     * 公司头像
     */
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
}
