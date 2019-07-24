package com.iworkcloud.serviceImp;

import com.iworkcloud.mapper.ProjectMapper;
import com.iworkcloud.pojo.Project;
import com.iworkcloud.service.IProjectService;

import java.util.List;

public class ProjectService implements IProjectService {

    private ProjectMapper projectMapper;

    public void setProjectMapper(ProjectMapper projectMapper) {
        this.projectMapper = projectMapper;
    }

    @Override
    public boolean addProject(Project project) {
        return 1==projectMapper.insertProject(project);
    }

    @Override
    public boolean approveProject(String projectId) {
        return 1==projectMapper.updateProjectStatus(projectId,"审批通过");
    }

    @Override
    public boolean rejectProject(String projectId) {
        return 1==projectMapper.updateProjectStatus(projectId,"审批不通过");
    }

    @Override
    public List<Project> getProjects() {
        return projectMapper.queryAllProject();
    }

    @Override
    public boolean deleteProject(String projectId) {
        return 1==projectMapper.deleteProject(projectId);
    }

    @Override
    public Project getMyProject(String id) {
        return projectMapper.queryProjectById(id);
    }
}
