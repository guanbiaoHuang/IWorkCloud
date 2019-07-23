package com.iworkcloud.controller;

import com.iworkcloud.pojo.Activity;
import com.iworkcloud.pojo.Idea;
import com.iworkcloud.service.IActivityService;
import com.iworkcloud.service.IIdeaService;
import com.iworkcloud.serviceImp.StaffService;
import com.iworkcloud.utils.Str2Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PageGet {
    @Autowired
    private IActivityService activityService;

    @Autowired
    private IIdeaService ideaService;

    @RequestMapping("page/{pageName}")
    public String DispatchView(@PathVariable("pageName") String pageName){
        return pageName;
    }

    @RequestMapping("iframe/{iframeName}")
    public String getIframe(@PathVariable("iframeName") String iframe){
        return iframe;
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
            List<Idea> ideas = ideaService.getAllIdeas();
            List<Activity> welfare = activityService.getActivityByTag("welfare");
            List<Activity> activities = activityService.getActivityByTag("activity");
            model.addAttribute("ideaList",ideas);
            model.addAttribute("welfareList",welfare);
            model.addAttribute("activityList",activities);

            return "index";
        }
    }


}
