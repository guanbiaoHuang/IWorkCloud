package com.iworkcloud.controller;

import com.iworkcloud.pojo.Holiday;
import com.iworkcloud.pojo.Out;
import com.iworkcloud.service.IHolidayService;
import com.iworkcloud.service.IOutService;
import com.iworkcloud.utils.Str2Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

@RequestMapping("page")
@Controller
public class HolidayController {
    @Autowired
    private IHolidayService holidayService;

    @Autowired
    private IOutService outService;

    @RequestMapping("/askForHoliday")
    public String addHoliday(String timeStart, String timeEnd, String content, HttpSession session) throws ParseException {
        System.out.println(timeEnd + "----" + timeStart);
        timeStart = timeStart.replace('T', ' ');
        timeEnd = timeEnd.replace('T', ' ');
        holidayService.addHoliday(new Holiday(session.getAttribute("staff").toString(),
                new Timestamp(Str2Date.getTimeByStr(timeStart)),
                new Timestamp(Str2Date.getTimeByStr(timeEnd)),
                content, "waited"));
        return "redirect:schedule";
    }

    @RequestMapping("/ratifyHoliday")
    public String ratify(String holidayId) {
        holidayService.ratifyHoliday(holidayId);
        return "redirect:excellentStaff";
    }

    @RequestMapping("/refuseHoliday")
    public String refuse(String holidayId) {
        holidayService.refuseHoliday(holidayId);
        return "redirect:excellentStaff";
    }

    @RequestMapping("/excellentStaff")
    public String holidayWaited(Model model) {
        List<Holiday> holidays = holidayService.getHolidayWaitedRatified();
        model.addAttribute("holidayList", holidays);
        List<Out> outs = outService.outToday();
        model.addAttribute("outList", outs);
        return "excellentStaff";
    }

}
