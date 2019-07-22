package com.iworkcloud.serviceImp;

import com.iworkcloud.mapper.BillMapper;
import com.iworkcloud.pojo.Bill;
import com.iworkcloud.service.IBillService;

public class BillService implements IBillService {
    private BillMapper billMapper;

    public void setBillMapper(BillMapper billMapper) {
        this.billMapper = billMapper;
    }

    @Override
    public boolean addBill(Bill bill) {
        return false;
    }

    @Override
    public boolean modifyBill(Bill bill) {
        return false;
    }

    @Override
    public boolean queryBillById(String id) {
        return false;
    }

    @Override
    public boolean queryBillByTag(String tag) {
        return false;
    }
}
