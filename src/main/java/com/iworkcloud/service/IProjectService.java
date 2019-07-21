package com.iworkcloud.service;

import com.iworkcloud.pojo.Project;

public interface IProjectService {

    boolean addProject(Project project);
    boolean approveProject(String projectId);


}
