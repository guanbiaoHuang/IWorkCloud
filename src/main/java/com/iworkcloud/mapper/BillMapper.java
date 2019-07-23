package com.iworkcloud.mapper;

import com.iworkcloud.pojo.Bill;

import java.util.HashMap;
import java.util.List;

public interface BillMapper {

    int insertBill(Bill bill);
    int updateBillContent(HashMap<Object,Object>map);
    List<Bill> queryBillById(String id);
    List<Bill> queryBillsByTag(String tag);

    List<Bill> queryBillNumOrderByMonth(String tag);
}
