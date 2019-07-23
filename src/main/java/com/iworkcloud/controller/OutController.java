package com.iworkcloud.controller;

import com.iworkcloud.pojo.Out;
import com.iworkcloud.service.IOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class OutController {
    @Autowired
    private IOutService outService;

    @RequestMapping("addOut")
    public String addOut(){
        return "";
    }

//    public String getOut(Model model){
//
//        return "redirect:";
//    }

//    @RequestMapping("e")
//    public String getOut(Model model){
////        List<Out> outs = outService.outToday();
////        model.addAttribute("outList",outs);
////        System.out.println(outs.size());
////        for (Out out:outs){
////            System.out.println("OUT"+out.getStaff()+"------"+out.getDateStart()+"---------"+out.getDateEnd());
////        }
////        return "excellentStaff";
//    }
}
