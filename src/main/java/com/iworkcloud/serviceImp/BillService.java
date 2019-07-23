package com.iworkcloud.serviceImp;

import com.iworkcloud.mapper.BillMapper;
import com.iworkcloud.pojo.Bill;
import com.iworkcloud.service.IBillService;

import java.util.List;

public class BillService implements IBillService {
    private BillMapper billMapper;

    public void setBillMapper(BillMapper billMapper) {
        this.billMapper = billMapper;
    }

    @Override
    public boolean addBill(Bill bill) {
        return 1==billMapper.insertBill(bill)?true:false;
    }


    @Override
    public List<Bill> queryBillById(String id) {
        return billMapper.queryBillById(id);
    }

    @Override
    public List<Bill> queryBillByTag(String tag) {
        return queryBillByTag(tag);
    }
}
