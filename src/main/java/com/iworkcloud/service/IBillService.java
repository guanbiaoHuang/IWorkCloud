package com.iworkcloud.service;

import com.iworkcloud.pojo.Bill;

public interface IBillService {
    //添加账单
    boolean addBill(Bill bill);
    //修改账单
    boolean modifyBill(Bill bill);
}
