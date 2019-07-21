package com.iworkcloud.service;

import com.iworkcloud.pojo.Team;

public interface ITeamService {
    boolean addTeam(Team team);
    boolean modifyManager(String id, String ManagerId);
    boolean decideProject(String projectId);

}
