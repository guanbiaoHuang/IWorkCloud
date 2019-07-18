package com.iworkcloud.mapper;

import com.iworkcloud.pojo.Idea;

import java.util.HashMap;
import java.util.List;

public interface IdeaMapper {

    int insertIdea(Idea idea);

    int deleteIdeaByStaffId(String staffId);

    List<Idea> queryIdeaByStaffId(String staffId);

    int updateIdeaContent(HashMap<Object,Object>map);
}
