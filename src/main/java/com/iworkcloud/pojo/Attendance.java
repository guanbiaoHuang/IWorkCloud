package com.iworkcloud.pojo;


import java.sql.Timestamp;

public class Attendance {

  private long id;
  private String name;
  private String staff;
  private java.sql.Timestamp time;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getStaff() {
    return staff;
  }

  public void setStaff(String staff) {
    this.staff = staff;
  }


  public java.sql.Timestamp getTime() {
    return time;
  }

  public void setTime(java.sql.Timestamp time) {
    this.time = time;
  }

  public Attendance(String name, String staff, Timestamp time) {
    this.name = name;
    this.staff = staff;
    this.time = time;
  }

  public Attendance(long id, String name, String staff, Timestamp time) {
    this.id = id;
    this.name = name;
    this.staff = staff;
    this.time = time;
  }
}
