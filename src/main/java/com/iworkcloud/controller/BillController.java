package com.iworkcloud.controller;

import com.iworkcloud.pojo.Bill;
import com.iworkcloud.serviceImp.BillService;
import com.iworkcloud.utils.Str2Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;

@Controller
public class BillController {
    @Autowired
    private BillService billService;


    @RequestMapping("addBill")
    public String billAdd(String id,String time,String mount,String details,String billType){

        time = time.replace('T',' ');
        Timestamp timestamp = new Timestamp(Str2Date.getTimeByStr(time));

        Bill bill = new Bill(id,timestamp,Double.parseDouble(mount),billType,details);
        billService.addBill(bill);

        return "bill";
    }
}
