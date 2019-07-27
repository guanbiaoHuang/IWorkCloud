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

    /**
     * 添加项目信息
     * @param project
     * @return
     */
    @Override
    public boolean addProject(Project project) {
        return 1 == projectMapper.insertProject(project);
    }

    /**
     * 批准项目
     * @param projectId
     * @return
     */
    @Override
    public boolean approveProject(String projectId) {
        return 1 == projectMapper.updateProjectStatus(projectId, "审批通过");
    }

    /**
     * 拒绝项目
     * @param projectId
     * @return
     */
    @Override
    public boolean rejectProject(String projectId) {
        return 1 == projectMapper.updateProjectStatus(projectId, "审批不通过");
    }

    /**
     * 获取所有的项目
     * @return
     */
    @Override
    public List<Project> getProjects() {
        return projectMapper.queryAllProject();
    }

    /**
     * 删除项目
     * @param projectId 项目Id
     * @return
     */
    @Override
    public boolean deleteProject(String projectId) {
        return 1 == projectMapper.deleteProject(projectId);
    }

    /**
     * 获取我的项目组的项目
     * @param id 项目Id
     * @return
     */
    @Override
    public Project getMyProject(String id) {
        return projectMapper.queryProjectById(id);
    }
}
