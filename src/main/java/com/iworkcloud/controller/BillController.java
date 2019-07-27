package com.iworkcloud.controller;

import com.iworkcloud.pojo.Bill;
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

import java.sql.Timestamp;
import java.util.List;

/**
 * Bill控制器
 */

@RequestMapping("page")
@Controller
public class BillController {
    @Autowired
    private BillService billService;
    @Autowired
    private BonusService bonusService;

    /**
     * 添加一笔账单
     * @param id 账单流水号
     * @param time 账单时间
     * @param mount 账单数目
     * @param details 账单描述
     * @param billType 账单类型（支出/收入）
     * @return
     */
    @RequestMapping("/addBill")
    public String billAdd(String id, String time, String mount, String details, String billType) {
        //时间字符串处理
        time = time.replace('T', ' ');
        Timestamp timestamp = new Timestamp(Str2Date.getTimeByStr(time));
        Bill bill = new Bill(id, timestamp, Double.parseDouble(mount), billType, details);
        billService.addBill(bill);
        return "redirect:bill";
    }

    /**
     * 根据Excel批量添加账单
     * @param file 上传的Excel账单文件
     * @return
     */
    @RequestMapping("/addBillXls")
    public String billAddByExcel(@RequestParam("file") MultipartFile file) {
        billService.addBillByExcel(file);
        return "redirect:bill";

    }

    /**
     * 账单页面，携带数据至财务界面
     * @param model 处理模型数据类
     * @return
     */
    @RequestMapping("/bill")
    public String bill(Model model) {

        //获取支出状况
        Double bonuses = bonusService.queryBonusNumOrderByMonth("奖金");
        Double subsidies = bonusService.queryBonusNumOrderByMonth("补贴");
        Double expenses = billService.getBillByTag("支出");
        Double salary = billService.getBillOfSalary("工资支出");
        List<Double> expense = billService.queryBillNumOrderByMonth("支出");
        List<Double> income = billService.queryBillNumOrderByMonth("收入");

        model.addAttribute("bonuses", bonuses);
        model.addAttribute("subsidies", subsidies);
        model.addAttribute("expense", expense);
        model.addAttribute("income", income);
        model.addAttribute("expenses", expenses);
        model.addAttribute("salary", salary);
        return "bill";
    }
}
