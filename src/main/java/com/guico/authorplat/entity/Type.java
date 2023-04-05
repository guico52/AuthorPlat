package com.guico.authorplat.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author guico
 * @since 2023-03-16
 */
@TableName("t_type")
public class Type implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

      private Integer id;

    /**
     * 分区名
     */
    private String name;

    /**
     * 创建者username
     */
    private String ownerId;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 分区的父分区id
     */
    private Integer parentId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "Type{" +
        "id = " + id +
        ", name = " + name +
        ", ownerId = " + ownerId +
        ", createdTime = " + createdTime +
        ", parentId = " + parentId +
        "}";
    }
}
