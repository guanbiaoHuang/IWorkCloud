package com.iworkcloud.controller;

import com.iworkcloud.service.IHolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

public class HolidayController {
    @Autowired
    private IHolidayService holidayService;

    @RequestMapping("askForLeave")
    public String addHoliday(){

        return "redirect:";
    }

    @RequestMapping("verifyHoliday")
    public String refuse(){

        return "redirect:ratify";
    }

}
