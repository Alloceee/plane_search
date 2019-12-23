package com.yws.plane.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
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
@TableName("tb_news")
public class News implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 新闻内容
     */
    private String content;
    /**
     * 新闻时间
     */
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
    private String notifyPlane;
    /**
     * 状态
     */
    private Integer status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotifyContent() {
        return notifyContent;
    }

    public void setNotifyContent(String notifyContent) {
        this.notifyContent = notifyContent;
    }

    public String getNotifyPlane() {
        return notifyPlane;
    }

    public void setNotifyPlane(String notifyPlane) {
        this.notifyPlane = notifyPlane;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "News{" +
        ", id=" + id +
        ", content=" + content +
        ", createTime=" + createTime +
        ", title=" + title +
        ", notifyContent=" + notifyContent +
        ", notifyPlane=" + notifyPlane +
        ", status=" + status +
        "}";
    }
}
