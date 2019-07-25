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
import java.util.Calendar;
import java.util.GregorianCalendar;
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
        if(attendanceService.isAttend(staffId)){
            return "index";
        }else {
            String name = staffService.getStaffById(staffId).getName();
            Attendance attendance = new Attendance(name,staffId,new Timestamp(System.currentTimeMillis()));
            attendanceService.addAttendance(attendance);
            return "redirect:index";
        }

    };


    @RequestMapping("/myAttendance")
    public String getMyAttendance(HttpSession session,Model model){
        String staffId = session.getAttribute("staff").toString();
        int myAttendance = attendanceService.getMyAttendance(staffId);
        int late = attendanceService.getMyLateNum(staffId);
        Calendar calendar = new GregorianCalendar();
        int absence = calendar.get(calendar.DAY_OF_MONTH) - myAttendance;
        int inTime = myAttendance - late;
        model.addAttribute("late",late);
        model.addAttribute("absence",absence);
        model.addAttribute("inTime",inTime);
        return "myAttendance";


    }

    @RequestMapping("/attendance")
    public String attendance(Model model){
        List<Attendance> attendances = attendanceService.getAttendanceToday();

        int staffNum = staffService.getStaffCount();
        int late = attendanceService.getLateNum();
        int inTime = attendances.size()-late;
        model.addAttribute("inTimeNum",inTime);
        model.addAttribute("lateNum",late);
        model.addAttribute("absenceNum",staffNum-late-inTime);
        model.addAttribute("attendanceList",attendances);
        return "attendance";
    }

}
