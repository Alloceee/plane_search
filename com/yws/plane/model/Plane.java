package com.yws.plane.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yewenshu123
 * @since 2019-12-23
 */
@TableName("tb_plane")
public class Plane implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 所属公司
     */
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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Plane{" +
        ", id=" + id +
        ", companyId=" + companyId +
        ", model=" + model +
        ", number=" + number +
        ", type=" + type +
        "}";
    }
}
