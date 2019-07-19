package com.iworkcloud.pojo;


import java.io.Serializable;
import java.sql.Date;

public class Attendance implements Serializable {

  private long id;
  private String staff;
  private java.sql.Date date;

  public Attendance() {
  }

  public Attendance(long id, String staff, Date date) {
    this.id = id;
    this.staff = staff;
    this.date = date;
  }

  public Attendance(String staff, Date date) {
    this.staff = staff;
    this.date = date;
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


  public java.sql.Date getDate() {
    return date;
  }

  public void setDate(java.sql.Date date) {
    this.date = date;
  }

}
