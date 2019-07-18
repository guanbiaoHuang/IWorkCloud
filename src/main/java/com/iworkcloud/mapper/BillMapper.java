package com.iworkcloud.mapper;

import com.iworkcloud.pojo.Bill;

import java.util.HashMap;
import java.util.List;

public interface BillMapper {

    int insertBill(Bill bill);
    int updateBillContent(HashMap<Object,Object>map);
    List<Bill> queryBillById(int id);
    List<Bill> queryBillsByTag(String tag);
    int deleteBillById(int id);
}
