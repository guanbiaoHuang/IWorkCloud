package com.iworkcloud.mapper;

import com.iworkcloud.pojo.Bill;

import java.util.HashMap;
import java.util.List;

public interface BillMapper {

    int insertBill(Bill bill);

    int updateBillContent(HashMap<Object, Object> map);

    List<Bill> queryBillById(String id);

    Double queryBillsByTag(String tag);

    Double queryBillsByDetail(String detail);

    List<Double> queryBillNumOrderByMonth(String tag);

}
