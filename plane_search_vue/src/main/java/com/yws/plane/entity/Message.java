package com.yws.plane.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yewenshu123
 * @since 2019-12-24
 */
@Data
@TableName("tb_message")
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 航班Id
     */
    private Long planeId;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 发送类型（0验证码，1航班起飞提醒，2航班动态更新提醒）
     */
    private Integer type;


}
