package com.iworkcloud.controller;

import com.iworkcloud.pojo.Out;
import com.iworkcloud.service.IOutService;
import com.iworkcloud.utils.Str2Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.util.List;

/**
 * Out控制器
 */
@RequestMapping("page")
@Controller
public class OutController {
    @Autowired
    private IOutService outService;

    /**
     * 添加出差
     * @param staff 员工号
     * @param dateStart 开始日期
     * @param dateEnd 结束日期
     * @return
     */
    @RequestMapping("/addOut")
    public String addOut(String staff, String dateStart, String dateEnd) {

        Out out = new Out(staff, new Date(Str2Date.getDateByStr(dateStart)), new Date(Str2Date.getDateByStr(dateEnd)));
        boolean isSuccess = outService.addOut(out);
        return "redirect:excellentStaff";
    }

    /**
     * 删除出差
     * @param id 出差Id
     * @return
     */
    @RequestMapping("deleteOut")
    public String deleteOut(String id) {
        outService.deleteOut(id);
        return "redirect:excellentStaff";
    }


}
