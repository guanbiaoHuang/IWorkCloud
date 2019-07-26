package com.iworkcloud.serviceImp;

import com.iworkcloud.mapper.BillMapper;
import com.iworkcloud.pojo.Bill;
import com.iworkcloud.service.IBillService;
import com.iworkcloud.utils.ExcelUtil;
import com.iworkcloud.utils.Str2Date;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.List;

public class BillService implements IBillService {
    private BillMapper billMapper;

    public void setBillMapper(BillMapper billMapper) {
        this.billMapper = billMapper;
    }

    @Override
    public boolean addBill(Bill bill) {
        return 1 == billMapper.insertBill(bill);
    }


    @Override
    public List<Bill> queryBillById(String id) {
        return billMapper.queryBillById(id);
    }

    @Override
    public Double getBillByTag(String tag) {
        return billMapper.queryBillsByTag(tag);
    }

    @Override
    public boolean addBillByExcel(MultipartFile file) {
        InputStream inputStream = null;
        List<List<Object>> lists = null;
        try {
            inputStream = file.getInputStream();
            lists = new ExcelUtil().getBankListByExcel(inputStream, file.getOriginalFilename());
            for (int i = 0; i < lists.size(); i++) {
                List<Object> list = lists.get(i);
                Bill bill = new Bill(String.valueOf(list.get(0)),
                        new Timestamp(Str2Date.getTimeByStr(String.valueOf(list.get(1)))),
                        Double.parseDouble(String.valueOf(list.get(2))),
                        String.valueOf(list.get(3)),
                        String.valueOf(list.get(4)));
                billMapper.insertBill(bill);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    @Override
    public Double getBillOfSalary(String detail) {
        return billMapper.queryBillsByDetail(detail);
    }

    @Override
    public List<Double> queryBillNumOrderByMonth(String tag) {
        return billMapper.queryBillNumOrderByMonth(tag);
    }
}
