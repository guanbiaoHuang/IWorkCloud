package com.iworkcloud.controller;

import com.iworkcloud.pojo.Project;
import com.iworkcloud.serviceImp.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;


    @RequestMapping("addProject")
    public String addProject(String id,String name, String tag){

        Project project = new Project(id,name,tag,"未审批");

        projectService.addProject(project);

        return "projects";
    }
}
