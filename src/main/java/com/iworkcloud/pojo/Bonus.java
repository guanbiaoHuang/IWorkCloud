package com.iworkcloud.pojo;

import java.util.Date;

//奖金表
public class Bonus {

    //发放人
    private  int staffId;
    //奖金
    private float bonus;
    //补贴
    private float subsidy;
    //发放日期
    private Date date;

    public Bonus() {
    }

    public Bonus(int staffId, float bonus, float subsidy, Date date) {
        this.staffId = staffId;
        this.bonus = bonus;
        this.subsidy = subsidy;
        this.date = date;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public float getBonus() {
        return bonus;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }

    public float getSubsidy() {
        return subsidy;
    }

    public void setSubsidy(float subsidy) {
        this.subsidy = subsidy;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
