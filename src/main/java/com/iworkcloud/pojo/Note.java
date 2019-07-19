package com.iworkcloud.pojo;


import java.io.Serializable;
import java.sql.Timestamp;

public class Note implements Serializable {

  private long id;
  private String staff;
  private String title;
  private java.sql.Timestamp time;
  private String content;


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


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
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

  public Note(long id, String staff, String title, Timestamp time, String content) {
    this.id = id;
    this.staff = staff;
    this.title = title;
    this.time = time;
    this.content = content;
  }

  public Note(String staff, String title, Timestamp time, String content) {
    this.staff = staff;
    this.title = title;
    this.time = time;
    this.content = content;
  }
}
