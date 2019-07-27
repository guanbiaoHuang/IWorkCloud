package com.iworkcloud.serviceImp;

import com.iworkcloud.mapper.OutMapper;
import com.iworkcloud.pojo.Out;
import com.iworkcloud.service.IOutService;

import java.util.List;

public class OutService implements IOutService {
    private OutMapper outMapper;

    public void setOutMapper(OutMapper outMapper) {
        this.outMapper = outMapper;
    }

    /**
     * 添加出差
     * @param out
     * @return
     */
    @Override
    public boolean addOut(Out out) {
        return 1 == outMapper.insertOut(out);
    }

    /**
     * 获取今天的出差人数
     * @return
     */
    @Override
    public List<Out> outToday() {
        return outMapper.queryOutToday();
    }

    /**
     *删除出差
     * @param id
     * @return
     */
    @Override
    public boolean deleteOut(String id) {
        return 1 == outMapper.deleteOut(id);
    }
}
