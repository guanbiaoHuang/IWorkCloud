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
        return 1==outMapper.insertOut(out)?true:false;
    }

    @Override
    public List<Out> outToday() {
        return null;
    }
}
