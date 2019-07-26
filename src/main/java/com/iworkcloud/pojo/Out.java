package com.iworkcloud.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.sql.Date;

public class Out implements Serializable {

    private long id;
    private String staff;
    private java.sql.Date dateStart;
    private java.sql.Date dateEnd;


    public Out() {
    }


    public Out(long id, String staff, Date dateStart, Date dateEnd) {
        this.id = id;
        this.staff = staff;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public Out(String staff, Date dateStart, Date dateEnd) {
        this.staff = staff;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }


    public java.sql.Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(java.sql.Date dateStart) {
        this.dateStart = dateStart;
    }


    public java.sql.Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(java.sql.Date dateEnd) {
        this.dateEnd = dateEnd;
    }

}
