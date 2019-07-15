package com.iworkcloud.pojo;


import java.util.Date;

//请假表
public class Leave {

    //请假员工ID
    private int staffId;
    //请假原因
    private String reason;
    //开始日期
    private Date dateStart;
    //结束日期
    private Date dateEnd;
    //是否批准
    private String ratify;


    public Leave() {
    }

    public Leave(int staffId, String reason, Date dateStart, Date dateEnd, String ratify) {
        this.staffId = staffId;
        this.reason = reason;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.ratify = ratify;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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

    public String getRatify() {
        return ratify;
    }

    public void setRatify(String ratify) {
        this.ratify = ratify;
    }
}
