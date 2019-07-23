package com.iworkcloud.serviceImp;

import com.iworkcloud.mapper.ProjectMapper;
import com.iworkcloud.pojo.Project;
import com.iworkcloud.service.IProjectService;

public class ProjectService implements IProjectService {

    private ProjectMapper projectMapper;

    public void setProjectMapper(ProjectMapper projectMapper) {
        this.projectMapper = projectMapper;
    }

    @Override
    public boolean addProject(Project project) {
        return 1==projectMapper.insertProject(project)?true:false;
    }

    @Override
    public boolean approveProject(String projectId) {
        return false;
    }
}
