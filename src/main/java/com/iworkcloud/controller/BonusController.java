package com.iworkcloud.controller;

import com.iworkcloud.pojo.Bonus;
import com.iworkcloud.serviceImp.BonusService;
import com.iworkcloud.utils.Str2Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

/**
 * Bonus控制器
 */
@RequestMapping("page")
@Controller
public class BonusController {
    @Autowired
    private BonusService bonusService;

    /**
     * 添加一笔奖金补贴信息
     * @param id 流水号
     * @param staff 发放的员工工号
     * @param time 发放时间
     * @param mount 发放金额
     * @param bonusType 奖金类型
     * @return
     */
    @RequestMapping("/addBonus")
    public String addBonus(String id, String staff, String time, String mount, String bonusType) {
        //时间字符串处理
        time = time.replace('T', ' ');
        Timestamp timestamp = new Timestamp(Str2Date.getTimeByStr(time));

        bonusService.addBonus(new Bonus(id, staff, timestamp, Double.parseDouble(mount), bonusType));

        return "redirect:bill";
    }

    /**
     * 根据上传的Excel表格批量添加奖金补贴信息
     * @param file 上传的Excel文件
     * @return
     */
    @RequestMapping("/addBonusXls")
    public String addBonusByExcel(@RequestParam("file") MultipartFile file) {
        bonusService.addBonusByExcel(file);
        return "redirect:bill";

    }

}
