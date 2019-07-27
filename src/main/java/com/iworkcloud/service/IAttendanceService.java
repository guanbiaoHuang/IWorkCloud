package com.iworkcloud.service;

import com.iworkcloud.pojo.Attendance;
import com.iworkcloud.pojo.Staff;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

public interface IAttendanceService {
    //添加出勤信息
    boolean addAttendance(Attendance attendance);

    //获取今天的缺勤信息
    int getAbsenceByDay();

    //获得某个员工的出勤统计（按月份）
    List<Attendance> getAttendanceByStaff(String staffId);

    //获取今天的所有签到情况
    List<Attendance> getAttendanceToday();

    //判断某人是否签到今天
    boolean isAttend(String staffId);

    //获取今天的迟到人数
    int getLateNum();

    //获取本人的月签到次数
    int getMyAttendance(String staffId);

    //获取本人的月迟到次数
    int getMyLateNum(String staffId);


}
