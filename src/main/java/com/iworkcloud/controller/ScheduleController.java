package com.iworkcloud.controller;


import com.iworkcloud.pojo.Activity;
import com.iworkcloud.pojo.Holiday;
import com.iworkcloud.pojo.Schedule;
import com.iworkcloud.service.IActivityService;
import com.iworkcloud.service.IHolidayService;
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

/**
 * Schedule控制器
 */

@RequestMapping("page")
@Controller
public class ScheduleController {
    @Autowired
    private IScheduleService scheduleService;
    @Autowired
    private IActivityService activityService;
    @Autowired
    private IHolidayService holidayService;

    /**
     * 添加日程
     * @param time 日程时间
     * @param content 日程内容
     * @param session 获取session域中的员工号
     * @return
     * @throws ParseException
     */
    @RequestMapping("/addSchedule")
    public String addSchedule(String time, String content, HttpSession session) throws ParseException {
        //时间字符串处理
        time = time.replace('T', ' ');
        Timestamp timestamp = new Timestamp(Str2Date.getTimeByStr(time));
        scheduleService.addSchedule(new Schedule((String) session.getAttribute("staff"), timestamp, content));
        return "redirect:schedule";
    }

    /**
     * 日程界面
     * @param model 处理模型数据类
     * @param session 获取session域中数据
     * @return
     */
    @RequestMapping("/schedule")
    public String getSchedule(Model model, HttpSession session) {
        //获取最近一周的日程、会议，以及个人的请假条
        List<Schedule> scheduleList = scheduleService.getRecentSchedule(7, (String) session.getAttribute("staff"));
        List<Activity> meetingList = activityService.getActivitiesByTime(7, "meeting");
        List<Holiday> holidayList = holidayService.getHolidayWaitedByStaff(session.getAttribute("staff").toString());
        model.addAttribute("meetingList", meetingList);
        model.addAttribute("scheduleList", scheduleList);
        model.addAttribute("holidayList", holidayList);
        return "schedule";
    }

    /**
     * 删除日程
     * @param scheduleId 日程Id号
     * @return
     */
    @RequestMapping("/deleteSchedule")
    public String deleteSchedule(String scheduleId) {
        scheduleService.deleteSchedule(scheduleId);
        return "redirect:schedule";

    }

}
