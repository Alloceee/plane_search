package com.baomidou.springboot.model;

import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yewenshu123
 * @since 2019-12-24
 */
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getPlaneId() {
        return planeId;
    }

    public void setPlaneId(Long planeId) {
        this.planeId = planeId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Message{" +
        ", id=" + id +
        ", phone=" + phone +
        ", planeId=" + planeId +
        ", email=" + email +
        ", type=" + type +
        "}";
    }
}
