package com.iworkcloud.pojo;


import java.util.Date;

//会议表
public class Meeting {

    //会议名称
    private String title;
    //开会时间
    private Date dateStart;
    //参加部门
    private String department;

    public Meeting() {
    }

    public Meeting(String title, Date dateStart, String department) {
        this.title = title;
        this.dateStart = dateStart;
        this.department = department;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
