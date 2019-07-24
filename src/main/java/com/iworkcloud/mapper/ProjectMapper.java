package com.iworkcloud.mapper;

import com.iworkcloud.pojo.Project;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface ProjectMapper {

    int insertProject(Project project);


    int updateProjectStatus(@Param("projectId")String projectId,@Param("approved")String approved);

    Project queryProjectById(String id);

    List<Project> queryAllProject();

    int deleteProject(String projectId);

}
