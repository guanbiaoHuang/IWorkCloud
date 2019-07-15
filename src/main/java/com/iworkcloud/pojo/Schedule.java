package com.iworkcloud.pojo;


import java.util.Date;

//日程信息表
public class Schedule {

    //员工工号
    private int staffId;
    //日期
    private Date date;
    //日程信息
    private String content;

    public Schedule() {
    }

    public Schedule(int staffId, Date date, String content) {
        this.staffId = staffId;
        this.date = date;
        this.content = content;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
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
