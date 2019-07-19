package com.iworkcloud.pojo;


import java.io.Serializable;

public class Team implements Serializable {

  private String id;
  private String name;
  private String manager;
  private String project;


  public Team() {
  }


  public Team(String id, String name, String manager, String project) {
        this.id = id;
        this.name = name;
        this.manager = manager;
        this.project = project;
  }
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


  public String getManager() {
    return manager;
  }

  public void setManager(String manager) {
    this.manager = manager;
  }


  public String getProject() {
    return project;
  }

  public void setProject(String project) {
    this.project = project;
  }

}
