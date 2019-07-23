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
    //从Excel导入
    boolean addBillByExcel(MultipartFile file);


    //根据tag查询每月的总数据
    List<Bill> queryBillNumOrderByMonth(String tag);
}
