package com.iworkcloud.pojo;


import java.io.Serializable;

public class User implements Serializable {

  private String phone;
  private String password;
  private String icon;


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public User() {
  }

  public User(String phone, String password, String icon) {
    this.phone = phone;
    this.password = password;
    this.icon = icon;
  }
}
