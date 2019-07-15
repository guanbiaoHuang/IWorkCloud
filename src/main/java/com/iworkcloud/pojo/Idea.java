package com.iworkcloud.pojo;

import java.util.Date;


//创意表
public class Idea {

    //员工ID
    private int staffId;
    //创意名称
    private String title;
    //发表时间
    private Date date;
    //创意内容
    private String content;

    public Idea() {
    }

    public Idea(int staffId, String title, Date date, String content) {
        this.staffId = staffId;
        this.title = title;
        this.date = date;
        this.content = content;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

