package com.iworkcloud.mapper;

import com.iworkcloud.pojo.Project;

import java.util.HashMap;
import java.util.List;

public interface ProjectMapper {

    int insertProject(Project project);

    int deleteProjectById(String id);

    int updateProjectStatus(HashMap<String,String>map);

    Project queryProjectById(String id);

    List<Project> queryProjectByTag(String tag);
}
