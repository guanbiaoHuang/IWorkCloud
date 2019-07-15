package com.iworkcloud.pojo;


import java.util.Date;


//记事本表
public class Note {

    //记事人工号
    private int staffId;
    //记事标题
    private String title;
    //记事日期
    private Date date;
    //记事内容
    private String content;

    public Note() {
    }

    public Note(int staffId, String title, Date date, String content) {
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
