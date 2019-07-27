package com.iworkcloud.controller;

import com.iworkcloud.pojo.Activity;
import com.iworkcloud.service.IActivityService;
import com.iworkcloud.utils.Str2Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.util.List;

/**
 * Activity控制器
 */

@RequestMapping("page")
@Controller
public class ActivityController {

    @Autowired
    private IActivityService activityService;

    /**
     * 活动页面，携带数据至活动管理页面
     * @param model 处理模型数据类
     * @return
     */
    @RequestMapping("/activities")
    public String activities(Model model) {
        //根据Tag获取会议、活动以及福利并添加到Request域中
        List<Activity> meetingList = activityService.getActivityByTag("meeting");
        List<Activity> activityList = activityService.getActivityByTag("activity");
        List<Activity> welfareList = activityService.getActivityByTag("welfare");
        model.addAttribute("meetingList", meetingList);
        model.addAttribute("activityList", activityList);
        model.addAttribute("welfareList", welfareList);
        return "activities";
    }

    /**
     * 添加活动
     * @param time 活动时间
     * @param title 活动标题
     * @param content 活动内容
     * @return
     */

    @RequestMapping("/addActivity")
    public String addActivity(String time, String title, String content) {
        //将从Html5原生组件DateTimeLocal获取的时间字符串进行处理
        time = time.replace('T', ' ');
        Timestamp timestamp = new Timestamp(Str2Date.getTimeByStr(time));
        Activity activity = new Activity(timestamp, title, content, "activity");

        activityService.addActivity(activity);
        return "redirect:activities";
    }

    /**
     *添加会议
     * @param time 会议时间
     * @param title 会议标题
     * @param content 会议内容
     * @return
     */
    @RequestMapping("/addMeeting")
    public String addMeeting(String time, String title, String content) {
        time = time.replace('T', ' ');
        Timestamp timestamp = new Timestamp(Str2Date.getTimeByStr(time));
        Activity activity = new Activity(timestamp, title, content, "meeting");
        activityService.addActivity(activity);
        return "redirect:activities";
    }

    /**
     * 添加员工福利
     * @param time 福利时间
     * @param content 福利内容
     * @return
     */

    @RequestMapping("/addWelfare")
    public String addWelfare(String time, String content) {
        time = time.replace('T', ' ');
        Timestamp timestamp = new Timestamp(Str2Date.getTimeByStr(time));
        Activity activity = new Activity(timestamp, "员工福利", content, "welfare");
        activityService.addActivity(activity);
        return "redirect:activities";
    }

    /**
     * 删除活动/福利/会议
     * @param activityId 活动、福利、会议的Id属性
     * @return
     */
    @RequestMapping("/deleteActivity")
    public String deleteActivity(String activityId) {
        activityService.deleteActivityById(Integer.parseInt(activityId));
        return "redirect:activities";
    }
}
