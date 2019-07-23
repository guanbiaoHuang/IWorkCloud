package com.iworkcloud.controller;

import com.iworkcloud.pojo.Attendance;
import com.iworkcloud.service.IAttendanceService;
import com.iworkcloud.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;

@Controller
public class AttendanceController {

    @Autowired
    private IAttendanceService attendanceService;

    @Autowired
    private IStaffService staffService;

    @RequestMapping("attend")
    public String attend(HttpSession session){
        String staffId = (String)session.getAttribute("staff");
        String name = staffService.getStaffById(staffId).getName();
        Attendance attendance = new Attendance(name,staffId,new Timestamp(System.currentTimeMillis()));
        attendanceService.addAttendance(attendance);
        return "redirect:index";
    };

    @RequestMapping("attendance")
    public String attendance(Model model){
        List<Attendance> attendances = attendanceService.getAttendanceToday();
        model.addAttribute("attendanceList",attendances);
        return "attendance";
    }

}
