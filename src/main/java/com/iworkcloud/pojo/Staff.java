package com.iworkcloud.pojo;


import java.io.Serializable;

public class Staff implements Serializable {

  private String id;
  private String name;
  private String team;
  private String sex;
  private String phone;
  private String department;




  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getTeam() {
    return team;
  }

  public void setTeam(String team) {
    this.team = team;
  }


  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public Staff(String id, String name, String team, String department,String phone,String sex) {
    this.id = id;
    this.name = name;
    this.team = team;
    this.sex = sex;
    this.phone = phone;
    this.department = department;
  }

  public Staff() {
  }
}
