package com.iworkcloud.controller;

import com.iworkcloud.pojo.Attendance;
import com.iworkcloud.service.IAttendanceService;
import com.iworkcloud.service.IStaffService;
import com.iworkcloud.utils.Str2Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@RequestMapping("page")
@Controller
public class AttendanceController {

    @Autowired
    private IAttendanceService attendanceService;

    @Autowired
    private IStaffService staffService;

    @RequestMapping("/attend")
    public String attend(HttpSession session){
        String staffId = (String)session.getAttribute("staff");
         String name = staffService.getStaffById(staffId).getName();
        Attendance attendance = new Attendance(name,staffId,new Timestamp(System.currentTimeMillis()));
        attendanceService.addAttendance(attendance);
        return "redirect:index";
    };

    @RequestMapping("/attendance")
    public String attendance(Model model){
        List<Attendance> attendances = attendanceService.getAttendanceToday();
        int absence = staffService.getStaffCount()-attendanceService.getAttendanceNum();
        Timestamp timestamp = new Timestamp(Str2Date.getTimeByStr(""));
        int late = 0;
        for(Attendance attendance:attendances){
            if(attendance.getTime().after(timestamp)){
                late++;
            }
        }
        int inTime = attendanceService.getAttendanceNum()-late;
        model.addAttribute("inTimeNum",inTime);
        model.addAttribute("late",late);
        model.addAttribute("absenceNum",absence);
        model.addAttribute("attendanceList",attendances);
        return "attendance";
    }

}
