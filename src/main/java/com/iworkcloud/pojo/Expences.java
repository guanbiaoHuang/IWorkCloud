package com.iworkcloud.pojo;

import java.util.Date;


//支出表
public class Expences {

    //项目编号
    private int projectId;
    //支出
    private float expencess;
    //日期
    private Date date;
    //详细
    private String detail;

    public Expences() {
    }

    public Expences(int projectId, float expencess, Date date, String detail) {
        this.projectId = projectId;
        this.expencess = expencess;
        this.date = date;
        this.detail = detail;
    }


    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public float getExpencess() {
        return expencess;
    }

    public void setExpencess(float expencess) {
        this.expencess = expencess;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
