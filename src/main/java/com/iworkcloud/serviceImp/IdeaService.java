package com.iworkcloud.serviceImp;

import com.iworkcloud.mapper.IdeaMapper;
import com.iworkcloud.service.IIdeaService;

public class IdeaService implements IIdeaService {

    private IdeaMapper ideaMapper;

    public void setIdeaMapper(IdeaMapper ideaMapper) {
        this.ideaMapper = ideaMapper;
    }
}
