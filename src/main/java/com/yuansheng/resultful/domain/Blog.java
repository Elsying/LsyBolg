package com.yuansheng.resultful.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Blog {
    private Integer id;

    private String title;//博客题目

    private String summary;//博客摘要'

//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date releasedate;//发布日期

    private Integer clickhit;//评论次数

    private Integer replyhit;//回复次数

    private String content;//博客内容

    private String keyword;//关键字

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
        this.title = title == null ? null : title.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public Date getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(Date releasedate) {
        this.releasedate = releasedate;
    }

    public Integer getClickhit() {
        return clickhit;
    }

    public void setClickhit(Integer clickhit) {
        this.clickhit = clickhit;
    }

    public Integer getReplyhit() {
        return replyhit;
    }

    public void setReplyhit(Integer replyhit) {
        this.replyhit = replyhit;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}