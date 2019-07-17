package com.iworkcloud.pojo;


import java.io.Serializable;

public class Holiday implements Serializable {

  private long id;
  private String staff;
  private java.sql.Timestamp timeStart;
  private java.sql.Timestamp timeEnd;
  private String reason;
  private String ratified;


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


  public java.sql.Timestamp getTimeStart() {
    return timeStart;
  }

  public void setTimeStart(java.sql.Timestamp timeStart) {
    this.timeStart = timeStart;
  }


  public java.sql.Timestamp getTimeEnd() {
    return timeEnd;
  }

  public void setTimeEnd(java.sql.Timestamp timeEnd) {
    this.timeEnd = timeEnd;
  }


  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }


  public String getRatified() {
    return ratified;
  }

  public void setRatified(String ratified) {
    this.ratified = ratified;
  }

}
