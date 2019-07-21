package com.iworkcloud.serviceImp;

import com.iworkcloud.mapper.TeamMapper;
import com.iworkcloud.pojo.Team;
import com.iworkcloud.service.ITeamService;

public class TeamService implements ITeamService {
    private TeamMapper teamMapper;

    public void setTeamMapper(TeamMapper teamMapper) {
        this.teamMapper = teamMapper;
    }

    @Override
    public boolean addTeam(Team team) {
        return false;
    }

    @Override
    public boolean modifyManager(String id, String ManagerId) {
        return false;
    }

    @Override
    public boolean decideProject(String projectId) {
        return false;
    }
}
