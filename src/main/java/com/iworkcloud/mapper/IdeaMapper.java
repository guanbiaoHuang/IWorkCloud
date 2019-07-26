package com.iworkcloud.mapper;

import com.iworkcloud.pojo.Idea;

import java.util.HashMap;
import java.util.List;

public interface IdeaMapper {

    int insertIdea(Idea idea);

    int deleteIdeaByStaffId(long id);

    List<Idea> queryAllIdea();

    int updateIdeaContent(HashMap<Object, Object> map);
}
