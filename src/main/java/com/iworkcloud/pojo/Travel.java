package com.iworkcloud.pojo;


import java.util.Date;

//出差信息表
public class Travel {

    //出差员工工号
    private int staffId;
    //开始日期
    private Date dateStart;
    //结束日期
    private Date dateEnd;

    public Travel() {
    }

    public Travel(int staffId, Date dateStart, Date dateEnd) {
        this.staffId = staffId;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
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
}
