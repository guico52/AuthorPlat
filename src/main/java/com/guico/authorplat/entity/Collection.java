package com.guico.authorplat.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("t_collection")
public class Collection implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 收藏夹id
     */
      private Integer id;

    /**
     * 收藏夹名称
     */
    private String name;

    /**
     * 收藏夹主人username
     */
    private String ownerUsername;

    /**
     * 收藏夹创建时间
     */
    private LocalDateTime createTime;

    /**
     * 是否为默认收藏夹
     */
    private Boolean isDefault;

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

    public String getOwnerUsername() {
        return ownerUsername;
    }

    public void setOwnerUsername(String ownerUsername) {
        this.ownerUsername = ownerUsername;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    @Override
    public String toString() {
        return "Collection{" +
        "id = " + id +
        ", name = " + name +
        ", ownerUsername = " + ownerUsername +
        ", createTime = " + createTime +
        "}";
    }
}
