package com.iworkcloud.mapper;

import com.iworkcloud.pojo.Project;

import java.util.HashMap;
import java.util.List;

public interface ProjectMapper {

    int insertProject(Project project);

    int deleteProjectById(String id);

    int updateProjectContent(HashMap<Object,Object>map);

    List<Project> queryProjectById(String id);

    List<Project> queryProjectByTag(String tag);
}
