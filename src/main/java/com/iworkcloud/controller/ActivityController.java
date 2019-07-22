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

@Controller
public class ActivityController {

    @Autowired
    private IActivityService activityService;

    @RequestMapping("activities")
    public String activities(Model model){
        List<Activity> meetingList= activityService.getActivityByTag("meeting");
        List<Activity> activityList= activityService.getActivityByTag("activity");
        List<Activity> welfareList= activityService.getActivityByTag("welfare");
        model.addAttribute("meetingList",meetingList);
        model.addAttribute("activityList",activityList);
        model.addAttribute("welfareList",welfareList);
        return "activities";
    }

    @RequestMapping("meetingInfo")
    public String fillMeeting(){
        return "meetingInfo";
    }

    @RequestMapping("activityInfo")
    public String fillActivity(){
        return "activityInfo";
    }

    @RequestMapping("welfareInfo")
    public String fillWelfare(){
        return "welfareInfo";
    }

    @RequestMapping("addActivity")
    public String addActivity(String time, String title, String content){
        time = time.replace('T',' ');
        Timestamp timestamp = new Timestamp(Str2Date.getTimeByStr(time));
        Activity activity = new Activity(timestamp,title,content,"activity");
        activityService.addActivity(activity);
        return "redirect:activities";
    }

    @RequestMapping("addMeeting")
    public String addMeeting(String time, String title, String content){
        time = time.replace('T',' ');
        Timestamp timestamp = new Timestamp(Str2Date.getTimeByStr(time));
        Activity activity = new Activity(timestamp,title,content,"meeting");
        activityService.addActivity(activity);
        return "redirect:activities";
    }

    @RequestMapping("addWelfare")
    public String addWelfare(String time, String content){
        time = time.replace('T',' ');
        Timestamp timestamp = new Timestamp(Str2Date.getTimeByStr(time));
        Activity activity = new Activity(timestamp,"员工福利",content,"welfare");
        activityService.addActivity(activity);
        return "redirect:activities";
    }

    @RequestMapping("deleteActivity")
    public String deleteActivity(String activityId){
        activityService.deleteActivityById(Integer.parseInt(activityId));
        return "redirect:activities";
    }
}
