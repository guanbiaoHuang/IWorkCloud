package com.sample;


public class Bill {

  private String id;
  private java.sql.Timestamp time;
  private double mount;
  private String tag;
  private String details;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public java.sql.Timestamp getTime() {
    return time;
  }

  public void setTime(java.sql.Timestamp time) {
    this.time = time;
  }


  public double getMount() {
    return mount;
  }

  public void setMount(double mount) {
    this.mount = mount;
  }


  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }


  public String getDetails() {
    return details;
  }

  public void setDetails(String details) {
    this.details = details;
  }

}
