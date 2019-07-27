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

/**
 * Attendance控制器
 */

@RequestMapping("page")
@Controller
public class AttendanceController {

    @Autowired
    private IAttendanceService attendanceService;

    @Autowired
    private IStaffService staffService;

    /**
     * 签到
     * @param session 获取session中的员工工号进行签到
     * @return
     */
    @RequestMapping("/attend")
    public String attend(HttpSession session) {
        //获取session中登陆的员工号
        String staffId = (String) session.getAttribute("staff");
        //判断是否今天已签到，根据情况进行签到或跳转
        if (attendanceService.isAttend(staffId)) {
            return "index";
        } else {
            String name = staffService.getStaffById(staffId).getName();
            Attendance attendance = new Attendance(name, staffId, new Timestamp(System.currentTimeMillis()));
            attendanceService.addAttendance(attendance);
            return "redirect:index";
        }

    }

    /**
     *获取本人的签到情况
     * @param session 获取session域中的员工工号
     * @param model 处理模型数据类
     * @return
     */
    @RequestMapping("/myAttendance")
    public String getMyAttendance(HttpSession session, Model model) {
        //从session域中获取员工号
        String staffId = session.getAttribute("staff").toString();
        //获取自己的签到情况
        int myAttendance = attendanceService.getMyAttendance(staffId);
        //获取迟到情况
        int late = attendanceService.getMyLateNum(staffId);
        //根据今天的日期获取本月全部的及时签到、迟到、缺席情况
        Calendar calendar = new GregorianCalendar();
        int absence = calendar.get(Calendar.DAY_OF_MONTH) - myAttendance;
        int inTime = myAttendance - late;
        model.addAttribute("late", late);
        model.addAttribute("absence", absence);
        model.addAttribute("inTime", inTime);
        return "myAttendance";


    }

    /**
     * 出勤界面，携带出勤信息
     * @param model 处理模型数据类
     * @return
     */
    @RequestMapping("/attendance")
    public String attendance(Model model) {
        //获取今天所有的签到情况
        List<Attendance> attendances = attendanceService.getAttendanceToday();
        //计算今天的签到情况，迟到、及时签到、缺席
        int staffNum = staffService.getStaffCount();
        int late = attendanceService.getLateNum();
        int inTime = attendances.size() - late;
        model.addAttribute("inTimeNum", inTime);
        model.addAttribute("lateNum", late);
        model.addAttribute("absenceNum", staffNum - late - inTime);
        model.addAttribute("attendanceList", attendances);
        return "attendance";
    }

}
