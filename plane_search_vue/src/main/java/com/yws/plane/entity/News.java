package com.yws.plane.entity;

import com.baomidou.mybatisplus.enums.IdType;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
@TableName("tb_news")
public class News implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 计划开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date planStartTime;
    /**
     * 计划结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date planEndTime;
    /**
     * 新闻时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date createTime;
    /**
     * 新闻标题
     */
    private String title;
    /**
     * 通知内容
     */
    private String notifyContent;
    /**
     * 通知航班
     */
    private String notifyFight;
    /**
     * 状态
     */
    private Integer status;
    public String getPlaneStartTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (this.planStartTime == null) {
            return "";
        }
        return sdf.format(this.planStartTime);
    }

    public String getPlaneEndTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (this.planEndTime == null) {
            return "";
        }
        return sdf.format(this.planEndTime);
    }

}
