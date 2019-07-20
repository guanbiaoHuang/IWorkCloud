package com.iworkcloud.serviceImp;

import com.iworkcloud.mapper.TeamMapper;
import com.iworkcloud.service.ITeamService;

public class TeamService implements ITeamService {
    private TeamMapper teamMapper;

    public void setTeamMapper(TeamMapper teamMapper) {
        this.teamMapper = teamMapper;
    }
}
