package com.iworkcloud.pojo;

import java.util.Date;

//缺勤表
public class Absence {

    //员工工号
    private int staffId;
    //缺席日期
    private Date date;
    //是否请假
    private String isRatified;

    public Absence() {
    }

    public Absence(int staffId, Date date, String isRatified) {
        this.staffId = staffId;
        this.date = date;
        this.isRatified = isRatified;
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

    public String isRatified() {
        return isRatified;
    }

    public void setRatified(String ratified) {
        isRatified = ratified;
    }
}
