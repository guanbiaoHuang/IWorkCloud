package com.iworkcloud.controller;

import com.iworkcloud.pojo.Project;
import com.iworkcloud.service.IProjectService;
import com.iworkcloud.service.IStaffService;
import com.iworkcloud.service.ITeamService;
import com.iworkcloud.service.IUserService;
import com.iworkcloud.serviceImp.ProjectService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Project控制器
 */
@RequestMapping("page")
@Controller
public class ProjectController {

    @Autowired
    private IProjectService projectService;
    @Autowired
    private IStaffService staffService;
    @Autowired
    private ITeamService teamService;

    /**
     * 添加项目
     * @param id 项目Id
     * @param name 项目名称
     * @param tag 项目分类
     * @return
     */
    @RequestMapping("/addProject")
    public String addProject(String id, String name, String tag) {
        Project project = new Project(id, name, tag, "未审批");
        projectService.addProject(project);
        return "redirect:projectsManage";
    }

    /**
     * 批准项目
     * @param projectId 项目Id
     * @return
     */
    @RequestMapping("/approveProject")
    public String approveProject(String projectId) {
        projectService.approveProject(projectId);
        return "redirect:projectsManage";
    }

    /**
     * 项目管理界面
     * @param model 处理模型数据类
     * @return
     */
    @RequestMapping("/projectsManage")
    public String projectsManage(Model model) {
        List<Project> projectList = projectService.getProjects();
        model.addAttribute("projectList", projectList);
        return "projectsManage";
    }

    /**
     * 删除项目
     * @param projectId 项目Id
     * @return
     */
    @RequestMapping("/deleteProject")
    public String deleteProject(String projectId) {
        projectService.deleteProject(projectId);
        return "redirect:projectsManage";
    }

    /**
     * 我的项目界面
     * @param model 处理模型数据类
     * @param session
     * @return
     */
    @RequestMapping("/projects")
    public String projects(Model model, HttpSession session) {
        String staffId = session.getAttribute("staff").toString();
        String team = staffService.getStaffById(staffId).getTeam();
        String projectId = teamService.getProject(team);
        if (null != projectId && projectId.length() > 0) {
            Project project = projectService.getMyProject(projectId);
            model.addAttribute("project", project);
            return "projects";
        }
        return "projects";
    }

}
