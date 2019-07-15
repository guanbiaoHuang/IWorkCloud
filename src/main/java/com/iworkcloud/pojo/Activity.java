package com.iworkcloud.pojo;

import java.util.Date;

//活动表
public class Activity {

    //活动名称
    private String title;
    //开始时间
    private Date dateStart;
    //结束时间
    private Date dateEnd;
    //活动内容
    private String content;

    public Activity() {
    }

    public Activity(String title, Date dateStart, Date dateEnd, String content) {
        this.title = title;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
