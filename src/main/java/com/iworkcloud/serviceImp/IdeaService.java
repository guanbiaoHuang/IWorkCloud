package com.iworkcloud.serviceImp;

import com.iworkcloud.mapper.IdeaMapper;
import com.iworkcloud.pojo.Idea;
import com.iworkcloud.service.IIdeaService;

import java.util.List;

public class IdeaService implements IIdeaService {

    private IdeaMapper ideaMapper;

    public void setIdeaMapper(IdeaMapper ideaMapper) {
        this.ideaMapper = ideaMapper;
    }

    @Override
    public boolean addIdea(Idea idea) {
        return false;
    }

    @Override
    public boolean modifyIdea(Idea idea) {
        return false;
    }

    @Override
    public boolean deleteIdea(Idea idea) {
        return false;
    }

    @Override
    public List<Idea> getAllIdeas() {
        return null;
    }
}
