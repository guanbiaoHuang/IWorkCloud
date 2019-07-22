package com.iworkcloud.controller;

import com.iworkcloud.pojo.Holiday;
import com.iworkcloud.service.IHolidayService;
import com.iworkcloud.utils.Str2Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

@Controller
public class HolidayController {
    @Autowired
    private IHolidayService holidayService;

    @RequestMapping("askForHoliday")
    public String addHoliday(String time, String content, HttpSession session) throws ParseException {
        time = time.replace('T',' ');
        long timeStamp = Str2Date.getTimeByStr(time);
        Timestamp timestampStart = new Timestamp(timeStamp);
        Timestamp timestampEnd = new Timestamp(timeStamp);
        holidayService.addHoliday(new Holiday(session.getAttribute("staff").toString(),timestampStart,timestampEnd,content,"waited"));
        return "redirect:holiday";
    }

    @RequestMapping("verifyHoliday")
    public String refuse(HttpSession session){
        holidayService.ratifyHoliday(session.getAttribute("staff").toString());
        return "redirect:ratify";
    }

    @RequestMapping("holidayInfo")
    public String holidayInfo(){
        return "holidayInfo";
    }


    @RequestMapping("excellentStaff")
    public String holidayWaited(Model model){
        List<Holiday> holidays = holidayService.getHolidayWaitedRatified();
        model.addAttribute("holidayList",holidays);
        System.out.println("--------------------------------");
        System.out.println(holidays.size());
        System.out.println("--------------------------------");
        return "excellentStaff";
    }

}
