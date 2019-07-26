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

    @Override
    public boolean addOut(Out out) {
        return 1 == outMapper.insertOut(out);
    }

    @Override
    public List<Out> outToday() {
        return outMapper.queryOutToday();
    }

    @Override
    public boolean deleteOut(String id) {
        return 1 == outMapper.deleteOut(id);
    }
}
