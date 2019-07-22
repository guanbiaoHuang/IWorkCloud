package com.iworkcloud.controller;

import com.iworkcloud.pojo.Activity;
import com.iworkcloud.service.IActivityService;
import com.iworkcloud.utils.Str2Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;

@Controller
public class ActivityController {

    @Autowired
    private IActivityService activityService;

    @RequestMapping("activities")
    public String activities(){
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
}
