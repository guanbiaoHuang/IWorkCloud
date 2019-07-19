package com.iworkcloud.pojo;


import java.io.Serializable;
import java.sql.Timestamp;

public class Activity implements Serializable {

  private long id;
  private java.sql.Timestamp time;
  private String title;
  private String content;
  private String tag;

  public Activity() {
  }


  public Activity(long id, Timestamp time, String title, String content, String tag) {
    this.id = id;
    this.time = time;
    this.title = title;
    this.content = content;
    this.tag = tag;
  }

  public Activity(Timestamp time, String title, String content, String tag) {
    this.time = time;
    this.title = title;
    this.content = content;
    this.tag = tag;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public java.sql.Timestamp getTime() {
    return time;
  }

  public void setTime(java.sql.Timestamp time) {
    this.time = time;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

}
