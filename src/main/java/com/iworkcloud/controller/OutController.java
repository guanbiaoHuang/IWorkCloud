package com.iworkcloud.controller;

import com.iworkcloud.service.IOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OutController {
    @Autowired
    private IOutService outService;

    @RequestMapping("addOut")
    public String addOut(){
        return "";
    }

    public String getOut(Model model){

        return "redirect:";
    }
}
