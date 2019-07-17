package com.iworkcloud.controller;

import com.iworkcloud.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class StaffController {
    @Autowired
    private IStaffService staffService;

    @RequestMapping("bindStaff")
    public String bindStaff(HttpSession session, String staffID, Model model){
        if(session.getAttribute("phone")!=null){
            HashMap<String,Object> map= new HashMap<>();
            map.put("phone",session.getAttribute("phone"));
            map.put("id",staffID);
            if(staffService.bindStaff(map)) {
                session.removeAttribute("phone");
                session.setAttribute("staff", staffID);
                return "redirect:index";
            }else{
                session.removeAttribute("phone");
                model.addAttribute("msg","bindFailed");
                return "forward:login";
            }
        }else{
            model.addAttribute("msg","notLogin");
            return "forward:login";
        }

    }
}
