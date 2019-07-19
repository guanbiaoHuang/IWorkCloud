package com.iworkcloud.controller;


import com.iworkcloud.pojo.Schedule;
import com.iworkcloud.service.IScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ScheduleController {
    @Autowired
    private IScheduleService scheduleService;

    @RequestMapping("addSchedule")
    public String addSchedule(){
        scheduleService.addSchedule(new Schedule());
        return "redirect:schedule";
    }

    @RequestMapping("schedule")
    public String getSchedule(){

        return "";
    }

}
