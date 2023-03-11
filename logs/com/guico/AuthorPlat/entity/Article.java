package com.guico.AuthorPlat.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 文章表
 * </p>
 *
 * @author guico
 * @since 2023-03-11
 */
@TableName("t_article")
@ApiModel(value = "Article对象", description = "文章表")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("发表用户ID")
    private Integer userId;

    @ApiModelProperty("分类ID")
    private Integer categoryId;

    @ApiModelProperty("是否隐藏(0:不隐藏，1:隐藏)")
    private Boolean isHidden;

    @ApiModelProperty("是否审核(0:未审核，1:审核)")
    private Boolean isReviewed;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Boolean getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(Boolean isHidden) {
        this.isHidden = isHidden;
    }

    public Boolean getIsReviewed() {
        return isReviewed;
    }

    public void setIsReviewed(Boolean isReviewed) {
        this.isReviewed = isReviewed;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Article{" +
        "id = " + id +
        ", title = " + title +
        ", content = " + content +
        ", userId = " + userId +
        ", categoryId = " + categoryId +
        ", isHidden = " + isHidden +
        ", isReviewed = " + isReviewed +
        ", createTime = " + createTime +
        ", updateTime = " + updateTime +
        "}";
    }
}