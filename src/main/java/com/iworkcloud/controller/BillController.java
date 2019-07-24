package com.iworkcloud.controller;

import com.iworkcloud.pojo.Bill;
import com.iworkcloud.pojo.BillMonthCount;
import com.iworkcloud.pojo.Bonus;
import com.iworkcloud.serviceImp.BillService;
import com.iworkcloud.serviceImp.BonusService;
import com.iworkcloud.utils.Str2Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;


@RequestMapping("page")
@Controller
public class BillController {
    @Autowired
    private BillService billService;
    @Autowired
    private BonusService bonusService;

    @RequestMapping("/addBill")
    public String billAdd(String id,String time,String mount,String details,String billType){

        time = time.replace('T',' ');
        Timestamp timestamp = new Timestamp(Str2Date.getTimeByStr(time));
        Bill bill = new Bill(id,timestamp,Double.parseDouble(mount),billType,details);
        billService.addBill(bill);
        return "redirect:bill";
    }

    @RequestMapping("/addBillXls")
    public String billAddByExcel(@RequestParam("file") MultipartFile file){
        billService.addBillByExcel(file);
        return "redirect:bill";

    }

    @RequestMapping("/bill")
    public String bill(Model model){
        List<Bonus> bonuses = bonusService.queryBonusNumOrderByMonth("奖金");
        List<Bonus> subsidies = bonusService.queryBonusNumOrderByMonth("补贴");
        List<BillMonthCount> expense = billService.queryBillNumOrderByMonth("支出");
        List<BillMonthCount> income = billService.queryBillNumOrderByMonth("收入");

        System.out.println("-----------------------");
        double num = expense.stream().mapToDouble(BillMonthCount::getMonthCount).sum();
        System.out.println(num);
        System.out.println("-----------------------");

//        for (BillMonthCount bill:income){
//            System.out.println("-----------");
//            System.out.println(bill.getMonthCount());
//            System.out.println(bill);
//        }
//        for (BillMonthCount bill:expense){
//            System.out.println("+++++++++++");
//            System.out.println(bill.getMonth());
//            System.out.println(bill);
//        }
        model.addAttribute("bonuses",bonuses);
        model.addAttribute("subsidies",subsidies);
        model.addAttribute("expense",expense);
        model.addAttribute("income",income);
        return "bill";
    }
}
