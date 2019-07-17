package com.iworkcloud.mapper;

import com.iworkcloud.pojo.Bill;

import java.util.HashMap;

public interface BillMapper {

    void insertBill(Bill bill);
    void updateBillContent(HashMap<Object,Object>map);
    Bill queryBillById(int id);
    Bill queryBillsByTag(String tag);
    void deleteBillById(int id);
}
