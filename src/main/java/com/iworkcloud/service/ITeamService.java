package com.iworkcloud.service;

import com.iworkcloud.pojo.Project;
import com.iworkcloud.pojo.Team;

import java.util.HashMap;

public interface ITeamService {
    boolean addTeam(Team team);
    boolean modifyManager(String id, String ManagerId);
    boolean decideProject(HashMap<Object,Object>map);
    String getProject(String id);
}
