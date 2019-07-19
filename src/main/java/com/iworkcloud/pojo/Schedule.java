package com.iworkcloud.pojo;


import java.io.Serializable;
import java.sql.Timestamp;

public class Schedule implements Serializable {

  private long id;
  private String staff;
  private java.sql.Timestamp time;
  private String content;


  public Schedule() {
  }


  public Schedule(long id, String staff, Timestamp time, String content) {
    this.id = id;
    this.staff = staff;
    this.time = time;
    this.content = content;
  }

  public Schedule(String staff, Timestamp time, String content) {
    this.staff = staff;
    this.time = time;
    this.content = content;
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


  public java.sql.Timestamp getTime() {
    return time;
  }

  public void setTime(java.sql.Timestamp time) {
    this.time = time;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

}
