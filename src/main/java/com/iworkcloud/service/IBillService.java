package com.iworkcloud.service;

import com.iworkcloud.pojo.Bill;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IBillService {
    //添加账单
    boolean addBill(Bill bill);

    //根据ID查账单
    List<Bill> queryBillById(String id);
    //根据tag查账单
    List<Bill> queryBillByTag(String tag);

    boolean addBillByExcel(MultipartFile file);
}
