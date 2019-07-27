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

/**
 * 界面跳转
 */

@RequestMapping("page")
@Controller
public class PageGet {
    @Autowired
    private IActivityService activityService;

    @Autowired
    private IIdeaService ideaService;

    /**
     * layer弹出层
     * 基于Ant风格传值，减少代码冗余
     * @param iframe 请求弹出的iframe层，经视图解析器解析后的值
     * @return
     */
    @RequestMapping("/iframe/{iframeName}")
    public String getIframe(@PathVariable("iframeName") String iframe) {
        return iframe;
    }

    /**
     * 首页界面，信息携带
     * @param model 处理模型数据类
     * @param session 获取session中的员工号
     * @return
     */
    @RequestMapping("/index")
    public String toIndex(Model model, HttpSession session) {
        List<Idea> ideas = ideaService.getAllIdeas();
        //获取最近一周的活动、福利
        List<Activity> welfare = activityService.getActivitiesByTime(7, "welfare");
        List<Activity> activities = activityService.getActivitiesByTime(7, "activity");
        model.addAttribute("ideaList", ideas);
        model.addAttribute("welfareList", welfare);
        model.addAttribute("activityList", activities);
        return "index";
    }


}
