package com.iworkcloud.serviceImp;

import com.iworkcloud.mapper.OutMapper;
import com.iworkcloud.service.IOutService;

public class OutService implements IOutService {
    private OutMapper outMapper;

    public void setOutMapper(OutMapper outMapper) {
        this.outMapper = outMapper;
    }
}
