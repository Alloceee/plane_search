package com.yws.plane.entity;

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
 * @since 2019-12-23
 */
@Data
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

}
