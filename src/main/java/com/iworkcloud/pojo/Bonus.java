package com.iworkcloud.pojo;
import java.sql.Timestamp;

public class Bonus {

  private String id;
  private String staff;
  private double mount;
  private java.sql.Timestamp time;
  private String tag;

  public Bonus() {
  }

  public Bonus(String id, String staff, Timestamp time, double mount,String tag) {
    this.id = id;
    this.staff = staff;
    this.time = time;
    this.mount = mount;
    this.tag = tag;
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


  public double getMount() {
    return mount;
  }

  public void setMount(double mount) {
    this.mount = mount;
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
