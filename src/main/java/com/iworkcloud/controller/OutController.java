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

@RequestMapping("page")
@Controller
public class OutController {
    @Autowired
    private IOutService outService;

    @RequestMapping("/addOut")
    public String addOut(String staff, String dateStart, String dateEnd) {

        Out out = new Out(staff, new Date(Str2Date.getDateByStr(dateStart)), new Date(Str2Date.getDateByStr(dateEnd)));
        boolean isSuccess = outService.addOut(out);
        return "redirect:excellentStaff";
    }

    @RequestMapping("deleteOut")
    public String deleteOut(String id) {
        outService.deleteOut(id);
        return "redirect:excellentStaff";
    }


}
