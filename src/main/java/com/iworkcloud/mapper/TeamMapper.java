package com.iworkcloud.mapper;

import com.iworkcloud.pojo.Team;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface TeamMapper {

    int insertTeam(Team team);

    int updateTeamProject(HashMap<Object, Object> map);

    int updateTeamForManager(@Param("id") String id, @Param("managerId") String managerId);

    String queryProjectIdByTeam(String id);


}
