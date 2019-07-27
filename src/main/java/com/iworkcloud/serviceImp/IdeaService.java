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

    /**
     * 添加想法或意见
     * @param idea
     * @return
     */
    @Override
    public boolean addIdea(Idea idea) {
        return 1 == ideaMapper.insertIdea(idea);
    }

    /**
     * 删除想法或意见
     * @param id
     * @return
     */
    @Override
    public boolean deleteIdea(long id) {
        return 1 == ideaMapper.deleteIdeaByStaffId(id);
    }

    /**
     * 获取所有的意见墙
     * @return
     */
    @Override
    public List<Idea> getAllIdeas() {
        return ideaMapper.queryAllIdea();
    }
}
