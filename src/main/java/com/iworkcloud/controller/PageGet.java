package com.iworkcloud.controller;

import com.iworkcloud.serviceImp.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class PageGet {

    @RequestMapping("register")
    public String toReigister() {
        return "register";
    }

    @RequestMapping("login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("bind")
    public String bind(){
        return "bind";
    }

    @RequestMapping("index")
    public String toIndex(Model model, HttpSession session){
        if(session.getAttribute("staffID")==null){
            model.addAttribute("msg","notLogin");
            return "forward:login";
        }else{
            return "index";
        }
    }


}
