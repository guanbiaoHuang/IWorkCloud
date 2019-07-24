package com.iworkcloud.service;

import com.iworkcloud.pojo.Project;

import java.util.List;

public interface IProjectService {

    boolean addProject(Project project);
    //批准项目，修改项目表的approved值
    boolean approveProject(String projectId);
    //不批准项目,修改项目表的approved值
    boolean rejectProject(String projectId);

    List<Project> getProjects();

    boolean deleteProject(String projectId);

    Project getMyProject(String id);

}
