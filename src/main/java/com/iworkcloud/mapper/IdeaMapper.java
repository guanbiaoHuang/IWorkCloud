package com.iworkcloud.mapper;

import com.iworkcloud.pojo.Idea;

import java.util.HashMap;
import java.util.List;

public interface IdeaMapper {

    void insertIdea(Idea idea);

    void deleteIdeaByStuffId(String staffId);

    List<Idea> queryIdeaByStuffId(String staffId);

    void updateIdeaContent(HashMap<Object,Object>map);
}
