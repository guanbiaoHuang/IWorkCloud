package com.iworkcloud.serviceImp;

import com.iworkcloud.mapper.ProjectMapper;
import com.iworkcloud.service.IProjectService;

public class ProjectService implements IProjectService {

    private ProjectMapper projectMapper;

    public void setProjectMapper(ProjectMapper projectMapper) {
        this.projectMapper = projectMapper;
    }
}
