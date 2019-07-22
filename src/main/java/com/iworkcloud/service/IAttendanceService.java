package com.iworkcloud.service;

import com.iworkcloud.pojo.Attendance;

import java.sql.Date;

public interface IAttendanceService {
    //添加出勤信息
    boolean addAttendance(Attendance attendance);
    //获得今天的出勤统计，使用时间比较获取
    boolean getAbsenceByDay(Date date);
    //获得某个员工的出勤统计（按月份）
    boolean getAttendanceByStaff(String staffId);

}
