package com.iworkcloud.pojo;

public class BillMonthCount {

    private int month;
    private double monthCount;
    private String tag;


    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getMonthCount() {
        return monthCount;
    }

    public void setMonthCount(double monthCount) {
        this.monthCount = monthCount;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "BillMonthCount{" +
                "month=" + month +
                ", monthCount=" + monthCount +
                ", tag='" + tag + '\'' +
                '}';
    }
}


