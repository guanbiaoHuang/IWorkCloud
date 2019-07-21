package com.iworkcloud.service;

import com.iworkcloud.pojo.Idea;

import java.util.List;

public interface IIdeaService {

    boolean addIdea(Idea idea);
    boolean modifyIdea(Idea idea);
    boolean deleteIdea(Idea idea);
    List<Idea> getAllIdeas();
}
