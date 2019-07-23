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
        return 1==ideaMapper.insertIdea(idea)?true:false;
    }


    @Override
    public boolean deleteIdea(long id) {
        return 1==ideaMapper.deleteIdeaByStaffId(id)?true:false;
    }

    @Override
    public List<Idea> getAllIdeas() {
        return ideaMapper.queryAllIdea();
    }
}
