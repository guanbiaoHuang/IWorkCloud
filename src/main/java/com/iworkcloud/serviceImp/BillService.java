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

    /**
     * 添加一笔账单
     * @param bill bill实体类
     * @return
     */
    @Override
    public boolean addBill(Bill bill) {
        return 1 == billMapper.insertBill(bill);
    }

    /**
     * 根据流水号获取某笔账单
     * @param id 流水号
     * @return
     */
    @Override
    public List<Bill> queryBillById(String id) {
        return billMapper.queryBillById(id);
    }

    /**
     * 获取支出或收入
     * @param tag 支出或收入
     * @return
     */
    @Override
    public Double getBillByTag(String tag) {
        return billMapper.queryBillsByTag(tag);
    }

    /**
     * 根据Excel表格批量添加账单信息
     * @param file
     * @return
     */
    @Override
    public boolean addBillByExcel(MultipartFile file) {
        //获取上传Excel文件的输入流
        InputStream inputStream = null;
        //将每一行数据视作一个链表，所有的数据则为一个包含所有行的数据总集
        List<List<Object>> lists = null;
        try {
            inputStream = file.getInputStream();
            //调用ExcelUtil类将数据读入总集集合中
            lists = new ExcelUtil().getBankListByExcel(inputStream, file.getOriginalFilename());
            //遍历链表，将数据填充到实体类当中
            for (int i = 0; i < lists.size(); i++) {
                List<Object> list = lists.get(i);
                //使用包装类的方法对数据进行转型
                Bill bill = new Bill(String.valueOf(list.get(0)),
                        new Timestamp(Str2Date.getTimeByStr(String.valueOf(list.get(1)))),
                        Double.parseDouble(String.valueOf(list.get(2))),
                        String.valueOf(list.get(3)),
                        String.valueOf(list.get(4)));

                //调用插入函数
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

    /**
     * 获取支出为工资的账单
     * @param detail 账单描述
     * @return
     */
    @Override
    public Double getBillOfSalary(String detail) {
        return billMapper.queryBillsByDetail(detail);
    }

    /**
     *按月份统计获取所有的账单信息
     * @param tag 支出或收入
     * @return
     */
    @Override
    public List<Double> queryBillNumOrderByMonth(String tag) {
        return billMapper.queryBillNumOrderByMonth(tag);
    }
}
