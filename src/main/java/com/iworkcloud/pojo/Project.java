package com.iworkcloud.pojo;


import java.util.Date;

//项目信息表
public class Project {

    //项目类型
    private String Tag;
    //接受项目组ID
    private String teamId;
    //是否通过审核
    private String isApproved;
    //开始项目日期
    private Date dateStart;

    public Project() {
    }

    public Project(String tag, String teamId, String isApproved, Date dateStart) {
        Tag = tag;
        this.teamId = teamId;
        this.isApproved = isApproved;
        this.dateStart = dateStart;
    }

    public String getTag() {
        return Tag;
    }

    public void setTag(String tag) {
        Tag = tag;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(String isApproved) {
        this.isApproved = isApproved;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }
}
