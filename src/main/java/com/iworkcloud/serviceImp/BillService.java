package com.iworkcloud.serviceImp;

import com.iworkcloud.mapper.BillMapper;
import com.iworkcloud.service.IBillService;

public class BillService implements IBillService {
    private BillMapper billMapper;

    public void setBillMapper(BillMapper billMapper) {
        this.billMapper = billMapper;
    }
}
