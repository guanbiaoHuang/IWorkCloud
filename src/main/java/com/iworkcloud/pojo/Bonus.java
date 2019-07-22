package com.iworkcloud.pojo;


import java.sql.Timestamp;

public class Bonus {

  private String id;
  private String staff;
  private java.sql.Timestamp time;
  private float mount;
  private String tag;

  public Bonus() {
  }

  public Bonus(String id, String staff, Timestamp time, String tag) {
    this.id = id;
    this.staff = staff;
    this.time = time;
    this.tag = tag;
  }

  public float getMount() {
    return mount;
  }

  public void setMount(float mount) {
    this.mount = mount;
  }
  public String getId() {
    return id;
  }

  public void setId(String id) {
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


  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

}
