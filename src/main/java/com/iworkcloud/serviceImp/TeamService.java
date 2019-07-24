package com.iworkcloud.serviceImp;

import com.iworkcloud.mapper.TeamMapper;
import com.iworkcloud.pojo.Project;
import com.iworkcloud.pojo.Team;
import com.iworkcloud.service.ITeamService;

import java.util.HashMap;

public class TeamService implements ITeamService {
    private TeamMapper teamMapper;

    public void setTeamMapper(TeamMapper teamMapper) {
        this.teamMapper = teamMapper;
    }

    @Override
    public boolean addTeam(Team team) {
        return 1==teamMapper.insertTeam(team)?true:false;
    }

    @Override
    public boolean modifyManager(String id, String ManagerId) {
        return 1==teamMapper.updateTeamForManager(id,ManagerId)?true:false;
    }

    @Override
    public boolean decideProject(HashMap<Object,Object>map) {
        return 1==teamMapper.updateTeamProject(map)?true:false;
    }

    @Override
    public String getProject(String id) {
        return teamMapper.queryProjectIdByTeam(id);
    }
}
