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
@TableName("t_article")
public class Article implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 文章id
     */
      private Integer id;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 分区
     */
    private Integer typeId;

    /**
     * 标签
     */
    private String tips;

    /**
     * 文章是否被审核
     */
    private Byte isChecked;

    /**
     * 如果文章被审核，审核的username
     */
    private Integer checkerId;

    /**
     * 审核留言，80字以内
     */
    private String checkerMsg;

    /**
     * 提交时间
     */
    private LocalDateTime submitTime;

    /**
     * 审核通过时间
     */
    private LocalDateTime checkPassTime;

    /**
     * 点赞数
     */
    private Integer likes;

    /**
     * 浏览数
     */
    private Integer watches;

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

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public Byte getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(Byte isChecked) {
        this.isChecked = isChecked;
    }

    public Integer getCheckerId() {
        return checkerId;
    }

    public void setCheckerId(Integer checkerId) {
        this.checkerId = checkerId;
    }

    public String getCheckerMsg() {
        return checkerMsg;
    }

    public void setCheckerMsg(String checkerMsg) {
        this.checkerMsg = checkerMsg;
    }

    public LocalDateTime getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(LocalDateTime submitTime) {
        this.submitTime = submitTime;
    }

    public LocalDateTime getCheckPassTime() {
        return checkPassTime;
    }

    public void setCheckPassTime(LocalDateTime checkPassTime) {
        this.checkPassTime = checkPassTime;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getWatches() {
        return watches;
    }

    public void setWatches(Integer watches) {
        this.watches = watches;
    }

    @Override
    public String toString() {
        return "Article{" +
        "id = " + id +
        ", title = " + title +
        ", content = " + content +
        ", typeId = " + typeId +
        ", tips = " + tips +
        ", isChecked = " + isChecked +
        ", checkerId = " + checkerId+
        ", checkerMsg = " + checkerMsg +
        ", submitTime = " + submitTime +
        ", checkPassTime = " + checkPassTime +
        ", likes = " + likes +
        ", watches = " + watches +
        "}";
    }
}
