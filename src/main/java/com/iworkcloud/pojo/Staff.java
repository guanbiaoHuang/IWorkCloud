package com.iworkcloud.pojo;


//员工信息表
public class Staff {

    //员工ID
    private int staffId;
    //姓名
    private String name;
    //团队ID
    private String teamId;
    //手机号
    private String phone;
    //所属部门
    private String department;
    //员工角色,用于权限管理
    private String role;

    public Staff() {
    }

    public Staff(int staffId, String name, String teamId, String phone, String department, String role) {
        this.staffId = staffId;
        this.name = name;
        this.teamId = teamId;
        this.phone = phone;
        this.department = department;
        this.role = role;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
