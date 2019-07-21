package com.iworkcloud.service;

import com.iworkcloud.pojo.Bill;

public interface IBillService {

    boolean addBill(Bill bill);
    boolean modifyBill(Bill bill);
}
