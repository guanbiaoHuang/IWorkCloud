package com.iworkcloud.service;

import com.iworkcloud.pojo.Idea;

import java.util.List;

public interface IIdeaService {
    //添加想法或建议
    boolean addIdea(Idea idea);

    boolean deleteIdea(long id);

    //获取想法或建议
    List<Idea> getAllIdeas();
}
