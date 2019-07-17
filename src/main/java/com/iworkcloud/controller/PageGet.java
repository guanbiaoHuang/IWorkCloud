package com.iworkcloud.controller;

import com.iworkcloud.serviceImp.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class PageGet {

    @RequestMapping("page/{pageName}")
    public String DispatchView(@PathVariable("pageName") String pageName){
        return pageName;
    }

    @RequestMapping("register")
    public String toReigister() {
        return "register";
    }

    @RequestMapping("login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("index")
    public String toIndex(Model model, HttpSession session){
        if(session.getAttribute("staff")==null){
            if(session.getAttribute("phone")==null) {
                model.addAttribute("msg", "请登录");
                return "forward:login";
            }else{
                model.addAttribute("msg", "notBind");
                return "forward:login";
            }
        }else {
            return "index";
        }
    }


}
