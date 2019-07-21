package com.iworkcloud.controller;


import com.iworkcloud.pojo.Schedule;
import com.iworkcloud.service.IScheduleService;
import com.iworkcloud.utils.Str2Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ScheduleController {
    @Autowired
    private IScheduleService scheduleService;

    @RequestMapping("addSchedule")
    public String addSchedule(String time, String content, HttpSession session) throws ParseException {

        time = time.replace('T',' ');
        long timeStamp = Str2Date.getTimeByStr(time);
        Timestamp timestamp = new Timestamp(timeStamp);
        scheduleService.addSchedule(new Schedule((String)session.getAttribute("staff"),timestamp,content));
        return "redirect:schedule";
    }

    @RequestMapping("schedule")
    public String getSchedule(Timestamp time,String content){

        return "schedule";
    }

    @RequestMapping("scheduleInfo")
    public String fillInfo(){
        return "scheduleInfo";
    }

}
