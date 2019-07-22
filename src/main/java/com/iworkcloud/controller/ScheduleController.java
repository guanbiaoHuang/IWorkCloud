package com.iworkcloud.controller;


import com.iworkcloud.pojo.Schedule;
import com.iworkcloud.service.IScheduleService;
import com.iworkcloud.utils.Str2Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ScheduleController {
    @Autowired
    private IScheduleService scheduleService;

    @RequestMapping("addSchedule")
    public String addSchedule(String time, String content, HttpSession session) throws ParseException {
        time = time.replace('T',' ');
        Timestamp timestamp = new Timestamp(Str2Date.getTimeByStr(time));
        scheduleService.addSchedule(new Schedule((String)session.getAttribute("staff"),timestamp,content));
        return "redirect:schedule";
    }

    @RequestMapping("schedule")
    public String getSchedule(Model model,HttpSession session){
        List<Schedule> scheduleList = scheduleService.getRecentSchedule(7,(String)session.getAttribute("staff"));
        model.addAttribute("scheduleList",scheduleList);
        return "schedule";
    }

    @RequestMapping("scheduleInfo")
    public String fillInfo(){
        return "scheduleInfo";
    }

}
