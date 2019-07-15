package com.iworkcloud.pojo;


//项目组信息表
public class Team {

    //项目组ID
    private String ID;
    //项目组
    private String name;
    //管理人ID
    private String managerId;

    public Team() {
    }

    public Team(String ID, String name, String managerId) {
        this.ID = ID;
        this.name = name;
        this.managerId = managerId;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }
}
