package com.iworkcloud.mapper;

import com.iworkcloud.pojo.Team;

import java.util.HashMap;
import java.util.List;

public interface TeamMapper {

    int insertTeam(Team team);

    int deleteTeam(String id);

    int updateTeam(HashMap<Object,Object>map);

    List<Team>queryTeamById(String id);
    List<Team>queryTeamByName(String name);
    List<Team>queryTeamByManager(String manager);
    List<Team>queryTeamByProject(String project);
}
