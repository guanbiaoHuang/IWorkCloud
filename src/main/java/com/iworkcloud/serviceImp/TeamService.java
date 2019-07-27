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

    /**
     * 添加团队
     * @param team
     * @return
     */
    @Override
    public boolean addTeam(Team team) {
        return 1 == teamMapper.insertTeam(team);
    }

    /**
     * 修改团队管理者信息
     * @param id 团队Id
     * @param ManagerId 管理者Id
     * @return
     */
    @Override
    public boolean modifyManager(String id, String ManagerId) {
        return 1 == teamMapper.updateTeamForManager(id, ManagerId);
    }

    /**
     * 竞标项目
     * @param map
     * @return
     */
    @Override
    public boolean decideProject(HashMap<Object, Object> map) {
        return 1 == teamMapper.updateTeamProject(map);
    }

    @Override
    public String getProject(String id) {
        return teamMapper.queryProjectIdByTeam(id);
    }
}
